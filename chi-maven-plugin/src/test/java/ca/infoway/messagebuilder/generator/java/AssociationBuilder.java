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

/**
 * 
 */
package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.lang.Association;
import ca.infoway.messagebuilder.generator.lang.LanguageSpecificName;
import ca.infoway.messagebuilder.generator.lang.Type;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class AssociationBuilder {

	private String name;
	private Cardinality cardinality;
	private Type type;
	private String businessName;
	private LanguageSpecificName languageSpecificName;
	
	public Association buildStandard() {
		Relationship relationship = new Relationship();
		relationship.setName(this.name);
		relationship.setCardinality(cardinality);
		if (this.type != null && this.type.getTypeName() != null) {
			relationship.setType(this.type.getTypeName().getName());
			this.type.setLanguageSpecificName(this.languageSpecificName);
		}
		if (businessName!=null) {
			Documentation documentation = new Documentation();
			documentation.setBusinessName(businessName);
			relationship.setDocumentation(documentation);
		}
		return Association.createStandardAssociation(relationship, this.type);
	}
	
	public AssociationBuilder setName(String name) {
		this.name = name;
		return this;
	}


	public AssociationBuilder setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality;
		return this;
	}

	public AssociationBuilder setType(Type type) {
		this.type = type;
		return this;
	}

	public AssociationBuilder setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public AssociationBuilder setLanguageSpecificName(String packageName, String className) {
		this.languageSpecificName = new LanguageSpecificName(packageName, className);
		return this;
	}

}