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

package ca.infoway.messagebuilder.generator.lang;

import java.io.File;
import java.io.IOException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

public class IntermediateToXsdGenerator extends IntermediateToModelGenerator {
	
	public IntermediateToXsdGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, boolean isR2, boolean isCda) {
		this(outputUI, sourceFolder, basePackageName, null, isR2, isCda);
	}
	public IntermediateToXsdGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report, boolean isR2, boolean isCda) {
		this(outputUI, new IntermediateToModelConfiguration(sourceFolder, basePackageName, report, null, isR2, isCda));
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
	protected DefinitionToResultConverter getDefinitionToResultConverter(SimplifiableDefinitions definitions, boolean isR2, boolean isCda) {
		return new XsdDefinitionToResultConverter(definitions, this.basePackageName, getProgrammingLanguage(), this.outputUI, getNamingPolicy(), isR2, isCda);
	}
	@Override
	protected void writeDomainInterfaces() throws IOException, GeneratorException {
	}
}
