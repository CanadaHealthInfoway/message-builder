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

package ca.infoway.messagebuilder.simple.temp;

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
public class SchemaValidationTest {

	@DataPoint public final static String[] SAMPLE_XML = { "CareCompositionsBean.xml", "CareEventIdentified.xsd" };
	@DataPoint public final static String[] SAMPLE_XML_FINDCANDIDATESQUERY = { "simplifiedFindCandidatesMessage.xml", "PRPA_IN101103CA.xsd"};
	
	@Theory
	public void shouldParseSampleDocumentWithMessageSchemas(String[] parameters) throws Exception {
		Validator validator = getSchemaValidator(parameters[1]);
		InputStream input = getClass().getResourceAsStream(parameters[0]);
		try {
			validator.validate(new StreamSource(input));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	private Validator getSchemaValidator(String schemaString) throws Exception, SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(getClass().getResource(schemaString));
		return schema.newValidator();
	}
	
}
