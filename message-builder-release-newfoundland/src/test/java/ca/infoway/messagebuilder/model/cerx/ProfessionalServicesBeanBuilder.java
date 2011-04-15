package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.PerformerBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServiceRecord;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ProfessionalServicesBeanBuilder extends BaseBeanBuilder<ProfessionalServiceRecord> {
	
	public ProfessionalServicesBeanBuilder() {
		super(new ProfessionalServiceRecord());
	}

	public ProfessionalServicesBeanBuilder populate() {
		this.bean.setId(new Identifier("1.2.3.4.5", "1"));
		this.bean.setStatus(ActStatus.ACTIVE);
		this.bean.setCode(CodeResolverRegistry.lookup(ActProfessionalServiceCode.class, "SMC", "2.16.840.1.113883.6.95"));
		this.bean.setEffectiveTime(IntervalFactory.createSimple(DateUtil.getDate(2009, 0, 1)));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populateMabelHauptman().create());
		
		this.bean.setPerformer(new PerformerBean());
		this.bean.getPerformer().getAssignedPerson().setId(new Identifier("1.1.2.2.3.3.1", "2"));
		this.bean.getPerformer().getAssignedPerson().setLicenseNumber(new Identifier("77.33.22.11", "1"));
		this.bean.getPerformer().getAssignedPerson().setName(PersonName.createFirstNameLastName("John", "Doe"));
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		return this;
	}
}
