package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

public interface OfPatient {

	public Identifier getId();
	public void setId(Identifier id);
	public IdentifiedPersonBean getPatient();
	public void setPatient(IdentifiedPersonBean patient);

}
