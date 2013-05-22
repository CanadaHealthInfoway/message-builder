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
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PACKAGE_TOC_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.TOC_LIST_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.TOC_LIST_ITEM_CLASS;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.PackageLocationLayout;
import ca.infoway.demiftifier.layout.LayerOuter;
import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H4;
import com.hp.gagawa.java.elements.Hr;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ol;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Ul;

public class PackageLocationHtml extends BaseHtmlGenerator {
	
	private Svgifier svgifier;
	private PackageLocation packageLocation;
	private MessageSet messageSet;
	private DatatypeSet datatypeSet;
	private Boolean excludeStructuralAttributes;
	
	public PackageLocationHtml(PackageLocation packageLocation, MessageSet messageSet, DatatypeSet datatypeSet, Boolean excludeStructuralAttributes) {
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		this.packageLocation = packageLocation;
		if (excludeStructuralAttributes == null) {
			this.excludeStructuralAttributes = false;
		} else {
			this.excludeStructuralAttributes = excludeStructuralAttributes;
		}
	}
	
	public PackageLocationHtml(PackageLocation packageLocation, MessageSet messageSet, DatatypeSet datatypeSet, Boolean excludeStructuralAttributes,
			String interactionsPath, String packagesPath, String datatypesPath,
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, packagesPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath, 
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		this.packageLocation = packageLocation;
		if (excludeStructuralAttributes == null) {
			this.excludeStructuralAttributes = false;
		} else {
			this.excludeStructuralAttributes = excludeStructuralAttributes;
		}
	}
	
	@Override
	public String write() {
		return writePackageLocation().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected Document writePackageLocation() {
		Document doc = new Document(DocumentType.HTMLStrict);
	
		addHeadParamaters(getPackageLocation().getName(), "PackageLocation", getMessageSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addDetailsMetaHeader(getPackageLocation().getRootType(), containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		
		mainContentDiv.appendChild(createHeader(
				getPackageLocation().getName() + ": " + (getPackageLocation().getDescriptiveName()==null?"":getPackageLocation().getDescriptiveName()), 
				"packageTitleHeader_" + getPackageLocation().getName(), 
				"packageTitleHeader"));
		
		mainContentDiv.appendChild(createPackageTocDiv());
		
		mainContentDiv.appendChild(createPackageSummaryDiv());
		
		List<String> msgPartList = new ArrayList<String>();
		msgPartList.add(getPackageLocation().getRootType());
		populateBreadthFirstPackageLevelPartList(getPackageLocation().getRootType(), msgPartList);
		
		for (String messagePartName : msgPartList) {
			MessagePart messagePart = getPackageLocation().getMessageParts().get(messagePartName);
			MessagePartHtml messagePartHtml = new MessagePartHtml(messagePart, getMessageSet(), getDatatypeSet(), getExcludeStructrualAttributes());
			
			Div messagePartDiv = new Div();
			messagePartDiv.setId(getMessagePartName(messagePart.getName()) + "DetailsDiv");
			messagePartDiv.setCSSClass("messagePartDetailsDiv");
			messagePartDiv.appendChild(new Hr());
			if (StringUtils.isNotBlank(getBusinessName(messagePart.getDocumentation()))) {
				messagePartDiv.appendChild(createHeader(
						getBusinessName(messagePart.getDocumentation()), 
						"titleHeader-"+getMessagePartName(messagePart.getName()), "titleHeader"));
				messagePartDiv.appendChild(createSubHeader(
						"(" + getHl7TypeName(messagePart.getName()) + ")", 
						"titleHeader-"+getMessagePartName(messagePart.getName()), "subTitleHeader"));
			} else {
				messagePartDiv.appendChild(createHeader(
						getHl7TypeName(messagePart.getName()), 
						"titleHeader-"+getMessagePartName(messagePart.getName()), "titleHeader"));
			}
			messagePartDiv.appendChild(messagePartHtml.createMessagePartSummaryDiv());
			messagePartHtml.addRelationshipsSection(messagePartDiv);
			mainContentDiv.appendChild(messagePartDiv);	
		}
		mainContentDiv.appendChild(createDiagramDiv(getPackageLocation(), getMessageSet()));
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	private Div createPackageSummaryDiv() {
		Div result = new Div();
		result.setId("packageSummaryDiv_" + getPackageLocation().getName());
		result.setCSSClass("packageSummaryDiv");
		result.appendChild(new Hr());
		result.appendChild(createHeader("Package Summary", "", "titleHeader"));
		result.appendChild(createSummaryTable(getPackageLocation()));
		return result;
	}

	private Table createSummaryTable(PackageLocation packageLocation) {
		Table result = new Table();
		result.setCSSClass("packageLocationSummaryTable");
		result.setId("packageLocationSummaryTable-"+packageLocation.getName());
		Tbody tBody = new Tbody();
		tBody.appendChild(createDataRow("Name:", createLink("#" + getMessagePartName(packageLocation.getName()) + "DetailsDiv", new Text(packageLocation.getName()), "", ""), ""));
		tBody.appendChild(createDataRow("Descriptive Name:", new Text(packageLocation.getDescriptiveName()==null?"":packageLocation.getDescriptiveName()), ""));
		
		addAnnotationDetails(packageLocation.getDocumentation(), "Note:", tBody);
		
		result.appendChild(tBody);
		return result;
	}
	
	private void populateBreadthFirstPackageLevelPartList(String rootType, List<String> currentList) {
		List<String> associationList = new ArrayList<String>();
		List<String> specializationChildList = new ArrayList<String>();
		MessagePart rootPart = getPackageLocation().getMessageParts().get(rootType);
		if (rootPart != null) {
			List<Relationship> relationships = rootPart.getRelationships();
			List<Relationship> sortedRelationships = new ArrayList<Relationship>();
			sortedRelationships.addAll(relationships);
			sortRelationships(sortedRelationships);
			
			for (Relationship relationship : sortedRelationships) {
				if (relationship.isAssociation() 
						&& !relationship.isTemplateRelationship() 
						&& getPackageLocation().getMessageParts().get(relationship.getType()) != null
						&& !currentList.contains(relationship.getType())
						&& !associationList.contains(relationship.getType())) {
					associationList.add(relationship.getType());
				}
			}
			currentList.addAll(associationList);
			
			for (String associationTypeName : associationList) {
				populateBreadthFirstPackageLevelPartList(associationTypeName, currentList);				
			}
			
			if (rootPart.isAbstract()) {
				List<SpecializationChild> specializationChilds = rootPart.getSpecializationChilds();
				for (SpecializationChild specializationChild : specializationChilds) {
					String childName = specializationChild.getName();
					if (getPackageLocation().getMessageParts().get(childName) != null
							&& !currentList.contains(childName)
							&& !specializationChildList.contains(childName)) {
						specializationChildList.add(childName);
					}
				}
				currentList.addAll(specializationChildList);
				
				for (String childName : specializationChildList) {
					populateBreadthFirstPackageLevelPartList(childName, currentList);
				}
			}
		}
	}
	
	protected Div createPackageTocDiv() {
		Div packageTocDiv = new Div();
		packageTocDiv.setId(PACKAGE_TOC_DIV_ID);
		
		H4 tocHeader = new H4();
		tocHeader.setCSSClass("tocHeader");
		tocHeader.appendText("Contents:");
		packageTocDiv.appendChild(tocHeader);

		Ol rootTocList = new Ol();
		rootTocList.setCSSClass("mainToc " + TOC_LIST_CLASS);
		packageTocDiv.appendChild(rootTocList);
		
//		Li summaryListItem = new Li();
//		summaryListItem.appendChild(createLink("#packageSummaryDiv_" + getPackageLocation().getName(), new Text("Package Summary"), "", ""));
//		rootTocList.appendChild(summaryListItem);
		
		MessagePart rootPart = getPackageLocation().getMessageParts().get(getPackageLocation().getRootType());
		List<String> cycleCheckList = new ArrayList<String>();
		if (rootPart != null) {
			cycleCheckList.add(rootPart.getName());
			rootTocList.appendChild(createDepthFirstTOCList(rootPart, cycleCheckList));
		}
		
		Li diagramListItem = new Li();
		diagramListItem.setCSSClass(TOC_LIST_ITEM_CLASS);
		diagramListItem.appendChild(createLink("#" + DIAGRAM_DIV_ID, new Text("Diagram"), "", ""));
		rootTocList.appendChild(diagramListItem);
		
		return packageTocDiv;
	}

	protected Li createDepthFirstTOCList(MessagePart messagePart, List<String> cycleCheckList) {	
		Li detailsListItem = new Li();
		detailsListItem.setCSSClass("msgPartToc " + TOC_LIST_ITEM_CLASS);
		detailsListItem.appendChild(createLink("#" + getMessagePartName(messagePart.getName()) +"DetailsDiv", new Text(getDisplayName(messagePart)), "", ""));	
		
		Ol relationshipTocList = createRelationshipTocList(messagePart, cycleCheckList);
		relationshipTocList.setCSSClass(TOC_LIST_CLASS);
		detailsListItem.appendChild(relationshipTocList);
		
		if (messagePart.isAbstract()) {
			Ol specializationChildTocList = new Ol();
			specializationChildTocList.setCSSClass(TOC_LIST_CLASS);
			for (SpecializationChild specializationChild : messagePart.getSpecializationChilds()) {
				String childName = specializationChild.getName();
				MessagePart childPart = getPackageLocation().getMessageParts().get(childName);
				if (childPart != null && !cycleCheckList.contains(childPart.getName())) {
					cycleCheckList.add(childPart.getName());
					specializationChildTocList.appendChild(createDepthFirstTOCList(childPart, cycleCheckList));
				} else if (childPart != null) {
					MessagePartHtml html = new MessagePartHtml(childPart, getMessageSet(), getDatatypeSet(), getExcludeStructrualAttributes());
					specializationChildTocList.appendChild(html.createMessagePartTOCList());
				} else {
					Li specializationChildElement = new Li();
					specializationChildElement.appendChild(
						createLink("#" + getMessagePartName(childName) + "DetailsDiv", new Text(childName), "", ""));
					specializationChildTocList.appendChild(specializationChildElement);
				}
			}
			detailsListItem.appendChild(specializationChildTocList);
		}
		
		
		return detailsListItem;
	}

	private Ol createRelationshipTocList(MessagePart messagePart, List<String> cycleCheckList) {
		Ol relationshipTocList = new Ol(); 
		relationshipTocList.setCSSClass(TOC_LIST_CLASS);
		
		List<Relationship> relationships = messagePart.getRelationships();
		List<Relationship> sortedRelationships = new ArrayList<Relationship>();
		sortedRelationships.addAll(relationships);
		sortRelationships(sortedRelationships);
		
		for (Relationship relationship : sortedRelationships) {
			if (relationship.isStructural() && getExcludeStructrualAttributes()) {
				continue;
			}
			Li relationshipTocListItem = new Li();
			relationshipTocListItem.setCSSClass(TOC_LIST_ITEM_CLASS);
			relationshipTocListItem.appendChild(createLink("#" + getRelationshipId(messagePart, relationship), 
					new Text(getDisplayName(relationship)), 
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
				MessagePart associationPart = getPackageLocation().getMessageParts().get(relationship.getType());
				if (associationPart != null && !cycleCheckList.contains(associationPart.getName())) {
					cycleCheckList.add(associationPart.getName());
					//GN: Removed message part name section in order to decrease number of levels in TOC as requested
					//associationSection.appendChild(createDepthFirstTOCList(associationPart, cycleCheckList, false));
					//relationshipTocListItem.appendChild(associationSection);
					relationshipTocListItem.appendChild(createRelationshipTocList(associationPart, cycleCheckList));
				} else if (associationPart != null) {
					MessagePartHtml html = new MessagePartHtml(associationPart, getMessageSet(), getDatatypeSet(), getExcludeStructrualAttributes());
					associationSection.appendChild(html.createMessagePartTOCList());
					relationshipTocListItem.appendChild(associationSection);
				} else {
					associationElement.appendChild(
						createLink("#" + getMessagePartName(relationship.getType()) + "DetailsDiv", new Text(relationship.getType()), "", ""));
					associationSection.appendChild(associationElement);
					relationshipTocListItem.appendChild(associationSection);
				}
			}
		}
		return relationshipTocList;
	}

	private Div createDiagramDiv(PackageLocation packageLocation, MessageSet messageSet) {
		Div result = new Div();
		result.setId(DIAGRAM_DIV_ID);
		result.setCSSClass(DIAGRAM_DIV_ID);
		
		PackageLocationLayout layout = new LayerOuter().layout(messageSet, packageLocation.getName());
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
		result.appendChild(createHeader("Diagram:", "diagramHeader-"+packageLocation.getName(), "diagramHeader"));
		result.appendText(writer.toString());
		
		return result;
	}

	public PackageLocation getPackageLocation() {
		return packageLocation;
	}
	public void setPackageLocation(PackageLocation packageLocation) {
		this.packageLocation = packageLocation;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}
	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public Boolean getExcludeStructrualAttributes() {
		return excludeStructuralAttributes;
	}
	public void setExcludeStructrualAttributes(
			Boolean excludeStructrualAttributes) {
		this.excludeStructuralAttributes = excludeStructrualAttributes;
	}

	public Svgifier getSvgifier() {
		return svgifier;
	}
	public void setSvgifier(Svgifier svgifier) {
		this.svgifier = svgifier;
	}

	public DatatypeSet getDatatypeSet() {
		return datatypeSet;
	}

	public void setDatatypeSet(DatatypeSet datatypeSet) {
		this.datatypeSet = datatypeSet;
	}
	
}
