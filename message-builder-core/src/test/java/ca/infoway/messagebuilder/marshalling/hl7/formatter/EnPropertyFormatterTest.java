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

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class EnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testEnPropertyFormatterWhenConformanceLevelIsNotSpecified() throws Exception {
		String result = new EnPropertyFormatter().format(getContext("name"), new ENImpl<EntityName>());
		assertEquals("<name nullFlavor=\"NI\"/>", result.trim());
	}
    
	@Test
	public void testEnPropertyFormatterWhenConformanceLevelIsSetToNullFlavor() throws Exception {
		String result = new EnPropertyFormatter().format(getContext("name"), new ENImpl<EntityName>(NullFlavor.ASKED_BUT_UNKNOWN));
		assertEquals("<name nullFlavor=\"ASKU\"/>", result.trim());
	}
    
	@Test
    public void testFormatValueTrivialName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        
        EntityName name = new TrivialName("something");
        assertEquals("TrivialName uses TN formatter", 
        		"<x xsi:type=\"TN\">something</x>", 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)).trim());
    }
    
	@Test
    public void testFormatValueOrganizationName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        
        OrganizationName name = new OrganizationName();
        name.addNamePart(new EntityNamePart("prefix", OrganizationNamePartType.PREFIX));
        name.addNamePart(new EntityNamePart("Organization"));

        assertEquals("OrganizationName uses ON formatter", 
        		"<x xsi:type=\"ON\"><prefix>prefix</prefix>Organization</x>", 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)).trim());
    }
    
	@Test
    public void testFormatValuePersonName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        
        PersonName name = new PersonName();
        name.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX));
        name.addNamePart(new EntityNamePart("given", PersonNamePartType.GIVEN));

        assertEquals("PersonName uses PN formatter", 
        		"<x xsi:type=\"PN\"><prefix>prefix</prefix><given>given</given></x>", 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)).trim());
    }
	
	@Test
    public void testFormatValueNoSpecializationType() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        
        EntityName name = new EntityName();
        name.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX));
        name.addNamePart(new EntityNamePart("given", PersonNamePartType.GIVEN));

        assertEquals("result", 
        		"<x><prefix>prefix</prefix><given>given</given></x>", 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)).trim());
        System.out.println("");
    }
}
