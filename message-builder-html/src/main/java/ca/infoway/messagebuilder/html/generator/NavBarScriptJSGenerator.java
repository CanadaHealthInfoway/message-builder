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

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.LEFT_NAV_BAR_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MESSAGE_SET_ROOT_TREE_NODE_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ReceiverResponsibility;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.ValueSet;

import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Ul;

public class NavBarScriptJSGenerator extends BaseHtmlGenerator {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private MessageSet messageSet;
	private DatatypeSet datatypeSet;
	private Map<String, String> categoryNames;
	
	public NavBarScriptJSGenerator(MessageSet messageSet, DatatypeSet datatypeSet, Map<String, String> categoryNames) {
		super();
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		this.categoryNames = categoryNames;
	}

	public NavBarScriptJSGenerator(MessageSet messageSet, DatatypeSet datatypeSet, Map<String, String> categoryNames,
			String interactionsPath, String messagePartsPath, String datatypesPath, 
			String codeSystemsPath, String valueSetsPath, String conceptDomainsPath,
			String javascriptPath, String resourcesPath) {
		super(interactionsPath, messagePartsPath, datatypesPath, 
				codeSystemsPath, valueSetsPath, conceptDomainsPath, 
				javascriptPath, resourcesPath);
		this.messageSet = messageSet;
		this.datatypeSet = datatypeSet;
		this.categoryNames = categoryNames;
	}
	
	
	@Override
	public String write() {
		return writeSideNavBarScript();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	protected String writeSideNavBarScript() {
		String result = "$(function() {" + LINE_SEPARATOR +
				"	$(\"#" + LEFT_NAV_BAR_ID + "\").jstree({" + LINE_SEPARATOR +
				"		\"html_data\" : { " + LINE_SEPARATOR +
				"			\"data\" : \"";

		result+= writeSideNavBarHtml().replaceAll("\"", "\'");
		
		result += "\"" + LINE_SEPARATOR +
					"		}," + LINE_SEPARATOR +
					"		\"plugins\" : [ \"themes\", \"html_data\", \"ui\" ], " + LINE_SEPARATOR +
					"		\"core\" : { \"initially_open\" : [ \"messageSetRootNode\" ] }, " + LINE_SEPARATOR +
					"		\"ui\" : { \"initially_select\" : [ getCurrentSelectedNode() ] } " + LINE_SEPARATOR +
					"	})" + LINE_SEPARATOR +
					"	.bind(\"select_node.jstree\", function(e, data) { " + LINE_SEPARATOR +
					"		updatePageWidth();" + LINE_SEPARATOR +
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR +
					"	function getCurrentSelectedNode() {" + LINE_SEPARATOR + 
					"		var result = getCurrentPackageName() + \"_li\";" + LINE_SEPARATOR + 
					"		return result;" + LINE_SEPARATOR + 
					"	}" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	$(\"a.leafNode\").live(\"click\", function(e) {" + LINE_SEPARATOR + 
					"		var redirectUrl = $(\"a.jstree-clicked\").attr(\"href\");" + LINE_SEPARATOR + 
					"		window.location.href = redirectUrl;" + LINE_SEPARATOR + 
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR +
					"	$(\"a.detailsRow\").live(\"click\", function(e) { " + LINE_SEPARATOR +  
					"		var redirectUrl = e.target.href;" + LINE_SEPARATOR + 		
					"		window.location.href = redirectUrl;" + LINE_SEPARATOR +
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR +
					" 	$(\"ins.jstree-icon, li.jstree-open, li.jstree-closed\").live(\"click\", function(e) { " + LINE_SEPARATOR + 
					"		updatePageWidth();" + LINE_SEPARATOR + 
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	function updatePageWidth() {" + LINE_SEPARATOR + 
					"		var mainColumnWidth = $(\"div#mainColumn\").width();" + LINE_SEPARATOR + 
					"		if ($(\"div#diagramDiv svg\").width() >= mainColumnWidth) {" + LINE_SEPARATOR + 
					"			mainColumnWidth = $(\"div#diagramDiv svg\").width();" + LINE_SEPARATOR + 
					"		}" + LINE_SEPARATOR + 
					"		var newMax = $(\"div#leftNavBar\").width() + mainColumnWidth;" + LINE_SEPARATOR + 
					"		$(\"div#page\").width('100%');" + LINE_SEPARATOR + 
					"		$(\"div#headerDiv\").width('100%');" + LINE_SEPARATOR + 
					"		$(\"div#wrapper\").width('100%');" + LINE_SEPARATOR + 
					"		if (newMax >= $(\"div#page\").width()) {" + LINE_SEPARATOR + 
					"			$(\"div#page\").width(newMax+100);" + LINE_SEPARATOR + 
					"			$(\"div#headerDiv\").width(newMax+100);" + LINE_SEPARATOR + 
					"			$(\"div#wrapper\").width(newMax+100);" + LINE_SEPARATOR + 
					"		}" + LINE_SEPARATOR + 
					"	}" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	$(document).ready(function(e) {" + LINE_SEPARATOR + 
					"		$(\"a#toggleNavBarButton\").text(\"Hide\");" + LINE_SEPARATOR +
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	function getCurrentPackageName() {" + LINE_SEPARATOR + 
					"		return $(\"div#metaDiv\").attr(\"packagename\");" + LINE_SEPARATOR + 
					"	}" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	function getCurrentPartName() {" + LINE_SEPARATOR + 
					"		var currentPath = window.location.hash;" + LINE_SEPARATOR + 
					"		if (currentPath != null && currentPath.length>0 " + LINE_SEPARATOR + 
					"			&& currentPath.indexOf(\"#\" + getCurrentPackageName()) >= 0) {" + LINE_SEPARATOR + 
					"			return currentPath;" + LINE_SEPARATOR + 
					"		} else {" + LINE_SEPARATOR + 
					"			return \"#\" + $(\"div#metaDiv\").attr(\"partname\");" + LINE_SEPARATOR + 
					"		}" + LINE_SEPARATOR + 
					"	}" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	$(\"#leftNavBar\").delegate(\"a\",\"click\", function(e) {" + LINE_SEPARATOR +
					"		$(\"#leftNavBar\").jstree(\"toggle_node\", this);" + LINE_SEPARATOR +
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	$(\"a#toggleNavBarButton\").live(\"click\", function(e){" + LINE_SEPARATOR + 
					"		$(\"div#leftNavBar\").toggle('slide');" + LINE_SEPARATOR + 
					"		if ($(this).text() == 'Hide') {" + LINE_SEPARATOR + 
					"			$(this).text(\"Show\");" + LINE_SEPARATOR + 
					"		} else {" + LINE_SEPARATOR + 
					"			$(this).text(\"Hide\");" + LINE_SEPARATOR + 
					"		}" + LINE_SEPARATOR + 
					"	});" + LINE_SEPARATOR + LINE_SEPARATOR + 
					"	$(\"a#toggleNavBarButton\").button();" + LINE_SEPARATOR + 
					"});"; 
		return result;
	}
	
	protected String writeSideNavBarHtml() {	
		Li messageSetListItem = new Li();
		messageSetListItem.setId(MESSAGE_SET_ROOT_TREE_NODE_ID);
		messageSetListItem.appendChild(createLink("#", new Text(getMessageSet().getVersion()), 
				"messageSetTreeNode", getMessageSet().getVersion()));

		Ul interactionHeaderList = new Ul();
		Li interactionHeaderListItem = new Li();
		interactionHeaderListItem.setId("interactionHeaderNode");
		interactionHeaderListItem.appendChild(createLink("#", new Text("Interactions"), 
				"interactionTreeNode", "interactionTreeNode"));
		Ul interactionList = new Ul();
		interactionHeaderListItem.appendChild(interactionList);
		interactionHeaderList.appendChild(interactionHeaderListItem);
		messageSetListItem.appendChild(interactionHeaderList);

		Ul messagePartHeaderList = new Ul();
		Li messagePartHeaderListItem = new Li();
		messagePartHeaderListItem.setId("messagePartHeaderNode");
		messagePartHeaderListItem.appendChild(createLink("#", new Text("Message Types"), 
				"messagePartTreeNode", "messagePartTreeNode"));
		Ul messagePartList = new Ul();
		messagePartHeaderListItem.appendChild(messagePartList);
		messagePartHeaderList.appendChild(messagePartHeaderListItem);
		messageSetListItem.appendChild(messagePartHeaderList);
		
		Ul datatypeHeaderList = new Ul();
		Li datatypeHeaderListItem = new Li();
		datatypeHeaderListItem.setId("datatypeHeaderNode");
		datatypeHeaderListItem.appendChild(createLink("#", new Text("Datatypes"), 
				"datatypeTreeNode", "datatypeTreeNode"));
		Ul datatypeList = new Ul();
		datatypeHeaderListItem.appendChild(datatypeList);
		datatypeHeaderList.appendChild(datatypeHeaderListItem);
		messageSetListItem.appendChild(datatypeHeaderList);
		
		Ul vocabularyHeaderList = new Ul();
		Li vocabularyHeaderListItem = new Li();
		vocabularyHeaderListItem.setId("vocabularyHeaderNode");
		vocabularyHeaderListItem.appendChild(createLink("#", new Text("Vocabulary"), 
				"vocabularyTreeNode", "vocabularyTreeNode"));
		Ul vocabularyList = new Ul();
		vocabularyHeaderListItem.appendChild(vocabularyList);
		vocabularyHeaderList.appendChild(vocabularyHeaderListItem);
		messageSetListItem.appendChild(vocabularyHeaderList);
		
		Li codeSystemHeaderListItem = new Li();
		codeSystemHeaderListItem.setId("codeSystemHeaderNode");
		codeSystemHeaderListItem.appendChild(createLink("#", new Text("Code Systems"), 
				"codeSystemTreeNode", "codeSystemTreeNode"));
		Ul codeSystemList = new Ul();
		codeSystemHeaderListItem.appendChild(codeSystemList);
		vocabularyList.appendChild(codeSystemHeaderListItem);

		Li valueSetHeaderListItem = new Li();
		valueSetHeaderListItem.setId("valueSetHeaderNode");
		valueSetHeaderListItem.appendChild(createLink("#", new Text("Value Sets"), 
				"valueSetTreeNode", "valueSetTreeNode"));
		Ul valueSetList = new Ul();
		valueSetHeaderListItem.appendChild(valueSetList);
		vocabularyList.appendChild(valueSetHeaderListItem);
		
		Li conceptDomainHeaderListItem = new Li();
		conceptDomainHeaderListItem.setId("conceptDomainHeaderNode");
		conceptDomainHeaderListItem.appendChild(createLink("#", new Text("Concept Domains"), 
				"conceptDomainTreeNode", "conceptDomainTreeNode"));
		Ul conceptDomainList = new Ul();
		conceptDomainHeaderListItem.appendChild(conceptDomainList);
		vocabularyList.appendChild(conceptDomainHeaderListItem);
		
		addPackageLeafs(messagePartList);
		addInteractionLeafs(interactionList);		
		addDatatypeLeafs(datatypeList);
		
		addCodeSystemLeafs(codeSystemList);		
		addValueSetLeafs(valueSetList);		
		addConceptDomainLeafs(conceptDomainList);
		
		return messageSetListItem.write();
	}

	private void addConceptDomainLeafs(Ul conceptDomainList) {
		if(getMessageSet().getVocabulary() != null && getMessageSet().getVocabulary().getConceptDomains().size() > 0) {
			List<ConceptDomain> conceptDomains = getMessageSet().getVocabulary().getConceptDomains();
			List<ConceptDomain> sortedConceptDomains = new ArrayList<ConceptDomain>();
			sortedConceptDomains.addAll(conceptDomains);
			Collections.sort(sortedConceptDomains, new Comparator<ConceptDomain>() {
				@Override
				public int compare(ConceptDomain o1, ConceptDomain o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			});
			
			for (ConceptDomain conceptDomain : sortedConceptDomains) {
				Li conceptDomainListItem = new Li();
				conceptDomainListItem.setId(DomainSource.CONCEPT_DOMAIN.name() + "_" + getMessagePartName(conceptDomain.getName()) + "_li");
				conceptDomainListItem.appendChild(createLink(getConceptDomainUrl(conceptDomain.getName()), new Text(conceptDomain.getName()), "leafNode", conceptDomain.getName()));
				conceptDomainList.appendChild(conceptDomainListItem);
			}
		}
	}

	private void addValueSetLeafs(Ul valueSetList) {
		if(getMessageSet().getVocabulary() != null && getMessageSet().getVocabulary().getValueSets().size() > 0) {
			List<ValueSet> valueSets = getMessageSet().getVocabulary().getValueSets();
			List<ValueSet> sortedValueSets = new ArrayList<ValueSet>();
			sortedValueSets.addAll(valueSets);
			Collections.sort(sortedValueSets, new Comparator<ValueSet>() {
				@Override
				public int compare(ValueSet o1, ValueSet o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			});
			
			for (ValueSet valueSet : sortedValueSets) {
				Li valueSetListItem = new Li();
				valueSetListItem.setId(DomainSource.VALUE_SET.name() + "_" + getMessagePartName(valueSet.getName()) + "_li");
				valueSetListItem.appendChild(createLink(getValueSetUrl(valueSet.getName()), new Text(valueSet.getName()), "leafNode", valueSet.getName()));
				valueSetList.appendChild(valueSetListItem);
			}
		}
	}

	private void addCodeSystemLeafs(Ul codeSystemList) {
		if(getMessageSet().getVocabulary() != null && getMessageSet().getVocabulary().getCodeSystems().size() > 0) {
			List<CodeSystem> codeSystems = getMessageSet().getVocabulary().getCodeSystems();
			List<CodeSystem> sortedCodeSystems = new ArrayList<CodeSystem>();
			sortedCodeSystems.addAll(codeSystems);
			Collections.sort(sortedCodeSystems, new Comparator<CodeSystem>() {
				@Override
				public int compare(CodeSystem o1, CodeSystem o2) {
					return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
				}
				
			});
					
			for (CodeSystem codeSystem : sortedCodeSystems) {
				Li codeSystemListItem = new Li();
				codeSystemListItem.setId(DomainSource.CODE_SYSTEM.name() + "_" + getMessagePartName(codeSystem.getName()) + "_li");
				codeSystemListItem.appendChild(createLink(getCodeSystemUrl(codeSystem.getName()), new Text(codeSystem.getName()), "leafNode", codeSystem.getName()));
				codeSystemList.appendChild(codeSystemListItem);
			}
		}
	}

	private void addDatatypeLeafs(Ul datatypeList) {
		if(getDatatypeSet() != null) {
			Map<String, Datatype> datatypes = getDatatypeSet().getDatatypes();
			ArrayList<String> sortedDatatypeNames = new ArrayList<String>();
			sortedDatatypeNames.addAll(datatypes.keySet());
			Collections.sort(sortedDatatypeNames);
			
			for (String datatypeName : sortedDatatypeNames) {
				Li datatypeListItem = new Li();
				datatypeListItem.setId(getMessagePartName(datatypeName) + "_li");
				datatypeListItem.appendChild(createLink(getDatatypeUrl(datatypeName), new Text(datatypeName), "leafNode", datatypeName));
				datatypeList.appendChild(datatypeListItem);
			}
		}
	}

	private void addInteractionLeafs(Ul interactionList) {
		Map<String, Set<String>> interactionPackagePrefixMap = new HashMap<String, Set<String>>(); 
		for (String interactionName : getMessageSet().getInteractions().keySet()) {
			String interactionPackagePrefix = interactionName.split("_")[0];
			
			if (interactionPackagePrefixMap.containsKey(interactionPackagePrefix)) {
				Set<String> interactionPackageList = interactionPackagePrefixMap.get(interactionPackagePrefix);
				interactionPackageList.add(interactionName);
				interactionPackagePrefixMap.put(interactionPackagePrefix, interactionPackageList);
			} else {
				interactionPackagePrefixMap.put(interactionPackagePrefix, new HashSet<String>(Arrays.asList(interactionName)));
			}				
		}
		
		ArrayList<String> sortedInteractionPackagePrefixes = new ArrayList<String>();
		sortedInteractionPackagePrefixes.addAll(interactionPackagePrefixMap.keySet());
		Collections.sort(sortedInteractionPackagePrefixes);
		
		for (String interactionPackagePrefix : sortedInteractionPackagePrefixes) {	
			
			Li interactionPackagePrefixList = new Li();
			interactionPackagePrefixList.setId(interactionPackagePrefix + "_li_interaction");
			String packagePrefixDescription = getCategoryNames().get(interactionPackagePrefix)==null?"":getCategoryNames().get(interactionPackagePrefix);
			interactionPackagePrefixList.appendChild(createLink("#", new Text(interactionPackagePrefix + " : " + packagePrefixDescription), 
					"packagePrefixNode", interactionPackagePrefix + "_interaction"));
			Ul interactionPackagePerPrefixList = new Ul();

			ArrayList<String> sortedInteractionNames = new ArrayList<String>();
			sortedInteractionNames.addAll(interactionPackagePrefixMap.get(interactionPackagePrefix));
			Collections.sort(sortedInteractionNames);
			
			List<String> sortedInteractionsGroupByRequestResponse = groupInteractionsByRequestResponse(sortedInteractionNames);
			
			for (String interactionName : sortedInteractionsGroupByRequestResponse) {
				Interaction interaction = getMessageSet().getInteractions().get(interactionName);
				Li interactionListItem = new Li();
				interactionListItem.setId(interactionName+"_li");
				interactionListItem.appendChild(createLink(getInteractionUrl(interaction.getName()), 
						new Text(interaction.getName() + ":" + interaction.getBusinessName()), "leafNode", interaction.getName()));
				interactionPackagePerPrefixList.appendChild(interactionListItem);
			}
			
			interactionPackagePrefixList.appendChild(interactionPackagePerPrefixList);
			interactionList.appendChild(interactionPackagePrefixList);
		}
	}

	private void addPackageLeafs(Ul messagePartList) {
		Map<String, Set<String>> msgPartPackageLocationMap = new HashMap<String, Set<String>>();
		Map<String, Set<String>> msgPartPackagePrefixMap = new HashMap<String, Set<String>>(); 
		for (MessagePart messagePart : getMessageSet().getAllMessageParts()) {
			String packageName = new TypeName(messagePart.getName()).getRootName().getName();
			String packagePrefix = packageName.split("_")[0];
			
			if (msgPartPackagePrefixMap.containsKey(packagePrefix)) {
				Set<String> packageList = msgPartPackagePrefixMap.get(packagePrefix);
				packageList.add(packageName);
				msgPartPackagePrefixMap.put(packagePrefix, packageList);
			} else {
				msgPartPackagePrefixMap.put(packagePrefix, new HashSet<String>(Arrays.asList(packageName)));
			}
			
			if (msgPartPackageLocationMap.containsKey(packageName)) {
				Set<String> partList = msgPartPackageLocationMap.get(packageName);
				partList.add(messagePart.getName());
				msgPartPackageLocationMap.put(packageName, partList);
			} else {
				msgPartPackageLocationMap.put(packageName, new HashSet<String>(Arrays.asList(messagePart.getName())));
			}
		}

		ArrayList<String> sortedMsgPartPackagePrefixes = new ArrayList<String>();
		sortedMsgPartPackagePrefixes.addAll(msgPartPackagePrefixMap.keySet());
		Collections.sort(sortedMsgPartPackagePrefixes);
		
		for (String packagePrefix : sortedMsgPartPackagePrefixes) {
			Li packagePrefixList = new Li();
			packagePrefixList.setId(packagePrefix+"_li_msgPart");
			String packagePrefixDescription = getCategoryNames().get(packagePrefix)==null?"":getCategoryNames().get(packagePrefix);
			packagePrefixList.appendChild(createLink("#", new Text(packagePrefix + " : " + packagePrefixDescription), 
					"packagePrefixNode", packagePrefix+"_msgPart"));
			Ul packagePerPrefixList = new Ul();
			
			ArrayList<String> sortedPackageNames = new ArrayList<String>();
			sortedPackageNames.addAll(msgPartPackagePrefixMap.get(packagePrefix));
			Collections.sort(sortedPackageNames);
			
			for (String packageName : sortedPackageNames) {
				Li packageList = new Li();
				packageList.setId(packageName+"_li");
				String packageDescription = getMessageSet().getPackageLocation(packageName)==null?
						"":getMessageSet().getPackageLocation(packageName).getDescriptiveName();
				if (StringUtils.isNotBlank(packageDescription)) {
					packageList.appendChild(createLink(getPackageUrl(packageName), new Text(packageName + " : " + packageDescription), 
							"leafNode", packageName+"_msgPart"));
				} else {
					packageList.appendChild(createLink(getPackageUrl(packageName), new Text(packageName), 
							"leafNode", packageName+"_msgPart"));
				}
//				addPackageLevelMessagePartListItems(msgPartPackageLocationMap, packageName, packageList);
				packagePerPrefixList.appendChild(packageList);
			}
			packagePrefixList.appendChild(packagePerPrefixList);
			messagePartList.appendChild(packagePrefixList);
		}
	}

	/** Message Part per Package Tree Items **/
	@SuppressWarnings("unused")
	private void addPackageLevelMessagePartListItems(Map<String, Set<String>> msgPartPackageLocationMap,
			String packageName, Li packageList) {
		Ul messagePartPerPackageList = new Ul();
		
		Set<String> messagePartNamesSet = msgPartPackageLocationMap.get(packageName);
		ArrayList<String> sortedMessagePartNames = new ArrayList<String>();
		sortedMessagePartNames.addAll(messagePartNamesSet);
		Collections.sort(sortedMessagePartNames);
		
		for (String messagePartName : sortedMessagePartNames) {
			MessagePart messagePart = getMessageSet().getMessagePart(messagePartName);
			Li messagePartListItem = new Li();
			messagePartListItem.setId(getMessagePartName(messagePart.getName())+"_li");
			messagePartListItem.appendChild(createLink(
					getMessagePartUrl(messagePart.getName()), 
					new Text(messagePart.getName()),
					"leafNode", getMessagePartName(messagePart.getName())));
			messagePartPerPackageList.appendChild(messagePartListItem);
		}
		packageList.appendChild(messagePartPerPackageList);
	}

	/** Additionally sorting, group requests and responses together after sorting by interaction Name **/
	private List<String> groupInteractionsByRequestResponse(ArrayList<String> sortedInteractionNames) {
		List<String> result = new ArrayList<String>();
		for (String interactionName : sortedInteractionNames) {
			if (!result.contains(interactionName)) {					
				result.add(interactionName);
				Interaction interaction = getMessageSet().getInteractions().get(interactionName);
				if (interaction.getReceiverResponsibilities().size() > 0) {
					for (ReceiverResponsibility receiver : interaction.getReceiverResponsibilities()) {
						if (!result.contains(receiver.getInvokeInteraction())) {
							result.add(receiver.getInvokeInteraction());
						}
					}
				}
			}
		}
		return result;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public Map<String, String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(Map<String, String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public DatatypeSet getDatatypeSet() {
		return datatypeSet;
	}

	public void setDatatypeSet(DatatypeSet datatypeSet) {
		this.datatypeSet = datatypeSet;
	}
}
