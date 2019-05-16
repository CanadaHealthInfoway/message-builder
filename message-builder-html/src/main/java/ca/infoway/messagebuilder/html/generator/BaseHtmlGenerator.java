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

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CODESYSTEM_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CONCEPTDOMAIN_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DATATYPE_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_LABEL_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DETAILS_TABLE_VALUE_COL_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.INTERACTION_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.JAVASCRIPT_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.LEFT_NAV_BAR_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PACKAGE_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.RESOURCE_PATH;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.VALUESET_PATH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H2;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Script;
import com.hp.gagawa.java.elements.Span;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Title;
import com.hp.gagawa.java.elements.Tr;
import com.hp.gagawa.java.elements.Ul;

import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.html.generator.util.UrlLinkifier;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.Concept;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.Vocabulary;

public abstract class BaseHtmlGenerator {

	private Set<String> duplicateCodeSystemNameSet;
	
	private String interactionsPath;
	private String messagePartsPath;
	private String datatypesPath;
	private String codeSystemsPath;
	private String valueSetsPath;
	private String conceptDomainsPath;
	private String javascriptPath;
	private String resourcesPath;
	
	public BaseHtmlGenerator(String interactionsPath, String messagePartsPath, String datatypesPath, 
			String codeSystemPath, String valueSetsPath, String conceptDomainsPath, 
			String javascriptPath, String resourcesPath){
		this.interactionsPath = interactionsPath;
		this.messagePartsPath = messagePartsPath;
		this.datatypesPath = datatypesPath;
		this.codeSystemsPath = codeSystemPath;
		this.valueSetsPath = valueSetsPath;
		this.conceptDomainsPath = conceptDomainsPath;
		this.javascriptPath = javascriptPath;
		this.resourcesPath = resourcesPath;
	}
	
	public BaseHtmlGenerator() {
		this.interactionsPath = INTERACTION_PATH;
		this.messagePartsPath = PACKAGE_PATH;
		this.datatypesPath = DATATYPE_PATH;
		this.codeSystemsPath = CODESYSTEM_PATH;
		this.valueSetsPath = VALUESET_PATH;
		this.conceptDomainsPath = CONCEPTDOMAIN_PATH;
		this.javascriptPath = JAVASCRIPT_PATH;
		this.resourcesPath = RESOURCE_PATH;
	}

	public abstract String write();
	public abstract Set<AnnotationType> getExcludeAnnotationFilter();
	public abstract MessageSet getMessageSet();
	
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
			return getMessagePartsPath() + "/" + getPackageFileName(packageName) + "#" + messagePartAnchor + "DetailsDiv";
		}
		return getMessagePartsPath() + "/" + getPackageFileName(packageName);
	}
	
	protected String getRelationshipUrl(MessagePart messagePart, Relationship relationship) {
		String packageName = new TypeName(messagePart.getName()).getParent().getName();
		if (relationship != null) {
			return getMessagePartsPath() + "/" + getPackageFileName(packageName) + "#" + getRelationshipId(messagePart, relationship);
		}
		return getMessagePartsPath() + "/" + getPackageFileName(packageName);
	}
	
	protected String getPackageUrl(String packageName) {
		return getMessagePartsPath() + "/" + getPackageFileName(packageName);
	}
	
	protected String getPackageFileName(String packageName) {
		return packageName + ".html";
	}
	
	protected String getInteractionUrl(String interaction) {
		return getInteractionsPath() + "/" + getInteractionFileName(interaction);
	}
	
	protected String getInteractionFileName(String interaction) {
		return interaction + ".html";
	}
	
	protected String getDatatypeUrl(String datatype) {
		return getDatatypesPath() + "/" + getDatatypeFileName(datatype);
	}
	
	protected String getDatatypeFileName(String datatype) {
		return datatype + ".html";
	}
	
	protected String getCodeSystemUrl(String codeSystem) {
		return getCodeSystemsPath() + "/" + getCodeSystemFileName(codeSystem);
	}

	protected String getCodeSystemFileName(String codeSystem) {
		if (getDuplicateCodeSystemNameSet()==null) {
			initDuplicateNameList();
		}
		Integer fileSuffix = 0;
		String fileName = new String(codeSystem);
		
		while (getDuplicateCodeSystemNameSet().contains(fileName)) {
			fileName = fileName + "_" + fileSuffix;
			fileSuffix++;
		}
		
		return fileName + ".html";
	}

	protected String getValueSetUrl(String valueSet) {
		return getValueSetsPath() + "/" + getValueSetFileName(valueSet);
	}
	
	protected String getValueSetFileName(String valueSet) {
		return valueSet + ".html";
	}
	
	protected String getConceptDomainUrl(String conceptDomain) {
		return getConceptDomainsPath() + "/" + getConceptDomainFileName(conceptDomain);
	}
	
	protected String getConceptDomainFileName(String conceptDomain) { 
		return conceptDomain + ".html";
	}
	
	private void initDuplicateNameList() {
		Set<String> nameSet = new HashSet<String>();
		Set<String> dupNameSet = new HashSet<String>();
		//Only concerned about concept domain for now as no other components seem to have same name with different case
		for (CodeSystem codeSystem : getMessageSet().getVocabulary().getCodeSystems()) {
			if (!nameSet.contains(codeSystem.getName().toUpperCase())) {				
				nameSet.add(codeSystem.getName().toUpperCase());
			} else {
				dupNameSet.add(codeSystem.getName());
			}
		}
		setDuplicateCodeSystemNameSet(dupNameSet);
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
	
	protected Integer addAnnotationDetails(Documentation documentation, String definitionLabelText, Tbody tBody) {
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
			List<Annotation> sortedAnnotations = new ArrayList<Annotation>(annotations);
			Collections.sort(sortedAnnotations, new Comparator<Annotation>() {
				@Override
				public int compare(Annotation o1, Annotation o2) {
					if (AnnotationType.DEFINITION.equals(o1.getAnnotationTypeAsEnum())
							&& !AnnotationType.DEFINITION.equals(o2.getAnnotationTypeAsEnum())) {
						return -1;
					} else if (AnnotationType.DEFINITION.equals(o2.getAnnotationTypeAsEnum())
							&& !AnnotationType.DEFINITION.equals(o1.getAnnotationTypeAsEnum())) {
						return 1;
					} else if (AnnotationType.DESCRIPTION.equals(o1.getAnnotationTypeAsEnum())
							&& !AnnotationType.DESCRIPTION.equals(o2.getAnnotationTypeAsEnum())) {
						return -1;
					} else if (AnnotationType.DESCRIPTION.equals(o2.getAnnotationTypeAsEnum())
							&& !AnnotationType.DESCRIPTION.equals(o1.getAnnotationTypeAsEnum())) {
						return 1;
					} else {
						return o1.getAnnotationType().compareTo(o2.getAnnotationType());
					}
				}
				
			});
			
			for (Annotation annotation : sortedAnnotations) {
				// Filter out mapping annotations for now (not in requirements), will likely require different handling for subtype
				String text = annotation.getText();
				if (text != null) {
					if (AnnotationType.DEFINITION.equals(annotation.getAnnotationTypeAsEnum())) {
						tBody.appendChild(createDataRow(definitionLabelText, new Text(UrlLinkifier.linkify(text)), ""));
						numRows++;
					} else if (!getExcludeAnnotationFilter().contains(annotation.getAnnotationTypeAsEnum())) {
						tBody.appendChild(createDataRow(capitalizeTitle(annotation.getAnnotationType()) + ":", new Text(UrlLinkifier.linkify(text)), ""));
						numRows++;
					}
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
	
	protected Node createDatatypeLinks(String typeName, DatatypeSet datatypeSet) {
		Span result = new Span();
		
		//Split the super type into pieces 
		String[] angleParts = typeName.split("<");
		List<Node> linkList = new ArrayList<Node>();
		List<String> partSuffix = new ArrayList<String>();
		for (String anglePart : angleParts) {
			String datatypeName = new String(anglePart);

			String closingBracket = "";
			while(datatypeName.endsWith(">")) {
				closingBracket+=">";
				datatypeName = datatypeName.substring(0, datatypeName.length()-1);
			}
			
			if (datatypeSet != null && datatypeSet.getDatatype(datatypeName) != null) {
				linkList.add(createLink(getDatatypeUrl(datatypeName), new Text(datatypeName), "detailsRows", ""));
			} else if (datatypeName.contains(",")) {
				String[] commaParts = datatypeName.split(",");
				int commaIndex = 0;
				for (String commaPart : commaParts) {
					String subDatatypeName = new String(commaPart.trim());
					if (datatypeSet != null && datatypeSet.getDatatype(subDatatypeName) != null) {
						linkList.add(createLink(getDatatypeUrl(subDatatypeName), new Text(subDatatypeName), "detailsRows", ""));
					} else {
						linkList.add(new Text(commaPart));
					}
					if (commaIndex > 0) {
						partSuffix.add(", ");						
					}
					commaIndex++;
				}
			} else {
				linkList.add(new Text(datatypeName));
			}
			partSuffix.add(closingBracket);
		}
		
		//Reconstruct various pieces into links
		int index = 0;
		for (Node link : linkList) {
			if (index > 0) {
				if (partSuffix.get(index-1)!=", ") {
					result.appendText(StringEscapeUtils.escapeHtml("<"));
				}
				result.appendChild(link);
				result.appendText(StringEscapeUtils.escapeHtml(partSuffix.get(index)));
			} else {
				result.appendChild(link);
			}
			index++;
		}
		
		return result;
	}
	
	protected String capitalizeTitle(String text) {
		if (StringUtils.isBlank(text)) {
			return text;
		}
			
		String result = text.substring(0, 1).toUpperCase() + text.substring(1, text.length()).toLowerCase();
		result = result.replace("_", " ");
		
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

	protected void addDatatypeDetailsMetaHeader(String datatypeName, Div contentDiv) {
		Div metaDiv = new Div();
		metaDiv.setId("metaDiv");
		metaDiv.setAttribute("partname", datatypeName);
		metaDiv.setAttribute("packagename", getMessagePartName(datatypeName));
		contentDiv.appendChild(metaDiv);
	}
	
	protected void addVocabDetailsMetaHeader(String name, DomainSource domainSource, Div contentDiv) {
		Div metaDiv = new Div();
		metaDiv.setId("metaDiv");
		metaDiv.setAttribute("partname", name);
		metaDiv.setAttribute("packagename", domainSource.name() + "_" + getMessagePartName(name));
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
					if (o1.isStructural() && !o2.isStructural()) {
						return -1;
					} else if (!o1.isStructural() && o2.isStructural()) {
						return 1;
					} else {
						if (getSortName(o1).compareTo(getSortName(o2)) != 0) {
							return getSortName(o1).compareTo(getSortName(o2));
						}
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
	
	protected Ul createModelClassAttributeList(String name, DomainSource domainSource, MessageSet messageSet) {
		Ul result = new Ul();
		int modelClassAttrCount = 0;
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isAttribute() && relationship.isCodedType() 
						&& domainSource.equals(relationship.getDomainSource())
						&& name.equals(relationship.getDomainType())) {
					Li modelClassAttributeRefererListItem = new Li();
					modelClassAttributeRefererListItem.appendChild(
							createLink(getRelationshipUrl(messagePart, relationship), 
									new Text(messagePart.getName()+"."+relationship.getName()), "", ""));
					//modelClassAttributeRefererListItem.appendText(messagePart.getName()+"."+relationship.getName());
					result.appendChild(modelClassAttributeRefererListItem);
					modelClassAttrCount++;
				}
			}
		}
		
		if(modelClassAttrCount == 0) {
			result.appendText("None");
		}
		
		return result;
	}
	
	protected Concept getConcept(CodeSystem codeSystem, String conceptName) {
		if (conceptName == null) { return null; }
		for (Concept concept : codeSystem.getConcepts()) {
			if (concept.getCode() != null && concept.getCode().equals(conceptName)) {
				return concept;
			}
		}
		return null;
	}

	protected CodeSystem getCodeSystemByName(String codeSystemName, Vocabulary vocabulary) {
		if (codeSystemName == null) { return null; }
		for (CodeSystem codeSystem : vocabulary.getCodeSystems()) {
			if (codeSystem.getName().equals(codeSystemName)) {
				return codeSystem;
			}
		}
		return null;
	}
	
	protected ValueSet getValueSetByName(String valueSetName, Vocabulary vocabulary) {
		if (valueSetName == null) { return null; }
		for (ValueSet valueSet : vocabulary.getValueSets()) {
			if (valueSet.getName().equals(valueSetName)) {
				return valueSet;
			}
		}
		return null;
	}
	
	protected ConceptDomain getConceptDomainByName(String conceptDomainName, Vocabulary vocabulary) {
		if (conceptDomainName == null) { return null; }
		for (ConceptDomain conceptDomain : vocabulary.getConceptDomains()) {
			if (conceptDomain.getName().equals(conceptDomainName)) {
				return conceptDomain;
			}
		}
		return null;
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

	public String getDatatypesPath() {
		return datatypesPath;
	}

	public void setDatatypesPath(String datatypesPath) {
		this.datatypesPath = datatypesPath;
	}

	public String getCodeSystemsPath() {
		return codeSystemsPath;
	}

	public void setCodeSystemsPath(String codeSystemPath) {
		this.codeSystemsPath = codeSystemPath;
	}

	public String getValueSetsPath() {
		return valueSetsPath;
	}

	public void setValueSetsPath(String valueSetsPath) {
		this.valueSetsPath = valueSetsPath;
	}

	public String getConceptDomainsPath() {
		return conceptDomainsPath;
	}

	public void setConceptDomainsPath(String conceptDomainsPath) {
		this.conceptDomainsPath = conceptDomainsPath;
	}

	public Set<String> getDuplicateCodeSystemNameSet() {
		return duplicateCodeSystemNameSet;
	}

	public void setDuplicateCodeSystemNameSet(Set<String> duplicateNameList) {
		this.duplicateCodeSystemNameSet = duplicateNameList;
	}	

}
