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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
