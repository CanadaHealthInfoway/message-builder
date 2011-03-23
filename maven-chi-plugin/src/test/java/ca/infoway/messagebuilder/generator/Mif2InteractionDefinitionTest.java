package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePartResolver;

@RunWith(JMock.class)
public class Mif2InteractionDefinitionTest {
	
	private Mockery jmock = new Mockery();
	private MessagePartResolver resolver = this.jmock.mock(MessagePartResolver.class);
	
	@Test
	public void shouldExtractInteraction() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(resolver).getPackageLocationRootType("MCCI_MT002300CA"); will(returnValue("MCCI_MT002300CA.Message"));
			one(resolver).getPackageLocationRootType("MFMI_MT700726CA"); will(returnValue("MFMI_MT700726CA.ControlActEvent"));
			one(resolver).getPackageLocationRootType("PRPA_MT101102CA"); will(returnValue("PRPA_MT101102CA.IdentifiedEntity"));
		}});
		
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(getClass(), "PRPA_IN101205CA - Person Revise Event Accept.mif"));
		Interaction interaction = new Mif2InteractionDefinition(document, null, null).extract(this.resolver);
		assertEquals("name", "PRPA_IN101205CA", interaction.getName());
		assertEquals("businessName", "Person Revise Event Accept", interaction.getBusinessName());
		assertEquals("super type", "MCCI_MT002300CA.Message", interaction.getSuperTypeName());
		assertEquals("arguments", 1, interaction.getArguments().size());
		assertEquals("argument name", "MFMI_MT700726CA.ControlActEvent", interaction.getArguments().get(0).getName());
	}

}
