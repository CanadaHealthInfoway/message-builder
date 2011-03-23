package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

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
