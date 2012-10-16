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

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class AbstractCerxPqPropertyFormatterTest extends FormatterTestCase {
    
	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testFormatPhysicalQuantityNull() throws Exception {
        String formatResult = new PqPropertyFormatter().format(createContext(), new PQImpl());
        
        // a null value for PQ elements results in a nullFlavor attribute
        assertEquals("result", "<name nullFlavor=\"NI\"/>", formatResult.trim());
    }
    
	@Test
    public void testFormatPhysicalQuantityEmpty() throws Exception {
        Map<String,String>  result = new PqPropertyFormatter().getAttributeNameValuePairs(createContext(), new PhysicalQuantity(), null);
        
        // an empty value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
    }

	private FormatContextImpl createContext() {
		return new FormatContextImpl(this.result, null, "name", "PQ.BASIC", null, false, SpecificationVersion.V01R04_3, null, null, null);
	}
    
	@Test
    public void testFormatPhysicalQuantityValueOrUnitNull() throws Exception {
        // no name-value pairs
        PqPropertyFormatter formatter = new PqPropertyFormatter();
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setUnit(MILLIGRAM);

        formatter.format(createContext(), new PQImpl(physicalQuantity));
        
        assertEquals("No value provided for physical quantity", this.result.getHl7Errors().get(0).getMessage());
        
    }

	@Test
    public void testFormatPhysicalQuantityValid() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = MILLILITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        Map<String, String> result = new PqPropertyFormatter().getAttributeNameValuePairs(createContext(), physicalQuantity, null);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
    }
}
