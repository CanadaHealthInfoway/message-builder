package ca.infoway.messagebuilder.marshalling;

import java.util.List;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

class PartBridgeImpl implements PartBridge {
	
	private final List<BaseRelationshipBridge> relationshipBridges;
	private final String typeName;
	private final boolean collapsed;
	private final String propertyPath;
	private final Object bean;
	
	public PartBridgeImpl(String propertyPath, Object bean, String typeName, List<BaseRelationshipBridge> relationshipBridges, boolean collapsed) {
		this.propertyPath = propertyPath;
		this.bean = bean;
		this.typeName = typeName;
		this.relationshipBridges = relationshipBridges;
		this.collapsed = collapsed;
	}

	public List<BaseRelationshipBridge> getRelationshipBridges() {
		return this.relationshipBridges;
	}

	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * <p>Determine if a part has any content.
	 * 
	 * <p>For the purposes of determining emptiness, we don't consider fixed attributes.
	 * We consider fixed values as not providing real content -- only meta-data.
	 * 
	 * <p>There are some part types that cause especial concern.  For example, the
	 * COCT_MT141007CA.PackagedDevice has only fixed values, and yet it is mandatory.
	 */
	public boolean isEmpty() {
		boolean empty = true;
		for (BaseRelationshipBridge relationship : this.relationshipBridges) {
			if (!relationship.getRelationship().isAttribute() || !relationship.getRelationship().isFixed()) {
				empty &= relationship.isEmpty();
			}
		}
		// watch out for "indicators", etc.
		if (empty) {
			empty = this.collapsed || this.bean == null || hasNullFlavor();
		}
		return empty;
	}

	public boolean hasNullFlavor() {
		boolean result = false;
		if (this.bean instanceof NullFlavorSupport) {
			NullFlavorSupport nullable = (NullFlavorSupport) this.bean;
			result = nullable.hasNullFlavor();
		}
		return result;
	}
	
	public NullFlavor getNullFlavor() {
		NullFlavor result = null;
		if (this.bean instanceof NullFlavorSupport) {
			NullFlavorSupport nullable = (NullFlavorSupport) this.bean;
			result = nullable.getNullFlavor();
		}
		return result;
	}

	public boolean isCollapsed() {
		return this.collapsed;
	}

	public String getPropertyName() {
		return this.propertyPath;
	}
}
