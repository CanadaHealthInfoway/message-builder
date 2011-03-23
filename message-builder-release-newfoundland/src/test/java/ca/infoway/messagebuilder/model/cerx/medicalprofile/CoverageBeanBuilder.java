package ca.infoway.messagebuilder.model.cerx.medicalprofile;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CoverageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class CoverageBeanBuilder extends BaseBeanBuilder<CoverageBean> {
	
	public CoverageBeanBuilder() {
		super(new CoverageBean());
	}

	public CoverageBeanBuilder populate() {
		this.bean.setIdentifier(new Identifier("coverageRoot", "extension"));
		this.bean.setMoodCode(CodeResolverRegistry.lookup(x_ActMoodOrderEvent.class, "RQO", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setPayorIdentifier(new Identifier("payorIdentifierRoot", "extension"));
		this.bean.setPayorName("Payor name");
		
		return this;
	}

}
