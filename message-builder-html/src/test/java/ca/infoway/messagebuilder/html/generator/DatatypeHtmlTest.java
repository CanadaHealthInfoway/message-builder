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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.hp.gagawa.java.Node;

import ca.infoway.messagebuilder.datatype.mif.DatatypeMifMarshaller;
import ca.infoway.messagebuilder.datatype.mif.MifDatatypeModelLibrary;
import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(MockitoJUnitRunner.class)
public class DatatypeHtmlTest {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private DatatypeMifMarshaller marshaller = new DatatypeMifMarshaller();
	private MifDatatypeModelLibrary uvDatatypeModel;
	private MifDatatypeModelLibrary caDatatypeModel;
	private DatatypeSet testUVDatatypeSet;
	private DatatypeSet testCADatatypeSet;
	private MessageSet testMessageSet;
	
	@Before
	public void setUp() throws Exception {
		InputStream input1 = getClass().getResourceAsStream("/DEFN=UV=DT=1.1.coremif");
		uvDatatypeModel = getMifTestModel(input1);
		InputStream input2 = getClass().getResourceAsStream("/DEFN=CA=DT=R02.04.xx.coremif");
		caDatatypeModel = getMifTestModel(input2);
		testUVDatatypeSet = new DatatypeSet(uvDatatypeModel);
		testCADatatypeSet = new DatatypeSet(testUVDatatypeSet, caDatatypeModel);
		
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}

	@Test
	public void testWrite() {
		Datatype datatype = testCADatatypeSet.getAllDatatypes().get(0);
		DatatypeHtml html = new DatatypeHtml(datatype, testCADatatypeSet, testMessageSet);
		
		assertNotNull(html.write());
		assertTrue(html.write().length() > 0);
	}
	
	@Test
	public void testShouldContainBasicHtmlStructure() {
		Datatype datatype = testCADatatypeSet.getDatatype("CD.LAB");
		DatatypeHtml html = new DatatypeHtml(datatype, testCADatatypeSet, testMessageSet);
		String result = html.write();
		
		String headElement =
				"<head>" +
					"<title>Datatype: CD.LAB for: R02.04.00</title>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/mystyle.css\"></link>" +
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/jquery-ui-1.8.21.custom.css\"></link>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-1.7.2.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery-ui-1.8.21.custom.min.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/jquery.jstree.js\"></script>" +
					"<script type=\"text/javascript\" src=\"../resources/js/mainNavBar.js\"></script>" +
				"</head>";
		
		String datatypeSummaryDiv =
			"<div class=\"datatypeSummaryDiv\" id=\"datatypeSummary_CD.LAB\">" +
				"<table class=\"datatypeSummaryTable\">" +
					"<thead></thead>" +
					"<tbody>" +
						"<tr>" +
							"<td class=\"detailsTableLabelCol\">Super Type:</td><td class=\"detailsTableValueCol\" colspan=\"3\"><span>CD.UV</span></td>" +
						"</tr>" +
						"<tr>" +
							"<td class=\"detailsTableLabelCol\">Usage notes:</td>" +
							"<td class=\"detailsTableValueCol\" colspan=\"3\">" + LINE_SEPARATOR + 
								"<p>If the attribute or property is null, the codeSystem and originalTextproperties are still permitted but not <i>mandatory</i>.</p>" + LINE_SEPARATOR + 
								"<p>The rules for supporting the several properties vary depending on whether the element has a coding strength of CWE (Coded with extensibility) or CNE (Coded with no extensibility).</p>" + LINE_SEPARATOR + 
								"<p>For CWE, \"code\", \"codeSystem\" and \"originalText\" properties are required. A constraint exists that at least one of \"code\" and \"originalText\" must be present and non-null, and that if \"code\" is present, then \"codeSystem is mandatory.</p>" + LINE_SEPARATOR + 
								"<p>For CNE, \"code\" and \"codeSystem\" are mandatory (meaning they must be non-null if the overall attribute or property is non-null). If the element is null with a flavor of OTH (Other), then the \"originalText\" property is mandatory (and no other properties may be specified).</p>" + LINE_SEPARATOR + 
							"</td>" +
						"</tr>" +
					"</tbody>" +
				"</table>" +
			"</div>";
		
		String staticExampleDiv =
				"<div class=\"datatypeExampleDiv\">" +
					"<h3 class=\"staticExampleHeader\">Example: </h3>" +
					"<div class=\"datatypeExampleHeaderDiv\">a diagnosis of moderate to severe psoriasis of the face with sudden onset</div>" +
					"<div class=\"datatypeExampleTextDiv\">" + LINE_SEPARATOR + 
						"<pre>" +
						"&lt;value codeSystem=&apos;2.16.840.1.113883.6.96&apos; code=&apos;402320002&apos;&gt;" + LINE_SEPARATOR + 
						"	&lt;originalText&gt;Acute, moderate facial psoriasis&lt;/originalText&gt;" + LINE_SEPARATOR + 
						"	&lt;qualifier&gt;" + LINE_SEPARATOR +
						"		&lt;name codeSystem=&apos;2.16.840.1.113883.6.96&apos; code=&apos;246100006&apos;/&gt;" + LINE_SEPARATOR +
						"		&lt;value codeSystem=&apos;2.16.840.1.113883.6.96&apos; code=&apos;385315009&apos;/&gt;" + LINE_SEPARATOR + 
						"	&lt;/qualifier&gt;" + LINE_SEPARATOR +
						"	&lt;qualifier&gt;" + LINE_SEPARATOR +
						"		&lt;name codeSystem=&apos;2.16.840.1.113883.6.96&apos; code=&apos;246112005&apos;/&gt;" + LINE_SEPARATOR +
						"		&lt;value codeSystem=&apos;2.16.840.1.113883.6.96&apos; code=&apos;371924009&apos;/&gt;" + LINE_SEPARATOR +
						"	&lt;/qualifier&gt;" + LINE_SEPARATOR +
						"&lt;/value&gt;" + LINE_SEPARATOR +
						"</pre>" +
					"</div>" +
				"</div>";
		
		String expected=
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
					headElement +
					"<body>" +
						"<div id=\"wrapper\">" +
							"<div id=\"headerDiv\" class=\"headerDiv\">" +
								"<div id=\"iconDiv\" class=\"iconDiv\"></div>" +
							"</div>" +
							"<div id=\"container\" class=\"content\">" +
								"<div id=\"metaDiv\" partname=\"CD.LAB\" packagename=\"CD-LAB\"></div>" +
								"<div id=\"breadcrumbDiv\">" +
									"<h2 class=\"breadcrumbHeader\">MessageSet Version: R02_04_03</h2>" +
								"</div>" +
								"<div id=\"page\">" +
									"<div id=\"leftSideColumn\">" +
										"<div id=\"navControlDiv\">" +
											"<a id=\"toggleNavBarButton\" href=\"#\">[<<<]</a></div><div id=\"leftNavBar\">" +
										"</div>" +
									"</div>" +
									"<div id=\"mainColumn\">" +
										"<h2 class=\"titleHeader\">CD.LAB</h2>" +
										"<h3 id=\"titleHeader-CD-LAB\" class=\"subTitleHeader\">(Coded Value (Lab))</h3>" +
										datatypeSummaryDiv +
										staticExampleDiv +
									"</div>" +
								"</div>" +
							"</div>" +
							"<div id=\"footerDiv\" class=\"footerDiv\"></div>" +
						"</div>" +
					"</body>" +
				"</html>";
		assertEquals(expected, result);
	}

	@Test
	public void testShouldGenerateSingleLinksCorrectly() {
		Datatype mockDatatype = mock(Datatype.class);
		DatatypeSet mockDatatypeSet = mock(DatatypeSet.class);
		MessageSet mockMessageSet = mock(MessageSet.class);
		
		DatatypeHtml fixture = new DatatypeHtml(mockDatatype, mockDatatypeSet, mockMessageSet);
		
		String compoundName = "CD";
		when(mockDatatypeSet.getDatatype("CD")).thenReturn(new Datatype());
		
		Node typeLinks = fixture.createDatatypeLinks(compoundName, mockDatatypeSet);
		
		String result = typeLinks.write();
		
		String expected = 
				"<span>" +
					"<a href=\"../datatypes/CD.html\" class=\"detailsRows\">CD</a>" +
				"</span>";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testShouldGenerateSingleArgCollectionLinksCorrectly() {
		Datatype mockDatatype = mock(Datatype.class);
		DatatypeSet mockDatatypeSet = mock(DatatypeSet.class);
		MessageSet mockMessageSet = mock(MessageSet.class);
		
		DatatypeHtml fixture = new DatatypeHtml(mockDatatype, mockDatatypeSet, mockMessageSet);
		
		String compoundName = "LIST<LIST<LIST<CD>>>";
		when(mockDatatypeSet.getDatatype("LIST")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("CD")).thenReturn(new Datatype());
		
		Node typeLinks = fixture.createDatatypeLinks(compoundName, mockDatatypeSet);
		
		String result = typeLinks.write();
		
		String expected = 
				"<span>" +
					"<a href=\"../datatypes/LIST.html\" class=\"detailsRows\">LIST</a>&lt;" +
					"<a href=\"../datatypes/LIST.html\" class=\"detailsRows\">LIST</a>&lt;" +
					"<a href=\"../datatypes/LIST.html\" class=\"detailsRows\">LIST</a>&lt;" +
					"<a href=\"../datatypes/CD.html\" class=\"detailsRows\">CD</a>&gt;&gt;&gt;" +
				"</span>";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testShouldGenerateMultiArgCollectionLinksCorrectly() {
		Datatype mockDatatype = mock(Datatype.class);
		DatatypeSet mockDatatypeSet = mock(DatatypeSet.class);
		MessageSet mockMessageSet = mock(MessageSet.class);
		
		DatatypeHtml fixture = new DatatypeHtml(mockDatatype, mockDatatypeSet, mockMessageSet);
		
		String compoundName = "RTO<ID, RTO<ID, CD>>";
		when(mockDatatypeSet.getDatatype("RTO")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("ID")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("CD")).thenReturn(new Datatype());
		
		Node typeLinks = fixture.createDatatypeLinks(compoundName, mockDatatypeSet);
		
		String result = typeLinks.write();
		
		String expected = 
				"<span>" +
					"<a href=\"../datatypes/RTO.html\" class=\"detailsRows\">RTO</a>&lt;" +
					"<a href=\"../datatypes/ID.html\" class=\"detailsRows\">ID</a>, " +
					"<a href=\"../datatypes/RTO.html\" class=\"detailsRows\">RTO</a>&lt;" +
					"<a href=\"../datatypes/ID.html\" class=\"detailsRows\">ID</a>, " +
					"<a href=\"../datatypes/CD.html\" class=\"detailsRows\">CD</a>&gt;&gt;" +
				"</span>";
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testShouldGenerateMultiArgWithUnknownTypeCollectionLinksCorrectly() {
		Datatype mockDatatype = mock(Datatype.class);
		DatatypeSet mockDatatypeSet = mock(DatatypeSet.class);
		MessageSet mockMessageSet = mock(MessageSet.class);
		
		DatatypeHtml fixture = new DatatypeHtml(mockDatatype, mockDatatypeSet, mockMessageSet);
		
		String compoundName = "RTO<ID, LIST<RTO<CD, HIGHFIVE>>>";
		when(mockDatatypeSet.getDatatype("RTO")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("ID")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("CD")).thenReturn(new Datatype());
		when(mockDatatypeSet.getDatatype("LIST")).thenReturn(new Datatype());
		
		Node typeLinks = fixture.createDatatypeLinks(compoundName, mockDatatypeSet);
		
		String result = typeLinks.write();
		
		String expected = 
				"<span>" +
					"<a href=\"../datatypes/RTO.html\" class=\"detailsRows\">RTO</a>&lt;" +
					"<a href=\"../datatypes/ID.html\" class=\"detailsRows\">ID</a>, " +
					"<a href=\"../datatypes/LIST.html\" class=\"detailsRows\">LIST</a>&lt;" +
					"<a href=\"../datatypes/RTO.html\" class=\"detailsRows\">RTO</a>&lt;" +
					"<a href=\"../datatypes/CD.html\" class=\"detailsRows\">CD</a>,  HIGHFIVE&gt;&gt;&gt;" +
				"</span>";
		
		assertEquals(expected, result);
	}
	
	private MifDatatypeModelLibrary getMifTestModel(InputStream input) throws IOException {
		MifDatatypeModelLibrary model = null;
		try {
			model = marshaller.unmarshallDatatypeModel(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
		return model;
	}
}
