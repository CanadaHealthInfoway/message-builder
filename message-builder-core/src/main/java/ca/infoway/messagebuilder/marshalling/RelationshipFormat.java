package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipFormat {

	private final String traversalName;
	private final String type;
	private final Argument argument;

	public RelationshipFormat(String traversalName, String type) {
		this.traversalName = traversalName;
		this.type = type;
		this.argument = null;
	}
	public RelationshipFormat(String traversalName, String type, Argument argument) {
		this.traversalName = traversalName;
		this.type = type;
		this.argument = argument;
	}

	public String getTraversalName() {
		return this.traversalName;
	}

	public String getXmlElementName() {
		return this.traversalName;
	}
	
	public String getType() {
		return this.type;
	}
	
	static RelationshipFormat getRelationshipFormat(ConversionContext context, Relationship relationship) {
		if (relationship.isTemplateRelationship()) {
			return context.resolveTemplateType(relationship);
		} else {
			return new RelationshipFormat(relationship.getName(), relationship.getType());
		}
	}
	public Argument getArgument() {
		return this.argument;
	}
}
