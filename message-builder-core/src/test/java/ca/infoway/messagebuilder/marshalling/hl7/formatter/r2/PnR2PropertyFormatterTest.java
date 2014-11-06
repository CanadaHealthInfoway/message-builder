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
 * Last modified: $LastChangedDate: 2013-02-13 17:08:18 -0500 (Wed, 13 Feb 2013) $
 * Revision:      $LastChangedRevision: 6527 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class PnR2PropertyFormatterTest extends FormatterTestCase {
	
	@Test
	public void testFormatValueNull() throws Exception {
		String result = new EnR2PropertyFormatter().format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl());
		assertTrue(this.result.isValid());
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNullNoUse() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name>Steve Shaw</name>", result, true);
    }

	@Test
    public void testFormatValueNonNullWithUse() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\">Steve Shaw</name>", result, true);
    }

	@Test
    public void testFormatSimpleWithMoreThanOneSimplePart() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve"));
        personName.addNamePart(new EntityNamePart("Shaw"));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
		System.out.println(result);
        assertEquals("something in text node", "<name use=\"L\">" + SystemUtils.LINE_SEPARATOR +
        		"  Steve" + SystemUtils.LINE_SEPARATOR +
        		"  Shaw" + SystemUtils.LINE_SEPARATOR +
        		"</name>" + SystemUtils.LINE_SEPARATOR, result);
    }

	@Test
    public void testFormatSimpleWithMixedParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve"));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\">Steve<family>Shaw</family></name>", result, true);
    }

	@Test
    public void testFormatSimpleWithTwoNonSimpleParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());

        assertEquals("formatted text node", "<name use=\"L\">" + SystemUtils.LINE_SEPARATOR +
        									"  <given>Steve</given>" + SystemUtils.LINE_SEPARATOR +
        									"  <family>Shaw</family>" + SystemUtils.LINE_SEPARATOR +
        									"</name>" + SystemUtils.LINE_SEPARATOR, result);
        assertXml("something in text node", "<name use=\"L\"><given>Steve</given><family>Shaw</family></name>", result, true);
    }

	@Test
    public void testFormatSimpleWithNullFlavorPart() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart(PersonNamePartType.GIVEN, NullFlavor.MASKED));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());

        assertEquals("formatted text node", "<name use=\"L\">" + SystemUtils.LINE_SEPARATOR +
        									"  <given nullFlavor=\"MSK\"/>" + SystemUtils.LINE_SEPARATOR +
        									"  <family>Shaw</family>" + SystemUtils.LINE_SEPARATOR +
        									"</name>" + SystemUtils.LINE_SEPARATOR, result);
        assertXml("something in text node", "<name use=\"L\"><given nullFlavor=\"MSK\"/><family>Shaw</family></name>", result, true);
    }

	@Test
    public void testFormatValueNonNullWithMultipleUses() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addUse(EntityNameUse.PSEUDONYM);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L P\">Steve Shaw</name>", result.trim(), true);
    }

	@Test
    public void testUsesForMr2009() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\">Steve Shaw</name>", result, true);
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.PSEUDONYM);
        result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"P\">Steve Shaw</name>", result, true);
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.LICENSE);
        result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"C\">Steve Shaw</name>", result, true);
        
        this.result.clearErrors();
        personName.getUses().clear();
        
        personName.addUse(EntityNameUse.OFFICIAL_REGISTRY);
        result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_03), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"OR\">Steve Shaw</name>", result, true);
    }

	@Test
    public void testFormatValueNonNullWithQualifier() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY, EntityNamePartQualifier.BIRTH));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.V02R02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\"><family qualifier=\"BR\">Shaw</family></name>", result, true);
    }

	@Test
    public void testBasicForCeRxWithMultipleNameParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\"><given>Steve</given><family>Shaw</family></name>", result, true);
    }

	@Test
    public void testFormatSimpleNoParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\"></name>", result, true);
    }

	@Test
    public void testFormatValueWithDelimiterPartType() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("namegoeshere", PersonNamePartType.DELIMITER));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\"><delimiter>namegoeshere</delimiter></name>", result, true);
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX, EntityNamePartQualifier.INITIAL));
        personName.addNamePart(new EntityNamePart("given1", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given2", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given3", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("given4", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("family", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("suffix", PersonNamePartType.SUFFIX, EntityNamePartQualifier.INITIAL));
        
        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("well formed name", "<name use=\"L\"><prefix qualifier=\"IN\">prefix</prefix><given>given1</given><given>given2</given><given>given3</given><given>given4</given><family>family</family><suffix qualifier=\"IN\">suffix</suffix></name>", result, true);
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
		
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("<cats tk they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name", "PN", SpecificationVersion.R02_04_02), new PNImpl(personName));
		assertTrue(this.result.isValid());
		assertXml("something in text node", "<name use=\"L\">&lt;cats tk they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>", result, true);
	}
}
