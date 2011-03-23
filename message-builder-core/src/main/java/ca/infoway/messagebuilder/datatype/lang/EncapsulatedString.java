package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>Java datatype for HL7 encapsulated string.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EncapsulatedString extends EncapsulatedData {

	private final String text;

	/**
	 * <p>Constructs an EcapsulatedString from the given text. 
	 * 
	 * @param text the initial text
	 */
	public EncapsulatedString(String text) {
		this.text = text;
	}

	/**
	 * <p>Returns this encapsulated string's content as a string.
	 * 
	 * @return the content as a string
	 */
	public String getContentAsString() {
		return this.text;
	}

	/**
	 * <p>Returns the content as an array of bytes.
	 * 
	 * @return the content as an array of bytes
	 */
	@Override
	public byte[] getContent() {
		return this.text == null ? null : this.text.getBytes();
	}

	/**
	 * <p>Returns this object's media type. In this case, it is always plain text.
	 * 
	 * @return the media type
	 */
	@Override
	public MediaType getMediaType() {
		return MediaType.PLAIN_TEXT;
	}
}
