package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.xml.Relationship;

class VisitorStructuralAttributeRenderer extends StructuralAttributeRenderer {

	private final Object value;

	public VisitorStructuralAttributeRenderer(Relationship relationship, Object value) {
		super(relationship);
		this.value = value;
	}
	
	@Override
	protected Object getValue() {
		return this.value;
	}
}
