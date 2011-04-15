package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;

public class ActRequestBeanBuilder extends BaseBeanBuilder<ActRequestBean> {

	public ActRequestBeanBuilder() {
		super(new ActRequestBean());
	}
	
	public ActRequestBeanBuilder populate() {
		this.bean.getIds().add(new Identifier("1.2.3.2.1", "12321"));
		this.bean.getIds().add(new Identifier("5.4.3.2", "9876"));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		return this;
	}

	public ActRequestBeanBuilder withIdentifier(Identifier identifier) {
		this.bean.setId(identifier);
		return this;
	}
}
