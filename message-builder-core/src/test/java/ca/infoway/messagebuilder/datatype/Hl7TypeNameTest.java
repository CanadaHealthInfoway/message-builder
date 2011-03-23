package ca.infoway.messagebuilder.datatype;

import static ca.infoway.messagebuilder.datatype.Hl7TypeName.parse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class Hl7TypeNameTest {
	
	@Test
	public void shouldCorrectlyIndicateEquality() throws Exception {
		assertTrue("name", parse("RTO < PQ.DRUG, PQ.TIME >").equals(parse("RTO<PQ.DRUG,PQ.TIME>")));
		assertFalse("different specialization", parse("RTO < PQ.DRUG, PQ >").equals(parse("RTO<PQ.DRUG,PQ.TIME>")));
	}
}
