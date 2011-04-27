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

package ca.infoway.messagebuilder.simple.xml.process;

import java.io.IOException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;
import ca.infoway.messagebuilder.simple.xml.parser.SimpleXmlParseProcessor;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class ResponseProcessor implements SimpleXmlProcessor {
	
	private final VersionNumber versionNumber;

	public ResponseProcessor(VersionNumber versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	public String process(String input) throws IOException, MarshallingException, SAXException {
		Document document = new DocumentFactory().createFromString(input);
		
		XmlToModelResult result = createTransformer().transformFromHl7(this.versionNumber, document);
		InteractionBean message = (InteractionBean) result.getMessageObject();
		
		return new SimpleXmlParseProcessor().process(message);
	}

	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl();
	}
}
