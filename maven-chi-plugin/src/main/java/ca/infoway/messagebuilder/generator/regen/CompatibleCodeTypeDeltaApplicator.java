package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.PropertyGeneratorBuilder;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationshipFactory;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;

public class CompatibleCodeTypeDeltaApplicator implements TypeDeltaApplicator {
	
	private RegeneratedRelationshipFactory factory = new RegeneratedRelationshipFactory();

	public void apply(final RelationshipsMergerContext context, final BaseRelationship originalRelationship, BaseRelationship newRelationship) {
		Attribute original = (Attribute) originalRelationship;
		Attribute newAttribute = (Attribute) newRelationship;
		
		RegeneratedRelationship relationship = getOrCreateRegenerated(context, originalRelationship, newRelationship);
		PropertyGeneratorBuilder buidler = relationship.getBuilder();
	}

	private RegeneratedRelationship getOrCreateRegenerated(
			RelationshipsMergerContext context, BaseRelationship originalRelationship,
			BaseRelationship newRelationship) {
		// TODO Auto-generated method stub
		return null;
	}

	private void replaceRelationship(Type mergedType, BaseRelationship originalRelationship, BaseRelationship mergedRelationship) {
		int index = mergedType.getRelationships().indexOf(originalRelationship);
		mergedType.getRelationships().remove(index);
		mergedType.getRelationships().add(index, mergedRelationship);
	}

	public boolean canApply(BaseRelationship originalRelationship, BaseRelationship newRelationship) {
		if (originalRelationship instanceof Attribute && newRelationship instanceof Attribute) {
			Attribute originalAttribute = (Attribute) originalRelationship; 
			Attribute newAttribute = (Attribute) newRelationship;
			return isCompatibleCodeChange(originalAttribute.getDomainType(), newAttribute.getDomainType());
		}
		return false;
	}

	private boolean isCompatibleCodeChange(String originalDomainType, String newDomainType) {
		boolean compatible = false;
		if (originalDomainType!=null && newDomainType!=null) {
			Class<?> originalType = DomainRegistry.getInstance().getDomainType(originalDomainType);
			Class<?> newType = DomainRegistry.getInstance().getDomainType(originalDomainType);
			if (originalType!=null && newType!=null && originalType.isAssignableFrom(newType)) {
				compatible = true;
			}
		}
		return compatible;
	}

}
