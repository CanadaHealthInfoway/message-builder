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

package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.messagebuilder.xml.TypeName;


public class ComplexTypePackage {

	protected Map<String,Type> types = Collections.synchronizedMap(new TreeMap<String,Type>());
	private final TypeName name;

    public ComplexTypePackage(TypeName name) {
		this.name = name;
    }

	public void addInnerClass(String typeName, Type type) {
	    this.types.put(typeName, type);
	}

	public Map<String, Type> getTypes() {
	    return this.types;
	}

	public TypeName getName() {
		return this.name;
	}

	public void removeInnerClass(TypeName name) {
		this.types.remove(name.getName());
	}
	
}
