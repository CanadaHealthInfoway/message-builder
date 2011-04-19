package ca.infoway.messagebuilder.model.newfoundland.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstanceAdministrationRequestBean;

public class SubstanceAdministrationRequestBeanBuilder extends BaseBeanBuilder<SubstanceAdministrationRequestBean> {

	public SubstanceAdministrationRequestBeanBuilder() {
		super(new SubstanceAdministrationRequestBean());
	}

	public SubstanceAdministrationRequestBeanBuilder populate() {
		this.bean.getId().add(new Identifier("prescriptionIdRoot", "1"));
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}

}