package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import java.util.ArrayList;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ListTelPhonemailPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("blah", "LIST<TEL.PHONEMAIL>", OPTIONAL), 
				(BareANY) new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("blah", "LIST<TEL.PHONEMAIL>", OPTIONAL), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						new ArrayList<TelecommunicationAddress>(makeTelecommunicationAddressSet( "Fred"))));
		assertXml("non null", "<blah value=\"mailto://Fred\"/>", result);
	}

}
