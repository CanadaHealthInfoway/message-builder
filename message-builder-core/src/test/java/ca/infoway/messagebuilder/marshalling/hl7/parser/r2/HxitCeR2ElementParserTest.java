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

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.HXIT;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;

@SuppressWarnings("unchecked")
public class HxitCeR2ElementParserTest extends MarshallingTestCase {
	
	private HxitCeR2ElementParser parser;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new HxitCeR2ElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", ce.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, ce.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", ce.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, ce.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNode() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"OTH\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", ce.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, ce.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNodeAndCodeSystem() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" nullFlavor=\"OTH\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", ce.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, ce.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, MANDATORY, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("empty node returns null", ce.getValue());
    }

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("node with no code attribute returns null", ce.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", ce.getValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", ce.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), node, this.xmlResult);
        
        assertFalse(this.xmlResult.isValid());
		assertEquals("warning message count", 1, this.xmlResult.getHl7Errors().size()); // invalid NF
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
        		ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", ce.getValue().getCodeValue());
    }
    
	@Test
	public void testParseValidFull() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("America/Toronto");
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				DateUtil.getDate(2006, 11, 25, 11, 12, 13, 0, timeZone),
				DateUtil.getDate(2007, 0, 2, 10, 11, 12, 0, timeZone));
		
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\">" +
								"  <originalText>some original text</originalText>" +
								"  <translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
								"  <translation code=\"F\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
								"  <validTime><low value=\"20061225121213.0000-0400\"/><high value=\"20070102111112.0000-0400\"/></validTime>" +
							   "</something>");
		
		HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
				ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, ce.getValue().getCode());
		assertEquals("aCsName", ce.getValue().getCodeSystemName());
		assertEquals("aCsVersion", ce.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", ce.getValue().getDisplayName());
		assertEquals("some original text", ce.getValue().getOriginalText().getContent());
		assertEquals(2, ce.getValue().getTranslation().size());
		assertEquals(AdministrativeGender.MALE.getCodeValue(), ce.getValue().getTranslation().get(0).getCode().getCodeValue());
		assertEquals(AdministrativeGender.MALE.getCodeSystem(), ce.getValue().getTranslation().get(0).getCode().getCodeSystem());
		assertEquals(AdministrativeGender.FEMALE.getCodeValue(), ce.getValue().getTranslation().get(1).getCode().getCodeValue());
		assertEquals(AdministrativeGender.FEMALE.getCodeSystem(), ce.getValue().getTranslation().get(1).getCode().getCodeSystem());
		assertEquals(interval.getLow(), ce.getValue().getValidTime().getLow());
		assertEquals(interval.getHigh(), ce.getValue().getValidTime().getHigh());
	}
	
	@Test
	public void testParseFull() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("America/Toronto");
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				DateUtil.getDate(2006, 11, 25, 11, 12, 13, 0, timeZone),
				DateUtil.getDate(2007, 0, 2, 10, 11, 12, 0, timeZone));
		
		Node node = createNode(
				"<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\" value=\"1.2\" operator=\"P\">" +
				"  some freeform text" +
				"  <originalText>some original text</originalText>" +
				"  <qualifier inverted=\"true\"><name code=\"cm\" codeSystem=\"1.2.3.4\"/><value code=\"normal\" codeSystem=\"2.16.840.1.113883.5.14\"/></qualifier>" +
				"  <qualifier inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><value code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/></qualifier>" +
				"  <translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"  <translation code=\"F\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"  <validTime><low value=\"20061225121213.0000-0400\"/><high value=\"20070102111112.0000-0400\"/></validTime>" +
				"</something>");
		
		HXIT<CodedTypeR2<Code>> ce = (HXIT<CodedTypeR2<Code>>) this.parser.parse(
				ParserContextImpl.create("HXIT<CodedTypeR2<Code>><CE>", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 4, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", ce.getValue());
		assertEquals("main code", "BARNEY", ce.getValue().getCodeValue());
		assertEquals("main code", "1.2.3.4.5", ce.getValue().getCodeSystem());
		assertEquals("aCsName", ce.getValue().getCodeSystemName());
		assertEquals("aCsVersion", ce.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", ce.getValue().getDisplayName());
		assertNull(ce.getValue().getOperator());
		assertNull(ce.getValue().getValue());
		assertNull(ce.getValue().getSimpleValue());
		assertEquals("some original text", ce.getValue().getOriginalText().getContent());
		assertEquals(2, ce.getValue().getTranslation().size());
		assertEquals(AdministrativeGender.MALE.getCodeValue(), ce.getValue().getTranslation().get(0).getCode().getCodeValue());
		assertEquals(AdministrativeGender.MALE.getCodeSystem(), ce.getValue().getTranslation().get(0).getCode().getCodeSystem());
		assertEquals(AdministrativeGender.FEMALE.getCodeValue(), ce.getValue().getTranslation().get(1).getCode().getCodeValue());
		assertEquals(AdministrativeGender.FEMALE.getCodeSystem(), ce.getValue().getTranslation().get(1).getCode().getCodeSystem());
		assertEquals(0, ce.getValue().getQualifier().size());
		assertEquals(interval.getLow(), ce.getValue().getValidTime().getLow());
		assertEquals(interval.getHigh(), ce.getValue().getValidTime().getHigh());
	}

}
