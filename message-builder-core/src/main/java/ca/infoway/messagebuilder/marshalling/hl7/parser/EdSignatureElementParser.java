package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * ED.SIGNATURE - Encapsulated Data (Signature)
 * 
 * Parses a ED.SIGNATURE element into a String:
 * 
 * <element-name mediaType="text/xml">
 *   <signature xmlns="http://www.w3.org/2000/09/xmldsig#">signatureString</signature>
 * </element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 *
 * This appears to be correct, although all of the examples name the outer element as "text".
 *
 * CeRx notes that this is an evolving standard.
 */
@DataTypeHandler("ED.SIGNATURE")
class EdSignatureElementParser extends AbstractSingleElementParser<String> {

	private final StElementParser stElementParser = new StElementParser();
	
	@Override
	protected String parseNonNullNode(ParseContext context, Node node, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		
		String result = null;
		
		Node signatureNode = getNamedChildNode(node, "signature");
		if (signatureNode == null || signatureNode.getNodeType() != Node.ELEMENT_NODE) {
			xmlToJavaResult.addHl7Error(createHl7Error());
		} else {
			result = (String) this.stElementParser.parse(context, signatureNode, xmlToJavaResult).getBareValue();
		}
		
		return result;
	}
	
    private Hl7Error createHl7Error() {
    	return new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Expected ED.SIGNATURE node to have a child element named signature");
    }

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EDImpl<String>();
	}
}
