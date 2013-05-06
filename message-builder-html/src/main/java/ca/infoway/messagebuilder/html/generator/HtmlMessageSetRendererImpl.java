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

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DEFAULT_RESOURCE_PATH;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.ValueSet;

public class HtmlMessageSetRendererImpl implements HtmlMessageSetRenderer{	
	private static final String[] STATIC_RESOURCE_FILES = {
		"js/jquery-1.7.2.js", "js/jquery.jstree.js", "js/jquery-ui-1.8.21.custom.min.js",
		"js/themes/default/d.gif", "js/themes/default/d.png", "js/themes/default/style.css", 
		"css/jquery-ui-1.8.21.custom.css", "js/themes/default/throbber.gif", "mystyle.css", 
		"images/top_banner.png", "images/top_banner_ext.png", "images/footer-global.png"}; 

	
	private String interactionsPath;
	private String packagesPath;
	private String javascriptPath;
	private String resourcesPath;
	private Boolean excludeStructuralAttributes;
	
	public HtmlMessageSetRendererImpl() {
		this.interactionsPath = "../interactions";
		this.packagesPath = "../packages";
		this.resourcesPath = "../resources";
		this.javascriptPath = "../resources/js";
		this.excludeStructuralAttributes = false;
	}
	
	public HtmlMessageSetRendererImpl(String interactionsPath, String messagePartsPath, String resourcesPath, String javascriptPath) {
		this.interactionsPath = interactionsPath;
		this.packagesPath = messagePartsPath;
		this.javascriptPath = javascriptPath;
		this.resourcesPath = resourcesPath;
		this.excludeStructuralAttributes = false;
	}
	
	public HtmlMessageSetRendererImpl(String interactionsPath, String messagePartsPath, String resourcesPath, String javascriptPath, Boolean excludeStructuralAttributes) {
		this.interactionsPath = interactionsPath;
		this.packagesPath = messagePartsPath;
		this.javascriptPath = javascriptPath;
		this.resourcesPath = resourcesPath;
		this.excludeStructuralAttributes = excludeStructuralAttributes;
	}
		
	/** Interaction Section **/
	@Override
	public String writeInteraction(Interaction interaction, MessageSet messageSet) {
		InteractionHtml interactionHtml = new InteractionHtml(interaction, messageSet);
		
		return interactionHtml.write();
	}

	/** PackageLocation Section **/
	@Override
	public String writePackageLocation(PackageLocation packageLocation, MessageSet messageSet) {
		PackageLocationHtml packageHtml = new PackageLocationHtml(packageLocation, messageSet, getExcludeStructuralAttributes());
		
		return packageHtml.write();
	}
	
	@Override
	public String writePackageLocation(PackageLocation packageLocation, MessageSet messageSet, Boolean excludeStructuralAttributes) {
		PackageLocationHtml packageHtml = new PackageLocationHtml(packageLocation, messageSet, excludeStructuralAttributes);
		
		return packageHtml.write();
	}
	
	
	/** Message Part Section **/
	@Override
	public String writeMessagePart(MessagePart messagePart, MessageSet messageSet) {
		MessagePartHtml messagePartHtml = new MessagePartHtml(messagePart, messageSet, getExcludeStructuralAttributes());
		
		return messagePartHtml.write();
	}
	
	/** Value Set Section **/
	@Override
	public String writeValueSet(ValueSet valueSet, MessageSet messageSet) {
		ValueSetHtml valueSetHtml = new ValueSetHtml(valueSet, messageSet);
		
		return valueSetHtml.write();
	}
	
	/** Concept Domain Section **/
	@Override
	public String writeConceptDomain(ConceptDomain conceptDomain, MessageSet messageSet) {
		ConceptDomainHtml conceptDomainHtml = new ConceptDomainHtml(conceptDomain, messageSet);
		
		return conceptDomainHtml.write();
	}

	/** Datatype Section **/
	@Override
	public String writeDatatype(Datatype datatype, DatatypeSet datatypeSet, MessageSet messageSet) {
		DatatypeHtml datatypeHtml = new DatatypeHtml(datatype, datatypeSet, messageSet);
		
		return datatypeHtml.write();
	}
	
	/** Side Nav Bar **/
	@Override
	public String writeSideNavBarScript(MessageSet messageSet, Map<String, String> categoryNames) {
		NavBarScriptJSGenerator navBar = new NavBarScriptJSGenerator(messageSet, categoryNames);
		
		return navBar.write();
	}
	
	/** Start Pages **/
	@Override
	public String writeOuterStartFile(String pathToIndexPage, String indexFileName) {
		StartPageRedirectHtml startPageRedirect = new StartPageRedirectHtml(indexFileName, pathToIndexPage);
		
		return startPageRedirect.write();
	}

	@Override
	public String writeInnerStartFile(MessageSet messageSet) {
		StartPageHtml startPage = new StartPageHtml(messageSet);
		return startPage.write();
	}
	
	
	/** Common Section **/
	@Override
	public Map<String, InputStream> getStaticResourceFiles() {
		Map<String, InputStream> result = new HashMap<String, InputStream>();
		for (String fileName : STATIC_RESOURCE_FILES) {
			InputStream resourceAsStream = getClass().getResourceAsStream(DEFAULT_RESOURCE_PATH + "/" + fileName);
			result.put(fileName, resourceAsStream);
		}
		return result;
	}
	
	/** Config Setters/Getters **/
	@Override
	public Boolean getExcludeStructuralAttributes() {
		return excludeStructuralAttributes;
	}
	@Override
	public void setExcludeStructuralAttributes(
			Boolean excludeStructuralAttributes) {
		this.excludeStructuralAttributes = excludeStructuralAttributes;
	}

	@Override
	public void setJavascriptPath(String javascriptPath) {
		this.javascriptPath = javascriptPath;
	}
	@Override
	public String getJavascriptPath() {
		return javascriptPath;
	}

	@Override
	public void setPackagesPath(String packagesPath) {
		this.packagesPath = packagesPath;
	}
	@Override
	public String getPackagesPath() {
		return this.packagesPath;
	}

	@Override
	public void setInteractionsPath(String interactionsPath) {
		this.interactionsPath = interactionsPath;
	}
	@Override
	public String getInteractionsPath() {
		return this.interactionsPath;
	}

	@Override
	public void setResourcesPath(String resourcesPath) {
		this.resourcesPath = resourcesPath;
	}
	@Override
	public String getResourcesPath() {
		return this.resourcesPath;
	}
}
