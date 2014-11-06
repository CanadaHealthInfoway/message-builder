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

package ca.infoway.messagebuilder.xml.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>A utility to determine if an XML node is in the HL7 namespace.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class NamespaceUtil {

	private static final String HL7_BASE_NAMESPACE_URI = "urn:hl7-org:";
	private static final String HL7_NAMESPACE_URI = HL7_BASE_NAMESPACE_URI + "v3";
	private static final String CDA_NAMESPACE_URI = HL7_BASE_NAMESPACE_URI + "v3";
	private static final String SDTC_NAMESPACE_URI = HL7_BASE_NAMESPACE_URI + "sdtc";

	private static Set<String> NAMESPACES = new HashSet<String>();
	static {
		NAMESPACES.add(HL7_NAMESPACE_URI);
		NAMESPACES.add(CDA_NAMESPACE_URI);
		NAMESPACES.add(SDTC_NAMESPACE_URI);
	}
	
	/**
	 * <p>Determine if the node is in the HL7 namespace.
	 * @param node - the node being considered
	 * @return true if the node is part of the HL7 namespace; false otherwise
	 */
	public static boolean isHl7Node(Node node) {
		if (NAMESPACES.contains(node.getNamespaceURI())) {
			return true;
		} else if (node instanceof Attr && (StringUtils.isBlank(node.getNamespaceURI()))) {
			return HL7_NAMESPACE_URI.equals(((Attr) node).getOwnerElement().getNamespaceURI());
		} else {
			return false;
		}
	}
	
	public static boolean isNamespaceCorrect(Node node, Relationship relationship) {
		if (relationship == null) return false;
		String nodeNamespace = getActualNamespace(node);
		String expectedNamespace = getExpectedNamespace(relationship);
		return StringUtils.equals(nodeNamespace, expectedNamespace);
	}

	public static String getActualNamespace(Node node) {
		String nodeNamespace = node.getNamespaceURI();
		if (node instanceof Attr && (StringUtils.isBlank(nodeNamespace))) {
			nodeNamespace = ((Attr) node).getOwnerElement().getNamespaceURI();
		}
		return nodeNamespace;
	}

	public static String getExpectedNamespace(Relationship relationship) {
		String expectedNamespace = HL7_NAMESPACE_URI;
		if (StringUtils.isNotBlank(relationship.getNamespace())) {
			expectedNamespace = HL7_BASE_NAMESPACE_URI + relationship.getNamespace(); 
		}
		return expectedNamespace;
	}
}
