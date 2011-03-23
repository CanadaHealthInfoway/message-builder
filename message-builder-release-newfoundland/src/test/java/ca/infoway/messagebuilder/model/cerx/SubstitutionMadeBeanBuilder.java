package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

public class SubstitutionMadeBeanBuilder extends BaseBeanBuilder<SubstitutionMadeBean> {

	public static final Identifier DEFAULT_RESPONSIBLE_PARTY = new Identifier("1.2.3.4", "11223344");

	public SubstitutionMadeBeanBuilder() {
		super(new SubstitutionMadeBean());
	}

	public SubstitutionMadeBeanBuilder populate() {
		this.bean.setCode(lookup(ActSubstanceAdminSubstitutionCode.class, "F", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setReasonCode(lookup(SubstanceAdminSubstitutionReason.class, "CT", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setResponsibleParty(DEFAULT_RESPONSIBLE_PARTY);
		return this;
	}

	public SubstitutionMadeBeanBuilder withCodeNone() {
		this.bean.setCode(lookup(ActSubstanceAdminSubstitutionCode.class, "N", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		return this;
	}
}
