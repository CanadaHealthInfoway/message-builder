package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.xml.TypeName;


public interface WriterProvider {
    public Writer createWriter(TypeName typeName) throws IOException;
}
