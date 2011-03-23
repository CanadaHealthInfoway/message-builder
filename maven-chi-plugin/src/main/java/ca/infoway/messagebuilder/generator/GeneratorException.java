package ca.infoway.messagebuilder.generator;

/**
 * <p>An exception that indicates that something went wrong while trying to 
 * generate message sets from MIF files.</p>
 * 
 * @author administrator
 */
public class GeneratorException extends Exception {

	private static final long serialVersionUID = 5359081721882569L;
	
	/**
	 * <p>Standard constructor.
	 */
	public GeneratorException() {
		super();
	}

	/**
	 * <p>Standard constructor.
	 * @param message - a description of the cause of the exception
	 * @param cause - the underlying exception that caused the error
	 */
	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>Standard constructor.
	 * @param message - a description of the cause of the exception
	 */
	public GeneratorException(String message) {
		super(message);
	}

	/**
	 * <p>Standard constructor.
	 * @param cause - the underlying exception that caused the error
	 */
	public GeneratorException(Throwable cause) {
		super(cause);
	}
}
