package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.StringUtils.EMPTY;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class TemporaryTypeName extends TypeName {

	private static final long serialVersionUID = 6941022774291107237L;
	private static int counter = 0;
	private static final int MAX_INT_LENGTH = 9; // 10, actually, but the leftmost digit only goes to 2

	/**
	 * This constructor for tests only. Please use the static creation method for normal use.
	 * 
	 * @param qualifier the temporary type name qualifier
	 * @param suffix the temporary type name suffix
	 */
	protected TemporaryTypeName(String qualifier, String suffix) {
		super(qualifier + "." + suffix);
	}
	
	private TemporaryTypeName(String fullName) {
		super(fullName);
	}
	
	public static TemporaryTypeName create(String qualifier) {
		String counterString = EMPTY + (++counter); 
		String suffix = StringUtils.leftPad(counterString, MAX_INT_LENGTH, '0');
		return new TemporaryTypeName(qualifier, suffix);
	}
	
	protected static TemporaryTypeName createNameAsIs(String fullName) {
		return new TemporaryTypeName(fullName);
	}
}
