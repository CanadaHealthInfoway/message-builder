package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * II - Installer Identifier
 * 
 * Parses an II element into a II object. The element looks like this:
 * 
 * <element-name root="data1" extension="data2" />
 * 
 * CeRx standards claim that both attributes are required, although extension 
 * is sometimes unused.
 * 
 * The HL7 standard defines the assigningAuthorityName attribute, but that
 * has been left out of the CeRx implementation.
 * 
 * According to CeRx: Root has a limit of 100 characters, extension of 20 
 * characters. These limits are not currently enforced by this class. 
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
 */
@DataTypeHandler("II")
class IiElementParser extends AbstractSingleElementParser<Identifier> {
	
	private static final String II = "II";
	private static final String II_TOKEN = "II.TOKEN";
	private static final String II_BUS = "II.BUS";
	private static final String II_PUBLIC = "II.PUBLIC";
	private static final String II_OID = "II.OID";
	private static final String II_VER = "II.VER";

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IIImpl();
	}
	
	@Override
	protected Identifier parseNonNullNode(ParseContext context, Node node, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		return parseNonNull(context, (Element) node, xmlToJavaResult);
	}

	private Identifier parseNonNull(ParseContext context, Element element,
			XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {
		String root = getMandatoryAttributeValue(element, "root", xmlToJavaResult);
		String extension = getAttributeValue(element, "extension");
		
		if (StringUtils.isBlank(root)) {
			// skip it... already handled
		} else if (II_TOKEN.equals(context.getType())) {
			validateRootAsUuid(element, root, xmlToJavaResult);
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "extension");
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "use");
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "displayable");
		} else if (II_BUS.equals(context.getType())) {
			if (!isUuid(root)) {
				validateRootAsOid(root, element, xmlToJavaResult);
			} else {
				validateRootAsUuid(element, root, xmlToJavaResult);
				validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "extension");
			}
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "displayable");
			validateAttributeEquals(context.getType(), element, xmlToJavaResult, "use", "BUS");
		} else if (II_OID.equals(context.getType())) {
			validateRootAsOid(root, element, xmlToJavaResult);
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "extension");
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "use");
			validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "displayable");
		} else if (II_PUBLIC.equals(context.getType())) {
			validateRootAsOid(root, element, xmlToJavaResult);
			validateAttributeEquals(context.getType(), element, xmlToJavaResult, "displayable", "true");
		}
		validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "assigningAuthorityName");
		return new Identifier(root, extension);
	}


	private void validateAttributeEquals(String type, Element element,
			XmlToModelResult xmlToJavaResult, String attributeName, String attributeValue) {
		if (!element.hasAttribute(attributeName)) {
			xmlToJavaResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, 
					MessageFormat.format(
							"Data type " + type + " requires the attribute {0}=\"{1}\" ({2})",
							attributeName, XmlStringEscape.escape(attributeValue), 
							XmlDescriber.describeSingleElement(element)),
					element));
		} else if (!StringUtils.equals(element.getAttribute(attributeName), attributeValue)) {
			xmlToJavaResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, 
					MessageFormat.format(
							"Data type " + type + " expected the attribute {0}=\"{1}\" ({2})",
							attributeName, XmlStringEscape.escape(attributeValue), 
							XmlDescriber.describeSingleElement(element)),
					element));
		}
	}


	private void validateRootAsUuid(Element element, String root, XmlToModelResult xmlToJavaResult) {
		if (!isUuid(root)) {
			xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "root '" + root + "' should be a UUID. ("
					+ XmlDescriber.describeSingleElement(element) +")"));
		}
	}

	private boolean isUuid(String root) {
		try {
			UUID.fromString(root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void validateRootAsOid(String root, Element element, XmlToModelResult xmlToJavaResult) {
		if (!isOid(root)) {
			xmlToJavaResult.addHl7Error(
					new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							"The oid, \"" + root + "\" does not appear to be a valid oid", element));
		}
	}

	boolean isOid(String root) {
		if (StringUtils.isBlank(root) || !root.contains(".")) {
			return false;
		} else {
			boolean oid = true;
			while (root.contains(".")) {
				String prefix = StringUtils.substringBefore(root, ".");
				oid &= (StringUtils.isNotBlank(prefix) && StringUtils.isNumeric(prefix)); 
				root = StringUtils.substringAfter(root, ".");
			}
			
			if (StringUtils.isBlank(root)) {
				oid = false;
			} else {
				oid &= StringUtils.isNumeric(root);
			}
			
			return oid;
		}
	}


}
