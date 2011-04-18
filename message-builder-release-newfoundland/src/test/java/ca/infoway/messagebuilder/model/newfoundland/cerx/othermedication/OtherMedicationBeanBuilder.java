package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication.OtherMedicationBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class OtherMedicationBeanBuilder extends BaseBeanBuilder<OtherMedicationBean> {

	public OtherMedicationBeanBuilder() {
		super(new OtherMedicationBean());
	}

	public OtherMedicationBeanBuilder populate() {
		this.bean.setCode(CodeResolverRegistry.lookup(ActCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setStatusCode(ActStatus.ACTIVE);
		this.bean.setId(new Identifier(CodeSystem.INTELLIWARE_APPLICATIONS_TEAL.getRoot() + ".1111", "1234"));
		this.bean.getMedicine().setCode(CodeResolverRegistry.lookup(ClinicalDrug.class, "01916475", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.getMedicine().setName("Percocet");
		AssignedPersonBean author = new AssignedPersonBean();
		author.setId(new Identifier("13.23", "129387"));
		author.setName(PersonName.createFirstNameLastName("Frederick", "Strange"));
		this.bean.setAuthor(author);
		
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		return this;
	}

}
