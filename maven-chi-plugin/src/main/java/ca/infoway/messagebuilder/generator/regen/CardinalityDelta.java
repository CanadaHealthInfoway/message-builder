package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationshipFactory;

public class CardinalityDelta extends Delta {
	
	private RegeneratedRelationshipFactory factory = new RegeneratedRelationshipFactory();

	public CardinalityDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		super(oldRelationship, newRelationship);
	}

	@Override
	public void apply(final RelationshipsMergerContext context) {
//		Cardinality oldCardinality = oldRelationship.getCardinality();
//		Cardinality newCardinality = newRelationship.getCardinality();
//		if (oldCardinality.isSingle() && newCardinality.isMultiple()
//		 || oldCardinality.isMultiple() && newCardinality.isSingle()) {
//			this.factory.createRegenerated(oldRelationship, newRelationship, new RegeneratedRelationshipFactory.Callback(){
//				@Override
//				protected void created(final RegeneratedAssociation regenerated) {
//					if (oldRelationship.isCardinalityMultiple()) {
//						regenerated.setBuilder(PropertyGeneratorBuilders.newAssociationCardinalityChangedFromMultipleToSingleBuilder(regenerated));
//					} else {
//						regenerated.setBuilder(PropertyGeneratorBuilders.newAssociationCardinalityChangedFromSingleToMultipleBuilder(regenerated));
//					}
//					replaceRelationship(context.getMergedType(), oldRelationship, (BaseRelationship) regenerated);
//				}
//				//a cardinality change of an attribute type relationship
//				//is a type change indeed, and is hence represented with a TypeDelta
//			});			
//		}
//		
//		System.out.println(toString(context.getMergedType()) + format(",%s, %s", getCardinality(this.oldRelationship), getCardinality(this.newRelationship)));
	}

//	private Object getCardinality(BaseRelationship relationship) {
//		return relationship.getCardinality();
//	}
	
}
