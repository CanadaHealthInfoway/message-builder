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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;
import static ca.infoway.messagebuilder.generator.LogLevel.WARN;
import static org.apache.commons.io.FilenameUtils.getExtension;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.generator.maven.FileSet;
import ca.infoway.messagebuilder.j5goodies.ManifestReader;
import ca.infoway.messagebuilder.xml.MessageSet;

public class MifToXmlGenerator implements MessageSetGenerator {
	
	private final OutputUI outputUI;
	private MessageSet messageSet = new MessageSet();
	private MifProcessor processor;
	private MifRegistry mifRegistry;
	private MessageSetWriter messageSetWriter;
	private final File reportDir;

	public MifToXmlGenerator(OutputUI outputUI, String version, File mifTransform, File reportDir) throws GeneratorException {
		this.outputUI = outputUI;
		this.reportDir = reportDir;
		this.mifRegistry = new MifRegistry(mifTransform, outputUI);
		this.messageSet.setVersion(version);
		
		String projectVersion;
		try {
			Manifest manifest = ManifestReader.read(getClass());
			Attributes attributes = manifest.getMainAttributes();
			projectVersion = attributes.getValue("Implementation-Version");
		} catch(IOException e) {
			projectVersion = "unknown version";
		}
		this.messageSet.setGeneratedBy(projectVersion);
		
		this.messageSetWriter = new MessageSetWriter(this.messageSet, this.outputUI);
	}
	
	
	MifProcessor getMifProcessor() throws GeneratorException {
		if (this.processor != null) {
		} else if (this.mifRegistry.isMif1()) {
			this.processor = new Mif1Processor(this.mifRegistry, this.outputUI);
		} else if (this.mifRegistry.isMif2()) {
			this.processor = new Mif2Processor(this.mifRegistry, this.outputUI);
		} else {
			throw new GeneratorException("Cannot determine the MIF processor type.  Are the MIF files valid?");
		}
		return this.processor;
	}

	public void processAllMifs(MifSource mifSource) throws GeneratorException, IOException {
		initializeVersionAndProcessEachFile(mifSource.getAllMifs());
	}	


	void initializeVersionAndProcessEachFile(List<MifReference> allMifs) throws IOException, GeneratorException {
		if (!CollectionUtils.isEmpty(allMifs)) {
			initializeMifVersionInformation(allMifs);
			processAllMifs(allMifs);
		} else {
			this.outputUI.log(WARN, "No .mif files were found in the directory.");
		}
	}

	/**
	 * <p>Determine the version information of the MIFs being processed.
	 * <p>By reading in one of the MIF files, we can inspect what MIF version is being
	 * used.
	 * 
	 * @param allMifs - the list of all MIF files being processed.
	 * @throws IOException
	 * @throws GeneratorException
	 */
	void initializeMifVersionInformation(List<MifReference> allMifs) throws IOException, GeneratorException {
		this.mifRegistry.getMif(getFirstMifFile(allMifs));
		this.outputUI.log(INFO, "Processing MIF files using schema version " + this.mifRegistry.getMifVersion());
	}


	MifReference getFirstMifFile(List<MifReference> allMifs) {
		MifReference result = null;
		for (MifReference reference : allMifs) {
			if (equalsIgnoreCase("mif", getExtension(reference.asFile().getName())) 
					&& !isInteraction(reference)) {
				result = reference;
				break;
			}
		}
		return result;
	}
	
	private boolean isInteraction(MifReference reference) {
		return PackageLocationDeriver.derive(reference.asFile()).isInteraction();
	}

	public void processAllMifs(List<MifReference> mifs) throws GeneratorException, IOException {
		this.outputUI.log(INFO, "Now processing " + CollectionUtils.size(mifs) + " MIF files.");
		try {
			getMifProcessor().addMessagePartsFromMifs(this.messageSet, mifs);
		} catch (XPathExpressionException e) {
			throw new GeneratorException(e);
		}
	}
	
	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException {
		this.messageSetWriter.writeToMessageSet(outputFile);
	}

	public void processAllMessageSets(List<FileSet> inputMessageSets) throws GeneratorException, IOException {
		throw new UnsupportedOperationException("Must use processAllMifs() method instead.");
	}

}
