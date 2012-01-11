/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

class NameHelper {

	static String qualifiyName(Element anyElement, String unqualifiedName) {
		return createName(getOwnedEntryPoint(anyElement), unqualifiedName);
	}

	static String getOwnedEntryPoint(Element anyElement) {
		Element element = anyElement.getOwnerDocument().getDocumentElement();
		if (StringUtils.equals(Namespaces.MIF2_NAMESPACE.getNamespace(), element.getNamespaceURI())) {
			return new Mif2XPathHelper().getOwnedEntryPoint(anyElement.getOwnerDocument());
		} else {
			return new MifXPathHelper().getOwnedEntryPoint(anyElement.getOwnerDocument());
		}
	}

	static String createName(String qualifier, String attribute) {
		return qualifier + "." + attribute;
	}
}
