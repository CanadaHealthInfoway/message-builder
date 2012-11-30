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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.Code;

/**
 * <p>The Class CompositeCodeResolver. A code resolver made up of a combination of other code resolvers.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public class CompositeCodeResolver extends CodeResolverImpl {
    
    private final CodeResolver[] resolvers;

    /**
     * <p>Instantiates a new composite code resolver.
     *
     * @param resolvers the resolvers
     */
    public CompositeCodeResolver(CodeResolver... resolvers) {
        this.resolvers = resolvers;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
	public <T extends Code> Collection<T> lookup(Class<T> type) {
    	List<T> result = new ArrayList<T>();
    	for (CodeResolver resolver : this.resolvers) {
			Collection<T> collection = resolver.lookup(type);
			if (collection != null) {
				result.addAll(collection);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> type, String code) {
        Object result = null;
        for (CodeResolver resolver : this.resolvers) {
            Object object = resolver.lookup(type, code);
            if (object != null) {
                result = object;
                break;
            }
        }
        return (T) result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid) {
        Object result = null;
        for (CodeResolver resolver : this.resolvers) {
            Object object = resolver.lookup(type, code, codeSystemOid);
            if (object != null) {
                result = object;
                break;
            }
        }
        return (T) result;
	}
}
