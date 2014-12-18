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
 * Last modified: $LastChangedDate: 2014-01-06 15:03:13 -0400 (Mon, 06 Jan 2014) $
 * Revision:      $LastChangedRevision: 8266 $
 */
package ca.infoway.messagebuilder.domainvalue.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class (and all changes to it) must be manually translated to MB .NET.
 * 
 * @sharpen.ignore
 * 
 */
public class DomainTypeResolver {

	public Class<?> resolveDomainTypeUniquely(String domainType) {
		List<Class<?>> results = resolveDomainType(domainType);
		// TM - RM18323 - If we get multiple results back this means the domain type has matched a domain class in more than one generated MB API.
		// We can't easily distinguish which one to use, so just return the first one. This should very rarely happen, if at all.
		return results.isEmpty() ? null : results.get(0);
	}

	public List<Class<?>> resolveDomainType(String domainType) {
		List<Class<?>> classList = new ArrayList<Class<?>>();
		try {
			Class<?> class1 = Class.forName("ca.infoway.messagebuilder.domainvalue." + domainType);
			classList.add(class1);
		} catch (ClassNotFoundException e) {
			// try to locate interfaces within MB generated API domainvalue packages
			// (this likely will have translation issues; also, this requires the given domainvalue package to already be in the classloader)
			Package[] packages = Package.getPackages();
			for (Package package1 : packages) {
				if (package1.getName().startsWith("ca.infoway.messagebuilder.") 
						&& package1.getName().endsWith(".domainvalue")) {
					try {
						Class<?> class2 = Class.forName(package1.getName() + "." + domainType);
						classList.add(class2);
					} catch (ClassNotFoundException e1) {
						// do nothing
					}
				}
			}
		}
		return classList;
	}
	
}
