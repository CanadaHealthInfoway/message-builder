package ca.infoway.messagebuilder.marshalling;

import java.util.Collections;
import java.util.List;

class MockPartBridge implements PartBridge {

	private boolean isEmpty;
	private String typeName;
	
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
}
