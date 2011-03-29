package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.NamingPolicy;

public class XsdTypeWriter extends TypeWriter {

	private final NamingPolicy namingPolicy;

	public XsdTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result, NamingPolicy namingPolicy) {
		super(log, writerProvider, translator, result);
		this.namingPolicy = namingPolicy;
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) {
		return new Hl7XsdInteractionTypeWriter((InteractionType)type, this.result);
	}
	
    @Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	this.log.log(DEBUG, "Writing: " + messageType.getName().getName());
    	Writer writer = this.writerProvider.createWriter(messageType.getName());
    	try {
			new Hl7XsdMessageTypeWriter(messageType, this.translator, this.result, this.namingPolicy).write(writer);
    	} finally {
    		writer.close();
    	}
    }
    
}
