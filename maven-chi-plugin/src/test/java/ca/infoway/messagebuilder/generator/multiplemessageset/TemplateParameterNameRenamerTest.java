package ca.infoway.messagebuilder.generator.multiplemessageset;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class TemplateParameterNameRenamerTest {

	private String originalTemplateParameterName = TemplateParameterNameRenamer.TEMPLATE_PARAMETER_NAME_RENAMES.keySet().iterator().next();
	private String newTemplateParameterName = TemplateParameterNameRenamer.TEMPLATE_PARAMETER_NAME_RENAMES.get(originalTemplateParameterName);
	
	@Test
	public void shouldRenameArgumentTemplateParameterName() {
		Argument argument = new Argument();
		argument.setTemplateParameterName(this.originalTemplateParameterName);
				
		Interaction interaction = new Interaction();
		interaction.getArguments().add(argument);
		
		MessageSet messageSet = new MessageSet();
		messageSet.getInteractions().put("anInteraction", interaction);
		
		assertEquals("old", this.originalTemplateParameterName, argument.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, argument.getTemplateParameterName());
	}
	
	@Test
	public void shouldRenameNestedArgumentTemplateParameterName() {
		Argument nestedArgument = new Argument();
		nestedArgument.setTemplateParameterName(this.originalTemplateParameterName);
				
		Argument argument = new Argument();
		argument.getArguments().add(nestedArgument);
		
		Interaction interaction = new Interaction();
		interaction.getArguments().add(argument);
		
		MessageSet messageSet = new MessageSet();
		messageSet.getInteractions().put("anInteraction", interaction);
		
		assertEquals("old", this.originalTemplateParameterName, nestedArgument.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, nestedArgument.getTemplateParameterName());
	}
	
	@Test
	public void shouldRenameRelationshipTemplateParameterName() {
		Relationship relationship = new Relationship();
		relationship.setTemplateParameterName(this.originalTemplateParameterName);
		
		MessagePart messagePart = new MessagePart("ABCD_MT123456CA.MyMessagePart");
		messagePart.getRelationships().add(relationship);
		
		PackageLocation packageLocation = new PackageLocation("ABCD_MT123456CA");
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", packageLocation);
		messageSet.addMessagePart(messagePart);
		
		assertEquals("old", this.originalTemplateParameterName, relationship.getTemplateParameterName());
		new TemplateParameterNameRenamer().renameTemplateParameterNames(messageSet);
		assertEquals("new", this.newTemplateParameterName, relationship.getTemplateParameterName());
	}
	
}
