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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class EdSignatureElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		@SuppressWarnings("unchecked")
		ED<String> ed = (ED<String>) new EdSignatureElementParser().parse(createEdContext(), node, null);
		assertNull("signature is null", ed.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ed.getNullFlavor());
	}

	private ParseContext createEdContext() {
		return ParserContextImpl.create("ED.SIGNATURE", String.class, SpecificationVersion.V02R02, null, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		testInvalidNode(createNode("<something/>"));
	}

	@Test
	public void testParseTextNode() throws Exception {
		testInvalidNode(createNode("<something>signatureText</something>"));
	}

	@Test
	public void testParseWrongChildNode() throws Exception {
		testInvalidNode(createNode(
				  "<something>"
				+ "  <notSignature></notSignature>"
				+ "</something>"));
	}

	public void testInvalidNode(Node invalidNode) throws Exception {
		XmlToModelResult xmlResult = new XmlToModelResult();
		String parseResult = (String) new EdSignatureElementParser().parse(createEdContext(), invalidNode, xmlResult).getBareValue();
		
		assertNull("parse result", parseResult);
		assertEquals("HL7 error count", 1, xmlResult.getHl7Errors().size());
		
		Hl7Error hl7Error = xmlResult.getHl7Errors().get(0);
		assertEquals("error message", "Expected ED.SIGNATURE node to have a child element named signature", hl7Error.getMessage());
		assertEquals("error message code", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
	}

	@Test
	public void testParseValidNode() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <signature>signatureText</signature>"
				+ "</something>");

		assertEquals("signature", 
				"signatureText", 
				new EdSignatureElementParser().parse(createEdContext(), node, null).getBareValue());
	}

	@Test
	public void testParseEmptySignatureNode() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <signature></signature>"
				+ "</something>");

		assertEquals("signature", 
				"", 
				new EdSignatureElementParser().parse(createEdContext(), node, null).getBareValue());
	}

	@Test
	public void testParseEmptySignatureNodeAgain() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <signature/>"
				+ "</something>");

		assertEquals("signature", 
				"", 
				new EdSignatureElementParser().parse(createEdContext(), node, null).getBareValue());
	}
}

