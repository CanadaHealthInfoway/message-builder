package ca.infoway.messagebuilder.datatype;


/**
 * <p>HL7 datatype CE. Backed by a Code.
 * 
 * <p>Coded data that consists of a coded value and, optionally, coded value(s) from other coding systems that 
 * identify the same concept. Used when alternative codes may exist.
 * 
 * <p>Note: The use of this data type has been reviewed and the recommendation is to use CD instead. Namely 
 * because the only difference between CD and CE was the use of the qualifier property, which is no longer 
 * being used for this release. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying Code
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface CE extends CD {

}
