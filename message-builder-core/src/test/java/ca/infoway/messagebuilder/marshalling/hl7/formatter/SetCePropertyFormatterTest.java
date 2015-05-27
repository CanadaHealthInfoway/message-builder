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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetCePropertyFormatterTest extends FormatterTestCase {

	private FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();
	
	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter(this.formatterRegistry).format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CE>", ConformanceLevel.MANDATORY, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, false), 
				new SETImpl<CE, Code>(CEImpl.class, NullFlavor.NO_INFORMATION));
        assertFalse(this.result.isValid()); // blah is mandatory
        assertEquals(1, this.result.getHl7Errors().size());
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = new SetPropertyFormatter(this.formatterRegistry).format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CE>", "x_BasicUnitsOfMeasure", ConformanceLevel.MANDATORY, Cardinality.create("1-4"), false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, null, false), 
				SETImpl.<CE, Code>create(CEImpl.class, 
        			makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertTrue(this.result.isValid());
        assertXml("non null", "<blah code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\"/><blah code=\"kg\" codeSystem=\"2.16.840.1.113883.5.141\"/>", result);
    }

}
