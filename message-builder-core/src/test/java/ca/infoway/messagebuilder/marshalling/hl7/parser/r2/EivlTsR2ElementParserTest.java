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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.EIVL;
import ca.infoway.messagebuilder.datatype.lang.EventRelatedPeriodicIntervalTime;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EivlTsR2ElementParserTest extends CeRxDomainValueTestCase {

	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		EIVL<EventRelatedPeriodicIntervalTime> tel = (EIVL<EventRelatedPeriodicIntervalTime>) new EivlTsR2ElementParser().parse(createContext("EIVL<TS>", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("null returned", tel.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, tel.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParserContextImpl.create(type, EventRelatedPeriodicIntervalTime.class, version, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		new EivlTsR2ElementParser().parse(createContext("EIVL<TS>", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		new EivlTsR2ElementParser().parse(createContext("EIVL<TS>", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void testParseAll() throws Exception {
		Node node = createNode(
				"<eventRelatedPeriod>" +
					"<event code=\"ACM\" codeSystem=\"2.16.840.1.113883.5.139\" codeSystemName=\"TimingEvent\"/>" +
					"<offset>" +
						"<low unit=\"cm\" value=\"120\"/>" +
						"<high unit=\"cm\" value=\"170\"/>" +
					"</offset>" +
				"</eventRelatedPeriod>");
		
		EventRelatedPeriodicIntervalTime address = (EventRelatedPeriodicIntervalTime) new EivlTsR2ElementParser().parse(createContext("EIVL<TS>", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		
		assertTrue(this.xmlResult.isValid());
		
		assertEquals("ACM", address.getEvent().getCodeValue());
		assertEquals(new BigDecimal("120"), address.getOffset().getLow().getQuantity());
		assertEquals("cm", address.getOffset().getLow().getUnit().getCodeValue());
		assertEquals(new BigDecimal("170"), address.getOffset().getHigh().getQuantity());
		assertEquals("cm", address.getOffset().getHigh().getUnit().getCodeValue());
		
	}
	
}
