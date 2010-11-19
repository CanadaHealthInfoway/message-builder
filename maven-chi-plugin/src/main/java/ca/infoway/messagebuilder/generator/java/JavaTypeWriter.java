package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.util.HashMap;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

public class JavaTypeWriter extends TypeWriter {

	public JavaTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result) {
		super(log, writerProvider, translator, result);
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException {
		return new Hl7JavaMessageTypeWriter(type, this.translator, 
				new HashMap<TypeName, TypeName>());
//				this.result.getRemovedTypeTranslation());
	}

	@Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	for (Type type : messageType.getTypes().values()) {
    		writeType(type);
		}
    }
}
