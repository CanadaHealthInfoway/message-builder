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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;

public abstract class TypeWriter {

	protected final WriterProvider writerProvider;
	protected final LogUI log;
	protected final NameTranslator translator;
	protected final TypeAnalysisResult result;

	public TypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result) {
		super();
		this.log = log;
		this.writerProvider = writerProvider;
		this.translator = translator;
		this.result = result;
	}
	
	public void writeTypes() throws IOException, GeneratorException {
		for (ComplexTypePackage type : this.result.getAllPackages()) {
			write(type);
		}
		
		for (Type type : this.result.getTypes().values()) {
			if (type instanceof InteractionType) {
				writeType(type);
			}
		}
	}

    protected abstract void write(ComplexTypePackage messageType) throws IOException, GeneratorException;
    
    protected void writeType(Type type) throws IOException, GeneratorException {
		this.log.log(DEBUG, "Writing: " + type.getTypeName().getName());
		Writer writer = this.writerProvider.createWriter(type.getTypeName());
		try {
			getHl7MessageTypeWriter(type).write(writer);
		} finally {
			writer.close();
		}
	}

	protected abstract Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException;

}