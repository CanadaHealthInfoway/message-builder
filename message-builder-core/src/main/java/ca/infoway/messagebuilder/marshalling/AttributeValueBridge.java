package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;


@SuppressWarnings("unchecked")
class AttributeValueBridge implements AttributeBridge {

	private final ANY any;
	private final Object value;
	private final Relationship relationship;

	AttributeValueBridge(Relationship relationship, ANY any) {
		this.relationship = relationship;
		this.any = any;
		this.value = any!=null ? any.getValue() : null;  
	}

	AttributeValueBridge(Relationship relationship, Object value) {
		this.relationship = relationship;
		if (value instanceof ANY) {
			this.any = (ANY) value;
			this.value = any.getValue();
		} else {
			this.value = value;
			this.any = null;
		}
	}
	
	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return EmptinessUtil.isEmpty(getValue());
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
