package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.Namespaces.isMif1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.util.XPathHelper;

abstract class BaseMifXPathHelper {

	public static Element getSingleElement(Element start, String xpath) {
		try {
			return (Element) new XPathHelper().getSingleNode(start, xpath, 
					Namespaces.MIF_NAMESPACE,
					Namespaces.MIF2_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	protected static List<Element> toElementList(NodeList nodes) {
		List<Element> result = new ArrayList<Element>();
		for (int i = 0, length = nodes == null ? 0 : nodes.getLength(); i < length; i++) {
			result.add((Element) nodes.item(i));
		}
		return result;
	}

	protected static NodeList getNodes(Element start, String xpath) {
		try {
			return new XPathHelper().getNodes(start, xpath, 
					Namespaces.MIF_NAMESPACE, Namespaces.MIF2_NAMESPACE, Namespaces.HTML_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	protected static String getAttribute(Element start, String xpath) {
		try {
			return new XPathHelper().getAttributeValue(start, xpath, Namespaces.MIF_NAMESPACE, Namespaces.MIF2_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	public static String getMifVersion(Document document) throws XPathExpressionException {
		String mifVersion = null;
		String namespace = getMifNamespace(document);
		String version = new XPathHelper().getAttributeValue(document, "/mif2:staticModel/@schemaVersion", Namespaces.MIF2_NAMESPACE);
		if (isMif1(namespace)) {
			mifVersion = "1.x";
		} else {
			mifVersion = version;
		}
		return mifVersion;
	}
	
	public static String getMifNamespace(Document document) {
		return document.getDocumentElement().getNamespaceURI();
	}
	
	abstract String getOwnedEntryPoint(Document document);
	abstract String getRootType(Element ownedEntryPoint);
	abstract List<String> getDocumentation(Element classElement);
	abstract String getBusinessName(Element element);
	abstract Element getOwnedEntryPointElement(Document document);
	
}
