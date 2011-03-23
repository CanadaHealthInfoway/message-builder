package ca.infoway.messagebuilder.generator;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

class PackageLocationDeriver {

	static TypeName derive(File file) {
		return derive(file.getName());
	}

	static TypeName derive(String fileName) {
		return new TypeName(StringUtils.left(fileName, 15));
	}
}
