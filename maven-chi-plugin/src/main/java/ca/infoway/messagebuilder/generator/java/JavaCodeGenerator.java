package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.lang.Indenter;


public abstract class JavaCodeGenerator extends Indenter {
    
    protected void writeClassDefinitionClosure(int indentLevel, Writer writer) throws IOException {
        indent(indentLevel, writer);
        writer.write("}");
        writer.write(LINE_SEPARATOR);
    }
}
