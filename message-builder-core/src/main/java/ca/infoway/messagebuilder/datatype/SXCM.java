package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.SetComponent;

/**
 * <p>Set Component (SXCM) HL7 datatype. Backed by the java datatype SetComponent. 
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SXCM
 * 
 * <p>Definition: An ITS-defined generic type extension for the base data type of a
 * set, representing a component of a general set over a discrete or continuous
 * value domain. Its use is mainly for continuous value domains. Discrete
 * (enumerable) set components are the individual elements of the base data
 * type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java datatype
 * @sharpen.ignore - datatype - translated manually 
 */
public interface SXCM<T> extends ANY<SetComponent<T>> {
}
