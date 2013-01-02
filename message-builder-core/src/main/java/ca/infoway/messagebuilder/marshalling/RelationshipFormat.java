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

package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipFormat {

	private final String traversalName;
	private final String type;
	private final Argument argument;

	public RelationshipFormat(String traversalName, String type) {
		this.traversalName = traversalName;
		this.type = type;
		this.argument = null;
	}
	public RelationshipFormat(String traversalName, String type, Argument argument) {
		this.traversalName = traversalName;
		this.type = type;
		this.argument = argument;
	}

	public String getTraversalName() {
		return this.traversalName;
	}

	public String getXmlElementName() {
		return this.traversalName;
	}
	
	public String getType() {
		return this.type;
	}
	
	static RelationshipFormat getRelationshipFormat(ConversionContext context, Relationship relationship) {
		if (relationship.isTemplateRelationship()) {
			return context.resolveTemplateType(relationship);
		} else {
			return new RelationshipFormat(relationship.getName(), relationship.getType());
		}
	}
	public Argument getArgument() {
		return this.argument;
	}
}
