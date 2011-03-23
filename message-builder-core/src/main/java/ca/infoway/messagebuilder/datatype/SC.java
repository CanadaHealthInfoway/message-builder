package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodedString;

/**
 * <p>Hl7 datatype SC (Coded String). Backed by the Java datatype CodedString.
 *
 * <p>An ST that optionally may have a code attached. The text must always be present if a code is present. 
 * The code is often a local code.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type
 * @sharpen.ignore - datatype - translated manually 
 */
public interface SC<V extends Code> extends ANY<CodedString<V>> {
}
