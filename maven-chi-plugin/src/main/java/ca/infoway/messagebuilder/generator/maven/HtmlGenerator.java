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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault;
import ca.infoway.messagebuilder.html.generator.HtmlMessageSetRendererImpl;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class HtmlGenerator {
	private final LogUI logUI;

	public HtmlGenerator(LogUI logUI) {
		this.logUI = logUI;
	}

	public void execute(MessageSet messageSet, File htmlFolder, Boolean excludeStructuralAttributes) throws IOException {
		int count = 0;
		
		Boolean excludeStrucAttrFlag = false;
		if (excludeStructuralAttributes != null) {
			excludeStrucAttrFlag = excludeStructuralAttributes;
		}
		
		File resourcesFolder = createResourceFolderStructure(htmlFolder);
		
		addStaticResources(resourcesFolder);
		
		addNavBar(messageSet, resourcesFolder);
		count++;
		
		File interactionFolder = new File(htmlFolder, "interactions");
		if (!interactionFolder.exists() || !interactionFolder.isDirectory()) {
			new File(htmlFolder, "interactions").mkdir();
		}
		for (Interaction interaction : messageSet.getInteractions().values()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing package location " + interaction.getName());
			File htmlFile = createHtmlFile(interaction, interactionFolder);
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(new HtmlMessageSetRendererImpl().writeInteraction(interaction, messageSet));
			} finally {
				IOUtils.closeQuietly(writer);
			}
			count++;			
		}
		
		File packageFolder = new File(htmlFolder, "packages");
		if (!packageFolder.exists() || !packageFolder.isDirectory()) {
			new File(htmlFolder, "packages").mkdir();
		}
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing package location " + packageLocation.getName());
			File htmlFile = createHtmlFile(packageLocation, packageFolder);
			FileWriter writer = new FileWriter(htmlFile);
			try {
				writer.write(new HtmlMessageSetRendererImpl().writePackageLocation(packageLocation, messageSet, excludeStrucAttrFlag));
			} finally {
				IOUtils.closeQuietly(writer);
			}
			count++;
		}
		
		addStartPages(messageSet, htmlFolder);
		count+=2;
		
		this.logUI.log(LogLevel.INFO, "" + count + " Html files generated for message set " + messageSet.getVersion());
		
	}

	private void addStaticResources(File resourcesFolder)
			throws FileNotFoundException, IOException {
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
			} finally {
				IOUtils.closeQuietly(outputStream);
				IOUtils.closeQuietly(inputStream);
			}
		}
	}

	private void addStartPages(MessageSet messageSet, File htmlFolder)
			throws IOException {
		
		this.logUI.log(LogLevel.DEBUG, "Now processing index page");
		File indexPage = new File(htmlFolder, "/packages/index.html");
		FileWriter writer = new FileWriter(indexPage);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeInnerStartFile(messageSet));
		} finally {
			IOUtils.closeQuietly(writer);
		}
		
		this.logUI.log(LogLevel.DEBUG, "Now processing start page");
		File startFile = new File(htmlFolder, "start.html");
		writer = new FileWriter(startFile);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeOuterStartFile("./packages", "index.html"));
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}

	private void addNavBar(MessageSet messageSet, File resourcesFolder)
			throws IOException {
		this.logUI.log(LogLevel.DEBUG, "Now processing package location mainNavBar.js");
		File htmlFile = new File(resourcesFolder, "/js/" + HtmlMessageSetRenderDefault.NAV_BAR_SCRIPT_NAME);
		FileWriter writer = new FileWriter(htmlFile);
		try {
			writer.write(new HtmlMessageSetRendererImpl().writeSideNavBarScript(
					messageSet, HtmlMessageSetRenderDefault.DOMAIN_DESCRIPTIONS));
		} finally {
			IOUtils.closeQuietly(writer);
		}
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

	private File createHtmlFile(PackageLocation packageLocation, File htmlFolder) {
		return new File(htmlFolder, packageLocation.getName() + ".html");
	}
	
	private File createHtmlFile(Interaction interaction, File htmlFolder) {
		return new File(htmlFolder, interaction.getName() + ".html");
	}
}
