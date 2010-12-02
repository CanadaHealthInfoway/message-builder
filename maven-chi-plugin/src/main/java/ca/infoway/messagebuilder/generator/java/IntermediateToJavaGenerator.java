package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;

import java.io.File;
import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class IntermediateToJavaGenerator extends IntermediateToModelGenerator {
	
	public IntermediateToJavaGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToJavaGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report) {
		super(outputUI, sourceFolder, basePackageName, report);
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
		SimpleNameTranslator translator = new SimpleNameTranslator(JAVA, this.basePackageName, result);
		JavaSourceFileWriterProvider writerProvider = new JavaSourceFileWriterProvider(this.sourceFolder, translator);
		new JavaTypeWriter(this.outputUI, writerProvider, translator, result).writeTypes();
	}
	@Override
	protected ProgrammingLanguage getProgrammingLanguage() {
		return ProgrammingLanguage.JAVA;
	}
}
