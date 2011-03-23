package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.xml.Relationship;

interface RelationshipReader {

	public Object read(Relationship relationship);
	public BareANY readDataType(Relationship relationship);
	public NullFlavor getNullFlavor();

}
