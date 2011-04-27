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

package ca.infoway.messagebuilder.generator.util;


import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class NamespaceContextMap implements javax.xml.namespace.NamespaceContext {

	private Map<String,Namespace> namespaces = Collections.synchronizedMap(new HashMap<String,Namespace>());
	
	public NamespaceContextMap(Namespace[] namespaces) {
		for (Namespace namespace : nullSafeIterable(namespaces)) {
			this.namespaces.put(namespace.getPrefix(), namespace);
		}
	}
	
	public String getNamespaceURI(String prefix) {
		return this.namespaces.get(prefix).getNamespace();
	}

	public String getPrefix(String namespaceURI) {
        throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public Iterator getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException();
	}

}