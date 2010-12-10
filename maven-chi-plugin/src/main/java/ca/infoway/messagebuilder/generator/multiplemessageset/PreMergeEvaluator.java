package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class PreMergeEvaluator implements ExcisionEvaluator {

	public boolean shouldRemove(Interaction interaction) {
		boolean ok = isAllDifferencesOkay(interaction);
		if (ok) {
			ok = checkArgumentsforOkayness(interaction.getArguments());
		}
		return !ok;
	}

	private boolean checkArgumentsforOkayness(List<Argument> arguments) {
		boolean ok = true;
		for (Argument argument : arguments) {
			ok &= isAllDifferencesOkay(argument);
			if (ok) {
				ok &= checkArgumentsforOkayness(argument.getArguments());
			} else {
				break;
			}
			
		}
		return ok;
	}
	
	public boolean shouldRemove(MessagePart messagePart) {
		boolean ok = isAllDifferencesOkay(messagePart);
		
		if (ok) {
			for (Relationship relationship : messagePart.getRelationships()) {
				ok &= isAllDifferencesOkay(relationship);
				if (ok) {
					ok &= checkChoicesForOkayness(relationship.getChoices());
				} else {
					break;
				}
			}
		}
		return !ok;
	}

	private boolean checkChoicesForOkayness(List<Relationship> choices) {
		boolean ok = true;
		for (Relationship relationship : choices) {
			ok &= isAllDifferencesOkay(relationship);
			if (ok) {
				ok &= checkChoicesForOkayness(relationship.getChoices());
			} else {
				break;
			}
		}
		return ok;
	}
	
	private boolean isAllDifferencesOkay(HasDifferences differences) {
		boolean ok = true;
		
		for (Difference difference : differences.getDifferences()) {
			if (!difference.isOk()) {
				ok = false;
				break;
			}
		}
		return ok;
	}
	
	public boolean shouldRemove(PackageLocation packageLocation) {
		return !isAllDifferencesOkay(packageLocation);
	}

}
