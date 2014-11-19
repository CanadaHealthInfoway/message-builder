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
 * Last modified: $LastChangedDate: 2012-08-23 17:52:18 -0400 (Thu, 23 Aug 2012) $
 * Revision:      $LastChangedRevision: 6035 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.CR;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class CrR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		CR cr = (CR) new CrR2ElementParser().parse(createContext(), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNull("value", cr.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, cr.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParseContextImpl.create("CR", Ratio.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        CodeRole codeRole = (CodeRole) new CrR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("CR types must have a value element (or a nullFlavor attribute)", this.xmlResult.getHl7Errors().get(0).getMessage());
		assertNull("code role", codeRole);
	}

	@Test
	public void testParseValidValue() throws Exception {
		Node node = createNode("<something inverted=\"true\"><name code=\"testCode\" codeSystem=\"11.22.33\" /><value code=\"oneMoreCode\" codeSystem=\"55.66.77\" /></something>");
        CodeRole codeRole = (CodeRole) new CrR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertTrue(this.xmlResult.isValid());
        assertNotNull("code role", codeRole);
        assertTrue(codeRole.isInverted());
        assertEquals("testCode", codeRole.getName().getCodeValue());
        assertEquals("11.22.33", codeRole.getName().getCodeSystem());
        assertEquals("oneMoreCode", codeRole.getValue().getCodeValue());
        assertEquals("55.66.77", codeRole.getValue().getCodeSystem());
	}
	
	@Test
	public void testParseValidTooManyValues() throws Exception {
		Node node = createNode("<something inverted=\"true\"><name code=\"testCode\" codeSystem=\"11.22.33\" /><name code=\"xtestCode\" codeSystem=\"x11.22.33\" /><value code=\"oneMoreCode\" codeSystem=\"55.66.77\" /><value code=\"xoneMoreCode\" codeSystem=\"x55.66.77\" /></something>");
        CodeRole codeRole = (CodeRole) new CrR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertFalse(this.xmlResult.isValid());
        assertEquals(2, this.xmlResult.getHl7Errors().size());
        assertNotNull("code role", codeRole);
        assertTrue(codeRole.isInverted());
        assertEquals("testCode", codeRole.getName().getCodeValue());
        assertEquals("11.22.33", codeRole.getName().getCodeSystem());
        assertEquals("oneMoreCode", codeRole.getValue().getCodeValue());
        assertEquals("55.66.77", codeRole.getValue().getCodeSystem());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something><numerator value=\"monkey\" /><denominator value=\"2345.67\" /></something>");
		new CrR2ElementParser().parse(createContext(), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
	}
}
