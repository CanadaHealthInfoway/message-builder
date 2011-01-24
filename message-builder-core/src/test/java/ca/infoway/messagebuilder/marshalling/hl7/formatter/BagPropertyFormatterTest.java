package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class BagPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new BagPropertyFormatter().format(
				new FormatContextImpl("telecom", "BAG<TEL>", OPTIONAL), 
				(BareANY) new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class));
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new BagPropertyFormatter().format(
				new FormatContextImpl("telecom", "BAG<TEL>", OPTIONAL), 
				(BareANY) LISTImpl.<TEL, TelecommunicationAddress>create(
						TELImpl.class, 
						createTelecommunicationAddressList()));
		assertXml("non null", "<telecom value=\"+1-519-555-2345;ext=12345\"/>" + 
							  "<telecom value=\"+1-416-555-2345;ext=12345\"/>", result);
	}

	private List<TelecommunicationAddress> createTelecommunicationAddressList() {
		ArrayList<TelecommunicationAddress> result = new ArrayList<TelecommunicationAddress>();
		TelecommunicationAddress phone1 = createTelecommunicationAddress("+1-519-555-2345;ext=12345");
		TelecommunicationAddress phone2 = createTelecommunicationAddress("+1-416-555-2345;ext=12345");
		result.add(phone1);
		result.add(phone2);
		return result;
	}

	private static TelecommunicationAddress createTelecommunicationAddress(String formattedPhoneNumber) {
		TelecommunicationAddress telecom = new TelecommunicationAddress();
		telecom.setAddress(formattedPhoneNumber);
		return telecom;
	}
}
