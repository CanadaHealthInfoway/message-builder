package ca.infoway.messagebuilder.model;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.newfoundland.PersonalRelationshipBean;

public class PersonalRelationshipBeanBuilder extends BaseBeanBuilder<PersonalRelationshipBean> {
	
	public PersonalRelationshipBeanBuilder() {
		super(new PersonalRelationshipBean());
	}

	public PersonalRelationshipBeanBuilder populate() {
		bean.setId(new Identifier("44.55.66.88", "4357"));
		bean.setRoleType(lookup(PersonalRelationshipRoleType.class, "SON", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		bean.setName(PersonName.createFirstNameLastName("George", "Lazen"));
		return this;
	}

}
