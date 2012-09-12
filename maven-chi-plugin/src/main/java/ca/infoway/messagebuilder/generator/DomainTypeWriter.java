/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-01-10 21:45:18 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3334 $
 */
package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.generator.util.DomainType;

public class DomainTypeWriter {

	private final LogUI log;
	private final File sourceFolder;
	private final ProgrammingLanguage language;
	private final Class<? extends SourceFileWriter> sourceWriterClass;

	public DomainTypeWriter(LogUI log, File sourceFolder, Class<? extends SourceFileWriter> sourceWriterClass, ProgrammingLanguage language) {
		this.log = log;
		this.sourceFolder = sourceFolder;
		this.sourceWriterClass = sourceWriterClass;
		this.language = language;
	}

	public void writeDomains() throws GeneratorException, IOException {
		List<DomainType> types = DomainRegistry.getInstance().getAllSpecificationDomainTypes();
		for (DomainType domainType : types) {
			this.log.log(DEBUG, "Writing: " + domainType.getFullyQualifiedClassName());
			FileWriter writer = createFileWriter(domainType);
			try {
				createSourceWriter(domainType).write(writer);
			} finally {
				IOUtils.closeQuietly(writer);
			}
		}
	}

	private SourceFileWriter createSourceWriter(DomainType domainType) {
		try {
			return this.sourceWriterClass.getConstructor(DomainType.class).newInstance(domainType);
		} catch (IllegalArgumentException e) {
			throw new GeneratorException(e);
		} catch (SecurityException e) {
			throw new GeneratorException(e);
		} catch (InstantiationException e) {
			throw new GeneratorException(e);
		} catch (IllegalAccessException e) {
			throw new GeneratorException(e);
		} catch (InvocationTargetException e) {
			throw new GeneratorException(e);
		} catch (NoSuchMethodException e) {
			throw new GeneratorException(e);
		}
	}

	private FileWriter createFileWriter(DomainType domainType) throws IOException {
		String className = domainType.getFullyQualifiedClassName();
		File packageFolders = new File(this.sourceFolder, ClassUtils.getPackageName(className).replace('.', '/'));
		if (!packageFolders.exists()) {
			packageFolders.mkdirs();
		}
		return new FileWriter(new File(packageFolders, domainType.getName() + "." + this.language.getFileSuffix()));
	}
}
