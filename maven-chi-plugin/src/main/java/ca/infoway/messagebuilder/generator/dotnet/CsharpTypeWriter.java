package ca.infoway.messagebuilder.generator.dotnet;

import java.io.IOException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.java.ComplexTypePackage;
import ca.infoway.messagebuilder.generator.java.Hl7TypeWriter;
import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;
import ca.infoway.messagebuilder.generator.java.TypeWriter;
import ca.infoway.messagebuilder.generator.java.WriterProvider;

public class CsharpTypeWriter extends TypeWriter {

	private NamespaceContentsImpl contents;
	private final NamingPolicy namingPolicy;

	public CsharpTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result, NamingPolicy namingPolicy) {
		super(log, writerProvider, translator, result);
		this.namingPolicy = namingPolicy;
		this.contents = new NamespaceContentsImpl(translator, result);
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException {
		return new Hl7DotNetMessageTypeWriter(type, this.translator, this.contents, this.namingPolicy);
	}

	@Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	for (Type type : messageType.getTypes().values()) {
    		writeType(type);
		}
    }
}
