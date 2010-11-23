package ca.infoway.messagebuilder.marshalling;

import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

class MockPartBridge implements PartBridge {

	private boolean isEmpty;
	private String typeName;
	private NullFlavor nullFlavor;
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getPropertyName() {
		return "aPropertyName2";
	}

	public List<BaseRelationshipBridge> getRelationshipBridges() {
		return Collections.<BaseRelationshipBridge>emptyList();
	}

	public String getTypeName() {
		return this.typeName;
	}

	public boolean isCollapsed() {
		return false;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public NullFlavor getNullFlavor() {
		return this.nullFlavor;
	}

	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}
	
	public boolean hasNullFlavor() {
		return this.nullFlavor != null;
	}
}
