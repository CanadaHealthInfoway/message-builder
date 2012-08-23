package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.List;

public interface Hl7Errors {

	public boolean isValid();
	public void addHl7Error(Hl7Error hl7Error);
	public List<Hl7Error> getHl7Errors();
	
}
