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

package ca.infoway.messagebuilder.simple.xml;

import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.xml.sax.SAXException;

@RunWith(Theories.class)
public class DataTypesSchemaValidationTest {

	@DataPoint public final static String SAMPLE_XML = "sample.xml";
	@DataPoint public final static String SAMPLE_NULL_XML = "sampleNull.xml";
	@DataPoint public final static String SAMPLE_FULL_XML = "sampleFull.xml";
	@DataPoint public final static String SAMPLE_ADDRESS_XML = "sampleAddress.xml";
	@DataPoint public final static String SAMPLE_ADDRESS_2_XML = "sampleAddress2.xml";
	@DataPoint public final static String SAMPLE_ADDRESS_3_XML = "sampleAddress3.xml";
	@DataPoint public final static String SAMPLE_ADDRESS_4_XML = "sampleAddress4.xml";
	@DataPoint public final static String SAMPLE_URI_XML = "sampleTelecommunicationAddress.xml";
	@DataPoint public final static String SAMPLE_ENCAPSULATED_DATA_XML = "sampleEncapsulatedDocument.xml";
	@DataPoint public final static String SAMPLE_RATIO_XML = "sampleRatio.xml";
	@DataPoint public final static String SAMPLE_DATES_1_XML = "sampleDates1.xml";
	@DataPoint public final static String SAMPLE_DATES_2_XML = "sampleDates2.xml";
	@DataPoint public final static String SAMPLE_DATES_3_XML = "sampleDates3.xml";
	@DataPoint public final static String SAMPLE_PIVL_XML = "samplePivl.xml";
	@DataPoint public final static String SAMPLE_DATE_BOUNDED_PIVL_XML = "sampleBoundedPivl.xml";
	@DataPoint public final static String SAMPLE_DATE_IVL_XML = "sampleDateInterval.xml";
	@DataPoint public final static String SAMPLE_DATE_URG_XML = "sampleDateUncertainRange.xml";
	@DataPoint public final static String SAMPLE_CODED_TYPES_XML = "sampleCodedTypes.xml";
	@DataPoint public final static String SAMPLE_NAMES_XML = "sampleNames.xml";
	
	@Theory
	public void shouldParseSampleDocumentWithSimpleDatatypes(String name) throws Exception {
		Validator validator = getSchemaValidator();
		InputStream input = getClass().getResourceAsStream(name);
		try {
			validator.validate(new StreamSource(input));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	private Validator getSchemaValidator() throws Exception, SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(getClass().getResource("/testSchema.xsd"));
		return schema.newValidator();
	}
	
}
