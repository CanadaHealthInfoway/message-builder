package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.CustodianBean;


public class CustodianBeanBuilder extends BaseBeanBuilder<CustodianBean> {

	public CustodianBeanBuilder() {
		super(new CustodianBean());
	}

	public CustodianBeanBuilder populate() {
		bean.setId(new Identifier("2.16.124.113620.1.1.14", "1"));
		bean.setJurisdictionName("Ontario/TEAL");
		bean.setRepositoryName("TEAL Repository");
		return this;
	}
}
