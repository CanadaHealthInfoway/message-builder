/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.CausalityAssessmentBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.AdverseReactionBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public abstract class BaseAdverseReactionTransformationTest extends BaseTransformerTestCase {
	
	protected static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	protected abstract String getRequestMessageFile(); 
	protected abstract String getAcceptedMessageFile(); 
	protected abstract String getRefusedMessageFile();
	protected abstract HL7TriggerEventCode getRequestHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getAcceptedHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getRefusedHL7TriggerEventCode();
	protected abstract RecordResponseMessageBean<ActEventBean> createAcceptedBean();
	protected abstract RecordResponseMessageBean<ActEventBean> createRefusedBean();
	protected abstract RecordRequestMessageBean<AdverseReactionBean> createRequestBean();

	@Before
	public void setup() {
		CodeResolverRegistry.registerResolver(ActCode.class,
				new CompositeCodeResolver( 
						new EnumBasedCodeResolver(MockActCodeEnum.class),
						new TrivialCodeResolver()));
	}
	
	@Test
	@Ignore // BCH: looks like a bad mapping
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		assertNotNull("result", xml);
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRequestMessageFile())), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(
				getRequestMessageFile()));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RecordRequestMessageBean<AdverseReactionBean> message = (RecordRequestMessageBean<AdverseReactionBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RecordControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRecord());
		assertEquals("name", "Mabel Hauptman", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRecord().getPatient().getIndeterminatePerson().getName()));
	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getRequestMessageFile()));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	private RecordRequestMessageBean<AdverseReactionBean> createRequest() {
		RecordRequestMessageBean<AdverseReactionBean> model = createRequestBean();
		model.getControlActEvent().setCode(getRequestHL7TriggerEventCode());
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBean());
		model.getControlActEvent().getResponsibleParty().setId(new Identifier("3.16.840.1.113883.1.133", "223344"));
		model.getControlActEvent().getResponsibleParty().setName(new PersonName());
		model.getControlActEvent().getResponsibleParty().getName().addNamePart(new EntityNamePart("Laura", PersonNamePartType.GIVEN));
		model.getControlActEvent().getResponsibleParty().getName().addNamePart(new EntityNamePart("Bush", PersonNamePartType.FAMILY));
		model.getControlActEvent().getResponsibleParty().setLicenseNumber(new Identifier("3.21.456.1.113883.1.133", "445566"));
		model.getControlActEvent().getResponsibleParty().setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));

		RecordBean<AdverseReactionBean> recordBean = new RecordBean<AdverseReactionBean>();
		
		AdverseReactionBean reaction = new AdverseReactionBean();
		recordBean.setRecord(reaction);

		reaction.setId(new Identifier("2.16.124.113620.1.1.15", "7"));
		
		reaction.getPatient().setId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		reaction.getPatient().getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		reaction.getPatient().getIndeterminatePerson().setName(PersonName.createFirstNameLastName("Mabel", "Hauptman"));
		reaction.getPatient().getIndeterminatePerson().setBirthTime(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		
		reaction.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		reaction.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		reaction.setSeverityObservation(lookup(SeverityObservation.class, "H", CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		reaction.setSubjectReactionValue(lookup(SubjectReaction.class, "241938005", CodeSystem.SNOMED.getRoot()));
		reaction.setReactionOnsetDate(IntervalFactory.createLow(DateUtil.getDate(2009, 3, 22)));
		reaction.setText("some adverse reaction text");

//		ResponsiblePartyBean responsibleParty = new ResponsiblePartyBean();
//		responsibleParty.setId(new Identifier("2.16.840.1.113883.1.133", "665544"));
//		responsibleParty.getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.MALE);
//		responsibleParty.getIndeterminatePerson().setName(PersonNameUtil.createFirstNameLastName("George", "Jungle"));
//		responsibleParty.getIndeterminatePerson().setBirthTime(DateUtil.getDate(1955, Calendar.SEPTEMBER, 20));
		AssignedPersonBean assignedPersonBean = new AssignedPersonBean();
		assignedPersonBean.setId(new Identifier("2.16.840.1.113883.1.133", "665544"));
		assignedPersonBean.setName(PersonName.createFirstNameLastName("George", "Jungle"));
		
		reaction.setInformant(assignedPersonBean);
		reaction.setInformantTime(DateUtil.getDate(1999, Calendar.DECEMBER, 28));
		
		addCausalityAssessments(reaction.getCausalityAssessments(), 5);
		
		ActStatus status = lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot());
		
		NoteBean noteBean = new NoteBean();
		
		noteBean.setText("condition note");
		noteBean.setLanguageCode(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		noteBean.getAuthor().setId(new Identifier("2.16.840.1.113883.1.133", "112233"));
		noteBean.getAuthor().setLicenseNumber(new Identifier("2.16.840.1.113883.1.133", "332211"));
		noteBean.getAuthor().setTime(DateUtil.getDate(2008, 8, 20));
		noteBean.getAuthor().setName(new PersonName());
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Michelle", PersonNamePartType.GIVEN));
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Obama", PersonNamePartType.FAMILY));

		reaction.getNotes().add(noteBean);
		
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	private void addCausalityAssessments(List<CausalityAssessmentBean> list, int num) {
		for (int i = 0; i < num; i++) {
			CausalityAssessmentBean assessment = new CausalityAssessmentBean();
			assessment.setId(new Identifier("2.16.840.1.113883.1.133", ""+(i+1)));
			assessment.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
			assessment.setObservationValue(lookup(ObservationValue.class, "371627004", CodeSystem.SNOMED.getRoot()));
			assessment.setRouteCode(lookup(RouteOfAdministration.class, "CHEW", CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
			assessment.setMaterialCode(lookup(ExposureAgentEntityType.class, "NDA04", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
			assessment.setName("intelliware");
			list.add(assessment);
		}
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> acceptedBean = createAcceptedBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getAcceptedMessageFile())), actual);
	}

	private void populateAcceptedBean(RecordResponseMessageBean<ActEventBean> acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(getAcceptedHL7TriggerEventCode());
		acceptedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		acceptedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> refusedBean = createRefusedBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);	
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRefusedMessageFile())), actual);
	}

	protected void populateRefusedBean(RecordResponseMessageBean<ActEventBean> refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(getRefusedHL7TriggerEventCode());
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}
}
