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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.html.generator;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.Vocabulary;

@RunWith(MockitoJUnitRunner.class)
public class FilterElementHtmlTest {
	private MessageSet testMessageSet;
	
	@Before
	public void setUp() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}

	
	@Test
	public void testWriteDefaultFilterElement() {
		ValueSet valueSet = getValueSetByName("MediaType", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>Include all codes from code system: mediaType (2.16.840.1.113883.5.79)</li></ul>";
		
		assertEquals(expected, html.write());
	}

	@Test
	public void testWriteFilterElementWithOrConjunctionParameters() {
		ValueSet valueSet = getValueSetByName("ObservationResultableLabType", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>From Code System: LN (2.16.840.1.113883.6.1)<ul><li>Under condition that code has:<ul><li>property: B/R/O with value: B OR property: B/R/O with value: R</li></ul></li></ul></li><li>From Code System: pclocd (2.16.840.1.113883.2.20.5.1)<ul><li>Under condition that code has:<ul><li>property: B/R/O with value: B OR property: B/R/O with value: R</li></ul></li></ul></li></ul>";
		
		assertEquals(expected, html.write());
	}

	@Test
	public void testWriteFilterElementWithInclude() {
		ValueSet valueSet = getValueSetByName("SectionHeadingObservationValue", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>From Code System: snomed-CT (2.16.840.1.113883.6.96)<ul><li>Include code and specializations of 404684003</li></ul></li></ul>";
		
		assertEquals(expected, html.write());
	}
	
	@Test
	public void testWriteFilterElementWithIncludeFromMultipleCodesystems() {
		ValueSet valueSet = getValueSetByName("ServiceDeliveryLocationPlaceType", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>From Code System: EntityCode (2.16.840.1.113883.5.1060)<ul><li>Include code and specializations of _PlaceEntityType</li></ul></li><li>From Code System: SCTEMP (2.16.840.1.113883.2.20.5.2)<ul><li>Include code of CAMP</li><li>Include code of MOBILE</li></ul></li></ul>";
		
		assertEquals(expected, html.write());
	}

	@Test
	public void testWriteFilterElementWithIncludeExclude() {
		ValueSet valueSet = getValueSetByName("ActProfessionalServiceCodeSecondary", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>From Code System: CCI (2.16.840.1.113883.6.95)<ul><li>Include code and specializations of 3.^^.^^.^^</li><li>Except:<ul><li>code and specializations of 4.^^.^^.^^</li></ul></li></ul></li></ul>";
		
		assertEquals(expected, html.write());
	}
	
	@Test
	public void testWriteFilterElementWithIncludeExcludeAndParameters() {
		ValueSet valueSet = getValueSetByName("SymptomValuePrimary", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>From Code System: snomed-CT (2.16.840.1.113883.6.96)<ul><li>Include code and specializations of 118956008</li><li>Include code and specializations of 272379006</li><li>Include code and specializations of 413350009</li><li>Include code and specializations of 57177007</li><li>Include code and specializations of 4908009</li><li>Include code and specializations of 404684003</li><li>Except:<ul><li>code and specializations of 307824009</li><li>code and specializations of 405533003</li><li>code and specializations of 217020008</li><li>code and specializations of 420134006</li><li>code and specializations of 365858006</li><li>code and specializations of 285153007</li></ul></li><li>Under condition that code has:<ul><li>property: Human</li><li class=\"no-bullet\">AND</li><li>property: Status with value: Current</li></ul></li></ul></li></ul>";
		
		assertEquals(expected, html.write());
	}
	
	@Test
	public void testWriteFilterElementWithOtherValueSets() {
		ValueSet valueSet = getValueSetByName("ControlActReason", testMessageSet.getVocabulary());
		
		FilterElementHtml html = new FilterElementHtml(valueSet, testMessageSet);
		
		String expected = "<ul><li>Includes all codes from value set: ActSupplyFulfillmentRefusalReason(2.16.840.1.113883.1.11.19718)</li><li>Includes all codes from value set: CombinedPharmacyOrderSuspendReasonCode(2.16.840.1.113883.1.11.19779)</li><li>Includes all codes from value set: ControlActNullificationReasonCode(2.16.840.1.113883.1.11.19826)</li><li>Includes all codes from value set: GenericUpdateReasonCode(2.16.840.1.113883.1.11.19777)</li><li>Includes all codes from value set: MedicationOrderAbortReasonCode(2.16.840.1.113883.2.20.3.65)</li><li>Includes all codes from value set: MedicationOrderReleaseReasonCode(2.16.840.1.113883.1.11.19782)</li><li>Includes all codes from value set: PatientProfileQueryReasonCode(2.16.840.1.113883.1.11.19784)</li><li>Includes all codes from value set: PharmacySupplyEventAbortReason(2.16.840.1.113883.1.11.20342)</li><li>Includes all codes from value set: PharmacySupplyEventStockReasonCode(2.16.840.1.113883.1.11.19785)</li><li>Includes all codes from value set: PharmacySupplyRequestFulfillerRevisionRefusalReasonCode(2.16.840.1.113883.1.11.20344)</li><li>Includes all codes from value set: PharmacySupplyRequestRenewalRefusalReasonCode(2.16.840.1.113883.1.11.19786)</li><li>Includes all codes from value set: RefusalReasonCode(2.16.840.1.113883.2.20.3.45)</li><li>Includes all codes from value set: StatusRevisionRefusalReasonCode(2.16.840.1.113883.1.11.20363)</li><li>Includes all codes from value set: SubstanceAdministrationPermissionRefusalReasonCode(2.16.840.1.113883.1.11.20343)</li><li>Includes all codes from value set: SupplyOrderAbortReasonCode(2.16.840.1.113883.1.11.19787)</li><li>Includes all codes from value set: UpdateRefusalReasonCode(2.16.840.1.113883.2.20.3.183)</li></ul>";
		
		assertEquals(expected, html.write());
	}
	
	private ValueSet getValueSetByName(String valueSetName, Vocabulary vocabulary) {
		for (ValueSet valueSet : vocabulary.getValueSets()) {
			if(valueSet.getName().equals(valueSetName)) {
				return valueSet;
			}
		}
		return null;
	}
}
