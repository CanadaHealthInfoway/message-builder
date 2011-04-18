package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageLineWrapperBean;

public class DosageLineWrapperBeanBuilder extends BaseBeanBuilder<DosageLineWrapperBean> {

	public DosageLineWrapperBeanBuilder() {
		super(new DosageLineWrapperBean());
	}

	public DosageLineWrapperBeanBuilder populate() {
		this.bean.setSequenceNumber(1);
		this.bean.setDosageLine(new DosageLineBeanBuilder().populate().create());
		return this;
	}
	
}
