package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstitutionPermissionBean;

public class SubstitutionPermissionBeanBuilder extends BaseBeanBuilder<SubstitutionPermissionBean> {
	
	public SubstitutionPermissionBeanBuilder() {
		super(new SubstitutionPermissionBean());
	}

	public SubstitutionPermissionBeanBuilder populate() {
		// SPD: fixed
		// this.bean.setCode(lookup(ActCode.class, "G", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setNegationInd(false);
		this.bean.setReasonCode(
				lookup(SubstanceAdminSubstitutionNotAllowedReason.class, "ALGALT", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		return this;
	}

}
