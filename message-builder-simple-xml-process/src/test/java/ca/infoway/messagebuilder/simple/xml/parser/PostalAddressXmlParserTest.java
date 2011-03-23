package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;


public class PostalAddressXmlParserTest extends AbstractXmlParserTest<AD> {

	public PostalAddressXmlParserTest() {
		super(new PostalAddressXmlParser(), "deliveryAddress", new ADImpl());
	}

	@Test
	public void shouldParseOnePart() throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("something"));
		
		assertEquals(
				"<deliveryAddress><addressPart>something</addressPart></deliveryAddress>",
				this.parser.parse(createContext(), new ADImpl(postalAddress)));
	}

	@Test
	public void shouldParseOnePartWithReservedXmlCharacters() throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addPostalAddressPart(new PostalAddressPart("<cats think they're > humans & dogs 99% of the time/>"));
		
		assertEquals(
				"<deliveryAddress><addressPart>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</addressPart></deliveryAddress>",
				this.parser.parse(createContext(), new ADImpl(postalAddress)));
	}

	@Test
	public void shouldParseMultipleParts() throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.getUses().add(PostalAddressUse.HOME);
		postalAddress.getUses().add(PostalAddressUse.WORK_PLACE);
		postalAddress.getUses().add(PostalAddressUse.POSTAL);
		postalAddress.addPostalAddressPart(new PostalAddressPart("addressline1"));
		postalAddress.addPostalAddressPart(new PostalAddressPart("addressline2"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.CITY, "myCity"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STATE, "ON"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, "M1L4V1"));
		postalAddress.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.COUNTRY, "CA"));
		
		assertEquals(
				"<deliveryAddress use=\"H WP PST\">" +
					"<addressPart>addressline1</addressPart>" +
					"<addressPart>addressline2</addressPart>" +
					"<addressPart type=\"CTY\">myCity</addressPart>" +
					"<addressPart type=\"STA\">ON</addressPart>" +
					"<addressPart type=\"ZIP\">M1L4V1</addressPart>" +
					"<addressPart type=\"CNT\">CA</addressPart>" +
				"</deliveryAddress>",
				this.parser.parse(createContext(), new ADImpl(postalAddress)));
		
	}

	@Test
	public void shouldParsePostalAddressUses() throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.addUse(PostalAddressUse.HOME);
		postalAddress.addUse(PostalAddressUse.PUBLIC);
		
		String parsedAddress = this.parser.parse(createContext(), new ADImpl(postalAddress));
		
		assertTrue("open tag", parsedAddress.startsWith("<deliveryAddress use=\""));
		assertTrue("H PUB", parsedAddress.contains("H PUB") || parsedAddress.contains("PUB H"));
		assertTrue("close tag", parsedAddress.trim().endsWith("\"></deliveryAddress>"));

	}
	
	@Override
	protected AD createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new ADImpl(nullFlavor);
	}

}
