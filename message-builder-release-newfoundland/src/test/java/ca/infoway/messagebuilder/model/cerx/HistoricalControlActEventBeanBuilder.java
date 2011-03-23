package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class HistoricalControlActEventBeanBuilder extends
		BaseBeanBuilder<HistoricalControlActEventBean> {

	public HistoricalControlActEventBeanBuilder() {
		super(new HistoricalControlActEventBean());
	}

	public HistoricalControlActEventBeanBuilder withTriggerEventCode(String triggerEventCode) {
		this.bean.setCode(CodeResolverRegistry.lookup(HL7TriggerEventCode.class, triggerEventCode, CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		return this;
	}
	
	public HistoricalControlActEventBeanBuilder populate() {
		this.bean.setEffectiveTime(IntervalFactory.createLow(DateUtil.getDate(2009, 01, 01)));
		this.bean.setReasonCode(CodeResolverRegistry.lookup(ControlActReason.class, "EIE", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}

}
