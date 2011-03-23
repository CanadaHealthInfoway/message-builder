package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.EntityNameUse;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class PersonNameXmlParserTest extends AbstractXmlParserTest<PN> {
	
	public PersonNameXmlParserTest() {
		super(new PersonNameXmlParser(), "name", new PNImpl());
	}
	
	@Test
	public void shouldParsePnSimple() throws Exception {
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("John Doe"));
        personName.getUses().add(EntityNameUse.LEGAL);

		assertEquals(
				"<name use=\"L\">John Doe</name>",
				this.parser.parse(createContext(), createPN(personName, StandardDataType.PN_SIMPLE)));
	}

	private PNImpl createPN(PersonName personName, StandardDataType dataType) {
		PNImpl pn = new PNImpl(personName);
		pn.setDataType(dataType);
		return pn;
	}

	@Test
	public void shouldParsePnBasic() throws Exception {
        PersonName personName = new PersonName();
        personName.getUses().add(EntityNameUse.LEGAL);
        personName.addNamePart(new EntityNamePart("myTitle", PersonNamePartType.PREFIX));
        personName.addNamePart(new EntityNamePart("myFirstName", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myMiddleName1", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myMiddleName2", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myMiddleName3", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myLastName", PersonNamePartType.FAMILY, "IN"));
        personName.addNamePart(new EntityNamePart("mySuffix", PersonNamePartType.SUFFIX));
        
		assertEquals(
				"<name use=\"L\">" +
					"<title>myTitle</title>" +
					"<firstName>myFirstName</firstName>" +
					"<middleName>myMiddleName1</middleName>" +
					"<middleName>myMiddleName2</middleName>" +
					"<middleName>myMiddleName3</middleName>" +
					"<lastName qualifier=\"IN\">myLastName</lastName>" +
					"<suffix>mySuffix</suffix></name>",
				this.parser.parse(createContext(), createPN(personName, StandardDataType.PN_BASIC)));
	}

	@Test
	public void shouldParsePnSearch() throws Exception {
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("myTitle", PersonNamePartType.PREFIX));
        personName.addNamePart(new EntityNamePart("myFirstName", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myMiddleName1", PersonNamePartType.GIVEN, "IN"));
        personName.addNamePart(new EntityNamePart("myMiddleName2", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myMiddleName3", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("myLastName", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("mySuffix", PersonNamePartType.SUFFIX));
        
		assertEquals(
				"<name>" +
					"<namePart partType=\"PFX\">myTitle</namePart>" +
					"<namePart partType=\"GIV\">myFirstName</namePart>" +
					"<namePart partType=\"GIV\" qualifier=\"IN\">myMiddleName1</namePart>" +
					"<namePart partType=\"GIV\">myMiddleName2</namePart>" +
					"<namePart partType=\"GIV\">myMiddleName3</namePart>" +
					"<namePart partType=\"FAM\">myLastName</namePart>" +
					"<namePart partType=\"SFX\">mySuffix</namePart></name>",
				this.parser.parse(createContext(), createPN(personName, StandardDataType.PN_SEARCH)));
	}
	
	@Test
	public void shouldParseOneNamePartWithReservedXmlChars() throws Exception {
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

		assertEquals(
				"<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>",
				this.parser.parse(createContext(), createPN(personName, StandardDataType.PN)));
	}
	
	@Override
	protected PN createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new PNImpl(nullFlavor);
	}

}
