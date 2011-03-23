package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7StandardVersionCode;

class TopLevelBeanBridgeWrapper implements PartBridge {

	public class FixedValueIfNotProvidedAttributeBeanBridge extends FixedValueAttributeBeanBridge {

		private final AttributeBridge relationshipBridge;

		public FixedValueIfNotProvidedAttributeBeanBridge(
				AttributeBridge relationshipBridge, BareANY any) {
			super(relationshipBridge.getRelationship(), any);
			this.relationshipBridge = relationshipBridge;
		}
		@Override
		public BareANY getHl7Value() {
			BareANY any = this.relationshipBridge.getHl7Value();
			if (any == null || any.getBareValue() == null) {
				return super.getHl7Value();
			} else {
				return any;
			}
		}
	}

	private final PartBridge bridge;
	private final String interactionId;

	public TopLevelBeanBridgeWrapper(PartBridge bridge, String interactionId) {
		this.bridge = bridge;
		this.interactionId = interactionId;
	}
	
	public List<BaseRelationshipBridge> getRelationshipBridges() {
		List<BaseRelationshipBridge> result = new ArrayList<BaseRelationshipBridge>();
		for (BaseRelationshipBridge relationshipBridge : this.bridge.getRelationshipBridges()) {
			if ("versionCode".equals(relationshipBridge.getRelationship().getName())
					&& !relationshipBridge.getRelationship().isFixed()) {
				result.add(new FixedValueAttributeBeanBridge(relationshipBridge.getRelationship(), 
						new CSImpl(HL7StandardVersionCode.V3_2007_05)));
			} else if ("interactionId".equals(relationshipBridge.getRelationship().getName())) {
				result.add(new FixedValueIfNotProvidedAttributeBeanBridge((AttributeBridge) relationshipBridge, 
						new IIImpl(new Identifier("2.16.840.1.113883.1.6", this.interactionId))));
			} else {
				result.add(relationshipBridge);
			}
		}
		return result;
	}

	public String getTypeName() {
		return this.interactionId;
	}

	public boolean isEmpty() {
		return this.bridge.isEmpty();
	}

	public String getPropertyName() {
		return this.bridge.getPropertyName();
	}

	public boolean isCollapsed() {
		return false;
	}
}
