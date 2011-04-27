/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.generator.NamingPolicy;

public class XsdTypeWriter extends TypeWriter {

	private final NamingPolicy namingPolicy;

	public XsdTypeWriter(LogUI log, WriterProvider writerProvider, NameTranslator translator, TypeAnalysisResult result, NamingPolicy namingPolicy) {
		super(log, writerProvider, translator, result);
		this.namingPolicy = namingPolicy;
	}

	@Override
	protected Hl7TypeWriter getHl7MessageTypeWriter(Type type) {
		return new Hl7XsdInteractionTypeWriter((InteractionType)type, this.result);
	}
	
    @Override
	protected void write(ComplexTypePackage messageType) throws IOException, GeneratorException {
    	this.log.log(DEBUG, "Writing: " + messageType.getName().getName());
    	Writer writer = this.writerProvider.createWriter(messageType.getName());
    	try {
			new Hl7XsdMessageTypeWriter(messageType, this.translator, this.result, this.namingPolicy).write(writer);
    	} finally {
    		writer.close();
    	}
    }
    
}
