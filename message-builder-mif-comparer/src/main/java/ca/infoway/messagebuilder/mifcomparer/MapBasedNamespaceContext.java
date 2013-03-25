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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

public class MapBasedNamespaceContext implements NamespaceContext {
	private Map<String, String> prefix2UriMap;
	private Map<String, String> uri2PrefixMap;

	public MapBasedNamespaceContext(Map<String,String> map) {
		this.prefix2UriMap = map;
		
		this.uri2PrefixMap = new HashMap<String, String>();
		// Naive implementation doesn't cope with multiple prefixes mapping to the same URI
		for (String prefix : prefix2UriMap.keySet()) {
			uri2PrefixMap.put(prefix2UriMap.get(prefix),  prefix);
		}
		
	}

	public String getNamespaceURI(String prefix) {
		return prefix2UriMap.get(prefix);
	}

	public String getPrefix(String namespaceURI) {
		return uri2PrefixMap.get(namespaceURI);
	}

	public Iterator getPrefixes(String namespaceURI) {
		throw new UnsupportedOperationException("getPrefixes(String namespaceURI)");
	}
	
	/**
	 * For testing
	 */
	Map<String, String> getMap() {
		return prefix2UriMap;
	}
}
