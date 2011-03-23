package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.OrganizationNamePartType;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;

public class EnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testEnPropertyFormatterWhenConformanceLevelIsNotSpecified() throws Exception {
		String result = new EnPropertyFormatter().format(getContext("name"), new ENImpl<EntityName>());
		assertEquals("<name nullFlavor=\"NI\"/>", result.trim());
	}
    
	@Test
    public void testFormatValueTrivialName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        TnPropertyFormatter tnFormatter = new TnPropertyFormatter();
        
        EntityName name = new TrivialName("something");
        assertEquals("TrivialName uses TN formatter", 
        		tnFormatter.format(getContext("x"), new TNImpl((TrivialName) name)), 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)));
    }
    
	@Test
    public void testFormatValueOrganizationName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        OnPropertyFormatter onFormatter = new OnPropertyFormatter();
        
        OrganizationName name = new OrganizationName();
        name.addNamePart(new EntityNamePart("prefix", OrganizationNamePartType.PREFIX));
        name.addNamePart(new EntityNamePart("Organization"));

        assertEquals("OrganizationName uses ON formatter", 
        		onFormatter.format(getContext("x"), new ONImpl(name)), 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)));
    }
    
	@Test
    public void testFormatValuePersonName() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        PnPropertyFormatter pnFormatter = new PnPropertyFormatter();
        
        PersonName name = new PersonName();
        name.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX));
        name.addNamePart(new EntityNamePart("given", PersonNamePartType.GIVEN));

        assertEquals("PersonName uses PN formatter", 
        		pnFormatter.format(getContext("x"), new PNImpl(name)), 
        		formatter.format(getContext("x"), new ENImpl<EntityName>(name)));
    }
}
