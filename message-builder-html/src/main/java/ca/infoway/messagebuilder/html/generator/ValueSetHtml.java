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
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MAIN_CONTENT_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.util.List;

import ca.infoway.messagebuilder.xml.ContextBinding;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Ul;

public class ValueSetHtml extends BaseHtmlGenerator {
	private MessageSet messageSet;
	private ValueSet valueSet;
	
	public ValueSetHtml(ValueSet valueSet, MessageSet messageSet) {
		this.messageSet = messageSet;
		this.valueSet = valueSet;
	}
	
	public ValueSetHtml(ValueSet valueSet, MessageSet messageSet,
			String interactionsPath, String messagePartsPath, String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.valueSet = valueSet;
	}
	
	@Override
	public String write() {
		return writeValueSet();
	}

	protected String writeValueSet() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		addHeadParamaters(valueSet.getName(), "ValueSet", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addDetailsMetaHeader("", containerDiv);
		
		addBreadcrumbHeader(messageSet, containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		mainContentDiv.appendChild(createHeader(getValueSet().getName(), "titleHeader-"+getValueSet().getName(), "titleHeader"));
		mainContentDiv.appendChild(createValueSetSummaryDiv());
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc.write();
	}
		
	private Div createValueSetSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("summaryDiv");
		result.setId("summaryDiv-"+valueSet.getName());
		
		Table detailsTable = new Table();
		
		Thead tableHeader = new Thead();
		
		Tbody tableBody = new Tbody();
		tableBody.appendChild(createDataRow("Name", new Text(valueSet.getName()), ""));
		tableBody.appendChild(createDataRow("OID", new Text(valueSet.getCodeSystem()), ""));
		tableBody.appendChild(createDataRow("Concept Domains", createConceptDomainList(getValueSet().getContextBindings()), ""));
		
		detailsTable.appendChild(tableHeader);
		detailsTable.appendChild(tableBody);
		
		result.appendChild(detailsTable);
		return result;
	}
	
	private Ul createConceptDomainList(List<ContextBinding> contextBindings) {
		Ul result = new Ul();
		for (ContextBinding contextBinding : contextBindings) {
			Li conceptDomainListItem = new Li();
			conceptDomainListItem.appendText(contextBinding.getConceptDomain()); 
			conceptDomainListItem.appendText("[" + contextBinding.getRealm() + "]" 
					+ " (" + contextBinding.getCodingStrength().getName() + ")");
			result.appendChild(conceptDomainListItem);
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
