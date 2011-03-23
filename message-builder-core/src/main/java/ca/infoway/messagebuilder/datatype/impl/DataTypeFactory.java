package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.ANY;

/**
 * <p>A factory to create a datatype object given a type name. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class DataTypeFactory {

	/**
	 * <p>Creates a datatype object given a type name. 
	 * 
	 * @param typeName the type
	 * @return the created datatype
	 */
	@SuppressWarnings("unchecked")
	public static final ANY createDataType(String typeName) {
		Class<? extends ANYImpl<?>> implementation = DataTypeImplementationFactory.getImplementation(typeName);
		try {
			if (implementation!=null) {
				return implementation.newInstance();
			} else {
				throw new RuntimeException("Unable to create data type: " + typeName);
			}
		} catch (InstantiationException e) {
			throw new RuntimeException("Unable to create data type: " + typeName, e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to create data type: " + typeName, e);
		}
	}

}
