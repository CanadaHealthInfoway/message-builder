package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PostalAddress;

/**
 * <p>HL7 datatype for addresses. Backed by the java datatype PostalAddress.
 * 
 * <p>Covers:
 * 
 * <p>AD.BASIC:  Used to communicate addresses for simple display, mailing and contact purposes.  
 *            The data type is not generally suitable for registries.
 * <p>AD.FULL:   Used to communicate fully validatable addresses. Usually appropriate only for registry-type situations.
 * <p>AD.SEARCH: This type is used to convey high level address information for searching purposes. All matches are 
 *            considered to be "starts with" for each specified property.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface AD extends ANY<PostalAddress> {

}
