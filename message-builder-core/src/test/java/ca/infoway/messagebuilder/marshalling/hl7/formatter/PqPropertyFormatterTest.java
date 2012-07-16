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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PqPropertyFormatterTest {

    private class TestablePqPropertyFormatter extends AbstractCerxPqPropertyFormatter {
    }
    
    @Test
    public void testFormatPhysicalQuantityNull() throws Exception {
        Map<String,String>  result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), null);
        
        // a null value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
    }
    
    @Test
    public void testFormatPhysicalQuantityEmpty() throws Exception {
        Map<String,String>  result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), new PhysicalQuantity());
        
        // an empty value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
    }
    
    @Test
    public void testFormatPhysicalQuantityValueOrUnitNull() throws Exception {
        // no name-value pairs
        TestablePqPropertyFormatter formatter = new TestablePqPropertyFormatter();
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setUnit(CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE);
        
        try {
            formatter.getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), physicalQuantity);
            fail("expected exception");
        } catch (ModelToXmlTransformationException e) {
            assertEquals("exception message null quantity", "PhysicalQuantity must define quantity", e.getMessage());
        }
    }

    
    @Test
    public void testFormatPhysicalQuantityValid() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        Map<String, String> result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), physicalQuantity);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
    }
    
    @Test
    public void testFormatPhysicalQuantityFormattingErrors() throws Exception {
        assertExceptionAsExpected("33.455", true, false);
        assertExceptionAsExpected("-33.455", true, false);
        assertExceptionAsExpected("123456789.455", true, false);
        assertExceptionAsExpected("-123456789.455", true, false);
        assertExceptionAsExpected("123456789012", false, true);
        assertExceptionAsExpected("-123456789012", false, true);
        assertExceptionAsExpected("1234567890123.12345", true, true);
        assertExceptionAsExpected("-1234567890123.12345", true, true);
    }

	private void assertExceptionAsExpected(String quantity, boolean decimalError, boolean integerError) {
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        BigDecimal bigDecimal = new BigDecimal(quantity);
		physicalQuantity.setQuantity(bigDecimal);
        physicalQuantity.setUnit(CeRxDomainTestValues.FLUID_OUNCE);
        
        try {
        	String expectedErrorMessage = MessageFormat.format(
        			"<!-- WARNING: {0}{1} -->",
        			decimalError ? "PhysicalQuantity can contain a maximum of 2 decimal places. Value has " + bigDecimal.scale() + " decimal places." : "",
        			integerError ? "PhysicalQuantity can contain a maximum of 11 integer places. Value has " + (bigDecimal.precision() - bigDecimal.scale()) + " integer places." : ""
        			);
        	
			String result = new TestablePqPropertyFormatter().format(new FormatContextImpl(new ModelToXmlResult(),
					null, "name", "PQ", ConformanceLevel.MANDATORY), new PQImpl(physicalQuantity), 0);
			assertEquals(expectedErrorMessage, StringUtils.substringBefore(result,SystemUtils.LINE_SEPARATOR));
		} catch (ModelToXmlTransformationException e) {
			fail("should not throw exception: " + e.getMessage());
		}
    }
    
    @Test
    public void testFormatNonNullWithEmptyPq() throws ModelToXmlTransformationException {
    	TestablePqPropertyFormatter formatter = new TestablePqPropertyFormatter();
    	PQImpl pqImpl = new PQImpl();
    	pqImpl.setValue(new PhysicalQuantity());
		String string = formatter.formatNonNullDataType(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), pqImpl, 0);
		String lineBreak = System.getProperty("line.separator");
		assertEquals("<name nullFlavor=\"NI\"/>" + lineBreak, string);
    }
    
    @Test
    public void testFormatPhysicalQuantityFormatting() throws Exception {
        assertFormattingAsExpected("33.4", "33.4");
        assertFormattingAsExpected("33.40", "33.40");
        assertFormattingAsExpected("33.41", "33.41");
        assertFormattingAsExpected("033.40", "33.40");
        assertFormattingAsExpected("0.40", "0.40");
        assertFormattingAsExpected("12345678.99", "12345678.99");
        assertFormattingAsExpected("12345678901.99", "12345678901.99");

        assertFormattingAsExpected("-33.4", "-33.4");
        assertFormattingAsExpected("-33.40", "-33.40");
        assertFormattingAsExpected("-33.41", "-33.41");
        assertFormattingAsExpected("-033.40", "-33.40");
        assertFormattingAsExpected("-0.40", "-0.40");
        assertFormattingAsExpected("-12345678.99", "-12345678.99");
        
        // now check values that will be truncated/rounded (UPDATE: not anymore due to Redmine 1570)
        assertFormattingAsExpected("-33.416", "-33.416");
        assertFormattingAsExpected("-33.41223", "-33.41223");
        assertFormattingAsExpected("123456789012.99", "123456789012.99");
    }
    
    /**
     * 
     * @sharpen.remove
     */
    @Test
    public void testEdgeCasesForFormatPhysicalQuantityFormattingThatCauseTroubleForDotNet() throws Exception {
        assertFormattingAsExpected("0.0", "0.0");
        assertFormattingAsExpected("-0.0", "0.0");
    }
    
    private void assertFormattingAsExpected(String quantity, String formattedQuantity) throws Exception {
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(CeRxDomainTestValues.CENTIMETRE);
        Map<String, String> result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), physicalQuantity);
        assertEquals("value " + quantity, formattedQuantity, result.get("value"));
    }
}
