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
 * Last modified: $LastChangedDate: 2014-02-14 11:22:06 -0500 (Fri, 14 Feb 2014) $
 * Revision:      $LastChangedRevision: 8399 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class EnR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testEnR2PropertyFormatterWhenConformanceLevelIsNotSpecified() throws Exception {
		String result = new EnR2PropertyFormatter().format(getContext("name", "EN"), new ENImpl<EntityName>());
		assertEquals("<name nullFlavor=\"NI\"/>", result.trim());
	}
    
	@Test
    public void testBasicForCeRxWithMultipleNameParts() throws Exception {
        EnR2PropertyFormatter formatter = new EnR2PropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addUse(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("Steve", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("Shaw", PersonNamePartType.FAMILY));
        
        String result = formatter.format(getContext("name", "EN", SpecificationVersion.V01R04_3), new PNImpl(personName));
		assertTrue(this.result.isValid());
        assertXml("something in text node", "<name use=\"L\"><given>Steve</given><family>Shaw</family></name>", result, true);
    }

}
