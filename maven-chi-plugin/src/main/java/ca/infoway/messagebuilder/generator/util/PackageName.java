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
 * Last modified: $LastChangedDate: 2012-01-10 21:45:18 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3334 $
 */
package ca.infoway.messagebuilder.generator.util;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class PackageName {

	private static final String DOMAINVALUE_JAVA = "domainvalue";
	private static final String DOMAINVALUE_CSHARP = "Domainvalue";
	
	private final String packageName;

	public PackageName(String packageName) {
		this.packageName = packageName;
	}
	PackageName(PackageName basePackageName, String packageName) {
		this(basePackageName.packageName + "." + packageName);
	}
	
	public static PackageName createDomainValuesPackage(String basePackageName, ProgrammingLanguage programmingLanguage) {
		return createDomainValuesPackage(new PackageName(basePackageName), programmingLanguage);
	}
	private static PackageName createDomainValuesPackage(PackageName basePackageName, ProgrammingLanguage programmingLanguage) {
		return new PackageName(basePackageName, programmingLanguage == ProgrammingLanguage.C_SHARP ? DOMAINVALUE_CSHARP : DOMAINVALUE_JAVA);
	}
	public String qualifyClassName(String unqualifiedClassName) {
		return this.packageName + "." + unqualifiedClassName;
	}
}
