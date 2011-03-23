package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.datatype.lang.Identifier;

public class ActEventBeanBuilder extends BaseBeanBuilder<ActEventBean> {
	
	public ActEventBeanBuilder() {
		super(new ActEventBean());
	}

	public ActEventBeanBuilder populate() {
		bean.setId(new Identifier("1.2.3.4", "11223344"));
		bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());		
		return this;
	}

}
