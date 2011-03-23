package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.EntityName;

/**
 * <p>Interface for HL7 name-based datatypes. Backed by a java datatype that must be an extension of EntityName.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying javav entity name type
 * 
 * @sharpen.ignore - datatype - translated manually
 * @sharpen.ignore - datatype - translated manually 
 */
public interface EN<V extends EntityName> extends ANY<V> {

	// TODO - Datatypes - TM/AG -"validTime" not currently supported 
}
