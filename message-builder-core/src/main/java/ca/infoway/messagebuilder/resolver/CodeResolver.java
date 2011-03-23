package ca.infoway.messagebuilder.resolver;

import java.util.Collection;

import ca.infoway.messagebuilder.Code;

/**
 * <p>The Interface CodeResolver. Specifies the various ways a code can be resolved/looked up.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public interface CodeResolver {

	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @return the collection
	 */
	public <T extends Code> Collection<T> lookup(Class<T> type);
	
	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param code the code
	 * @return the t
	 */
	public <T extends Code> T lookup(Class<T> type, String code);
	
	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @return the t
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid);

}