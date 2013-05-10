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

import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(MockitoJUnitRunner.class)
public class HtmlMessageSetRenderImplTest {
	private HtmlMessageSetRenderer fixture;
	@Mock private MessageSet mockMessageSet;
	@Mock private DatatypeSet mockDatatypeSet;
	
	@Before
	public void setUp() {
		fixture = new HtmlMessageSetRendererImpl();
		fixture.setInteractionsPath("../interactions");
		fixture.setPackagesPath("../packages");
		fixture.setJavascriptPath("../resources/js");
		fixture.setResourcesPath("../resources");
		when(mockDatatypeSet.getDatatype(Mockito.anyString())).thenReturn(null);
	}
		
	@Test 
	public void testWritePackageLocationWithSVG() throws Exception {
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		MessageSet testMessageSet = marshaller.unmarshall(resourceAsStream);
		
		PackageLocation packageLocation = testMessageSet.getPackageLocation("COCT_MT011001CA");
		
		String result = this.fixture.writePackageLocation(packageLocation, testMessageSet, mockDatatypeSet);
		
		String headElement = 
				"<head><title>PackageLocation: COCT_MT011001CA for: R02_04_03</title><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link><script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script><script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script></head>";
		
		String headerDivElement = "<div id=\"headerDiv\" class=\"headerDiv\"><div id=\"iconDiv\" class=\"iconDiv\"></div></div>";
		
		String metaDivElement = "<div id=\"metaDiv\" partname=\"COCT_MT011001CA-PatientCareProvisionEvent\" packagename=\"COCT_MT011001CA\"></div>";
		
		String breadcrumbDivElement = "<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2></div>";
		
		String leftNavBarElement = "<div id=\"leftNavBar\"></div>";
		
		String packagePayloadElements = 
				"<div id=\"packageSummaryDiv_COCT_MT011001CA\" class=\"packageSummaryDiv\"><hr><h2 class=\"titleHeader\">Package Summary</h2><table class=\"packageLocationSummaryTable\" id=\"packageLocationSummaryTable-COCT_MT011001CA\"><tbody><tr><td class=\"detailsTableLabelCol\">Name:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"#COCT_MT011001CADetailsDiv\">COCT_MT011001CA</a></td></tr><tr><td class=\"detailsTableLabelCol\">Descriptive Name:</td><td class=\"detailsTableValueCol\" colspan=\"3\">Care Event identified</td></tr></tbody></table></div><div id=\"COCT_MT011001CA-PatientCareProvisionEventDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-PatientCareProvisionEvent\" class=\"titleHeader\">Care Compositions</h2><h3 id=\"titleHeader-COCT_MT011001CA-PatientCareProvisionEvent\" class=\"subTitleHeader\">(PatientCareProvisionEvent)</h3><div id=\"summaryDiv_COCT_MT011001CA-PatientCareProvisionEvent\" class=\"summaryDiv\"><table class=\"messagePartSummaryTable\" id=\"messagePartSummaryTable-COCT_MT011001CA-PatientCareProvisionEvent\"><tbody><tr><td class=\"detailsTableLabelCol\">Note:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>A care composition is a record with two purposes. It indicates that care of a given type has occurred or is occurring. It also acts as a collector for the events that happened during care, including who is responsible for the care provided.</p></td></tr><tr><td class=\"detailsTableLabelCol\">Rationale:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>Allows linking records to encounters, condition and care-based compositions. Useful for searching and navigation of the patient's record.</p></td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_code\"><h2 class=\"titleHeader\">A: Care Composition Type</h2><h3 class=\"subTitleHeader\">(code)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CV</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Concept Domain</td><td class=\"detailsTableValueCol\">ActCareEventType</td></tr><tr><td class=\"detailsTableLabelCol\">Note:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>Identifies the kind of composition represented. Examples include encounters (&quot;Emergency Encounter&quot;, &quot;Long Term Care Encounter&quot;, etc), health condition (episode)-based collections (e.g. &quot;Diabetes&quot;, &quot;Hypertension&quot;, etc) and general care-based collections such as &quot;gynecological care&quot;.</p></td></tr><tr><td class=\"detailsTableLabelCol\">Open issue:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>EPHS: vocab concepts needed for LAB ID, Special Considerations ID etc.</p></td></tr><tr><td class=\"detailsTableLabelCol\">Rationale:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>Allows care compositions to be captured and categorized at different levels of abstraction, and is therefore mandatory.</p></td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_id\"><h2 class=\"titleHeader\">B: Care Composition Identifier</h2><h3 class=\"subTitleHeader\">(id)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">II.BUS</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-1</td></tr><tr><td class=\"detailsTableLabelCol\">Note:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>Unique identifier of an encounter, condition or care-based collection.</p></td></tr><tr><td class=\"detailsTableLabelCol\">Rationale:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><p>Allows care compositions to be uniquely identified and referenced.</p></td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_effectiveTime\"><h2 class=\"titleHeader\">Care Composition Effective Date</h2><h3 class=\"subTitleHeader\">(effectiveTime)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">IVL&lt;TS.DATETIME&gt;</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-1</td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_classCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(classCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">PCPR</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to PCPR</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">ActClass</td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_moodCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(moodCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">EVN</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to EVN</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">ActMood</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_admitter\"><h2 class=\"titleHeader\">admitter</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-AdmitterDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.Admitter\" class=\"detailsRow\">COCT_MT011001CA.Admitter</a></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-10</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_attender\"><h2 class=\"titleHeader\">attender</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-AttenderDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.Attender\" class=\"detailsRow\">COCT_MT011001CA.Attender</a></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-10</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.PatientCareProvisionEvent_location\"><h2 class=\"titleHeader\">location</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-LocationDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.Location\" class=\"detailsRow\">COCT_MT011001CA.Location</a></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-1</td></tr></tbody></table></div></div><div id=\"COCT_MT011001CA-AdmitterDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-Admitter\" class=\"titleHeader\">Admitter</h2><div id=\"summaryDiv_COCT_MT011001CA-Admitter\" class=\"summaryDiv\"></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.Admitter_typeCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(typeCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">ADM</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to ADM</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">ParticipationType</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.Admitter_assignees\"><h2 class=\"titleHeader\">assignees</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-AssigneesDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.Assignees\" class=\"detailsRow\">COCT_MT011001CA.Assignees</a></td></tr><tr id=\"choice_assignees\"><td class=\"detailsTableLabelCol\">Descendants:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><ul><li class=\"choiceDetails\">assignedEntity1 : <a href=\"../packages/COCT_MT090102CA.html#COCT_MT090102CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090102CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090102CA.AssignedEntity</a></li><li class=\"choiceDetails\">assignedEntity2 : <a href=\"../packages/COCT_MT090502CA.html#COCT_MT090502CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090502CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090502CA.AssignedEntity</a></li></ul></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr></tbody></table></div></div><div id=\"COCT_MT011001CA-AttenderDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-Attender\" class=\"titleHeader\">Attender</h2><div id=\"summaryDiv_COCT_MT011001CA-Attender\" class=\"summaryDiv\"></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.Attender_typeCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(typeCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">ATND</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to ATND</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">ParticipationType</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.Attender_assignees\"><h2 class=\"titleHeader\">assignees</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-AssigneesDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.Assignees\" class=\"detailsRow\">COCT_MT011001CA.Assignees</a></td></tr><tr id=\"choice_assignees\"><td class=\"detailsTableLabelCol\">Descendants:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><ul><li class=\"choiceDetails\">assignedEntity1 : <a href=\"../packages/COCT_MT090102CA.html#COCT_MT090102CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090102CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090102CA.AssignedEntity</a></li><li class=\"choiceDetails\">assignedEntity2 : <a href=\"../packages/COCT_MT090502CA.html#COCT_MT090502CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090502CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090502CA.AssignedEntity</a></li></ul></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr></tbody></table></div></div><div id=\"COCT_MT011001CA-LocationDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-Location\" class=\"titleHeader\">Location</h2><div id=\"summaryDiv_COCT_MT011001CA-Location\" class=\"summaryDiv\"></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.Location_typeCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(typeCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">LOC</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to LOC</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">ParticipationType</td></tr></tbody></table></div><div class=\"relationshipDiv\" id=\"COCT_MT011001CA.Location_serviceDeliveryLocation\"><h2 class=\"titleHeader\">serviceDeliveryLocation</h2><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Target:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/COCT_MT011001CA.html#COCT_MT011001CA-ServiceDeliveryLocationDetailsDiv\" id=\"detailsRow_COCT_MT011001CA.ServiceDeliveryLocation\" class=\"detailsRow\">COCT_MT011001CA.ServiceDeliveryLocation</a></td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr></tbody></table></div></div><div id=\"COCT_MT011001CA-AssigneesDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-Assignees\" class=\"titleHeader\">Assignees</h2><div id=\"summaryDiv_COCT_MT011001CA-Assignees\" class=\"summaryDiv\"><table class=\"messagePartSummaryTable\" id=\"messagePartSummaryTable-COCT_MT011001CA-Assignees\"><tbody><tr><td class=\"detailsTableLabelCol\">Specialization Types:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><ul><li><a href=\"../packages/COCT_MT090102CA.html#COCT_MT090102CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090102CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090102CA.AssignedEntity</a></li><li><a href=\"../packages/COCT_MT090502CA.html#COCT_MT090502CA-AssignedEntityDetailsDiv\" id=\"COCT_MT090502CA.AssignedEntity\" class=\"detailsRow\">COCT_MT090502CA.AssignedEntity</a></li></ul></td></tr></tbody></table></div></div><div id=\"COCT_MT011001CA-ServiceDeliveryLocationDetailsDiv\" class=\"messagePartDetailsDiv\"><hr><h2 id=\"titleHeader-COCT_MT011001CA-ServiceDeliveryLocation\" class=\"titleHeader\">ServiceDeliveryLocation</h2><div id=\"summaryDiv_COCT_MT011001CA-ServiceDeliveryLocation\" class=\"summaryDiv\"></div><div class=\"relationshipDiv attributeDiv\" id=\"COCT_MT011001CA.ServiceDeliveryLocation_code\"><h2 class=\"titleHeader\">Service Location Type</h2><h3 class=\"subTitleHeader\">(code)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CV</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Required</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">0-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Concept Domain</td><td class=\"detailsTableValueCol\">ServiceDeliveryLocationRoleType</td></tr></tbody></table></div><div class=\"relationshipDiv attributeDiv fixedAttribute\" id=\"COCT_MT011001CA.ServiceDeliveryLocation_classCode\"><h2 class=\"titleHeader\"></h2><h3 class=\"subTitleHeader\">(classCode)</h3><table class=\"relationshipDetailsTable\"><thead></thead><tbody><tr><td class=\"detailsTableLabelCol\">Data Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\">CS</td></tr><tr><td class=\"detailsTableLabelCol\">Fixed Value:</td><td class=\"detailsTableValueCol\">SDLOC</td><td class=\"detailsTableValueCol\" colspan=\"2\">This member is fixed to SDLOC</td></tr><tr><td class=\"detailsTableLabelCol\">Conformance:</td><td class=\"detailsTableValueCol\">Mandatory</td><td class=\"detailsTableLabelCol\">Cardinality:</td><td class=\"detailsTableValueCol\">1-1</td></tr><tr><td class=\"detailsTableLabelCol\">Coding Strength:</td><td class=\"detailsTableValueCol\">CNE</td><td class=\"detailsTableLabelCol\">Code System</td><td class=\"detailsTableValueCol\">RoleClass</td></tr></tbody></table></div></div>";
		
		String svgDiagramElementStub = "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\"";

		Assert.assertTrue("Incorrect Head Element: ", result.contains(headElement));
		Assert.assertTrue("Incorrect Header Title Element: ", result.contains(headerDivElement));
		Assert.assertTrue("Incorrect Meta Div Element: ", result.contains(metaDivElement));
		Assert.assertTrue("Incorrect Breadcrumb Element: ", result.contains(breadcrumbDivElement));
		Assert.assertTrue("Incorrect Left Tree Nav Element: ", result.contains(leftNavBarElement));
		Assert.assertTrue("Incorrect Package Payload Elements: " + result, result.contains(packagePayloadElements));
		Assert.assertTrue("Missing SVG Elements ", result.contains(svgDiagramElementStub));
	}
	
	@Test
	public void testWriteMessagePart() {
		MessagePart messagePart = new MessagePart();
		messagePart.setName("ABCD_MT123456CA.TestPart");
		Documentation documentation = new Documentation();
		documentation.setBusinessName("testPart BusinessName");
		messagePart.setDocumentation(documentation);
		String result = fixture.writeMessagePart(messagePart, mockMessageSet, mockDatatypeSet);
		
		String expected = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title>MessagePart: ABCD_MT123456CA-TestPart for: null</title><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link><script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script><script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script></head><body><div id=\"wrapper\"><div id=\"headerDiv\" class=\"headerDiv\"><div id=\"iconDiv\" class=\"iconDiv\"></div></div><div id=\"container\" class=\"content\"><div id=\"metaDiv\" partname=\"ABCD_MT123456CA-TestPart\" packagename=\"ABCD_MT123456CA\"></div><div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: null</h2></div><div id=\"page\"><div id=\"leftSideColumn\"><div id=\"navControlDiv\"><a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div><div id=\"leftNavBar\"></div></div><div id=\"mainColumn\"><h2 id=\"titleHeader-ABCD_MT123456CA-TestPart\" class=\"titleHeader\">testPart BusinessName</h2><h3 class=\"subTitleHeader\">(ABCD_MT123456CA.TestPart)</h3><div id=\"summaryDiv_ABCD_MT123456CA-TestPart\" class=\"summaryDiv\"></div></div></div></div><div id=\"footerDiv\" class=\"footerDiv\"></div></div></body></html>";
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testWriteInteraction() {
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setBusinessName("Sample Interaction");
		interaction.setSuperTypeName("ABCD_MT654321.SuperType");
		interaction.setTriggerEvent("ABCD_MT991122.ControlActEvent");
		Annotation description = new Annotation("This is a test interaction");
		description.setAnnotationTypeAsEnum(AnnotationType.DESCRIPTION);
		interaction.getDocumentation().getAnnotations().add(description);
		Annotation rationale = new Annotation("This is the rationale behind the test interaction");
		rationale.setAnnotationTypeAsEnum(AnnotationType.RATIONALE);
		interaction.getDocumentation().getAnnotations().add(rationale);
		interaction.getDocumentation().setTitle("Test Interaction for Test purposes");
		String result = fixture.writeInteraction(interaction , mockMessageSet);
		String expected = 
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title>Interaction: ABCD_IN123456CA for: null</title><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link><link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link><script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script><script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script><script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script></head><body><div id=\"wrapper\"><div id=\"headerDiv\" class=\"headerDiv\"><div id=\"iconDiv\" class=\"iconDiv\"></div></div><div id=\"container\" class=\"content\"><div id=\"metaDiv\" partname=\"ABCD_IN123456CA\" packagename=\"ABCD_IN123456CA\"></div><div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: null</h2></div><div id=\"page\"><div id=\"leftSideColumn\"><div id=\"navControlDiv\"><a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div><div id=\"leftNavBar\"></div></div><div id=\"mainColumn\"><h2 id=\"interactionTitleHeader-ABCD_IN123456CA\" class=\"interactionTitleHeader\">ABCD_IN123456CA : Sample Interaction</h2><div class=\"interactionTocDiv\" id=\"interactionTocDiv\"><h4 class=\"tocTitle\">Contents:</h4><ol class=\"mainToc\"><li><a href=\"#detailsDiv\">Interaction Details</a></li></ol></div><div id=\"detailsDiv\" class=\"detailsDiv\"><hr><h3>Interaction Details:</h3><table class=\"interactionDetailsTable\"><thead><tr><th>ABCD_IN123456CA</th></tr></thead><tbody><tr><td class=\"detailsTableLabelCol\">Name:</td><td class=\"detailsTableValueCol\" colspan=\"3\">Sample Interaction</td></tr><tr><td class=\"detailsTableLabelCol\">Transmission Wrapper:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"../packages/ABCD_MT654321.html#ABCD_MT654321-SuperTypeDetailsDiv\" id=\"ABCD_MT654321.SuperType\" class=\"detailsRow\">ABCD_MT654321.SuperType</a></td></tr><tr><td class=\"detailsTableLabelCol\">Control Act Wrapper:</td><td class=\"detailsTableValueCol\" colspan=\"3\">NONE</td></tr><tr><td class=\"detailsTableLabelCol\">Payload:</td><td class=\"detailsTableValueCol\" colspan=\"3\">NONE</td></tr><tr><td class=\"detailsTableLabelCol\">Trigger Event:</td><td class=\"detailsTableValueCol\" colspan=\"3\">ABCD_MT991122.ControlActEvent</td></tr><tr><td class=\"detailsTableLabelCol\">Responses:</td><td class=\"detailsTableValueCol\" colspan=\"3\">Not Applicable</td></tr><tr><td class=\"detailsTableLabelCol\">Title:</td><td class=\"detailsTableValueCol\" colspan=\"3\">Test Interaction for Test purposes</td></tr><tr><td class=\"detailsTableLabelCol\">Description:</td><td class=\"detailsTableValueCol\" colspan=\"3\">This is a test interaction</td></tr><tr><td class=\"detailsTableLabelCol\">Rationale:</td><td class=\"detailsTableValueCol\" colspan=\"3\">This is the rationale behind the test interaction</td></tr></tbody></table></div></div></div></div><div id=\"footerDiv\" class=\"footerDiv\"></div></div></body></html>";
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testGetStaticDatatypeFiles() {
		Map<String, InputStream> staticDatatypeFiles1 = fixture.getStaticDatatypeFiles("R02_04_xx_CA");
		Assert.assertEquals(1, staticDatatypeFiles1.size());
		
		Map<String, InputStream> staticDatatypeFiles2 = fixture.getStaticDatatypeFiles("R02_04_03_CA");
		Assert.assertEquals(0, staticDatatypeFiles2.size());
	}
}
