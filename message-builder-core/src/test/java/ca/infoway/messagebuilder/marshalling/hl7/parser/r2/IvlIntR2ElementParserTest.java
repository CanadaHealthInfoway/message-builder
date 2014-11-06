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
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

 package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;

public class IvlIntR2ElementParserTest extends CeRxDomainValueTestCase {

	private XmlToModelResult result;
	private ElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlIntR2ElementParser();
	}
	
	@SuppressWarnings("unchecked")
	private Interval<Integer> parse(Node node) throws XmlToModelTransformationException {
		BareANY ivl = this.parser.parse(ParserContextImpl.create("IVL<INT>", Interval.class, SpecificationVersion.V02R02, null, null, null, null, null), 
				Arrays.asList(node), 
				this.result);
		return (Interval<Integer>) (ivl.getBareValue());
	}
	
	
	@Test
	public void testParseSimpleWithOperator() throws Exception {
		Node node = createNode(
				"<range operator=\"A\" value=\"221\" />");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals(new Integer(221), interval.getValue());
		assertEquals(SetOperator.INTERSECT, interval.getOperator());
		assertEquals("representation", Representation.SIMPLE, interval.getRepresentation());
	}

	@Test
	public void testParseSimpleWithDefaultOperator() throws Exception {
		Node node = createNode(
				"<range value=\"221\" />");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals(new Integer(221), interval.getValue());
		assertEquals(SetOperator.INCLUDE, interval.getOperator());
		assertEquals("representation", Representation.SIMPLE, interval.getRepresentation());
	}

	@Test
	public void testParseLowHighWithInclusive() throws Exception {
		Node node = createNode(
				"<range><low inclusive=\"false\" value=\"123\" /><high value=\"567\" inclusive=\"false\" /></range>");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low", new Integer(123), interval.getLow());
		assertEquals("low incl", false, interval.getLowInclusive());
		assertEquals("high", new Integer(567), interval.getHigh());
		assertEquals("high incl", false, interval.getHighInclusive());
		assertEquals("centre", new Integer(345), interval.getCentre());
		assertEquals("width", new Integer(567-123), interval.getWidth().getValue());
		assertEquals("representation", Representation.LOW_HIGH, interval.getRepresentation());
	}

	@Test
	public void testParseLowHighWithBadInclusive() throws Exception {
		Node node = createNode(
				"<range><low inclusive=\"xyz\" value=\"123\" /><high value=\"567\" inclusive=\"true\" /></range>");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low", new Integer(123), interval.getLow());
		assertEquals("low incl", false, interval.getLowInclusive());
		assertEquals("high", new Integer(567), interval.getHigh());
		assertEquals("high incl", true, interval.getHighInclusive());
		assertEquals("centre", new Integer(345), interval.getCentre());
		assertEquals("width", new Integer(567-123), interval.getWidth().getValue());
		assertEquals("representation", Representation.LOW_HIGH, interval.getRepresentation());
	}

	@Test
	public void testParseLowHighWithoutInclusive() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" /><high value=\"567\" /></range>");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low", new Integer(123), interval.getLow());
		assertEquals("low incl", true, interval.getLowInclusive());
		assertEquals("high", new Integer(567), interval.getHigh());
		assertEquals("high incl", true, interval.getHighInclusive());
		assertEquals("centre", new Integer(345), interval.getCentre());
		assertEquals("width", new Integer(567-123), interval.getWidth().getValue());
		assertEquals("representation", Representation.LOW_HIGH, interval.getRepresentation());
	}

	@Test
	public void testParseCentreWidth() throws Exception {
		Node node = createNode(
				"<range><center value=\"15\" /><width value=\"10\" /></range>");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low", new Integer(10), interval.getLow());
		assertEquals("high", new Integer(20), interval.getHigh());
		assertEquals("centre", new Integer(15), interval.getCentre());
		assertEquals("width", new Integer(10), interval.getWidth().getValue());
		assertEquals("representation", Representation.CENTRE_WIDTH, interval.getRepresentation());
	}
	
	@Test
	public void testParseCentreWidthWithRounding() throws Exception {
		Node node = createNode(
		"<range><center value=\"15\" /><width value=\"9\" /></range>");
		Interval<Integer> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low", new Integer(11), interval.getLow());
		assertEquals("high", new Integer(20), interval.getHigh());
		assertEquals("centre", new Integer(15), interval.getCentre());
		assertEquals("width", new Integer(9), interval.getWidth().getValue());
		assertEquals("representation", Representation.CENTRE_WIDTH, interval.getRepresentation());
	}
}
