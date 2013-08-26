/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.terminology.loader.maven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

/**
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class TerminologyProcessor {
	
	public class Metrics {
		int rowCount;
		int valueSetCount;
		int valueSetEntryCount;
		int codeValueCount;
	}

	class ConceptDomainHolder {
		
		private final String rootName;
		private final VocabularyDomain domain;
		private final String parentName;

		public ConceptDomainHolder(VocabularyDomain domain, String parentName, String rootName) {
			this.domain = domain;
			this.parentName = parentName;
			this.rootName = rootName;
		}
	}
	
	private final HSSFWorkbook workbook;
	private final LogUI log;
	private final Database database;
	private Map<String,CodeSystem> codeSystems = new HashMap<String,CodeSystem>();
	private Date createDate;
	private final String version;

	public TerminologyProcessor(LogUI log, HSSFWorkbook workbook, Database database, String version) {
		this.log = log;
		this.workbook = workbook;
		this.database = database;
		this.version = version;
		this.createDate = new Date();
	}

	public void process() throws TerminologyLoaderException {
		processConceptDomainEntries();
		processCodeValues();
	}

	private void processCodeValues() {
		this.log.log(LogLevel.INFO, "Processing each code value sheet");
		
		for (int i = 1, length = this.workbook.getNumberOfSheets(); i < length; i++) {
			HSSFSheet sheet = this.workbook.getSheetAt(i);
			String sheetName = this.workbook.getSheetName(i);
			this.log.log(LogLevel.INFO, "Processing code value sheet: " + sheetName);
			processCodeValues(sheetName, sheet);
		}
		
		this.log.log(LogLevel.INFO, "" + (this.workbook.getNumberOfSheets()-1) + " sheets processed.");
	}

	private void processCodeValues(String sheetName, HSSFSheet sheet) {
		Metrics metrics = new Metrics();
		for (int i = 1, length = sheet.getLastRowNum(); i <= length; i++) {
			String domain = getCellValue(sheet, i, 0);
			this.log.log(LogLevel.DEBUG, "Now processing code values: " + domain);
			String oid = getCellValue(sheet, i, 3);
			if (StringUtils.isBlank(oid)) {
				this.log.log(LogLevel.WARN, "Row " + i + " on sheet " + sheetName + " has no OID.  Row will be skipped.");
			} else if (isInvalid(oid)) {
				this.log.log(LogLevel.WARN, "Row " + i + " on sheet " + sheetName + " has an invalid OID (" +
						oid + ").  Row will be skipped.");
			} else if (!isDomainExisting(domain)) {
				this.log.log(LogLevel.WARN, "Row " + i + " on sheet " + sheetName + " has an invalid domain (" +
						domain + ").  Row will be skipped.");
			} else {
				metrics.rowCount++;
				String code = getCellValue(sheet, i, 2);
				CodedValue value = findOrCreateCodedValue(oid, code, metrics);
				value.setLastUpdateDatetime(this.createDate);
				processDescription(value, "en", getCellValue(sheet, i, 4));
				processDescription(value, "fr", getCellValue(sheet, i, 5));
				
				String valueSetName = getCellValue(sheet, i, 1);
				ValueSetEntry valueSetEntry = this.database.findValueSetEntry(valueSetName, new CodeImpl(code, oid), this.version);
				if (valueSetEntry == null) {
					valueSetEntry = new ValueSetEntry();
					metrics.valueSetEntryCount++;
					valueSetEntry.setCodedValue(value);
					
					ValueSet valueSet = findOrCreateValueSet(valueSetName, metrics);
					valueSetEntry.setValueSet(valueSet);
				}
				
				if (StringUtils.isNotBlank(domain)) {
					VocabularyDomain vocabularyDomain = this.database.getVocabularyDomainByName(domain);
					if (vocabularyDomain != null && !isValueSetAssociatedWithDomain(valueSetEntry.getValueSet(), vocabularyDomain)) {
						valueSetEntry.getValueSet().getVocabularyDomains().add(vocabularyDomain);
					}
				}
				this.database.saveValueSetEntry(valueSetEntry);
			}
		}
		this.log.log(LogLevel.INFO, String.format("Sheet %s processed.  %d of %d records processed.\n%d code values created\n%d value sets created\n%d value set entries created.",
				sheetName, metrics.rowCount, sheet.getLastRowNum(), metrics.codeValueCount, metrics.valueSetCount, metrics.valueSetEntryCount));
	}

	private boolean isValueSetAssociatedWithDomain(ValueSet valueSet,
			VocabularyDomain vocabularyDomain) {
		boolean result = false;
		for (VocabularyDomain domain : valueSet.getVocabularyDomains()) {
			if (StringUtils.equals(domain.getType(), vocabularyDomain.getType())) {
				result = true;
				break;
			}
		}
		return result;
	}

	private boolean isDomainExisting(String domain) {
		return this.database.getVocabularyDomainByName(domain) != null;
	}

	private ValueSet findOrCreateValueSet(String valueSetName, Metrics metrics) {
		ValueSet valueSet = this.database.findValueSet(valueSetName, this.version);
		if (valueSet == null) {
			valueSet = new ValueSet();
			metrics.valueSetCount++;
			valueSet.setName(valueSetName);
			this.database.saveValueSet(valueSet);
		}
		return valueSet;
	}

	private CodedValue findOrCreateCodedValue(String oid, String code, Metrics metrics) {
		CodedValue value = this.database.findCodedValue(new CodeImpl(code, oid));
		if (value == null) {
			CodeSystem codeSystem = this.database.getCodeSystem(oid);
			if (codeSystem == null) {
				codeSystem = codeSystems.get(oid);
			}
			if (codeSystem == null) {
				codeSystem = new CodeSystem();
				codeSystem.setOid(oid);
			}
			codeSystems.put(oid, codeSystem);
			value = new CodedValue();
			metrics.codeValueCount++;
			value.setCode(code);
			value.setCodeSystem(codeSystem);
			value.setCreateDatetime(this.createDate);
		}
		return value;
	}

	private boolean isInvalid(String oid) {
		return false;
	}

	private void processDescription(CodedValue value, String language, String description) {
		if (StringUtils.isNotBlank(description)) {
			value.getDescriptions().put(language, description);
		}
	}

	private void processConceptDomainEntries() throws TerminologyLoaderException {
		this.log.log(LogLevel.INFO, "Processing each concept domain");
		HSSFSheet sheet = this.workbook.getSheetAt(0);
		if (sheet == null) {
			throw new TerminologyLoaderException("The first worksheet in the .xls file is expected to contain the concept domain definitions.");
		} else {
			processVocabularyEntries(sheet);
		}
	}

	private void processVocabularyEntries(HSSFSheet sheet) throws TerminologyLoaderException {
		Map<String, ConceptDomainHolder> map = processBaseConceptDomains(sheet);
		createRelationshipsBetweenDomains(map);
		this.database.saveVocabularyDomains(toVocabularyDomains(map.values()));
	}

	private Collection<VocabularyDomain> toVocabularyDomains(
			Collection<ConceptDomainHolder> values) {
		Collection<VocabularyDomain> result = new ArrayList<VocabularyDomain>();
		for (ConceptDomainHolder concept : values) {
			result.add(concept.domain);
		}
		return result;
	}

	private void createRelationshipsBetweenDomains(Map<String, ConceptDomainHolder> map)
			throws TerminologyLoaderException {
		for (ConceptDomainHolder holder : map.values()) {
			if (isNew(holder.domain)) {
				holder.domain.setParent(resolveAncestor(map, holder.parentName));
				holder.domain.setRoot(resolveAncestor(map, holder.rootName));
			}
		}
	}

	private Map<String, ConceptDomainHolder> processBaseConceptDomains(HSSFSheet sheet) {
		Map<String,ConceptDomainHolder> map = new HashMap<String,ConceptDomainHolder>();
		
		for (int i = 1, length = sheet.getLastRowNum(); i <= length; i++) {
			String conceptDomainName = getCellValue(sheet, i, 0);
			if (StringUtils.isNotBlank(conceptDomainName)) {
				String businessName = getCellValue(sheet, i, 3);
				this.log.log(LogLevel.DEBUG, "Now processing Concept Domain: " + conceptDomainName + " : " + StringUtils.trimToEmpty(businessName));
				String parentDomainName = getCellValue(sheet, i, 1);
				String rootDomainName = getCellValue(sheet, i, 2);
				String englishDescription = getCellValue(sheet, i, 4);
//				String frenchDescription = getCellValue(sheet, i, 5);
				
				VocabularyDomain conceptDomain = this.database.getVocabularyDomainByName(conceptDomainName);
				if (conceptDomain == null) {
					conceptDomain = new VocabularyDomain();
					conceptDomain.setType(conceptDomainName);
				}
				conceptDomain.setDescription(englishDescription);
				conceptDomain.setBusinessName(businessName);
				map.put(conceptDomainName, new ConceptDomainHolder(conceptDomain, parentDomainName, rootDomainName));
			}
		}
		return map;
	}

	private VocabularyDomain resolveAncestor(Map<String, ConceptDomainHolder> map, String name)
			throws TerminologyLoaderException {
		VocabularyDomain result = null;
		if (StringUtils.isNotBlank(name)) {
			VocabularyDomain parent = this.database.getVocabularyDomainByName(name);
			if (parent == null) {
				ConceptDomainHolder parentHolder = map.get(name);
				parent = parentHolder == null ? null : parentHolder.domain;
			}
			if (parent == null) {
				throw new TerminologyLoaderException("The type " + name + " is not defined.");
			} else {
				result = parent;
			}
		}
		return result;
	}

	private boolean isNew(VocabularyDomain domain) {
		return domain.getId() == null;
	}

	private String getCellValue(HSSFSheet sheet, int rowNumber, int columnNumber) {
		HSSFRow row = sheet.getRow(rowNumber);
		HSSFCell cell = row == null ? null : row.getCell(columnNumber);
		return cell == null ? null : cell.getStringCellValue();
	}
}
