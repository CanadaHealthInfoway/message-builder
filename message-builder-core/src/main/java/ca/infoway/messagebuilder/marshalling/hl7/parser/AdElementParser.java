package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

/**
 * AD - Address
 * 
 * Parses a AD element into an Address. The element looks like this:
 * 
 * <addr use='WP'>
 *    <houseNumber>1050</houseNumber>
 *    <direction>W</direction>
 *    <streetName>Wishard Blvd</streetName>,
 *    <additionalLocator>RG 5th floor</additionalLocator>,
 *    <city>Indianapolis</city>, <state>IN</state>
 *    <postalCode>46240</postalCode>
 * </addr>
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 */
@DataTypeHandler({"AD", "AD.BASIC", "AD.FULL", "AD.SEARCH"})
class AdElementParser extends AbstractSingleElementParser<PostalAddress> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ADImpl();
	}
    
    @Override
    protected PostalAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
        PostalAddress result = parseNode(node);
        result.setUses(getNameUses(getAttributeValue(node, "use")));
        return result;
    }
    
    private Set<PostalAddressUse> getNameUses(String nameUseAttribute) {
        Set<PostalAddressUse> uses = new HashSet<PostalAddressUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                PostalAddressUse postalAddressUse = CodeResolverRegistry.lookup(PostalAddressUse.class, token);
                if (postalAddressUse != null) {
                    uses.add(postalAddressUse);
                }
            }
        }
        return uses;
    }
    
    private PostalAddress parseNode(Node node) throws XmlToModelTransformationException {
        PostalAddress result = new PostalAddress();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (isNonBlankTextNode(childNode)) {
                String value = childNode.getNodeValue();
                result.addPostalAddressPart(new PostalAddressPart(value));
                
            } else if (childNode instanceof Element) {
                Element element = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(element);
                String value = getTextValue(element);
                result.addPostalAddressPart(new PostalAddressPart(getPostalAddressPartType(name), value));
            }
        }
        return result;
    }

	private boolean isNonBlankTextNode(Node childNode) {
		return childNode.getNodeType() == Node.TEXT_NODE 
			&& !StringUtils.isBlank(childNode.getNodeValue());
	}
    
    private PostalAddressPartType getPostalAddressPartType(String type) throws XmlToModelTransformationException {
    	return getNamePartType(PostalAddressPartType.class, type);
    }

    private String getTextValue(Element element) throws XmlToModelTransformationException {
        Node childNode = element.getFirstChild();
        if (childNode == null) {
        	return null;
        }
        else if (childNode.getNodeType() != Node.TEXT_NODE) {
            throw new XmlToModelTransformationException("Expected AD child node to have a text node");
        }
        return childNode.getNodeValue();
    }

}
