package ca.infoway.messagebuilder.marshalling;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Relationship;

class IndicatorAssociationBridgeImpl implements AssociationBridge {
	
	private final Relationship relationship;
	private final List<PartBridge> parts;
	private final BeanProperty beanProperty;

	public IndicatorAssociationBridgeImpl(Relationship relationship, PartBridge bridge, BeanProperty beanProperty) {
		this.relationship = relationship;
		this.beanProperty = beanProperty;
		this.parts = Arrays.asList(bridge);
	}

	public Collection<PartBridge> getAssociationValues() {
		return isEmpty() ? Collections.<PartBridge>emptyList() : this.parts;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return true;
	}

	public boolean isEmpty() {
		// null flavor does *not* read as empty
		return Boolean.FALSE.equals(this.beanProperty == null ? null : this.beanProperty.get());
	}

	public String getPropertyName() {
		return null;
	}
}
