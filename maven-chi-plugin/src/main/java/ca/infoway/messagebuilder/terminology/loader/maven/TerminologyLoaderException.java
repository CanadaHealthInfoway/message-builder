package ca.infoway.messagebuilder.terminology.loader.maven;

/**
 * <p>An exception that is thrown when an error occurs while trying
 * to load the terminology worksheet into the database.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TerminologyLoaderException extends Exception {

	private static final long serialVersionUID = -7013371969609692854L;

	/**
	 * <p>Basic constructor.
	 * 
	 * @param message - an explanation of the cause of the exception.
	 * @param cause - the root cause of the exception.
	 */
	public TerminologyLoaderException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * <p>Basic constructor.
	 * 
	 * @param message - an explanation of the cause of the exception.
	 */
	public TerminologyLoaderException(String message) {
		super(message);
	}
}
