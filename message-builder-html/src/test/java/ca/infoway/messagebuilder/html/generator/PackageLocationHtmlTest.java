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
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.svgifier.Svgifier;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(MockitoJUnitRunner.class)
public class PackageLocationHtmlTest {
	@Mock private Svgifier mockSvgifier;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() throws Exception {
		String packageName = "ABCD_MT123456CA";
		String rootTypeName = packageName + ".rootPart";
		
		PackageLocation testPackage = new PackageLocation();
		testPackage.setName(packageName);
		testPackage.setRootType(rootTypeName);
		
		MessagePart testPart = new MessagePart();
		testPart.setName(rootTypeName);
		testPackage.getMessageParts().put(rootTypeName, testPart);
		
		MessageSet testSet = new MessageSet();
		testSet.getPackageLocations().put(packageName, testPackage);
		testSet.addMessagePart(testPart);
		
		PackageLocationHtml html = new PackageLocationHtml(testPackage, testSet, null, false);
		html.setSvgifier(mockSvgifier);
		
		String result = html.write();
		
		String expectedHeadElements
			= 	"<head>" +
					"<title>PackageLocation: ABCD_MT123456CA for: null</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String expectedTOCDiv 
			=	"<div id=\"packageTocDiv\">" +
					"<h4 class=\"tocHeader\">Contents:</h4>" +
					"<ol class=\"mainToc tocList\">" +
						"<li class=\"msgPartToc tocListItem\">" +
							"<a href=\"#ABCD_MT123456CA-rootPartDetailsDiv\">ABCD_MT123456CA.rootPart</a>" +
							"<ol class=\"tocList\"></ol></li><li class=\"tocListItem\">" +
							"<a href=\"#diagramDiv\">Diagram</a>" +
						"</li>" +
					"</ol>" +
				"</div>";
		
		String expectedSidePanel 
			= 	"<div id=\"leftSideColumn\">" +
					"<div id=\"navControlDiv\"><a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div>" +
					"<div id=\"leftNavBar\"></div>" +
				"</div>";
		
		String expectedPackagePayload 
			=	"<div id=\"packageSummaryDiv_ABCD_MT123456CA\" class=\"packageSummaryDiv\"><hr>" +
					"<h2 class=\"titleHeader\">Package Summary</h2>" +
					"<table class=\"packageLocationSummaryTable\" id=\"packageLocationSummaryTable-ABCD_MT123456CA\">" +
						"<tbody>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Name:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\"><a href=\"#ABCD_MT123456CADetailsDiv\">ABCD_MT123456CA</a></td>" +
							"</tr>" +
							"<tr>" +
								"<td class=\"detailsTableLabelCol\">Descriptive Name:</td>" +
								"<td class=\"detailsTableValueCol\" colspan=\"3\"></td>" +
							"</tr>" +
						"</tbody>" +
					"</table>" +
				"</div>" +
				"<div id=\"ABCD_MT123456CA-rootPartDetailsDiv\" class=\"messagePartDetailsDiv\"><hr>" +
					"<h2 id=\"titleHeader-ABCD_MT123456CA-rootPart\" class=\"titleHeader\">rootPart</h2>" +
					"<div id=\"summaryDiv_ABCD_MT123456CA-rootPart\" class=\"summaryDiv\">" +
					"</div>" +
				"</div>" +
				"<div id=\"diagramDiv\" class=\"diagramDiv\"><hr>" +
					"<h2 id=\"diagramHeader-ABCD_MT123456CA\" class=\"diagramHeader\">Diagram:</h2>" +
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
								"<div id=\"metaDiv\" partname=\"ABCD_MT123456CA-rootPart\" packagename=\"ABCD_MT123456CA\"></div>" +
								"<div id=\"breadcrumbDiv\"><h2 class=\"breadcrumbHeader\">MessageSet Version: null</h2></div>" +
								"<div id=\"page\">" +
									expectedSidePanel + 
									"<div id=\"mainColumn\">" +
									"<h2 id=\"packageTitleHeader_ABCD_MT123456CA\" class=\"packageTitleHeader\">ABCD_MT123456CA: </h2>" +
									expectedTOCDiv + 
									expectedPackagePayload + 
									"</div>" +
								"</div>" +
							"</div>" +
							"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
						"</div>" +
					"</body>" +
					"</html>";
		
		//System.out.println(result);
		Assert.assertTrue(result.contains(expectedHeadElements));
		Assert.assertTrue(result.contains(expectedTOCDiv));
		Assert.assertTrue(result.contains(expectedSidePanel));
		Assert.assertTrue(result.contains(expectedPackagePayload));
		Assert.assertEquals(expectedHtml, result);
	}
}
