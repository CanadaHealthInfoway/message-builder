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
 * Last modified: $LastChangedDate: 2012-01-10 21:44:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3332 $
 */
package ca.infoway.messagebuilder.generator.util;

import java.util.List;

public interface DomainType {
	/**
	 * The name of the domain type.  For example, "ActCode" or "ProcessingID".
	 * 
	 * @return the name of the domain type.
	 */
	public String getName();
	/**
	 * The class name of the domain type.  
	 * For example, <tt>ca.infoway.messagebuilder.domainvalue.ActCode</tt>.
	 * 
	 * @return the name of the domain type.
	 */
	public String getFullyQualifiedClassName();
	public List<DomainType> getParentDomainTypes();
	public DomainType findCommonAncestorWith(DomainType type);
}
