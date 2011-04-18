package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.newfoundland.SeverityObservationBean;

public class SeverityObservationBeanBuilder extends BaseBeanBuilder<SeverityObservationBean> {

	public SeverityObservationBeanBuilder() {
		super(new SeverityObservationBean());
	}

	// TM - this bean is pretty much useless. We only ever need the underlying SeverityObservation; the rest are fixed values.

	public SeverityObservationBeanBuilder populate() {
		bean.setCode(lookup(ActCode.class, "N", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		bean.setSeverityObservation(lookup(SeverityObservation.class, "H", CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		return this;
	}
	
}
