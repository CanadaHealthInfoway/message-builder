package ca.infoway.messagebuilder.xml.util;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

public interface InteractionVisitor {

	public void visitInteraction(Interaction interaction, String xpath);

	public void visitMessagePart(MessagePart messagePart, String xpath);

	public void visitSpecializationChild(SpecializationChild specializationChild, String xpath);

	public void visitRelationship(Relationship relationship, String xpath);

	public void visitArgument(Argument argument, String xpath);
}
