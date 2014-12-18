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
 * Last modified: $LastChangedDate: 2014-05-22 15:54:32 -0400 (Thu, 22 May 2014) $
 * Revision:      $LastChangedRevision: 8676 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PqR2PropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	
    @Test
    public void testFormatPhysicalQuantityNull() throws Exception {
        String result = new PqR2PropertyFormatter().format(createContext("PQ"), new PQImpl());
        
        // a null value for PQ elements results in a nullFlavor attribute (but not via calling getAttributeNameValuePairs, only through format() itself)
        assertEquals("map size", "<name nullFlavor=\"NI\"/>", result.trim());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatPhysicalQuantitySpecificNull() throws Exception {
        PQImpl dataType = new PQImpl(NullFlavor.NOT_APPLICABLE);
		String result = new PqR2PropertyFormatter().format(createContext("PQ"), dataType);
        
        assertEquals("map size", "<name nullFlavor=\"NA\"/>", result.trim());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatPhysicalQuantityNotNullWithNullFlavor() throws Exception {
    	
    	// in this case, NF "wins"
    	
    	PhysicalQuantity pq = new PhysicalQuantity(null, ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.CENTIMETRE);
        PQImpl dataType = new PQImpl(NullFlavor.NOT_APPLICABLE);
        dataType.setValue(pq);
        
		String result = new PqR2PropertyFormatter().format(createContext("PQ"), dataType);
        
        assertEquals("map size", "<name nullFlavor=\"NA\"/>", result.trim());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatPhysicalQuantityEmpty() throws Exception {
        Map<String,String> resultMap = new PqR2PropertyFormatter().getAttributeNameValuePairs(createContext("PQ"), new PhysicalQuantity(), null);
        
        // an empty value for PQ elements results no attributes whatsoever
        assertEquals("map size", 0, resultMap.size());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatPhysicalQuantityValueOrUnitNull() throws Exception {
        // no name-value pairs
        PqR2PropertyFormatter formatter = new PqR2PropertyFormatter();
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setUnit(CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE);
        
        String result = formatter.format(createContext("PQ"), new PQImpl(physicalQuantity));
        
        assertTrue(this.result.isValid());
        assertEquals("map size", "<name unit=\"U/L\"/>", result.trim());
    }

    
    @Test
    public void testFormatPhysicalQuantityValid() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        Map<String, String> result = new PqR2PropertyFormatter().getAttributeNameValuePairs(createContext("PQ"), physicalQuantity, null);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
    }
    
    @Test
    public void testFormatPhysicalQuantityValidWithTranslations() throws Exception {
    	
    	CodedTypeR2<Code> translation1 = new CodedTypeR2<Code>();
    	translation1.setCode(AdministrativeGender.MALE);
    	
    	CodedTypeR2<Code> translation2 = new CodedTypeR2<Code>();
    	translation2.setCode(ActStatus.ACTIVE);
    	
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        physicalQuantity.getTranslation().add(translation1);
        physicalQuantity.getTranslation().add(translation2);
        
        Map<String, String> result = new PqR2PropertyFormatter().getAttributeNameValuePairs(createContext("PQ"), physicalQuantity, null);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
        
		String xml = new PqR2PropertyFormatter().format(createContext("PQ"), new PQImpl(physicalQuantity), 0);
		
		assertXml("should see translations", "<name unit=\"U/L\" value=\"33.45\"><translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><translation code=\"active\" codeSystem=\"2.16.840.1.113883.5.14\"/></name>", xml);
        
    }
    
    @Test
    public void testFormatValidPhysicalQuantity() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        PQ rawPq = new PQImpl(physicalQuantity);
        
		String result = new PqR2PropertyFormatter().format(createContext("PQ"), rawPq, 0);
		
		String expectedResult = "<name unit=\"U/L\" value=\"33.45\"/>";
        assertEquals("output", expectedResult, result.trim());
    }
    
    @Test
    public void testFormatNonNullWithEmptyPq() {
    	
    	// nullFlavor, value, and unit are all optional in the schema (unit will default to "1")
    	
    	PqR2PropertyFormatter formatter = new PqR2PropertyFormatter();
    	PQImpl pqImpl = new PQImpl();
    	pqImpl.setValue(new PhysicalQuantity());
		String result = formatter.formatNonNullDataType(createContext("PQ"), pqImpl, 0);
		assertEquals("<name/>", result.trim());
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
    
    @Test
    public void testFormatValidPhysicalQuantityWithOperatorNotAllowed() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        PQ rawPq = new PQImpl(physicalQuantity);
        rawPq.setOperator(SetOperator.PERIODIC_HULL);
        
		String result = new PqR2PropertyFormatter().format(createContext("PQ"), rawPq, 0);
		
		String expectedResult = "<name unit=\"U/L\" value=\"33.45\"/>";
        assertEquals("output", expectedResult, result.trim());
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
    }
    
    @Test
    public void testFormatSxcmPhysicalQuantityWithOperator() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        PQ rawPq = new PQImpl(physicalQuantity);
        rawPq.setOperator(SetOperator.PERIODIC_HULL);
        
		String result = new PqR2PropertyFormatter().format(createContext("SXCM<PQ>"), rawPq, 0);
		
		String expectedResult = "<name operator=\"P\" unit=\"U/L\" value=\"33.45\"/>";
        assertEquals("output", expectedResult, result.trim());
        assertTrue(this.result.isValid());
    }
    
    @Test
    public void testFormatSxcmPhysicalQuantityWithoutOperator() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = CeRxDomainTestValues.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        PQ rawPq = new PQImpl(physicalQuantity);
        
		String result = new PqR2PropertyFormatter().format(createContext("SXCM<PQ>"), rawPq, 0);
		
		String expectedResult = "<name unit=\"U/L\" value=\"33.45\"/>";
        assertEquals("output", expectedResult, result.trim());
        assertTrue(this.result.isValid());
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
        Map<String, String> result = new PqR2PropertyFormatter().getAttributeNameValuePairs(createContext("PQ"), physicalQuantity, null);
        assertEquals("value " + quantity, formattedQuantity, result.get("value"));
    }

	private FormatContextImpl createContext(String type) {
		return new FormatContextImpl(this.result, null, "name", type, ConformanceLevel.POPULATED, null, false, SpecificationVersion.R02_04_02, null, null, null, false);
	}
}
