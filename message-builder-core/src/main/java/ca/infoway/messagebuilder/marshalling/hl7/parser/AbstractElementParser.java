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
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.schema.XmlSchemas;

public abstract class AbstractElementParser implements ElementParser {

	protected static final String SPECIALIZATION_TYPE = "specializationType";

	public abstract BareANY parse(ParseContext context, List<Node> node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException;
	
	protected String getAttributeValue(Node node, String attributeName) {
		return node != null && node instanceof Element ? getAttributeValue((Element) node, attributeName) : null;
	} 

	protected String getSpecializationType(Node node) {
		String specializationType = node != null && node instanceof Element ? getAttributeValue((Element) node, SPECIALIZATION_TYPE) : null;
		// specialization types defined as A<B.C> are not a problem.
		// specialization types defined as A_B.C (the way MB formats specializationType!) are not handled properly, so convert the value here
		if (specializationType != null && specializationType.contains("_")) {
			specializationType = specializationType.replaceAll("_", "<") + ">";
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
}
