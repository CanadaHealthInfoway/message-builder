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

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.NamespaceContext;

import org.w3c.dom.Document;

public abstract class XmlFilterImpl implements XmlFilter {
	/* (non-Javadoc)
	 * @see ca.infoway.messagebuilder.mifcomparer.XmlFilter#apply(java.io.File, org.w3c.dom.Document, ca.infoway.messagebuilder.mifcomparer.MessageList)
	 */
	public abstract void apply(File file, Document dom, MessageList msgs);
	
	/**
	 * Maps each filter-directive name to the fully qualified name of the class that implements the filter.
	 */ 
	private static Map<String, String> filterClasses;
	static {
		filterClasses = new HashMap<String, String>();
		
		filterClasses.put("delete",					"ca.infoway.messagebuilder.mifcomparer.XmlNodeDeleteFilter");
		filterClasses.put("resequence",				"ca.infoway.messagebuilder.mifcomparer.XmlResequenceFilter");
		filterClasses.put("search",					"ca.infoway.messagebuilder.mifcomparer.XmlSearchFilter");
		filterClasses.put("normalize-whitespace",	"ca.infoway.messagebuilder.mifcomparer.XmlNormalizeWhitespaceFilter");
		filterClasses.put("wrap-contents",			"ca.infoway.messagebuilder.mifcomparer.XmlWrapContentFilter");
		filterClasses.put("change-namespace",		"ca.infoway.messagebuilder.mifcomparer.XmlChangeNamespaceFilter");
		filterClasses.put("replace-text",			"ca.infoway.messagebuilder.mifcomparer.XmlReplaceTextFilter");
	}

	private static Pattern tokenizerPattern = Pattern.compile("\\s*([^\"']\\S*|\".*?\"|'.*?')\\s*");

	
	/**
	 * Return the first non-null message in the chain of {@link Throwable}s headed by {@code t}.
	 */
	public static String getExceptionMessage(Throwable t) {
		for (; t != null; t = t.getCause()) {
			String m = t.getMessage();
			if (m != null)
				return m;
		}
		
		return "(null)";
	}
	
	/**
	 * Create a new XmlFilter instance.
	 * {@code definition} is a text description of the filter to be created.  It is of the form:<pre>
	 * 		filter-type arguments
	 * </pre>
	 * 
	 * See {@link GlobalConfiguration} for details.
	 */
	static XmlFilter newInstance(NamespaceContext nsContext, String definition) {
		List<String> words = tokenize(definition);

		String filterName = words.remove(0);
		String[] filterArgs = words.toArray(new String[0]);
		
		String className = filterClasses.get(filterName);
		if (className == null)
			throw new FatalConditionException("Unknown XmlFilter type: \"" + filterName + "\"");
		
		return instantiate(definition, className, nsContext, filterArgs);
	}
		
	static XmlFilter instantiate(String definition, String className, NamespaceContext nsContext, String[] filterArgs) {
		try {
			Class<?>[] argTemplate = new Class<?>[] {
					NamespaceContext.class,
					String[].class,
			};
			
			Class<? extends XmlFilter> clazz = (Class<? extends XmlFilter>)Class.forName(className);
			Constructor<? extends XmlFilter> cons = clazz.getConstructor(argTemplate);
			return cons.newInstance(nsContext, filterArgs);
		} catch (Exception e) {
			throw new RuntimeException(String.format("Can't instantiate filter class \"%s\" for filter \"%s\"", className, definition), e);
		}


	}
	
	/**
	 * Tokenizes a string.
	 * Splits a string into words on whitespace, but recognizes single- and double-quoted strings.
	 * There is no escape mechanism; to include a '"' or a "'", surround the string in the other
	 * kind of quote.
	 * 
	 * @param	s	the string to be split
	 * @return		a list of tokens
	 */ 
	static List<String> tokenize(String s) {
		List<String> tokens = new LinkedList<String>();
		
		Matcher m = tokenizerPattern.matcher(s);
		while (m.find()) {
			String t = m.group(1);
			if (t.startsWith("\"") || t.startsWith("'")) {
				t = t.substring(1, t.length() - 1);			// Quoted string; strip off the quotes
			}
		    tokens.add(t);
		}
		
		return tokens;
	}
}
