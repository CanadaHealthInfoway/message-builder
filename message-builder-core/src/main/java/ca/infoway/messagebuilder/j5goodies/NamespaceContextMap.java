package ca.infoway.messagebuilder.j5goodies;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

/**
 * @sharpen.ignore j5goodies - Translated manually
 */
class NamespaceContextMap implements javax.xml.namespace.NamespaceContext {

	private Map<String,XmlNamespace> namespaces = Collections.synchronizedMap(new HashMap<String,XmlNamespace>());
	
	public NamespaceContextMap(XmlNamespace[] namespaces) {
		for (XmlNamespace namespace : EmptyIterable.nullSafeIterable(namespaces)) {
			this.namespaces.put(namespace.getPrefix(), namespace);
		}
	}
	
	public String getNamespaceURI(String prefix) {
		return this.namespaces.get(prefix).getXmlNamespace();
	}

	public String getPrefix(String namespaceURI) {
        throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public Iterator getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException();
	}

}
