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
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import ca.infoway.demiftifier.Layout;
import ca.infoway.demiftifier.layout.LayerOuter;
import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class SvgGenerator {

	private final LogUI logUI;

	public SvgGenerator(LogUI logUI) {
		this.logUI = logUI;
	}

	public void execute(MessageSet messageSet, File svgFolder) throws IOException {
		int count = 0;
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			this.logUI.log(LogLevel.DEBUG, "Now processing package location " + packageLocation.getName());
			File svgFile = createSvgFile(packageLocation, svgFolder);
			FileWriter writer = new FileWriter(svgFile);
			try {
				Layout layout = new LayerOuter().layout(messageSet, packageLocation.getName());
				new Svgifier().render(layout, writer);
			} finally {
				IOUtils.closeQuietly(writer);
			}
			count++;
		}
		this.logUI.log(LogLevel.INFO, "" + count + " SVG files generated for message set " + messageSet.getVersion());
	}

	private File createSvgFile(PackageLocation packageLocation, File svgFolder) {
		return new File(svgFolder, packageLocation.getName() + ".svg");
	}
}
