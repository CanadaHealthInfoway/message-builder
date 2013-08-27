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

package ca.infoway.messagebuilder.resolver;

import java.util.Collection;

import ca.infoway.messagebuilder.Code;

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
 * @sharpen.ignore - terminology - translated manually
 */
public abstract class CodeResolverRegistry {
	
	private static GenericCodeResolverRegistryImpl registry = new GenericCodeResolverRegistryImpl();

    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the collection
     */
    public static <T extends Code> Collection<T> lookup(Class<T> type) {
    	return registry.lookup(type);
    }
    
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @return the t
     */
    public static <T extends Code> T lookup(Class<T> type, String code) {
        return registry.lookup(type, code);
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
    public static <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid) {
    	return registry.lookup(type, code, codeSystemOid);
    }
    
    /**
     * <p>Gets the resolver.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the resolver
     */
	public static <T extends Code> CodeResolver getResolver(Class<T> type) {
		return registry.getResolver(type);
    }

    /**
     * <p>Checks if is initialized.
     *
     * @return true, if is initialized
     */
    public static boolean isInitialized() {
    	return registry.isInitialized();
    }
    
    /**
     * <p>Register.
     *
     * @param codeResolver the code resolver
     */
    public static void register(CodeResolver codeResolver) {
    	registry.register(codeResolver);
    }
    
    /**
     * <p>Register resolver.
     *
     * @param type the type
     * @param codeResolver the code resolver
     */
    public static void registerResolver(Class<? extends Code> type, CodeResolver codeResolver) {
    	registry.registerResolver(type, codeResolver);
    }
    
    /**
     * <p>Unregister all.
     */
    public static void unregisterAll() {
    	registry.unregisterAll();
    }
    
}
