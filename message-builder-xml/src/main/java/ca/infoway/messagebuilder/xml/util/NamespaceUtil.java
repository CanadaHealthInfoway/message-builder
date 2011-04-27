/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * <p>A utility to determine if an XML node is in the HL7 namespace.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class NamespaceUtil {

	private static final String HL7_NAMESPACE_URI = "urn:hl7-org:v3";

	/**
	 * <p>Determine if the node in the HL7 namespace.
	 * @param node - the node being considered
	 * @return true if the node is part of the HL7 namespace; false otherwise
	 */
	public static boolean isHl7Node(Node node) {
		if (HL7_NAMESPACE_URI.equals(node.getNamespaceURI())) {
			return true;
		} else if (node instanceof Attr && (node.getNamespaceURI() == null || node.getNamespaceURI()=="")) {
			return HL7_NAMESPACE_URI.equals(((Attr) node).getOwnerElement().getNamespaceURI());
		} else {
			return false;
		}
	}
}
