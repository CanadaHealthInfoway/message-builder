package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class NullFlavorHelper {
	
	static final String NULL_FLAVOR_ATTRIBUTE_NAME = "nullFlavor";

	private final Node node;
	private final XmlToModelResult xmlToJavaResult;
	private final ConformanceLevel conformanceLevel;

	public NullFlavorHelper(ConformanceLevel conformanceLevel, Node node, XmlToModelResult xmlToJavaResult) {
		this.conformanceLevel = conformanceLevel;
		this.node = node;
		this.xmlToJavaResult = xmlToJavaResult;
	}

	public NullFlavor parseNullNode() {
		String attributeValue = getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME);
		NullFlavor nullFlavor = ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.lookup(attributeValue);
		
		if (this.conformanceLevel != null && this.conformanceLevel == ConformanceLevel.MANDATORY) {
			xmlToJavaResult.addHl7Error(Hl7Error.createMandatoryAttributeIsNullError(
					NodeUtil.getLocalOrTagName((Element) node), 
					getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME),
					(Element) node));
		} else if (this.conformanceLevel != null && this.conformanceLevel == ConformanceLevel.REQUIRED) {
			xmlToJavaResult.addHl7Error(Hl7Error.createRequiredAttributeIsNullError(
					NodeUtil.getLocalOrTagName((Element) node), 
					getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME),
					(Element) node));
		} 
		return nullFlavor;
	}
	
    public boolean hasValidNullFlavorAttribute() {
		String attributeValue = getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME);
		if (attributeValue==null) {
			return false;
		} else if (StringUtils.isEmpty(attributeValue) || ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.lookup(attributeValue)==null) {
			xmlToJavaResult.addHl7Error(
					new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM,
							MessageFormat.format("The nullFavor attribute value \"{0}\" is not valid ({1})", 
									attributeValue, 
									XmlDescriber.describeSingleElement((Element) node)),
									(Element) node));
			return false;
		}
		return true;
	}

	private String getAttributeValue(Node node, String attributeName) {
		return node != null && node instanceof Element ? getAttributeValue((Element) node, attributeName) : null;
	} 
	
	protected String getAttributeValue(Element node, String attributeName) {
		return node != null && node.hasAttribute(attributeName) ? node.getAttribute(attributeName) : null;
	}
	
}
