/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * ED.SIGNATURE - Encapsulated Data (Signature)
 * 
 * Parses a ED.SIGNATURE element into a String:
 * 
 * <element-name mediaType="text/xml">
 *   <signature xmlns="http://www.w3.org/2000/09/xmldsig#">signatureString</signature>
 * </element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 *
 * This appears to be correct, although all of the examples name the outer element as "text".
 *
 * CeRx notes that this is an evolving standard.
 */
@DataTypeHandler("ED.SIGNATURE")
class EdSignatureElementParser extends AbstractSingleElementParser<String> {

	private final StElementParser stElementParser = new StElementParser();
	
	@Override
	protected String parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		
		String result = null;
		
		Node signatureNode = getNamedChildNode(node, "signature");
		if (signatureNode == null || signatureNode.getNodeType() != Node.ELEMENT_NODE) {
			xmlToJavaResult.addHl7Error(createHl7Error((Element) node));
		} else {
			result = (String) this.stElementParser.parse(context, signatureNode, xmlToJavaResult).getBareValue();
		}
		
		return result;
	}
	
    private Hl7Error createHl7Error(Element element) {
    	return new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Expected ED.SIGNATURE node to have a child element named signature", element);
    }

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EDImpl<String>();
	}
}
