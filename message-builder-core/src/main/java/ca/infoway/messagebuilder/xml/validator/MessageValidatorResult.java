package ca.infoway.messagebuilder.xml.validator;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;

public class MessageValidatorResult {

	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();

	public List<Hl7Error> getHl7Errors() {
		return hl7Errors;
	}
	
	public void addHl7Error(Hl7Error hl7Error) {
		this.hl7Errors.add(hl7Error);
	}
	
}
