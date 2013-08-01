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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Code;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.Concept;
import ca.infoway.messagebuilder.xml.ContextBinding;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Hr;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

public class ValueSetHtml extends BaseHtmlGenerator {
	
	private static class ValueSetTreeNode implements Comparable<ValueSetTreeNode> {
		private final String name;
		private final Code code;
		private final Set<ValueSetTreeNode> children = new TreeSet<ValueSetTreeNode>();
		public ValueSetTreeNode(Code code) {
			this.name = code.getCode();
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public Code getCode() {
			return code;
		}
		public Set<ValueSetTreeNode> getChildren() {
			return children;
		}
		public void addCode(ValueSetTreeNode child) {
			this.children.add(child);
		}
		@Override
		public int compareTo(ValueSetTreeNode o) {
			return this.getName().compareTo(o.getName());
		}
	}
	
	private MessageSet messageSet;
	private ValueSet valueSet;
	
	public ValueSetHtml(ValueSet valueSet, MessageSet messageSet) {
		this.messageSet = messageSet;
		this.valueSet = valueSet;
	}
	
	public ValueSetHtml(ValueSet valueSet, MessageSet messageSet,
			String interactionsPath, String messagePartsPath, String datatypesPath,
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath,
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.valueSet = valueSet;
	}
	
	@Override
	public String write() {
		return writeValueSet().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected Document writeValueSet() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		addHeadParamaters(valueSet.getName(), "Value Set", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addVocabDetailsMetaHeader(getValueSet().getName(), DomainSource.VALUE_SET, containerDiv);
		
		addBreadcrumbHeader(messageSet, containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		mainContentDiv.appendChild(createHeader("Value Set: " + getValueSet().getName(), "titleHeader-"+getValueSet().getName(), "titleHeader"));
		mainContentDiv.appendChild(createValueSetSummaryDiv());
		Div valueSetExpansionSummaryDiv = createValueSetExpansionSummaryDiv();
		if (valueSetExpansionSummaryDiv != null) {
			mainContentDiv.appendChild(valueSetExpansionSummaryDiv);
			mainContentDiv.appendChild(createValueSetExpansionDetailsDiv());
		}	
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}
		
	private Div createValueSetExpansionDetailsDiv() {
		Div result = new Div();
		result.setCSSClass("valueSetExpansionDetailsDiv");
		result.appendChild(new Hr());
		if (getValueSet().isComplete()) {
			result.appendChild(createHeader("Value Set Expansion Details", "valueSetExpansionDetailsHeader", "titleHeader"));
		} else {
			result.appendChild(createHeader("Example Codes Details", "valueSetExpansionDetailsHeader", "titleHeader"));
		}
		
		if (getValueSet().getCodes() != null) {
			for (Code code : getValueSet().getCodes()) {
				Div codeDiv = new Div();
				codeDiv.setCSSClass("codeDiv");
				codeDiv.setId(getCodeId(code.getCode()));
				CodeSystem codeSystem = getCodeSystemByName(code.getCodeSystem(), getMessageSet().getVocabulary());
				if (codeSystem!=null) {
					codeDiv.appendChild(createHeader(code.getCode(), "", "titleHeader"));
					codeDiv.appendChild(createConceptDetailsTable(code, codeSystem, getMessageSet()));
				} else {
					codeDiv.appendChild(createHeader(code.getCode(), "", "titleHeader"));
					codeDiv.appendChild(new Text("No Details Available"));
				}
				result.appendChild(codeDiv);
			}
		}
		
		return result;
	}

	private String getCodeId(String code) {
		return "codeDiv-"+code;
	}

	private Table createConceptDetailsTable(Code code, CodeSystem codeSystem, MessageSet messageSet) {
		Table result = new Table();
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
		if (codeSystem != null) {
			Concept concept = getConcept(codeSystem, code.getCode());
			tBody.appendChild(createDataRow("Code:", new Text(code.getCode()), ""));
			if (concept != null) {
				tBody.appendChild(createDataRow("Name:", new Text(concept.getDisplayName()==null?"-":concept.getDisplayName()), ""));
				addAnnotationDetails(concept.getDocumentation(), "Description:", tBody);
			}
			tBody.appendChild(createDataRow("Code System OID:", new Text(codeSystem.getOid()), ""));
			tBody.appendChild(createDataRow("Example CV:", createExample(code, codeSystem), ""));
		} 
		
		result.appendChild(tHead);
		result.appendChild(tBody);
		return result;
	}

	private Text createExample(Code code, CodeSystem codeSystem) {
		String example = "&lt;code";
		example+=" code=\"" + code.getCode();
		example+="\" codeSystem=\"" + codeSystem.getOid();
		example+="\" /&gt;";
		return new Text(example);
	}

	private Div createValueSetExpansionSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("valueSetExpansionSummaryDiv");
		result.setId("valueSetExpansionSummaryDiv-" + getValueSet().getName());
		
		result.appendChild(new Hr());
		if (getValueSet().isComplete()) {
			result.appendChild(createHeader("Value Set Expansion Summary", "valueSetExpansionHeader", "titleHeader"));
		} else {
			result.appendChild(createHeader("Example Codes Summary", "valueSetExpansionHeader", "titleHeader"));
		}
		
		Table summaryTable = new Table();
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
		Tr titleRow = new Tr();
		titleRow.setCSSClass("codeTitleRow");
		titleRow.appendChild(createDataColumn(new Text("Code"), DETAILS_TABLE_LABEL_COL_CLASS));
		titleRow.appendChild(createDataColumn(new Text("Display Name"), DETAILS_TABLE_LABEL_COL_CLASS));
		titleRow.appendChild(createDataColumn(new Text("Code System OID"), DETAILS_TABLE_LABEL_COL_CLASS));
		titleRow.appendChild(createDataColumn(new Text("Code System Name"), DETAILS_TABLE_LABEL_COL_CLASS));
		tBody.appendChild(titleRow);
		
		if (getValueSet().getCodes() != null && !getValueSet().getCodes().isEmpty()) {
			TreeSet<ValueSetTreeNode> codeStructure = buildCodeStructure(getValueSet().getCodes());
			appendCodes(tBody, codeStructure, 0);
		} else {
			Tr blankRow = new Tr();
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			blankRow.appendChild(createDataColumn(new Text("-"), ""));
			tBody.appendChild(blankRow);
			return null;
		}
		
		summaryTable.appendChild(tHead);
		summaryTable.appendChild(tBody);
		
		result.appendChild(summaryTable);
		return result;
	}

	public void appendCodes(Tbody tableBody, Set<ValueSetTreeNode> codes, int indentationLevel) {
		for (ValueSetTreeNode node : codes) {			
			tableBody.appendChild(createCodeRow(node.getCode(), getMessageSet(), indentationLevel));
			appendCodes(tableBody, node.getChildren(), indentationLevel + 1);
		}
	}

	private TreeSet<ValueSetTreeNode> buildCodeStructure(List<Code> codes) {
		HashMap<String,ValueSetTreeNode> codeMap = new HashMap<String, ValueSetTreeNode>();
		TreeSet<ValueSetTreeNode> structure = new TreeSet<ValueSetTreeNode>();
		for (Code code : getValueSet().getCodes()) {
			codeMap.put(code.getCode(), new ValueSetTreeNode(code));
		}
		for (Code code : getValueSet().getCodes()) {
			Concept concept = findConcept(code);
			if (concept == null || concept.getParentConcepts() == null || concept.getParentConcepts().isEmpty()) {
				structure.add(codeMap.get(code.getCode()));
			} else {
				boolean inserted = false;
				for (String parent : concept.getParentConcepts()) {
					if (codeMap.get(parent) != null) {
						codeMap.get(parent).addCode(codeMap.get(code.getCode()));
						inserted = true;
					}
				}
				if (!inserted) {	// none of the parents are included in the value set, so treat it as a root
					structure.add(codeMap.get(code.getCode()));
				}
			}
		}
		return structure;
	}
	
	private Concept findConcept(Code code) {
		CodeSystem codeSystem = getCodeSystemByName(code.getCodeSystem(), messageSet.getVocabulary());
		if (codeSystem != null) {
			return getConcept(codeSystem, code.getCode());
		}
		return null;
	}

	private Tr createCodeRow(Code code, MessageSet messageSet, int indentationLevel) {
		Tr result = new Tr();
		result.setCSSClass("codeDataRow");
		String indentClass = "indent" + String.valueOf(indentationLevel);
		CodeSystem codeSystem = getCodeSystemByName(code.getCodeSystem(), messageSet.getVocabulary());
		if (codeSystem != null) {
			Concept concept = getConcept(codeSystem, code.getCode());
			if (concept != null) {
				result.appendChild(createDataColumn(
						createLink("#"+ getCodeId(concept.getCode()), new Text(concept.getCode()), "", ""), indentClass));
				if (StringUtils.isNotBlank(concept.getDisplayName())) {
					result.appendChild(createDataColumn(new Text(concept.getDisplayName()), ""));
				} else {
					result.appendChild(createDataColumn(new Text("-"), ""));
				}
				result.appendChild(createDataColumn(new Text(codeSystem.getOid()), ""));
				result.appendChild(createDataColumn(new Text(codeSystem.getName()), ""));
				return result;
			} else {
				result.appendChild(createDataColumn(
						createLink("#"+ getCodeId(code.getCode()), new Text(code.getCode()), "", ""), indentClass));
				String printName = code.getPrintName() == null ? "-" : code.getPrintName();
				result.appendChild(createDataColumn(new Text(printName), ""));
				result.appendChild(createDataColumn(new Text(codeSystem.getOid()), ""));
				result.appendChild(createDataColumn(new Text(codeSystem.getName()), ""));
				return result;
			}
		}
		
		result.appendChild(createDataColumn(new Text(code.getCode()), indentClass));
		result.appendChild(createDataColumn(new Text("-"), ""));
		result.appendChild(createDataColumn(new Text(code.getCodeSystem()), ""));
		result.appendChild(createDataColumn(new Text("-"), ""));
		return result;
	}

	private Div createValueSetSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("summaryDiv");
		result.setId("summaryDiv-" + getValueSet().getName());
		
		Table detailsTable = new Table();
		
		Thead tableHeader = new Thead();
		
		Tbody tableBody = new Tbody();
		//tableBody.appendChild(createDataRow("Value Set Name:", new Text(getValueSet().getName()), ""));
		if (getValueSet().getId() != null) {
			tableBody.appendChild(createDataRow("Value Set OID:", new Text(getValueSet().getId()), ""));
		}
		if (getValueSet().getDate() != null) {
			tableBody.appendChild(createDataRow("Value Set Date:", new Text(new SimpleDateFormat("yyyy-MM-dd").format(getValueSet().getDate())), ""));
		}
		addAnnotationDetails(getValueSet().getDocumentation(), "Definition:", tableBody);
		
		if (getValueSet().getOwningSCWG() != null) {
			tableBody.appendChild(createDataRow("Owning SCWG:", new Text(getValueSet().getOwningSCWG()), ""));
		}
		
		Text codingStrengthElement = createCodingStrengthElement(getValueSet(), getMessageSet());
		if (codingStrengthElement != null) {
			tableBody.appendChild(createDataRow("Coding Strength:", codingStrengthElement, ""));
		}
		
		tableBody.appendChild(createDataRow("Used In Model Class Attributes:", 
				createModelClassAttributeList(getValueSet().getName(), DomainSource.VALUE_SET, getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Bound Concept Domains:", 
				createContextBindingList(getValueSet(), getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Draws From Code Systems:", createDrawsFromCodeSystemList(getValueSet(), getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Filter:", createFilterElement(getValueSet(), getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Codes listed below are:", createCodeStatusElement(getValueSet(), getMessageSet()), ""));

		detailsTable.appendChild(tableHeader);
		detailsTable.appendChild(tableBody);
		
		result.appendChild(detailsTable);
		return result;
	}
	
	private Node createDrawsFromCodeSystemList(ValueSet valueSet,
			MessageSet messageSet) {
		Ul result = new Ul();
		if (valueSet.getSourceCodeSystems().size() > 0) {
			for (String codeSystemName : valueSet.getSourceCodeSystems()) {
				Li codeSystemListItem = new Li();
				if (getCodeSystemByName(codeSystemName, messageSet.getVocabulary()) != null) {
					codeSystemListItem.appendChild(createLink(getCodeSystemUrl(codeSystemName), new Text(codeSystemName), "", ""));
				} else {
					codeSystemListItem.appendText(codeSystemName);
				}
				result.appendChild(codeSystemListItem);
			}
		} else {
			return new Text("None");
		}
		
		return result;
	}

	private Node createContextBindingList(ValueSet valueSet, MessageSet messageSet) {
		Ul result = new Ul();
		if (valueSet.getContextBindings().size() > 0) {
			for (ContextBinding contextBinding : valueSet.getContextBindings()) {
				Li contextBindingListItem = new Li();
				if (getConceptDomainByName(contextBinding.getConceptDomain(), messageSet.getVocabulary()) != null) {
					contextBindingListItem.appendChild(createLink(getConceptDomainUrl(contextBinding.getConceptDomain()), new Text(contextBinding.getConceptDomain()), "", ""));
				} else {
					contextBindingListItem.appendText(contextBinding.getConceptDomain());
				}
				result.appendChild(contextBindingListItem);
			}
		} else {
			return new Text("None");
		}
		return result;
	}

	private Node createCodeStatusElement(ValueSet valueSet,
			MessageSet messageSet) {
		if (valueSet.isComplete()) {
			return new Text("Complete");
		} else {
			return new Text("Incomplete");
		}
	}

	private Node createFilterElement(ValueSet valueSet, MessageSet messageSet) {
		FilterElementHtml filterHtml = new FilterElementHtml(valueSet, messageSet);

		return filterHtml.getFilterElement();
	}

	private Text createCodingStrengthElement(ValueSet valueSet, MessageSet messageSet) {
		Text result = new Text("Unknown");
		
		List<ContextBinding> contextBindings = valueSet.getContextBindings();
		if (contextBindings.size() > 0) {
			//Get coding strength from context binding
			for (ContextBinding contextBinding : contextBindings) {
				if (CodingStrength.CWE.equals(contextBinding.getCodingStrength())) {
					return new Text(CodingStrength.CWE.name());
				} else {
					result = new Text(contextBinding.getCodingStrength().name());
				}
			}
		} else {
			return null;
			//GN: Request that we do not show coding strength if value set is bound to a model class attribute
			//Get coding strength from message part that references the valueset
//			for (MessagePart messagePart : messageSet.getAllMessageParts()) {
//				for (Relationship relationship : messagePart.getRelationships()) {
//					if (relationship.isAttribute() && relationship.isCodedType() 
//							&& DomainSource.VALUE_SET.equals(relationship.getDomainSource())
//							&& valueSet.getName().equals(relationship.getDomainType())) {
//						if (CodingStrength.CWE.equals(relationship.getCodingStrength())) {
//							return new Text(CodingStrength.CWE.name());
//						} else {
//							result = new Text(relationship.getCodingStrength().name());
//						}
//					}
//				}
//			}
		}
		
		return result;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public ValueSet getValueSet() {
		return valueSet;
	}

	public void setValueSet(ValueSet valueSet) {
		this.valueSet = valueSet;
	}
}
