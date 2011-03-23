package ca.infoway.messagebuilder.marshalling;

import java.util.List;

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;

/**
 * <p>An exception indicating that the application tried to marshall a message
 * part that did not follow the rules of marshalling.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class InvalidRenderInputException extends RenderingException {

	private final List<Hl7Error> hl7Errors;

	private static final long serialVersionUID = -1049387329590610715L;

	public InvalidRenderInputException(List<Hl7Error> hl7Errors) {
		this.hl7Errors = hl7Errors;
	}

	public List<Hl7Error> getHl7Errors() {
		return this.hl7Errors;
	}
	
	@Override
	public String getMessage() {
		return this.hl7Errors.isEmpty() ? null : this.hl7Errors.get(0).toString();
	}
}
