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
