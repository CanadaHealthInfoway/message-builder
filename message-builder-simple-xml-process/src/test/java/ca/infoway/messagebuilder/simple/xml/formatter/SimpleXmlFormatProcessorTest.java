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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ErrorsOrWarningsBean;
import ca.infoway.messagebuilder.schema.XmlSchemas;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(JMock.class)
public class SimpleXmlFormatProcessorTest {
	
	class ParameterListBean extends MessagePartBean {
		private static final long serialVersionUID = 482950311451912906L;
		
		private ST description;
		private TEL telecom;
		private II id;
		public ST getDescription() {
			return this.description;
		}
		public void setDescription(ST description) {
			this.description = description;
		}
		public II getId() {
			return this.id;
		}
		public void setId(II id) {
			this.id = id;
		}
		public TEL getTelecom() {
			return this.telecom;
		}
		public void setTelecom(TEL telecom) {
			this.telecom = telecom;
		}
	}

	private Mockery jmock = new Mockery();
	private FormatterFactory factory = this.jmock.mock(FormatterFactory.class);
	private SimpleXmlFormatter formatter = this.jmock.mock(SimpleXmlFormatter.class);
	private MessagePartResolver resolver = this.jmock.mock(MessagePartResolver.class);
	private SimpleXmlFormatProcessor processor = new SimpleXmlFormatProcessor(this.factory, this.resolver, SpecificationVersion.R02_04_02);
	
	@Test
	public void shouldCallAppropriateFormatter() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).isSimpleDataType("InstanceIdentifier"); will(returnValue(true));
			one(factory).createFormatter("InstanceIdentifier"); will(returnValue(formatter));
			one(resolver).resolve(SpecificationVersion.R02_04_02, "ParameterList", null); will(returnValue(new MessagePartWrapper(new ParameterListBean())));
			allowing(formatter); will(returnValue(new IIImpl(new Identifier("abcd", "123"))));
		}});
		this.processor.process(loadSchema(), getSampleDocument());
	}

	@Test
	public void shouldDetermineCodeType() throws Exception {
		ErrorsOrWarningsBean detail = new ErrorsOrWarningsBean();
		Class<?> type = this.processor.getTypeIfApplicable(detail.getClass().getDeclaredField("responseCode"));
		assertEquals("type", AcknowledgementDetailCode.class, type);
	}
	
	@Test
	public void shouldReturnAppropriateBeanType() throws Exception {
		final II ii = new IIImpl(new Identifier("abcd", "123"));
		this.jmock.checking(new Expectations() {{
			allowing(factory).isSimpleDataType("InstanceIdentifier"); will(returnValue(true));
			allowing(factory).createFormatter("InstanceIdentifier"); will(returnValue(formatter));
			allowing(resolver).resolve(SpecificationVersion.R02_04_02, "ParameterList", null); will(returnValue(new MessagePartWrapper(new ParameterListBean())));
			allowing(formatter); will(returnValue(ii));
		}});
		MessagePartBean bean = this.processor.process(loadSchema(), getSampleDocument());
		assertNotNull("bean", bean);
		assertEquals("type", ParameterListBean.class, bean.getClass());
		assertEquals("id", ii, bean.getField("id"));
	}

	@Test
	public void shouldCallStandardXmlTypeFormatter() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).isSimpleDataType("string"); will(returnValue(true));
			one(factory).createFormatter("string"); will(returnValue(formatter));
			one(resolver).resolve(SpecificationVersion.R02_04_02, "ParameterList", null); will(returnValue(new MessagePartWrapper(new ParameterListBean())));
			allowing(formatter); will(returnValue(new STImpl("Some text")));
		}});
		this.processor.process(loadSchema(), getAlternativeDocument());
	}
	
	@Test
	public void shouldCallDerivedTypeFormatter() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).isSimpleDataType("EmailAddress"); will(returnValue(true));
			one(factory).createFormatter("EmailAddress"); will(returnValue(formatter));
			one(resolver).resolve(SpecificationVersion.R02_04_02, "ParameterList", null); will(returnValue(new MessagePartWrapper(new ParameterListBean())));
			allowing(formatter); will(returnValue(new TELImpl(new TelecommunicationAddress())));
		}});
		this.processor.process(loadSchema(), getThirdDocument());
	}
	
	private Document getSampleDocument() throws SAXException {
		return new DocumentFactory().createFromString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<ParameterList xmlns=\"urn:ca.infoway.messagebuilder.simplexml.v1\" >" +
				"	<id root=\"abcdefg\" />" +
				"</ParameterList>");
	}
	
	private Document getAlternativeDocument() throws SAXException {
		return new DocumentFactory().createFromString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<ParameterList xmlns=\"urn:ca.infoway.messagebuilder.simplexml.v1\" >" +
				"	<description>This is some text</description>" +
		"</ParameterList>");
	}
	
	private Document getThirdDocument() throws SAXException {
		return new DocumentFactory().createFromString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<ParameterList xmlns=\"urn:ca.infoway.messagebuilder.simplexml.v1\" " +
				"xmlns:xsi=\"" + XmlSchemas.SCHEMA_INSTANCE + "\">" +
				"	<telecom xsi:type=\"EmailAddress\"><mailto>tom.mcgrady@example.com</mailto></telecom>" +
		"</ParameterList>");
	}
	
	private Schema loadSchema() throws SAXException {
		InputStream input = getClass().getResourceAsStream("sample.xsd");
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language); 
			factory.setResourceResolver(new ResolverImpl(factory.getResourceResolver()));
			return factory.newSchema(new StreamSource(input));
		} finally {
			IOUtils.closeQuietly(input);
		}
	}	
}
