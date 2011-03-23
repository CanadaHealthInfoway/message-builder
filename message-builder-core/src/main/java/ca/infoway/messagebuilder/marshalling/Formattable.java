package ca.infoway.messagebuilder.marshalling;

import java.util.List;

interface Formattable extends RelationshipReader {
	public Object read(String relationshipName);
	
	public boolean isAssociationMappedToSameBean(String name);
	public Formattable createSubWrapper(String relationshipName);
	public List<String> findMatchingRelationshipNames(String name);
}
