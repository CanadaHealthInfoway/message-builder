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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdSignaturePropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNullWithConformanceOptional() throws Exception {
		String expectedResult = "";
			
		FormatContext context = new FormatContextImpl(new ModelToXmlResult(), null, "name", null, ConformanceLevel.OPTIONAL, null, false);
		String result = new EdSignaturePropertyFormatter().format(context, null);
		assertEquals("named null format", expectedResult, result);
	}

	@Test
	public void testFormatValueNull() throws Exception {
		// expected:
		// <name nullFlavor=\"NI\"/>
		
		String expectedResult = "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;
		
		String result = new EdSignaturePropertyFormatter().format(getContext("name"), new EDImpl<String>());
		assertEquals("named null format", expectedResult, result);
	}

	@Test
	public void testFormatValueNonNull() throws Exception {
		// expected:
		// <name mediaType="text/xml">
		//   <signature xmlns="http://www.w3.org/2000/09/xmldsig#">signatureText</signature>
		// </name>

		String expectedResult = 
			  "<name mediaType=\"text/xml\">" + LINE_SEPARATOR
			+ "  <signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">signatureText</signature>" + LINE_SEPARATOR
			+ "</name>" + LINE_SEPARATOR;
			
		String result = new EdSignaturePropertyFormatter().format(getContext("name"), new EDImpl<String>("signatureText"));
		assertEquals("something in text node", expectedResult, result);
	}
}
