package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

public class SupplementalInstructionBeanBuilder extends BaseBeanBuilder<SupplementalInstructionBean> {

	public SupplementalInstructionBeanBuilder() {
		super(new SupplementalInstructionBean());
	}

	public SupplementalInstructionBeanBuilder populate() {
		this.bean.setMoodCode(lookup(x_ActMoodDefEvnRqo.class, "EVN", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		this.bean.setText("supplemental instruction text");
		return this;
	}
	
}
