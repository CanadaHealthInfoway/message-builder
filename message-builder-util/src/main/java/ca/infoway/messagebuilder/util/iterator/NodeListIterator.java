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

package ca.infoway.messagebuilder.util.iterator;

import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>A utility to translate the NodeList API into the easier-to-use Interable API.
 * 
 * <p>A typical usage would be:
 * 
 * <code>
 * import static ca.infoway.messagebuilder.util.iterator.NodeListIterator.elementIterable;
 * 
 *   ...
 *   public void doMethod() {
 *     NodeList list = getAllReleventElementsFromDocument();
 *     for (Element element : elementIterable(list)) {
 *       ...
 *     }
 *   }
 *   ...
 * </code>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * NodeListIterator only used from maven-chi-plugin, so adding to sharpern ignore list 
 * 
 * @sharpen.ignore
 * 
 */
public class NodeListIterator {
	
	/**
	 * <p>Return an Iterable instance that iterates over all nodes.
	 * 
	 * @param list - the node list that contains all the nodes
	 * @return - the iterator
	 */
	public static Iterable<Node> nodeIterable(NodeList list) {
		List<Node> result = new ArrayList<Node>();
		int length = list == null ? 0 : list.getLength();
		for (int i = 0; i < length; i++) {
			result.add(list.item(i));
		}
		return result;
	}
	
	/**
	 * <p>Return an Iterable instance that iterates over only the elements.  
	 * Non-element nodes in the original NodeList are ignored.
	 * 
	 * @param list - the node list 
	 * @return - the iterator
	 */
	public static Iterable<Element> elementIterable(NodeList list) {
		List<Element> result = new ArrayList<Element>();
		int length = list == null ? 0 : list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				result.add((Element) node);
			}
		}
		return result;
	}

	/**
	 * <p>Return an Iterable instance that collates the elements in the iterator into
	 * individual contiguous lists that happen to have the same tag name.  
	 * Thus, if the original list had five elements -- "&lt;purple&gt;", "&lt;purple&gt;", 
	 * "&lt;red&gt;", "&lt;red&gt;", "&lt;purple&gt;") -- the resulting iterable would
	 * have three items to iterate over.  The first result is a list of two purple 
	 * elements, the next is a list of two red elements, and the final result is a 
	 * single purple element.
	 * 
	 * @param list - the node list 
	 * @return - the iterator
	 */
	public static Iterable<List<Element>> collatedElements(NodeList list) {
		List<List<Element>> result = new ArrayList<List<Element>>();
		int length = list == null ? 0 : list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (result.isEmpty() || !isSameTagName(result.get(result.size()-1), element)) {
					List<Element> temp = new ArrayList<Element>();
					temp.add(element);
					result.add(temp);
				} else {
					result.get(result.size()-1).add(element);
				}
			}
		}
		return result;
	}

	private static boolean isSameTagName(List<Element> list, Element node) {
		return StringUtils.equals(getLocalOrTagName(list.get(list.size()-1)), 
				getLocalOrTagName(node));
	}
}
