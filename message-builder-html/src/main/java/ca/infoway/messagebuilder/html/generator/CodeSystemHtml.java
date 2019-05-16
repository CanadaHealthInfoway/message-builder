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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.html.generator;

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CONTAINER_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CONTENT_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_LABEL_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MAIN_CONTENT_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Hr;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.Concept;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;

public class CodeSystemHtml extends BaseHtmlGenerator {
	private CodeSystem codeSystem;
	private MessageSet messageSet;
	
	public CodeSystemHtml(CodeSystem codeSystem, MessageSet messageSet) {
		this.setCodeSystem(codeSystem);
		this.messageSet = messageSet;
	}
	
	public CodeSystemHtml(CodeSystem codeSystem, MessageSet messageSet,
			String interactionsPath, String messagePartsPath, String datatypesPath,
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath, 
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.setCodeSystem(codeSystem);
	}

	@Override
	public String write() {
		return writeCodeSystem().write();
	}
	
	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected Document writeCodeSystem() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		addHeadParamaters(getCodeSystem().getName(), "Code System", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addVocabDetailsMetaHeader(getCodeSystem().getName(), DomainSource.CODE_SYSTEM, containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		mainContentDiv.appendChild(createHeader("Code System: " + getCodeSystem().getName(), "titleHeader-"+getCodeSystem().getName(), "titleHeader"));
		mainContentDiv.appendChild(createCodeSystemSummaryDiv());
		mainContentDiv.appendChild(createCodeSummaryDiv());
		mainContentDiv.appendChild(createCodeDetailsDiv());
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	private Div createCodeDetailsDiv() {
		Div result = new Div();
		result.setCSSClass("codeSummaryDetailsDiv");
		result.appendChild(new Hr());
		result.appendChild(createHeader("Code Summary Details", "codeSummaryDetailsHeader", "titleHeader"));

		for (Concept concept : getCodeSystem().getConcepts()) {
			// Can probably remove this check once the mif parsing gets fixed 
			if (concept.getCode() != null) {
				Div codeDiv = new Div();
				codeDiv.setCSSClass("codeDiv");
				codeDiv.setId(getCodeId(concept.getCode()));
	
				codeDiv.appendChild(createHeader(concept.getCode(), "", "titleHeader"));
				codeDiv.appendChild(createConceptDetailsTable(concept, getCodeSystem(), getMessageSet()));
				result.appendChild(codeDiv);
			}
		}
		
		return result;
	}

	private String getCodeId(String code) {
		return "codeDiv-"+code;
	}
	
	private Table createConceptDetailsTable(Concept concept, CodeSystem codeSystem, MessageSet messageSet) {
		Table result = new Table();
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
		tBody.appendChild(createDataRow("Code:", new Text(concept.getCode()), ""));
		tBody.appendChild(createDataRow("Name:", new Text(concept.getDisplayName()), ""));
		addAnnotationDetails(concept.getDocumentation(), "Description:", tBody);
		tBody.appendChild(createDataRow("Selectable", new Text(concept.isSelectable()?"Y":"N"), ""));
		tBody.appendChild(createDataRow("Code System OID:", new Text(codeSystem.getOid()), ""));
		tBody.appendChild(createDataRow("Example CS:", createExample(concept, codeSystem), ""));
		
		result.appendChild(tHead);
		result.appendChild(tBody);
		return result;
	}

	private Text createExample(Concept code, CodeSystem codeSystem) {
		String example = "&lt;code";
		example+=" code=\"" + code.getCode();
		example+="\" /&gt;";
		return new Text(example);
	}

	
	private Div createCodeSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("codeSummaryDiv");
		result.setId("codeSummaryDiv-" + getCodeSystem().getName());
		
		result.appendChild(new Hr());
		result.appendChild(createHeader("Code Summary", "codeSummaryHeader", "titleHeader"));

		
		Table detailsTable = new Table();
		
		Thead tableHeader = new Thead();
		Tbody tableBody = new Tbody();
		
		Tr titleRow = new Tr();
		titleRow.setCSSClass("codeTitleRow");
		titleRow.appendChild(createDataColumn(new Text("Code"), DETAILS_TABLE_LABEL_COL_CLASS));
		titleRow.appendChild(createDataColumn(new Text("Display Name"), DETAILS_TABLE_LABEL_COL_CLASS));
		titleRow.appendChild(createDataColumn(new Text("Code System OID"), DETAILS_TABLE_LABEL_COL_CLASS));
		tableBody.appendChild(titleRow);
		
		if (getCodeSystem().getConcepts().size() > 0) {
			for (Concept concept : getCodeSystem().getConcepts()) {
				// Can probably remove this check once the mif parsing gets fixed 
				if (concept.getCode() != null) {
					tableBody.appendChild(createCodeRow(concept, getCodeSystem()));
				}
			}
		} else {
			Tr blankRow = new Tr();
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			tableBody.appendChild(blankRow);
		}
		
		detailsTable.appendChild(tableHeader);
		detailsTable.appendChild(tableBody);
		
		result.appendChild(detailsTable);
		return result;
	}
	
	private Tr createCodeRow(Concept concept, CodeSystem codeSystem) {
		Tr result = new Tr();
		result.setCSSClass("codeDataRow");
		result.appendChild(createDataColumn(createLink("#" + getCodeId(concept.getCode()), new Text(concept.getCode()), "", ""), ""));
		result.appendChild(createDataColumn(new Text(concept.getDisplayName()), ""));
		result.appendChild(createDataColumn(new Text(codeSystem.getOid()), ""));
		return result;
	}

	private Div createCodeSystemSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("summaryDiv");
		result.setId("summaryDiv-" + getCodeSystem().getName());
		
		Table detailsTable = new Table();
		
		Thead tableHeader = new Thead();
		
		Tbody tableBody = new Tbody();
		tableBody.appendChild(createDataRow("Code System Technical Name:", new Text(getCodeSystem().getName()), ""));
		if (StringUtils.isNotBlank(getCodeSystem().getBusinessName())) {
			tableBody.appendChild(createDataRow("Code System Business Name:", new Text(getCodeSystem().getBusinessName()), ""));
		}
		tableBody.appendChild(createDataRow("Code System OID:", new Text(getCodeSystem().getOid()), ""));
		tableBody.appendChild(createDataRow("Code System Release Date", new Text(new SimpleDateFormat("yyyy-MM-dd").format(getCodeSystem().getReleaseDate())), ""));
		
		addAnnotationDetails(getCodeSystem().getDocumentation(), "Definition:", tableBody);
		
		tableBody.appendChild(createDataRow("Maintenance Organization:", createMaintenanceOrganizationElement(getCodeSystem()), ""));
		if (!getCodeSystem().isComplete() 
				&& getCodeSystem().getMaintenanceOrganization() != null
				&& getCodeSystem().getMaintenanceOrganization().getRepositoryUrl() != null) {
			String sourceUrl = getCodeSystem().getMaintenanceOrganization().getRepositoryUrl();
			A sourceLink = createLink(sourceUrl, new Text(sourceUrl), "", "codeSystemSourceLink");
			sourceLink.setTarget("_blank");
			tableBody.appendChild(createDataRow("Source Definition:", sourceLink, ""));
		}
//		tableBody.appendChild(createDataRow("Version:", new Text(getCodeSystem().getVersionId()), ""));
		tableBody.appendChild(createDataRow("Codes listed below are:", createCodeCompleteElement(getCodeSystem()), ""));
		
//		tableBody.appendChild(createDataRow("Model Class Attribute Referers:", 
//				createModelClassAttributeList(getCodeSystem().getName(), DomainSource.CODE_SYSTEM, getMessageSet()), ""));
		tableBody.appendChild(createDataRow("In use by value sets:", createInUseByValueSetsList(getCodeSystem(), getMessageSet()), ""));
		
		
		detailsTable.appendChild(tableHeader);
		detailsTable.appendChild(tableBody);
		
		result.appendChild(detailsTable);
		return result;
	}

	private Node createCodeCompleteElement(CodeSystem codeSystem) {
		if (codeSystem.isComplete()) {
			return new Text("Complete");
		} else {
			return new Text("Incomplete");
		}
	}

	private Node createMaintenanceOrganizationElement(CodeSystem codeSystem) {
		if (codeSystem.getMaintenanceOrganization() != null) {
			return new Text(codeSystem.getMaintenanceOrganization().getName());
		}
		return new Text("-");
	}

	private Node createInUseByValueSetsList(CodeSystem codeSystem, MessageSet messageSet) {
		Ul result = new Ul();
		int valueSetCount = 0;
		for (ValueSet valueSet : messageSet.getVocabulary().getValueSets()) {
			if (valueSet.getSourceCodeSystems().contains(codeSystem.getName())) {
				Li valueSetListItem = new Li();
				valueSetListItem.appendChild(createLink(getValueSetUrl(valueSet.getName()), new Text(valueSet.getName()), "", ""));
				result.appendChild(valueSetListItem);
				valueSetCount++;
			}
		}
		
		if (valueSetCount == 0) {
			return new Text("None");
		}
		
		return result;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public CodeSystem getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(CodeSystem codeSystem) {
		this.codeSystem = codeSystem;
	}
}
