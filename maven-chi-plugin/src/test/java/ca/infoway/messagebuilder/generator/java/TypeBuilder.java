/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.TypeName;

public class TypeBuilder {
	private String name;
	private List<BaseRelationship> relationships = new ArrayList<BaseRelationship>();
	public TypeBuilder() {
	}
	public TypeBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public TypeBuilder addRelationship(BaseRelationship relationship) {
		this.relationships.add(relationship);
		return this;
	}
	public Type build() {
		Type type = new Type(new TypeName(this.name));
		type.getRelationships().addAll(this.relationships);
		return type;
	}
}