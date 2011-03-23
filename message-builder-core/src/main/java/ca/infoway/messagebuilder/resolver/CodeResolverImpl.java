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
