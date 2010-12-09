package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.Namespaces.isMif1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.DOMWriter;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;

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
	
	List<Annotation> getDocumentation(Element classElement, String preMifAnnotationPath, String postMifAnnotationPath) {
		List<Annotation> result = new ArrayList<Annotation>();
		for (AnnotationType annotationType : (List<AnnotationType>) EnumPattern.values(AnnotationType.class)) {
			String[] elementNames = annotationType.getMifElementNames();
			for (String elementName : elementNames) {
				List<Element> elements = toElementList(getNodes(classElement, preMifAnnotationPath+elementName+postMifAnnotationPath));
				List<Annotation> annotations = new ArrayList<Annotation>();
				if (!elements.isEmpty()) {
					Annotation annotation = new Annotation();
					annotation.setAnnotationType(annotationType);
					for (Element paragraph : elements) {
						String text = null;
						try {
							text = StringUtils.trim(DOMWriter.renderAsString(paragraph));
							if (StringUtils.isNotBlank(text)) {
								annotation.setText((annotation.getText()!=null)?annotation.getText()+text:text);
							}
						} catch (IOException e) {
							throw new MifProcessingException(e);
						}
						annotations.add(annotation);
					}
				}
				if (!annotations.isEmpty()) {
					result.addAll(annotations);
				}
			}
		}
		return result;
	}
	
	abstract String getOwnedEntryPoint(Document document);
	abstract String getRootType(Element ownedEntryPoint);
	abstract List<Annotation> getDocumentation(Element classElement);
	abstract String getBusinessName(Element element);
	abstract Element getOwnedEntryPointElement(Document document);
	
}
