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

package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.xml.Relationship;

class SimplifiableRelationship implements Named, Fingerprintable {

	private final Relationship relationship;
	private DataType dataType;
	private SimplifiableType type;
	private TemplateVariable variable;

	public SimplifiableRelationship(Relationship relationship, DataType dataType) {
		this.relationship = relationship;
		this.dataType = dataType;
	}

	public SimplifiableRelationship(Relationship relationship, SimplifiableType type) {
		this.relationship = relationship;
		this.type = type;
	}
	public SimplifiableRelationship(Relationship relationship, TemplateVariable variable) {
		this.relationship = relationship;
		this.variable = variable;
	}
	
	public Relationship getRelationship() {
		return this.relationship;
	}

	public DataType getDataType() {
		return this.dataType;
	}

	public SimplifiableType getType() {
		return this.type;
	}

	public TemplateVariable getVariable() {
		return this.variable;
	}

	public String getName() {
		return this.relationship.getName();
	}

	public boolean isAssociation() {
		return this.relationship.isAssociation();
	}
	public boolean isChoice() {
		return this.relationship.isChoice();
	}
	public boolean isTemplateType() {
		return this.relationship.isTemplateRelationship();
	}
	public boolean isTemplateParameterPresent() {
		return this.variable != null;
	}

	public Fingerprint getFingerprint() {
		if (this.relationship.isAttribute()) {
			return new Fingerprint(RelationshipType.ATTRIBUTE, this.relationship.getName());
		} else if (this.relationship.isTemplateRelationship()) {
			return new Fingerprint(RelationshipType.ASSOCIATION, this.relationship.getTemplateParameterName());
		} else if (this.type.getMergedTypeName() != null) {
			return new Fingerprint(RelationshipType.ASSOCIATION, this.type.getMergedTypeName().getName());
		} else {
			return new Fingerprint(RelationshipType.ASSOCIATION, this.type.getTypeName().getName());
		}
	}
}
