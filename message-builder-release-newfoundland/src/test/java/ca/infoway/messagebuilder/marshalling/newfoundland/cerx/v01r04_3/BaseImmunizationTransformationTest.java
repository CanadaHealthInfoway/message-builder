/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.NoPayloadResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ImmunizationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.RecordImmunizationMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public abstract class BaseImmunizationTransformationTest extends BaseTransformerTestCase {
	
	protected static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	protected abstract String getRequestMessageFile(); 
	protected abstract String getAcceptedMessageFile(); 
	protected abstract String getRefusedMessageFile();
	protected abstract HL7TriggerEventCode getRequestHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getAcceptedHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getRefusedHL7TriggerEventCode();
	protected abstract RecordResponseMessageBean<ActEventBean> createAcceptedBean();
	protected abstract NewBaseMessageBean createRefusedBean();
	protected abstract RecordRequestMessageBean<ImmunizationBean> createRequestBean();

	@Before
	public void setup() {
		CodeResolverRegistry.registerResolver(ActCode.class,
				new CompositeCodeResolver( 
						new EnumBasedCodeResolver(MockActCodeEnum.class),
						new TrivialCodeResolver()));
	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest()).getXmlMessage();
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest()).getXmlMessage();
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
		RecordRequestMessageBean<ImmunizationBean> message = (RecordRequestMessageBean<ImmunizationBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RecordControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRecord());
		assertEquals("name", "Hannah Lambert", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRecord().getPatient().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getRequestMessageFile()));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);

		@SuppressWarnings("unchecked")
		RecordRequestMessageBean<ImmunizationBean> msgObj = (RecordRequestMessageBean<ImmunizationBean>) xmlToJavaResult.getMessageObject();
		if (msgObj instanceof RecordImmunizationMessageBean) {
			assertNotNull("informant", msgObj.getRecord().getInformantRole());
		}

		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) msgObj).getXmlMessage();
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	private RecordRequestMessageBean<ImmunizationBean> createRequest() {
		RecordRequestMessageBean<ImmunizationBean> model = createRequestBean();
		model.getControlActEvent().setCode(getRequestHL7TriggerEventCode());
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		
		RecordBean<ImmunizationBean> recordBean = new RecordBean<ImmunizationBean>();
		recordBean.setRecord(new ImmunizationBeanBuilder().populate().create());
		
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> acceptedBean = createAcceptedBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean).getXmlMessage();
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
		NewBaseMessageBean refusedBean = createRefusedBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean).getXmlMessage();	
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRefusedMessageFile())), actual);
	}

	@SuppressWarnings("unchecked")
	protected void populateRefusedBean(NewBaseMessageBean refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(getRefusedHL7TriggerEventCode());
		if (refusedBean instanceof RecordResponseMessageBean) {
			RecordResponseMessageBean<ActEventBean> actEventMessageBean = (RecordResponseMessageBean<ActEventBean>) refusedBean;
			actEventMessageBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
			actEventMessageBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
			actEventMessageBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		} else {
			NoPayloadResponseMessageBean noPayloadMessageBean = (NoPayloadResponseMessageBean) refusedBean;
			noPayloadMessageBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		}
	}
}
