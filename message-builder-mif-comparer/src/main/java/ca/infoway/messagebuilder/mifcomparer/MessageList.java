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

import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.mifcomparer.Message.MessageType;
import ca.infoway.messagebuilder.mifcomparer.Message.Severity;

public class MessageList {
	private static final String NEWLINE = System.getProperty("line.separator");

	static final String CSV_HEADER = "Severity,Message Type,Message,File 1,File 2,XPath 1,XPath 2,Object Type,Object Name,Kind of Difference,Value 1,Value 2";

	private List<Message> messages = new LinkedList<Message>();
	private MessageStatistics stats = new MessageStatistics();

	public void add(Message m) {
		messages.add(m);
		m.accumulateStatistics(stats);
	}
	
	List<Message> filterMessagesBySeverity(Severity s) {
		List<Message> out = new ArrayList<Message>(messages.size());

		for (Message m : messages) {
			if (m.severity.compareTo(s) >= 0)
				out.add(m);
		}

		return out;
	}

	public StringBuilder appendText(StringBuilder sb) {
		return appendText(sb, null);
	}

	public StringBuilder appendText(StringBuilder sb, Severity s) {
		if (s == null)
			s = Message.MINIMUM_SEVERITY;
		
		for (Message d : this.filterMessagesBySeverity(s)) {
			d.appendText(sb);
			sb.append(NEWLINE);
		}

		return sb;
	}
	
	public StringBuilder appendCSV(StringBuilder sb) {
		return appendCSV(sb, null);
	}

	public StringBuilder appendCSV(StringBuilder sb, Severity s) {
		if (s == null)
			s = Message.MINIMUM_SEVERITY;
		
		sb.append(CSV_HEADER);
		sb.append(NEWLINE);
		
		for (Message d : this.filterMessagesBySeverity(s)) {
			d.appendCSV(sb);
			sb.append(NEWLINE);
		}

		return sb;
	}
	
	public StringBuilder appendXML(StringBuilder sb, Severity s) {
		if (s == null)
			s = Message.MINIMUM_SEVERITY;
		
		sb.append("<difference-list>");
		sb.append(NEWLINE);
		
		for (Message d : this.filterMessagesBySeverity(s)) {
			d.appendXML(sb);
			sb.append(NEWLINE);
		}

		sb.append("</difference-list>");
		sb.append(NEWLINE);
		
		return sb;
	}
	
	public String asText() {
		return asText(null);
	}
	
	public String asText(Severity s) {
		StringBuilder sb = new StringBuilder();
		this.appendText(sb, s);
		return sb.toString();
	}

	public String asCSV() {
		return asCSV(null);
	}
	
	public String asCSV(Severity s) {
		StringBuilder sb = new StringBuilder();
		this.appendCSV(sb, s);
		return sb.toString();
	}

	public String asXML(Severity s) {
		StringBuilder sb = new StringBuilder();
		this.appendXML(sb, s);
		return sb.toString();
	}

	public String asXML() {
		return asXML(null);
	}
	
	public String toString() {
		return this.asText();
	}

	public List<Message> getMessages() {
		return getMessages(null);
	}
	
	public List<Message> getMessages(Severity s) {
		if (s == null)
			s = Message.MINIMUM_SEVERITY;
		
		return filterMessagesBySeverity(s);
	}
	
	public String getStatistics() {
		return stats.toString();
	}
	
//	public Map<String, Integer> getPerFileStatistics() {
//		Map<String, Integer> stats = new HashMap<String, Integer>();
//		
//		// UNPAIRED_FILE, UNRECOGNIZED_FILE_TYPE, IGNORED_FILE, DESCRIPTIONS_DIFFER,
//		// FILE_SUMMARY, XML_ERROR, XML_DIFFERENCE, PROGRESS, INTERNAL_ERROR, FILTER, TESTING_CODE,
//		
//		for (Message m : this.getMessages()) {
//			switch (m.msgType) {
//			case FILE_SUMMARY:
//				increment(stats, m.message);
//				increment(stats, "were compared");			// Total files compared
//			}
//		}
//		
//		return stats;
//	}

}
