package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.*;

import org.junit.Test;


public class FingerprintTest {

	@Test
	public void shouldConcat() throws Exception {
		
		Fingerprint fingerprint = new Fingerprint(RelationshipType.ATTRIBUTE, "name");
		Fingerprint fingerprint2 = new Fingerprint(RelationshipType.ASSOCIATION, "ABCD_MT123456CA.Person");
		assertEquals("string", "ABCD_MT123456CA.Person/name", fingerprint2.concat(fingerprint).toString());
	}
}
