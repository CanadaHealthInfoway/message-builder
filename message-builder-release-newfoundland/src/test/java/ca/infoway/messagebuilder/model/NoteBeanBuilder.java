package ca.infoway.messagebuilder.model;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;

public class NoteBeanBuilder extends BaseBeanBuilder<NoteBean> {

	public NoteBeanBuilder() {
		super(new NoteBean());
	}

	public NoteBeanBuilder populate() {
		bean.setAuthor(new AuthorBeanBuilder().populate().create());
		bean.setText("note text");
		bean.setTime(new Date(0));
		bean.setAnnotationCode(lookup(ActPatientAnnotationCode.class, "MED", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		bean.setLanguageCode(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		bean.setRecordIdentifier(new Identifier("1.2.3.2.1", "1122112"));
		bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		return this;
	}
	
}
