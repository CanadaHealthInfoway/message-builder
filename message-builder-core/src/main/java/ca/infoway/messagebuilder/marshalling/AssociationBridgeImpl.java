package ca.infoway.messagebuilder.marshalling;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.xml.Relationship;

class AssociationBridgeImpl implements AssociationBridge {
	
	private final Relationship relationship;
	private final List<PartBridge> parts;

	public AssociationBridgeImpl(Relationship relationship, List<PartBridge> parts) {
		this.relationship = relationship;
		this.parts = parts;
	}

	public AssociationBridgeImpl(Relationship relationship, PartBridge bridge) {
		this(relationship, Arrays.asList(bridge));
	}

	public Collection<PartBridge> getAssociationValues() {
		return this.parts;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return true;
	}

	public boolean isEmpty() {
		boolean empty = true;
		for (PartBridge part : this.parts) {
			empty &= part.isEmpty();
		}
		return empty;
	}

	public String getPropertyName() {
		return null;
	}
}
