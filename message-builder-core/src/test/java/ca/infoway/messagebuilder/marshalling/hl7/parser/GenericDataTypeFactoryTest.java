package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class GenericDataTypeFactoryTest {

	@Test
	public void shouldFindIntervalTypes() throws Exception {
		assertType("IVL<PQ.BASIC>");
		assertType("IVL<TS.FULLDATETIME>");
		assertType("IVL<TS.DATE>");
	}

	private void assertType(String type) {
		assertNotNull("type " + type, GenericDataTypeFactory.create(type));
	}
	
	@Test
	public void shouldFindListTypes() throws Exception {
		assertType("LIST<II.OID>");
		assertType("LIST<GTS.BOUNDEDPIVL>");
		assertType("LIST<PN.BASIC>");
		assertType("LIST<TEL.PHONEMAIL>");
	}
}
