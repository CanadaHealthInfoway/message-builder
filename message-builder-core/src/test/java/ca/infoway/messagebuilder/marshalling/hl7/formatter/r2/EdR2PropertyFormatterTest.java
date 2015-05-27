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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-03-04 18:41:56 -0500 (Mon, 04 Mar 2013) $
 * Revision:      $LastChangedRevision: 6667 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.platform.Base64;

public class EdR2PropertyFormatterTest extends FormatterTestCase {

	private TelR2PropertyFormatter telFormatter = new TelR2PropertyFormatter();
	
 	@Test
	public void testFormatValueNull() throws Exception {
		String expectedResult =
			  "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter(this.telFormatter, true).format(getContext("name", "ED"), new EDImpl<EncapsulatedData>());
		assertTrue(this.result.isValid());
		assertEquals("named null format", expectedResult, result);
	}
	
	@Test
	public void testInvalidTextContent() throws Exception {
		TelecommunicationAddress reference = new TelecommunicationAddress();
		reference.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		reference.setAddress("aValue");
		reference.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);

		try {
			createEd(reference, "some content & that will <b>not</b> be escaped");
			fail("Should not get here due to unescaped content");
		} catch (SAXException e) {
			// expected to throw an exception on the "&"
		}
	}

	@Test
	public void testTextContent() throws Exception {
		TelecommunicationAddress reference = new TelecommunicationAddress();
		reference.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		reference.setAddress("aValue");
		reference.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		
		EncapsulatedData data = createEd(reference, "some content &amp; that will <b>not</b> be escaped");
		
		String result = new EdPropertyFormatter(this.telFormatter, true).format(getContext("text", "ED"), new EDImpl<EncapsulatedData>(data));
		assertTrue(this.result.isValid());
		assertXml("something in text node", 
				"<text compression=\"ZL\" integrityCheck=\"c29tZXRoaW5nIHRvIGVuY29kZQ==\" integrityCheckAlgorithm=\"SHA-256\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"TXT\">" +
					"<reference use=\"H\" value=\"tel:aValue\"/>" + 
					"some content &amp; that will <b>not</b> be escaped" +
				"</text>"
		, result, true);
	}

	@Test
	public void testAllProperties() throws Exception {
		TelecommunicationAddress reference = new TelecommunicationAddress();
		reference.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		reference.setAddress("aValue");
		reference.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		
		EncapsulatedData data = createEd(reference, "<content>this is some <b>bolded</b> content</content>");
		data.setThumbnail(createEd(reference, "<![CDATA[some cdata <& <> content]]>"));
		
		String result = new EdPropertyFormatter(this.telFormatter, true).format(getContext("text", "ED"), new EDImpl<EncapsulatedData>(data));
		assertTrue(this.result.isValid());
		assertXml("something in text node", 
				"<text compression=\"ZL\" integrityCheck=\"c29tZXRoaW5nIHRvIGVuY29kZQ==\" integrityCheckAlgorithm=\"SHA-256\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"TXT\">" +
					"<reference use=\"H\" value=\"tel:aValue\"/>" + 
					"<thumbnail compression=\"ZL\" integrityCheck=\"c29tZXRoaW5nIHRvIGVuY29kZQ==\" integrityCheckAlgorithm=\"SHA-256\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"TXT\">" +
						"<reference use=\"H\" value=\"tel:aValue\"/>" +
						"<![CDATA[some cdata <& <> content]]>" +
					"</thumbnail>" +
					"<content>this is some <b>bolded</b> content</content>" +
				"</text>"
		, result, true);
	}

	private EncapsulatedData createEd(TelecommunicationAddress reference, String content) throws Exception {
		EncapsulatedData data = new EncapsulatedData();
		data.setCompression(Compression.ZLIB);
		data.setIntegrityCheck(Base64.encodeBase64String("something to encode".getBytes()));
		data.setIntegrityCheckAlgorithm(IntegrityCheckAlgorithm.SHA_256);
		data.setLanguage("en-CA");
		data.setMediaType(X_DocumentMediaType.PLAIN_TEXT);
		data.setReferenceObj(reference);
		data.setRepresentation(EdRepresentation.TXT);
		if (content != null) {
			data.setContent(content);
		}
		return data;
	}
	
}