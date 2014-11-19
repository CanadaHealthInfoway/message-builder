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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

public class IvlPqElementParserTest extends CeRxDomainValueTestCase {

	private static final String mL = UnitsOfMeasureCaseSensitive.MILLILITRE.getCodeValue();
	private XmlToModelResult result;
	private IvlPqElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlPqElementParser();
	}
	
	@SuppressWarnings("unchecked")
	private Interval<PhysicalQuantity> parse(Node node) throws XmlToModelTransformationException {
		return (Interval<PhysicalQuantity>) this.parser.parse(
				ParseContextImpl.create("IVL<PQ.BASIC>", Interval.class, V02R02, null, null, null, null, null), 
				Arrays.asList(node), 
				this.result).getBareValue();
	}
	
	@Test
	public void testParseLowHigh() throws Exception {
		Node node = createNode("<name><low unit=\"mL\" value=\"1000\"/><high unit=\"mL\" value=\"2000\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
		assertTrue(this.result.isValid());
		assertNotNull("null", interval);
		assertEquals("low - value", 1000, interval.getLow().getQuantity().intValue());
		assertEquals("low - unit", mL, interval.getLow().getUnit().getCodeValue());
		assertEquals("high - value", 2000, interval.getHigh().getQuantity().intValue());
		assertEquals("high - unit", mL, interval.getHigh().getUnit().getCodeValue());
		assertEquals("centre - value", 1500, interval.getCentre().getQuantity().intValue());
		assertEquals("centre - unit", mL, interval.getCentre().getUnit().getCodeValue());
		assertEquals("width - value", 1000, interval.getWidth().getValue().getQuantity().intValue());
		assertEquals("width - unit", mL, interval.getWidth().getValue().getUnit().getCodeValue());
	}

	@Test
	public void testParseLow() throws Exception {
		Node node = createNode("<name><low unit=\"mL\" value=\"1000\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // high must be provided
		assertNotNull("null", interval);
		assertEquals("low - value", 1000, interval.getLow().getQuantity().intValue());
		assertEquals("low - unit", mL, interval.getLow().getUnit().getCodeValue());
		assertNull("high", interval.getHigh());
		assertNull("centre", interval.getCentre());
		assertNull("width", interval.getWidth());
	}
	
	@Test
	public void testParseLowInvalidBothNull() throws Exception {
		Node node = createNode("<name><low nullFlavor=\"OTH\"/><high nullFlavor=\"NI\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // low and high can't both be null
		assertNotNull("null", interval);
		assertNull(interval.getLow());
		assertNull(interval.getHigh());
		assertEquals(NullFlavor.OTHER, interval.getLowNullFlavor());
		assertEquals(NullFlavor.NO_INFORMATION, interval.getHighNullFlavor());
	}
}
