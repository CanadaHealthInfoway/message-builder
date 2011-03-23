package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>An object that represents the result of transforming an object from HL7 XML format
 * to a Java representation.  The result tends to contain two key items:
 * 
 * <ol>
 * <li>A Java representation of the HL7 message that contains all of the populated 
 * data.
 * <li>A set of errors that were encountered during parsing of the message.
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlToModelResult {
	
	private Object messageObject;
	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();
	
	/**
	 * <p>The Java representation of the HL7 message.
	 * 
	 * @return - the populated Java classes that contain the message data.
	 */
	public Object getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(Object messageObject) {
		this.messageObject = messageObject;
	}
	
	public boolean isValid() {
		return this.hl7Errors.size() == 0;
	}

	public void addHl7Error(Hl7Error hl7Error) {
		this.hl7Errors.add(hl7Error);
	}
	
	boolean hasCodeError() {
		return getFirstCodeError() != null;
	}
	Hl7Error getFirstCodeError() {
		Hl7Error result = null;
		for (Hl7Error error : this.hl7Errors) {
			if (error.getHl7ErrorCode() == Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM) {
				result = error;
				break;
			}
		}
		return result;
	}

	public List<Hl7Error> getHl7Errors() {
		return hl7Errors;
	}
}