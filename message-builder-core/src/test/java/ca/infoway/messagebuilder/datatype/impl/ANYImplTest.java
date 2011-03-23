package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class ANYImplTest {
	
	@Test
	public void twoNullFlavorsAreNeverEqual() throws Exception {
		ANYImpl<String> anyImpl1 = new BarDataType();
		anyImpl1.setNullFlavor(NullFlavor.ASKED_BUT_UNKNOWN);
		ANYImpl<String> anyImpl2 = new BarDataType();
		anyImpl2.setNullFlavor(NullFlavor.ASKED_BUT_UNKNOWN);
		assertFalse(anyImpl1.equals(anyImpl2));
	}

	@Test
	public void twoH7ValuesAreEqualWhenTheyAreNotNullFlavorsAndTheirValuesAreEqual() throws Exception {
		ANYImpl<String> anyImpl1 = new BarDataType();
		anyImpl1.setValue("same");
		ANYImpl<String> anyImpl2 = new BarDataType();
		anyImpl2.setValue("same");
		assertTrue(anyImpl1.equals(anyImpl2));
	}
	
	class BarDataType extends ANYImpl<String> {
	}
	
}
