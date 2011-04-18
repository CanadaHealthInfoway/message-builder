package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBean;

public class ResponsiblePartyBeanBuilder extends BaseBeanBuilder<ResponsiblePartyBean> {

	public ResponsiblePartyBeanBuilder() {
		super(new ResponsiblePartyBean());
	}

	public ResponsiblePartyBeanBuilder populate() {
		this.bean.setCode(lookup(x_SimplePersonalRelationship.class, "SIB", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		bean.setId(new Identifier("3.14", "159"));
		PostalAddress address = new PostalAddress();
		address.addUse(PostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		bean.setAddress(address);
		bean.getTelecom().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		bean.setIndeterminatePerson(new IndeterminatePersonBeanBuilder().populate().create());
		bean.setStatusCode(lookup(RoleStatus.class, "active", CodeSystem.VOCABULARY_ROLE_STATUS.getRoot()));
		bean.setConfidentialityCode(
				lookup(x_NormalRestrictedTabooConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		bean.setEffectiveTime(IntervalUtil.createInterval(DateUtil.getDate(2000, 02, 03), DateUtil.getDate(2010, 03, 04)));
		return this;
	}

}