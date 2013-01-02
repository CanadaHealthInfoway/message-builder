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

package ca.infoway.messagebuilder.util.xml;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.platform.MapEntry;
import ca.infoway.messagebuilder.util.text.Indenter;

/**
 * <p>Utilities for creating a string representation of XML.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlRenderingUtils {
	
	public static final String SPACE = " ";
    public static final String QUOTE = "\"";
    public static final String EQUALS = "=";

    /**
     * <p>Create a XML start element.
     * @param name - the tag name.
     * @param indentLevel - the indent level
     * @param close - indicates whether or not close the element.
     * @param lineBreak - indicates whether or not to include a line break
     * @return - the formatted result.
     */
	public static String createStartElement(String name, 
			int indentLevel, boolean close, boolean lineBreak) {
		return createStartElement(name, Collections.<Map.Entry<String, String>>emptyList(), indentLevel, close, lineBreak);
	}

    /**
     * <p>Create a XML start element.
     * @param name - the tag name.
     * @param nameSpace - namespace of the tag name
     * @param indentLevel - the indent level
     * @param close - indicates whether or not close the element.
     * @param lineBreak - indicates whether or not to include a line break
     * @return - the formatted result.
     */
	public static String createStartElement(String name, String nameSpace,
			int indentLevel, boolean close, boolean lineBreak) {
		return createStartElement(name, nameSpace, Collections.<Map.Entry<String, String>>emptyList(), indentLevel, close, lineBreak);
	}

    /**
     * <p>Create a XML start element.
     * @param name - the tag name.
     * @param attributes - an ordered collection of attributes (names and values) to render with the element
     * @param indentLevel - the indent level
     * @param close - indicates whether or not close the element.
     * @param lineBreak - indicates whether or not to include a line break
     * @return - the formatted result.
     */
	public static String createStartElement(String name, List<Map.Entry<String, String>> attributes, 
			int indentLevel, boolean close, boolean lineBreak) {
		return createStartElement(name, null, attributes, indentLevel, close, lineBreak);
	}

    /**
     * <p>Create a XML start element.
     * @param name - the tag name.
     * @param attributes - a map of attributes (names and values) to render with the element
     * @param indentLevel - the indent level
     * @param close - indicates whether or not close the element.
     * @param lineBreak - indicates whether or not to include a line break
     * @return - the formatted result.
     */
	public static String createStartElement(String name, Map<String, String> attributes, 
			int indentLevel, boolean close, boolean lineBreak) {
		return createStartElement(name, null, toSortedList(attributes), indentLevel, close, lineBreak);
	}
	
	private static List<Entry<String, String>> toSortedList(Map<String, String> attributes) {
		List<Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();

		if (attributes != null) {
			ArrayList<String> sortedList = new ArrayList<String>(attributes.keySet());
			Collections.sort(sortedList);

			for (String key : sortedList) {
				list.add(new MapEntry<String,String>(key, attributes.get(key)));
			}
		}
		return list;
	}

    /**
     * <p>Create a XML start element.
     * @param name - the tag name.
     * @param nameSpace - namespace of the tag name
     * @param attributes - an ordered collection of attributes (names and values) to render with the element
     * @param indentLevel - the indent level
     * @param close - indicates whether or not close the element.
     * @param lineBreak - indicates whether or not to include a line break
     * @return - the formatted result.
     */
	public static String createStartElement(String name, String nameSpace, List<Map.Entry<String, String>> attributes, 
			int indentLevel, boolean close, boolean lineBreak) {
		
		StringBuffer buffer = new StringBuffer();
	    Indenter.indentBuffer(buffer, indentLevel);
	    buffer.append("<");
		buffer.append(name);
		if (nameSpace!=null) {
			buffer.append(" xmlns=\"" + nameSpace + "\"");
		}
	    if (attributes != null) {
	        for (Map.Entry<String, String> attribute : attributes) {
	            buffer.append(SPACE);
	            buffer.append(attribute.getKey());
	            buffer.append(EQUALS);
	            buffer.append(QUOTE);
	            buffer.append(XmlStringEscape.escape(attribute.getValue()));
	            buffer.append(QUOTE);
	        }
	    }
	    
	    if (close) {
	        buffer.append("/");
	    }
	    
	    buffer.append(">");
	    if (lineBreak) {
	        buffer.append(LINE_SEPARATOR);
	    }
	    return buffer.toString();
	}

	/**
	 * <p>Create a closing element tag.
	 * @param name - the tag name
	 * @param indentLevel - the indent level
	 * @param lineBreak - a flag to indicate if a line break should terminate the tag
	 * @return - the formatted result
	 */
	public static String createEndElement(String name, int indentLevel, boolean lineBreak) {
		StringBuffer buffer = new StringBuffer();
	    Indenter.indentBuffer(buffer, indentLevel);
	    buffer.append("</");
		buffer.append(name);
	    buffer.append(">");
	    if (lineBreak) {
	        buffer.append(LINE_SEPARATOR);
	    }
	    return buffer.toString();
	}

}
