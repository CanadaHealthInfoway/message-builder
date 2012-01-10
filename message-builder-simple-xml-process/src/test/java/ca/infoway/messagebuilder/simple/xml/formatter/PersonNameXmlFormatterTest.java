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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.PN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class PersonNameXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformPersonSimpleXmlToPersonName() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<name" + ns  + " use=\"L\">a name</name>");
		PersonNameXmlFormatter formatter = new PersonNameXmlFormatter(new FormatterConfiguration());
		
		PN pn = formatter.format(new FormatterContextImpl(StandardDataType.PN_SIMPLE, null), document.getDocumentElement());
		assertNotNull("pn", pn);
		assertEquals(1, pn.getValue().getUses().size());
		assertEquals("L", pn.getValue().getUses().iterator().next().getCodeValue());
		
		assertEquals(1, pn.getValue().getParts().size());
		assertNull(pn.getValue().getParts().get(0).getType());
		assertEquals("a name", pn.getValue().getParts().get(0).getValue());
	}
	
	@Test
	public void shouldTransformPersonNameUsingSpecificPartsXmlToPersonName() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<name" + ns  + " use=\"L\"><title>myTitle</title><firstName>myFirstName</firstName><middleName>myMiddleName1</middleName><middleName>myMiddleName2</middleName><middleName>myMiddleName3</middleName><lastName>myLastName</lastName><suffix>mySuffix</suffix></name>");

		PersonNameXmlFormatter formatter = new PersonNameXmlFormatter(new FormatterConfiguration());
		
		PN pn = formatter.format(new FormatterContextImpl(StandardDataType.PN_BASIC, null), document.getDocumentElement());
		assertNotNull("pn", pn);
		assertEquals(1, pn.getValue().getUses().size());
		assertEquals("L", pn.getValue().getUses().iterator().next().getCodeValue());
		
		assertEquals(7, pn.getValue().getParts().size());
		assertEquals(PersonNamePartType.PREFIX, pn.getValue().getParts().get(0).getType());
		assertEquals("myTitle", pn.getValue().getParts().get(0).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(1).getType());
		assertEquals("myFirstName", pn.getValue().getParts().get(1).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(2).getType());
		assertEquals("myMiddleName1", pn.getValue().getParts().get(2).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(3).getType());
		assertEquals("myMiddleName2", pn.getValue().getParts().get(3).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(4).getType());
		assertEquals("myMiddleName3", pn.getValue().getParts().get(4).getValue());
		assertEquals(PersonNamePartType.FAMILY, pn.getValue().getParts().get(5).getType());
		assertEquals("myLastName", pn.getValue().getParts().get(5).getValue());
		assertEquals(PersonNamePartType.SUFFIX, pn.getValue().getParts().get(6).getType());
		assertEquals("mySuffix", pn.getValue().getParts().get(6).getValue());
	}
	
	@Test
	public void shouldTransformPersonNameUsingGenericPartsXmlToPersonName() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<name" + ns  + "><namePart partType=\"PFX\">myTitle</namePart><namePart partType=\"GIV\" qualifier=\"IN\">myFirstName</namePart><namePart partType=\"GIV\">myMiddleName1</namePart><namePart partType=\"GIV\">myMiddleName2</namePart><namePart partType=\"GIV\">myMiddleName3</namePart><namePart partType=\"FAM\">myLastName</namePart><namePart partType=\"SFX\">mySuffix</namePart></name>");

		PersonNameXmlFormatter formatter = new PersonNameXmlFormatter(new FormatterConfiguration());
		
		PN pn = formatter.format(new FormatterContextImpl(StandardDataType.PN_SEARCH, null), document.getDocumentElement());
		assertNotNull("pn", pn);
		assertTrue(pn.getValue().getUses().isEmpty());
		
		assertEquals(7, pn.getValue().getParts().size());
		assertEquals(PersonNamePartType.PREFIX, pn.getValue().getParts().get(0).getType());
		assertEquals("myTitle", pn.getValue().getParts().get(0).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(1).getType());
		assertEquals("myFirstName", pn.getValue().getParts().get(1).getValue());
		assertEquals("IN", pn.getValue().getParts().get(1).getQualifier());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(2).getType());
		assertEquals("myMiddleName1", pn.getValue().getParts().get(2).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(3).getType());
		assertEquals("myMiddleName2", pn.getValue().getParts().get(3).getValue());
		assertEquals(PersonNamePartType.GIVEN, pn.getValue().getParts().get(4).getType());
		assertEquals("myMiddleName3", pn.getValue().getParts().get(4).getValue());
		assertEquals(PersonNamePartType.FAMILY, pn.getValue().getParts().get(5).getType());
		assertEquals("myLastName", pn.getValue().getParts().get(5).getValue());
		assertEquals(PersonNamePartType.SUFFIX, pn.getValue().getParts().get(6).getType());
		assertEquals("mySuffix", pn.getValue().getParts().get(6).getValue());
	}

	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfUseMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<name" + ns  + "><namePart partType=\"PFX\">myTitle</namePart><namePart partType=\"GIV\">myFirstName</namePart><namePart partType=\"GIV\">myMiddleName1</namePart><namePart partType=\"GIV\">myMiddleName2</namePart><namePart partType=\"GIV\">myMiddleName3</namePart><namePart partType=\"FAM\">myLastName</namePart><namePart partType=\"SFX\">mySuffix</namePart></name>");
		PersonNameXmlFormatter formatter = new PersonNameXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(PN, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidNameIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<name" + ns  + "><namePart partType=\"PFX\">myTitle</namePart><namePart partType=\"GIV\">myFirstName</namePart><namePart partType=\"GIV\">myMiddleName1</namePart><namePart partType=\"GIV\">myMiddleName2</namePart><namePart partType=\"GIV\">myMiddleName3</namePart><namePart partType=\"FAM\">myLastName</namePart><namePart partType=\"SFX\">mySuffix</namePart></name>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		PersonNameXmlFormatter formatter = new PersonNameXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.PN, null);
		PN pn = formatter.format(formatContext, document.getDocumentElement());
		assertNull("pn", pn);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Must provide at least one use for name", formatContext.getErrors().get(0).getMessage());
	}
}
