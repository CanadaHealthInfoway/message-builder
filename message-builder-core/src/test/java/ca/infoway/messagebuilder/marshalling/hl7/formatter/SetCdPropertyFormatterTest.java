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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetCdPropertyFormatterTest extends FormatterTestCase {

	private SetPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.formatter = new SetPropertyFormatter();
	}
	
	@Test
    public void testFormatValueNull() throws Exception {
        String result = this.formatter.format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CD>", ConformanceLevel.MANDATORY, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE), 
				new SETImpl<CD, Code>(CDImpl.class, NullFlavor.NO_INFORMATION));
        assertFalse(this.result.isValid()); // blah is mandatory
        assertEquals(1, this.result.getHl7Errors().size());
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNullNotMandatory() throws Exception {
    	String result = this.formatter.format(
    			new FormatContextImpl(this.result, null, "blah", "SET<CD>", ConformanceLevel.OPTIONAL, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE), 
    			null);
        assertTrue(this.result.isValid());
    	assertXml("null", "", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = this.formatter.format(
        		new FormatContextImpl(this.result, null, "blah", "SET<CD>", ConformanceLevel.MANDATORY, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE), 
				SETImpl.<CD, Code>create(CDImpl.class, 
						makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertTrue(this.result.isValid());
        assertXml("non null", "<blah code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\"/><blah code=\"kg\" codeSystem=\"2.16.840.1.113883.5.141\"/>", result);
    }

	@Test
    public void testFormatValueEmptySet() throws Exception {
    	String result = this.formatter.format(
    			new FormatContextImpl(this.result, null, "blah", "SET<CD>", ConformanceLevel.POPULATED, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE), 
				SETImpl.<CD, Code>create(CDImpl.class, new HashSet<Code>()));
        assertTrue(this.result.isValid());
    	assertXml("non null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
}
