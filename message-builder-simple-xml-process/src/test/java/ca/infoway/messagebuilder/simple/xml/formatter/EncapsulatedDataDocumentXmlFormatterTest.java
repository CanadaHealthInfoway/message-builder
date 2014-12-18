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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.schema.XmlSchemas;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@SuppressWarnings("deprecation")
public class EncapsulatedDataDocumentXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\" xmlns:xsi=\"" + XmlSchemas.SCHEMA_INSTANCE + "\"";
	
	private byte[] bytes = Base64.decodeBase64("VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=".getBytes());
	
	@Test
	public void shouldTransformDocOrRefXmlToDocument() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<docOrRef" + ns  + " xsi:type=\"EncapsulatedDocumentType\"><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></docOrRef>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		ED<EncapsulatedData> ed = formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC, null), document.getDocumentElement());
		assertNotNull("ed", ed);
		assertNull(ed.getValue().getReference());
		assertNull(ed.getValue().getMediaType());
		assertEquals(new String(this.bytes), new String(ed.getValue().getContent()));
		assertFalse(ed.getValue() instanceof CompressedData);
	}
	
	@Test
	public void shouldTransformFullDocXmlToDocument() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<document" + ns  + " mediaType=\"text/html\" uri=\"http://www.i-proving.ca\" compression=\"GZ\" language=\"en\"><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></document>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		ED<EncapsulatedData> ed = formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC, null), document.getDocumentElement());
		assertNotNull("ed", ed);
		assertEquals("http://www.i-proving.ca", ed.getValue().getReference());
		assertEquals("text/html", ed.getValue().getMediaType().getCodeValue());
		assertEquals(new String(this.bytes), new String(ed.getValue().getContent()));
		assertTrue(ed.getValue() instanceof CompressedData);
		assertEquals("GZ", ((CompressedData) ed.getValue()).getCompression().getCompressionType());
		assertEquals("en-CA", ((CompressedData) ed.getValue()).getLanguage());
	}
	
	@Test
	public void shouldTransformMinimalDocXmlToDocument() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<document" + ns  + " xsi:type=\"EncapsulatedDocumentType\"><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></document>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		ED<EncapsulatedData> ed = formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC, null), document.getDocumentElement());
		assertNotNull("ed", ed);
		assertNull(ed.getValue().getReference());
		assertNull(ed.getValue().getMediaType());
		assertEquals(new String(this.bytes), new String(ed.getValue().getContent()));
		assertFalse(ed.getValue() instanceof CompressedData);
	}
	
	@Test
	public void shouldTransformFullRefXmlToDocument() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<reference" + ns  + " mediaType=\"text/html\" uri=\"http://www.i-proving.ca\" compression=\"GZ\" language=\"en\" />");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		ED<EncapsulatedData> ed = formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC_REF, null), document.getDocumentElement());
		assertNotNull("ed", ed);
		assertEquals("http://www.i-proving.ca", ed.getValue().getReference());
		assertEquals("text/html", ed.getValue().getMediaType().getCodeValue());
		assertNull(ed.getValue().getContent());
		assertTrue(ed.getValue() instanceof CompressedData);
		assertEquals("GZ", ((CompressedData) ed.getValue()).getCompression().getCompressionType());
		assertEquals("en-CA", ((CompressedData) ed.getValue()).getLanguage());
	}
	@Test
	public void shouldTransformMinimalRefXmlToDocument() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<reference" + ns  + " uri=\"http://www.i-proving.ca\"/>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		ED<EncapsulatedData> ed = formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC_REF, null), document.getDocumentElement());
		assertNotNull("ed", ed);
		assertEquals("http://www.i-proving.ca", ed.getValue().getReference());
		assertNull(ed.getValue().getMediaType());
		assertNull(ed.getValue().getContent());
		assertFalse(ed.getValue() instanceof CompressedData);
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDocRefNotCreated() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<reference" + ns  + "/>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC_REF, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDocNotCreated() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<document" + ns  + "/>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfReferenceMissingForRef() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<reference" + ns  + " mediaType=\"text/html\" compression=\"GZ\" language=\"en\" />");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC_REF, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfReferenceHasContent() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<reference" + ns  + " mediaType=\"text/html\" uri=\"http://www.i-proving.ca\" compression=\"GZ\" language=\"en\"><document>VG9tIGlzIGRyaXZpbmcgbWUgY3Jhenk=</document></reference>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC_REF, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDocMissingContent() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<document" + ns  + " mediaType=\"text/html\" uri=\"http://www.i-proving.ca\" compression=\"GZ\" language=\"en\"/>");
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_DOC, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidSignatureIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<document" + ns  + " mediaType=\"text/html\" uri=\"http://www.i-proving.ca\" compression=\"GZ\" language=\"en\"/>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		EncapsulatedDataDocumentXmlFormatter formatter = new EncapsulatedDataDocumentXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.ED_DOC, null);
		ED<EncapsulatedData> ed = formatter.format(formatContext, document.getDocumentElement());
		assertNotNull("ed", ed);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Document type must have content; Reference type may not have content", formatContext.getErrors().get(0).getMessage());
	}
	
}
