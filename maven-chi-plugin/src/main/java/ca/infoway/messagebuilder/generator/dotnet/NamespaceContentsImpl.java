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

package ca.infoway.messagebuilder.generator.dotnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeProvider;

class NamespaceContentsImpl implements NamespaceContents {

	public Map<String,List<String>> types = new HashMap<String,List<String>>();
	
	NamespaceContentsImpl(NameTranslator translator, TypeProvider provider) {
		for (Type type : provider.getAllMessageTypes()) {
			String packageName = translator.getPackageName(type.getTypeName());
			String className = translator.getClassNameWithoutPackage(type.getTypeName());
			if (!this.types.containsKey(packageName)) {
				this.types.put(packageName, new ArrayList<String>());
			}
			this.types.get(packageName).add(className);
		}
	}
	
	public List<String> getAllTypes(String namespaceName) {
		return this.types.get(namespaceName);
	}
}
