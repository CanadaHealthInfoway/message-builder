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

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;

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

	private static final ThreadLocal<VersionNumber> threadLocalVersion = new ThreadLocal<VersionNumber>();
	private static final ThreadLocal<GenericCodeResolverRegistry> threadLocalCodeResolverRegistryOverride = new ThreadLocal<GenericCodeResolverRegistry>();

	private static final Map<VersionNumber, GenericCodeResolverRegistry> registryMap = new HashMap<VersionNumber, GenericCodeResolverRegistry>(); 
	
	// the "default" registry that will be used if no other registry can be found 
	private static final GenericCodeResolverRegistry _defaultRegistry = new GenericCodeResolverRegistryImpl();

	// all transform/validator calls should set version in TLS
	public static void setThreadLocalVersion(VersionNumber version) {
		threadLocalVersion.set(version);
	}
	public static void clearThreadLocalVersion() {
		threadLocalVersion.remove();
	}

	// transform/validator calls *may* provide a code resolver registry override in TLS
	public static void setThreadLocalCodeResolverRegistryOverride(GenericCodeResolverRegistry registryOverride) {
		threadLocalCodeResolverRegistryOverride.set(registryOverride);
	}
	public static void clearThreadLocalCodeResolverRegistryOverride() {
		threadLocalCodeResolverRegistryOverride.remove();
	}

	/**
	 * Store a CodeResolverRegistry to be used for a specific HL7v3 release version. Passing in a null value for the registry will 
	 * remove any existing registry for the supplied version.
	 * 
	 * @param version the version for which the supplied code resolver registry should be used
	 * @param registry the code resolver registry to use for this version
	 * @return returns true if there was a code resolver registry already registered for this version
	 */
	public static boolean registerCodeResolverRegistryForVersion(VersionNumber version, GenericCodeResolverRegistry registry) {
		if (registry == null) {
			return registryMap.remove(version) != null;
		}
		return registryMap.put(version, registry) != null;
	}
	
	/**
	 * Retrieves the CodeResolverRegistry used for a specific HL7v3 release version, if one has been stored for that version. Otherwise, returns null.
	 * 
	 * @param version the version for which the supplied code resolver registry should be used
	 * @return registry the code resolver registry to use for this version
	 */
	public static GenericCodeResolverRegistry getCodeResolverRegistryForVersion(VersionNumber version) {
		return registryMap.get(version);
	}
	
	// for testing purposes only
    static GenericCodeResolverRegistry getDefaultRegistry() {
    	return _defaultRegistry;
    }

    /**
	 * Removes all code resolver registries stored by HL7v3 release version.
	 * 
	 */
	public static void removeAllRegistries() {
		registryMap.clear();
	}
	
	/**
	 * @return the registry for the version being used in the current thread. If none found, returns the default registry.
	 */
	static GenericCodeResolverRegistry getRegistry() {
		// if an override code resolver registry has been specified it will be returned regardless of other settings 
		if (threadLocalCodeResolverRegistryOverride.get() != null) {
			return threadLocalCodeResolverRegistryOverride.get();
		}
		// otherwise, returns the code resolver registry stored under the HL7v3 version being used by the current thread
		// if no registries found, return the default code resolver registry
		VersionNumber currentlySpecifiedVersion = threadLocalVersion.get();
		GenericCodeResolverRegistry versionRegistry = registryMap.get(currentlySpecifiedVersion);
		return versionRegistry == null ? _defaultRegistry : versionRegistry;
	}
	
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the collection
     */
    public static <T extends Code> Collection<T> lookup(Class<T> type) {
    	return getRegistry().lookup(type);
    }
    
    /**
     * <p>Lookup. Defaults to case insensitive.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @return the t
     */
    public static <T extends Code> T lookup(Class<T> type, String code) {
        return lookup(type, code, true);
    }
    
    /**
     * <p>Lookup code, logging a warning if a code is found that doesn't match case.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param logger an error logger
     * @return the t
     */
    public static <T extends Code> T lookupWarningOnCaseMismatch(Class<T> type, String code, ErrorLogger logger) {
        T result = getRegistry().lookup(type, code);
        if (result == null) {
        	// now try to find a match while ignoring case
            result = getRegistry().lookup(type, code, true);
            if (result != null) {
            	logger.logError(
            			Hl7ErrorCode.CODE_MATCH_ONLY_WHEN_IGNORING_CASE, 
            			ErrorLevel.WARNING, 
            			MessageFormat.format("A match for code {0} of type {1} was found only when ignoring case ({2}).", code, type.getSimpleName(), result.getCodeValue()));
            }
        }
		return result;
    }
    
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param ignoreCase ignore case when matching code
     * @return the t
     */
    public static <T extends Code> T lookup(Class<T> type, String code, boolean ignoreCase) {
        return getRegistry().lookup(type, code, ignoreCase);
    }
    
    /**
     * <p>Lookup. Defaults to case insensitive.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param codeSystemOid the code system oid
     * @return the t
     */
    public static <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid) {
    	return lookup(type, code, codeSystemOid, true);
    }
    
    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param codeSystemOid the code system oid
     * @param logger an error logger
     * @return the t
     */
    public static <T extends Code> T lookupWarningOnCaseMismatch(Class<T> type, String code, String codeSystemOid, ErrorLogger logger) {
        T result = getRegistry().lookup(type, code, codeSystemOid);
        if (result == null) {
        	// now try to find a match while ignoring case
            result = getRegistry().lookup(type, code, codeSystemOid, true);
            if (result != null) {
            	logger.logError(
            			Hl7ErrorCode.CODE_MATCH_ONLY_WHEN_IGNORING_CASE,
            			ErrorLevel.WARNING, 
            			MessageFormat.format("A match for code {0} of type {1} was found only when ignoring case ({2}).", code, type.getSimpleName(), result.getCodeValue()));
            }
        }
		return result;
    }

    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @param code the code
     * @param codeSystemOid the code system oid
     * @param ignoreCase ignore case when matching code
     * @return the t
     */
    public static <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid, boolean ignoreCase) {
    	return getRegistry().lookup(type, code, codeSystemOid, ignoreCase);
    }
    
    /**
     * <p>Gets the resolver.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the resolver
     */
	public static <T extends Code> CodeResolver getResolver(Class<T> type) {
		return getRegistry().getResolver(type);
    }

    /**
     * <p>Checks if the DEFAULT code resolver registry is initialized.
     *
     * @return true, if is initialized
     */
    public static boolean isInitialized() {
    	return _defaultRegistry.isInitialized();
    }
    
    /**
     * <p>Register a code resolver in the DEFAULT code resolver registry.
     *
     * @param codeResolver the code resolver
     */
    public static void register(CodeResolver codeResolver) {
    	_defaultRegistry.register(codeResolver);
    }
    
    /**
     * <p>Register a code resolver in the DEFAULT code resolver registry.
     *
     * @param type the type
     * @param codeResolver the code resolver
     */
    public static void registerResolver(Class<? extends Code> type, CodeResolver codeResolver) {
    	_defaultRegistry.registerResolver(type, codeResolver);
    }
    
    /**
     * <p>Unregister all code resolvers in the DEFAULT code resolver registry.
     */
    public static void unregisterAll() {
    	_defaultRegistry.unregisterAll();
    }
    
}
