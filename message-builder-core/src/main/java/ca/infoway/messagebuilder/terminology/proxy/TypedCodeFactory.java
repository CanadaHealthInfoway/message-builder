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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2015-01-30 14:20:12 -0500 (Fri, 30 Jan 2015) $
 * Revision:      $LastChangedRevision: 9162 $
 */

package ca.infoway.messagebuilder.terminology.proxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.proxy.Enhancer;
import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.domainvalue.Active;
import ca.infoway.messagebuilder.terminology.domainvalue.Common;
import ca.infoway.messagebuilder.terminology.domainvalue.Displayable;
import ca.infoway.messagebuilder.terminology.domainvalue.Identifiable;
import ca.infoway.messagebuilder.terminology.domainvalue.Sortable;

/**
 * Creates an instance of Code that is assignable to a specific type.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TypedCodeFactory {

	private static final Set<Class<?>> STANDARD_INTERFACES;
	
	static {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Displayable.class);
		set.add(Sortable.class);
		set.add(Active.class);
		set.add(Common.class);
		set.add(Identifiable.class);
		
		STANDARD_INTERFACES = Collections.unmodifiableSet(set);
	}
	
	/**
	 * <p>Creates the Code.
	 *
	 * @param type the type
	 * @param types the types
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @param codeSystemName the human readable name of the code system
	 * @param displayTextMap the display text map
	 * @param sortValue the sort value
	 * @param active the active
	 * @param common the common
	 * @return the code
	 */
	public Code create(Class<?> type, Collection<Class<?>> types, 
			String code, String codeSystemOid, 
			String codeSystemName,
			Map<String,String> displayTextMap, 
			Integer sortValue, Boolean active, 
			Boolean common) {	
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TypedCode.class);
		List<Class<?>> allTypes = new ArrayList<Class<?>>(types);
		allTypes.addAll(STANDARD_INTERFACES);
		enhancer.setInterfaces((Class[]) allTypes.toArray(new Class[allTypes.size()]));
		enhancer.setCallback(new TypedCodeMethodInterceptor(new TypedCode(type, allTypes, code, 
				codeSystemOid, codeSystemName, displayTextMap, sortValue, active, common)));
		return (Code) enhancer.create();
	}
}
