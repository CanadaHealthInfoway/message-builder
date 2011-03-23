package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;

class MockAttributeBridge implements AttributeBridge {

	private BareANY hl7Value;
	private Object value;
	private boolean isEmpty;
	Relationship relationship;
	
	public void setHl7Value(BareANY hl7Value) {
		this.hl7Value = hl7Value;
	}

	public BareANY getHl7Value() {
		return this.hl7Value;
	}

	public BareANY getHl7Value(int index) {
		return null;
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public String getPropertyName() {
		return null;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return false;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
