package ca.infoway.messagebuilder.generator.dotnet;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;

import java.io.File;
import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.java.Case3Simplifier;
import ca.infoway.messagebuilder.generator.java.IntermediateToModelGenerator;
import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.SimpleNameTranslator;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;

public class IntermediateToCsharpGenerator extends IntermediateToModelGenerator {
	
	public IntermediateToCsharpGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToCsharpGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report) {
		super(outputUI, sourceFolder, basePackageName, report);
	}
	
	/**
	 * <p>Apply simplification algorithms.
	 * 
	 * <p>The Case 3 algorithm only applies to Java and .Net. 
	 */
	@Override
	public void simplify(TypeAnalysisResult result) throws GeneratorException {
		new Case3Simplifier(this.outputUI, result).execute();
		super.simplify(result);
	}
	
	@Override
	protected void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException {
		NameTranslator translator = new CsharpPackageNameAdjustingDecorator(new SimpleNameTranslator(C_SHARP, this.basePackageName, result));
		CsharpSourceFileWriterProvider writerProvider = new CsharpSourceFileWriterProvider(this.sourceFolder, translator);
		new CsharpTypeWriter(this.outputUI, writerProvider, translator, result).writeTypes();
	}
}
