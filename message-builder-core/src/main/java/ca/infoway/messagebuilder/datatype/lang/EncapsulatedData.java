package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>This class represents data that is primarily intended for human interpretation
 * or for further machine processing outside the scope of HL7.  Examples include
 * PDF documents, images, XML or other content types.
 *
 * <p>This includes unformatted or formatted written language, multimedia data, or
 * structured information in as defined by a different standard (e.g., XML-signatures.)
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class EncapsulatedData {

	private ca.infoway.messagebuilder.domainvalue.MediaType mediaType;
	private String reference;
	private byte[] content;

	/**
	 * <p>Constructs an empty ED.
	 */
	public EncapsulatedData() {
	}
	
	/**
	 * <p>Constructs an ED using the supplied parameters.
	 * 
	 * @param mediaType the mediatype
	 * @param reference a reference
	 * @param content content within a byte array
	 */
	public EncapsulatedData(ca.infoway.messagebuilder.domainvalue.MediaType mediaType, String reference, byte[] content) {
		this.mediaType = mediaType;
		this.reference = reference;
		this.content = content;
	}
	
	/**
	 * <p>Returns the byte array content.
	 * 
	 * @return the byte array content
	 */
	public byte[] getContent() {
		return this.content;
	}
	
	/**
	 * <p>Returns the media type.
	 * 
	 * @return the media type
	 */
	public ca.infoway.messagebuilder.domainvalue.MediaType getMediaType() {
		return this.mediaType;
	}
	
	/**
	 * <p>Returns the reference.
	 * 
	 * @return the reference
	 */
	public String getReference() {
		return this.reference;
	}
}
