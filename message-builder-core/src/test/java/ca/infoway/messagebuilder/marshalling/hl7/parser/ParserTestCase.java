package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;

public abstract class ParserTestCase extends CeRxDomainValueTestCase {

	protected List<Node> asList(NodeList list) {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0, length = list == null ? 0 : list.getLength(); i < length; i++) {
			result.add(list.item(i));
		}
		return result;
	}

}
