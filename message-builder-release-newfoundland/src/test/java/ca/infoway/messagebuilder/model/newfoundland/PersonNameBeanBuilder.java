package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.model.newfoundland.PersonNameBean;

public class PersonNameBeanBuilder extends BaseBeanBuilder<PersonNameBean> {
	
	public PersonNameBeanBuilder() {
		super(new PersonNameBean());
	}

	public PersonNameBeanBuilder withName(String firstName, String lastName) {
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		return this;
	}

}
