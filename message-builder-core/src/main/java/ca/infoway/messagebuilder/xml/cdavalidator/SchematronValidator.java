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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.xml.cdavalidator;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.oclc.purl.dsdl.svrl.FailedAssert;
import org.oclc.purl.dsdl.svrl.SchematronOutputType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.SchematronContext;
import ca.infoway.messagebuilder.xml.SchematronRule;

import com.helger.schematron.SchematronException;
import com.helger.schematron.pure.binding.IPSQueryBinding;
import com.helger.schematron.pure.binding.PSQueryBindingRegistry;
import com.helger.schematron.pure.bound.IPSBoundSchema;
import com.helger.schematron.pure.model.PSAssertReport;
import com.helger.schematron.pure.model.PSNS;
import com.helger.schematron.pure.model.PSPattern;
import com.helger.schematron.pure.model.PSRule;
import com.helger.schematron.pure.model.PSSchema;
import com.helger.schematron.pure.preprocess.PSPreprocessor;

public class SchematronValidator {
	
	private boolean initiated = false;
	private IPSBoundSchema boundSchema;

	public SchematronValidator(List<SchematronContext> contexts) {
		initiate(contexts);
	}

	@SuppressWarnings("deprecation")
	private void initiate(List<SchematronContext> contexts) {
		if (!contexts.isEmpty()) {
			PSSchema schema = new PSSchema();
			PSNS namespace = new PSNS();
			namespace.setPrefix("cda");
			namespace.setUri("urn:hl7-org:v3");
			schema.addNS(namespace);
			
			for (SchematronContext context : contexts) {
				PSPattern pattern = new PSPattern();
				schema.addPattern(pattern);
				
				PSRule rule = new PSRule();
				rule.setContext(context.getContext());
	
				boolean hasTests = false;
				for (SchematronRule schematronRule : context.getRules()) {
					if (schematronRule.getTest().getTest().contains("document(")) {
						// The document() function is not supported in this library
						continue;
					}
					PSAssertReport assertReport = new PSAssertReport(true);
					assertReport.setTest(StringEscapeUtils.unescapeXml(schematronRule.getTest().getTest()));
					if (schematronRule.getDescription() != null) {
						assertReport.addText(schematronRule.getDescription().getDescription());
					}
					rule.addAssertReport(assertReport);
					hasTests = true;
				}
				
				if (hasTests) {
					pattern.addRule(rule);
				}
			}
			
			// Useful for testing purposes, but should be commented out in production
	//		MicroWriter.writeToStream(schema.getAsMicroElement(), System.out);
	
			if (!schema.isValid()) {
				throw new IllegalArgumentException("Invalid Schema");
			}
			
			try {
				IPSQueryBinding binding = PSQueryBindingRegistry.getQueryBindingOfNameOrThrow(schema.getQueryBinding());
				PSPreprocessor preprocessor = new PSPreprocessor(binding);
				PSSchema preprocessedSchema = preprocessor.getAsPreprocessedSchema(schema);
				boundSchema = binding.bind(preprocessedSchema, null, null);
			} catch (SchematronException e) {
				LogFactory.getLog(getClass()).error("Unable to initialize schematron library", e);
			}
			
			this.initiated = true;
		}		
	}

	public void validate(String xml, Hl7Errors validationResults) {
		if (this.initiated) {
			try {
				Document document = new DocumentFactory().createFromString(xml);
				validate(document, validationResults);
			} catch (SAXException e) {
				validationResults.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, e.getMessage(), (String) null));
			}
		}
	}
	
	public void validate(Document document, Hl7Errors validationResults) {
		if (this.initiated) {
			try {
				SchematronOutputType schematronOutput = boundSchema.validateComplete(document);
				
				for (Object o : schematronOutput.getActivePatternAndFiredRuleAndFailedAssert()) {
					if (o instanceof FailedAssert) {
						FailedAssert failedAssert = (FailedAssert) o;
						
						String description = failedAssert.getText();
						if (StringUtils.isBlank(description)) {
							description = failedAssert.getTest();
						}
						
						validationResults.addHl7Error(new Hl7Error(Hl7ErrorCode.SCHEMATRON, description, failedAssert.getLocation()));
					}
				}
			} catch (Exception e) {
				validationResults.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, e.getMessage(), (String) null));
			}
		}
	}
}
