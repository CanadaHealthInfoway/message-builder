/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
