package ca.infoway.messagebuilder.generator.dotnet;

import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.java.ComplexTypePackage;
import ca.infoway.messagebuilder.generator.java.Hl7TypeWriter;
import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;
import ca.infoway.messagebuilder.generator.java.TypeWriter;
import ca.infoway.messagebuilder.generator.java.WriterProvider;

public class CsharpTypeWriter extends TypeWriter {

	private NamespaceContentsImpl contents;

	public CsharpTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result) {
		super(log, writerProvider, translator, result);
		this.contents = new NamespaceContentsImpl(translator, result);
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException {
		return new Hl7DotNetMessageTypeWriter(type, this.translator, this.contents, this.result.getRemovedTypeTranslation());
	}

	@Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	for (Type type : messageType.getTypes().values()) {
    		writeType(type);
		}
    }
}
