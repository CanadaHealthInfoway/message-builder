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

package ca.infoway.messagebuilder.resolver;

import java.util.Collection;

import ca.infoway.messagebuilder.Code;

/**
 * <p>The Class CodeResolverImpl. A trivial (and abstract) implementation of CodeResolver. 
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public abstract class CodeResolverImpl implements CodeResolver {

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> Collection<T> lookup(Class<T> type) {
		return null;
	}
	
	
	public abstract <T extends Code> T lookup(Class<T> type, String code);
	
	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @return the t
	 */
	public abstract <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid);
	

}
