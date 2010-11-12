package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.Relationship;

class SimplifiableRelationship {

	private final Relationship relationship;

	public SimplifiableRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

}
