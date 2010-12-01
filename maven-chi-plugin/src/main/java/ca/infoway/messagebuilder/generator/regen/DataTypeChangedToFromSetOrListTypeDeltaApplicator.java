package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationshipFactory;
import ca.infoway.messagebuilder.generator.java.Type;

public class DataTypeChangedToFromSetOrListTypeDeltaApplicator implements TypeDeltaApplicator {
	
	private RegeneratedRelationshipFactory factory = new RegeneratedRelationshipFactory();

	public void apply(final RelationshipsMergerContext context, final BaseRelationship originalRelationship, BaseRelationship newRelationship) {
//		factory.createRegenerated(originalRelationship, newRelationship, new RegeneratedRelationshipFactory.Callback() {
//			@Override
//			protected void created(final RegeneratedAttribute regenerated) {
//				if (originalRelationship.isCardinalityMultiple()) {
//					regenerated.setBuilder(PropertyGeneratorBuilders.newAttributeTypeChangedFromListOrSetToSimpleBuilder(regenerated));
//				} else {
//					regenerated.setBuilder(PropertyGeneratorBuilders.newAttributeTypeChangedFromSimpleToListOrSetBuilder(regenerated));
//				}
//				replaceRelationship(context.getMergedType(), originalRelationship, (BaseRelationship) regenerated);
//			}
//		});
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
			
			DataType originalDataType = originalAttribute.getDataType();
			DataType newDataType = newAttribute.getDataType();
			
			return originalDataType.isWrappedTypeListOrSet() != newDataType.isWrappedTypeListOrSet();
		}
		return false;
	}

}
