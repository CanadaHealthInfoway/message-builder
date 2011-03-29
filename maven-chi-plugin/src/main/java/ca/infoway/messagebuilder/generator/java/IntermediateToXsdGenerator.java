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
}
