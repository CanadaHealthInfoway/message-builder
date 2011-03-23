package ca.infoway.messagebuilder.model;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;

public class AuthorBeanBuilder extends BaseBeanBuilder<AuthorBean> {
	
	public AuthorBeanBuilder() {
		super(new AuthorBean());
	}

	public AuthorBeanBuilder populate() {
		this.bean.setId(new Identifier("1.1.1", "1"));
		this.bean.setLicenseNumber(new Identifier("2.2.2", "1"));
		this.bean.setTime(new Date(0));
		this.bean.setName(createPersonName("John", "Doe"));
		this.bean.setSignatureCode(lookup(ParticipationSignature.class, "S", CodeSystem.VOCABULARY_PARTICIPATION_SIGNATURE.getRoot()));
		return this;
	}
	
	public AuthorBeanBuilder populateIncludingHealthcareProviderRoleType() {
		this.populate();
		this.bean.setCode(lookup(HealthcareProviderRoleType.class, "AUD", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		return this;
	}
	
	private PersonName createPersonName(String firstName, String lastName) {
		PersonName personName = new PersonName();
		personName.getParts().add(new EntityNamePart(firstName, PersonNamePartType.GIVEN));
		personName.getParts().add(new EntityNamePart(lastName, PersonNamePartType.FAMILY));
		return personName;
	}
	
}
