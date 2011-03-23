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
 * @sharpen.ignore - terminology - translated manually
 */
public abstract class CodeResolverRegistry {

    private static Map<Class<?>, CodeResolver> resolvers = Collections.synchronizedMap(new HashMap<Class<?>, CodeResolver>());
    private static CodeResolver instance;

    /**
     * <p>Lookup.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the collection
     */
    public static <T extends Code> Collection<T> lookup(Class<T> type) {
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
    public static <T extends Code> T lookup(Class<T> type, String code) {
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
    public static <T extends Code> T lookup(Class<T> type, String code, String codeSystemOid) {
    	return getResolver(type).lookup(type, code, codeSystemOid);
    }
    
    /**
     * <p>Gets the resolver.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the resolver
     */
	public static <T extends Code> CodeResolver getResolver(Class<T> type) {
        if (CodeResolverRegistry.resolvers.containsKey(type)) {
            return resolvers.get(type);
        } else if (EnumPattern.isEnum(type)) {
            return new EnumBasedCodeResolver((Class<?>) type);
        } else if (!type.isInterface()) {
        	return new EnumPatternCodeResolver();
        } else if (instance == null) {
            throw new IllegalStateException("No code resolver established for " 
                    + type.getName() + ".");
        } else {
            return instance;
        }
    }

    /**
     * <p>Checks if is initialized.
     *
     * @return true, if is initialized
     */
    public static boolean isInitialized() {
    	return instance != null;
    }
    
    /**
     * <p>Register.
     *
     * @param codeResolver the code resolver
     */
    public static void register(CodeResolver codeResolver) {
    	instance = codeResolver;
    }
    
    /**
     * <p>Register resolver.
     *
     * @param type the type
     * @param codeResolver the code resolver
     */
    public static void registerResolver(Class<? extends Code> type, CodeResolver codeResolver) {
        CodeResolverRegistry.resolvers.put(type, codeResolver);
    }
    
    /**
     * <p>Unregister all.
     */
    public static void unregisterAll() {
        CodeResolverRegistry.instance = null;
        CodeResolverRegistry.resolvers.clear();
    }
}
