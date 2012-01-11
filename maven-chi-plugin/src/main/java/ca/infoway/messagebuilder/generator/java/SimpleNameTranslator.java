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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.TypeName;

public class SimpleNameTranslator implements NameTranslator {

	private final String basePackageName;
	private NameCoordinator nameCoordinator;
	private Map<TypeName, Type> types;
	private final ProgrammingLanguage language;
	private final TypeNameHelper helper;
	
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper, NamingPolicy namingPolicy) {
		this.language = language;
		this.basePackageName = basePackageName;
		this.helper = helper;
		this.types = helper.getTypes();
		this.nameCoordinator = new SimpleNameCoordinator(helper, namingPolicy);
	}
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper, NameCoordinator nameCoordinator) {
		this.language = language;
		this.basePackageName = basePackageName;
		this.helper = helper;
		this.types = helper.getTypes();
		this.nameCoordinator = nameCoordinator;
	}
	
	public String getClassNameWithoutPackage(TypeName name) {
		return getPrefix(name) + this.nameCoordinator.getName(name) + getSuffix(name);
	}
	private String getSuffix(TypeName name) {
		if (this.language == ProgrammingLanguage.C_SHARP) {
			return "";
		} else if (this.helper.isAbstract(name)) {
			return "";
		} else {
			return "Bean";
		}
	}
	
	private String getPrefix(TypeName name) {
		if (this.language == JAVA) {
			return "";
		} else if (this.helper.isAbstract(name)) {
			return "I";
		} else {
			return "";
		}
	}

	public LanguageSpecificName getLanguageSpecificName(TypeName name) {
		return new LanguageSpecificName(getPackageName(name), getClassNameWithoutPackage(name));
	}
	
	public String getFullyQualifiedClassName(TypeName name) {
		return getPackageName(name) + "." + getClassNameWithoutPackage(name);
	}

	public String getPackageName(TypeName name) {
		String baseName = this.basePackageName;
		if (name.isInteraction()) {
			return baseName + getCategory(name) + ".interaction";
		} else {
			return baseName + getCategory(name) + "." + name.getRootName().getName().toLowerCase();
		}
	}
	private String getCategory(TypeName name) {
		if (this.types != null && this.types.containsKey(name)) {
			String category = this.types.get(name).getCategory();
			if (StringUtils.isNotBlank(category)) {
				category = "." + category;
			}
			return StringUtils.trimToEmpty(category);
		} else {
			return StringUtils.EMPTY;
		}
	}
}
