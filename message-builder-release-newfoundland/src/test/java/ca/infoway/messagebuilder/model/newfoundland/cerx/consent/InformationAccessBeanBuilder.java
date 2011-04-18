package ca.infoway.messagebuilder.model.newfoundland.cerx.consent;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.InformationAccessTypeBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.consent.InformationAccessBean;

public class InformationAccessBeanBuilder extends BaseBeanBuilder<InformationAccessBean> {
	
	public InformationAccessBeanBuilder() {
		super(new InformationAccessBean());
	}

	public InformationAccessBeanBuilder populate() {
		InformationAccessTypeBean informationAccessType = new InformationAccessTypeBean();
		informationAccessType.setCode(lookup(ActInformationAccessTypeCode.class, "ACADR", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.getInformationAccessTypes().add(informationAccessType);
		this.bean.setRecipient(new AssignedPersonBeanBuilder().populate().create());
		return this;
	}

}
