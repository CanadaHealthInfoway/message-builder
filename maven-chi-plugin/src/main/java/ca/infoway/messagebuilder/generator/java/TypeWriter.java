package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;

public abstract class TypeWriter {

	protected final WriterProvider writerProvider;
	protected final LogUI log;
	protected final NameTranslator translator;
	protected final TypeAnalysisResult result;

	public TypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result) {
		super();
		this.log = log;
		this.writerProvider = writerProvider;
		this.translator = translator;
		this.result = result;
	}
	
	public void writeTypes() throws IOException, GeneratorException {
		for (ComplexTypePackage type : this.result.getAllPackages()) {
			write(type);
		}
		
		for (Type type : this.result.getTypes().values()) {
			if (type instanceof InteractionType) {
				writeType(type);
			}
		}
	}

    protected abstract void write(ComplexTypePackage messageType) throws IOException, GeneratorException;
    
    protected void writeType(Type type) throws IOException, GeneratorException {
		this.log.log(DEBUG, "Writing: " + type.getTypeName().getName());
		Writer writer = this.writerProvider.createWriter(type.getTypeName());
		try {
			getHl7MessageTypeWriter(type).write(writer);
		} finally {
			writer.close();
		}
	}

	protected abstract Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException;

}