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