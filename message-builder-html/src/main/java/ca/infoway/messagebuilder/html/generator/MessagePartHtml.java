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
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_VALUE_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MAIN_CONTENT_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.TOC_LIST_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.TOC_LIST_ITEM_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ol;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

public class MessagePartHtml extends BaseHtmlGenerator {

	private MessagePart messagePart;
	private MessageSet messageSet;
	private DatatypeSet datatypeSet;
	private Boolean excludeStructuralAttributes;
	
	public MessagePartHtml(MessagePart messagePart, MessageSet messageSet, DatatypeSet datatypeSet, Boolean excludeStructuralAttributes) {
		this.messagePart = messagePart;
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		if (excludeStructuralAttributes == null) {
			this.excludeStructuralAttributes = false;
		} else { 
			this.excludeStructuralAttributes = excludeStructuralAttributes;
		}
	}
	
	public MessagePartHtml(MessagePart messagePart, MessageSet messageSet, DatatypeSet datatypeSet, Boolean excludeStructuralAttributes,
			String interactionsPath, String packagesPath, String datatypesPath,
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, packagesPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath, 
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		this.messagePart = messagePart;
		if (excludeStructuralAttributes == null) {
			this.excludeStructuralAttributes = false;
		} else {
			this.excludeStructuralAttributes = excludeStructuralAttributes;
		}
	}
	
	@Override
	public String write() {
		return writeMessagePart().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected Document writeMessagePart() {
		Document doc = new Document(DocumentType.HTMLStrict);
	
		addHeadParamaters(getMessagePartName(getMessagePart().getName()), "MessagePart", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addDetailsMetaHeader(getMessagePart().getName(), containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		
		if (StringUtils.isNotBlank(getBusinessName(messagePart.getDocumentation()))) {
			mainContentDiv.appendChild(createHeader(
					getBusinessName(getMessagePart().getDocumentation()), 
					"titleHeader-"+getMessagePartName(getMessagePart().getName()), "titleHeader"));
			mainContentDiv.appendChild(createSubHeader("(" + getMessagePart().getName() + ")", "", "subTitleHeader"));

		} else {
			mainContentDiv.appendChild(createHeader(
					getHl7TypeName(messagePart.getName()), 
					"titleHeader-"+getMessagePartName(messagePart.getName()), "titleHeader"));
		}
		mainContentDiv.appendChild(createMessagePartSummaryDiv());
				
		addRelationshipsSection(mainContentDiv);
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	protected void addRelationshipsSection(Div mainContentDiv) {
		List<Relationship> relationships = getMessagePart().getRelationships();
		List<Relationship> sortedRelationships = new ArrayList<Relationship>();
		sortedRelationships.addAll(relationships);
		sortRelationships(sortedRelationships);
		
		for (Relationship relationship : sortedRelationships) {
			if (this.getExcludeStructuralAttributes() && relationship.isStructural()) {
				continue;
			}
			Div relationshipDiv = new Div();
			if (relationship.isAttribute() && relationship.isFixed()) {
				relationshipDiv.setCSSClass("relationshipDiv attributeDiv fixedAttribute");
			} else if (relationship.isAttribute()){
				relationshipDiv.setCSSClass("relationshipDiv attributeDiv");
			} else {
				relationshipDiv.setCSSClass("relationshipDiv");
			}
			relationshipDiv.setId(getRelationshipId(getMessagePart(), relationship));
			
			if (relationship.isAttribute()) {
				relationshipDiv.appendChild(createHeader(getBusinessName(relationship.getDocumentation()), "", "titleHeader"));
				relationshipDiv.appendChild(createSubHeader("(" + relationship.getName() + ")", "", "subTitleHeader"));
			} else {
				relationshipDiv.appendChild(createHeader(relationship.getName(), "", "titleHeader"));
			}	
			
			relationshipDiv.appendChild(createRelationshipTable(relationship));
			mainContentDiv.appendChild(relationshipDiv);
		}
	}

	protected Li createMessagePartTOCList() {	
		Li detailsListItem = new Li();
		detailsListItem.setCSSClass("msgPartToc " + TOC_LIST_ITEM_CLASS);
		detailsListItem.appendChild(createLink("#" + getMessagePartName(getMessagePart().getName()) +"DetailsDiv", new Text(getMessagePart().getName()), "", ""));
		
		Ol relationshipTocList = new Ol(); 
		relationshipTocList.setCSSClass(TOC_LIST_CLASS);
		for (Relationship relationship : getMessagePart().getRelationships()) {
			if (relationship.isStructural() && this.getExcludeStructuralAttributes()) {
				continue;
			}
			Li relationshipTocListItem = new Li();
			relationshipTocListItem.setCSSClass(TOC_LIST_ITEM_CLASS);
			relationshipTocListItem.appendChild(createLink("#" + getRelationshipId(getMessagePart(), relationship), 
					new Text(relationship.getName() + ": " + getBusinessName(relationship.getDocumentation())), 
					"", ""));
			relationshipTocListItem.appendText(" (" + getConformanceLetter(relationship.getConformance()) + ") ");
			relationshipTocListItem.appendText(" ["+ getCardinalityValue(relationship.getCardinality()) + "]");
			relationshipTocList.appendChild(relationshipTocListItem);
			
			if (relationship.isChoice()) {
				Ul choiceSection = new Ul();
				choiceSection.setCSSClass(TOC_LIST_CLASS);
				Li choiceElement = new Li();
				choiceElement.setCSSClass(TOC_LIST_ITEM_CLASS);
				choiceElement.appendChild(createLink("#" + getRelationshipChoiceId(relationship), new Text("Descendants:"), "",  ""));
				
				Ol choiceTocList = new Ol();
				choiceTocList.setCSSClass(TOC_LIST_CLASS);
				for (Relationship choice : relationship.getChoices()) {
					Li choiceTocListItem = new Li();
					choiceTocListItem.setCSSClass(TOC_LIST_ITEM_CLASS);
					choiceTocListItem.appendChild(createLink("#" + getRelationshipChoiceId(relationship), new Text(choice.getName()), "", ""));
					choiceTocListItem.appendText(" : ");
					choiceTocListItem.appendChild(createLink(getMessagePartUrl(choice.getType()), new Text(choice.getType()), "", ""));
					choiceTocList.appendChild(choiceTocListItem);
				}
				choiceElement.appendChild(choiceTocList);
				choiceSection.appendChild(choiceElement);
				
				relationshipTocListItem.appendChild(choiceSection);
			} else if (relationship.isAssociation() && !relationship.isTemplateRelationship()) {
				Ul associationSection = new Ul();
				associationSection.setCSSClass(TOC_LIST_CLASS);
				Li associationElement = new Li();
				associationElement.setCSSClass(TOC_LIST_ITEM_CLASS);
				associationElement.appendChild(
						createLink("#" + getMessagePartName(relationship.getType()) + "DetailsDiv", new Text(relationship.getType()), "", ""));
				associationSection.appendChild(associationElement);
				relationshipTocListItem.appendChild(associationSection);
			}
		}
		
		detailsListItem.appendChild(relationshipTocList);
		
		return detailsListItem;
	}

	protected Div createMessagePartSummaryDiv() {
		Div summaryDiv = new Div();
		summaryDiv.setId("summaryDiv_" + getMessagePartName(getMessagePart().getName()));
		summaryDiv.setCSSClass("summaryDiv");
//		summaryDiv.appendChild(createHeader("Message Part Summary:", "", "titleHeader"));
		Table summaryTable = createSummaryTable(getMessagePart());
		if (summaryTable != null) {
			summaryDiv.appendChild(summaryTable);
		}
		return summaryDiv;
	}

	private Table createSummaryTable(MessagePart messagePart) {
		Table result = new Table();
		result.setCSSClass("messagePartSummaryTable");
		result.setId("messagePartSummaryTable-"+getMessagePartName(messagePart.getName()));
		Tbody tBody = new Tbody();
		//tBody.appendChild(createDataRow("Name:", createLink("#" + getMessagePartName(messagePart.getName()) + "DetailsDiv", new Text(messagePart.getName()), "", ""), ""));
		//tBody.appendChild(createDataRow("Container:", new Text(new TypeName(messagePart.getName()).getRootName().getName()), ""));
		//tBody.appendChild(createDataRow("Business Name:", new Text(getBusinessName(messagePart.getDocumentation())), ""));
		//tBody.appendChild(createDataRow("Abstract:", new Text(messagePart.isAbstract()), ""));
		Integer numRows = 0;
		if (messagePart.isAbstract()) {
			tBody.appendChild(createDataRow("Specialization Types:", createSpecializationList(messagePart.getSpecializationChilds()), ""));
			numRows++;
			
		}
		
		numRows+=addAnnotationDetails(messagePart.getDocumentation(), "Note:", tBody);
		if (numRows > 0) {
			result.appendChild(tBody);
			return result;
		}
		return null;
	}

	private Node createSpecializationList(
			List<SpecializationChild> specializationChilds) {
		Ul specializationList = new Ul();
		for (SpecializationChild specializationChild : specializationChilds) {
			Li specializationListItem = new Li();
			specializationListItem.appendChild(createLink(getMessagePartUrl(specializationChild.getName()), 
					new Text(specializationChild.getName()), "detailsRow", specializationChild.getName()));
			specializationList.appendChild(specializationListItem);
		}
		return specializationList;	
	}

	protected Table createRelationshipTable(Relationship relationship) {
		Table result = new Table();
		result.setCSSClass("relationshipDetailsTable");
		
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
//		Tr titleHeaderRow = new Tr();
//		if (relationship.isAttribute()) {
//			titleHeaderRow.appendChild(createHeader(getBusinessName(relationship.getDocumentation()), "", "titleHeader"));
//			titleHeaderRow.appendChild(createSubHeader("(" + relationship.getName() + ")", "", "subTitleHeader"));
//		} else {
//			titleHeaderRow.appendChild(createHeader(relationship.getName(), "", "titleHeader"));
//		}	
//		tHead.appendChild(titleHeaderRow);
		result.appendChild(tHead);
		
//		tBody.appendChild(createDataRow("Business Name:", new Text(getBusinessName(relationship.getDocumentation())), ""));			
		
		if (relationship.isAttribute()) {
			tBody.appendChild(createDataRow("Data Type:", createDatatypeLinks(relationship.getType(), getDatatypeSet()), ""));
			
			if (relationship.isFixed()) {
				tBody.appendChild(createDataRow("Fixed Value:", new Text(relationship.getFixedValue()), 
						"This member is fixed to " + relationship.getFixedValue()));
			} 
			
			if (relationship.getDefaultValue() != null) {
				tBody.appendChild(createDataRow("Default Value:", new Text(relationship.getDefaultValue()), 
						"This member is defaulted to " + relationship.getDefaultValue()));
			}
			
		} else {
			if (StringUtils.isNotBlank(relationship.getType()))	{
				tBody.appendChild(createDataRow("Target:", 
						createLink(getMessagePartUrl(relationship.getType()), 
								new Text(relationship.getType()), "detailsRow", "detailsRow_" + relationship.getType()), ""));
			} else if (StringUtils.isBlank(relationship.getType()) && StringUtils.isNotBlank(relationship.getTemplateParameterName())) {
				tBody.appendChild(createDataRow("Data Type:", new Text(relationship.getTemplateParameterName()), ""));
			}
			
			if (relationship.isChoice()) {			
				Tr choicesListRow = createDataRow("Descendants:", createChoiceListElement(relationship.getChoices()), "");
				choicesListRow.setId(getRelationshipChoiceId(relationship));
				tBody.appendChild(choicesListRow);				
			}
		}
		
		//Merge conformance and Cardinality into 1 row
		tBody.appendChild(createMergedConformanceCardinalityRow(relationship));
		
//		tBody.appendChild(createDataRow("Conformance:", 
//				new Text(ConformanceLevel.valueOf(ConformanceLevel.class, relationship.getConformance().name()).getDescription()), ""));
		
//		tBody.appendChild(createDataRow("Cardinality:", new Text(getCardinalityValue(relationship.getCardinality())), ""));
		
		if (relationship.isCodedType()) {
//			if (relationship.getCodingStrength() != null) {
//				tBody.appendChild(createDataRow("Coding Strength:", new Text(relationship.getCodingStrength().name()), ""));
//			} else if (relationship.getDomainSource().equals(DomainSource.CODE_SYSTEM)) {
//				tBody.appendChild(createDataRow("Supplier Strength:", new Text(CodingStrength.CNE.name()), ""));
//			} else if (relationship.getDomainSource().equals(DomainSource.CONCEPT_DOMAIN)) {
//				tBody.appendChild(createDataRow("Supplier Strength:", new Text(""), ""));
//			}
//			if (relationship.getDomainSource() != null) {
//				tBody.appendChild(createDataRow("Supplier Domain:", new Text(getDomainSource(relationship.getDomainSource())), ""));
//			}
//			if (!StringUtils.isBlank(relationship.getDomainType())) {
//				tBody.appendChild(createDataRow("Domain Type:", new Text(relationship.getDomainType()), ""));
//			}
			tBody.appendChild(createMergedCodedDetailsRow(relationship));
		}
			
		if (relationship.getDocumentation() != null && !relationship.isStructural()) {
			if (StringUtils.isNotBlank(relationship.getDocumentation().getTitle())){
				tBody.appendChild(createDataRow("Title:", new Text(relationship.getDocumentation().getTitle()), ""));
			}
			addAnnotationDetails(relationship.getDocumentation(), "Note:", tBody);
		}
		
		result.appendChild(tBody);
		return result;
	}

	private Tr createMergedCodedDetailsRow(Relationship relationship) {
		Tr codeDetailsRow = new Tr();
		codeDetailsRow.appendChild(createDataColumn(new Text("Coding Strength:"), DETAILS_TABLE_LABEL_COL_CLASS));
		if (relationship.getCodingStrength() != null) {
			codeDetailsRow.appendChild(createDataColumn(new Text(relationship.getCodingStrength().name()), DETAILS_TABLE_VALUE_COL_CLASS));
		} else if (relationship.getDomainSource().equals(DomainSource.CODE_SYSTEM)) {
			//According to JR, code systems all have the same coding strength (Hardcoded to CNE for now)
			codeDetailsRow.appendChild(createDataColumn(new Text(CodingStrength.CNE.name()), DETAILS_TABLE_VALUE_COL_CLASS));
		} else if (relationship.getDomainSource().equals(DomainSource.CONCEPT_DOMAIN)) {
			//GN: Value currently obtained from new msg set but not handled in older versions
			codeDetailsRow.appendChild(createDataColumn(new Text("-"), DETAILS_TABLE_VALUE_COL_CLASS));
		}
		codeDetailsRow.appendChild(createDataColumn(new Text(getDomainSource(relationship.getDomainSource())), DETAILS_TABLE_LABEL_COL_CLASS));
		if (DomainSource.CONCEPT_DOMAIN.equals(relationship.getDomainSource())
				&& getConceptDomainByName(relationship.getDomainType(), getMessageSet().getVocabulary()) != null) {	
			codeDetailsRow.appendChild(createDataColumn(
					createLink(getConceptDomainUrl(relationship.getDomainType()), new Text(relationship.getDomainType()), "", ""), 
					DETAILS_TABLE_VALUE_COL_CLASS));
		} else if (DomainSource.VALUE_SET.equals(relationship.getDomainSource())
				&& getValueSetByName(relationship.getDomainType(), getMessageSet().getVocabulary()) != null) {	
			codeDetailsRow.appendChild(createDataColumn(
					createLink(getValueSetUrl(relationship.getDomainType()), new Text(relationship.getDomainType()), "", ""), 
					DETAILS_TABLE_VALUE_COL_CLASS));
		} else if (DomainSource.CODE_SYSTEM.equals(relationship.getDomainSource())
				&& getCodeSystemByName(relationship.getDomainType(), getMessageSet().getVocabulary()) != null) {	
			codeDetailsRow.appendChild(createDataColumn(
					createLink(getCodeSystemUrl(relationship.getDomainType()), new Text(relationship.getDomainType()), "", ""), 
					DETAILS_TABLE_VALUE_COL_CLASS));
		} else {
			codeDetailsRow.appendChild(createDataColumn(new Text(relationship.getDomainType()), DETAILS_TABLE_VALUE_COL_CLASS));
		}
		return codeDetailsRow;
	}
	
	private Tr createMergedConformanceCardinalityRow(Relationship relationship) {
		Tr conformanceCardRow = new Tr();
		Td confLabelCol = createDataColumn(new Text("Conformance:"), DETAILS_TABLE_LABEL_COL_CLASS);
		conformanceCardRow.appendChild(confLabelCol);
		Td confValueCol = createDataColumn(new Text(getConformanceValue(relationship.getConformance())), DETAILS_TABLE_VALUE_COL_CLASS);
		conformanceCardRow.appendChild(confValueCol);
		Td cardLabelCol = createDataColumn(new Text("Cardinality:"), DETAILS_TABLE_LABEL_COL_CLASS);
		conformanceCardRow.appendChild(cardLabelCol);
		Td cardValueCol = createDataColumn(new Text(getCardinalityValue(relationship.getCardinality())), DETAILS_TABLE_VALUE_COL_CLASS);
		conformanceCardRow.appendChild(cardValueCol);
		return conformanceCardRow;
	}

	private Ul createChoiceListElement(List<Relationship> choices) {
		Ul result = new Ul();
		for (Relationship choice : choices) {
			Li choiceListItem = new Li();
			choiceListItem.setCSSClass("choiceDetails");
			choiceListItem.appendText(choice.getName() + " : ");
			choiceListItem.appendChild(createLink(getMessagePartUrl(choice.getType()), 
					new Text(choice.getType()), "detailsRow", choice.getType()));
			result.appendChild(choiceListItem);
		}
		return result;
	}
	
	public MessagePart getMessagePart() {
		return messagePart;
	}

	public void setMessagePart(MessagePart messagePart) {
		this.messagePart = messagePart;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public Boolean getExcludeStructuralAttributes() {
		return excludeStructuralAttributes;
	}

	public void setExcludeStructuralAttributes(Boolean excludeStructuralAttributes) {
		this.excludeStructuralAttributes = excludeStructuralAttributes;
	}

	public DatatypeSet getDatatypeSet() {
		return datatypeSet;
	}

	public void setDatatypeSet(DatatypeSet datatypeSet) {
		this.datatypeSet = datatypeSet;
	}
}
