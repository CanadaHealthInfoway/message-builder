package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;

/**
 * @sharpen.ignore - datatype - translated manually 
 */
public interface BareANY extends NullFlavorSupport {
	public Object getBareValue();
	
	/**
	 * <p>Represents the fact that every data value implicitly carries information about its own data type. 
	 * Thus, given a data value one can inquire about its data type.
	 * 
	 * @return the underlying enum datatype
	 */
	public StandardDataType getDataType();

	/**
	 * <p>Sets this ANY's datatype.
	 * 
	 * @param dataType an hl7 datatype
	 */
	public void setDataType(StandardDataType dataType);
}
