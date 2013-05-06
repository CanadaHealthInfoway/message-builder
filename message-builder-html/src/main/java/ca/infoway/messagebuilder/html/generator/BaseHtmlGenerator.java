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

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_LABEL_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_VALUE_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.INTERACTION_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.JAVASCRIPT_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.LEFT_NAV_BAR_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PACKAGE_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.RESOURCE_PATH;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H2;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Script;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Tr;

public abstract class BaseHtmlGenerator {

	private String interactionsPath;
	private String messagePartsPath;
	private String javascriptPath;
	private String resourcesPath;
	
	public BaseHtmlGenerator(String interactionsPath, String messagePartsPath, String javascriptPath, String resourcesPath){
		this.interactionsPath = interactionsPath;
		this.messagePartsPath = messagePartsPath;
		this.javascriptPath = javascriptPath;
		this.resourcesPath = resourcesPath;
	}
	
	public BaseHtmlGenerator() {
		this.interactionsPath = INTERACTION_PATH;
		this.messagePartsPath = PACKAGE_PATH;
		this.javascriptPath = JAVASCRIPT_PATH;
		this.resourcesPath = RESOURCE_PATH;
	}

	public abstract String write();
	
	/** Common Section **/
	protected Div getHeaderDiv() {
		Div result = new Div();
		result.setId("headerDiv");
		result.setCSSClass("headerDiv");
		Div iconDiv = new Div();
		iconDiv.setId("iconDiv");
		iconDiv.setCSSClass("iconDiv");
		result.appendChild(iconDiv);
		return result;
	}


	protected Node getFooterDiv() {
		Div result = new Div();
		result.setId("footerDiv");
		result.setCSSClass("footerDiv");
		return result;
	}
	
	protected void addHeadParamaters(String partName, String partType, String version, Document doc) {
		Title title = new Title();
		title.appendChild(new Text(partType + ": " + partName + " for: " + version));
		Script jqueryScript = new Script("text/javascript");
		jqueryScript.setSrc(getJavascriptPath() + "/jquery-1.7.2.js");
		Script jsTreeScript = new Script("text/javascript");
		jsTreeScript.setSrc(getJavascriptPath() + "/jquery.jstree.js");
		Script navBarScript = new Script("text/javascript");
		navBarScript.setSrc(getJavascriptPath() + "/" + HtmlMessageSetRenderDefault.NAV_BAR_SCRIPT_NAME);
		Script jqueryUiScript = new Script("text/javascript");
		jqueryUiScript.setSrc(getJavascriptPath() + "/jquery-ui-1.8.21.custom.min.js");
		Link uiCssLink = new Link();
		uiCssLink.setRel("stylesheet");
		uiCssLink.setType("text/css");
		uiCssLink.setHref(getResourcesPath() + "/css/jquery-ui-1.8.21.custom.css");

		Link cssLink = new Link();
		cssLink.setRel("stylesheet");
		cssLink.setType("text/css");
		cssLink.setHref(getResourcesPath() + "/mystyle.css");
		
		doc.head.appendChild(title);
		doc.head.appendChild(cssLink);
		doc.head.appendChild(uiCssLink);
		doc.head.appendChild(jqueryScript);
		doc.head.appendChild(jqueryUiScript);
		doc.head.appendChild(jsTreeScript);
		doc.head.appendChild(navBarScript);
	}

	protected String getMessagePartName(String messagePartName) {
		String packageName = new TypeName(messagePartName).getRootName().getName();
		String partName = new TypeName(messagePartName).getUnqualifiedName();
		if (!StringUtils.equals(packageName, partName)) {
			return packageName + "-" + partName;
		} else {
			return partName;
		}
	}
	

	protected String getHl7TypeName(String name) {
		TypeName typeName = new TypeName(name);
		return typeName.getUnqualifiedName();
	}
	
	protected String getMessagePartUrl(String messagePart) {
		String packageName = new TypeName(messagePart).getParent().getName();
		String messagePartAnchor = getMessagePartName(messagePart);
		if (StringUtils.isNotBlank(messagePart) && !StringUtils.equals(packageName, messagePartAnchor)) {
			return getMessagePartsPath() + "/" + packageName + ".html#" + messagePartAnchor + "DetailsDiv";
		}
		return getMessagePartsPath() + "/" + packageName + ".html";
	}
	
	protected String getPackageUrl(String packageName) {
		return getMessagePartsPath() + "/" + packageName + ".html";
	}
	
	protected String getInteractionUrl(String interaction) {
		return getInteractionsPath() + "/" + interaction + ".html";
	}
	
	protected Div getLeftSideColumn() {
		Div result = new Div();
		result.setId("leftSideColumn");
		
		Div leftControlDiv = new Div();
		leftControlDiv.setId("navControlDiv");
		result.appendChild(leftControlDiv);
		A toggleDivAnchor = new A();
		toggleDivAnchor.setId("toggleNavBarButton");
		toggleDivAnchor.setHref("#");
		toggleDivAnchor.appendText("[<<<]");
		leftControlDiv.appendChild(toggleDivAnchor);
		
		Div navBar = new Div();
		navBar.setId(LEFT_NAV_BAR_ID);
		
		result.appendChild(navBar);
		return result;
	}
	
	protected Td createDataColumn(Node Value, String cssClass) {
		Td confLabelCol = new Td();
		confLabelCol.appendChild(Value);
		confLabelCol.setCSSClass(cssClass);
		return confLabelCol;
	}
	
	protected Tr createDataRow(String dataLabelName, Node dataValue, String description) {
		Tr result = new Tr();
		
		Td labelCol = createDataColumn(new Text(dataLabelName), DETAILS_TABLE_LABEL_COL_CLASS);
		result.appendChild(labelCol);
		
		Td valueCol = createDataColumn(dataValue, DETAILS_TABLE_VALUE_COL_CLASS);
		result.appendChild(valueCol);
		
		if (!StringUtils.isBlank(description)) {
			Td descriptionCol = createDataColumn(new Text(description), DETAILS_TABLE_VALUE_COL_CLASS);
			descriptionCol.setColspan("2");
			result.appendChild(descriptionCol);
		} else {
			valueCol.setColspan("3");
		}
		
		return result;
	}
	
	protected A createLink(String href, Node text, String cssClass, String id) {
		A result = new A();
		result.setHref(href);
		if (StringUtils.isNotBlank(id)) {
			result.setId(id);
		}
		if (StringUtils.isNotBlank(cssClass)){
			result.setCSSClass(cssClass);
		}
		result.appendChild(text);
		return result;
	}
	
	protected H2 createHeader(String text, String id, String cssClass) {
		H2 result = new H2();
		if (StringUtils.isNotBlank(id)) {
			result.setId(id);
		}
		if (StringUtils.isNotBlank(cssClass)) {
			result.setCSSClass(cssClass);
		}
		result.appendText(text);
		return result;
	}
	
	protected H3 createSubHeader(String text, String id, String cssClass) {
		H3 result = new H3();
		if (StringUtils.isNotBlank(id)) {
			result.setId(id);
		}
		if (StringUtils.isNotBlank(cssClass)) {
			result.setCSSClass(cssClass);
		}
		result.appendText(text);
		return result;
	}
	
	protected Integer addAnnotationDetails(Documentation documentation, Tbody tBody) {
		Integer numRows = 0;
//		boolean hasDescription = false;
		if (documentation != null) {
			if (StringUtils.isNotBlank(documentation.getTitle())) {
				tBody.appendChild(createDataRow("Title:", new Text(documentation.getTitle()), ""));
				numRows++;
			} else {
//				tBody.appendChild(createDataRow("Title:", new Text(""), ""));
			}
			
			List<Annotation> annotations = documentation.getAnnotations();
			for (Annotation annotation : annotations) {
				//FIXME: Filter out mapping annotations for now (not in requirements), will likely require different handling for subtype
				if (AnnotationType.DEFINITION.equals(annotation.getAnnotationTypeAsEnum())) {
					tBody.appendChild(createDataRow("Note:", new Text(annotation.getText()), ""));
					numRows++;
				} else if (!AnnotationType.MAPPING.equals(annotation.getAnnotationTypeAsEnum())
						&& !AnnotationType.STATIC_EXAMPLE.equals(annotation.getAnnotationTypeAsEnum())) {
					tBody.appendChild(createDataRow(capitalizeTitle(annotation.getAnnotationType()) + ":", new Text(annotation.getText()), ""));
					numRows++;
				}
//				if (AnnotationType.DESCRIPTION.equals(annotation.getAnnotationTypeAsEnum())) {
//					hasDescription = true;
//				}
			}
		}
//		if (!hasDescription) {
//			tBody.appendChild(createDataRow("Description:", new Text(""), ""));
//		}
		return numRows;
	}
	
	protected String capitalizeTitle(String text) {
		if (StringUtils.isBlank(text)) {
			return text;
		}
			
		String result = text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
		
		return result;
	}
	
	protected void addDetailsMetaHeader(String partName, Div contentDiv) {
		String packageName = new TypeName(partName).getRootName().getName();
		Div metaDiv = new Div();
		metaDiv.setId("metaDiv");
		metaDiv.setAttribute("partname", getMessagePartName(partName));
		metaDiv.setAttribute("packagename", packageName);
		contentDiv.appendChild(metaDiv);
	}

	protected void addBreadcrumbHeader(MessageSet messageSet, Div contentDiv) {
		Div breadcrumbDiv = new Div();
		breadcrumbDiv.setId("breadcrumbDiv");
		breadcrumbDiv.appendChild(createHeader("MessageSet Version: " + messageSet.getVersion(), "", "breadcrumbHeader"));
		contentDiv.appendChild(breadcrumbDiv);
	}

	protected String getBusinessName(Documentation documentation) {
		if (documentation != null && StringUtils.isNotBlank(documentation.getBusinessName())) {			
			return documentation.getBusinessName();
		}
		return "";
	}
	
	protected String getDisplayName(MessagePart messagePart) {
		String businessName = getBusinessName(messagePart.getDocumentation());
		if (StringUtils.isBlank(businessName)) {
			return messagePart.getName();
		} else {
			return businessName;
		}
	}
	
	protected String getDisplayName(Relationship relationship) {
		String businessName = getBusinessName(relationship.getDocumentation());
		if (StringUtils.isNotBlank(businessName) && relationship.isAttribute()) {
			return businessName;
		} else {
			return relationship.getName();
		}
	}
	
	protected String getRelationshipId(MessagePart messagePart, Relationship relationship) {
		return messagePart.getName() + "_" + relationship.getName();
	}
	
	protected String getRelationshipChoiceId(Relationship relationship) {
		return "choice_"+relationship.getName();
	}
	
	protected String getCardinalityValue(Cardinality cardinality) {
		if (cardinality != null) {
			if (ObjectUtils.equals(cardinality.getMax(), cardinality.getMin())) {
				return "" + cardinality.getMin() + "-" + cardinality.getMax();
			} else {
				return cardinality.toString();
			}
		} 
		return "";
	}

	protected String getConformanceValue(ConformanceLevel conformance) {
		if (conformance != null) {
			String result = conformance.getName();
			result = capitalizeTitle(result);
			result = result.replaceAll("_", " ");
			return result;
		}
		return "";
	}
	

	protected String getDomainSource(DomainSource domainSource) {
		if (domainSource != null) {
			String[] nameParts = domainSource.getName().split("_");
			String result = "";
			for (String namePart : nameParts) {
				result+=" "+capitalizeTitle(namePart);
			}
			return result.trim();
		}
		return "";
	}
	
	protected String getConformanceLetter(ConformanceLevel conformance) {
		if (conformance != null) {
			return conformance.getName().substring(0, 1);
		}
		return "";
	}
	
	protected void sortRelationships(List<Relationship> relationships) {
		Collections.sort(relationships, new Comparator<Relationship>() {
			@Override
			public int compare(Relationship o1, Relationship o2) {
				if (o1.isAttribute() && o2.isAssociation()) {
					return -1;
				} else if (o1.isAssociation() && o2.isAttribute()) {
					return 1;
				} else if (o1.isAttribute() && o2.isAttribute()) {
					if (getSortName(o1).compareTo(getSortName(o2)) != 0) {
						return getSortName(o1).compareTo(getSortName(o2));
					}
				} 
				return o1.compareTo(o2);				
			}
			
			public String getSortName(Relationship relationship) {
				if (relationship.getDocumentation() != null && StringUtils.isNotBlank(relationship.getDocumentation().getBusinessName())) {
					return relationship.getDocumentation().getBusinessName();
				}
				return relationship.getName();
			}
		});
	}
	
	public String getInteractionsPath() {
		return interactionsPath;
	}
	public void setInteractionsPath(String interactionsPath) {
		this.interactionsPath = interactionsPath;
	}

	public String getMessagePartsPath() {
		return messagePartsPath;
	}
	public void setMessagePartsPath(String messagePartsPath) {
		this.messagePartsPath = messagePartsPath;
	}

	public String getJavascriptPath() {
		return javascriptPath;
	}
	public void setJavascriptPath(String javascriptPath) {
		this.javascriptPath = javascriptPath;
	}

	public String getResourcesPath() {
		return resourcesPath;
	}
	public void setResourcesPath(String resourcesPath) {
		this.resourcesPath = resourcesPath;
	}	

}
