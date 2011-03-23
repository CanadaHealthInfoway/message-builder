package ca.infoway.messagebuilder.generator.java;

public class RegeneratedRelationshipFactory {
	
	public static class Callback {
		protected void created(RegeneratedAttribute regenerated) {
		}
		protected void created(RegeneratedAssociation regenerated) {
		}
	}
	
	public void createRegenerated(BaseRelationship originalRelationship, BaseRelationship newRelationship, Callback callback) {
		if (originalRelationship instanceof InlinedAttribute) {
			callback.created(new RegeneratedInlinedAttribute((InlinedAttribute) originalRelationship, (InlinedAttribute) newRelationship));
		} else if (originalRelationship instanceof Attribute) {
			callback.created(new RegeneratedAttributeImpl((Attribute) originalRelationship, (Attribute) newRelationship));
		} else if (originalRelationship instanceof InlinedAssociation) {
			callback.created(new RegeneratedInlinedAssociation((InlinedAssociation) originalRelationship, (InlinedAssociation) newRelationship));
		} else if (originalRelationship instanceof Association) {
			callback.created(new RegeneratedAssociationImpl((Association) originalRelationship, (Association) newRelationship));
		} else {
			throw new IllegalArgumentException("Unable to create regenerated relationship for relationship of type: " + originalRelationship.getClass().getSimpleName());
		}
	}

}
