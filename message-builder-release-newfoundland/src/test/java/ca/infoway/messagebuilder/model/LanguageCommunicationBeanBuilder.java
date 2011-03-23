package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class LanguageCommunicationBeanBuilder extends BaseBeanBuilder<LanguageCommunicationBean> {

	public LanguageCommunicationBeanBuilder() {
		super(new LanguageCommunicationBean());
	}

	public LanguageCommunicationBeanBuilder withLanguageCode(String codeValue) {
		this.bean.setLanguageCode(CodeResolverRegistry.lookup(HumanLanguage.class, codeValue, "2.16.840.1.113883.6.84"));
		return this;
	}

}
