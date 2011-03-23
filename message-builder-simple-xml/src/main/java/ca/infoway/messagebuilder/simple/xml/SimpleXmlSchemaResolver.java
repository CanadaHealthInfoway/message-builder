package ca.infoway.messagebuilder.simple.xml;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class SimpleXmlSchemaResolver implements LSResourceResolver {

	public LSInput resolveResource(String type, String namespaceURI, String publicId,
			String systemId, String baseURI) {
		
		if ("http://www.w3.org/2001/XMLSchema".equals(type) 
				&& StringUtils.endsWith(systemId, "/simpleDataTypes.xsd")) {
			return new LSInputImpl("/simpleDataTypes.xsd");
		} else if ("http://www.w3.org/2001/XMLSchema".equals(type)) {
			return new LSInputImpl(systemId, "/ca/infoway/messagebuilder/model/" + systemId);
		} else {
			return null;
		}
	}
}
