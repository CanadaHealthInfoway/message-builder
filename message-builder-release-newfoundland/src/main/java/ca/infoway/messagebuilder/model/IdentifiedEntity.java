package ca.infoway.messagebuilder.model;

import java.util.Set;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

public interface IdentifiedEntity {

	public Set<Identifier> getIds();
	public IndeterminatePerson getIndeterminatePerson();

}
