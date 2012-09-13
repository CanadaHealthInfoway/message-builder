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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServicesQueryCriteria;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServicesQueryMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ProfessionalServicesQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientPharmacyProfServicesQuery.xml";
	
	@Test
	public void shouldProduceSomeQuery() throws Exception {
		String xml = toHl7UsingNewRenderer(createQueryBean(), BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK);
		assertNotNull("query", xml);
		assertValidHl7Message(xml);
	}

	@Test
	public void shouldMatchKnownQuery() throws Exception {
		ProfessionalServicesQueryMessageBean model = createQueryBean();
		String xml = toHl7UsingNewRenderer(model, BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE)), 
				actual);
	}

	private ProfessionalServicesQueryMessageBean createQueryBean() {
		PersonName patientName = PersonName.createFirstNameLastName("John", "Doe");
		
		ProfessionalServicesQueryCriteria criteria = new ProfessionalServicesQueryCriteria();
		criteria.setIncludeNotesIndicator(true);
		criteria.setPatientBirthDate(DateUtil.getDate(2009, 0, 1));
		criteria.setPatientGender(AdministrativeGender.FEMALE);
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "1"));
		criteria.setName(patientName);
		criteria.getTypes().add(CodeResolverRegistry.lookup(ActProfessionalServiceCode.class, "SMC", "2.16.840.1.113883.6.95"));
		criteria.setServicePeriod(IntervalFactory.createLowHigh(DateUtil.getDate(2008, 0, 1), DateUtil.getDate(2009, 0, 1)));
		
		ProfessionalServicesQueryMessageBean model = new ProfessionalServicesQueryMessageBean(criteria);
		model.getControlActEventBean().setCode(HL7TriggerEventCode.PATIENT_PHARMACY_PROF_SERVICES_QUERY);
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEventBean());
		model.setQueryId(new Identifier("1.2.3.4.5", "1"));
		
		return model;
	}

	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		MessageBean messageObject = (MessageBean) this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message).getMessageObject();
		assertTrue("type", messageObject instanceof ProfessionalServicesQueryMessageBean);
		
		ProfessionalServicesQueryMessageBean bean = (ProfessionalServicesQueryMessageBean) messageObject;
		assertTrue("includeNotesIndicator", bean.getCriteria().isIncludeNotesIndicator());
	}

	@Test
	public void shouldTransformBackAndForthWioutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		MessageBean messageObject = (MessageBean) this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message).getMessageObject();
		
		String xml = toHl7UsingNewRenderer(messageObject, BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK);
		
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE)), 
				this.factory.createFromString(xml));
	}
}
