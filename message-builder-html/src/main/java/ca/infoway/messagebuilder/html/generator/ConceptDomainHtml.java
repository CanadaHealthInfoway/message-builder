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
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DIAGRAM_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MAIN_CONTENT_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

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
import com.hp.gagawa.java.elements.Ul;

import ca.infoway.demiftifier.VocabularyLayout;
import ca.infoway.demiftifier.layout.LayerOuter;
import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.ContextBinding;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;

public class ConceptDomainHtml extends BaseHtmlGenerator {
	private ConceptDomain conceptDomain;
	private MessageSet messageSet;
	private Svgifier svgifier;
	
	public ConceptDomainHtml(ConceptDomain conceptDomain, MessageSet messageSet) {
		this.conceptDomain = conceptDomain;
		this.messageSet = messageSet;
	}
	
	public ConceptDomainHtml(ConceptDomain conceptDomain, MessageSet messageSet,
			String interactionsPath, String messagePartsPath, String datatypesPath, 
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath, 
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.conceptDomain = conceptDomain;
	}

	@Override
	public String write() {
		return writeConceptDomain().write();
	}
	
	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected Document writeConceptDomain() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		addHeadParamaters(getConceptDomain().getName(), "Concept Domain", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addVocabDetailsMetaHeader(getConceptDomain().getName(), DomainSource.CONCEPT_DOMAIN, containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		mainContentDiv.appendChild(createHeader("Concept Domain: " + getConceptDomain().getName(), "titleHeader-"+getConceptDomain().getName(), "titleHeader"));
		mainContentDiv.appendChild(createConceptDomainSummaryDiv());
		mainContentDiv.appendChild(createDiagramDiv(getConceptDomain(), getMessageSet()));
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	private Div createDiagramDiv(ConceptDomain conceptDomain, MessageSet messageSet) {
		Div result = new Div();
		result.setId(DIAGRAM_DIV_ID);
		result.setCSSClass(DIAGRAM_DIV_ID);
		
		VocabularyLayout layout = new LayerOuter().vocabLayout(messageSet, conceptDomain.getName());
		StringWriter writer = new StringWriter();
		try {
			if (getSvgifier() == null) {
				new Svgifier().render(layout, writer);
			} else {
				getSvgifier().render(layout, writer);
			}
		} catch (IOException ex) {
			throw new RuntimeException("Unable to generate SVG: " + ex.getMessage());
		}
		result.appendChild(new Hr());
		result.appendChild(createHeader("Diagram:", "diagramHeader-"+conceptDomain.getName(), "titleHeader"));
		result.appendText(writer.toString());
		
		return result;
	}

	private Div createConceptDomainSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("summaryDiv");
		result.setId("summaryDiv-" + getConceptDomain().getName());
		
		Table detailsTable = new Table();
		
		Thead tableHeader = new Thead();
		
		Tbody tableBody = new Tbody();
		//tableBody.appendChild(createDataRow("Concept Domain Name:", new Text(getConceptDomain().getName()), ""));
		
		addAnnotationDetails(getConceptDomain().getDocumentation(), "Definition:", tableBody);
		
		tableBody.appendChild(createDataRow("Owning SCWG:", new Text(getConceptDomain().getOwningSCWG()), ""));
		tableBody.appendChild(createDataRow("Risk of Change:", new Text(getConceptDomain().getRiskOfChange()==null?"N/A":getConceptDomain().getRiskOfChange()), ""));
		tableBody.appendChild(createDataRow("Used In Model Class Attributes:", 
				createModelClassAttributeList(getConceptDomain().getName(), DomainSource.CONCEPT_DOMAIN, getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Bound Value Sets:", createBoundValueSetsList(getConceptDomain(), getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Child Concept Domains:", createChildConceptDomainList(getConceptDomain(), getMessageSet()), ""));
		tableBody.appendChild(createDataRow("Parent Concept Domains:", createParentConceptDomainList(getConceptDomain(), getMessageSet()), ""));
		
		detailsTable.appendChild(tableHeader);
		detailsTable.appendChild(tableBody);
		
		result.appendChild(detailsTable);
		return result;
	}

	private Node createBoundValueSetsList(ConceptDomain conceptDomain, MessageSet messageSet) {
		Ul result = new Ul();
		int valueSetCount = 0;
		for (ValueSet valueSet : messageSet.getVocabulary().getValueSets()) {
			for (ContextBinding contextBinding : valueSet.getContextBindings()) {
				if (contextBinding.getConceptDomain().equals(conceptDomain.getName())) {
					Li boundValueSetListItem = new Li();
					boundValueSetListItem.appendChild(createLink(getValueSetUrl(valueSet.getName()), new Text(valueSet.getName()), "", ""));
					result.appendChild(boundValueSetListItem);
					valueSetCount++;
				}
			}
		}
		
		if (valueSetCount == 0) {
			return new Text("None");
		}
		
		return result;
	}

	private Node createChildConceptDomainList(ConceptDomain conceptDomain, MessageSet messageSet) {
		Ul result = new Ul();
		int childCount = 0;
		for (ConceptDomain childConceptDomain : messageSet.getVocabulary().getConceptDomains()) {
			if (childConceptDomain.getParentConceptDomains().contains(conceptDomain.getName())) {
				Li conceptDomainListItem = new Li();
				conceptDomainListItem.appendChild(createLink(getConceptDomainUrl(childConceptDomain.getName()), new Text(childConceptDomain.getName()), "", ""));
				result.appendChild(conceptDomainListItem);
				childCount++;
			}
		}
		
		if (childCount == 0) {
			return new Text("None");
		}
		
		return result;
	}

	private Node createParentConceptDomainList(ConceptDomain conceptDomain, MessageSet messageSet) {
		Ul result = new Ul();
		if (conceptDomain.getParentConceptDomains().size() > 0){
			for (String parentConceptDomain : conceptDomain.getParentConceptDomains()) {
				Li conceptDomainListItem = new Li();
				if (getConceptDomainByName(parentConceptDomain, messageSet.getVocabulary()) != null) {
					conceptDomainListItem.appendChild(createLink(getConceptDomainUrl(parentConceptDomain), new Text(parentConceptDomain), "", ""));
				} else {
					conceptDomainListItem.appendText(parentConceptDomain);
				}
				result.appendChild(conceptDomainListItem);
			}
		} else {
			return new Text("None");
		}
		return result;
	}

	public ConceptDomain getConceptDomain() {
		return conceptDomain;
	}

	public void setConceptDomain(ConceptDomain conceptDomain) {
		this.conceptDomain = conceptDomain;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public Svgifier getSvgifier() {
		return svgifier;
	}

	public void setSvgifier(Svgifier svgifier) {
		this.svgifier = svgifier;
	}
}
