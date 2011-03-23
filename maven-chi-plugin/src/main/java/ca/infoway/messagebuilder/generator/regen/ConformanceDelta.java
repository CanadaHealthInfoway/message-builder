package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ConformanceDelta extends Delta {

	public ConformanceDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		super(oldRelationship, newRelationship);
	}

	@Override
	public void apply(RelationshipsMergerContext context) {
		ConformanceLevel oldConformance = this.oldRelationship.getConformanceLevel();
		ConformanceLevel newConformance = this.newRelationship.getConformanceLevel();
		
		if (newConformance!=null && newConformance.isMorePermissive(oldConformance)) {
			if (oldRelationship!=null) {
				oldRelationship.setConformanceLevel(newConformance);
			}
		}
//		System.out.println(toString(context.getMergedType()) 
//				+ format(",%s, %s", this.oldRelationship.getConformanceLevel(), this.newRelationship.getConformanceLevel()));
	}

}
