package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.BareANY;

interface AttributeBridge extends BaseRelationshipBridge {

	public Object getValue();
	public boolean isEmpty();
	
	public BareANY getHl7Value();
	public BareANY getHl7Value(int index);
	
}
