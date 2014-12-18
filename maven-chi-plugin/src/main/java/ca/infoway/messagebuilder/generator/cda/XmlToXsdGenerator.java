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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator.cda;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.template.ValueSetDefinition;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class XmlToXsdGenerator {

	private final OutputUI outputUI;
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private File xsdSourceFolder;
	
	public XmlToXsdGenerator(OutputUIImpl outputUI, File xsdSourceFolder) {
		this.outputUI = outputUI;
		this.xsdSourceFolder = xsdSourceFolder;
	}

	public void generateAllSchemaFiles(MessageSet messageSet, File vocabularyFile) throws GeneratorException, IOException {
		try {
			this.outputUI.log(INFO, "Parsing input files.");
			
			ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, vocabularyFile);
			
			this.outputUI.log(INFO, "Generating base model.");
			CdaXsdFormatter cdaXsdFormatter = new CdaXsdFormatter(outputUI, valueSetDefinition);
			for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
				if (StringUtils.isNotBlank(packageLocation.getTemplateOid())) {
					File outputFile = new File(this.xsdSourceFolder, packageLocation.getName() + ".xsd");
					Schema schema = new Schema();
					cdaXsdFormatter.formatSchema(schema, messageSet, packageLocation.getName());
					serializer.write(schema, outputFile);
				}
			}
		} catch (Exception e) {
			throw new GeneratorException(e);
		}
	}
}
