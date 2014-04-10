package ca.infoway.messagebuilder.util.messagegenerator;

import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * @sharpen.ignore sample message generator is for MB Java only
 */
public interface DataTypeValueStore {

	public Object getValueForDatatype(String dataType, Class<?> propertyType);
	public StandardDataType getDatatypeUsedForAbstract(String dataType);
	
}
