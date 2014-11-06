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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TnR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		TN tn = (TN) new TnR2ElementParser().parse(createContext(), node, null);
		
		assertNull("null returned", tn.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, tn.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("TN", TrivialName.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
        assertNotNull("empty node", result);
        assertNull("empty node value", result.getName());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
		assertEquals("proper text returned", "text value", result.getName());
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
        assertEquals("proper text returned", "text value", result.getName());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
        new TnR2ElementParser().parse(createContext(), node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(2, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseNotATextNode() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
        new TnR2ElementParser().parse(createContext(), node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
	}
    
	@Test
    public void testUsesNoUse() throws Exception {
        Node node = createNode("<something/>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
        assertEquals("zero uses", 0, result.getUses().size());
    }
    
	@Test
    public void testUsesOneUse() throws Exception {
        Node node = createNode("<something use=\"L\"/>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
        assertEquals("one use", 1, result.getUses().size());
        assertTrue("contains LEGAL use", result.getUses().contains(EntityNameUse.LEGAL));
    }
    
	@Test
    public void testUsesMultipleUses() throws Exception {
        Node node = createNode("<something use=\"L C P\"/>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(null, node, null).getBareValue();
        assertEquals("one use", 3, result.getUses().size());
        assertTrue("contains LEGAL use", result.getUses().contains(EntityNameUse.LEGAL));
        assertTrue("contains LICENSE use", result.getUses().contains(EntityNameUse.LICENSE));
        assertTrue("contains PSEUDONYM use", result.getUses().contains(EntityNameUse.PSEUDONYM));
    }
    
	@Test
    public void testUsesUnknownUse() throws Exception {
        Node node = createNode("<something use=\"XXX\"/>");
        TrivialName result = (TrivialName) new TnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertEquals("no uses", 0, result.getUses().size());
    }
}
