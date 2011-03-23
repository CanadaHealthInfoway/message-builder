package ca.infoway.messagebuilder.model;

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
