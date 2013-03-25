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

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/**
 * Filter to resequence elements.
 * 
 * Takes:<ul>
 * 		<li>an XPath expression {@literal xpathExpr} that matches XML <i>elements</i>
 * 		<li>an attribute name {@literal sortKeyAttr}, which names an integer-valued attribute on the matched elements
 * </ul>
 * 
 * The filter will resequence the matched elements based on their values for the specified attribute:<ol>
 * 		<li>all such elements are sorted on their values for ${sortKeyAttr}
 * 		<li>then, the ${sortKeyAttr} attributes are renumbered to consecutive integers (1-based)
 *</ol>
 */
public class XmlResequenceFilter extends XmlFilterImpl {
	public static final String INT_SORT_KEY = "intSortKey";
	public static final String STR_SORT_KEY = "strSortKey";
	
	/**
	 * Compare two {@Element}s, based on the value of their <tt>sortKeyAttr</tt>
	 * attributes, taken and sorted as integers.
	 */
	private static class ElementSortKeyIntegerComparator implements Comparator<Element> {
		public int compare(Element e1, Element e2) {
			Integer v1 = (Integer)e1.getUserData(INT_SORT_KEY);
			Integer v2 = (Integer)e2.getUserData(INT_SORT_KEY);
			
			return v1 < v2 ? -1 :
				   v1 == v2 ? 0 :
				   1;
		}
	}

	/**
	 * Compare two {@Element}s, based on the value of their <tt>sortKeyAttr</tt>
	 * attributes, using simple string comparison.
	 */
	private static class ElementSortKeyStringComparator implements Comparator<Element> {
		public int compare(Element e1, Element e2) {
			String v1 = (String)e1.getUserData(STR_SORT_KEY);
			String v2 = (String)e2.getUserData(STR_SORT_KEY);
			
			return v1.compareTo(v2);
		}
	}

	private NamespaceContext nsContext;
	private String sortKeyAttr;
	private String xpathExpr;
	private XPath xpath;
	
	
	public XmlResequenceFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException("Expecting 2 args, but got " + args.length);
		else
			initialize(nsContext, args[0], args[1]);
	}

	public XmlResequenceFilter(NamespaceContext nsContext, String sortKeyAttr, String xpathExpr) {
		initialize(nsContext, sortKeyAttr, xpathExpr);
	}

	public void initialize(NamespaceContext nsContext, String sortKeyAttr, String xpathExpr) {
		this.nsContext = nsContext;
		this.sortKeyAttr = sortKeyAttr;
		this.xpathExpr = xpathExpr;
		
		XPathFactory xpf = XPathFactory.newInstance();
		xpath = xpf.newXPath();
		if (nsContext != null)
			xpath.setNamespaceContext(nsContext);
	}

	@Override
	public void apply(File file, Document dom, MessageList msgs) {
		try {
			resequence(file, dom, msgs);
		} catch (XmlFilterException e) {
			msgs.add(new Message(WARNING, FILTER, e.getMessage(), file, null));
			return;
		}
	}
	
	/**
	 * Resequence the elements matching {@link #xpathExpr}.
	 * Note that these elements need <i>not</i> be siblings.  This method is careful
	 * to resequence each group of siblings independently.
	 */
	public void resequence(File file, Document dom, MessageList msgs) throws XmlFilterException {
		List<Element> elems = getElementList(dom);
		if (elems.size() == 0)
			return;
	
		// Key: Parent
		// Value: List of the children that are to be sorted, in order of occurrence in the input
		Map<Element, List<Element>> families = new HashMap<Element, List<Element>>();
		
		for (Element e : elems) {
			Element parent = castToElement(e.getParentNode());
			List<Element> siblings = families.get(parent);
			if (siblings == null) {
				siblings = new ArrayList<Element>();
				families.put(parent, siblings);
			}
			
			siblings.add(e);
		}
		
		for (Element parent : families.keySet()) {
			try {
				// Do each family in its own try block, so that if one
				// dies, it doesn't kill the rest
				resequenceSiblings(dom, parent, families.get(parent));
			} catch (XmlFilterException e) {
				msgs.add(new Message(WARNING, FILTER, e.getMessage(),
						file, null));
			}
		}
	}
	
	List<Element> getElementList(Document dom) throws XmlFilterException {
		NodeList nodes;
		
		try {
			nodes = (NodeList)xpath.evaluate(xpathExpr, dom, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new XmlFilterException(
					String.format("Error evaluating XPath expr \"%s\": %s", xpathExpr, getExceptionMessage(e)),
					e);
		}

		List<Element> list = new ArrayList<Element>(nodes.getLength());
		for (int i=0; i<nodes.getLength(); ++i) {
			list.add(castToElement(nodes.item(i)));
		}
		
		return list;
	}

	
	/**
	 * Resequences a group of sibling nodes.  These are expected to all be the same type;
	 * they <i>must</i> all have the same parent Element.
	 */
	void resequenceSiblings(Document dom, Element parent, List<Element> elems) throws XmlFilterException {
		/*
		 * Algorithm:
		 *   1. if the passed elements all have sort keys (i.e. values of the ${sortKeyAttr} attributes) that are integers:
		 *   	  - sort the elements in numeric order 
		 *   	  - renumber their ${sortKeyAttr}s to 1,2,3...
		 *      else:
		 *        - sort the elements in String order
		 *        - DO NOT modify the ${sortKeyAttr} attributes
		 *   2. reorder all of the elements, within their parent Element,
		 *      based on the sort from step (1)
		 * 
		 * (2) is implemented by removing all of the elements from their parent,
		 * then inserting them (reordered) in a single clump.
		 * The insertion point is determined by finding the next-sibling
		 * of the last Element in the original, unsorted list.  The new,
		 * sorted list is inserted just before that node.
		 * CAVEAT: This assumes that the Elements being resequenced are
		 * contiguous; if they aren't, the overall order within the parent
		 * node will change.  E.g. we correctly transform (foo, bar2, bar1, baz)
		 * into (foo, bar1, bar2, baz) [sorting the "bar" nodes], but given
		 * (foo, bar2, baz, bar1, snork), the best we can do is
		 * (foo, baz, bar1, bar2, snork). 
		 */
		
		// must do this before sorting the list
		Node insertBefore = elems.get(elems.size()-1).getNextSibling();
		
		// Sort
		boolean allKeysAreInts = collectSortKeys(elems);
		Collections.sort(elems, allKeysAreInts ? new ElementSortKeyIntegerComparator() : new ElementSortKeyStringComparator());
		
		// Resequence, if appropriate
		if (allKeysAreInts) {
			int nextKey = 1;
			for (Element e : elems) {
					e.setAttribute(sortKeyAttr, ((Integer)(nextKey++)).toString());
			}
		}
		
		// Physically reorder the nodes under "parent"
		DocumentFragment df = dom.createDocumentFragment();
		for (Element e : elems) {
			parent.removeChild(e);
			df.appendChild(e);
		}

		if (insertBefore != null)
			parent.insertBefore(df,  insertBefore);
		else
			parent.appendChild(df);

	}
	
	static Element castToElement(Node n) throws XmlFilterException {
		try {
			return (Element)n;
		} catch (ClassCastException e) {
			throw new XmlFilterException(e.getMessage(), e);
		}
	}
	
	void sortElements(List<Element> elems) throws XmlFilterException {

	}
	
	/**
	 * Collect elements' sort keys into user data.
	 *
	 * <p>For each element:<ul>
	 * 		<li>Save the element's sort key (i.e. the value of its {@code this.sortKeyAttr}) attribute)
	 * 			into the element's user-data, under key {@code STR_SORT_KEY}
	 * 		<li>If that sort key is parseable as an integer, do so, and store the result as user data,
	 * 			under key {@code INT_SORT_KEY}
	 * </ul>
	 * 
	 * @return	true iff <i>all</i> of the elements in {@code elems} have integer keys
	 * @throws	XmlFilterException if any element lacks a ${sortKeyAttr} attribute entirely
	 */
	boolean collectSortKeys(List<Element> elems) throws XmlFilterException {
		boolean allKeysAreInts = true;
		
		for (Element e : elems) {
			String val = e.getAttribute(sortKeyAttr);
			e.setUserData(STR_SORT_KEY, val, (UserDataHandler)null);
			if (val == null || val.equals(""))
				throw new XmlFilterException(String.format("Can't sort \"%s\" elements due to missing \"%s\" attribute; expect spurious differences",
						this.xpathExpr, this.sortKeyAttr));
			try {
				int intVal = Integer.parseInt(val);
				e.setUserData(INT_SORT_KEY, intVal, (UserDataHandler)null);
			} catch (NumberFormatException ex) {
				allKeysAreInts = false;
			}
		}
		
		return allKeysAreInts;
	}
	
	void replaceElements(Document dom, List<Element> elems) {
		DocumentFragment df = dom.createDocumentFragment();
		
		int newKey = 1;
		for (Element e : elems) {
			e.setAttribute(sortKeyAttr, String.valueOf(newKey++));
		}
	}
}
