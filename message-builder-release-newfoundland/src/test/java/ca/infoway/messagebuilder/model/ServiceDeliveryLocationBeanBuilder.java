package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ServiceDeliveryLocationBeanBuilder extends BaseBeanBuilder<ServiceDeliveryLocationBean> {

	public ServiceDeliveryLocationBeanBuilder() {
		super(new ServiceDeliveryLocationBean());
	}

	public ServiceDeliveryLocationBeanBuilder populate() {
		bean.setIdentifier(new Identifier("2.2.2", "3"));
		bean.setName("Intelliware's Pharmacy");
		bean.setCode(CodeResolverRegistry.lookup(ServiceDeliveryLocationRoleType.class, "ALL", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		
		PostalAddress address = new PostalAddress();
		address.addUse(PostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		bean.setAddr(address);
		bean.getTelecom().add(new TelecommunicationAddress(CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.10"));

		return this;
	}

}
