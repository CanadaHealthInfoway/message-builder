package ca.infoway.messagebuilder.datatype;

/**
 * <p>Data that is primarily intended for human interpretation or for further
 * machine processing outside the scope of HL7.
 * 
 * <p>This includes unformatted or formatted written language, multimedia data, or
 * structured information in as defined by a different standard (e.g.,
 * XML-signatures.) Instead of the data itself, an ED may contain only a
 * reference (see TEL.) Note that ST is a specialization of the ED where the
 * mediaType is fixed to text/plain.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying java datatype
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface ED<V> extends ANY<V> {

}
