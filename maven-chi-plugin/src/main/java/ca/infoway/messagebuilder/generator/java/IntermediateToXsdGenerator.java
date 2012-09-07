/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.java;

import java.io.File;
import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class IntermediateToXsdGenerator extends IntermediateToModelGenerator {
	
	public IntermediateToXsdGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToXsdGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report) {
		this(outputUI, new IntermediateToModelConfiguration(sourceFolder, basePackageName, report, null));
	}
	public IntermediateToXsdGenerator(OutputUI outputUI, IntermediateToModelConfiguration configuration) {
		super(outputUI, configuration);
	}

	protected void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException {
		XsdNameTranslator translator = new XsdNameTranslator(this.basePackageName, result);
		XsdSourceFileWriterProvider writerProvider = new XsdSourceFileWriterProvider(this.sourceFolder, translator);
		new XsdTypeWriter(this.outputUI, writerProvider, translator, result, getNamingPolicy()).writeTypes();
	}
	@Override
	protected ProgrammingLanguage getProgrammingLanguage() {
		return null;
	}
	@Override
	protected DefinitionToResultConverter getDefinitionToResultConverter(SimplifiableDefinitions definitions) {
		return new XsdDefinitionToResultConverter(definitions, this.basePackageName, getProgrammingLanguage(), this.outputUI, getNamingPolicy());
	}
	@Override
	protected void writeDomainInterfaces() throws IOException, GeneratorException {
	}
}
