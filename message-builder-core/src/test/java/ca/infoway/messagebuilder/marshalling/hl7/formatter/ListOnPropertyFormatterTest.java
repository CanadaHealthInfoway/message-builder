package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ListOnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("name", "LIST<ON>", OPTIONAL), 
				new LISTImpl<ON, OrganizationName>(ONImpl.class));
		assertXml("null", "", result);
	}

	@Test
    public void testFormatValueNullMandatory() throws Exception {
        String result = new ListPropertyFormatter().format(
        		new FormatContextImpl("blah", "LIST<ON>", ConformanceLevel.MANDATORY), 
				(BareANY) new LISTImpl<ON, OrganizationName>(ONImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListPropertyFormatter().format(
				new FormatContextImpl("name", "LIST<ON>", MANDATORY),
				LISTImpl.<ON, OrganizationName>create(ONImpl.class, createOrganizationNameList()));
		
		assertEquals("non null", 
				"<name>Organization 1</name>" + LINE_SEPARATOR + "<name>Organization 2</name>" + LINE_SEPARATOR, 
				result);
	}

	private List<OrganizationName> createOrganizationNameList() {
		ArrayList<OrganizationName> result = new ArrayList<OrganizationName>();
		result.add(createOrganizationName("Organization 1"));
		result.add(createOrganizationName("Organization 2"));
		return result;
	}

	private OrganizationName createOrganizationName(String name) {
		OrganizationName organizationName = new OrganizationName();
		List<EntityNamePart> parts = organizationName.getParts();
		parts.add(new EntityNamePart(name));
		return organizationName;
	}
}
