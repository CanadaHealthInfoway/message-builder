package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * EN - EntityName
 * 
 * Parses an EN element into a EntityName. The element looks like this:
 * 
 * <element-name>This is a trivial name</element-name>
 * 
 * This class makes a decision on which parser to use based on the format of the
 * XML.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-EN
 */
@DataTypeHandler("EN")
class EnElementParser extends AbstractSingleElementParser<EntityName> {

    private final AbstractEntityNameElementParser onElementParser = new OnElementParser();
    private final PnElementParser pnElementParser = new PnElementParser();
    private final TnElementParser tnElementParser = new TnElementParser();

    @Override
	protected EntityName parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
    	EntityName result;
        
        if (tnElementParser.isParseable(node)) {
            result = (EntityName) tnElementParser.parse(null, node, xmlToJavaResult).getBareValue();
            
        } else if (onElementParser.isParseable(node)) {
            result = (EntityName) onElementParser.parse(null, node, xmlToJavaResult).getBareValue();
            
        } else if (pnElementParser.isParseable(node)) {
            result = (EntityName) pnElementParser.parse(null, node, xmlToJavaResult).getBareValue();
            
        } else {
            throw new XmlToModelTransformationException("Cannot figure out how to parse node " + node.toString());
        }

        return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ENImpl<EntityName>();
	}
}
