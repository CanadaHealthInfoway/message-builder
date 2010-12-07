package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.Namespaces.isMif1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
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
		//this.outputUI.log(DEBUG, "DMIF - now processing file " + reference.asFile().getName());
		List<Annotation> result = new ArrayList<Annotation>();
		for (AnnotationType annotationType : (List<AnnotationType>) EnumPattern.values(AnnotationType.class)) {
			String[] elementNames = annotationType.getMifElementNames();
			for (String elementName : elementNames) {
				List<Element> elements = toElementList(getNodes(classElement, preMifAnnotationPath+elementName+postMifAnnotationPath));
				List<Annotation> annotations = new ArrayList<Annotation>();
				for (Element paragraph : elements) {
					String text = StringUtils.trim(NodeUtil.getTextValue(paragraph, true));
					if (StringUtils.isNotBlank(text)) {
						Annotation annotation = new Annotation(text);
						annotation.setElementNameFromMif(elementName);
						if (!StringUtils.isBlank(paragraph.getAttribute("id"))) {
							annotation.setId(paragraph.getAttribute("id"));
						}
						if (!StringUtils.isBlank(paragraph.getAttribute("sourceName"))) {						
							annotation.setSourceName(paragraph.getAttribute("sourceName"));
						}
						annotation.setAnnotationType(annotationType);
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
