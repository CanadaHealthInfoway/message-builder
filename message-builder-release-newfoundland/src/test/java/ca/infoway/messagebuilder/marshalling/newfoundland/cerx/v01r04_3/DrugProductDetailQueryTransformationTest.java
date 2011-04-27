/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.query.DrugProductDetailQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.query.DrugProductDetailQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.query.DrugProductDetailQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.query.DrugProductDetailRecord;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class DrugProductDetailQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String DRUG_CODE = "02150352";
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/drugProductDetailQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/drugProductDetailQueryResponse.xml";

	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}	

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		DrugProductDetailQueryMessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", DrugProductDetailQueryMessageBean.class, result.getMessageObject().getClass());
		
		DrugProductDetailQueryMessageBean messageObject = (DrugProductDetailQueryMessageBean) result.getMessageObject();
		assertEquals("drug code", DRUG_CODE, messageObject.getCriteria().getDrugCode().getCodeValue());
	}
	
	private DrugProductDetailQueryMessageBean createQuery() {
		DrugProductDetailQueryMessageBean model = new DrugProductDetailQueryMessageBean(createCriteriaBean());
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DRUG_PRODUCT_DETAIL_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private DrugProductDetailQueryCriteriaBean createCriteriaBean() {
		DrugProductDetailQueryCriteriaBean criteria = new DrugProductDetailQueryCriteriaBean();
		criteria.setDrugCode(CodeResolverRegistry.lookup(ClinicalDrug.class, DRUG_CODE, CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		return criteria;
	}
	
	@Test @Ignore
	public void shouldCreateMeaningfulResponse() throws Exception {
		DrugProductDetailQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		DrugProductDetailQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}

	private DrugProductDetailQueryResponseMessageBean createResponseBean() {
		DrugProductDetailQueryResponseMessageBean model = new DrugProductDetailQueryResponseMessageBean(createCriteriaBean());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DRUG_PRODUCT_DETAIL_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
		model.getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<DrugProductDetailRecord>(
				createDrugProductDetailRecord()));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<DrugProductDetailRecord>(
				createDrugProductDetailRecord()));
		
		return model;
	}

	private DrugProductDetailRecord createDrugProductDetailRecord() {
		MedicineBean medicine = new MedicineBeanBuilder().populate().create();
		DrugProductDetailRecord record = new DrugProductDetailRecord();
		record.setMedicine(medicine);
		return record;
	}

}
