package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;

public class TypeDelta extends Delta {
	
	private TypeDeltaApplicatorProvider applicatorProvider; 

	public TypeDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		this(oldRelationship, newRelationship, new TypeDeltaApplicatorProvider());
	}

	TypeDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship, TypeDeltaApplicatorProvider applicatorProvider) {
		super(oldRelationship, newRelationship);
		this.applicatorProvider = applicatorProvider;
	}
	
	@Override
	public void apply(RelationshipsMergerContext context) {
		applicatorProvider.getApplicator(oldRelationship, newRelationship).apply(context, oldRelationship, newRelationship);
//		System.out.println(toString(context.getMergedType()) + format(",%s, %s", getType(this.oldRelationship), getType(this.newRelationship)));
	}

//	private Object getType(BaseRelationship relationship) {
//		if (relationship instanceof Attribute) {
//			return "\""+((Attribute) relationship).getDataType().getShortWrappedName()+"\"";
//		} else {
//			return "\""+((Association) relationship).getAssociationType()+"\"";
//		}
//	}
	
}
