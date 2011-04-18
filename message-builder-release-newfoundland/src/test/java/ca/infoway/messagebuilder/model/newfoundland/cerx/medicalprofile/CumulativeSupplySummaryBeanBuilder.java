package ca.infoway.messagebuilder.model.newfoundland.cerx.medicalprofile;

import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;


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
