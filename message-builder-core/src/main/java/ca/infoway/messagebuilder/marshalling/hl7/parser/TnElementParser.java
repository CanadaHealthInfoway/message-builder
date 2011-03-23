package ca.infoway.messagebuilder.marshalling.hl7.parser;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * TN - TrivialName
 * 
 * Parses a TN element into a TrivialName. The element looks like this:
 * 
 * <element-name>This is a trivial name</element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TN
 */
@DataTypeHandler("TN")
class TnElementParser extends AbstractEntityNameElementParser {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TNImpl();
	}

    @Override
	protected EntityName parseNode(Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
        String name = null;
        int childNodeCount = node.getChildNodes().getLength();
        
        if (childNodeCount == 0) {
            // name portion is null
            
        } else if (childNodeCount == 1) {
            Node childNode = node.getFirstChild();
            if (childNode.getNodeType() != Node.TEXT_NODE) {
                throw new XmlToModelTransformationException("Expected TN node to have a text node");
            }
            name = childNode.getNodeValue();
            
        } else {
            throw new XmlToModelTransformationException("Expected TN node to have at most one child");
        }
        
        return new TrivialName(name);
    }

}
