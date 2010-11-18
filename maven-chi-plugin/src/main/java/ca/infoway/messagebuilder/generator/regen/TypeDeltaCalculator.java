package ca.infoway.messagebuilder.generator.regen;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;

import ca.infoway.messagebuilder.generator.java.Association;
import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.Type;

//FIXME - AG/TM: it might need more work, specially in the template types area.
public class TypeDeltaCalculator extends NameBasedDeltaCalculator {

	@Override
	protected Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		Delta result = null;
		
		if (typeChanged(oldRelationship, newRelationship)) {
			result = new TypeDelta(oldRelationship, newRelationship);
		}
		
		return result;
	}

	private boolean typeChanged(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		return isAttribute(oldRelationship) != isAttribute(newRelationship)
		    || (isAttribute(oldRelationship) && isAttribute(newRelationship) && attributeTypeChanged(oldRelationship, newRelationship))
		    || (isAssociation(oldRelationship) && isAssociation(newRelationship) && associationTypeChanged(oldRelationship, newRelationship));
	}

	private boolean associationTypeChanged(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		Association oldAssociation = (Association) oldRelationship; 
		Association newAssociation = (Association) newRelationship;
		return !equals(oldAssociation.getAssociationType(), newAssociation.getAssociationType());
	}

	private boolean equals(Type associationType1, Type associationType2) {
		return new EqualsBuilder().append(
				associationType1 != null ? associationType1.getTypeName() : null, 
				associationType2 != null ? associationType2.getTypeName() : null)
			.isEquals();
	}

	private boolean isAssociation(BaseRelationship relationship) {
		return relationship instanceof Association;
	}

	private boolean isAttribute(BaseRelationship relationship) {
		return relationship instanceof Attribute;
	}

	private boolean attributeTypeChanged(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		return !StringUtils.equals(oldRelationship.getType(), newRelationship.getType())
		    || !StringUtils.equals(oldRelationship.getWrappedType(), newRelationship.getWrappedType())
		    || !StringUtils.equals(oldRelationship.getTypeParameters(), newRelationship.getTypeParameters());
	}

}
