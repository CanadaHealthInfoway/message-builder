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

import static ca.infoway.messagebuilder.xml.DomainSource.CODE_SYSTEM;

import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.Vocabulary;

public class CodeSystemHtmlTest {
	private MessageSet testMessageSet;
	
	@Before
	public void setUp() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() {
		String codeSystemName = "AcknowledgementCondition";
		CodeSystem codeSystem = getCodeSystem(testMessageSet.getVocabulary(), codeSystemName);
		CodeSystemHtml html = new CodeSystemHtml(codeSystem, testMessageSet);
		
		String result = html.write();

		String headElement =
				"<head>" +
					"<title>Code System: " + codeSystemName + " for: R02_04_03</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String summaryDiv = 
				"<div class=\"summaryDiv\" id=\"summaryDiv-" + codeSystemName + "\">" +
					"<table>" +
						"<thead></thead>" +
						"<tbody>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Code System Technical Name:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + codeSystemName + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Code System Business Name:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + codeSystem.getBusinessName() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + codeSystem.getOid() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Code System Release Date</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">2011-03-15</td>" +
							"</tr>" + 
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Description:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<p>The codes identify the conditions under which accept acknowledgements are " +
									"required to be returned in response to this message. Note that accept " +
									"acknowledgement address two different issues at the same time: reliable transport " +
									"as well as syntactical correctness</p>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Maintenance Organization:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + codeSystem.getMaintenanceOrganization().getName() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Codes listed below are:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">Complete</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">In use by value sets:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul><li><a href=\"../valueSets/AcknowledgementCondition.html\">AcknowledgementCondition</a></li></ul>" +
								"</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		String codeSummaryDiv =
				"<div class=\"codeSummaryDiv\" id=\"codeSummaryDiv-AcknowledgementCondition\">" +
					"<hr><h2 id=\"codeSummaryHeader\" class=\"titleHeader\">Code Summary</h2>" + 
					"<table>" +
						"<thead></thead>" +							
						"<tbody>" +
							"<tr class=\"codeTitleRow\">" +
								"<td class=\"detailsTableLabelCol\">Code</td>" +
								"<td class=\"detailsTableLabelCol\">Display Name</td>" +
								"<td class=\"detailsTableLabelCol\">Code System OID</td>" +
							"</tr>" +
							"<tr class=\"codeDataRow\">" +
								"<td class=\"\"><a href=\"#codeDiv-AL\">AL</a></td>" +
								"<td class=\"\">Always</td>" +
								"<td class=\"\">2.16.840.1.113883.5.1050</td>" +
							"</tr>" +
							"<tr class=\"codeDataRow\">" +
								"<td class=\"\"><a href=\"#codeDiv-ER\">ER</a></td>" +
								"<td class=\"\">Error/reject only</td>" +
								"<td class=\"\">2.16.840.1.113883.5.1050</td>" +
							"</tr>" +
							"<tr class=\"codeDataRow\">" +
								"<td class=\"\"><a href=\"#codeDiv-NE\">NE</a></td>" +							
								"<td class=\"\">Never</td>" +
								"<td class=\"\">2.16.840.1.113883.5.1050</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		String codeSummaryDetailsDiv =
				"<div class=\"codeSummaryDetailsDiv\">" +
					"<hr><h2 id=\"codeSummaryDetailsHeader\" class=\"titleHeader\">Code Summary Details</h2>" +
					"<div class=\"codeDiv\" id=\"codeDiv-AL\">" +
						"<h2 class=\"titleHeader\">AL</h2>" +
						"<table>" +
							"<thead></thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">AL</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Name:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Always</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Description:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\"><p>Always send an acknowledgement.</p></td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Selectable</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Y</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">2.16.840.1.113883.5.1050</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Example CS:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">&lt;code code=\"AL\" /&gt;</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
					"<div class=\"codeDiv\" id=\"codeDiv-ER\">" +
						"<h2 class=\"titleHeader\">ER</h2>" +
						"<table>" +
							"<thead></thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">ER</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Name:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Error/reject only</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Description:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
										"<p>Send an acknowledgement for error/reject conditions only.</p>" +
									"</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Selectable</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Y</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">2.16.840.1.113883.5.1050</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Example CS:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">&lt;code code=\"ER\" /&gt;</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
					"<div class=\"codeDiv\" id=\"codeDiv-NE\">" +
						"<h2 class=\"titleHeader\">NE</h2>" +
						"<table>" +
							"<thead></thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">NE</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Name:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Never</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Description:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\"><p>Never send an acknowledgement.</p></td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Selectable</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Y</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">2.16.840.1.113883.5.1050</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Example CS:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">&lt;code code=\"NE\" /&gt;</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
				"</div>";
		
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
							"<div id=\"metaDiv\" partname=\"" + codeSystemName + "\" packagename=\"" + CODE_SYSTEM.name() + "_" + codeSystemName + "\"></div>" +
							"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2></div>" +
							"<div id=\"page\">" +
								"<div id=\"leftSideColumn\">" +
									"<div id=\"navControlDiv\">" +
										"<a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a>" +
									"</div>" +
									"<div id=\"leftNavBar\"></div>" +
								"</div>" +
								"<div id=\"mainColumn\">" +
									"<h2 id=\"titleHeader-" + codeSystemName + "\" class=\"titleHeader\">Code System: " + codeSystemName + "</h2>" +
									summaryDiv + 
									codeSummaryDiv + 
									codeSummaryDetailsDiv +
								"</div>" +
							"</div>" +
						"</div>" +
						"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
					"</div>" +
				"</body>" +
				"</html>";
		
		Assert.assertNotNull(codeSystem);
		Assert.assertNotNull(result);
		Assert.assertEquals(expected, result);
	}

	private CodeSystem getCodeSystem(Vocabulary vocabulary, String name) {
		List<CodeSystem> codeSystems = vocabulary.getCodeSystems();
		for (CodeSystem codeSystem : codeSystems) {
			if (name.equals(codeSystem.getName())) {
				return codeSystem;
			}
		}
		return null;
	}
}
