/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.dotnet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.WriterProvider;
import ca.infoway.messagebuilder.xml.TypeName;

public class CsharpSourceFileWriterProvider implements WriterProvider {

	private final File sourceFolder;
	private final NameTranslator translator;

	public CsharpSourceFileWriterProvider(File sourceFolder, NameTranslator translator) {
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
        return new File(packageDirectory, this.translator.getClassNameWithoutPackage(typeName) + ".cs");
	}

	public Writer createWriter(TypeName typeName) throws IOException {
		return new FileWriter(createFile(typeName));
	}
}
