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

package ca.infoway.messagebuilder.generator.dotnet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A decorator that adjusts the package names to the C# format of 
 * first-letter-capitalization.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class CsharpPackageNameAdjustingDecorator implements NameTranslator {

	private final NameTranslator nameTranslator;

	CsharpPackageNameAdjustingDecorator(NameTranslator nameTranslator) {
		this.nameTranslator = nameTranslator;
	}

	public String getClassNameWithoutPackage(TypeName name) {
		return this.nameTranslator.getClassNameWithoutPackage(name);
	}

	public String getFullyQualifiedClassName(TypeName name) {
		String fullyQualifiedName = getPackageName(name) + "." + getClassNameWithoutPackage(name);
		return fullyQualifiedName; 
	}

	public String getPackageName(TypeName name) {
		return capitalizePackageNameParts(this.nameTranslator.getPackageName(name));
	}

	static String capitalizePackageNameParts(String packageName) {
		String[] words = StringUtils.split(packageName, ".");
		for (int i = 0; i < words.length; i++) {
			words[i] = WordUtils.capitalize(words[i]);
		}
		return StringUtils.join(words, ".");
	}
}
