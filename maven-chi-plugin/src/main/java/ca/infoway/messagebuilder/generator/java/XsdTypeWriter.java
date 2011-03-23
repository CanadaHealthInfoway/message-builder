package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;

public class XsdTypeWriter extends TypeWriter {

	public XsdTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result) {
		super(log, writerProvider, translator, result);
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
			new Hl7XsdMessageTypeWriter(messageType, this.translator, this.result).write(writer);
    	} finally {
    		writer.close();
    	}
    }
    
}
