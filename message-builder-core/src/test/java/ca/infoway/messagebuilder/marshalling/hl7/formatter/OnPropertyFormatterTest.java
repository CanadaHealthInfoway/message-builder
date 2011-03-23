package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.OrganizationNamePartType;

public class OnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new OnPropertyFormatter().format(getContext("name"), new ONImpl(null));
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNull() throws Exception {
        OnPropertyFormatter formatter = new OnPropertyFormatter();
        
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("Organization"));
        
        String result = formatter.format(getContext("name"), new ONImpl(organizationName));
        assertEquals("something in text node", "<name>Organization</name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        OnPropertyFormatter formatter = new OnPropertyFormatter();
        
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("prefix", OrganizationNamePartType.PREFIX));
        organizationName.addNamePart(new EntityNamePart("Organization"));
        organizationName.addNamePart(new EntityNamePart(",", OrganizationNamePartType.DELIMETER));
        organizationName.addNamePart(new EntityNamePart("Inc", OrganizationNamePartType.SUFFIX));
        
        String result = formatter.format(getContext("name"), new ONImpl(organizationName));
        assertEquals("something in text node with goofy sub nodes", "<name><prefix>prefix</prefix>Organization<delimiter>,</delimiter><suffix>Inc</suffix></name>", result.trim());
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        OnPropertyFormatter formatter = new OnPropertyFormatter();
		
        OrganizationName organizationName = new OrganizationName();
        organizationName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name"), new ONImpl(organizationName));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
}
