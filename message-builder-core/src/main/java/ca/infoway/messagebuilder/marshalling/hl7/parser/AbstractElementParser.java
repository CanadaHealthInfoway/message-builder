/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.schema.XmlSchemas;

public abstract class AbstractElementParser implements ElementParser {

	private static final String RTO_DATATYPE = "RTO";
	protected static final String SPECIALIZATION_TYPE = "specializationType";
	private static final String DATATYPE_CA_SUFFIX = ".CA";
	private static final int DATATYPE_CA_SUFFIX_LENGTH = DATATYPE_CA_SUFFIX.length();
	

	public abstract BareANY parse(ParseContext context, List<Node> node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException;
	
	protected String getAttributeValue(Node node, String attributeName) {
		return node != null && node instanceof Element ? getAttributeValue((Element) node, attributeName) : null;
	} 

	protected String getSpecializationType(Node node) {
		String specializationType = node != null && node instanceof Element ? getAttributeValue((Element) node, SPECIALIZATION_TYPE) : null;
		return convertSpecializationType(specializationType);
	}

	public String convertSpecializationType(String specializationType) {
		// specialization types defined as A<B.C> are not a problem.
		// specialization types defined as A_B.C (the way MB formats specializationType!) are not handled properly, so convert the value here
		if (specializationType != null) {
			specializationType = specializationType.toUpperCase();
			specializationType = removeCaFromSpecializationType(specializationType);
			specializationType = handleRtoInSpecializationType(specializationType);
			specializationType = handleUnderscoresInSpecializationType(specializationType);
		}
		return specializationType;
	}

	private String handleUnderscoresInSpecializationType(String specializationType) {
		// now convert the type to a format that MB recognizes (i.e. A<B.C>)
		int numUnderscores = StringUtils.split(specializationType, "_").length - 1;
		specializationType = specializationType.replaceAll("_", "<") + StringUtils.repeat(">", numUnderscores);
		return specializationType;
	}

	private String handleRtoInSpecializationType(String specializationType) {
		// assumes the only datatype with multiple args is RTO (which is handled as a special case)
		boolean isRto = specializationType.startsWith(RTO_DATATYPE) || specializationType.contains("_" + RTO_DATATYPE);
		if (isRto) {
			// special handling for RTO's multiple arguments the first "_" after "RTO_" should be changed to a comma
			int rtoIndex = specializationType.indexOf(RTO_DATATYPE + "_");
			int underscoreToReplace = specializationType.indexOf("_", rtoIndex + 4);
			if (rtoIndex > -1 && underscoreToReplace > -1) {
				specializationType = specializationType.substring(0, underscoreToReplace) + "," + specializationType.substring(underscoreToReplace + 1);
			}
		}
		return specializationType;
	}

	private String removeCaFromSpecializationType(String specializationType) {
		// 1) remove ending .CA and 2) replace .CA_ with _ (to handle any types named X.CAYYY, such as MO.CAD)
		// the above also leaves ANY.CA.IZ alone, which is what we want!
		if (specializationType.contains(DATATYPE_CA_SUFFIX)) {
			if (specializationType.endsWith(DATATYPE_CA_SUFFIX)) {
				specializationType = specializationType.substring(0, specializationType.length() - DATATYPE_CA_SUFFIX_LENGTH);
			}
			specializationType = specializationType.replaceAll(DATATYPE_CA_SUFFIX + "_", "_");
		}
		return specializationType;
	} 
	
	protected String getAttributeValue(Element node, String attributeName) {
		return node != null && node.hasAttribute(attributeName) ? node.getAttribute(attributeName) : null;
	}

	protected String getXsiType(Node node) {
		return node != null && node instanceof Element ? getXsiType((Element)node) : null;
	}
	
	protected String getXsiType(Element element) {
		return element.getAttributeNS(XmlSchemas.SCHEMA_INSTANCE, "type");
	}

	protected Type getReturnType(ParseContext context) {
		return context == null ? null : context.getExpectedReturnType();
	}
	
    protected List<Element> getNamedElements(String name, Element parentElement) {
    	List<Element> elements = new ArrayList<Element>();
		NodeList nodes = parentElement.getElementsByTagName(name);
		for (int i = 0; i < nodes.getLength(); i++) {
			Element foundElement = (Element) nodes.item(i);
			if (foundElement.getParentNode().isSameNode(parentElement)) {
				elements.add(foundElement);
			}
		}
		return elements;
    }
	
}
