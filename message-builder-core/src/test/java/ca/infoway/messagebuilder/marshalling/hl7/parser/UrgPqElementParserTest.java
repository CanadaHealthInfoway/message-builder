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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class UrgPqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" unit=\"kg\" /><high value=\"567\" unit=\"kg\" /></range>");
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(null, node, null).getBareValue();
		assertNotNull("null", range);
	
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@Test
	public void testReportError() throws Exception {
		XmlToModelResult xmlResult = new XmlToModelResult();
		
		Node node = createNode(
				"<range><low value=\"123\" unit=\"m\" /><high value=\"567\" unit=\"h\" /></range>");
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(null, node, xmlResult).getBareValue();
		
		assertNull("null", range);
		assertFalse("has error", xmlResult.getHl7Errors().isEmpty());
		assertEquals("syntax error", 
				new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Can't add two quantities of different units: METRE and HOUR", (Element) node),
				xmlResult.getHl7Errors().get(0));
	}
	
}
