package ca.infoway.messagebuilder.generator;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

class EntryPointAssembler {

	public static String getEntryPoint(Element element) {
		return getEntryPoint(element.getAttribute("subSection"), 
				element.getAttribute("domain"), 
				element.getAttribute("artifact"), 
				element.getAttribute("id"), 
				element.hasAttribute("realmNamespace") 
					? element.getAttribute("realmNamespace")
					: element.getAttribute("realm"));
	}

	public static String getEntryPoint(String subSection, String domain, String artifact, String id, String realm) {
		StringBuilder buffer = new StringBuilder();
		if (isNotBlank(subSection) && 
				isNotBlank(domain) &&
				isNotBlank(artifact) &&
				isNotBlank(id) &&
				isNotBlank(realm)) {
			buffer.append(subSection)
					.append(domain)
					.append("_")
					.append(sanitize(artifact))
					.append(id)
					.append(realm);
		}
		return buffer.toString().toUpperCase();
	}

	private static String sanitize(String attribute) {
		return StringUtils.chomp(attribute, "-deprecated");
	}

}
