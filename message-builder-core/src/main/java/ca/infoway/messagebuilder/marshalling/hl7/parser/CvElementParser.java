package ca.infoway.messagebuilder.marshalling.hl7.parser;


import static ca.infoway.messagebuilder.datatype.StandardDataType.CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CV;
import static ca.infoway.messagebuilder.util.xml.XmlDescriber.describeSingleElement;

import java.lang.reflect.Type;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * CV - Coded Value
 * 
 * Parses an CV element into a CV enum field. The element looks like this:
 * 
 * <element-name code="RECENT" />
 * 
 * According to CeRx: code has a limit of 20 characters. This limit is not 
 * currently enforced by this class.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CV
 * 
 * CeRx states that attribute codeSystem is mandatory if code is specified. However,
 * none of the sample messages do this and the HL7 definition of the message domains
 * do not specify what the codeSystem is for different domains.
 * 
 * There's also an originalText attribute that must be included if code is specified. 
 * Again, the HL7 domain definitions are of little help with that.
 * 
 * Finally: there are two types of attributes that that use this datatype.
 * 
 * CNE (coded no extensibility): code attribute is mandatory.
 * CWE (coded with extensibility): code attribute is required (that is, must be supported
 * but not mandatory. originalText may be specified if code is not entered.
 * 
 * Currently this class does nothing with codeSystem or originalText. Therefore it is
 * identical to the CS class.
 */
@DataTypeHandler({"CV", "CD", "CE"})
class CvElementParser extends AbstractCodeTypeElementParser {

	private static final String CODE_SYSTEM_ATTRIBUTE_NAME = "codeSystem";

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new CVImpl();
	}
	
    @SuppressWarnings("unchecked")
	@Override
    protected Code parseNonNullNode(
    		ParseContext context, Element element, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {

    	performStandardValidations(context, element, xmlToJavaResult);
    	
    	if (isCWE(context)) {
    		if (!element.hasAttribute("code") && !hasOriginalText(element)) {
    			xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    					MessageFormat.format(
    						"Either \"code\" or \"originalText\" property must be provided ({0}).", 
    						describeSingleElement(element)),
    					element));
    		}
    	} else if (isCNE(context)) {
    		if (hasOriginalText(element) && !hasValidNullFlavorAttribute(context, element, xmlToJavaResult)) {
    			xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    					MessageFormat.format(
    						"\"OriginalText\" is not allowed for non-null CNE values. ({0}).", 
    						describeSingleElement(element)),
    					element));
    		}
    	}

    	Class<? extends Code> codeType = getReturnTypeAsCodeType(expectedReturnType);
    	
    	Code code = getCorrespondingCode(context, element, codeType, xmlToJavaResult);

        return code;
    }

	private void performStandardValidations(
			ParseContext context, Element element, XmlToModelResult result) {
		validateUnallowedAttributes(context.getType(), element, result, "codeSystemName");
    	validateUnallowedAttributes(context.getType(), element, result, "codeSystemVersion");
    	validateUnallowedAttributes(context.getType(), element, result, "displayName");
    	
    	if (CV.getType().equals(context.getType())) {
    		validateUnallowedChildNode(context.getType(), element, result, "translation");
    		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
    	} else if (CD.getType().equals(context.getType())) {
    		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
    	}
	}
    
    @Override
    protected NullFlavor parseNullNode(ParseContext context, Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
    	NullFlavor nullFlavor = super.parseNullNode(context, node, xmlToJavaResult);
    	
    	if (!hasOriginalText((Element) node) && isOtherNullFlavor(nullFlavor) && isCNE(context)) {
    		xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    				MessageFormat.format("Data type \"{0}\" with coding strength of \"{1}\" " +
    						"must include <originalText> if nullFlavor is \"OTH\" ({2})",
    						context.getType(), context.getCodingStrength(),
    						XmlDescriber.describeSingleElement((Element)node)),
    						(Element) node));
    	}
    	
        return nullFlavor;
    }

	private boolean isOtherNullFlavor(NullFlavor nullFlavor) {
		return ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER == nullFlavor;
	}

    private boolean isInterface(Class<? extends Code> codeType) {
        return codeType.isInterface();
    }

    private Code getCorrespondingCode(ParseContext context, Element element, 
    		Class<? extends Code> codeType, XmlToModelResult xmlToJavaResult) 
    		throws XmlToModelTransformationException {
    	
        String code = isMandatory(context) && isCNE(context)
        		? getMandatoryAttributeValue(element, "code", xmlToJavaResult) 
        		: getAttributeValue(element, "code");
		String codeSystem = (isMandatory(context) && isCNE(context)) || StringUtils.isNotBlank(code)
        		? getMandatoryAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME, xmlToJavaResult) 
				: getAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME);
        		
		Code result = getCode(codeType, code, codeSystem);

//		FIXME - AG: get this back in at some point in time.
		if (result==null && !StringUtils.isEmpty(codeSystem) && isInterface(codeType)) {
			result = FullCodeWrapper.wrap(codeType, null, codeSystem);
		}
		
        // if a code is specified and there is no matching enum value for it,
		// something is seriously wrong
        if (StringUtils.isNotBlank(code) && result == null) {
        	xmlToJavaResult.addHl7Error(createHl7Error(element, codeType, code));
        }
    	return result;
    }

	private Code getCode(Type expectedReturnType, String codeValue, String codeSystem) {
		Class<? extends Code> returnType = getReturnTypeAsCodeType(expectedReturnType);
		CodeResolver resolver = CodeResolverRegistry.getResolver(returnType);
		return resolver.<Code>lookup(returnType, codeValue, codeSystem);
	}
    
	private boolean isCNE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CNE;
	}
	private boolean isCWE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CWE;
	}

	private boolean isMandatory(ParseContext context) {
		return context.getConformance() == ConformanceLevel.MANDATORY;
	}

}
