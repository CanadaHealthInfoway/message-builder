package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class SetTelPhonemailPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new SetPropertyFormatter().format(new FormatContextImpl("blah", "SET<TEL.PHONEMAIL>", MANDATORY), 
				new SETImpl<TEL, TelecommunicationAddress>(
						TELImpl.class, 
						NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new SetPropertyFormatter().format(new FormatContextImpl("blah", "SET<TEL.PHONEMAIL>", MANDATORY),
				SETImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, makeTelecommunicationAddressSet( "Fred")));
		assertXml("non null", "<blah value=\"mailto://Fred\"/>", result);
	}

}
