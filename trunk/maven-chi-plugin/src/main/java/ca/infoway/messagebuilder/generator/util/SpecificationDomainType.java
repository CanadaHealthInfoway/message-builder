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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-01-10 21:45:18 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3334 $
 */
package ca.infoway.messagebuilder.generator.util;

import java.util.List;

class SpecificationDomainType implements DomainType {

	private final String domainType;
	private final PackageName packageName;
	private final List<DomainType> parents;

	public SpecificationDomainType(String domainType,
			PackageName packageName, List<DomainType> parents) {
		this.domainType = domainType;
		this.packageName = packageName;
		this.parents = parents;
	}

	public String getName() {
		return this.domainType;
	}

	public String getFullyQualifiedClassName() {
		return this.packageName.qualifyClassName(this.domainType);
	}

	public List<DomainType> getParentDomainTypes() {
		return this.parents;
	}

	public DomainType findCommonAncestorWith(DomainType type) {
		return DomainTypeUtil.findCommonAncestor(this, type);
	}

}
