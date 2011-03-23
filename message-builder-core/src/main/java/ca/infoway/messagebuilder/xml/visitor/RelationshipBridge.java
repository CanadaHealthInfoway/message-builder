package ca.infoway.messagebuilder.xml.visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipBridge {

    private final Relationship relationship;
	private final ElementBridge elementBridge;

	public RelationshipBridge(ElementBridge elementBridge, Relationship relationship) {
		this.elementBridge = elementBridge;
		this.relationship = relationship;
	}

	public boolean isAssociation() {
		return this.relationship.isAssociation();
	}
	public boolean isStructuralAttribute() {
		return this.relationship.isAttribute() && this.relationship.isStructural();
	}

	public List<Element> getElements() {
		return this.elementBridge.getElements(this.relationship);
	}
	
	Element getBase() {
		return this.elementBridge.getBase();
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public Attr getAttribute() {
		return this.elementBridge.getAttribute(this.relationship);
	}
	
	String getXmlName() {
		return this.elementBridge.getXmlName(this.relationship);
	}

	@Override
	public String toString() {
		return "Relationship: " + this.relationship.getName();
	}
	public Set<String> getNames() {
		Set<String> names = new HashSet<String>();
		if (isStructuralAttribute()) {
			names.add(this.relationship.getName());
		} else {
			for (Element element : getElements()) {
				names.add(NodeUtil.getLocalOrTagName(element));
			}
		}
		return names;
	}
}
