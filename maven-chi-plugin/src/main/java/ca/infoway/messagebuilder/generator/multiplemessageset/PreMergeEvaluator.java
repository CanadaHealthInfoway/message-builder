/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
