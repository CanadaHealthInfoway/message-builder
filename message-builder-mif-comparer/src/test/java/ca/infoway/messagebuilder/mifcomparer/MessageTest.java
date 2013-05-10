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

import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.MISSING;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.VALUE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.TESTING_CODE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_DIFFERENCE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.ELEMENT;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.TEXT;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.INFO;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.WARNING;
import static ca.infoway.messagebuilder.mifcomparer.MessageStatistics.StatisticsGroup.*;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.mifcomparer.MessageStatistics.StatisticsGroup;
import ca.infoway.messagebuilder.mifcomparer.xmlunit.XmlunitState;

@RunWith(Suite.class)
@Suite.SuiteClasses({MessageTest.BasicTests.class, MessageTest.MessageFormattingTests.class})
public class MessageTest {
	public static class BasicTests {
		
		@Test
		public void fileseps() {
			File fs = new File("unix/file");
			File bs = new File("dos\\file");
			
			System.out.println("fs: " + fs.toString());
			System.out.println("bs: " + bs.toString());
		}

		@Test
		public void asText_if_first_File_is_null_then_it_prints_as_none() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", null, new File("rightfile"));
			
			assertEquals("WARNING: (none), rightfile: message", obj.asText());
		}
		
		@Test
		public void asText_if_second_File_is_null_then_it_prints_as_none() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), null);
			
			assertEquals("WARNING: leftfile, (none): message", obj.asText());
		}
		
		@Test
		public void asText_if_both_Files_are_null_then_neither_is_printed() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", (File)null, null);
			
			assertEquals("WARNING: message", obj.asText());
		}
		
		@Test
		public void asText_if_first_MifFile_is_null_then_it_prints_as_none() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", null, new MifFile(new File("AAAA_AA111111CA - right.mif")));
			
			assertEquals("WARNING: (none), AAAA_AA111111CA - right.mif: message", obj.asText());
		}
		
		@Test
		public void asText_if_second_MifFile_is_null_then_it_prints_as_none() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", new MifFile(new File("AAAA_AA111111CA - left.mif")), null);
			
			assertEquals("WARNING: AAAA_AA111111CA - left.mif, (none): message", obj.asText());
		}
		
		@Test
		public void asText_if_both_MifFiles_are_null_then_neither_is_printed() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", (MifFile)null, null);
			
			assertEquals("WARNING: message", obj.asText());
		}

		@Test
		public void asCSV_with_populated_files_xpaths_and_values() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile"), "/left/x/path", "/right/x/path", "leftvalue", "rightvalue");

			assertEquals("WARNING,TESTING_CODE,message,leftfile,rightfile,/left/x/path,/right/x/path,,,,leftvalue,rightvalue", obj.asCSV());
		}

		@Test
		public void asCSV_with_null_files_xpaths_and_values() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", (File)null, null, null, null, null, null);

			assertEquals("WARNING,TESTING_CODE,message,,,,,,,,,", obj.asCSV());
		}

		@Test
		public void asText_with_only_left_xpath_and_value() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile"), "/left/x/path", null, "leftvalue", null);

			assertEquals("WARNING: leftfile(/left/x/path), rightfile(): message", obj.asText());
		}

		@Test
		public void asText_with_only_right_xpath_and_value() {
			Message obj = new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile"), null, "/right/x/path", null, "rightvalue");

			assertEquals("WARNING: leftfile(), rightfile(/right/x/path): message", obj.asText());
		}
		
		@Test
		public void asCSV_with_quotes_in_message() {
			Message obj = new Message(WARNING, TESTING_CODE, "this contains \"quoted\" text", (File)null, null, null, null, null, null);

			assertEquals("WARNING,TESTING_CODE,\"this contains \"\"quoted\"\" text\",,,,,,,,,", obj.asCSV());
		}	
		
		@Test
		public void asCSV_with_LFs_in_message() {
			Message obj = new Message(WARNING, TESTING_CODE, "this\nis\nseveral\nlines\nlong", (File)null, null, null, null, null, null);

			assertEquals("WARNING,TESTING_CODE,\"this\nis\nseveral\nlines\nlong\",,,,,,,,,", obj.asCSV());
		}	
		
		@Test
		public void asCSV_with_CRLFs_in_message() {
			Message obj = new Message(WARNING, TESTING_CODE, "this\r\nis\r\nseveral\r\nlines\r\nlong", (File)null, null, null, null, null, null);

			assertEquals("WARNING,TESTING_CODE,\"this\nis\nseveral\nlines\nlong\",,,,,,,,,", obj.asCSV());
		}
		
	//	Severity sev, MessageType msgType, String msg, /*key,*/ File file1, File file2, String xpath1, String xpath2, ObjectType objType, String objName, DifferenceType diffType, String value1, String value2) {

		@Test
		public void asText_extra_element() {
			Message obj = new Message(ERROR, XML_DIFFERENCE, "message",
					null, null, null, null,
					ELEMENT, "foo", EXTRA,
					null, null);
			
			assertEquals("ERROR: message", obj.asText());
		}
		
		@Test
		public void asCSV_extra_element() {
			Message obj = new Message(ERROR, XML_DIFFERENCE, "message",
					null, null, null, null,
					ELEMENT, "foo", EXTRA,
					null, null);
			
			assertEquals("ERROR,XML_DIFFERENCE,message,,,,,ELEMENT,foo,EXTRA,,", obj.asCSV());
		}
		

		@Test
		public void asText_missing_element() {
			Message obj = new Message(ERROR, XML_DIFFERENCE, "message",
					null, null, null, null,
					ELEMENT, "foo", MISSING,
					null, null);
			
			assertEquals("ERROR: message", obj.asText());
		}
		
		@Test
		public void asCSV_missing_element() {
			Message obj = new Message(ERROR, XML_DIFFERENCE, "message",
					null, null, null, null,
					ELEMENT, "foo", MISSING,
					null, null);
			
			assertEquals("ERROR,XML_DIFFERENCE,message,,,,,ELEMENT,foo,MISSING,,", obj.asCSV());
		}
		
		@Test
		public void that_quoteCSV_with_value_appends_value() {
			StringBuilder sb = new StringBuilder();
			sb.append(Message.quoteCSV("the value", "the default"));
			
			assertEquals("the value", sb.toString());
		}
		
		@Test
		public void that_quoteCSV_without_value_appends_default() {
		
			StringBuilder sb = new StringBuilder();
			sb.append(Message.quoteCSV(null, "the default"));
			
			assertEquals("the default", sb.toString());
		}
		
		@Test
		public void that_two_arg_quoteCSV_without_value_appends_nothing() {
		
			StringBuilder sb = new StringBuilder();
			sb.append(Message.quoteCSV(sb, null));
			
			assertEquals("", sb.toString());
		}
			
		@Test
		public void that_accumulateMainStatistics_accumulates_correctly() {
			// Prepare
			Message msg = new Message(ERROR, XML_DIFFERENCE, "message",
					new File("left-file"), new File("right-file"),
					"/the[1]/x[3]/path[1]", "/the[1]/x[5]/path[1]",
					ELEMENT, "foo", EXTRA,
					null, "the-value");
			MessageStatistics stats = new MessageStatistics();
			
			// Perform
			msg.accumulateMainStatistics(stats);
			
			// Test
			MessageStatisticsTest.assertMainStatsContainOnly(stats, XML_DIFFS, "element (foo) extra", 1);
		}
		
				@Test
		public void that_accumulateXpathStatistics_accumulates_correctly() {
			// Prepare
			Message msg1 = new Message(ERROR, XML_DIFFERENCE, "message",
					new File("left-file"), new File("right-file"),
					"/the[1]/x[3]/path[1]", "/the[1]/x[5]/path[1]",
					ELEMENT, "foo", EXTRA,
					null, "the-value");
			Message msg2 = new Message(ERROR, XML_DIFFERENCE, "message",
					new File("left-file"), new File("right-file"),
					"/the[1]/x[47]/path[1]", "/the[1]/x[49]/path[1]",
					ELEMENT, "foo", EXTRA,
					null, "the-value");
			MessageStatistics stats = new MessageStatistics();
			
			// Perform
			msg1.accumulateXpathStatistics(stats);
			msg2.accumulateXpathStatistics(stats);
			
			// Test
			MessageStatisticsTest.assertXpathStatsContainOnly(stats, "/the[?]/x[?]/path[?]", 2);
		}
	}


	@RunWith(Parameterized.class)
	public static class MessageFormattingTests {
		String testName;			// JUnit doesn't use this; it's here purely as a (debugger-visible) comment
		Message inputMsg;
		StatisticsGroup expStatsGroup;
		String expStatsKey;
		String expXpathStatsKey;
		String expText;
		String expCSV;
		String expXML;

		@Parameters
		public static Collection<Object[]> getParameters() {
			/*
			 * Each element of the outer array contains the data for a test case.
			 * Its contents are, in order:
			 *		- test-case name
			 *		- Input message
			 *		- Expected StatisticsGroup
			 *		- Expected main-statistics key
			 *		- Expected xpath-statistics key
			 *		- Expected text-format output
			 *		- Expected CSV-format output
			 *		- Expected XML-format output
			 *
			 * N.B.: These tests filter out and ignore DEBUG-level output.
			 */
			return Arrays.asList(new Object[][] {
					{
						"Progress",

						new Message(DEBUG, PROGRESS, "Comparing using XmlFileComparer", new File("left-dir/left-file"), new File("right-dir/right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.OTHER, "(ignore)", null,

						"DEBUG: " + new File("left-dir/left-file") + ", " + new File("right-dir/right-file") + ": Comparing using XmlFileComparer",

						"DEBUG,PROGRESS,Comparing using XmlFileComparer," + new File("left-dir/left-file") + "," + new File("right-dir/right-file") + ",,,,,,,",

						"<file-pair-message message-type=\"progress\" severity=\"debug\">\n" +
						"	<expected-file>" + new File("left-dir/left-file") + "</expected-file>\n" +
						"	<actual-file>" + new File("right-dir/right-file") + "</actual-file>\n" +
						"	<message-text>Comparing using XmlFileComparer</message-text>\n" +
						"</file-pair-message>\n",
					},

					{
						"TESTING_CODE",

						new Message(DEBUG, TESTING_CODE, "Some text", new File("left-dir/left-file"), new File("right-dir/right-file")),

						StatisticsGroup.OTHER, "(ignore)", null,

						"DEBUG: " + new File("left-dir/left-file") + ", " + new File("right-dir/right-file") + ": Some text",

						"DEBUG,TESTING_CODE,Some text," + new File("left-dir/left-file") + "," + new File("right-dir/right-file") + ",,,,,,,",

						"<file-pair-message message-type=\"testing-code\" severity=\"debug\">\n" +
						"	<expected-file>" + new File("left-dir/left-file") + "</expected-file>\n" +
						"	<actual-file>" + new File("right-dir/right-file") + "</actual-file>\n" +
						"	<message-text>Some text</message-text>\n" +
						"</file-pair-message>\n",
					},

					{
						"Internal error on left",

						new Message(FATAL, INTERNAL_ERROR, "Error evaluating XPath expression \"/left/x/path\"", new File("left-dir/left-file"), null, "/left/x/path", null, null, null, null, null, null),

						StatisticsGroup.OTHER, "internal error", "/left/x/path",

						"FATAL: " + new File("left-dir/left-file") + "(/left/x/path), (none): Error evaluating XPath expression \"/left/x/path\"",

						"FATAL,INTERNAL_ERROR,\"Error evaluating XPath expression \"\"/left/x/path\"\"\"," + new File("left-dir/left-file") + ",,/left/x/path,,,,,,",

						"<file-message message-type=\"internal-error\" severity=\"fatal\">\n" +
						"	<file>" + new File("left-dir/left-file") + "</file>\n" +
						"	<xpath>/left/x/path</xpath>\n" +
						"	<value></value>\n" +
						"	<message-text>Error evaluating XPath expression \"/left/x/path\"</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Internal error on right",

						new Message(FATAL, INTERNAL_ERROR, "Error evaluating XPath expression \"/right/x/path\"", null, new File("right-dir/right-file"), null, "/right/x/path", null, null, null, null, null),

						StatisticsGroup.OTHER, "internal error", "/right/x/path",

						"FATAL: (none), " + new File("right-dir/right-file") + "(/right/x/path): Error evaluating XPath expression \"/right/x/path\"",

						"FATAL,INTERNAL_ERROR,\"Error evaluating XPath expression \"\"/right/x/path\"\"\",," + new File("right-dir/right-file") + ",,/right/x/path,,,,,",

						"<file-message message-type=\"internal-error\" severity=\"fatal\">\n" +
						"	<file>" + new File("right-dir/right-file") + "</file>\n" +
						"	<xpath>/right/x/path</xpath>\n" +
						"	<value></value>\n" +
						"	<message-text>Error evaluating XPath expression \"/right/x/path\"</message-text>\n" +
						"</file-message>\n",
					},

//					{
//						"Internal error on both",
//
//						new Message(FATAL, INTERNAL_ERROR, "message", new File("left-dir/left-file"), new File("right-dir/right-file"), "/left/x/path", "/right/x/path", null, null, null, null, null),
//
//						StatisticsGroup.OTHER, "internal error", null,
//
//						"FATAL: " + new File("left-dir/left-file") + "(/left/x/path), " + new File("right-dir/right-file") + "(/right/x/path): message",
//
//						"FATAL,INTERNAL_ERROR,message," + new File("left-dir/left-file") + "," + new File("right-dir/right-file") + ",/left/x/path,/right/x/path,,,,,",
//
//						"<internal-error severity=\"fatal\">\n" +
//						"	<expected-file>" + new File("left-dir/left-file") + "</expected-file>\n" +
//						"	<actual-file>" + new File("right-dir/right-file") + "</actual-file>\n" +
//						"	<expected-xpath>/left/x/path</expected-xpath>\n" +
//						"	<actual-xpath>/right/x/path</actual-xpath>\n" +
//						"	<expected-value></expected-value>\n" +
//						"	<actual-value></actual-value>\n" +
//						"	<message-text>message</message-text>\n" +
//						"</internal-error>\n",
//					},

					{
						"Unparseable filename",

						new Message(ERROR, UNRECOGNIZED_FILE_TYPE, "Unrecognized filename pattern: \"left-file\"", new File("left-dir/left-sub/left-file"), null),

						StatisticsGroup.PER_FILE, "unrecognized filename pattern", null,
						
						"ERROR: " + new File("left-dir/left-sub/left-file") + ", (none): Unrecognized filename pattern: \"left-file\"",

						"ERROR,UNRECOGNIZED_FILE_TYPE,\"Unrecognized filename pattern: \"\"left-file\"\"\"," + new File("left-dir/left-sub/left-file") + ",,,,,,,,",

						"<file-message message-type=\"unrecognized-file-type\" severity=\"error\">\n" +
						"	<file>" + new File("left-dir/left-sub/left-file") + "</file>\n" +
						"	<message-text>Unrecognized filename pattern: &quot;left-file&quot;</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Unpaired file on left",

						new Message(ERROR, UNPAIRED_FILE, "File occurs only in left-dir", new File("left-dir/left-sub/left-file"), null, null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "unpaired file", null,

						"ERROR: " + new File("left-dir/left-sub/left-file") + ", (none): File occurs only in left-dir",

						"ERROR,UNPAIRED_FILE,File occurs only in left-dir," + new File("left-dir/left-sub/left-file") + ",,,,,,,,",

						"<file-message message-type=\"unpaired-file\" severity=\"error\">\n" +
						"	<file>" + new File("left-dir/left-sub/left-file") + "</file>\n" +
						"	<message-text>File occurs only in left-dir</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Unpaired file on right",

						new Message(ERROR, UNPAIRED_FILE, "File occurs only in right-dir", null, new File("right-dir/right-sub/right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "unpaired file", null,

						"ERROR: (none), " + new File("right-dir/right-sub/right-file") + ": File occurs only in right-dir",

						"ERROR,UNPAIRED_FILE,File occurs only in right-dir,," + new File("right-dir/right-sub/right-file") + ",,,,,,,",

						"<file-message message-type=\"unpaired-file\" severity=\"error\">\n" +
						"	<file>" + new File("right-dir/right-sub/right-file") + "</file>\n" +
						"	<message-text>File occurs only in right-dir</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Ignored file on left",

						new Message(INFO, IGNORED_FILE, "Ignored coremif file", new File("left-dir/left-file"), null, null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "ignored file", null,

						"INFO: " + new File("left-dir/left-file").toString() + ", (none): Ignored coremif file",

						"INFO,IGNORED_FILE,Ignored coremif file," + new File("left-dir/left-file") + ",,,,,,,,",

						"<file-message message-type=\"ignored-file\" severity=\"info\">\n" +
						"	<file>" + new File("left-dir/left-file") + "</file>\n" +
						"	<message-text>Ignored coremif file</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Ignored file on right",

						new Message(INFO, IGNORED_FILE, "Ignored some extraneous file", null, new File("right-dir/right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "ignored file", null,

						"INFO: (none), " + new File("right-dir/right-file").toString() + ": Ignored some extraneous file",

						"INFO,IGNORED_FILE,Ignored some extraneous file,," + new File("right-dir/right-file") + ",,,,,,,",

						"<file-message message-type=\"ignored-file\" severity=\"info\">\n" +
						"	<file>" + new File("right-dir/right-file") + "</file>\n" +
						"	<message-text>Ignored some extraneous file</message-text>\n" +
						"</file-message>\n",
					},

					{
						"Descriptions differ",

						new Message(WARNING, DESCRIPTIONS_DIFFER, "For descriptive text in filename, expected \"left desc\", but got \"right desc\"", new File("left-dir/left-sub/AAAA_AA111111CA - left desc.mif"), new File("right-dir/right-sub/AAAA_AA111111CA - right desc.mif"), null, null, null, null, null, "left desc", "right desc"),

						StatisticsGroup.OTHER, "descriptions differ", null,

						"WARNING: " + new File("left-dir/left-sub/AAAA_AA111111CA - left desc.mif").toString() + ", " + new File("right-dir/right-sub/AAAA_AA111111CA - right desc.mif").toString() + ": For descriptive text in filename, expected \"left desc\", but got \"right desc\"",

						"WARNING,DESCRIPTIONS_DIFFER,\"For descriptive text in filename, expected \"\"left desc\"\", but got \"\"right desc\"\"\"," + new File("left-dir/left-sub/AAAA_AA111111CA - left desc.mif") + "," + new File("right-dir/right-sub/AAAA_AA111111CA - right desc.mif") + ",,,,,,left desc,right desc",

						"<difference severity=\"warning\" type=\"filename\" difference=\"descriptive-text\">\n" +
						"	<expected-file>" + new File("left-dir/left-sub/AAAA_AA111111CA - left desc.mif") + "</expected-file>\n" +
						"	<actual-file>" + new File("right-dir/right-sub/AAAA_AA111111CA - right desc.mif") + "</actual-file>\n" +
						"	<expected-value>left desc</expected-value>\n" +
						"	<actual-value>right desc</actual-value>\n" +
						"	<message-text>For descriptive text in filename, expected &quot;left desc&quot;, but got &quot;right desc&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"FILE_SUMMARY: INFO",

						new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "files are identical", null,

						"INFO: left-file, right-file: Files are identical",

						"INFO,FILE_SUMMARY,Files are identical,left-file,right-file,,,,,,,",
						
						"<file-pair-message message-type=\"file-summary\" severity=\"info\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <message-text>Files are identical</message-text>\n" +
						"</file-pair-message>\n",
					},

					{
						"XML_DIFFERENCE: text value difference (leading & trailing whitespace)",

						new Message(ERROR, XML_DIFFERENCE, "For text, expected \"test\", but got \" test \"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", TEXT, null, VALUE, "test", " test "),

						StatisticsGroup.XML_DIFFS, "text differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For text, expected \"test\", but got \" test \"",

						"ERROR,XML_DIFFERENCE,\"For text, expected \"\"test\"\", but got \"\" test \"\"\",left-file,right-file,/left/x/path,/right/x/path,TEXT,,VALUE,test, test ",

						"<difference severity=\"error\" type=\"text\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>test</expected-value>\n" +
						"    <actual-value> test </actual-value>\n" +
						"    <message-text>For text, expected \"test\", but got \" test \"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML parse error -- left side",

						new Message(ERROR, XML_ERROR, "XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".", new File("left-file"), null, null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "XML error", null,

						"ERROR: left-file, (none): XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".",

						"ERROR,XML_ERROR,\"XML error: 1:18: The element type \"\"inner1\"\" must be terminated by the matching end-tag \"\"</inner1>\"\".\",left-file,,,,,,,,",

						"<file-message message-type=\"xml-error\" severity=\"error\">\n" +
						"	<file>left-file</file>\n" +
						"	<message-text>XML error: 1:18: The element type &quot;inner1&quot; must be terminated by the matching end-tag &quot;&lt;/inner1&gt;&quot;.</message-text>\n" +
						"</file-message>\n",
					},

					{
						"XML parse error -- right side",

						new Message(ERROR, XML_ERROR, "XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".", null, new File("right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "XML error", null,

						"ERROR: (none), right-file: XML error: 1:18: The element type \"inner1\" must be terminated by the matching end-tag \"</inner1>\".",

						"ERROR,XML_ERROR,\"XML error: 1:18: The element type \"\"inner1\"\" must be terminated by the matching end-tag \"\"</inner1>\"\".\",,right-file,,,,,,,",

						"<file-message message-type=\"xml-error\" severity=\"error\">\n" +
						"	<file>right-file</file>\n" +
						"	<message-text>XML error: 1:18: The element type &quot;inner1&quot; must be terminated by the matching end-tag &quot;&lt;/inner1&gt;&quot;.</message-text>\n" +
						"</file-message>\n",
					},
					
					{
						"search-filter output",
						
						new Message(INFO, FILTER, "Found instance of \"//inner1\"", new File("the-file"), null, "/outer/mid1/inner1", null, null, null, null, null, null),

						StatisticsGroup.OTHER, "(ignore)", null,

						"INFO: the-file(/outer/mid1/inner1), (none): Found instance of \"//inner1\"",
						
						"INFO,FILTER,\"Found instance of \"\"//inner1\"\"\",the-file,,/outer/mid1/inner1,,,,,,",
						
						"<file-message message-type=\"filter\" severity=\"info\">\n" +
						"	<file>the-file</file>\n" +
						"   <xpath>/outer/mid1/inner1</xpath>\n" +
						"	<message-text>Found instance of &quot;//inner1&quot;</message-text>\n" +
						"</file-message>\n",
					},

					{
						"missing sort key",
						
						new Message(WARNING, FILTER, "An element matching \"/outer/mid/inner\" contains no \"sortKey\" attribute",
								new File("the-file"), null),

						StatisticsGroup.OTHER, "filter messages", null,

						"WARNING: the-file, (none): An element matching \"/outer/mid/inner\" contains no \"sortKey\" attribute",
						
						"WARNING,FILTER,\"An element matching \"\"/outer/mid/inner\"\" contains no \"\"sortKey\"\" attribute\",the-file,,,,,,,,",
						
						"<file-message message-type=\"filter\" severity=\"warning\">\n" +
						"	<file>the-file</file>\n" +
						"	<message-text>An element matching &quot;/outer/mid/inner&quot; contains no &quot;sortKey&quot; attribute</message-text>\n" +
						"</file-message>\n",
					},

					{
						"XML_DIFFERENCE: missing element",

						new Message(ERROR, XML_DIFFERENCE, "missing element: \"a\"", new File("left-file"), new File("right-file"), "/left/x/path", null, ELEMENT, "a", MISSING, null, null),

						StatisticsGroup.XML_DIFFS, "element (a) missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(): missing element: \"a\"",

						"ERROR,XML_DIFFERENCE,\"missing element: \"\"a\"\"\",left-file,right-file,/left/x/path,,ELEMENT,a,MISSING,,",

						"<difference severity=\"error\"  type=\"element\" name=\"a\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <message-text>missing element: \"a\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra element",

						new Message(ERROR, XML_DIFFERENCE, "extra element: \"a\"", new File("left-file"), new File("right-file"), null, "/right/x/path", ELEMENT, "a", EXTRA, null, null),

						StatisticsGroup.XML_DIFFS, "element (a) extra", "/right/x/path",

						"ERROR: left-file(), right-file(/right/x/path): extra element: \"a\"",

						"ERROR,XML_DIFFERENCE,\"extra element: \"\"a\"\"\",left-file,right-file,,/right/x/path,ELEMENT,a,EXTRA,,",

						"<difference severity=\"error\"  type=\"element\" name=\"a\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <message-text>extra element: \"a\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"FILE_SUMMARY: ERROR",

						new Message(ERROR, FILE_SUMMARY, "Files differ", new File("left-file"), new File("right-file"), null, null, null, null, null, null, null),

						StatisticsGroup.PER_FILE, "files differ", null,

						"ERROR: left-file, right-file: Files differ",

						"ERROR,FILE_SUMMARY,Files differ,left-file,right-file,,,,,,,",

						"<file-pair-message message-type=\"file-summary\" severity=\"error\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <message-text>Files differ</message-text>\n" +
						"</file-pair-message>\n",
					},

					{
						"XML_DIFFERENCE: missing attribute",

						new Message(ERROR, XML_DIFFERENCE, "missing attribute: \"a\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", ATTRIBUTE, "a", MISSING, "left-value", null),

						StatisticsGroup.XML_DIFFS, "attribute (a) missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): missing attribute: \"a\"",

						"ERROR,XML_DIFFERENCE,\"missing attribute: \"\"a\"\"\",left-file,right-file,/left/x/path,/right/x/path,ATTRIBUTE,a,MISSING,left-value,",

						"<difference severity=\"error\" type=\"attribute\" name=\"a\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value></actual-value>\n" +
						"    <message-text>missing attribute: \"a\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra attribute",

						new Message(ERROR, XML_DIFFERENCE, "extra attribute: \"a\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", ATTRIBUTE, "a", EXTRA, null, "right-value"),

						StatisticsGroup.XML_DIFFS, "attribute (a) extra", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): extra attribute: \"a\"",

						"ERROR,XML_DIFFERENCE,\"extra attribute: \"\"a\"\"\",left-file,right-file,/left/x/path,/right/x/path,ATTRIBUTE,a,EXTRA,,right-value",

						"<difference severity=\"error\" type=\"attribute\" name=\"a\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value></expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>extra attribute: \"a\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: attribute value difference",

						new Message(ERROR, XML_DIFFERENCE, "For attribute \"attr\", expected \"leftVal\", but got \"rightVal\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", ATTRIBUTE, "attr", VALUE, "leftVal", "rightVal"),

						StatisticsGroup.XML_DIFFS, "attribute (attr) differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For attribute \"attr\", expected \"leftVal\", but got \"rightVal\"",

						"ERROR,XML_DIFFERENCE,\"For attribute \"\"attr\"\", expected \"\"leftVal\"\", but got \"\"rightVal\"\"\",left-file,right-file,/left/x/path,/right/x/path,ATTRIBUTE,attr,VALUE,leftVal,rightVal",

						"<difference severity=\"error\" type=\"attribute\" name=\"attr\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>leftVal</expected-value>\n" +
						"    <actual-value>rightVal</actual-value>\n" +
						"    <message-text>For attribute \"attr\", expected \"leftVal\", but got \"rightVal\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: missing text value",

						new Message(ERROR, XML_DIFFERENCE, "missing text: \"left-value\"", new File("left-file"), new File("right-file"), "/left/x/path", null, TEXT, null, MISSING, "left-value", null),

						StatisticsGroup.XML_DIFFS, "text missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(): missing text: \"left-value\"",

						"ERROR,XML_DIFFERENCE,\"missing text: \"\"left-value\"\"\",left-file,right-file,/left/x/path,,TEXT,,MISSING,left-value,",

						"<difference severity=\"error\" type=\"text\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value></actual-value>\n" +
						"    <message-text>missing text: &quot;left-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra text value",

						new Message(ERROR, XML_DIFFERENCE, "extra text: \"right-value\"", new File("left-file"), new File("right-file"), null, "/right/x/path", TEXT, null, EXTRA, null, "right-value"),

						StatisticsGroup.XML_DIFFS, "text extra", "/right/x/path",

						"ERROR: left-file(), right-file(/right/x/path): extra text: \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"extra text: \"\"right-value\"\"\",left-file,right-file,,/right/x/path,TEXT,,EXTRA,,right-value",

						"<difference severity=\"error\" type=\"text\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value></expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>extra text: &quot;right-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: text value difference",

						new Message(ERROR, XML_DIFFERENCE, "For text, expected \"the left text\", but got \"the right text\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", TEXT, null, VALUE, "the left text", "the right text"),

						StatisticsGroup.XML_DIFFS, "text differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For text, expected \"the left text\", but got \"the right text\"",

						"ERROR,XML_DIFFERENCE,\"For text, expected \"\"the left text\"\", but got \"\"the right text\"\"\",left-file,right-file,/left/x/path,/right/x/path,TEXT,,VALUE,the left text,the right text",

						"<difference severity=\"error\" type=\"text\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>the left text</expected-value>\n" +
						"    <actual-value>the right text</actual-value>\n" +
						"    <message-text>For text, expected \"the left text\", but got \"the right text\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: namespace-prefix difference",

						new Message(TRIVIAL, XML_DIFFERENCE, "For namespace prefix, expected \"x\", but got \"y\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", NAMESPACE_PREFIX, null, VALUE, "x", "y"),

						StatisticsGroup.XML_DIFFS, "namespace prefix differs", "/left/x/path",

						"TRIVIAL: left-file(/left/x/path), right-file(/right/x/path): For namespace prefix, expected \"x\", but got \"y\"",

						"TRIVIAL,XML_DIFFERENCE,\"For namespace prefix, expected \"\"x\"\", but got \"\"y\"\"\",left-file,right-file,/left/x/path,/right/x/path,NAMESPACE_PREFIX,,VALUE,x,y",

						"<difference severity=\"trivial\" type=\"namespace_prefix\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>x</expected-value>\n" +
						"    <actual-value>y</actual-value>\n" +
						"    <message-text>For namespace prefix, expected \"x\", but got \"y\"</message-text>\n" +
						"</difference>\n",
					},


					{
						"XML_DIFFERENCE: missing processing instruction",

						new Message(ERROR, XML_DIFFERENCE, "missing processing instruction: \"<?left-value?>\"", new File("left-file"), new File("right-file"), "/left/x/path", null, PROCESSING_INSTRUCTION, null, MISSING, "left-value", null),

						StatisticsGroup.XML_DIFFS, "processing instruction missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(): missing processing instruction: \"<?left-value?>\"",

						"ERROR,XML_DIFFERENCE,\"missing processing instruction: \"\"<?left-value?>\"\"\",left-file,right-file,/left/x/path,,PROCESSING_INSTRUCTION,,MISSING,left-value,",

						"<difference severity=\"error\" type=\"processing_instruction\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value></actual-value>\n" +
						"    <message-text>missing processing instruction: &quot;&lt;?left-value?&gt;&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra processing instruction",

						new Message(ERROR, XML_DIFFERENCE, "extra processing instruction: \"<?right-value?>\"", new File("left-file"), new File("right-file"), null, "/right/x/path", PROCESSING_INSTRUCTION, null, EXTRA, null, "right-value"),

						StatisticsGroup.XML_DIFFS, "processing instruction extra", "/right/x/path",

						"ERROR: left-file(), right-file(/right/x/path): extra processing instruction: \"<?right-value?>\"",

						"ERROR,XML_DIFFERENCE,\"extra processing instruction: \"\"<?right-value?>\"\"\",left-file,right-file,,/right/x/path,PROCESSING_INSTRUCTION,,EXTRA,,right-value",

						"<difference severity=\"error\" type=\"processing_instruction\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value></expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>extra processing instruction: &quot;&lt;?right-value?&gt;&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: processing-instruction target difference",

						new Message(ERROR, XML_DIFFERENCE, "For processing instruction, expected target \"left-target\", but got \"right-target\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", PROCESSING_INSTRUCTION, null, PI_TARGET, "left-target", "right-target"),

						StatisticsGroup.XML_DIFFS, "processing instruction differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For processing instruction, expected target \"left-target\", but got \"right-target\"",

						"ERROR,XML_DIFFERENCE,\"For processing instruction, expected target \"\"left-target\"\", but got \"\"right-target\"\"\",left-file,right-file,/left/x/path,/right/x/path,PROCESSING_INSTRUCTION,,PI_TARGET,left-target,right-target",

						"<difference severity=\"error\" type=\"processing_instruction\" difference=\"pi_target\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>left-target</expected-value>\n" +
						"    <actual-value>right-target</actual-value>\n" +
						"    <message-text>For processing instruction, expected target \"left-target\", but got \"right-target\"</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: processing-instruction data difference",

						new Message(ERROR, XML_DIFFERENCE, "For processing instruction with target \"the-target\", expected data \"left-value\", but got \"right-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", PROCESSING_INSTRUCTION, null, VALUE, "left-value", "right-value"),

						StatisticsGroup.XML_DIFFS, "processing instruction differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For processing instruction with target \"the-target\", expected data \"left-value\", but got \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"For processing instruction with target \"\"the-target\"\", expected data \"\"left-value\"\", but got \"\"right-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,PROCESSING_INSTRUCTION,,VALUE,left-value,right-value",

						"<difference severity=\"error\" type=\"processing_instruction\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>For processing instruction with target &quot;the-target&quot;, expected data &quot;left-value&quot;, but got &quot;right-value&quot;</message-text>\n" +
						"</difference>\n",
					},


					{
						"XML_DIFFERENCE: missing xsi:schemaLocation attribute",

						new Message(ERROR, XML_DIFFERENCE, "missing xsi:schemaLocation attribute: \"left-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", SCHEMA_LOCATION, null, MISSING, "left-value", null),

						StatisticsGroup.XML_DIFFS, "xsi:schemaLocation missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): missing xsi:schemaLocation attribute: \"left-value\"",

						"ERROR,XML_DIFFERENCE,\"missing xsi:schemaLocation attribute: \"\"left-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,SCHEMA_LOCATION,,MISSING,left-value,",

						"<difference severity=\"error\" type=\"schema_location\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value></actual-value>\n" +
						"    <message-text>missing xsi:schemaLocation attribute: &quot;left-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra xsi:schemaLocation attribute",

						new Message(ERROR, XML_DIFFERENCE, "extra xsi:schemaLocation attribute: \"right-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", SCHEMA_LOCATION, null, EXTRA, null, "right-value"),

						StatisticsGroup.XML_DIFFS, "xsi:schemaLocation extra", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): extra xsi:schemaLocation attribute: \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"extra xsi:schemaLocation attribute: \"\"right-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,SCHEMA_LOCATION,,EXTRA,,right-value",

						"<difference severity=\"error\" type=\"schema_location\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value></expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>extra xsi:schemaLocation attribute: &quot;right-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: xsi:schemaLocation value difference",

						new Message(ERROR, XML_DIFFERENCE, "For xsi:schemaLocation attribute, expected value \"left-value\", but got \"right-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", SCHEMA_LOCATION, null, VALUE, "left-value", "right-value"),

						StatisticsGroup.XML_DIFFS, "xsi:schemaLocation differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For xsi:schemaLocation attribute, expected value \"left-value\", but got \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"For xsi:schemaLocation attribute, expected value \"\"left-value\"\", but got \"\"right-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,SCHEMA_LOCATION,,VALUE,left-value,right-value",

						"<difference severity=\"error\" type=\"schema_location\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>For xsi:schemaLocation attribute, expected value \"left-value\", but got \"right-value\"</message-text>\n" +
						"</difference>\n",
					},


					{
						"XML_DIFFERENCE: missing xsi:noNamespaceSchemaLocation attribute",

						new Message(ERROR, XML_DIFFERENCE, "missing xsi:noNamespaceSchemaLocation attribute: \"left-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", NO_NAMESPACE_SCHEMA_LOCATION, null, MISSING, "left-value", null),

						StatisticsGroup.XML_DIFFS, "xsi:noNamespaceSchemaLocation missing", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): missing xsi:noNamespaceSchemaLocation attribute: \"left-value\"",

						"ERROR,XML_DIFFERENCE,\"missing xsi:noNamespaceSchemaLocation attribute: \"\"left-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,NO_NAMESPACE_SCHEMA_LOCATION,,MISSING,left-value,",

						"<difference severity=\"error\" type=\"no_namespace_schema_location\" difference=\"missing\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath></actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value></actual-value>\n" +
						"    <message-text>missing xsi:noNamespaceSchemaLocation attribute: &quot;left-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: extra xsi:noNamespaceSchemaLocation attribute",

						new Message(ERROR, XML_DIFFERENCE, "extra xsi:noNamespaceSchemaLocation attribute: \"right-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", NO_NAMESPACE_SCHEMA_LOCATION, null, EXTRA, null, "right-value"),

						StatisticsGroup.XML_DIFFS, "xsi:noNamespaceSchemaLocation extra", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): extra xsi:noNamespaceSchemaLocation attribute: \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"extra xsi:noNamespaceSchemaLocation attribute: \"\"right-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,NO_NAMESPACE_SCHEMA_LOCATION,,EXTRA,,right-value",

						"<difference severity=\"error\" type=\"no_namespace_schema_location\" difference=\"extra\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath></expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value></expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>extra xsi:noNamespaceSchemaLocation attribute: &quot;right-value&quot;</message-text>\n" +
						"</difference>\n",
					},

					{
						"XML_DIFFERENCE: xsi:noNamespaceSchemaLocation value difference",

						new Message(ERROR, XML_DIFFERENCE, "For xsi:noNamespaceSchemaLocation attribute, expected value \"left-value\", but got \"right-value\"", new File("left-file"), new File("right-file"), "/left/x/path", "/right/x/path", NO_NAMESPACE_SCHEMA_LOCATION, null, VALUE, "left-value", "right-value"),

						StatisticsGroup.XML_DIFFS, "xsi:noNamespaceSchemaLocation differs", "/left/x/path",

						"ERROR: left-file(/left/x/path), right-file(/right/x/path): For xsi:noNamespaceSchemaLocation attribute, expected value \"left-value\", but got \"right-value\"",

						"ERROR,XML_DIFFERENCE,\"For xsi:noNamespaceSchemaLocation attribute, expected value \"\"left-value\"\", but got \"\"right-value\"\"\",left-file,right-file,/left/x/path,/right/x/path,NO_NAMESPACE_SCHEMA_LOCATION,,VALUE,left-value,right-value",

						"<difference severity=\"error\" type=\"no_namespace_schema_location\" difference=\"value\">\n" +
						"    <expected-file>left-file</expected-file>\n" +
						"    <actual-file>right-file</actual-file>\n" +
						"    <expected-xpath>/left/x/path</expected-xpath>\n" +
						"    <actual-xpath>/right/x/path</actual-xpath>\n" +
						"    <expected-value>left-value</expected-value>\n" +
						"    <actual-value>right-value</actual-value>\n" +
						"    <message-text>For xsi:noNamespaceSchemaLocation attribute, expected value \"left-value\", but got \"right-value\"</message-text>\n" +
						"</difference>\n",
					},
			});
		}
		
		public MessageFormattingTests(String testName, Message inputMsg,
				StatisticsGroup expStatsGroup, String expStatsKey, String expXpathStatsKey,
				String expText, String expCSV, String expXML) {
			this.testName = testName;
			this.inputMsg = inputMsg;
			this.expStatsGroup = expStatsGroup;
			this.expStatsKey = expStatsKey;
			this.expXpathStatsKey = expXpathStatsKey;
			this.expText = expText;
			this.expCSV = expCSV;
			this.expXML = expXML;
		}
		
		@Test
		public void test_accumulateStatistics() {
			System.out.println(testName);
			
			// Perform
			MessageStatistics stats = new MessageStatistics();
			inputMsg.accumulateStatistics(stats);
			
			// Test
			if (this.expStatsKey.equals("(ignore)")) {
				MessageStatisticsTest.assertStatsEmpty(stats);
			} else {
				MessageStatisticsTest.assertMainStatsContainOnly(stats, this.expStatsGroup, this.expStatsKey, 1);
			}

			if (this.expXpathStatsKey == null) {
				MessageStatisticsTest.assertGroupEmpty(stats, BY_XPATH);
			} else {
				MessageStatisticsTest.assertXpathStatsContainOnly(stats, this.expXpathStatsKey, 1);
			}
		}
		
		// accumulateXpathStatistics() isn't tested here, but only in BasicTests.  There's not enough
		// variability to be worth testing this method for each individual Message type.
		
		@Test
		public void test_text_format() {
			System.out.println(testName);
			
			String actText = inputMsg.asText();
		
			assertEquals(expText, actText);
		}

		@Test
		public void test_csv_format() {
			System.out.println(testName);
			
			String actCSV = inputMsg.asCSV();
		
			assertEquals(expCSV, actCSV);
		}

		@Test
		public void test_xml_format() throws IOException, SAXException {
			String actXML = inputMsg.asXML();
			
			System.out.println("Test " + this.testName + ":");
			System.out.println("Expected XML:");
			System.out.println(expXML);
			System.out.println("Actual XML:");
			System.out.println(actXML);
			System.out.println("========================================================");
			
			XmlunitState.save();
			try {
				XMLUnit.setIgnoreWhitespace(true);
				assertXMLEqual(expXML, actXML);
			} finally {
				XmlunitState.restore();
			}
		}

		@Test
		public void printEntry() {
			System.err.println(String.format("{{{%s:%n%s%n%n}}}%n", testName, expXML));
		}
	}
}

