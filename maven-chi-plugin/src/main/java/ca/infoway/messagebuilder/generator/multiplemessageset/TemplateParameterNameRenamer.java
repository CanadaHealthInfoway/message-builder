package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

class TemplateParameterNameRenamer {

	static Map<String, String> TEMPLATE_PARAMETER_NAME_RENAMES = new HashMap<String, String>();
	static{
		TEMPLATE_PARAMETER_NAME_RENAMES.put("ControlActProcess", "ControlActEvent");
	}
	
	void renameTemplateParameterNames(MessageSet... messageSets) {
		for (MessageSet messageSet : messageSets) {
			if (messageSet != null) {
				for (Interaction interaction : messageSet.getInteractions().values()) {
					renameArgumentTemplateParameterName(interaction.getArguments());
				}
				for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
					for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
						renameRelationshipTemplateParameterName(messagePart.getRelationships());
					}
				}
			}
		}
	}

	private void renameRelationshipTemplateParameterName(List<Relationship> relationships) {
		for (Relationship relationship : relationships) {
			String originalTemplateParameterName = relationship.getTemplateParameterName();
			relationship.setTemplateParameterName(renameTemplateParameterNameifNecessary(originalTemplateParameterName));
			renameRelationshipTemplateParameterName(relationship.getChoices());
		}
	}

	private void renameArgumentTemplateParameterName(List<Argument> arguments) {
		for (Argument argument : arguments) {
			String originalTemplateParameterName = argument.getTemplateParameterName();
			argument.setTemplateParameterName(renameTemplateParameterNameifNecessary(originalTemplateParameterName));
			renameRelationshipTemplateParameterName(argument.getChoices());
			renameArgumentTemplateParameterName(argument.getArguments());
		}
	}

	private String renameTemplateParameterNameifNecessary(String originalTemplateParameterName) {
		String result = originalTemplateParameterName;
		if (TEMPLATE_PARAMETER_NAME_RENAMES.containsKey(originalTemplateParameterName)) {
			result = TEMPLATE_PARAMETER_NAME_RENAMES.get(originalTemplateParameterName);
		}
		return result;
	}

}
