package ca.infoway.messagebuilder.generator.regen;

public class MergeTypeException extends RuntimeException {

	private static final long serialVersionUID = 470391126088192612L;

	public MergeTypeException() {
		super();
	}

    public MergeTypeException(String message) {
    	super(message);
    }

    public MergeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MergeTypeException(Throwable cause) {
        super(cause);
    }
    
	
}
