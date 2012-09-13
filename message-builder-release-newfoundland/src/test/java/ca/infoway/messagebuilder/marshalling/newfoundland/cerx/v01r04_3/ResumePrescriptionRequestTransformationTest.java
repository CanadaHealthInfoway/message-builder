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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.resume.ResumePrescriptionRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ResumePrescriptionRequestTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/resumePrescriptionRequest.xml";
	protected static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createRequestBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		ResumePrescriptionRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) result.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}
	
	private ResumePrescriptionRequestMessageBean createRequestBean() {
		ResumePrescriptionRequestMessageBean model = new ResumePrescriptionRequestMessageBean();
		
		model.getControlActEvent().setCode(HL7TriggerEventCode.RESUME_PRESCRIPTION_REQUEST);
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
		
		ActRequestBean actRequestBean = new ActRequestBeanBuilder().populate().create();
		
		RecordBean<ActRequestBean> recordBean = new RecordBean<ActRequestBean>();
		recordBean.setRecord(actRequestBean);
		
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
}
