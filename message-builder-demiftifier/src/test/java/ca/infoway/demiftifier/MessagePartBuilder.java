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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.demiftifier;

import org.junit.Assert;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.SpecializationChild;

public class MessagePartBuilder {
	
	public static final MessagePartBuilder basicBuilder(String messagePartName) {
		return new MessagePartBuilder(messagePartName);
	}

	private final MessagePart messagePart;
	
	private MessagePartBuilder(String messagePartName) {
		this.messagePart = new MessagePart(messagePartName);
		this.messagePart.setRimClass(RimClass.ACT);
	}
	
	public MessagePart build() {
		return this.messagePart;
	}

	public MessagePartBuilder withRimClass(RimClass rimClass) {
		messagePart.setRimClass(rimClass);
		return this;
		
	}

	public MessagePartBuilder withAssociation(String name, String typeName) {
		Relationship association = new Relationship(name, typeName, Cardinality.create("1"));
		if (!association.isAssociation()){
			Assert.fail("The type name [ " + typeName + "] is not valid for an association relationship!" +
					"  Should have '_' as 4th character. See Relationship.isAttribute()");
		}
		this.messagePart.getRelationships().add(association);
		return this;
	}

	public MessagePartBuilder withSpecChild(String childPartName) {
		this.messagePart.getSpecializationChilds().add(new SpecializationChild(childPartName));
		return this;
	}

	public MessagePartBuilder withSpecChild(String childPartName, String cmetBindingName, String cmetDerivationClassName) {
		this.messagePart.getSpecializationChilds().add(new SpecializationChild(childPartName, cmetBindingName, cmetDerivationClassName));
		return this;
	}
	
	public MessagePartBuilder asAbstract(boolean isAbstract) {
		this.messagePart.setAbstract(isAbstract);
		return this;
	}

	public MessagePartBuilder withTemplateRelationship(String relationshipName,	String templateParameterName) {
		Relationship relationship = new Relationship();
		relationship.setName(relationshipName);
		relationship.setTemplateParameterName(templateParameterName);
		this.messagePart.getRelationships().add(relationship);
		return this;
	}

	
}
