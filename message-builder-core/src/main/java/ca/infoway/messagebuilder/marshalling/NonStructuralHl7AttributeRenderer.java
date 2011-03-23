package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

class NonStructuralHl7AttributeRenderer {
	
	static Object getFixedValue(Relationship relationship) {
		if (StringUtils.equals("BL",relationship.getType())) {
			return Boolean.TRUE.toString().equalsIgnoreCase(relationship.getFixedValue());
		} else if (StringUtils.equals("INT.POS", relationship.getType())) {
			return new Integer(relationship.getFixedValue());
		} else if (relationship.isCodedType()) {
			return CodeResolverRegistry.lookup(DomainTypeHelper.getReturnType(relationship), relationship.getFixedValue());
		} else {
			throw new MarshallingException("Cannot handle a fixed relationship of type: " + relationship.getType());
		}
	}
	
	public static boolean matches(RelationshipReader reader, Relationship relationship, MessagePart messagePart) {
		return relationship.isAttribute() && !relationship.isStructural();
	}
}