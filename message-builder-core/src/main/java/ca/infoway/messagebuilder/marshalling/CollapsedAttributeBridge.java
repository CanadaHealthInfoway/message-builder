package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;

class CollapsedAttributeBridge implements AttributeBridge {

	private final Relationship relationship;
	private BareANY any;
	private Object value;
	private final String propertyName;

	public CollapsedAttributeBridge(String propertyName, Relationship relationship, Object value) {
		this.propertyName = propertyName;
		this.relationship = relationship;
		
		if (value instanceof BareANY) {
			this.any = (BareANY) value;
			this.value = this.any.getBareValue();
		} else {
			this.value = value;
			this.any = null;
		}
	}

	public BareANY getHl7Value() {
		return this.any;
	}

	public BareANY getHl7Value(int index) {
		throw new UnsupportedOperationException();
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return this.value == null;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return false;
	}
}
