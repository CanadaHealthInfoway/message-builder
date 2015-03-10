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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2015-01-13 13:10:01 -0500 (Tue, 13 Jan 2015) $
 * Revision:      $LastChangedRevision: 9127 $
 */

package ca.infoway.messagebuilder.resolver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinitionSystem;

/**
 * Knows how to provide Codes sourced from the Trifolia voc.xml file.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CdaCodeResolver implements CodeResolver {
	
	private static class ValueSet {
		private final Map<String, List<CodedValue>> codes = new HashMap<String, List<CodedValue>>();
		private final Map<String, List<CodedValue>> codesByLowerCase = new HashMap<String, List<CodedValue>>();
		
		public CodedValue getCode(String code, boolean ignoreCase) {
			List<CodedValue> codes = ignoreCase ? this.codesByLowerCase.get(StringUtils.lowerCase(code)) : this.codes.get(code);
			if (codes != null && codes.size() >= 1) {
				return codes.get(0);
			}
			return null;
		}
		
		public CodedValue getCode(String code, String codeSystemOid, boolean ignoreCase) {
			List<CodedValue> codes = ignoreCase ? this.codesByLowerCase.get(StringUtils.lowerCase(code)) : this.codes.get(code);
			if (codes != null) {
				for (CodedValue codedValue : codes) {
					// not applying ignoreCase to codeSystem check
					if (StringUtils.equals(codeSystemOid, codedValue.getCodeSystemOid())) {
						return codedValue;
					}
				}
			}
			return null;
		}
		
		public List<CodedValue> getAllCodes() {
			List<CodedValue> allValues = new ArrayList<CodedValue>();
			for (List<CodedValue> list : this.codes.values()) {
				allValues.addAll(list);
			}
			return allValues;
		}
		
		public void addCode(CodedValue code) {
			if (code != null && code.getValue() != null) {
				List<CodedValue> list = this.codes.get(code.getValue());
				if (list == null) {
					list = new ArrayList<CodedValue>();
					this.codes.put(code.getValue(), list);
					this.codesByLowerCase.put(StringUtils.lowerCase(code.getValue()), list);
				}
				list.add(code);
			}
		}
	}
	
	private static class CodedValue {
		private final String value;
		private final String codeSystemOid;
		private final String codeSystemName;
		private final String displayName;
		
		public CodedValue(String value, String codeSystemOid, String codeSystemName, String displayName) {
			this.value = value;
			this.codeSystemOid = codeSystemOid;
			this.codeSystemName = codeSystemName;
			this.displayName = displayName;
		}
		public String getValue() {
			return value;
		}
		public String getCodeSystemOid() {
			return codeSystemOid;
		}
		public String getCodeSystemName() {
			return codeSystemName;
		}
		public String getDisplayName() {
			return displayName;
		}
	}
	
	private final Log log = LogFactory.getLog(CdaCodeResolver.class);
	
	private Serializer serializer = new Persister(new AnnotationStrategy());

	private final TypedCodeFactory codeFactory;

	private final Map<String, ValueSet> valueSetsByTypeName = new HashMap<String, ValueSet>();

	/**
	 * Create and initialize the code resolver.
	 * 
	 * @param codeFactory the code factory.
	 * @param vocabularyDefinitionsFile an input stream containing a list of known value sets and the codes that each contains.
	 * @param valueSetNameMappingFile an input stream containing the mapping from value set OIDs to interface names.
	 */
	public CdaCodeResolver(TypedCodeFactory codeFactory, InputStream vocabularyDefinitionsFile, InputStream valueSetNameMappingFile) {
		this.codeFactory = codeFactory;

		try {
			ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, vocabularyDefinitionsFile);
			ValueSetDefinition valueSetMapping = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, valueSetNameMappingFile);
			
			Map<String, String> valueSetMap = new HashMap<String, String>();
			for (ValueSetDefinitionSystem mapping : valueSetMapping.getSystems()) {
				if (StringUtils.isNotBlank(mapping.getValueSetOid())) {
					valueSetMap.put(mapping.getValueSetOid(), mapping.getValueSetName());
				}
			}
			
			for (ValueSetDefinitionSystem system : valueSetDefinition.getSystems()) {
				if (StringUtils.isNotBlank(system.getValueSetOid())) {
					ValueSet valueSet = new ValueSet();
					String valueSetName = valueSetMap.get(system.getValueSetOid());
					if (valueSetName == null) {
						valueSetName = system.getValueSetName();
					}
					valueSetsByTypeName.put(valueSetName, valueSet);
					
					for (ca.infoway.messagebuilder.xml.cda.vocabulary.Code code : system.getCodes()) {
						valueSet.addCode(new CodedValue(
								code.getValue(), 
								code.getCodeSystem(), 
								code.getCodeSystemName(), 
								code.getDisplayName()));
					}
				}
			}
		} catch (Exception e) {
			log.error("Unable to initialize resolver", e);
		}

	}
	
	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> Collection<T> lookup(Class<T> type) {
		Collection<T> result = new ArrayList<T>();
		ValueSet valueSet = valueSetsByTypeName.get(type.getSimpleName());
		if (valueSet != null) {
			for (CodedValue value : valueSet.getAllCodes()) {
				result.add(createCode(type, value));
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> type, String code) {
		return lookup(type, code, false);
	}

	public <T extends Code> T lookup(Class<T> type, String code, boolean ignoreCase) {
		ValueSet valueSet = valueSetsByTypeName.get(type.getSimpleName());
		if (valueSet != null) {
			CodedValue codedValue = valueSet.getCode(code, ignoreCase);
			if (codedValue != null) {
				return createCode(type, codedValue);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid) {
		return lookup(type, code, codeSystemOid, false);
	}

	public <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid, boolean ignoreCase) {
		ValueSet valueSet = valueSetsByTypeName.get(type.getSimpleName());
		if (valueSet != null) {
			CodedValue codedValue = valueSet.getCode(code, codeSystemOid, ignoreCase);
			if (codedValue != null) {
				return createCode(type, codedValue);
			}
		}
		return null;
	}

	private <T extends Code> T createCode(Class<T> type, CodedValue value) {
		Set<Class<?>> implementedTypes = new HashSet<Class<?>>();
		implementedTypes.add(type);

		HashMap<String, String> displayTextMap = new HashMap<String, String>();
		displayTextMap.put("en", value.getDisplayName());
		
		return type.cast(this.codeFactory.create(type, implementedTypes, value.getValue(), 
				value.getCodeSystemOid(), value.getCodeSystemName(), displayTextMap, 
				new Integer(1), Boolean.TRUE, Boolean.TRUE));
	}

}
