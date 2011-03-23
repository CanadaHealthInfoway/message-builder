package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import ca.infoway.messagebuilder.generator.MifReference;

class MifReferenceImpl implements MifReference {

	private final String category;
	private final File file;

	MifReferenceImpl(File file, String category) {
		this.file = file;
		this.category = category;
	}
	
	public File asFile() {
		return this.file;
	}

	public String getCategory() {
		return this.category;
	}

}
