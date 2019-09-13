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

import java.io.IOException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.lang.ComplexTypePackage;
import ca.infoway.messagebuilder.generator.lang.Hl7TypeWriter;
import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.generator.lang.Type;
import ca.infoway.messagebuilder.generator.lang.TypeAnalysisResult;
import ca.infoway.messagebuilder.generator.lang.TypeWriter;
import ca.infoway.messagebuilder.generator.lang.WriterProvider;

public class JavaTypeWriter extends TypeWriter {

	private final NamingPolicy namingPolicy;

	public JavaTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, 
			TypeAnalysisResult result, NamingPolicy namingPolicy) {
		super(log, writerProvider, translator, result);
		this.namingPolicy = namingPolicy;
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) throws GeneratorException {
		return new Hl7JavaMessageTypeWriter(type, this.translator, this.namingPolicy);
	}

	@Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	for (Type type : messageType.getTypes().values()) {
    		writeType(type);
		}
    }
}
