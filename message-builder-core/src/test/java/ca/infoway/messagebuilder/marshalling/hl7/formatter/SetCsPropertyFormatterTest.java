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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.CodingStrength;

public class SetCsPropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CS>", MANDATORY, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE), 
				new SETImpl<CS, Code>(CSImpl.class, NullFlavor.NO_INFORMATION));
        assertFalse(this.result.isValid()); // blah is mandatory
        assertEquals(1, this.result.getHl7Errors().size());
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CS>", "x_BasicUnitsOfMeasure", MANDATORY, null, false, SpecificationVersion.R02_04_02, null, null, true, CodingStrength.CNE),
				SETImpl.<CS, Code>create(CSImpl.class, 
	        			makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertTrue(this.result.isValid());
        assertXml("non null", "<blah code=\"cm\"/><blah code=\"kg\"/>", result);
    }

}
