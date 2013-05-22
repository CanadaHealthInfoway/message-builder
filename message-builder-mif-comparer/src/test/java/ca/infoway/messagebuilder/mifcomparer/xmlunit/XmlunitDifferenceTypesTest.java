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

package ca.infoway.messagebuilder.mifcomparer.xmlunit;

import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.*;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.junit.Rule;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Tests that XmlUnit produces the expected {@link org.custommonkey.xmlunit.Difference}
 * types for various inputs.
 *
 * <p>This is half-way between:<ul>
 *		<li>an "enemy test" of XmlUnit, because its purpose is to test
 *		XmlUnit's response to various inputs, and
 *
 *		<li>a unit test of {@link XmlunitAdapter}, because the "input" consists
 *		not only of XML, but also .the specific XmlUnit configuration that
 *		we're using
 *	</ul>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({XmlunitDifferenceTypesTest.UtilityTests.class, XmlunitDifferenceTypesTest.DifferenceTypesTestInner.class})
public class XmlunitDifferenceTypesTest {
	@RunWith(Parameterized.class)
	public static class DifferenceTypesTestInner {
		private static final String NEWLINE = System.getProperty("line.separator");

		String testName;			// JUnit doesn't use this; it's here purely as a (debugger-visible) comment
		String xml1;
		String xml2;
		boolean expIsIdentical;
		boolean expIsSimilar;
		Difference[] expDiffs;

		/*
		 * Among other things, this set of tests exercises the generation of all of XmlUnit 1.5alpha's
		 * Difference types, except for the following:
		 *
		 *	 - Ignored in our configuration:
		 *			COMMENT_VALUE
		 *
		 *	 - Can only be generated when validating against an XML schema:
		 *			ATTR_VALUE_EXPLICITLY_SPECIFIED
		 *
		 *   - Omitted because I don't know how to provoke XmlUnit to generate them (perhaps a different configuration:
		 *	   would be needed):
		 *			ELEMENT_TAG_NAME
		 *			NAMESPACE_URI
		 *			NODE_TYPE
		 *			CDATA_VALUE
		 *
		 *	 - Omitted because I don't undertand doctype declarations, and since the MIFs don't appear to use them,
		 *	   there seems little benefit to my learning about them for this purpose:
		 *			DOCTYPE_NAME
		 *			DOCTYPE_PUBLIC_ID
		 *			DOCTYPE_SYSTEM_ID
		 *			HAS_DOCTYPE_DECLARATION
		 */
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
		
						true, true,
		
						new Difference[] {
						},
					},

					{
						"only insignificant whitespace differences",

						"<outer><inner1/></outer>",
						"<outer>\n\t<inner1/>   \n</outer>\n",
		
						true, true,
		
						new Difference[] {
						},
					},

	//				{
	//					//FIXME "significant whitespace differences" test disabled until I'm ready to implement a fix.
	//					//		The problem is that we call XMLUnit.setIgnoreWhitespace(true) in order to ignore formatting
	//					//		differences -- that's what allows the "only insignificant whitespace differences" test (above)
	//					//		to pass.
	//					//		But that also causes text nodes to get leading and trailing whitespace trimmed, which
	//					//		causes *this* test to fail.
	//					"significant whitespace differences",
	//
	//					"<outer>test</outer>",
	//					"<outer> test </outer>\n",
	//	
	//					1,
	//	
	//					"" +
	//						"ERROR: left-file(/outer[1]/text()[1]), right-file(/outer[1]/text()[1]): Expected text value \"test\", but got \" test \"" + NEWLINE +
	//						"INFO: left-file, right-file: Files differ" + NEWLINE +
	//						"",
	//	
	//					MessageList.CSV_HEADER + NEWLINE +
	//						"ERROR,XML_DIFFERENCE,text value,left-file,right-file,/outer[1]/text()[1],/outer[1]/text()[1],text,,value,test, test " + NEWLINE +
	//						"INFO,FILE_SUMMARY,Files differ,left-file,right-file,,,,,,," + NEWLINE,
	//	
	//					new Difference[] {
	//						//new Message(ERROR, XML_DIFFERENCE, "For text, expected \"test\", but got \" test \"", new File("left-file"), new File("right-file"), "/outer[1]/text()[1]", "/outer[1]/text()[1]", TEXT, null, VALUE, "test", " test "),
	//						//new Message(INFO, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),
	//				},

					{
						// These are ignored only with XMLUnit.setIgnoreComments(true)
						"comments within the Document element",

						"<outer><!-- comment in the first input --><inner1/></outer>",
						"<outer>\n\t<inner1/><!-- and a comment in the second input--></outer>\n",
		
						true, true,
		
						new Difference[] {
							// N.B. Because of this, DifferenceConstants.COMMENT_VALUE should never be produced
						},
					},

					{
						// These are ignored regardless of the state of XMLUnit.ignoreComments
						"comments outside the Document element",

						"<!-- comment at start --><outer><inner1/></outer>",
						"<outer>\n\t<inner1/></outer>\n<!-- comment at end -->",
		
						true, true,
		
						new Difference[] {
						},
					},
					
					{
						"namespaces -- no differences",

						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",

						true, true,

						new Difference[] {
						},
					},
					
					{
						"namespaces -- same namespace, different local name",

						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:b/></x:outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"namespaces -- different namespace, same local name",

						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><x:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"namespaces -- same local name, same namespace, different prefix",

						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:z='http://test.example.com/ns/y'><z:a/></x:outer>",

						false, true,

						new Difference[] {
							DifferenceConstants.NAMESPACE_PREFIX,
						},
					},
					
					{
						"namespaces -- same local name, same namespace, default vs. explicit prefix defined in outer element",

						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns='http://test.example.com/ns/y'><a/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x' xmlns:y='http://test.example.com/ns/y'><y:a/></x:outer>",

						false, true,

						new Difference[] {
							DifferenceConstants.NAMESPACE_PREFIX,
						},
					},
					
					{
						"namespaces -- same local name, same namespace, default vs. explicit prefix defined in inner element",

						"<x:outer xmlns:x='http://test.example.com/ns/x'><a     xmlns='http://test.example.com/ns/y'/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><y:a xmlns:y='http://test.example.com/ns/y'/></x:outer>",

						false, true,

						new Difference[] {
							DifferenceConstants.NAMESPACE_PREFIX,
						},
					},
					
					{
						"namespaces -- elements () vs. (a, b)",

						"<x:outer xmlns:x='http://test.example.com/ns/x'>            </x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/><x:b/></x:outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"namespaces -- elements (a, b) vs. ()",

						"<x:outer xmlns:x='http://test.example.com/ns/x'><x:a/><x:b/></x:outer>",
						"<x:outer xmlns:x='http://test.example.com/ns/x'>            </x:outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"element names -- (a) vs. (b)",

						"<outer><a/></outer>",
						"<outer><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"element names -- (b) vs. (a)",

						"<outer><b/></outer>",
						"<outer><a/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"element names (a, b) vs. (b, a)",

						"<outer><a/><b/></outer>",
						"<outer><b/><a/></outer>",

						false, true,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element names (b, a) vs. (a, b)",

						"<outer><b/><a/></outer>",
						"<outer><a/><b/></outer>",

						false, true,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (a, b) vs. (a)",

						"<outer><a/><b/></outer>",
						"<outer><a/>    </outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"element missing -- (a) vs. (a, b)",

						"<outer><a/>    </outer>",
						"<outer><a/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"element missing -- (a, b) vs. (b)",

						"<outer><a/><b/></outer>",
						"<outer>    <b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (b) vs. (a, b)",

						"<outer>    <b/></outer>",
						"<outer><a/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (a, a, b) vs. (b)",

						"<outer><a/><a/><b/></outer>",
						"<outer>        <b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (b) vs. (a, a, b)",

						"<outer>        <b/></outer>",
						"<outer><a/><a/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (b, a) vs. (a)",

						"<outer><b/><a/></outer>",
						"<outer><a/>    </outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (a) vs. (b, a)",

						"<outer><a/>    </outer>",
						"<outer><b/><a/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},


					{
						"element missing -- (b, a) vs. (b)",

						"<outer><b/><a/></outer>",
						"<outer>    <b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						//	DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"element missing -- (b) vs. (b, a)",

						"<outer>    <b/></outer>",
						"<outer><b/><a/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						//	DifferenceConstants.CHILD_NODELIST_SEQUENCE,
						},
					},

					{
						"elements missing -- () vs. (a, b)",

						"<outer>        </outer>",
						"<outer><a/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"elements missing -- (a, b) vs. ()",

						"<outer><a/><b/></outer>",
						"<outer>        </outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"elements missing -- () vs. (a, b, c, b)",

						"<outer>                </outer>",
						"<outer><a/><b/><c/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"elements missing -- (a, b, c, b) vs. ()",

						"<outer><a/><b/><c/><b/></outer>",
						"<outer>                </outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},
					
					{
						"element missing -- (a, b, b) vs. (a)",

						"<outer><a/><b/><b/></outer>",
						"<outer><a/>        </outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},

					{
						"element extra -- (a) vs. (a, b, b)",

						"<outer><a/>        </outer>",
						"<outer><a/><b/><b/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
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

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_VALUE,
							DifferenceConstants.ATTR_VALUE,
						},
					},

					{
						"attribute names (a) vs. (b)",

						"<outer><inner a=\"aval\"/></outer>",
						"<outer><inner b=\"bval\"/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
						},
					},	
					
					{
						"attribute names (b) vs. (a)",

						"<outer><inner b=\"bval\"/></outer>",
						"<outer><inner a=\"aval\"/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
						},
					},

					{
						"attribute names -- (a, b) vs. (b, a)",

						"<outer><inner attrA=\"Aval\" attrB=\"Bval\"/></outer>",
						"<outer><inner attrB=\"Bval\" attrA=\"Aval\"/></outer>",

						true, true,

						new Difference[] {
						},
					},

					{
						"attribute names -- (b, a) vs. (a, b)",

						"<outer><inner attrB=\"Bval\" attrA=\"Aval\"/></outer>",
						"<outer><inner attrA=\"Aval\" attrB=\"Bval\"/></outer>",

						true, true,

						new Difference[] {
						},
					},

					{
						"attribute missing -- (a, b) vs. (a)",

						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
						"<outer><inner a=\"aval\"/>				</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},

					{
						"attribute missing -- (a) vs. (a, b)",

						"<outer><inner a=\"aval\"/>				</outer>",
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},


					{
						"attribute missing -- (a, b) vs. (b)",

						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",
						"<outer><inner            b=\"bval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
							DifferenceConstants.ATTR_SEQUENCE,
						},
					},

					{
						"attribute missing -- (b) vs. (a, b)",

						"<outer><inner            b=\"bval\"/>	</outer>",
						"<outer><inner a=\"aval\" b=\"bval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
							DifferenceConstants.ATTR_SEQUENCE,
						},
					},

					{
						"attribute missing -- (b, a) vs. (a)",

						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
						"<outer><inner a=\"aval\"/>				</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},

					{
						"attribute missing -- (a) vs. (b, a)",

						"<outer><inner a=\"aval\"/>				</outer>",
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},


					{
						"attribute missing -- (b, a) vs. (b)",

						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",
						"<outer><inner            b=\"bval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
							DifferenceConstants.ATTR_SEQUENCE,
						},
					},

					{
						"attribute missing -- (b) vs. (b, a)",

						"<outer><inner            b=\"bval\"/>	</outer>",
						"<outer><inner b=\"bval\" a=\"aval\"/>	</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
							DifferenceConstants.ATTR_SEQUENCE,
						},
					},

					{
						"attribute missing -- () vs. (a, b)",

						"<outer                      />",
						"<outer a=\"aval\" b=\"bval\"/>",

						false, false,
						
						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},

					{
						"attribute missing -- (a, b) vs. ()",

						"<outer a=\"aval\" b=\"bval\"/>",
						"<outer                      />",

						false, false,
						
						new Difference[] {
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ATTR_NAME_NOT_FOUND,
							DifferenceConstants.ELEMENT_NUM_ATTRIBUTES,
						},
					},

					{
						"attribute value",

						"<outer><inner attr=\"leftVal\"/></outer>",
						"<outer><inner attr=\"rightVal\"/></outer>",

						false, false,

						new Difference[] {
						DifferenceConstants.ATTR_VALUE,
						},
					},
					
					{
						"text value",

						"<outer>the left text</outer>",
						"<outer>the right text</outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.TEXT_VALUE,
						},
					},	
					
					{
						"text vs. element",

						"<outer>the left text</outer>",
						"<outer><right-element/></outer>",

						false, false,

						new Difference[] {
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},	
					
					{
						"processing instruction -- target",

						"<foo><?leftTarget theValue?></foo>",
						"<foo><?rightTarget theValue?></foo>",

						false, false,

						new Difference[] {
							DifferenceConstants.PROCESSING_INSTRUCTION_TARGET,
						},
					},	
					
					{
						"processing instruction -- data",

						"<foo><?theTarget leftValue?></foo>",
						"<foo><?theTarget rightValue?></foo>",

						false, false,

						new Difference[] {
							DifferenceConstants.PROCESSING_INSTRUCTION_DATA,
						},
					},	
					
					{
						"processing instruction -- missing",

						"<foo><?theTarget theValue?></foo>",
						"<foo></foo>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},	
					
					{
						"processing instruction -- extra",

						"<foo></foo>",
						"<foo><?theTarget theValue?></foo>",

						false, false,

						new Difference[] {
							DifferenceConstants.HAS_CHILD_NODES,
							DifferenceConstants.CHILD_NODELIST_LENGTH,
							DifferenceConstants.CHILD_NODE_NOT_FOUND,
						},
					},	
					
					{
						"xsi:schemaLocation -- differ",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='left'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='right'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.SCHEMA_LOCATION,
						},
					},	
					
					{
						"xsi:schemaLocation -- extra",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='right'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.SCHEMA_LOCATION,
						},
					},	
					
					{
						"xsi:schemaLocation -- missing",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='left'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.SCHEMA_LOCATION,
						},
					},	
					
					{
						"xsi:noNamespaceSchemaLocation -- differ",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='left'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='right'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.NO_NAMESPACE_SCHEMA_LOCATION,
						},
					},	
					
					{
						"xsi:noNamespaceSchemaLocation -- extra",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='right'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.NO_NAMESPACE_SCHEMA_LOCATION,
						},
					},	
					
					{
						"xsi:noNamespaceSchemaLocation -- missing",

						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='left'/>",
						"<foo xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'/>",

						false, true,

						new Difference[] {
							DifferenceConstants.NO_NAMESPACE_SCHEMA_LOCATION,
						},
					},	
					
					// N.B.: The differing CDATA-ness should NOT produce any Difference's
					{
						"CDATA vs. not -- underlying values are identical",

						"<foo>" +
						"	<cdata-leftonly><![CDATA[text1]]></cdata-leftonly>" +
						"	<cdata-rightonly>text2</cdata-rightonly>" +
						"	<cdata-both><![CDATA[text3]]></cdata-both>" +
						"</foo>",

						"<foo>" +
						"	<cdata-leftonly>text1</cdata-leftonly>" +
						"	<cdata-rightonly><![CDATA[text2]]></cdata-rightonly>" +
						"	<cdata-both><![CDATA[text3]]></cdata-both>" +
						"</foo>",

						true, true,

						new Difference[] {
						},
					},	
					
					// N.B.: The differing CDATA-ness should NOT produce any Difference's
					{
						"CDATA vs. not -- underlying values differ",

						"<foo>" +
						"	<cdata-leftonly><![CDATA[left1]]></cdata-leftonly>" +
						"	<cdata-rightonly>left2</cdata-rightonly>" +
						"	<cdata-both><![CDATA[left3]]></cdata-both>" +
						"</foo>",

						"<foo>" +
						"	<cdata-leftonly>right1</cdata-leftonly>" +
						"	<cdata-rightonly><![CDATA[right2]]></cdata-rightonly>" +
						"	<cdata-both><![CDATA[right3]]></cdata-both>" +
						"</foo>",

						false, false,

						new Difference[] {
							// N.B.: *not* DifferenceConstants.CDATA_VALUE, which thus should never be produced
							DifferenceConstants.TEXT_VALUE,
							DifferenceConstants.TEXT_VALUE,
							DifferenceConstants.TEXT_VALUE,
						},
					},	
			});
		}
		
		public DifferenceTypesTestInner(String testName, String xml1, String xml2, boolean expIsIdentical, boolean expIsSimilar, Difference[] expDiffs) {
			this.testName = testName;
			this.xml1 = xml1;
			this.xml2 = xml2;
			this.expIsIdentical = expIsIdentical;
			this.expIsSimilar = expIsSimilar;
			this.expDiffs = expDiffs;
		}

		@Test
		public void test_compare() throws SAXException, IOException {
			System.out.println(testName);
			
			Document dom1 = xml2DOM(xml1);
			Document dom2 = xml2DOM(xml2);
			
			System.out.println(String.format("xml1 (text):%n%s%n     (DOM):%n%s%n", xml1, dom2XML(dom1)));
			System.out.println(String.format("xml2 (text):%n%s%n     (DOM):%n%s%n", xml2, dom2XML(dom2)));

			XmlunitAdapter obj = new XmlunitAdapter();
			XmlunitResult result = obj.compare(dom1, dom2);

			assertEquals("isIdentical", expIsIdentical, result.isIdentical());
			assertEquals("isSimilar", expIsSimilar, result.isSimilar());

			assertDifferenceListsEqual(Arrays.asList(expDiffs), result.getDifferences());
		}
	}


	public static void assertDifferenceListsEqual(List<Difference> expDiffs, List<Difference> actDiffs) {
		List<String> expStrs = new LinkedList<String>();
		List<String> actStrs = new LinkedList<String>();

		for (Difference d : expDiffs) {
			expStrs.add(String.format("%s(%d)", d.getDescription(), d.getId()));
		}

		for (Difference d : actDiffs) {
			actStrs.add(String.format("%s(%d)", d.getDescription(), d.getId()));
		}

		assertEqualsUnordered(expStrs, actStrs);
	}

	public static class UtilityTests {
		@Rule
		public ExpectedException exception = ExpectedException.none();

		@Test
		public void that_assertDifferenceListsEqual_passes_with_empty_lists() {
			Difference[] a = new Difference[] {
			};
			Difference[] b = new Difference[] {
			};

			assertDifferenceListsEqual(Arrays.asList(a), Arrays.asList(b));
		}

		@Test
		public void that_assertDifferenceListsEqual_passes_with_equal_lists() {
			Difference[] a = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
			};
			Difference[] b = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
			};

			assertDifferenceListsEqual(Arrays.asList(a), Arrays.asList(b));
		}

		@Test
		public void that_assertDifferenceListsEqual_fails_with_different_element_types() {
			Difference[] a = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
			};
			Difference[] b = new Difference[] {
				DifferenceConstants.HAS_CHILD_NODES,
			};

			exception.expect(AssertionError.class);
			exception.expectMessage("attribute value(3)");
			exception.expectMessage("presence of child nodes to be(18)");
			assertDifferenceListsEqual(Arrays.asList(a), Arrays.asList(b));
		}
		
		@Test
		public void that_assertDifferenceListsEqual_fails_with_duplicate_in_expected() {
			Difference[] a = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
				DifferenceConstants.ATTR_VALUE,
			};
			Difference[] b = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
			};

			exception.expect(AssertionError.class);
			exception.expectMessage("attribute value(3)");
			assertDifferenceListsEqual(Arrays.asList(a), Arrays.asList(b));
		}	
		
		@Test
		public void that_assertDifferenceListsEqual_fails_with_duplicate_in_actual() {
			Difference[] a = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
			};
			Difference[] b = new Difference[] {
				DifferenceConstants.ATTR_VALUE,
				DifferenceConstants.ATTR_VALUE,
			};

			exception.expect(AssertionError.class);
			exception.expectMessage("attribute value(3)");
			assertDifferenceListsEqual(Arrays.asList(a), Arrays.asList(b));
		}
	}
}
