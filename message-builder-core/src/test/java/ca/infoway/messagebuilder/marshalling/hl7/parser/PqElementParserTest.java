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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;

public class PqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PQ pq = (PQ) new PqElementParser().parse(createContext(), node, this.xmlJavaResult);
		assertNull("PhysicalQuantity", pq.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pq.getNullFlavor());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("PQ.BASIC", PhysicalQuantity.class, SpecificationVersion.V02R02, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertNull("PhysicalQuantity", physicalQuantity);
		assertFalse("result", this.xmlJavaResult.isValid());
	}

	@Test
	public void testParseNoCorrectAttributeNodes() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertNull("PhysicalQuantity", physicalQuantity);
		assertFalse("result", this.xmlJavaResult.isValid());
	}

	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesWithElementClosure() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\"></something>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesNoUnit() throws Exception {
		Node node = createNode("<something value=\"1234.45\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertNotNull("value", physicalQuantity.getQuantity());
		assertNull("value", physicalQuantity.getUnit());
		assertTrue("result", this.xmlJavaResult.isValid());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new PqElementParser().parse(createContext(), node, this.xmlJavaResult);
		assertFalse("result", this.xmlJavaResult.isValid());
	}
	
	@Test
	public void testParseTooManyIntegerDigitsValueAttribute() throws Exception {
		String element = "<something value=\"123456789012.12\" unit=\"kg\"/>";
		Node node = createNode(element);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertFalse("result", this.xmlJavaResult.isValid());
		assertEquals(1, this.xmlJavaResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity (<something unit=\"kg\" value=\"123456789012.12\"/>) can contain a maximum of 11 integer places", this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseTooManyDecimalDigitsValueAttribute() throws Exception {
		String element = "<something value=\"12345678901.1234\" unit=\"kg\"/>";
		Node node = createNode(element);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue();
		assertFalse("result", this.xmlJavaResult.isValid());
		assertEquals(1, this.xmlJavaResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity (<something unit=\"kg\" value=\"12345678901.1234\"/>) can contain a maximum of 2 decimal places", this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
}
