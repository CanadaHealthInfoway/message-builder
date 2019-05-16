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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.H4;
import com.hp.gagawa.java.elements.Hr;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ol;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Th;
import com.hp.gagawa.java.elements.Thead;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ReceiverResponsibility;

public class InteractionHtml extends BaseHtmlGenerator{
	
	private Interaction interaction;
	private MessageSet messageSet;
	
	public InteractionHtml(Interaction interaction, MessageSet messageSet) {
		super();
		this.interaction = interaction;
		this.messageSet = messageSet;
	}
	
	public InteractionHtml(Interaction interaction, MessageSet messageSet, 
			String interactionsPath, String messagePartsPath, String datatypesPath, 
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, datatypesPath,
				codeSystemsPath, valueSetsPath, conceptDomainsPath,
				javascriptPath, resourcesPath);
		this.interaction = interaction;
		this.messageSet = messageSet;
	}
	
	@Override
	public String write(){
		return writeInteraction().write();
	}
	
	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	private Document writeInteraction() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		addHeadParamaters(getInteraction().getName(), "Interaction", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addDetailsMetaHeader(getInteraction().getName(), containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		mainContentDiv.appendChild(createHeader(
				getInteraction().getName() + " : " + getBusinessName(getInteraction().getDocumentation()), 
				"interactionTitleHeader-" + getInteraction().getName(), "interactionTitleHeader"));
		mainContentDiv.appendChild(createInteractionTOC(getInteraction()));
		mainContentDiv.appendChild(createInteractionDetailsDiv(getInteraction()));
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	private Div createInteractionTOC(Interaction interaction) {
		Div result = new Div();
		result.setCSSClass("interactionTocDiv");
		result.setId("interactionTocDiv");
		
		H4 tocTitle = new H4();
		tocTitle.setCSSClass("tocTitle");
		tocTitle.appendText("Contents:");
		result.appendChild(tocTitle);
		
		Ol rootTocList = new Ol();
		rootTocList.setCSSClass("mainToc");
		Li detailsListItem = new Li();
		detailsListItem.appendChild(createLink("#detailsDiv", new Text("Interaction Details"), "", ""));
		rootTocList.appendChild(detailsListItem);
		
		result.appendChild(rootTocList);
		return result;
	}

	private Div createInteractionDetailsDiv(Interaction interaction) {
		Div result = new Div();
		result.setId("detailsDiv");
		result.setCSSClass("detailsDiv");
		
		result.appendChild(new Hr());
		
		H3 detailsTitle = new H3();
		detailsTitle.appendText("Interaction Details:");
		result.appendChild(detailsTitle);
		
		Table detailsTable = new Table();
		detailsTable.setCSSClass("interactionDetailsTable");
		
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
		Tr titleHeaderRow = new Tr();
		Th titleHeader = new Th();
		titleHeader.appendChild(new Text(interaction.getName()));
		titleHeaderRow.appendChild(titleHeader);
		tHead.appendChild(titleHeaderRow);
		detailsTable.appendChild(tHead);
		
		tBody.appendChild(createDataRow("Name:", new Text(interaction.getBusinessName()), ""));	
		tBody.appendChild(createDataRow("Transmission Wrapper:", 
				createLink(getMessagePartUrl(interaction.getSuperTypeName()), 
						new Text(interaction.getSuperTypeName()), "detailsRow", interaction.getSuperTypeName()), ""));
		List<Argument> arguments = interaction.getArguments();
		if (arguments.size() > 1) {
			for (Argument argument : arguments) {
				tBody.appendChild(createDataRow(argument.getTemplateParameterName() + ":", 
						createLink(getMessagePartUrl(argument.getName()), 
								new Text(argument.getName()), "detailsRow", argument.getName()), ""));
				appendInnerArgument(argument, tBody, 0);
			}
		} else if (arguments.size() > 0) {
			tBody.appendChild(createDataRow("Control Act Wrapper:", 
					createLink(getMessagePartUrl(arguments.get(0).getName()), 
							new Text(arguments.get(0).getName()), "detailsRow", arguments.get(0).getName()), ""));
			appendInnerArgument(arguments.get(0), tBody, 0);
		} else {
			tBody.appendChild(createDataRow("Control Act Wrapper:", new Text("NONE"), ""));
			tBody.appendChild(createDataRow("Payload:", new Text("NONE"), ""));
		}
		
		if (StringUtils.isNotBlank(interaction.getTriggerEvent())) {
			tBody.appendChild(createDataRow("Trigger Event:", new Text(interaction.getTriggerEvent()), ""));
		} else {
			tBody.appendChild(createDataRow("Trigger Event:", new Text(""), ""));
		}
		
		if (interaction.getReceiverResponsibilities().size() > 0) {
			tBody.appendChild(createDataRow("Responses:", createRecieverList(interaction.getReceiverResponsibilities()), ""));
		} else {
			tBody.appendChild(createDataRow("Responses:", new Text("Not Applicable"), ""));
		}
		
		addAnnotationDetails(interaction.getDocumentation(), "Note:", tBody);
		
		detailsTable.appendChild(tBody);
		
		result.appendChild(detailsTable);
		
		return result;
	}
	
	private void appendInnerArgument(Argument argument, Tbody result, Integer level) {
		List<Argument> innerArguments = argument.getArguments();
		if (innerArguments.size() > 1) {
			for (Argument innerArgument : innerArguments) {
				result.appendChild(createDataRow("Payload (" + innerArgument.getTemplateParameterName() + "):", 
						createLink(getMessagePartUrl(innerArgument.getName()), 
								new Text(innerArgument.getName()), "detailsRow", innerArgument.getName()), ""));
				appendInnerArgument(innerArgument, result, level+1);
			}	
		} else if (innerArguments.size() > 0) {
			result.appendChild(createDataRow("Payload:", 
					createLink(getMessagePartUrl(innerArguments.get(0).getName()), 
							new Text(innerArguments.get(0).getName()), "detailsRow", innerArguments.get(0).getName()), ""));
			appendInnerArgument(innerArguments.get(0), result, level+1);	
		} else if (level < 1){
			result.appendChild(createDataRow("Payload:", new Text("None"), ""));
		}
	}

	private Node createRecieverList(List<ReceiverResponsibility> receiverResponsibilities) {
		Ul receiverList = new Ul();
		for (ReceiverResponsibility receiverResponsibility : receiverResponsibilities) {
			Li receiverListItem = new Li();
			receiverListItem.appendChild(createLink(getInteractionUrl(receiverResponsibility.getInvokeInteraction()), 
					new Text(receiverResponsibility.getInvokeInteraction()), "detailsRow", 
					receiverResponsibility.getInvokeInteraction()));
			receiverList.appendChild(receiverListItem);
		}
		return receiverList;
	}

	public Interaction getInteraction() {
		return interaction;
	}

	public void setInteraction(Interaction interaction) {
		this.interaction = interaction;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}
}
