package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.model.BaseBeanBuilder;

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
