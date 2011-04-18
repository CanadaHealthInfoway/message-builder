package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;

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
