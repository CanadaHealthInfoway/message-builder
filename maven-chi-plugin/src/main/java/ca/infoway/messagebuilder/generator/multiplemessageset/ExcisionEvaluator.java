package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

public interface ExcisionEvaluator {
	boolean shouldRemove(Interaction interaction);
	boolean shouldRemove(MessagePart messagePart);
	boolean shouldRemove(PackageLocation packageLocation);
}
