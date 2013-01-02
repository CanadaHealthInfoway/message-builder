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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;

public class PnPropertyFormatterTest extends FormatterTestCase {
	
	@Test
	public void testFormatValueNull() throws Exception {
		String result = new PnPropertyFormatter().format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl());
		assertTrue(this.result.isValid());
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNullNoUse() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name>Steve Shaw</name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithUse() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\">Steve Shaw</name>", result.trim());
    }

	@Test
    public void testFormatSimpleWithMoreThanOneSimplePart() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve"));
        personName.addNamePart(new EntityNamePart("Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\">SteveShaw</name>", result.trim());
    }

	@Test
    public void testFormatSimpleWithMixedParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve"));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\">Steve<family>Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatSimpleWithMoreOneNonSimplePart() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"><family>Steve Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithMultipleUses() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addUse(EntityNameUse.PSEUDONYM);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertTrue("something in text node", "<name use=\"P L\">Steve Shaw</name>".equals(result.trim()) || "<name use=\"L P\">Steve Shaw</name>".equals(result.trim()));
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testUsesForCeRx() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.PSEUDONYM);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"P\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.LICENSE);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"C\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.HEALTH_CARD);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"HC\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.OFFICIAL_REGISTRY);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"OR\">Steve Shaw</name>", result.trim());
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testUsesForMr2007() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.PSEUDONYM);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"P\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.LICENSE);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"C\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.HEALTH_CARD);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"HC\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.OFFICIAL_REGISTRY);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.V02R02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"OR\">Steve Shaw</name>", result.trim());
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testUsesForMr2009() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.PSEUDONYM);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"P\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.LICENSE);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"C\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.HEALTH_CARD);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"HC\">Steve Shaw</name>", result.trim());
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.OFFICIAL_REGISTRY);
        result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"OR\">Steve Shaw</name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithQualifier() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "BR"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"BR\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testBasicForCeRxWithSimpleName() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw", null));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\">Steve Shaw</name>", result.trim());
    }

	@Test
    public void testBasicForCeRxWithSimpleNameInvalid() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve", null));
        personName.addNamePart(new EntityNamePart("Shaw", null));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\">SteveShaw</name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithQualifierMr2009() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "IN"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"IN\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithQualifierMr2009Full() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "BR"));
        
        String result = formatter.format(getContext("name", "PN.FULL", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"BR\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithInvalidQualifierMr2009() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "BR"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"BR\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithInvalidQualifier() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "XX"));
        
        String result = formatter.format(getContext("name", "PN.FULL", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"XX\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullWithInvalidQualifierCeRx() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, "BR"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"><family qualifier=\"BR\">Shaw</family></name>", result.trim());
    }

	@Test
    public void testFormatSimpleNoParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        
        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"></name>", result.trim());
    }

	@Test
    public void testFormatBasicNoParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"></name>", result.trim());
    }

	@Test
    public void testFormatFullNoParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        
        String result = formatter.format(getContext("name", "PN.FULL", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"></name>", result.trim());
    }

	@Test
    public void testFormatSearchNoParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        
        String result = formatter.format(getContext("name", "PN.SEARCH", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
        assertEquals("something in text node", "<name use=\"L\"></name>", result.trim());
    }

	@Test
    public void testFormatValueMaxLength() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("12345678901234567890123456789012345678901234567890", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"><family>12345678901234567890123456789012345678901234567890</family></name>", result.trim());
    }

	@Test
    public void testFormatValueInvalidLength() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("123456789012345678901234567890123456789012345678901", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // max length + 1
        assertEquals("something in text node", "<name use=\"L\"><family>123456789012345678901234567890123456789012345678901</family></name>", result.trim());
    }

	@Test
    public void testFormatValueInvalidPartType() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("namegoeshere", PersonNamePartType.DELIMITER));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // part type not allowed
        assertEquals("something in text node", "<name use=\"L\"><delimiter>namegoeshere</delimiter></name>", result.trim());
    }

	@Test
    public void testFormatValueMaxLengthCeRx() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("123456789012345678901234567890", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("something in text node", "<name use=\"L\"><family>123456789012345678901234567890</family></name>", result.trim());
    }

	@Test
    public void testFormatValueInvalidLengthCeRx() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("1234567890123456789012345678901", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // max length + 1
        assertEquals("something in text node", "<name use=\"L\"><family>1234567890123456789012345678901</family></name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX, "IN"));
        personName.addNamePart(new EntityNamePart("given1", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given2", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given3", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given4", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("family", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("suffix", PersonNamePartType.SUFFIX, "IN"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertEquals("well formed name", "<name use=\"L\"><prefix qualifier=\"IN\">prefix</prefix><given>given1</given><given>given2</given><given>given3</given><given>given4</given><family>family</family><suffix qualifier=\"IN\">suffix</suffix></name>", result.trim());
    }

	@Test
    public void testFormatValueTooManyNameParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX, "IN"));
        personName.addNamePart(new EntityNamePart("given1", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given2", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given3", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given4", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given5", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("family", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("suffix", PersonNamePartType.SUFFIX, "IN"));
        
        String result = formatter.format(getContext("name", "PN.BASIC", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // too many parts
        assertEquals("well formed name", "<name use=\"L\"><prefix qualifier=\"IN\">prefix</prefix><given>given1</given><given>given2</given><given>given3</given><given>given4</given><given>given5</given><family>family</family><suffix qualifier=\"IN\">suffix</suffix></name>", result.trim());
    }

	@Test
	public void testFormatValueReservedXmlCharsTooLong() throws Exception{
        PnPropertyFormatter formatter = new PnPropertyFormatter();
		
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", "<name use=\"L\">&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        PnPropertyFormatter formatter = new PnPropertyFormatter();
		
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("<cats tk they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name", "PN.SIMPLE", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
		assertEquals("something in text node", "<name use=\"L\">&lt;cats tk they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
}
