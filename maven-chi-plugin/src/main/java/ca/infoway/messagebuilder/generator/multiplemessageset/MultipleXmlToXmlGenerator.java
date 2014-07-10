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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.FileSet;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;
import ca.infoway.messagebuilder.generator.MessageSetWriter;
import ca.infoway.messagebuilder.generator.MifSource;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.lang.ExciseReportGenerator;
import ca.infoway.messagebuilder.generator.lang.ExcisedItem;
import ca.infoway.messagebuilder.generator.lang.Exciser;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

public class MultipleXmlToXmlGenerator implements MessageSetGenerator {

	static final String MESSAGE_SET_MERGE_COMPLETED = "Message set merge completed";

	private static final int MAX_MESSAGE_SETS_ALLOWED_FOR_MERGE = 2;
	
	private MessageSetMarshaller messageSetMarshaller;
	private OutputUI outputUI;
	private MessageSetWriter messageSetWriter;
	private final String version;
	private final TemplateParameterNameRenamer templateParameterNameRenamer;

	private final File reportDir;
	
	public MultipleXmlToXmlGenerator(OutputUI outputUI, String version, File reportDir) {
		this(outputUI, version, new MessageSetMarshaller(), null, new TemplateParameterNameRenamer(), reportDir);
	}
	
	protected MultipleXmlToXmlGenerator(OutputUI outputUI, String version, MessageSetMarshaller messageSetMarshaller, 
			MessageSetWriter messageSetWriter, TemplateParameterNameRenamer templateParameterNameRenamer, File reportDir) {
		this.outputUI = outputUI;
		this.version = version;
		this.messageSetMarshaller = messageSetMarshaller;
		this.messageSetWriter = messageSetWriter;
		this.templateParameterNameRenamer = templateParameterNameRenamer;
		this.reportDir = reportDir;
	}

	public void processAllMessageSets(List<FileSet> inputMessageSets) throws GeneratorException, IOException {
		int size = CollectionUtils.size(inputMessageSets);
		if (size > MAX_MESSAGE_SETS_ALLOWED_FOR_MERGE) {
			this.outputUI.log(LogLevel.WARN, "Message set merge currently only supports merging two message sets");
		} else if (size < 2) {
			this.outputUI.log(LogLevel.WARN, "Message set merge requires at least two message sets as input");
		} else {
			String primaryVersion = inputMessageSets.get(0).getName();
			String secondaryVersion = inputMessageSets.get(1).getName();
			MergeContext mergeContext = new MergeContextImpl(this.outputUI, primaryVersion, secondaryVersion);
			
			MessageSet primaryMessageSet = convertFileToMessageSet(inputMessageSets.get(0).getDirectory());
			MessageSet secondaryMessageSet = convertFileToMessageSet(inputMessageSets.get(1).getDirectory());
			renameTemplateParameterNames(primaryMessageSet, secondaryMessageSet);
			MessageSet mergedMessageSet = mergeMessageSets(mergeContext, primaryMessageSet, secondaryMessageSet);
			
			createMergeReport(mergedMessageSet, new File(SystemUtils.getJavaIoTmpDir(),
					"generatorMergeReport.xls"));
			
			Set<ExcisedItem> excisedItems = exciseUnmatchedItems(mergedMessageSet);
			
			createExciseReport(excisedItems, new File(SystemUtils.getJavaIoTmpDir(),
					"generatorExciseReport_firstPass.xls"));
			
			this.outputUI.log(LogLevel.INFO, MESSAGE_SET_MERGE_COMPLETED);
		}
	}
	
	private void renameTemplateParameterNames(MessageSet... messageSets) {
		this.templateParameterNameRenamer.renameTemplateParameterNames(messageSets);
	}

	private void createExciseReport(Set<ExcisedItem> excisedItems, File reportFile) throws IOException {
		new ExciseReportGenerator(excisedItems, reportFile).create();
	}

	private Set<ExcisedItem> exciseUnmatchedItems(MessageSet messageSet) {
		return new Exciser(messageSet, new PreMergeEvaluator()).execute();
	}

	private void createMergeReport(MessageSet messageSet, File reportFile) throws IOException {
		new MergeReportGenerator(messageSet, reportFile).create();
	}

	private MessageSet mergeMessageSets(MergeContext mergeContext, MessageSet primaryMessageSet, MessageSet secondaryMessageSet) {
		MessageSet result = new MessageSetMerger(mergeContext).merge(primaryMessageSet, secondaryMessageSet);
		result.setVersion(this.version);
		if (this.messageSetWriter == null) {
			this.messageSetWriter = new MessageSetWriter(result, this.outputUI);
		}
		return result;
	}

	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException {
		this.messageSetWriter.writeToMessageSet(outputFile);
	}

	public MessageSet processAllMifs(MifSource mifSource) throws GeneratorException, IOException {
		throw new UnsupportedOperationException("Must use processAllMessageSets() method instead.");
	}
	
	private MessageSet convertFileToMessageSet(File file) throws GeneratorException {
		try {
			return this.messageSetMarshaller.unmarshall(file);
		} catch (Exception e) {
			String filename = (file == null ? "null file" : file.getName());
			throw new GeneratorException("Exception trying to unmarshall input XML messageset:" + filename, e);
		}
	}

}
