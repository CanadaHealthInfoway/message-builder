package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;

public class AssignedPersonBeanBuilder extends BaseBeanBuilder<AssignedPersonBean> {

	public AssignedPersonBeanBuilder() {
		super(new AssignedPersonBean());
	}

	public AssignedPersonBeanBuilder populate() {
		this.bean.setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		this.bean.setId(new Identifier("12.34.56", "1"));
		this.bean.setName(PersonName.createFirstNameLastName("John", "Doe"));
		this.bean.setLicenseNumber(new Identifier("77.33.22.11", "1"));
		return this;
	}

}
