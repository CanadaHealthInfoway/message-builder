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

package ca.infoway.messagebuilder.simple.xml.process;

import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderingException;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlSchemaResolver;
import ca.infoway.messagebuilder.simple.xml.formatter.SimpleXmlFormatProcessor;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class RequestProcessor implements SimpleXmlProcessor {
	
	private final VersionNumber versionNumber;

	public RequestProcessor(VersionNumber versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	public String process(String input) throws IOException, MarshallingException, SAXException {
		Document document = new DocumentFactory().createFromString(input);

		SimpleXmlFormatProcessor processor = new SimpleXmlFormatProcessor(this.versionNumber);
		MessagePartBean bean = processor.process(loadSchema(getMessageId(document)), document);
		
		ModelToXmlResult result = createTransformer().transformToHl7AndReturnResult(
				this.versionNumber, (InteractionBean) bean);
		
		if (!result.isValid()) {
			throw new RenderingException(buildErrorMessage(result).toString());
		}
		
		return result.getXmlMessage();
	}

	private StringBuffer buildErrorMessage(ModelToXmlResult result) {
		StringBuffer sb = new StringBuffer();
		sb.append("Errors occurred:\n\n");
		List<Hl7Error> hl7Errors = result.getHl7Errors();
		for (Hl7Error hl7Error : hl7Errors) {
			sb.append(hl7Error.getMessage())
			  .append("\n --> ")
			  .append(hl7Error.getBeanPath())
			  .append("\n\n");
		}
		return sb;
	}	
	
	private String getMessageId(Document document) {
		String name = getLocalOrTagName(document.getDocumentElement());
		return InteractionNameToIdRegistry.getInstance().getMessageId(name);
	}

	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl();
	}

	private Schema loadSchema(String messageId) throws SAXException {
		InputStream input = getClass().getResourceAsStream("/ca/infoway/messagebuilder/model/"
				+ messageId + ".xsd");
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language); 
			factory.setResourceResolver(new SimpleXmlSchemaResolver());
			return factory.newSchema(new StreamSource(input));
		} finally {
			IOUtils.closeQuietly(input);
		}
	}	
}
