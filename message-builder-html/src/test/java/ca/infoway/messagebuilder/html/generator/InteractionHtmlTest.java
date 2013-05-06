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

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;

@RunWith(MockitoJUnitRunner.class)
public class InteractionHtmlTest {
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() throws Exception {
		String interactionName = "ABCD_IN123456CA";
		
		Interaction testInteraction = new Interaction();
		testInteraction.setName(interactionName);
		testInteraction.setSuperTypeName("ABCD_MT123456CA.Message");
		
		MessageSet testSet = new MessageSet();
		testSet.getInteractions().put(interactionName, testInteraction);
		
		InteractionHtml html = new InteractionHtml(testInteraction, testSet);
		
		String result = html.write();
		
		String expectedHeadElements
			= 	"<head>" +
					"<title>Interaction: " + interactionName + " for: " + testSet.getVersion() + "</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String expectedTOCDiv 
			=	"<div class=\"interactionTocDiv\" id=\"interactionTocDiv\">" + 
					"<h4 class=\"tocTitle\">Contents:</h4>" + 
					"<ol class=\"mainToc\">" + 
						"<li><a href=\"#detailsDiv\">Interaction Details</a></li>" + 
					"</ol>" + 
				"</div>";
		
		String expectedSidePanel 
			= 	"<div id=\"leftSideColumn\">" +
					"<div id=\"navControlDiv\"><a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div>" +
					"<div id=\"leftNavBar\"></div>" +
				"</div>";
		
		String expectedPackagePayload 
			=	"<div id=\"detailsDiv\" class=\"detailsDiv\">" + 
						"<hr>" + 
						"<h3>Interaction Details:</h3>" + 
						"<table class=\"interactionDetailsTable\">"+
							"<thead>" + 
								"<tr>" + 
									"<th>ABCD_IN123456CA</th>" + 
								"</tr>" + 
							"</thead>" + 
							"<tbody>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Name:</td>" + 
									"<td class=\"detailsTableValueCol\" colspan=\"3\">null</td>" + 
								"</tr>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Transmission Wrapper:</td>" + 
									"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
										"<a href=\"../packages/ABCD_MT123456CA.html#ABCD_MT123456CA-MessageDetailsDiv\" id=\"ABCD_MT123456CA.Message\" class=\"detailsRow\">ABCD_MT123456CA.Message</a>" +
									"</td>" + 
								"</tr>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Control Act Wrapper:</td>" + 
									"<td class=\"detailsTableValueCol\" colspan=\"3\">NONE</td>" + 
								"</tr>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Payload:</td>" + 
									"<td class=\"detailsTableValueCol\" colspan=\"3\">NONE</td>" + 
								"</tr>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Trigger Event:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\"></td>" + 
								"</tr>" + 
								"<tr>" + 
									"<td class=\"detailsTableLabelCol\">Responses:</td>" + 
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Not Applicable</td>" + 
								"</tr>" + 
							"</tbody>" + 
						"</table>" + 
					"</div>";
		
		String expectedHtml 
			= 	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">" +
					"<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
					expectedHeadElements +
					"<body>" +
						"<div id=\"wrapper\">" +
							"<div id=\"headerDiv\" class=\"headerDiv\">" +
								"<div id=\"iconDiv\" class=\"iconDiv\"></div>" +
							"</div>" +
							"<div id=\"container\" class=\"content\">" +
								"<div id=\"metaDiv\" partname=\"ABCD_IN123456CA\" packagename=\"ABCD_IN123456CA\"></div>" +
								"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: null</h2></div>" +
								"<div id=\"page\">" +
									expectedSidePanel + 
									"<div id=\"mainColumn\">" +
									"<h2 id=\"interactionTitleHeader-ABCD_IN123456CA\" class=\"interactionTitleHeader\">ABCD_IN123456CA : </h2>" +
									expectedTOCDiv + 
									expectedPackagePayload + 
									"</div>" +
								"</div>" +
							"</div>" +
							"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
						"</div>" +
					"</body>" +
					"</html>";
		
		Assert.assertTrue(result.contains(expectedHeadElements));
		Assert.assertTrue(result.contains(expectedTOCDiv));
		Assert.assertTrue(result.contains(expectedSidePanel));
		Assert.assertTrue(result.contains(expectedPackagePayload));
		Assert.assertEquals(expectedHtml, result);
	}
}
