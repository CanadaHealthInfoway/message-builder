package ca.infoway.messagebuilder.model.cerx;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class RefusalToFillBeanBuilder extends BaseBeanBuilder<RefusalToFillBean> {

	public RefusalToFillBeanBuilder() {
		super(new RefusalToFillBean());
	}
	
	public RefusalToFillBeanBuilder populate() {
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
		this.bean.setEffectiveTime(new Date(0));
		this.bean.setReasonCode(CodeResolverRegistry.lookup(ActSupplyFulfillmentRefusalReason.class, "FRR01", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
