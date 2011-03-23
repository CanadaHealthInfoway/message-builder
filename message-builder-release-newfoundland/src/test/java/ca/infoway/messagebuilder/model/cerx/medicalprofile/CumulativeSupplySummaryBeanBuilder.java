package ca.infoway.messagebuilder.model.cerx.medicalprofile;

import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CumulativeSupplySummaryBean;


public class CumulativeSupplySummaryBeanBuilder extends BaseBeanBuilder<CumulativeSupplySummaryBean> {
	
	public CumulativeSupplySummaryBeanBuilder() {
		super(new CumulativeSupplySummaryBean());
	}

	public CumulativeSupplySummaryBeanBuilder populate() {
//		this.bean.setQuantity(new PhysicalQuantity());
		this.bean.setRepeatNumber(1);
		return this;
	}

}
