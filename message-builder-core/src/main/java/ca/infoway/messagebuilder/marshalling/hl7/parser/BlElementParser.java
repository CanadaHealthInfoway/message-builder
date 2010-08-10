package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * Parses an BL element into a Boolean. The element looks like this:
 * 
 * <element-name value="true" />	<!-- or value="false" -->
 * 
 * If a BL is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-BL
 */
@DataTypeHandler("BL")
public class BlElementParser extends AbstractSingleElementParser<Boolean> {

	private static List<String> VALID_BOOLEAN_STRINGS = new ArrayList<String>();
	
	static {
		VALID_BOOLEAN_STRINGS.add("true");
		VALID_BOOLEAN_STRINGS.add("false");
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new BLImpl();
	}
	
	@Override
	protected Boolean parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		return parseNonNullNode(context, (Element) node, xmlToJavaResult);
	}

	private Boolean parseNonNullNode(ParseContext context, Element element,
			XmlToModelResult xmlToJavaResult) {
		return parseBooleanValue(xmlToJavaResult, getAttributeValue(element, "value"), element, null);
	}

	public Boolean parseBooleanValue(XmlToModelResult result, 
			String unparsedBoolean, Element element, Attr attr) {
		if (StringUtils.isBlank(unparsedBoolean)) {
			result.addHl7Error(Hl7Error.createMandatoryBooleanValueError(element, attr));
			return null;
		} else if (VALID_BOOLEAN_STRINGS.contains(unparsedBoolean)) {
			return Boolean.valueOf(unparsedBoolean);
		} else if (VALID_BOOLEAN_STRINGS.contains(unparsedBoolean.toLowerCase())) {
			result.addHl7Error(Hl7Error.createIncorrectCapitalizationBooleanValueError(unparsedBoolean, element, attr));
			return Boolean.valueOf(unparsedBoolean);
		} else {
			result.addHl7Error(Hl7Error.createInvalidBooleanValueError(element, attr));
			return null;
		}
	}

}