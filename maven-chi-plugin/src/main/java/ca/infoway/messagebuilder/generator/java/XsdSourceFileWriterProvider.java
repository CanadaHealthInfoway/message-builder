package ca.infoway.messagebuilder.generator.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.xml.TypeName;

public class XsdSourceFileWriterProvider implements WriterProvider {

	private final File sourceFolder;
	private final NameTranslator translator;

	public XsdSourceFileWriterProvider(File sourceFolder, NameTranslator translator) {
		this.sourceFolder = sourceFolder;
		this.translator = translator;
	}
	
	private File getSourceFolder() {
		return this.sourceFolder;
	}

	public File createFile(TypeName typeName) {
		String qualifiedPackageName = this.translator.getPackageName(typeName);
		File packageDirectory = new File(getSourceFolder(), qualifiedPackageName.replace('.', File.separatorChar));
        packageDirectory.mkdirs();
        return new File(packageDirectory, typeName.getUnqualifiedName() + ".xsd");
	}

	public Writer createWriter(TypeName typeName) throws IOException {
		return new FileWriter(createFile(typeName));
	}
}
