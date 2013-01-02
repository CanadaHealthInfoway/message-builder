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

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class XsdNameTranslator implements NameTranslator {

	private final String basePackageName;
	private NameCoordinator nameCoordinator;
	private Map<TypeName, Type> types;
	
	public XsdNameTranslator(String basePackageName, TypeNameHelper helper) {
		this.basePackageName = basePackageName;
		this.types = helper.getTypes();
		this.nameCoordinator = new SimpleNameCoordinator(helper);
	}
	public XsdNameTranslator(String basePackageName, NameCoordinator nameCoordinator) {
		this.basePackageName = basePackageName;
		this.nameCoordinator = nameCoordinator;
	}
	
	public String getClassNameWithoutPackage(TypeName name) {
		return this.nameCoordinator.getName(name);
	}

	public String getFullyQualifiedClassName(TypeName name) {
		return getPackageName(name) + "." + this.nameCoordinator.getName(name);
	}

	public String getPackageName(TypeName name) {
		String baseName = this.basePackageName;
		if (this.types != null && this.types.containsKey(name)) {
			String category = this.types.get(name).getCategory();
			if (StringUtils.isNotBlank(category)) {
				baseName += "." + category;
			}
		}
		return baseName;
	}
}
