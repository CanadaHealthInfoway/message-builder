package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLILITRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;

public class AbstractCerxPqPropertyFormatterTest {
    
	@Test
	public void testFormatPhysicalQuantityNull() throws Exception {
        Map<String,String>  result = new PqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);
        
        // a null value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
    }
    
	@Test
    public void testFormatPhysicalQuantityEmpty() throws Exception {
        Map<String,String>  result = new PqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new PhysicalQuantity());
        
        // an empty value for PQ elements results in a nullFlavor attribute
        assertEquals("map size", 1, result.size());
        
        assertTrue("key as expected", result.containsKey("nullFlavor"));
        assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
    }
    
	@Test
    public void testFormatPhysicalQuantityValueOrUnitNull() throws Exception {
        // no name-value pairs
        PqPropertyFormatter formatter = new PqPropertyFormatter();
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setUnit(MILLIGRAM);
        
        try {
            formatter.getAttributeNameValuePairs(new FormatContextImpl("name", null, null), physicalQuantity);
            fail("expected exception");
        } catch (ModelToXmlTransformationException e) {
            assertEquals("exception message null quantity", "PhysicalQuantity must define quantity", e.getMessage());
        }
    }

	@Test
    public void testFormatPhysicalQuantityValid() throws Exception {
        String quantity = "33.45";
        UnitsOfMeasureCaseSensitive unit = MILLILITRE;
        
        PhysicalQuantity physicalQuantity = new PhysicalQuantity();
        physicalQuantity.setQuantity(new BigDecimal(quantity));
        physicalQuantity.setUnit(unit);
        
        Map<String, String> result = new PqPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), physicalQuantity);
        assertEquals("map size", 2, result.size());
        
        assertTrue("key as expected", result.containsKey("value"));
        assertEquals("value", quantity, result.get("value"));
        
        assertTrue("unit key as expected", result.containsKey("unit"));
        assertEquals("unit", unit.getCodeValue(), result.get("unit"));
    }
}
