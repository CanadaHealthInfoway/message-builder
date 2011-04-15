package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;

public interface IdentifiablePractitioner extends Identifiable {
	
	public Identifier getLicenseNumber();
	public PersonName getName();
	
}
