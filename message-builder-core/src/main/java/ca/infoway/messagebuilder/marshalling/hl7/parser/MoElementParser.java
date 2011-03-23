package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * MO - Money
 * 
 * Represents an MO elements into a MO object. The element looks like this:
 * 
 * <amt value="10" currency="CAD"/>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoElementParser extends AbstractSingleElementParser<Money> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new MOImpl();
	}
	
	@Override
	protected Money parseNonNullNode(ParseContext context, Node node, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		
		validateNoChildren(context, node);

		String value = getMandatoryAttributeValue(node, "value", xmlToJavaResult);
		BigDecimal amount = StringUtils.isBlank(value) ? null : new BigDecimal(value);
        String currencyCode = getMandatoryAttributeValue(node, "currency", xmlToJavaResult);
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
        
        if (currency == null) {
            xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
            		"Could not decode currency value " + currencyCode + " (" + XmlDescriber.describeSingleElement((Element) node)
            		+ ")"));
        }

		return new Money(amount, currency);
	}

}
