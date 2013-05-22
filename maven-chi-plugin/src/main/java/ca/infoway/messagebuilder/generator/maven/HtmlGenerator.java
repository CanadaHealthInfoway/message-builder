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
package ca.infoway.messagebuilder.generator.maven;

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.DEFAULT_DATATYPE_FILE_PREFIX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.datatype.model.DatatypeSetMarshaller;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault;
import ca.infoway.messagebuilder.html.generator.HtmlMessageSetRendererImpl;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.Vocabulary;

public class HtmlGenerator {
	private final LogUI logUI;

	public HtmlGenerator(LogUI logUI) {
		this.logUI = logUI;
	}

	public void execute(MessageSet messageSet, DatatypeSet inputDatatypeSet, File htmlFolder, Boolean excludeStructuralAttributes) throws IOException {
		int count = 0;
		
		Boolean excludeStrucAttrFlag = false;
		if (excludeStructuralAttributes != null) {
			excludeStrucAttrFlag = excludeStructuralAttributes;
		}
		
		DatatypeSet datatypeSet = null;
		if (inputDatatypeSet == null) {
			this.logUI.log(LogLevel.DEBUG, "Unable to determine datatypeSet");
			datatypeSet = getDefaultDatatypeSet(messageSet);
		} else {
			datatypeSet = inputDatatypeSet;
		}
		
		File resourcesFolder = createResourceFolderStructure(htmlFolder);
		
		count += writeStaticResources(resourcesFolder);
		
		count += writeNavBar(messageSet, datatypeSet, resourcesFolder);
		
		if (datatypeSet != null) {
			count += writeDatatypeFiles(messageSet, htmlFolder, datatypeSet);
		} else {
			this.logUI.log(LogLevel.DEBUG, "No DatatypeSet Detected: skipping step");
		}
		
		count += writePackageLocationFiles(messageSet, htmlFolder, excludeStrucAttrFlag, datatypeSet);
		
		count += writeInteractionFiles(messageSet, htmlFolder);
		
		count += writeStartPages(messageSet, htmlFolder);
		
		Vocabulary vocabulary = messageSet.getVocabulary();
		if (vocabulary != null) {
			count += writeConceptDomains(messageSet, htmlFolder, vocabulary);
			
			count += writeValueSets(messageSet, htmlFolder, vocabulary);
			
			count += writeCodeSystem(messageSet, htmlFolder, vocabulary);
		} else {
			this.logUI.log(LogLevel.DEBUG, "No Vocabulary Detected: skipping step");
		}
		
		this.logUI.log(LogLevel.INFO, "" + count + " Html files generated for message set " + messageSet.getVersion());
		
	}

	protected int writeCodeSystem(MessageSet messageSet, File htmlFolder, Vocabulary vocabulary) throws IOException {
		int count = 0;
		File codeSystemFolder = new File(htmlFolder, "codeSystems");
		if (!codeSystemFolder.exists() || !codeSystemFolder.isDirectory()) {
			new File(htmlFolder, "codeSystems").mkdir();
		}
		for (CodeSystem codeSystem : vocabulary.getCodeSystems()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing code system " + codeSystem.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(codeSystemFolder, htmlRenderer.getFileName(codeSystem, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writeCodeSystem(codeSystem, messageSet));
				count++;
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	protected int writeValueSets(MessageSet messageSet, File htmlFolder, Vocabulary vocabulary) throws IOException {
		int count = 0;
		File valueSetFolder = new File(htmlFolder, "valueSets");
		if (!valueSetFolder.exists() || !valueSetFolder.isDirectory()) {
			new File(htmlFolder, "valueSets").mkdir();
		}
		for (ValueSet valueSet : vocabulary.getValueSets()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing value set " + valueSet.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(valueSetFolder, htmlRenderer.getFileName(valueSet, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writeValueSet(valueSet, messageSet));
				count++;
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	protected int writeConceptDomains(MessageSet messageSet, File htmlFolder, Vocabulary vocabulary) throws IOException {
		int count = 0;
		File conceptDomainFolder = new File(htmlFolder, "conceptDomains");
		if (!conceptDomainFolder.exists() || !conceptDomainFolder.isDirectory()) {
			new File(htmlFolder, "conceptDomains").mkdir();
		}
		for (ConceptDomain conceptDomain : vocabulary.getConceptDomains()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing concept domain " + conceptDomain.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(conceptDomainFolder, htmlRenderer.getFileName(conceptDomain, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writeConceptDomain(conceptDomain, messageSet));
				count++;
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	protected int writeInteractionFiles(MessageSet messageSet, File htmlFolder) throws IOException {
		int count = 0;
		File interactionFolder = new File(htmlFolder, "interactions");
		if (!interactionFolder.exists() || !interactionFolder.isDirectory()) {
			new File(htmlFolder, "interactions").mkdir();
		}
		for (Interaction interaction : messageSet.getInteractions().values()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing interaction " + interaction.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(interactionFolder, htmlRenderer.getFileName(interaction, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writeInteraction(interaction, messageSet));
				count++;			
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	protected int writePackageLocationFiles(MessageSet messageSet, File htmlFolder, Boolean excludeStrucAttrFlag, DatatypeSet datatypeSet)
			throws IOException {
		int count = 0;
		File packageFolder = new File(htmlFolder, "packages");
		if (!packageFolder.exists() || !packageFolder.isDirectory()) {
			new File(htmlFolder, "packages").mkdir();
		}
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing package location " + packageLocation.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(packageFolder, htmlRenderer.getFileName(packageLocation, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writePackageLocation(packageLocation, messageSet, datatypeSet, excludeStrucAttrFlag));
				count++;
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	protected int writeDatatypeFiles(MessageSet messageSet, File htmlFolder, DatatypeSet datatypeSet) throws IOException {
		int count = 0;
		File datatypeFolder = new File(htmlFolder, "datatypes");
		if (!datatypeFolder.exists() || !datatypeFolder.isDirectory()) {
			new File(htmlFolder, "datatypes").mkdir();
		}
		
		for (Datatype datatype : datatypeSet.getAllDatatypes()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing datatype " + datatype.getName());
			HtmlMessageSetRendererImpl htmlRenderer = new HtmlMessageSetRendererImpl();
			File htmlFile = new File(datatypeFolder, htmlRenderer.getFileName(datatype, messageSet));
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(htmlRenderer.writeDatatype(datatype, datatypeSet, messageSet));
				count++;
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
		return count;
	}

	private DatatypeSet getDefaultDatatypeSet(MessageSet messageSet) throws IOException {
		String datatypeVersion = getDatatypeVersions(messageSet);
		if (datatypeVersion != null) {
			this.logUI.log(LogLevel.DEBUG, "Now datatypeSet filename: " + datatypeVersion);
			Map<String, InputStream> staticDatatypeFilesMap = new HtmlMessageSetRendererImpl().getStaticDatatypeFiles(datatypeVersion);
			InputStream datatypeSetInputStream = staticDatatypeFilesMap.get(DEFAULT_DATATYPE_FILE_PREFIX + "_" + datatypeVersion + ".xml");
			if (datatypeSetInputStream != null) {
				DatatypeSet defaultDatatypeSet = new DatatypeSetMarshaller().unmarshallDatatypeModel(datatypeSetInputStream);
				return defaultDatatypeSet;
			}
		}
		return null;
	}

	private String getDatatypeVersions(MessageSet messageSet) {
		Map<String, PackageLocation> packageLocations = messageSet.getPackageLocations();
		for (String packageLocationName : packageLocations.keySet()) {
			PackageLocation packageLocation = packageLocations.get(packageLocationName);
			if (packageLocation.getDatatypeModel() != null 
					&& packageLocation.getDatatypeModel().getVersion() != null) {
				
				String result = packageLocation.getDatatypeModel().getVersion() + "_" + packageLocation.getDatatypeModel().getRealm();
				return result.replaceAll("[.]", "_");
			}
		}
		return null;
	}
	
	protected int writeStaticResources(File resourcesFolder)
			throws FileNotFoundException, IOException {
		int count = 0;
		Map<String, InputStream> staticResourceFiles = new HtmlMessageSetRendererImpl().getStaticResourceFiles();
		for (String filePath : staticResourceFiles.keySet()) {
			InputStream inputStream = staticResourceFiles.get(filePath);
			this.logUI.log(LogLevel.DEBUG, "Now processing package location " + filePath);
			File resourceFile = new File(resourcesFolder, filePath);
			FileOutputStream outputStream = new FileOutputStream(resourceFile);
			try {
				int c;
				while( (c= inputStream.read()) != -1 ) {
					outputStream.write(c);
				}
				count++;
			} finally {
				IOUtils.closeQuietly(outputStream);
				IOUtils.closeQuietly(inputStream);
			}
		}
		return count;
	}

	protected int writeStartPages(MessageSet messageSet, File htmlFolder)
			throws IOException {
		int count = 0;
		this.logUI.log(LogLevel.DEBUG, "Now processing index page");
		File indexPage = new File(htmlFolder, "/packages/index.html");
		FileWriter writer = new FileWriter(indexPage);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeInnerStartFile(messageSet));
			count++;
		} finally {
			IOUtils.closeQuietly(writer);
		}
		
		this.logUI.log(LogLevel.DEBUG, "Now processing start page");
		File startFile = new File(htmlFolder, "start.html");
		writer = new FileWriter(startFile);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeOuterStartFile("./packages", "index.html"));
			count++;
		} finally {
			IOUtils.closeQuietly(writer);
		}
		
		return count;
	}

	protected int writeNavBar(MessageSet messageSet, DatatypeSet datatypeSet, File resourcesFolder)
			throws IOException {
		int count = 0;
		this.logUI.log(LogLevel.DEBUG, "Now processing package location mainNavBar.js");
		File htmlFile = new File(resourcesFolder, "/js/" + HtmlMessageSetRenderDefault.NAV_BAR_SCRIPT_NAME);
		FileWriter writer = new FileWriter(htmlFile);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeSideNavBarScript(
					messageSet, datatypeSet, HtmlMessageSetRenderDefault.DOMAIN_DESCRIPTIONS));
			count++;
		} finally {
			IOUtils.closeQuietly(writer);
		}
		return count;
	}

	private File createResourceFolderStructure(File htmlFolder) {
		File resourcesFolder = new File(htmlFolder, "resources");
		if (!resourcesFolder.exists() || !resourcesFolder.isDirectory()) {
			new File(htmlFolder, "resources").mkdir();
		}
		File imagesFolder = new File(resourcesFolder, "images");
		if (!imagesFolder.exists() || !imagesFolder.isDirectory()) {
			new File(resourcesFolder, "images").mkdir();
		}		
		File jsFolder = new File(resourcesFolder, "js");
		if (!jsFolder.exists() || !jsFolder.isDirectory()) {
			new File(resourcesFolder, "js").mkdir();
		}
		File cssFolder = new File(resourcesFolder, "css");
		if (!cssFolder.exists() || !cssFolder.isDirectory()) {
			new File(resourcesFolder, "css").mkdir();
		}
		File themesFolder = new File(jsFolder, "themes");
		if (!themesFolder.exists() || !themesFolder.isDirectory()) {
			new File(jsFolder, "themes").mkdir();
		}
		File defaultThemeFolder = new File(themesFolder, "default");
		if (!defaultThemeFolder.exists() || !defaultThemeFolder.isDirectory()) {
			new File(themesFolder, "default").mkdir();
		}
		return resourcesFolder;
	}
}
