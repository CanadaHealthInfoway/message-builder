package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;


class FixedValueAttributeBeanBridge implements AttributeBridge {

	private final BareANY any;
	private final Object value;
	private final Relationship relationship;

	FixedValueAttributeBeanBridge(Relationship relationship, BareANY any) {
		this.relationship = relationship;
		this.any = any;
		this.value = any!=null ? any.getBareValue() : null;  
	}

	FixedValueAttributeBeanBridge(Relationship relationship, Object value) {
		this.relationship = relationship;
		if (value instanceof BareANY) {
			this.any = (BareANY) value;
			this.value = any.getBareValue();
		} else {
			this.value = value;
			this.any = null;
		}
	}
	
	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return false;
	}

	public BareANY getHl7Value() {
		return any;
	}
	
	public String getPropertyName() {
		return "fixed";
	}

	public boolean isAssociation() {
		return false;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public BareANY getHl7Value(int index) {
		throw new UnsupportedOperationException();
	}
}
