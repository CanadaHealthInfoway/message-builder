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
 * Last modified: $LastChangedDate: 2012-01-10 21:44:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3332 $
 */
package ca.infoway.messagebuilder.generator.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.Code;

class ClassBasedDomainType implements DomainType {

	private final Class<?> domainTypeClass;

	ClassBasedDomainType(Class<?> domainTypeClass) {
		this.domainTypeClass = domainTypeClass;
	}
	public String getName() {
		return ClassUtils.getShortClassName(this.domainTypeClass);
	}

	public String getFullyQualifiedClassName() {
		return this.domainTypeClass.getName();
	}

	public List<DomainType> getParentDomainTypes() {
		List<DomainType> result = new ArrayList<DomainType>();
		Class<?>[] interfaces = this.domainTypeClass.getInterfaces();
		for (Class<?> i : interfaces) {
			if (i != Code.class) {
				result.add(new ClassBasedDomainType(i));
			}
		}
		return result;
	}
	public DomainType findCommonAncestorWith(DomainType type) {
		return DomainTypeUtil.findCommonAncestor(this, type);
	}
}
