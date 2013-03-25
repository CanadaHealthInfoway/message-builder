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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.mifcomparer;

import static ca.infoway.messagebuilder.mifcomparer.Assert.assertEqualsUnordered;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.EXTRA;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.MISSING;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.VALUE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.FILE_SUMMARY;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_DIFFERENCE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.ELEMENT;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.TEXT;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.INFO;
import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@RunWith(Suite.class)
@Suite.SuiteClasses({XmlFileComparerTest.BasicTests.class, XmlFileComparerTest.SmokeTests.class, XmlFileComparerTest.XmlDifferenceTypes.class})
public class XmlFileComparerTest {
	private static final String NEWLINE = System.getProperty("line.separator");

	public static class BasicTests {
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void that_getChildNodes_on_nonempty_node_returns_the_children() throws XPathException, SAXException, IOException {
			//setup
			Document input = xml2DOM("<outer><a><aa/></a><b/><inner2/></outer>");
			List<String> expNames = Arrays.asList(new String[] {"a", "b", "inner2"});

			//action
			List<Node> children = XmlFileComparer.getChildNodes("/outer", input);
			
			//test
			List<String> actNames = new ArrayList<String>(children.size());
			for (Node n : children)
				actNames.add(n.getNodeName());
			
			assertEqualsUnordered(expNames, actNames);
		}
				
		@Test
		public void that_getChildNodes_on_returns_duplicate_children() throws XPathException, SAXException, IOException {
			//setup
			Document input = xml2DOM("<outer><a/><a/></outer>");
			List<String> expNames = Arrays.asList(new String[] {"a", "a", });

			//action
			List<Node> children = XmlFileComparer.getChildNodes("/outer", input);
			
			//test
			List<String> actNames = new ArrayList<String>(children.size());
			for (Node n : children)
				actNames.add(n.getNodeName());
			
			assertEqualsUnordered(expNames, actNames);
		}
				
		@Test
		public void that_getChildNodes_on_empty_node_returns_empty_list() throws XPathException, SAXException, IOException {
			//setup
			Document input = xml2DOM("<outer></outer>");
			
			//action
			List<Node> children = XmlFileComparer.getChildNodes("/outer", input);
			
			//test
			assertTrue("children should be empty, but isn't", children.isEmpty());
		}
				
		@Test
		public void that_getChildNodes_with_no_match_throws_XPathException() throws XPathException, SAXException, IOException {
			//setup
			Document input = xml2DOM("<outer></outer>");
			
			//action
			exception.expect(XPathException.class);
			exception.expectMessage("No node found matching XPath expression \"/does-not-exist\"");
			List<Node> children = XmlFileComparer.getChildNodes("/does-not-exist", input);
			
			//no tests
		}
	}		
	
	
	public static class SmokeTests extends TestCase {
		@Test
		public void smoke_test_with_zero_differences() {
			String xml1 = "<outer><inner1/></outer>";
			String xml2 = "<outer><inner1/></outer>";
			expMsgs = new String[] {
					"DEBUG: left-file, right-file: Comparing using XmlFileComparer",
					"INFO: left-file, right-file: Files are identical",
			};
					
			
			XmlFileComparer obj = new XmlFileComparer(xml1, xml2, actMsgs);
			int ndiffs = obj.compare();
			assertEquals(0, ndiffs);
		}
	
		@Test
		public void smoke_test_with_one_difference() {
			String xml1 = "<outer><inner1/></outer>";
			String xml2 = "<outer><inner2/></outer>";
			expMsgs = new String[] {
					"DEBUG: left-file, right-file: Comparing using XmlFileComparer",
					"INFO: left-file, right-file: Files differ",
					"ERROR: left-file(/outer[1]/inner1[1]), right-file(): missing element: \"inner1\"",
					"ERROR: left-file(), right-file(/outer[1]/inner2[1]): extra element: \"inner2\"",
			};
	
			
			XmlFileComparer obj = new XmlFileComparer(xml1, xml2, actMsgs);
			int ndiffs = obj.compare();
			assertEquals(1, ndiffs);
		}
	
		@Test
		public void smoke_test_with_xml_error() {
			String xml1 = "<outer><inner1></outer>";
			String xml2 = "<outer><inner1></outer>";
			expMsgs = new String[] {
					"DEBUG: left-file, right-file: Comparing using XmlFileComparer",
					"ERROR: left-file, (none): XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".", 
					"ERROR: (none), right-file: XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".",
			};
					
			XmlFileComparer obj = new XmlFileComparer(xml1, xml2, actMsgs);
			int ndiffs = obj.compare();
		
			assertEquals(1, ndiffs);
		}
		
		@Test
		public void smoke_test_using_Files() {
			File f1 = getResourceAsFile("disk-based-file-smoke-test/left-input/AAAA_AA111111CA.mif");
			File f2 = getResourceAsFile("disk-based-file-smoke-test/right-input/AAAA_AA111111CA.mif");

			expMsgs = new String[] {
					"DEBUG: " + f1.toString() + ", " + f2.toString() + ": Comparing using XmlFileComparer",
					"INFO: " + f1.toString() + ", " + f2.toString() + ": Files differ",
					"ERROR: " + f1.toString() + "(/outer[1]/left-element[1]), " + f2.toString() + "(): missing element: \"left-element\"",
					"ERROR: " + f1.toString() + "(), " + f2.toString() + "(/outer[1]/right-element[1]): extra element: \"right-element\"",
			};
	
			
			XmlFileComparer obj = new XmlFileComparer(f1, f2, actMsgs);
			int ndiffs = obj.compare();
			assertEquals(1, ndiffs);
		}
		
		@Test
		public void smoke_test_using_MifFiles() {
			File f1 = getResourceAsFile("disk-based-file-smoke-test/left-input/AAAA_AA111111CA.mif");
			File f2 = getResourceAsFile("disk-based-file-smoke-test/right-input/AAAA_AA111111CA.mif");

			expMsgs = new String[] {
					"DEBUG: " + f1.toString() + ", " + f2.toString() + ": Comparing using XmlFileComparer",
					"INFO: " + f1.toString() + ", " + f2.toString() + ": Files differ",
					"ERROR: " + f1.toString() + "(/outer[1]/left-element[1]), " + f2.toString() + "(): missing element: \"left-element\"",
					"ERROR: " + f1.toString() + "(), " + f2.toString() + "(/outer[1]/right-element[1]): extra element: \"right-element\"",
			};
	
			
			XmlFileComparer obj = new XmlFileComparer(new MifFile(f1), new MifFile(f2), actMsgs);
			int ndiffs = obj.compare();
			assertEquals(1, ndiffs);
		}
	
	}
	
	
	@RunWith(Parameterized.class)
	public static class XmlDifferenceTypes {
		String testName;			// JUnit doesn't use this; it's here purely as a (debugger-visible) comment
		String xml1;
		String xml2;
		int expNumDiffs;
		Message[] expMsgs;

		@Parameters
		public static Collection<Object[]> getParameters() {
			/*
			 * Each element of the outer array contains the data for a test case.
			 * Its contents are, in order:
			 *		- test-case name
			 *		- the two XML strings to be compared
			 *		- Number of differences that XmlFileComparer.compare() should report
			 *		- Array of expected Message objects
			 *
			 * N.B.: These tests filter out and ignore DEBUG-level output.
			 */
			return Arrays.asList(new Object[][] {
					{
						"no differences",

						"<outer><inner1/></outer>",
						"<outer><inner1/></outer>",
		
						0,
		
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},

					{
						"only insignificant whitespace differences",

						"<outer><inner1/></outer>",
						"<outer>\n\t<inner1/>   \n</outer>\n",
		
						0,
		
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},

//					{
//						//FIXME "significant whitespace differences" test disabled until I'm ready to implement a fix.
//						//		The problem is that we call XMLUnit.setIgnoreWhitespace(true) in order to ignore formatting
//						//		differences -- that's what allows the "only insignificant whitespace differences" test (above)
//						//		to pass.
//						//		But that also causes text nodes to get leading and trailing whitespace trimmed, which
//						//		causes *this* test to fail.
//						"significant whitespace differences",
//
//						"<outer>test</outer>",
//						"<outer> test </outer>\n",
//		
//						1,
//		
//						"" +
//							"ERROR: left-file(/outer[1]/text()[1]), right-file(/outer[1]/text()[1]): Expected text value \"test\", but got \" test \"" + NEWLINE +
//							"INFO: left-file, right-file: Files differ" + NEWLINE +
//							"",
//		
//						MessageList.CSV_HEADER + NEWLINE +
//							"ERROR,XML_DIFFERENCE,text value,left-file,right-file,/outer[1]/text()[1],/outer[1]/text()[1],text,,value,test, test " + NEWLINE +
//							"INFO,FILE_SUMMARY,Files differ,left-file,right-file,,,,,,," + NEWLINE,
//		
//						new Message[] {
//							new Message(ERROR, XML_DIFFERENCE, "For text, expected \"test\", but got \" test \"", new File("left-file"), new File("right-file"), "/outer[1]/text()[1]", "/outer[1]/text()[1]", TEXT, null, VALUE, "test", " test "),
//							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
//					},

					{
						// These are ignored only with XMLUnit.setIgnoreComments(true)
						"comments within the Document element",

						"<outer><!-- comment in the first input --><inner1/></outer>",
						"<outer>\n\t<inner1/><!-- and a comment in the second input--></outer>\n",
		
						0,
		
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},

					{
						// These are ignored regardless of the state of XMLUnit.ignoreComments
						"comments outside the Document element",

						"<!-- comment at start --><outer><inner1/></outer>",
						"<outer>\n\t<inner1/></outer>\n<!-- comment at end -->",
		
						0,
		
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"xml parse error",
	
						"<outer><inner1></outer>",
						"<outer><inner1></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_ERROR, "XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".", new File("left-file"), null, null, null, null, null, null, null, null),
							new Message(ERROR, XML_ERROR, "XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".", null, new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- no differences",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",
	
						0,
	
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- same namespace, different local name",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:b/></x:outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"x:a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "x:a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"x:b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "x:b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- different namespace, same local name",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"x:a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "x:a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"y:a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "y:a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- same local name, same namespace, different prefix",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:z='http://test.example.com/ns/y'><z:a/></x:outer>",
	
						0,
	
						new Message[] {
							new Message(TRIVIAL, XML_DIFFERENCE, "For namespace prefix, expected \"y\", but got \"z\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", "/outer[1]/a[1]", NAMESPACE_PREFIX, null, VALUE, "y", "z"),
							new Message(INFO, FILE_SUMMARY, "Files are similar", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- same local name, same namespace, default vs. explicit prefix defined in outer element",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns='http://test.example.com/ns/y'><a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",
	
						0,
	
						new Message[] {
							new Message(TRIVIAL, XML_DIFFERENCE, "For namespace prefix, expected \"null\", but got \"y\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", "/outer[1]/a[1]", NAMESPACE_PREFIX, null, VALUE, "null", "y"),
							new Message(INFO, FILE_SUMMARY, "Files are similar", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- same local name, same namespace, default vs. explicit prefix defined in inner element",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x'><a     xmlns='http://test.example.com/ns/y'/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><y:a xmlns:y='http://test.example.com/ns/y'/></x:outer>",
	
						0,
	
						new Message[] {
							new Message(TRIVIAL, XML_DIFFERENCE, "For namespace prefix, expected \"null\", but got \"y\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", "/outer[1]/a[1]", NAMESPACE_PREFIX, null, VALUE, "null", "y"),
							new Message(INFO, FILE_SUMMARY, "Files are similar", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- elements () vs. (a, b)",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x'>            </x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/><x:b/></x:outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"x:a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "x:a", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"x:b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "x:b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"namespaces -- elements (a, b) vs. ()",
	
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/><x:b/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'>            </x:outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"x:a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "x:a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"x:b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "x:b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"element names -- (a) vs. (b)",
	
						"<outer><a/></outer>",
						"<outer><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element names -- (b) vs. (a)",
	
						"<outer><b/></outer>",
						"<outer><a/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element names (a, b) vs. (b, a)",
	
						"<outer><a/><b/></outer>",
						"<outer><b/><a/></outer>",
	
						0,
	
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are similar", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element names (b, a) vs. (a, b)",
	
						"<outer><b/><a/></outer>",
						"<outer><a/><b/></outer>",
	
						0,
	
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are similar", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (a, b) vs. (a)",

						"<outer><a/><b/></outer>",
						"<outer><a/>    </outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (a) vs. (a, b)",
	
						"<outer><a/>    </outer>",
						"<outer><a/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (a, b) vs. (b)",
	
						"<outer><a/><b/></outer>",
						"<outer>    <b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (b) vs. (a, b)",
	
						"<outer>    <b/></outer>",
						"<outer><a/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},

					{
						"element missing -- (a, a, b) vs. (b)",
	
						"<outer><a/><a/><b/></outer>",
						"<outer>        <b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[2]", null, ELEMENT, "a", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (b) vs. (a, a, b)",
	
						"<outer>        <b/></outer>",
						"<outer><a/><a/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[2]", ELEMENT, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},

					{
						"element missing -- (b, a) vs. (a)",

						"<outer><b/><a/></outer>",
						"<outer><a/>    </outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (a) vs. (b, a)",
	
						"<outer><a/>    </outer>",
						"<outer><b/><a/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
	
					{
						"element missing -- (b, a) vs. (b)",
	
						"<outer><b/><a/></outer>",
						"<outer>    <b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element missing -- (b) vs. (b, a)",
	
						"<outer>    <b/></outer>",
						"<outer><b/><a/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"elements missing -- () vs. (a, b)",
	
						"<outer>        </outer>",
						"<outer><a/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"elements missing -- (a, b) vs. ()",
	
						"<outer><a/><b/></outer>",
						"<outer>        </outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"elements missing -- () vs. (a, b, c, b)",
	
						"<outer>                </outer>",
						"<outer><a/><b/><c/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/outer[1]/a[1]", ELEMENT, "a", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"c\"", new File("left-file"), new File("right-file"), null, "/outer[1]/c[1]", ELEMENT, "c", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[2]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"elements missing -- (a, b, c, b) vs. ()",
	
						"<outer><a/><b/><c/><b/></outer>",
						"<outer>                </outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]", null, ELEMENT, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"c\"", new File("left-file"), new File("right-file"), "/outer[1]/c[1]", null, ELEMENT, "c", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[2]", null, ELEMENT, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"element missing -- (a, b, b) vs. (a)",

						"<outer><a/><b/><b/></outer>",
						"<outer><a/>        </outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[1]", null, ELEMENT, "b", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing element: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/b[2]", null, ELEMENT, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"element extra -- (a) vs. (a, b, b)",
	
						"<outer><a/>        </outer>",
						"<outer><a/><b/><b/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[1]", ELEMENT, "b", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra element: \"b\"", new File("left-file"), new File("right-file"), null, "/outer[1]/b[2]", ELEMENT, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
										
					{
						// Default behaviour is to compare the <a/> attrs pairwise in order of occurrence in the file,
						// WITHOUT trying to pair up elements with the corresponding attribute values:
						// (left a[0] vs. right a[0]), then (left a[1] vs. right a[1]).
						//
						// This behaviour can be modified using an XMLUnit ElementQualifier. E.g. using an
						// ElementNameAndAttributeQualifier should, in theory, cause this test to compare
						// (left a[0] vs. right a[1]), then (left a[1] vs. right a[0]), and so to report "Files are similar",
						// but I haven't tried that.
						
						"element attributes -- (a@x, a@y) vs. (a@y, a@x)",
	
						"<outer><a attr='x'/><a attr='y'/></outer>",
						"<outer><a attr='y'/><a attr='x'/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "For attribute \"attr\", expected \"x\", but got \"y\"", new File("left-file"), new File("right-file"), "/outer[1]/a[1]/@attr", "/outer[1]/a[1]/@attr", ATTRIBUTE, "attr", VALUE, "x", "y"),
							new Message(ERROR, XML_DIFFERENCE, "For attribute \"attr\", expected \"y\", but got \"x\"", new File("left-file"), new File("right-file"), "/outer[1]/a[2]/@attr", "/outer[1]/a[2]/@attr", ATTRIBUTE, "attr", VALUE, "y", "x"),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),

						},
					},
	
					{
						"attribute names (a) vs. (b)",
	
						"<outer><inner a=\"aval\"/></outer>",
						"<outer><inner b=\"bval\"/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},	
					
					{
						"attribute names (b) vs. (a)",
	
						"<outer><inner b=\"bval\"/></outer>",
						"<outer><inner a=\"aval\"/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute names -- (a, b) vs. (b, a)",
	
						"<outer><inner attrA=\"Aval\" attrB=\"Bval\"/></outer>",
						"<outer><inner attrB=\"Bval\" attrA=\"Aval\"/></outer>",
	
						0,
	
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute names -- (b, a) vs. (a, b)",
	
						"<outer><inner attrB=\"Bval\" attrA=\"Aval\"/></outer>",
						"<outer><inner attrA=\"Aval\" attrB=\"Bval\"/></outer>",
	
						0,
	
						new Message[] {
							new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (a, b) vs. (a)",
	
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
						"<outer><inner a=\"aval\"/>				</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (a) vs. (a, b)",
	
						"<outer><inner a=\"aval\"/>				</outer>",
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
	
					{
						"attribute missing -- (a, b) vs. (b)",
	
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
						"<outer><inner            b=\"bval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (b) vs. (a, b)",
	
						"<outer><inner            b=\"bval\"/>	</outer>",
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (b, a) vs. (a)",
	
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
						"<outer><inner a=\"aval\"/>				</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (a) vs. (b, a)",
	
						"<outer><inner a=\"aval\"/>				</outer>",
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
	
					{
						"attribute missing -- (b, a) vs. (b)",
	
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
						"<outer><inner            b=\"bval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (b) vs. (b, a)",
	
						"<outer><inner            b=\"bval\"/>	</outer>",
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]", "/outer[1]/inner[1]", ATTRIBUTE, "a", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- () vs. (a, b)",
	
						"<outer                      />",
						"<outer a=\"aval\" b=\"bval\"/>",
	
						1,
						
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]", "/outer[1]", ATTRIBUTE, "a", EXTRA, null, null),
							new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]", "/outer[1]", ATTRIBUTE, "b", EXTRA, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute missing -- (a, b) vs. ()",
	
						"<outer a=\"aval\" b=\"bval\"/>",
						"<outer                      />",
	
						1,
						
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"a\"", new File("left-file"), new File("right-file"), "/outer[1]", "/outer[1]", ATTRIBUTE, "a", MISSING, null, null),
							new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"b\"", new File("left-file"), new File("right-file"), "/outer[1]", "/outer[1]", ATTRIBUTE, "b", MISSING, null, null),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
	
					{
						"attribute value",
	
						"<outer><inner attr=\"leftVal\"/></outer>",
						"<outer><inner attr=\"rightVal\"/></outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "For attribute \"attr\", expected \"leftVal\", but got \"rightVal\"", new File("left-file"), new File("right-file"), "/outer[1]/inner[1]/@attr", "/outer[1]/inner[1]/@attr", ATTRIBUTE, "attr", VALUE, "leftVal", "rightVal"),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},
					
					{
						"text value",
	
						"<outer>the left text</outer>",
						"<outer>the right text</outer>",
	
						1,
	
						new Message[] {
							new Message(ERROR, XML_DIFFERENCE, "For text, expected \"the left text\", but got \"the right text\"", new File("left-file"), new File("right-file"), "/outer[1]/text()[1]", "/outer[1]/text()[1]", TEXT, null, VALUE, "the left text", "the right text"),
							new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
						},
					},	
			});
		}
		
		public XmlDifferenceTypes(String testName, String xml1, String xml2, int expNumDiffs, Message[] expMsgs) {
			this.testName = testName;
			this.xml1 = xml1;
			this.xml2 = xml2;
			this.expNumDiffs = expNumDiffs;
			this.expMsgs = expMsgs;
		}

		@Test
		public void test_Message_objects() {
			System.out.println(testName);
			
			MessageList actMsgList = new MessageList();
			XmlFileComparer obj = new XmlFileComparer(xml1, xml2, actMsgList);
			int ndiffs = obj.compare();
		
			/*
			 * Convert each message list to a string and compare those.
			 * Pro: if they mismatch, Eclipse can display the differences.
			 * Con: depends on Message.toString() to include *all* fields in its result
			 *      (and to distinguish between "" and null where necessary).
			 */
			List<Message> actMsgs = actMsgList.getMessages(INFO);
			String expString = messagesToSortedString(Arrays.asList(expMsgs));
			String actString = messagesToSortedString(actMsgs);
			assertEquals(expString, actString);

			assertEquals(expNumDiffs, ndiffs);
		}
	}
}
