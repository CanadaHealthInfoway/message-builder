package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class XmlToModelResultTest {
	
	@Test
	public void testIsValid() throws Exception {
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		assertTrue("is valid", xmlToJavaResult.isValid());
		
		xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "monkey"));
		assertFalse("is not valid", xmlToJavaResult.isValid());
	}
}
