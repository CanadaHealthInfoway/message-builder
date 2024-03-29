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
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.VaccineEntityType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ImmunizationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.immunization.ImmunizationQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ImmunizationQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/immunizationQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/immunizationQueryResponse.xml";

	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
		CodeResolverRegistry.registerResolver(ActCode.class,
				new CompositeCodeResolver( 
						new EnumBasedCodeResolver(MockActCodeEnum.class),
						new TrivialCodeResolver()));
	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery()).getXmlMessage();
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		ImmunizationQueryMessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", ImmunizationQueryMessageBean.class, result.getMessageObject().getClass());
		
		ImmunizationQueryMessageBean messageObject = (ImmunizationQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}
	
	private ImmunizationQueryMessageBean createQuery() {
		ImmunizationQueryMessageBean model = new ImmunizationQueryMessageBean(createCriteria());
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.IMMUNIZATION_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}
	
	private ImmunizationQueryCriteriaBean createCriteria() {
		ImmunizationQueryCriteriaBean criteria = new ImmunizationQueryCriteriaBean();
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setIncludeNotesIndicator(true);
		criteria.setImmunizationPeriod(IntervalUtil.createInterval(DateUtil.getDate(2008, 4, 18, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")), 
				DateUtil.getDate(2009, 2, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		criteria.setIncludeIssuesIndicator(true);
		criteria.setNextPlannedDosePeriod(IntervalUtil.createInterval(DateUtil.getDate(2008, 9, 20, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")),
				DateUtil.getDate(2009, 2, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		criteria.setRenewalPeriod(IntervalUtil.createInterval(DateUtil.getDate(2008, 2, 4, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")),
				DateUtil.getDate(2009, 2, 5, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		criteria.setVaccineCode(lookup(VaccineEntityType.class, "396422009", CodeSystem.SNOMED.getRoot()));
		criteria.setVaccineDoseNumber(2);
		return criteria;
	}

	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
		ImmunizationQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		ImmunizationQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}

	private ImmunizationQueryResponseMessageBean createResponseBean() {
		ImmunizationQueryResponseMessageBean model = new ImmunizationQueryResponseMessageBean(createCriteria());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.IMMUNIZATION_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		ImmunizationBean immunization = new ImmunizationBeanBuilder().populate().create();
		immunization.getMedicine().setExpirationTime(IntervalFactory.createHigh(DateUtil.getDate(2009, 0, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<ImmunizationBean>(immunization));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<ImmunizationBean>(immunization));
		
		return model;
	}

}
