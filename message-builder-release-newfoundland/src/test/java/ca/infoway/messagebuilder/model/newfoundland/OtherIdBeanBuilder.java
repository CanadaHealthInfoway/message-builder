package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.model.newfoundland.OtherIdentifiersBean;

public class OtherIdBeanBuilder extends BaseBeanBuilder<OtherIdentifiersBean> {
	
	public OtherIdBeanBuilder() {
		super(new OtherIdentifiersBean());
	}

	public OtherIdBeanBuilder populate() {
		bean.setCode(lookup(OtherIdentifierRoleType.class, "PASS", CodeSystem.VOCABULARY_OTHER_IDENTIFIER_ROLE_TYPE.getRoot()));
		bean.setOrganizationName("Organization Inc.");
		bean.setOrganizationId(new Identifier("11.22.33", "987"));
		bean.getIds().add(new Identifier("1.2.3", "123"));
		return this;
	}

}
