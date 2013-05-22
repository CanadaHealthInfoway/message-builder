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

import static ca.infoway.messagebuilder.xml.DomainSource.CONCEPT_DOMAIN;

import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.Vocabulary;

@RunWith(MockitoJUnitRunner.class)
public class ConceptDomainHtmlTest {
	private MessageSet testMessageSet;
	@Mock private Svgifier mockSvgifier; 
	
	@Before
	public void setUp() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() {
		String conceptDomainName = "IssueTriggerObservationValue";
		ConceptDomain conceptDomain = getConceptDomain(testMessageSet.getVocabulary(), conceptDomainName);
		ConceptDomainHtml html = new ConceptDomainHtml(conceptDomain, testMessageSet);
		html.setSvgifier(mockSvgifier);
		
		String result = html.write();

		String headElement =
				"<head>" +
					"<title>Concept Domain: " + conceptDomainName + " for: R02_04_03</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String summaryDiv = 
				"<div class=\"summaryDiv\" id=\"summaryDiv-" + conceptDomainName + "\">" +
					"<table>" +
						"<thead></thead>" +
						"<tbody>" +
//							"<tr>" +
//								"<td class=\"detailsTableLabelCol\">Concept Domain Name:</td>" +
//								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + conceptDomainName + "</td>" +
//							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Definition:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<p>The combined domain for different types of coded observation issue triggers, such as diagnoses, allergies, etc.</p>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Rationale:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<p>Ensures that consistent codes are used in identifying detected issue triggers.  This allows " +
									"issues to be compared, even from different knowledge-bases.</p>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Owning SCWG:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + conceptDomain.getOwningSCWG() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Risk of Change:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">N/A</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Used In Model Class Attributes:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul>" +
										"<li><a href=\"../packages/COCT_MT260010CA.html#COCT_MT260010CA.ObservationCodedEvent_value\">" +
											"COCT_MT260010CA.ObservationCodedEvent.value</a></li>" +
										"<li><a href=\"../packages/COCT_MT260020CA.html#COCT_MT260020CA.ObservationCodedEvent_value\">" +
											"COCT_MT260020CA.ObservationCodedEvent.value</a></li>" +
										"<li><a href=\"../packages/COCT_MT260030CA.html#COCT_MT260030CA.ObservationCodedEvent_value\">" +
											"COCT_MT260030CA.ObservationCodedEvent.value</a></li>" +
									"</ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Bound Value Sets:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul><li><a href=\"../valueSets/IssueTriggerObservationValue.html\">IssueTriggerObservationValue</a></li></ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Child Concept Domains:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul>" +
										"<li><a href=\"../conceptDomains/DiagnosisValue.html\">DiagnosisValue</a></li>" +
										"<li><a href=\"../conceptDomains/IntoleranceValue.html\">IntoleranceValue</a></li>" +
									"</ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Parent Concept Domains:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">None</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		String diagramDiv = 
				"<div id=\"diagramDiv\" class=\"diagramDiv\"><hr><h2 id=\"diagramHeader-IssueTriggerObservationValue\" class=\"titleHeader\">Diagram:</h2></div>";
		
		String expected = 				
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
				headElement + 
				"<body>" +
					"<div id=\"wrapper\">" +
						"<div id=\"headerDiv\" class=\"headerDiv\">" +
							"<div id=\"iconDiv\" class=\"iconDiv\"></div>" +
						"</div>" +
						"<div id=\"container\" class=\"content\">" +
							"<div id=\"metaDiv\" partname=\""+ conceptDomainName + "\" packagename=\""+ CONCEPT_DOMAIN.name() + "_" + conceptDomainName + "\"></div>" +
							"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2></div>" +
							"<div id=\"page\">" +
								"<div id=\"leftSideColumn\">" +
									"<div id=\"navControlDiv\">" +
										"<a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a>" +
									"</div>" +
									"<div id=\"leftNavBar\"></div>" +
								"</div>" +
								"<div id=\"mainColumn\">" +
									"<h2 id=\"titleHeader-" + conceptDomainName + "\" class=\"titleHeader\">Concept Domain: " + conceptDomainName + "</h2>" +
									summaryDiv + 
									diagramDiv + 
								"</div>" +
							"</div>" +
						"</div>" +
						"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
					"</div>" +
				"</body>" +
				"</html>";
		
		Assert.assertNotNull(conceptDomain);
		Assert.assertNotNull(result);
		Assert.assertEquals(expected, result);
	}

	private ConceptDomain getConceptDomain(Vocabulary vocabulary, String name) {
		List<ConceptDomain> conceptDomains = vocabulary.getConceptDomains();
		for (ConceptDomain conceptDomain : conceptDomains) {
			if (name.equals(conceptDomain.getName())) {
				return conceptDomain;
			}
		}
		return null;
	}
}
