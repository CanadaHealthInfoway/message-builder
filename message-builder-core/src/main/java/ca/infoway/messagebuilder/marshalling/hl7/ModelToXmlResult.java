package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.ArrayList;
import java.util.List;

public class ModelToXmlResult {
	
	private String xmlMessage;

	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();
	
	public String getXmlMessage() {
		return this.xmlMessage;
	}
	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
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