package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.PropertyGeneratorBuilders;
import ca.infoway.messagebuilder.generator.java.RegeneratedAssociation;
import ca.infoway.messagebuilder.generator.java.RegeneratedAttribute;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationshipFactory;

public class BusinessNameDelta extends Delta {
	
	private RegeneratedRelationshipFactory factory = new RegeneratedRelationshipFactory(); 

	public BusinessNameDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		super(oldRelationship, newRelationship);
	}

	@Override
	public void apply(final RelationshipsMergerContext context) {
		BaseRelationship existingRelationship = context.getMergedType().getRelationship(oldRelationship.getName());
		if (!(existingRelationship instanceof RegeneratedRelationship)) {
			
			this.factory.createRegenerated(oldRelationship, newRelationship, new RegeneratedRelationshipFactory.Callback(){
				@Override
				protected void created(final RegeneratedAssociation regenerated) {
					regenerated.setBuilder(PropertyGeneratorBuilders.newAssociationBusinessNameChangedBuilder(regenerated));
					replaceRelationship(context.getMergedType(), oldRelationship, (BaseRelationship) regenerated);
				}
				@Override
				protected void created(final RegeneratedAttribute regenerated) {
					regenerated.setBuilder(PropertyGeneratorBuilders.newAttributeBusinessNameChangedBuilder(regenerated));
					replaceRelationship(context.getMergedType(), oldRelationship, (BaseRelationship) regenerated);
				}
			});			
		} 
		
//		System.out.println(toString(context.getMergedType()) + 
//				format(",\"%s\", \"%s\"", 
//						getBusinessName(this.oldRelationship), getBusinessName(this.newRelationship)));
	}

//	private String getBusinessName(BaseRelationship newRelationship) {
//		return newRelationship.getDocumentation() != null ? BusinessNameUtil.cleanUpBusinessName(newRelationship.getBusinessName()) : "";
//	}

}
