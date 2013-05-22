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

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.Relationship;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Table;

@RunWith(MockitoJUnitRunner.class)
public class MessagePartHtmlTest {
	private MessageSet testMessageSet;
	private DatatypeSet testDatatypeSet;
	
	@Before
	public void setUp() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
		testDatatypeSet = new DatatypeSet();
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() throws Exception {
		MessagePart testPart = new MessagePart();
		testPart.setName("ABCD_MT123456CA.testPart");
		testPart.setDocumentation(new Documentation());
		Annotation testAnnotation = new Annotation("this is a test rationale");
		testAnnotation.setAnnotationTypeAsEnum(AnnotationType.RATIONALE);
		testPart.getDocumentation().getAnnotations().add(testAnnotation);
		testPart.getDocumentation().setBusinessName("this is a part for test");
		MessagePartHtml html = new MessagePartHtml(testPart, testMessageSet, testDatatypeSet, false);
		String result = html.write();
		
		String expectedMetaHtml
			= "<div id=\"metaDiv\" partname=\"ABCD_MT123456CA-testPart\" packagename=\"ABCD_MT123456CA\"></div>";
		
		String expectedMsgPartSummaryHtml 
			= "<div id=\"summaryDiv_ABCD_MT123456CA-testPart\" class=\"summaryDiv\">" +
					"<table class=\"messagePartSummaryTable\" id=\"messagePartSummaryTable-ABCD_MT123456CA-testPart\">" +
						"<tbody>" +
						"<tr>" +
							"<td class=\"detailsTableLabelCol\">Rationale:</td>" +
							"<td class=\"detailsTableValueCol\" colspan=\"3\">this is a test rationale</td>" +
						"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>";
		
		String expectedRelationshipHtml 
			= "";
		
		String expectedHtml 
			= "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">" +
					"<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
					"<head>" +
						"<title>MessagePart: ABCD_MT123456CA-testPart for: R02_04_03</title>" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
						"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
						"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
						"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
						"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
					"</head>" +
					"<body>" +
						"<div id=\"wrapper\">" +
							"<div id=\"headerDiv\" class=\"headerDiv\">" +
								"<div id=\"iconDiv\" class=\"iconDiv\"></div>" +
							"</div>" +
							"<div id=\"container\" class=\"content\">" +
								expectedMetaHtml +
								"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2></div>" +
								"<div id=\"page\">" +
									"<div id=\"leftSideColumn\">" +
										"<div id=\"navControlDiv\"><a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div>" +
										"<div id=\"leftNavBar\"></div>" +
									"</div>" + 
									"<div id=\"mainColumn\">" +
										"<h2 id=\"titleHeader-ABCD_MT123456CA-testPart\" class=\"titleHeader\">this is a part for test</h2>" +
										"<h3 class=\"subTitleHeader\">(ABCD_MT123456CA.testPart)</h3>" +
										expectedMsgPartSummaryHtml + 
										expectedRelationshipHtml +
									"</div>" +
								"</div>" +
							"</div>" +
							"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
						"</div>" +
					"</body>" +
					"</html>";
		
		//System.out.println(result);
		Assert.assertTrue(result.contains(expectedMsgPartSummaryHtml));
		Assert.assertTrue(result.contains(expectedRelationshipHtml));
		Assert.assertEquals(expectedHtml, result);
	}
	
	@Test
	public void testAddRelationshipsSection() throws Exception {
		MessagePart testPart = new MessagePart();
		testPart.setName("ABCD_MT123456CA.testPart");
		Relationship testRelationship = new Relationship();
		testRelationship.setName("testRel1");
		testRelationship.setType("CV");
		Documentation documentation = new Documentation();
		documentation.setBusinessName("someRel");
		testRelationship.setDocumentation(documentation);
		testPart.getRelationships().add(testRelationship);
		
		MessagePartHtml html = new MessagePartHtml(testPart, testMessageSet, testDatatypeSet, false);	
		Div mainContentDiv = new Div();
		html.addRelationshipsSection(mainContentDiv);
		String result = mainContentDiv.write();
		
		String expectedRelationshipHtml 
			= 	"<div>" + 
					"<div class=\"relationshipDiv attributeDiv\" id=\"ABCD_MT123456CA.testPart_testRel1\">" +
						"<h2 class=\"titleHeader\">someRel</h2>" +
						"<h3 class=\"subTitleHeader\">(testRel1)</h3>" +
						"<table class=\"relationshipDetailsTable\">" +
							"<thead>" +
							"</thead>" +
							"<tbody>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Data Type:</td>" +
									"<td class=\"detailsTableValueCol\" colspan=\"3\"><span>CV</span></td>" +
								"</tr>" +
								"<tr>" +
									"<td class=\"detailsTableLabelCol\">Conformance:</td>" +
									"<td class=\"detailsTableValueCol\">Optional</td>" +
									"<td class=\"detailsTableLabelCol\">Cardinality:</td>" +
									"<td class=\"detailsTableValueCol\">0-1</td>" +
								"</tr>" +
							"</tbody>" +
						"</table>" +
					"</div>" +
				"</div>";
		
		Assert.assertEquals(expectedRelationshipHtml, result);
	}
	
	@Test
	public void testTOCShouldContainRelationships() throws Exception {
		MessagePart testPart = new MessagePart();
		testPart.setName("ABCD_MT123456CA.testPart");
		Relationship testRelationship = new Relationship();
		testRelationship.setName("testRel1");
		testRelationship.setType("CV");
		testPart.getRelationships().add(testRelationship);
		
		MessagePartHtml html = new MessagePartHtml(testPart, testMessageSet, testDatatypeSet, false);
		
		Li messagePartTOC = html.createMessagePartTOCList();
		String result = messagePartTOC.write();
		
		String expectedTOCHtml 
			= 	"<li class=\"msgPartToc tocListItem\">" +
					"<a href=\"#ABCD_MT123456CA-testPartDetailsDiv\">ABCD_MT123456CA.testPart</a>" +
					"<ol class=\"tocList\"><li class=\"tocListItem\"><a href=\"#ABCD_MT123456CA.testPart_testRel1\">testRel1: </a> (O)  [0-1]</li></ol>" +
				"</li>";
				
		
		Assert.assertEquals(expectedTOCHtml, result);
	}
	
	@Test
	public void testTOCShouldContainChoices() throws Exception {
		MessagePart testPart = new MessagePart();
		testPart.setName("ABCD_MT123456CA.testPart");
		Relationship testRelationship = new Relationship();
		testRelationship.setName("testRel1");
		testRelationship.setType("ABCD_MT654321CA.abstractType");
		Relationship choiceRelationship = new Relationship();
		choiceRelationship.setName("choiceType");
		choiceRelationship.setType("ABCD_MT654321CA.choice1");
		testRelationship.getChoices().add(choiceRelationship);
		testPart.getRelationships().add(testRelationship);
		
		MessagePartHtml html = new MessagePartHtml(testPart, testMessageSet, testDatatypeSet, false);
		
		Li messagePartTOC = html.createMessagePartTOCList();
		String result = messagePartTOC.write();
		
		String expectedTOCHtml 
			= 	"<li class=\"msgPartToc tocListItem\"><a href=\"#ABCD_MT123456CA-testPartDetailsDiv\">ABCD_MT123456CA.testPart</a>" +
					"<ol class=\"tocList\">" +
						"<li class=\"tocListItem\">" +
							"<a href=\"#ABCD_MT123456CA.testPart_testRel1\">testRel1: </a> (O)  [0-1]" +
							"<ul class=\"tocList\">" +
								"<li class=\"tocListItem\"><a href=\"#choice_testRel1\">Descendants:</a>" +
									"<ol class=\"tocList\">" +
										"<li class=\"tocListItem\">" +
											"<a href=\"#choice_testRel1\">choiceType</a> : " +
											"<a href=\"../packages/ABCD_MT654321CA.html#ABCD_MT654321CA-choice1DetailsDiv\">ABCD_MT654321CA.choice1</a>" +
										"</li>" +
									"</ol>" +
								"</li>" +
							"</ul>" +
						"</li>" +
					"</ol>" +
				"</li>";
		
		Assert.assertEquals(expectedTOCHtml, result);
	}
	
	@Test
	public void testTOCShouldHaveAssociationRelationshipList() throws Exception {
		
		MessagePart messagePart = testMessageSet.getMessagePart("FICR_MT600201CA.PaymentRequest");
				
		MessagePartHtml html = new MessagePartHtml(messagePart, testMessageSet, testDatatypeSet, false);
		
		Li msgPartTOC = html.createMessagePartTOCList();
		
		Assert.assertTrue(msgPartTOC.write().contains("<ul class=\"tocList\"><li class=\"tocListItem\"><a href=\"#FICR_MT600201CA-PaymentRequestAttentionDetailsDiv\">FICR_MT600201CA.PaymentRequestAttention</a></li></ul>"));
	}
		
	@Test
	public void testShouldEscapeDataTypeHtmlCharactersInRelationshipDataType() throws Exception {
		
		MessagePart messagePart = testMessageSet.getMessagePart("FICR_MT600201CA.PaymentRequest");
		
		Relationship relationship = messagePart.getRelationship("id");
		
		MessagePartHtml html = new MessagePartHtml(messagePart, testMessageSet, testDatatypeSet, false);
		
		Table result = html.createRelationshipTable(relationship);
		Assert.assertTrue(result.write().contains("<td class=\"detailsTableValueCol\" colspan=\"3\"><span>SET&lt;II.PUBLIC&gt;</span></td>"));
	}
	
	@Test
	public void testShouldMergeCardinalityConformanceIntoOneRow() throws Exception {
		
		MessagePart messagePart = testMessageSet.getMessagePart("FICR_MT600201CA.PaymentRequest");
		
		Relationship relationship = messagePart.getRelationship("id");
		
		MessagePartHtml html = new MessagePartHtml(messagePart, testMessageSet, testDatatypeSet, false);
		
		Table result = html.createRelationshipTable(relationship);
		
		Assert.assertTrue(result.write().contains("<tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-5</td></tr>"));
	}
	
	@Test
	public void testCreateRelationshipTable() throws Exception {
		
		MessagePart messagePart = testMessageSet.getMessagePart("FICR_MT600201CA.InvoiceElementDetail");
		
		Relationship relationship = messagePart.getRelationship("code");
		
		MessagePartHtml html = new MessagePartHtml(messagePart, testMessageSet, testDatatypeSet, false);
		
		Table result = html.createRelationshipTable(relationship);
		Assert.assertTrue("Coded Data Type Details Row", result.write().contains("<tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Concept Domain</td><td class=\"detailsTableValueCol\"><a href=\"../conceptDomains/ActInvoiceDetailCode.html\">ActInvoiceDetailCode</a></td></tr>"));
		Assert.assertTrue("Cardinality Conformance Row", result.write().contains("<tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr>"));
	}
		
	@Test
	public void shouldShowDefinitionAnnotationAsNote() throws Exception {
		MessagePart messagePart = testMessageSet.getMessagePart("FICR_MT600201CA.PatientConsent");
		
		MessagePartHtml html = new MessagePartHtml(messagePart, testMessageSet, testDatatypeSet, false);
		
		String result = html.write();
		
		String definition = "<p>Issue: this may be adjusted based on an expanded view of consent</p>";
		
		Assert.assertNotNull(messagePart.getDocumentation());
		Assert.assertEquals(1, messagePart.getDocumentation().getAnnotations().size());
		Assert.assertEquals("DEFINITION", messagePart.getDocumentation().getAnnotations().get(0).getAnnotationType());
		Assert.assertEquals(definition, messagePart.getDocumentation().getAnnotations().get(0).getText());
		Assert.assertTrue(result.contains("<tr><td class=\"detailsTableLabelCol\">Note:</td><td class=\"detailsTableValueCol\" colspan=\"3\">" + definition + "</td></tr>"));		
	}
}
