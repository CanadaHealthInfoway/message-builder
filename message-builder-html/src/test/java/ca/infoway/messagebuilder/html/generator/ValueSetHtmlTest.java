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

import static ca.infoway.messagebuilder.xml.DomainSource.VALUE_SET;

import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.Vocabulary;
import junit.framework.Assert;

public class ValueSetHtmlTest {
	private MessageSet testMessageSet;
	
	@Before
	public void setUp() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() {
		String valueSetName = "RoutedDocumentType";
		ValueSet valueSet = getValueSet(testMessageSet.getVocabulary(), valueSetName);
		ValueSetHtml html = new ValueSetHtml(valueSet, testMessageSet);
		
		String result = html.write();

		String headElement =
				"<head>" +
					"<title>Value Set: " + valueSetName + " for: R02_04_03</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String summaryDiv =
				"<div class=\"summaryDiv\" id=\"summaryDiv-" + valueSetName +"\">" +
					"<table>" +
						"<thead></thead>" +
						"<tbody>" +
//							"<tr>" +
//								"<td class=\"detailsTableLabelCol\">Value Set Name:</td>" +
//								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + valueSetName + "</td>" +
//							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Value Set OID:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + valueSet.getId() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Value Set Date:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">2008-12-17</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Description:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<p>A coded value denoting a specific document type that a provider expresses " +
									"to have routed to them from the Service Delivery Location to which they are associated.</p>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Rationale:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<p>Allows providers to request that specific document(s) be routed from an SDL to them.</p>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Owning SCWG:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" + valueSet.getOwningSCWG() + "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Coding Strength:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">CNE</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Used In Model Class Attributes:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\"><ul>None</ul></td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Bound Concept Domains:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul><li><a href=\"../conceptDomains/RoutedDocumentType.html\">RoutedDocumentType</a></li></ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Draws From Code Systems:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul><li><a href=\"../codeSystems/SCTEMP.html\">SCTEMP</a></li></ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Filter:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
									"<ul>" +
										"<li>From Code System: SCTEMP (2.16.840.1.113883.2.20.5.2)" +
											"<ul><li>Include code of ??</li></ul>" +
										"</li>" +
									"</ul>" +
								"</td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Codes listed below are:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\">Incomplete</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
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
							"<div id=\"metaDiv\" partname=\""+ valueSetName +"\" packagename=\"" + VALUE_SET.name() + "_" + valueSetName + "\"></div>" +
							"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2></div>" +
							"<div id=\"page\">" +
								"<div id=\"leftSideColumn\">" +
									"<div id=\"navControlDiv\">" +
										"<a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a>" +
									"</div>" +
									"<div id=\"leftNavBar\"></div>" +
								"</div>" +
								"<div id=\"mainColumn\">" +
									"<h2 id=\"titleHeader-" + valueSetName + "\" class=\"titleHeader\">Value Set: " + valueSetName + "</h2>" +
									summaryDiv + 
								"</div>" +
							"</div>" +
						"</div>" +
						"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
					"</div>" +
				"</body>" +
				"</html>";
		
		Assert.assertNotNull(valueSet);
		Assert.assertNotNull(result);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldContainExampleCodes() {
		String valueSetName = "RestrictionToPracticeType";
		ValueSet valueSet = getValueSet(testMessageSet.getVocabulary(), valueSetName);
		ValueSetHtml html = new ValueSetHtml(valueSet, testMessageSet);
	
		String result = html.write();
		
		CharSequence exampleCodesSummarySection = 
				"<div class=\"valueSetExpansionSummaryDiv\" id=\"valueSetExpansionSummaryDiv-RestrictionToPracticeType\">" +
					"<hr>" +
					"<h2 id=\"valueSetExpansionHeader\" class=\"titleHeader\">Example Codes Summary</h2>" +
					"<table>" +
						"<thead></thead>" +
						"<tbody>" +
							"<tr class=\"codeTitleRow\">" +
								"<td class=\"detailsTableLabelCol\">Code</td>" +
								"<td class=\"detailsTableLabelCol\">Display Name</td>" +
								"<td class=\"detailsTableLabelCol\">Code System OID</td>" +
								"<td class=\"detailsTableLabelCol\">Code System Name</td>" +
							"</tr>" +
								"<tr class=\"codeDataRow\">" +
								"<td class=\"indent0\"><a href=\"#codeDiv-?\">?</a></td>" +
								"<td class=\"\">-</td>" +
								"<td class=\"\">2.16.840.1.113883.2.20.5.2</td>" +
								"<td class=\"\">SCTEMP</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		CharSequence exampleCodesDetailsSection = 
				"<div class=\"valueSetExpansionDetailsDiv\">" +
					"<hr>" +
					"<h2 id=\"valueSetExpansionDetailsHeader\" class=\"titleHeader\">Example Codes Details</h2>" +
					"<div class=\"codeDiv\" id=\"codeDiv-?\">" +
						"<h2 class=\"titleHeader\">?</h2>" +
						"<table>" +
							"<thead></thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">?</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Name:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">-</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">2.16.840.1.113883.2.20.5.2</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Example CV:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">&lt;code code=\"?\" codeSystem=\"2.16.840.1.113883.2.20.5.2\" /&gt;</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
				"</div>";
		
		Assert.assertFalse(valueSet.isComplete());
		Assert.assertTrue(result.contains(exampleCodesSummarySection));
		Assert.assertTrue(result.contains(exampleCodesDetailsSection));
		
	}
	
	@Test
	public void testShouldContainValueSetExpansionSummary() {
		String valueSetName = "Calendar";
		ValueSet valueSet = getValueSet(testMessageSet.getVocabulary(), valueSetName);
		ValueSetHtml html = new ValueSetHtml(valueSet, testMessageSet);

		String result = html.write();
		
		CharSequence valueSetExpansionSummarySection = 
				"<div class=\"valueSetExpansionSummaryDiv\" id=\"valueSetExpansionSummaryDiv-Calendar\">" +
					"<hr>" +
					"<h2 id=\"valueSetExpansionHeader\" class=\"titleHeader\">Value Set Expansion Summary</h2>" +
					"<table>" +
						"<thead></thead>" +
						"<tbody>" +
							"<tr class=\"codeTitleRow\">" +
								"<td class=\"detailsTableLabelCol\">Code</td>" +
								"<td class=\"detailsTableLabelCol\">Display Name</td>" +
								"<td class=\"detailsTableLabelCol\">Code System OID</td>" +
								"<td class=\"detailsTableLabelCol\">Code System Name</td>" +
							"</tr>" +
							"<tr class=\"codeDataRow\">" +
								"<td class=\"indent0\"><a href=\"#codeDiv-GREG\">GREG</a></td>" +
								"<td class=\"\">Gregorian</td>" +
								"<td class=\"\">2.16.840.1.113883.5.1055</td>" +
								"<td class=\"\">Calendar</td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		CharSequence valueSetExpansionDetailsSection = 
				"<div class=\"valueSetExpansionDetailsDiv\">" +
					"<hr>" +
					"<h2 id=\"valueSetExpansionDetailsHeader\" class=\"titleHeader\">Value Set Expansion Details</h2>" +
					"<div class=\"codeDiv\" id=\"codeDiv-GREG\">" +
						"<h2 class=\"titleHeader\">GREG</h2>" +
						"<table>" +
							"<thead></thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">GREG</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Name:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">Gregorian</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Description:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">" +
										"<p>The Gregorian calendar is the calendar in effect in most countries of Christian " +
										"influence since approximately 1582. This calendar superceded the Julian calendar.</p>" +
									"</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Code System OID:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">2.16.840.1.113883.5.1055</td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Example CV:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\">&lt;code code=\"GREG\" codeSystem=\"2.16.840.1.113883.5.1055\" /&gt;</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
				"</div>";
		
		Assert.assertTrue(valueSet.isComplete());
		Assert.assertTrue(result.contains(valueSetExpansionSummarySection));
		Assert.assertTrue(result.contains(valueSetExpansionDetailsSection));

	}
	
	@Test
	public void testShouldNotContainNullDescription() {
		// GN: Can remove this test when problem in marshaller is fixed (currently has problems with annotations that do not have paragraph tags, gets run in as empty CData values)
		String valueSetName = "ControlActNullificationRefusalReasonCode";
		ValueSet valueSet = getValueSet(testMessageSet.getVocabulary(), valueSetName);
		ValueSetHtml html = new ValueSetHtml(valueSet, testMessageSet);

		String result = html.write();
		
		Assert.assertTrue(valueSet.isComplete());
		//System.out.println(result);
		Assert.assertTrue(!result.contains("<td class=\"detailsTableLabelCol\">Description:</td><td class=\"detailsTableValueCol\" colspan=\"3\">null</td>"));

	}
	
	private ValueSet getValueSet(Vocabulary vocabulary, String name) {
		List<ValueSet> valueSets = vocabulary.getValueSets();
		for (ValueSet valueSet : valueSets) {
			if (name.equals(valueSet.getName())) {
				return valueSet;
			}
		}
		return null;
	}
}
