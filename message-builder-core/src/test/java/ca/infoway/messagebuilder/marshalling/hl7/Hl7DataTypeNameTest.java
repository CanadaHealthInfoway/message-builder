package ca.infoway.messagebuilder.marshalling.hl7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Hl7DataTypeNameTest {
	
	@Test
	public void testShouldDetermineUnqualifiedName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("TS.FULLDATE");
		assertEquals("TS", name.getUnqualifiedVersion().toString());
	}
	@Test
	public void testShouldRecognizeQualifiedTypes() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("TS.FULLDATE");
		assertTrue("TS.FULLDATE", name.isQualified());
	}
	@Test
	public void testShouldDetermineUnqualifiedCollectionName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("SET<TS.FULLDATE>");
		assertEquals("SET<TS>", name.getUnqualifiedVersion().toString());
	}
	@Test
	public void testShouldDetermineUnqualifiedComplicatedName() throws Exception {
		Hl7DataTypeName name = Hl7DataTypeName.create("RTO<MO.CAD,PQ.BASIC>");
		assertEquals("RTO<MO,PQ>", name.getUnqualifiedVersion().toString());
	}
}
