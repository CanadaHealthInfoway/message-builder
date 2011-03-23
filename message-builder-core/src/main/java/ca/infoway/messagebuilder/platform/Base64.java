package ca.infoway.messagebuilder.platform;

/**
 * @sharpen.ignore platform
 */
public class Base64 {
	
	public static byte[] decodeBase64(byte[] base64Data) {
		return org.apache.commons.codec.binary.Base64.decodeBase64(base64Data);
	}

	public static byte[] encodeBase64(byte[] binaryData) {
		return org.apache.commons.codec.binary.Base64.encodeBase64(binaryData);
	}

	public static String encodeBase64String(byte[] binaryData) {
		return new String(encodeBase64(binaryData));
	}

	public static byte[] decodeBase64String(String text) {
		return decodeBase64(text.getBytes());
	}

}
