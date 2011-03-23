package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.CodingStrength;

public class Mif2XPathHelper extends BaseMifXPathHelper {
	
	public Element getOwnedEntryPointElement(Document document) {
		Element element = MifXPathHelper.getSingleElement(document.getDocumentElement(), "/mif2:staticModel/mif2:entryPoint");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException("Document does not contain an owned entry point.");
		}
	}
	
	public String getOwnedEntryPoint(Document document) {
		return getOwnedEntryPoint(document.getDocumentElement());
	}
	
	public static String getOwnedEntryPoint(Element start) {
		Element element = getSingleElement(start, "/mif2:staticModel/mif2:entryPoint");
		if (element != null) {
			return element.getAttribute("id");
		} else {
			throw new MifProcessingException("Document does not contain an owned entry point.");
		}
	}
	
	public static Element getClassElement(Element specializedClass) {
		Element element = getSingleElement(specializedClass, "./mif2:class");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException(specializedClass.getTagName() + " should have had a mif:class as a sub-element");
		}
	}

	public static List<Element> getContainedClasses(Document document) {
		NodeList nodes = getNodes(document.getDocumentElement(), ".//mif2:containedClass");
		return MifXPathHelper.toElementList(nodes);
	}

	public String getRootType(Element ownedEntryPoint) {
		return ownedEntryPoint.getAttribute("className");
	}

	public static boolean isMifClassPresent(Element element) {
		return null != getSingleElement(element, "./mif2:class");
	}

	String getBusinessName(Element element) {
		return getAttribute(element, "./mif2:businessName/@name");
	}
	public List<String> getDocumentation(Element classElement) {
		List<Element> elements = toElementList(getNodes(classElement, "./mif2:annotations//mif2:text/html:p"));
		List<String> result = new ArrayList<String>();
		for (Element paragraph : elements) {
			String text = StringUtils.trim(NodeUtil.getTextValue(paragraph, true));
			if (StringUtils.isNotBlank(text)) {
				result.add(text);
			}
		}
		return result;
	}
	
	public static String getAttributeType(Element attribute) {
		Element element = getSingleElement(attribute, "./mif2:type");
		String type = element.getAttribute("name");
		type += getDatatypeArguments(element);
		return type;
	}
	
	private static String getDatatypeArguments(Element start) {
		StringBuilder builder = new StringBuilder();
		List<Element> elements = toElementList(MifXPathHelper.getNodes(start, "./mif2:argumentDatatype"));
		for (Element element : elements) {
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(element.getAttribute("name"));
			builder.append(getDatatypeArguments(element));
		}
		return builder.length() == 0 ? "" : ("<" + builder.toString() + ">");
	}

	public static String getDomainType(Element element) {
		String domain = getAttribute(element, "./mif2:vocabulary/mif2:code/@codeSystemName");
		if (StringUtils.isBlank(domain)) {
			domain = getAttribute(element, "./mif2:vocabulary/mif2:conceptDomain/@name");
		}
		if (StringUtils.isBlank(domain)) {
			domain = getAttribute(element, "./mif2:vocabulary/mif2:valueSet/@name");
		}
		return domain;
	}

	public static CodingStrength getCodingStrength(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif2:supplierDomainSpecification/@codingStrength");
		if (StringUtils.isBlank(result)) {
			result = getAttribute(mifAttribute, "./mif2:vocabulary/mif2:valueSet/@codingStrength");
		}
		return StringUtils.isBlank(result) ? null : EnumPattern.valueOf(CodingStrength.class, result);
	}

	public static List<Element> getAssociations(Document document) {
		return toElementList(getNodes(
				document.getDocumentElement(), "./mif2:association"));
	}

	public static Element getTraversableConnection(Element association) {
		Element connection = getSingleElement(association, "./mif2:traversableConnection");
		if (connection != null) {
			return connection;
		} else {
			throw new MifProcessingException("No traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}

	public static String getNonTraversableConnectionClassName(Element association) {
		String connection = getAttribute(association, "./mif2:nonTraversableConnection/@participantClassName");
		if (StringUtils.isNotBlank(connection)) {
			return connection;
		} else {
			throw new MifProcessingException("No traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}

	public static boolean isChoiceItemPresent(Element element) {
		return getNodes(element, "./mif2:choiceItem").getLength() > 0;
	}

	public static Element getTemplateParameter(Element targetConnection) {
		String name = targetConnection.getAttribute("participantClassName");
		return getSingleElement(targetConnection, "//mif2:containedClass/mif2:templateParameter[@name='" + name + "']");
	}

	public static Element findCmetReference(Element element, String partName) {
		return getSingleElement(element, "/.//mif2:containedClass/mif2:commonModelElementRef[@name='" + partName + "']");
	}

	public static List<Element> getChoiceItems(Element parent) {
		return toElementList(getNodes(parent, "./mif2:choiceItem"));
	}

	public static List<Element> getSpecializationChilds(Element element) {
		return toElementList(getNodes(element, "./mif2:class/mif2:childClass"));
	}

	public static String getTemplateParameterName(Element targetConnection) {
		return getAttribute(targetConnection, "./mif2:participantClass/mif2:templateParameter/@name");
	}
}
