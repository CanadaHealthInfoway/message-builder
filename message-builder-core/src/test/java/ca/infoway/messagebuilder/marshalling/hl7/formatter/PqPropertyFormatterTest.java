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

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PqPropertyFormatterTest extends FormatterTestCase {
	
	private static class TestablePqPropertyFormatter extends PqPropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<PhysicalQuantity> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, PhysicalQuantity t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}
		public String formatNonNullDataTypeForTest(FormatContext context, BareANY bareAny, int indentLevel) {
			return super.formatNonNullDataType(context, bareAny, indentLevel);
		}
	}

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	
    @Test
    public void testFormatPhysicalQuantityNull() throws Exception {
        String result = new TestablePqPropertyFormatter().format(createContext("PQ.BASIC"), new PQImpl());
        
        // a null value for PQ elements results in a nullFlavor attribute (but not via calling getAttributeNameValuePairs, only through format() itself)
        assertEquals("map size", "<name nullFlavor=\"NI\"/>", result.trim());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatPhysicalQuantityNullMissingOriginalText() throws Exception {
        PQImpl dataType = new PQImpl(NullFlavor.NOT_APPLICABLE);
		String result = new TestablePqPropertyFormatter().format(createContext("PQ.LAB"), dataType);
        
        assertEquals("map size", "<name nullFlavor=\"NA\"/>", result.trim());
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
    }
    
    @Test
    public void testFormatPhysicalQuantityNotNullWithNullFlavorMissingOriginalText() throws Exception {
    	PhysicalQuantity pq = new PhysicalQuantity(null, ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.CENTIMETRE);
        PQImpl dataType = new PQImpl(NullFlavor.NOT_APPLICABLE);
        dataType.setValue(pq);
        
		String result = new TestablePqPropertyFormatter().format(createContext("PQ.LAB"), dataType);
        
        assertEquals("map size", "<name nullFlavor=\"NA\"/>", result.trim());
        assertFalse(this.result.isValid());
        assertEquals(2, this.result.getHl7Errors().size());
    }
    
    @Test
    public void testFormatPhysicalQuantityEmpty() throws Exception {
        Map<String,String> resultMap = new TestablePqPropertyFormatter().getAttributeNameValuePairs(createContext("PQ.BASIC"), new PhysicalQuantity());
        
        // an empty value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, resultMap.size());
        
        assertTrue("key as expected", resultMap.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, resultMap.get("nullFlavor"));
    }
    
    @Test
    public void testFormatPhysicalQuantityValueOrUnitNull() throws Exception {
        // no name-value pairs
        PqPropertyFormatter formatter = new TestablePqPropertyFormatter();
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setUnit(CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE);
        
        formatter.format(createContext("PQ.BASIC"), new PQImpl(physicalQuantity));
        
        assertEquals(1, this.result.getHl7Errors().size());
        
        assertEquals("exception message null quantity", "No value provided for physical quantity", this.result.getHl7Errors().get(0).getMessage());
    }

    
    @Test
    public void testFormatPhysicalQuantityValid() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        Map<String, String> result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(createContext("PQ.BASIC"), physicalQuantity);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
    }
    
    @Test
    public void testFormatPhysicalQuantityValidWithOriginalText() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        PQ rawPq = new PQImpl();
        rawPq.setOriginalText("some original text");
        rawPq.setValue(physicalQuantity);
        
		String result = new TestablePqPropertyFormatter().format(createContext("PQ.BASIC"), rawPq, 0);
		
		String expectedResult = "<name unit=\"U/L\" value=\"33.45\">" + SystemUtils.LINE_SEPARATOR +
								"  <originalText>some original text</originalText>" + SystemUtils.LINE_SEPARATOR +
								"</name>" + SystemUtils.LINE_SEPARATOR;
        assertEquals("output", expectedResult, result);
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
		this.result.clearErrors();
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        BigDecimal bigDecimal = new BigDecimal(quantity);
		physicalQuantity.setQuantity(bigDecimal);
        physicalQuantity.setUnit(CeRxDomainTestValues.FLUID_OUNCE);
        
    	String expectedErrorDecimal = "PhysicalQuantity for MR2009/PQ.BASIC can contain a maximum of 2 decimal places";
    	String expectedErrorInteger = "PhysicalQuantity for MR2009/PQ.BASIC can contain a maximum of 11 integer places";
    	
		new TestablePqPropertyFormatter().format(new FormatContextImpl(this.result,
				null, "name", "PQ.BASIC", ConformanceLevel.MANDATORY, null, false, SpecificationVersion.R02_04_02, null, null, null, false), new PQImpl(physicalQuantity), 0);
		if (decimalError) {
			assertEquals(expectedErrorDecimal, this.result.getHl7Errors().get(0).getMessage());
		}
		if (integerError) {
			assertEquals(expectedErrorInteger, this.result.getHl7Errors().get(decimalError && integerError ? 1 : 0).getMessage());
		}
    }
    
    @Test
    public void testFormatNonNullWithEmptyPq() {
    	TestablePqPropertyFormatter formatter = new TestablePqPropertyFormatter();
    	PQImpl pqImpl = new PQImpl();
    	pqImpl.setValue(new PhysicalQuantity());
		String string = formatter.formatNonNullDataTypeForTest(createContext("PQ.BASIC"), pqImpl, 0);
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
        Map<String, String> result = new TestablePqPropertyFormatter().getAttributeNameValuePairs(createContext("PQ.BASIC"), physicalQuantity);
        assertEquals("value " + quantity, formattedQuantity, result.get("value"));
    }

	private FormatContextImpl createContext(String type) {
		return new FormatContextImpl(this.result, null, "name", type, ConformanceLevel.POPULATED, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
	}
}
