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

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.SCImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * SC - Coded String (CS was already taken for coded simple)
 * 
 * Parses an SC element into a CodedString. The element looks like this:
 * 
 * <element-name>Assistant to the Regional Manager</element-name>
 * <element-name code="RM">Regional Manager</element-name>
 *
 * HL7 defines other optional attributes such as code system version and description.
 * 
 * Currently this class does nothing with codeSystem.
 * 
 * This class is a mix of StElementParser and CvElementParser.
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SC
 * 
 * TODO: handle code properly
 */
@DataTypeHandler("SC")
class ScElementParser<V extends Code> extends AbstractSingleElementParser<CodedString<V>> {

	@Override
	protected CodedString<V> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		
		String value = null;
		int childNodeCount = node.getChildNodes().getLength();
		
		if (childNodeCount == 0) {
			// this is an empty node, return empty string (null should have a null flavor attribute)
            value = EMPTY_STRING;
			
		} else if (childNodeCount == 1) {
			Node childNode = node.getFirstChild();
			if (childNode.getNodeType() != Node.TEXT_NODE) {
				throw new XmlToModelTransformationException("Expected SC node to have a text node");
			}
            value = childNode.getNodeValue();
			
		} else {
			throw new XmlToModelTransformationException("Expected SC node to have at most one child");
		}
        
		return new CodedString<V>(value, null);
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new SCImpl<V>();
	}
}
