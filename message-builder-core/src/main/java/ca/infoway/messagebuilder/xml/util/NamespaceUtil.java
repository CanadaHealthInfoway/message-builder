package ca.infoway.messagebuilder.xml.util;

import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * <p>A utility to determine if an XML node is in the HL7 namespace.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class NamespaceUtil {

	private static final String HL7_NAMESPACE_URI = "urn:hl7-org:v3";

	/**
	 * <p>Determine if the node in the HL7 namespace.
	 * @param node - the node being considered
	 * @return true if the node is part of the HL7 namespace; false otherwise
	 */
	public static boolean isHl7Node(Node node) {
		if (HL7_NAMESPACE_URI.equals(node.getNamespaceURI())) {
			return true;
		} else if (node instanceof Attr && (node.getNamespaceURI() == null || node.getNamespaceURI()=="")) {
			return HL7_NAMESPACE_URI.equals(((Attr) node).getOwnerElement().getNamespaceURI());
		} else {
			return false;
		}
	}
}
