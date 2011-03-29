package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.NamingPolicy;

public class JavaTypeWriter extends TypeWriter {

	private final NamingPolicy namingPolicy;

	public JavaTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, 
			TypeAnalysisResult result, NamingPolicy namingPolicy) {
		super(log, writerProvider, translator, result);
		this.namingPolicy = namingPolicy;
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException {
		return new Hl7JavaMessageTypeWriter(type, this.translator, this.namingPolicy);
	}

	@Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	for (Type type : messageType.getTypes().values()) {
    		writeType(type);
		}
    }
}
