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

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.FATAL;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.INFO;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.WARNING;
import static org.junit.Assert.assertEquals;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MessageListTest {
	private static final String NEWLINE = System.getProperty("line.separator");

	@Test
	public void that_new_MessageList_is_empty() {
		MessageList obj = new MessageList();
		assertEquals("", obj.asText());
	}
	
	@Test
	public void MessageList_with_xpaths_and_values_text_format() {
		MessageList obj = new MessageList();
		obj.add(new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile"), "/x/path/l", "/x/path/r", "leftvalue", "rightvalue"));
		
		assertEquals("WARNING: leftfile(/x/path/l), rightfile(/x/path/r): message" + NEWLINE, obj.asText());
	}
	
	@Test
	public void MessageList_with_xpaths_and_values_csv_format() {
		MessageList obj = new MessageList();
		obj.add(new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile"), "/x/path/l", "/x/path/r", "leftvalue", "rightvalue"));
		String exp = MessageList.CSV_HEADER + NEWLINE +
				"WARNING,TESTING_CODE,message,leftfile,rightfile,/x/path/l,/x/path/r,,,,leftvalue,rightvalue" + NEWLINE;
		
		assertEquals(exp, obj.asCSV());
	}
	
	@Test
	public void MessageList_with_one_message() {
		MessageList obj = new MessageList();
		obj.add(new Message(WARNING, TESTING_CODE, "message", new File("leftfile"), new File("rightfile")));
		
		assertEquals("WARNING: leftfile, rightfile: message" + NEWLINE, obj.asText());
	}
	
	@Test
	public void MessageList_with_two_messages() {
		MessageList obj = new MessageList();
		obj.add(new Message(WARNING, TESTING_CODE, "message", new File("left1"), new File("right1")));
		obj.add(new Message(INFO, TESTING_CODE, "another message", new File("left2"), new File("right2")));
		String exp =
			"WARNING: left1, right1: message" + NEWLINE +
			"INFO: left2, right2: another message" + NEWLINE;
		
		assertEquals(exp, obj.asText());
	}
	
	@Test
	public void that_appendText_without_threshold_appends_all_messages() {
		MessageList obj = messageListWithAllSeverities();
		String exp =
			"WARNING: left1, right1: warning message" + NEWLINE +
			"FATAL: left2, right2: fatal message" + NEWLINE +
			"INFO: left3, right3: info message" + NEWLINE +
			"ERROR: left4, right4: error message" + NEWLINE +
			"DEBUG: left5, right5: debug message" + NEWLINE +
		    "TRIVIAL: left6, right6: trivial message" + NEWLINE +
		    "";
		
		assertEquals(exp, obj.asText());
	}	
	
	@Test
	public void that_appendText_with_threshold_appends_only_messages_that_satisfy_the_threshold() {
		MessageList obj = messageListWithAllSeverities();
		String exp =
			"FATAL: left2, right2: fatal message" + NEWLINE +
			"ERROR: left4, right4: error message" + NEWLINE;
		
		assertEquals(exp, obj.asText(ERROR));
	}
	
	@Test
	public void that_appendCSV_with_threshold_appends_only_messages_that_satisfy_the_threshold() {
		MessageList obj = messageListWithAllSeverities();
		String exp =
			MessageList.CSV_HEADER + NEWLINE +
			"FATAL,TESTING_CODE,fatal message,left2,right2,,,,,,," + NEWLINE +
			"ERROR,TESTING_CODE,error message,left4,right4,,,,,,," + NEWLINE;
		
		assertEquals(exp, obj.asCSV(ERROR));
	}

	@Test
	public void that_getMessages_with_no_arg_gets_all_messages() {
		MessageList obj = messageListWithAllSeverities();
	
		String exp[] = new String[] {
				"WARNING: left1, right1: warning message",
				"FATAL: left2, right2: fatal message",
				"INFO: left3, right3: info message",
				"ERROR: left4, right4: error message",
				"DEBUG: left5, right5: debug message",
				"TRIVIAL: left6, right6: trivial message",
		};

		List<Message> actMsgs = obj.getMessages();
		
		List<String> actStrings = new ArrayList<String>(actMsgs.size());
		for (Message m : actMsgs) {
			actStrings.add(m.asText());
		}
		
		assertEqualsUnordered(Arrays.asList(exp), actStrings);		
	}
	
	@Test
	public void that_getMessages_with_threshold_returns_only_messages_that_satisfy_the_threshold() {
		MessageList obj = messageListWithAllSeverities();
	
		String exp[] = new String[] {
				"WARNING: left1, right1: warning message",
				"FATAL: left2, right2: fatal message",
				"ERROR: left4, right4: error message",
		};

		List<Message> actMsgs = obj.getMessages(WARNING);
		
		List<String> actStrings = new ArrayList<String>(actMsgs.size());
		for (Message m : actMsgs) {
			actStrings.add(m.asText());
		}
		
		assertEqualsUnordered(Arrays.asList(exp), actStrings);		
	}
	
	// Utility methods

	private MessageList messageListWithAllSeverities() {
		MessageList obj = new MessageList();
		obj.add(new Message(WARNING, TESTING_CODE, "warning message", new File("left1"), new File("right1")));
		obj.add(new Message(FATAL, TESTING_CODE, "fatal message", new File("left2"), new File("right2")));
		obj.add(new Message(INFO, TESTING_CODE, "info message", new File("left3"), new File("right3")));
		obj.add(new Message(ERROR, TESTING_CODE, "error message", new File("left4"), new File("right4")));
		obj.add(new Message(DEBUG, TESTING_CODE, "debug message", new File("left5"), new File("right5")));
		obj.add(new Message(TRIVIAL, TESTING_CODE, "trivial message", new File("left6"), new File("right6")));

		return obj;
	}
	
	private MessageList messageListForStatsTests() {
		MessageList obj = new MessageList();
		obj.add(new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left1"), new File("right1")));
		obj.add(new Message(INFO, FILE_SUMMARY, "Files differ", new File("left2"), new File("right2")));
		obj.add(new Message(INFO, FILE_SUMMARY, "Files are identical", new File("left3"), new File("right3")));
		
		return obj;
	}
}
