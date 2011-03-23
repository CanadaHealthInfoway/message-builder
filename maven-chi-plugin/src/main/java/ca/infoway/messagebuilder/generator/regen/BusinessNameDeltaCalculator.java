package ca.infoway.messagebuilder.generator.regen;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.BusinessNameUtil;

public class BusinessNameDeltaCalculator extends NameBasedDeltaCalculator {

	@Override
	protected Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship,	BaseRelationship newRelationship) {
		Delta result = null;

		String oldBusinessName = getBusinessName(oldRelationship);
		String newBusinessName = getBusinessName(newRelationship);
		
		// case sensitive for the time being...
		if (!StringUtils.isEmpty(newBusinessName) && !StringUtils.equals(oldBusinessName, newBusinessName)) {
			result = new BusinessNameDelta(oldRelationship, newRelationship);
		}
		
		return result;
	}

	private String getBusinessName(BaseRelationship oldRelationship) {
		String result = null;
		if (oldRelationship != null && oldRelationship.getDocumentation() != null) {
			result = BusinessNameUtil.cleanUpBusinessName(oldRelationship.getDocumentation().getBusinessName());
		}
		return result;
	}


}
