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

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.TypeName;

public class SimpleNameTranslator implements NameTranslator {

	private final String basePackageName;
	private NameCoordinator nameCoordinator;
	private Map<TypeName, Type> types;
	private final ProgrammingLanguage language;
	private final TypeNameHelper helper;
	private final boolean isCda;
	
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper, NamingPolicy namingPolicy, boolean isCda) {
		this(language, basePackageName, helper, new SimpleNameCoordinator(helper, namingPolicy), isCda);
	}
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper, NameCoordinator nameCoordinator, boolean isCda) {
		this.language = language;
		this.basePackageName = basePackageName;
		this.helper = helper;
		this.types = helper.getTypes();
		this.nameCoordinator = nameCoordinator;
		this.isCda = isCda;
	}
	
	public String getClassNameWithoutPackage(TypeName name) {
		if (name.isCdaDocumentRoot()) {
			return getPrefix(name) + name.getRootName().getName() + getSuffix(name);	// EXPERIMENT
		} else {
			return getPrefix(name) + this.nameCoordinator.getName(name) + getSuffix(name);
		}
	}
	private String getSuffix(TypeName name) {
		// TODO DOTNETCDA In the Java code, we are suppressing the "Bean" suffix for the interaction class, to eliminate
		//  the name collision and allow the class to be moved into the same package with all the message parts. Since
		//  the .Net classes never had the "Bean" suffix in the first place, what is the corresponding change?
		if (this.language == ProgrammingLanguage.C_SHARP) {
			return "";
		} else if (this.helper.isAbstract(name) || (this.isCda && name.isInteraction())) {
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
			// TODO DOTNETCDA The concept of an "interaction" isn't native to the CDA paradigm.
			//  To prevent confusion, we are moving them to their "home" directories
			//  this code may not produce the right results for .Net, since the above getSuffix() code
			//  may be producing a name collision.
			if (this.isCda) {
				return baseName + getCategory(name) + "." + name.getName().toLowerCase();
			} else {
				return baseName + getCategory(name) + ".interaction";
			}
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
