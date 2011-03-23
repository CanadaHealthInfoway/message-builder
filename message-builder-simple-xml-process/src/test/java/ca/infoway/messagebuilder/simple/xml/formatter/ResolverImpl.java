package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class ResolverImpl implements LSResourceResolver {

	private final LSResourceResolver resourceResolver;

	public ResolverImpl(LSResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
	}

	public LSInput resolveResource(String type, String namespaceURI, String publicId,
			String systemId, String baseURI) {
		if ("http://www.w3.org/2001/XMLSchema".equals(type) 
				&& "/simpleDataTypes.xsd".equals(systemId)) {
			return new LSInputImpl(systemId);
		} else {
			return this.resourceResolver == null 
					? null 
					: this.resourceResolver.resolveResource(
							type, namespaceURI, publicId, systemId, baseURI);
		}
	}
}
