package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.util.Collection;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.TypeConverter;

public class Case0Simplifier extends InlineableSimplifier {

	public Case0Simplifier(LogUI log, TypeAnalysisResult result) {
		super(log, result);
	}

	protected boolean isInlineable(ComplexTypePackage complexTypePackage, Type inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (!getNonFixedRelationships(inlineableType).isEmpty()) {
			result = false;
		} else if (inlineableType.isAbstract()) {
			result = false;
		}

		return result;
	}

	protected void inline(ComplexTypePackage complexTypePackage, Type inlineableType) {
		Collection<Type> types = this.result.getAllMessageTypes();
		
		for (Type type : types) {
			for (int i = 0, length = type.getRelationships().size(); i < length; i++) {
				BaseRelationship relationship = type.getRelationships().get(i);
				if (matches(inlineableType, relationship)) {

					Attribute newRelationship = new Attribute(relationship.getRelationship(), new TypeConverter().convertToType("BL", null), true);
					if (relationship instanceof InlinedAssociation) {
						BaseRelationship elidedRelationship = ((InlinedAssociation) relationship).getElidedRelationship();
						newRelationship = new InlinedAttribute(newRelationship, elidedRelationship, true); 
					}
				
					this.log.log(INFO, "Simplification case 0: Type " + inlineableType.getName() 
							+ " is being rolled up into " + type.getName() + "." + relationship.getName() + " as a Boolean");
					
					type.getRelationships().set(i, newRelationship);
				}
			}
		}
		if (!containedInChoice(inlineableType)) {
			this.log.log(INFO, "Simplification case 0: removing type " + inlineableType.getName());
			this.result.removeType(inlineableType);
		}
	}

}
