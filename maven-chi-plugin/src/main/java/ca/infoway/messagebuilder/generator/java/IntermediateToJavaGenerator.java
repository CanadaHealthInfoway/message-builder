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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;

import java.io.File;
import java.io.IOException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.DomainTypeWriter;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.lang.Case3Simplifier;
import ca.infoway.messagebuilder.generator.lang.IntermediateToModelConfiguration;
import ca.infoway.messagebuilder.generator.lang.IntermediateToModelGenerator;
import ca.infoway.messagebuilder.generator.lang.SimpleNameTranslator;
import ca.infoway.messagebuilder.generator.lang.SimplifiableDefinitions;
import ca.infoway.messagebuilder.generator.lang.TypeAnalysisResult;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

public class IntermediateToJavaGenerator extends IntermediateToModelGenerator {
	
	public IntermediateToJavaGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, boolean isR2) {
		this(outputUI, new IntermediateToModelConfiguration(sourceFolder, basePackageName, null, null, isR2));
	}
	public IntermediateToJavaGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File reportDir, boolean isR2) {
		super(outputUI, new IntermediateToModelConfiguration(sourceFolder, basePackageName, reportDir, null, isR2));
	}
	public IntermediateToJavaGenerator(OutputUI outputUI, IntermediateToModelConfiguration configuration) {
		super(outputUI, configuration);
	}
	
	/**
	 * <p>Apply simplification algorithms.
	 * 
	 * <p>The Case 3 algorithm only applies to Java and .Net. 
	 */
	@Override
	public void simplify(SimplifiableDefinitions definitions) throws GeneratorException {
		new Case3Simplifier(this.outputUI, definitions).execute();
		super.simplify(definitions);
	}
	
	@Override
	protected void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException {
		SimpleNameTranslator translator = new SimpleNameTranslator(JAVA, this.basePackageName, result, getNamingPolicy());
		JavaSourceFileWriterProvider writerProvider = new JavaSourceFileWriterProvider(this.sourceFolder, translator);
		new JavaTypeWriter(this.outputUI, writerProvider, translator, result, getNamingPolicy()).writeTypes();
	}
	@Override
	protected ProgrammingLanguage getProgrammingLanguage() {
		return ProgrammingLanguage.JAVA;
	}
	@Override
	protected void writeDomainInterfaces() throws IOException, GeneratorException {
		new DomainTypeWriter(this.outputUI, this.sourceFolder, JavaDomainTypeWriter.class, ProgrammingLanguage.JAVA).writeDomains();
	}
}
