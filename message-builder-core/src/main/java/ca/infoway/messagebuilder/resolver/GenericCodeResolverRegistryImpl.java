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
 * Last modified: $LastChangedDate: 2013-01-02 18:05:34 -0400 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.resolver;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>This class functions is generally used in one of two ways.  Either:
 * 
 * <ol>
 * <li>Register one monolithic Code Resolver that handles all lookup requests.
 * (This approach is currently used by the HealthWatch project, and their
 * resolver is backed by a database, and is sometimes used in test cases,
 * in which case we're usually using the TrivialCodeResolver).
 * To use this approach, a project should call the
 * <code>register(codeResolver)</code> method and set the <code>instance</code>
 * static variable.
 * <li>Register one resolver for each domain interface (This approach is currently used
 * by the eReferrals and Panacea projects).
 * </ol>
 * 
 * <p>Additionally, this class can automatically resolve:
 * 
 * <ol>
 * <li>enums; and
 * <li>classes that follow the enum pattern (having static constants -- see, for
 * example the Country class
 * </ol>
 * 
 * <p>In both cases the class or enum must implement the Code interface.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class GenericCodeResolverRegistryImpl implements GenericCodeResolverRegistry, CodeResolver {

    private Map<Class<?>, CodeResolver> resolvers = Collections.synchronizedMap(new HashMap<Class<?>, CodeResolver>());
    private CodeResolver instance;

    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the collection
     */
    public <T extends Code> Collection<T> lookup(Class<T> type) {
    	return getResolver(type).lookup(type);
    }
    
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @return the t
     */
    public <T extends Code> T lookup(Class<T> type, String code) {
        return getResolver(type).lookup(type, code);
    }
    
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param codeSystemOid the code system oid
     * @return the t
     */
    public <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid) {
    	return getResolver(type).lookup(type, code, codeSystemOid);
    }
    
    /**
     * <p>Gets the resolver.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the resolver
     */
	public <T extends Code> CodeResolver getResolver(Class<T> type) {
        if (this.resolvers.containsKey(type)) {
            return this.resolvers.get(type);
        } else if (EnumPattern.isEnum(type)) {
            return new EnumBasedCodeResolver((Class<?>) type);
        } else if (!type.isInterface()) {
        	return new EnumPatternCodeResolver();
        } else if (this.instance == null) {
            throw new IllegalStateException("No code resolver established for " 
                    + type.getName() + ".");
        } else {
            return this.instance;
        }
    }

    /**
     * <p>Checks if is initialized.
     *
     * @return true, if is initialized
     */
    public boolean isInitialized() {
    	return instance != null;
    }
    
    /**
     * <p>Register.
     *
     * @param codeResolver the code resolver
     */
    public void register(CodeResolver codeResolver) {
    	instance = codeResolver;
    }
    
    /**
     * <p>Register resolver.
     *
     * @param type the type
     * @param codeResolver the code resolver
     */
    public void registerResolver(Class<? extends Code> type, CodeResolver codeResolver) {
        this.resolvers.put(type, codeResolver);
    }
    
    /**
     * <p>Unregister all.
     */
    public void unregisterAll() {
        this.instance = null;
        this.resolvers.clear();
    }
}
