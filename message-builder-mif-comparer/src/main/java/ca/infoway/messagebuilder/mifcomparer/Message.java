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

import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.ATTRIBUTE;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.TEXT;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;

import java.io.File;
import java.util.Arrays;
import java.util.Formatter;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * A diagnostic message.
 * 
 * Each {@link Message} contains:<ul>
 * 		<li>a <i>Severity</i> -- the usual FATAL, ERROR, WARNING, or INFO
 * 		<li>Optionally, one or two {@link File} objects representing the file(s) to which the message applies
 * 		<li>A <i>MessageType</i>, which indicates in general terms what the message is about
 * 		<li>The message text
 * </ul>
 * Objects of this class are immutable.
 *
 * TODO: Add fields for line/col numbers and xpaths.  Probably in a subclass, to make it easier to vary the output format (by overloading asText() etc.)
 */
class Message {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private class Side {
		File file;
		String value;
		String xpath;
		
		Side(File f, String x, String v) {
			file = f;
			xpath = x;
			value = v;
		}
		
		public void appendText(StringBuilder sb, boolean printXpath) {
			sb.append(file.toString());
			if (printXpath) {
				sb.append("(");
				sb.append(quoteCSV(xpath));
				sb.append(")");
			}
		}
		
		public String asText(boolean printXpath) {
			StringBuilder sb = new StringBuilder();
			appendText(sb, printXpath);
			return sb.toString();
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("Side {");
				sb.append(quoteCSV(file,	"(null)"));		sb.append(", ");
				sb.append(quoteCSV(xpath,	"(null)"));		sb.append(", ");
				sb.append(quoteCSV(value,	"(null)"));
			sb.append("}");

			return sb.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
//			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((file == null) ? 0 : file.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			result = prime * result + ((xpath == null) ? 0 : xpath.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Side other = (Side) obj;
//			if (!getOuterType().equals(other.getOuterType()))
//				return false;
			if (file == null) {
				if (other.file != null)
					return false;
			} else if (!file.equals(other.file))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			if (xpath == null) {
				if (other.xpath != null)
					return false;
			} else if (!xpath.equals(other.xpath))
				return false;
			return true;
		}

//		private Message getOuterType() {
//			return Message.this;
//		}
		
	};

	Side sides[];
	
	public enum Severity { DEBUG, INFO, TRIVIAL, WARNING, ERROR, FATAL };
	public static final Severity MINIMUM_SEVERITY = Severity.values()[0];
	//FIXME: XML_DIFFERENCE_OLD should go away
	public enum MessageType { UNPAIRED_FILE, UNRECOGNIZED_FILE_TYPE, IGNORED_FILE, DESCRIPTIONS_DIFFER, NO_DIFFERENCES, FILE_SUMMARY, XML_ERROR, XML_DIFFERENCE, PROGRESS, INTERNAL_ERROR, FILTER, TESTING_CODE };
	public enum ObjectType { ELEMENT, ATTRIBUTE, TEXT, NAMESPACE_PREFIX };
	public enum DifferenceType { MISSING, EXTRA, VALUE };

	final Severity severity;
	final MessageType msgType;
	final String message;
	final ObjectType objType;
	final String objName;
	final DifferenceType diffType;
	
	/**
	 * Constructs a {@link Message} instance.
	 * Either or both {@link File} arguments may be <i>null</i>.
	 */
	public Message(Severity sev, MessageType msgType, String msg, File file1, File file2) {
		this(sev, msgType, msg, file1, file2, null, null, null, null);
	}
	
	public Message(
			Severity sev, MessageType msgType, String msg,
			/*key,*/
			File file1, File file2,
			String xpath1, String xpath2,
			ObjectType objType, String objName, DifferenceType diffType,
			String value1, String value2) {

		this.severity = sev;
		this.msgType = msgType;
		this.message = msg;
		this.objType = objType;
		this.objName = objName;
		this.diffType = diffType;
		
		sides = new Side[2];
		sides[0] = new Side(file1, xpath1, value1);
		sides[1] = new Side(file2, xpath2, value2);
	}
	
	public Message(Severity sev, MessageType msgType, String msg, File file1, File file2, String xpath1, String xpath2, String value1, String value2) {
		this(sev, msgType, msg, file1, file2, xpath1, xpath2, (ObjectType)null, (String)null, (DifferenceType)null, value1, value2);
	}

	/**
	 * Constructs a {@link Message} instance.
	 * Either or both {@link MifFile} arguments may be <i>null</i>.
	 */
	public Message(Severity sev, MessageType msgType, String msg, MifFile mf1, MifFile mf2) {
		this(sev,
			msgType,
			msg,
			mf1 == null ? null : mf1.getFile(), mf2 == null ? null : mf2.getFile());
	}

	/**
	 * Append this {@link Message}'s text to the given {@link StringBuilder}.
	 * Equivalent to:<code>
	 *		String text = this.asText();
	 *		sb.append(text);
	 * </code>
	 * but slightly more efficient, as it uses an existing {@link StringBuilder} instead of
	 * creating a new one.
	 */
	public StringBuilder appendText(StringBuilder sb) {
		sb.append(this.severity);
		sb.append(": ");
		
		if (sides[0].file != null || sides[1].file != null) {
			boolean printXpaths = sides[0].xpath != null || sides[1].xpath != null;
			
			sb.append(sides[0].file != null ? sides[0].asText(printXpaths) : "(none)");
			sb.append(", ");
			sb.append(sides[1].file != null ? sides[1].asText(printXpaths) : "(none)");
		
			sb.append(": ");
		}
		
		sb.append(this.message);
		
		return sb;
	}

	public StringBuilder appendCSV(StringBuilder sb) {
		sb.append(this.severity);					sb.append(",");
		sb.append(this.msgType);					sb.append(",");
		sb.append(quoteCSV(this.message));			sb.append(",");
		sb.append(quoteCSV(this.sides[0].file));	sb.append(",");
		sb.append(quoteCSV(this.sides[1].file));	sb.append(",");
		sb.append(quoteCSV(this.sides[0].xpath));	sb.append(",");
		sb.append(quoteCSV(this.sides[1].xpath));	sb.append(",");
		sb.append(quoteCSV(this.objType));			sb.append(",");
		sb.append(quoteCSV(this.objName));			sb.append(",");
		sb.append(quoteCSV(this.diffType));			sb.append(",");
		sb.append(quoteCSV(this.sides[0].value));	sb.append(",");
		sb.append(quoteCSV(this.sides[1].value));
		
		return sb;
	}
	
	/**
	 * Generate XML for this {@link Message}.
	 */
	public StringBuilder appendXML(StringBuilder sb) {
		/*
		 * XML looks like:
		 *
		 *		<difference severity="error" type="..." difference="...">
		 *			<expected-file>pathname of "expected" file</expected-file>
		 *			<actual-file>pathname of "actual" file</actual-file>
		 *		    <expected-xpath>xpath expr within expected-file</expected-xpath>
		 *		    <actual-xpath>xpath expr within actual-file</actual-xpath>
		 *		    <expected-value>value within expected-file</expected-value>
		 *		    <actual-value>value within expected-file</actual-value>
		 *			<message-text>human-readable text</message-text>
		 *		</difference>
		 *
		 *		<file-pair-message message-type="..." severity="...">
		 *			<expected-file>pathname of "expected" file</expected-file>
		 *			<actual-file>pathname of "actual" file</actual-file>
		 *			<message-text>human-readable text</message-text>
		 *		</file-pair-message>
		 *
		 *		<file-message message-type="..." severity="...">
		 *			<file>pathname of file that the message applies to</file>
		 *			<xpath>/xpath/expression</xpath>
		 *			<value>the value, if any</value>
		 *			<message-text>human-readable text</message-text>
		 *		</file-message>
		 *
		 * A fourth element type was part of the design, but no uses have yet
		 * been found for it:
		 *		<message message-type="..." severity="...">
		 *			<message-text>human-readable text</message-text>
		 *		</message>
		 *
		 *		In all of the above, the xpath and value elements are optional -- they
		 *		are omitted for messages where they aren't applicable.
		 */
		Formatter f = new Formatter(sb);
		
		if (msgType == XML_ERROR || msgType == UNPAIRED_FILE || msgType == IGNORED_FILE || msgType == FILTER) {
			String elem =
				msgType==XML_ERROR 			? "xml-error"		:
				msgType==UNPAIRED_FILE 		? "unpaired-file"	:
				msgType==IGNORED_FILE		? "ignored-file"	:
				msgType==FILTER				? "filter"			:
				null;
			if (elem == null)
				throw new RuntimeException("Internal error: elem==null should never occur");

			int whichSide = this.sides[0].file != null ? 0 : 1;
			
			f.format("<file-message message-type=\"%s\" severity=\"%s\">%n", elem, severity.toString().toLowerCase());
			f.format("\t<file>%s</file>%n", quoteXML(this.sides[whichSide].file));
			f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
			f.format("</file-message>%n");

		}

		else if (msgType == INTERNAL_ERROR) {
			/*
			 * At the moment, all INTERNAL_ERROR's happen to be best expressed as <file-message>s,
			 * but it's entirely possible that more will be added in future that are best expressed using
			 * <file-pair-message> or the hypothetical <message>.  (<difference> seems unlikely to be
			 * appropriate here, but even that's not inconceivable.)
			 */

			int whichSide = this.sides[0].file != null ? 0 : 1;

			f.format("<file-message message-type=\"internal-error\" severity=\"%s\">%n", severity.toString().toLowerCase());
			f.format("\t<file>%s</file>%n", quoteXML(this.sides[whichSide].file));
			f.format("\t<xpath>%s</xpath>%n", quoteXML(this.sides[whichSide].xpath));
			f.format("\t<value>%s</value>%n", quoteXML(this.sides[whichSide].value));
			f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
			f.format("</file-message>%n");
		}

		else if (msgType == FILE_SUMMARY || msgType == PROGRESS) {
			// <file-pair-message> types without xpaths or values

			String elem =
				msgType==FILE_SUMMARY 		? "file-summary"	:
				msgType==PROGRESS			? "progress"		:
				null;
			if (elem == null)
				throw new RuntimeException("Internal error: elem==null should never occur");
			
			f.format("<file-pair-message message-type=\"%s\" severity=\"%s\">%n", elem, severity.toString().toLowerCase());
			f.format("\t<expected-file>%s</expected-file>%n", quoteXML(this.sides[0].file));
			f.format("\t<actual-file>%s</actual-file>%n", quoteXML(this.sides[1].file));
			f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
			f.format("</file-pair-message>%n", elem);
		}

		else if (msgType == DESCRIPTIONS_DIFFER) {
			f.format("<difference severity=\"%s\" type=\"%s\"", severity.toString().toLowerCase(), "filename");
			f.format(" difference=\"%s\">%n", "descriptive-text");
			f.format("\t<expected-file>%s</expected-file>%n", quoteXML(this.sides[0].file));
			f.format("\t<actual-file>%s</actual-file>%n", quoteXML(this.sides[1].file));
			f.format("\t<expected-value>%s</expected-value>%n", quoteXML(this.sides[0].value));
			f.format("\t<actual-value>%s</actual-value>%n", quoteXML(this.sides[1].value));
			f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
			f.format("</difference>%n");
		}
		
		else if (msgType == XML_DIFFERENCE) {
			if (diffType != null) {
				if (diffType == DifferenceType.EXTRA || diffType == DifferenceType.MISSING) {
					f.format("<difference severity=\"%s\" type=\"%s\" name=\"%s\" difference=\"%s\">%n",
						severity.toString().toLowerCase(),
						this.objType.toString().toLowerCase(),
						this.objName,
						this.diffType.toString().toLowerCase());
					f.format("\t<expected-file>%s</expected-file>%n", quoteXML(this.sides[0].file));
					f.format("\t<actual-file>%s</actual-file>%n", quoteXML(this.sides[1].file));
					f.format("\t<expected-xpath>%s</expected-xpath>%n",
						diffType==MISSING ? quoteXML(this.sides[0].xpath) : "");
					f.format("\t<actual-xpath>%s</actual-xpath>%n",
						diffType==MISSING ? "" : quoteXML(this.sides[1].xpath));
					if (objType == ATTRIBUTE) {
						f.format("\t<expected-value>%s</expected-value>%n", quoteXML(this.sides[0].value));
						f.format("\t<actual-value>%s</actual-value>%n", quoteXML(this.sides[1].value));
					}
					f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
					f.format("</difference>%n");

				} else if (diffType == DifferenceType.VALUE) {
					f.format("<difference severity=\"%s\" type=\"%s\"", severity.toString().toLowerCase(), this.objType.toString().toLowerCase());
					if (objType == ATTRIBUTE)
						f.format(" name=\"%s\"", this.objName);
					f.format(" difference=\"%s\">%n", this.diffType.toString().toLowerCase());
					f.format("\t<expected-file>%s</expected-file>%n", quoteXML(this.sides[0].file));
					f.format("\t<actual-file>%s</actual-file>%n", quoteXML(this.sides[1].file));
					f.format("\t<expected-xpath>%s</expected-xpath>%n", quoteXML(this.sides[0].xpath));
					f.format("\t<actual-xpath>%s</actual-xpath>%n", quoteXML(this.sides[1].xpath));
					f.format("\t<expected-value>%s</expected-value>%n", quoteXML(this.sides[0].value));
					f.format("\t<actual-value>%s</actual-value>%n", quoteXML(this.sides[1].value));
					f.format("\t<message-text>%s</message-text>%n", quoteXML(this.message));
					f.format("</difference>%n");
				}
			}
		} else {
			System.err.println("XML not implemented for: " + this.toString());
		}
		
		return sb;
	}
	
	static String quoteCSV(Object o) {
		return quoteCSV(o, "");
	}

	static String quoteCSV(Object o, String dflt) {
		if (o == null) {
			o = dflt;
		}
		
		String s = o.toString();
		if (s.contains("\"") || s.contains("\n") || s.contains("\r") || s.contains(",")) {
			s = s.replaceAll("\r\n", "\n");
			s = s.replaceAll("\r",  "\n");
			s = s.replaceAll("\"",  "\"\"");
			return "\"" + s + "\"";
		} else {
			return s;
		}
	}
	
	static String quoteXML(Object o) {
		return quoteXML(o, "");
	}

	static String quoteXML(Object o, String dflt) {
		if (o == null) {
			o = dflt;
		}
		
		String s = o.toString();
		return StringEscapeUtils.escapeXml(s);
	}
	
	/**
	 * Return this {@link Message}'s human-readable text representation.
	 */
	public String asText() {
		StringBuilder sb = new StringBuilder();
		this.appendText(sb);
		return sb.toString();
	}
	
	public String asCSV() {
		StringBuilder sb = new StringBuilder();
		this.appendCSV(sb);
		return sb.toString();
	}
	
	public String asXML() {
		StringBuilder sb = new StringBuilder();
		this.appendXML(sb);
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Message {");
			sb.append(quoteCSV(severity,	"(null)"));		sb.append(", ");
			sb.append(quoteCSV(msgType,		"(null)"));		sb.append(", ");
			sb.append(quoteCSV(message,		"(null)"));		sb.append(", ");
			sb.append(quoteCSV(sides[0],	"(null)"));		sb.append(", ");
			sb.append(quoteCSV(sides[1],	"(null)"));		sb.append(", ");
			sb.append(quoteCSV(objType,		"(null)"));		sb.append(", ");
			sb.append(quoteCSV(objName,		"(null)"));		sb.append(", ");
			sb.append(quoteCSV(diffType,	"(null)"));
		sb.append("}");

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diffType == null) ? 0 : diffType.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((objName == null) ? 0 : objName.hashCode());
		result = prime * result + ((objType == null) ? 0 : objType.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + Arrays.hashCode(sides);
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (diffType != other.diffType)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (objName == null) {
			if (other.objName != null)
				return false;
		} else if (!objName.equals(other.objName))
			return false;
		if (objType != other.objType)
			return false;
		if (severity != other.severity)
			return false;
		if (!Arrays.equals(sides, other.sides))
			return false;
		if (msgType != other.msgType)
			return false;
		return true;
	}

}
