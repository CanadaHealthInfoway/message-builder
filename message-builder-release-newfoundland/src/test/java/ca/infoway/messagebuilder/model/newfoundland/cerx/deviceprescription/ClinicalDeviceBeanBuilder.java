package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ClinicalDeviceEntity;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ClinicalDeviceBeanBuilder extends BaseBeanBuilder<ClinicalDeviceBean> {

	public ClinicalDeviceBeanBuilder() {
		super(new ClinicalDeviceBean());
	}

	public ClinicalDeviceBeanBuilder populate() {
		this.bean.setCode(CodeResolverRegistry.lookup(ClinicalDeviceEntity.class, "97799979", CodeSystem.OPINIONS.getRoot()));
		this.bean.setName("Onetouch Surestep Testing Strips (100)");
		this.bean.setDesc("A concoction of this and that");
		this.bean.setQuantity(1);
		return this;
	}

}
