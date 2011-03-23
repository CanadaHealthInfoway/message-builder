package ca.infoway.messagebuilder.datatype;

import static ca.infoway.messagebuilder.datatype.StandardDataType.convertSimpleXmlToDataType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class StandardDataTypeTest {
	
	@Test
	public void shouldGetHl7TypeName() throws Exception {
		Hl7TypeName typeName = StandardDataType.AD_BASIC.getTypeName();
		assertEquals("name", "AD.BASIC", typeName.toString());
		assertEquals("unqualified name", "AD", typeName.getUnspecializedName());
	}

	@Test
	public void shouldGetRootName() throws Exception {
		assertEquals("AD", "AD", StandardDataType.AD_BASIC.getTypeName().getRootName());
		assertEquals("IVL", "IVL", StandardDataType.IVL_FULL_DATE.getTypeName().getRootName());
	}

	@Test
	public void shouldCalculateIsCoded() throws Exception {
		assertTrue("CD", StandardDataType.CD.isCoded());
		assertTrue("CD.LAB", StandardDataType.CD_LAB.isCoded());
		assertTrue("CV", StandardDataType.CV.isCoded());
		assertFalse("ST", StandardDataType.ST.isCoded());
	}
	
	@Test
	public void shouldResolveSimpleXmlType() throws Exception {
		assertEquals("II", StandardDataType.II, convertSimpleXmlToDataType("InstanceIdentifier"));
		assertEquals("TS.DATE", StandardDataType.TS_DATE, convertSimpleXmlToDataType("PartialDate"));
	}
	
}
