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

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * TN - TrivialName
 * 
 * Parses a TN element into a TrivialName. The element looks like this:
 * 
 * <element-name>This is a trivial name</element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TN
 */
@DataTypeHandler("TN")
class TnElementParser extends AbstractEntityNameElementParser {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TNImpl();
	}

    @Override
	protected EntityName parseNode(Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
        String name = null;
        int childNodeCount = node.getChildNodes().getLength();
        
        if (childNodeCount == 0) {
            // name portion is null
            
        } else if (childNodeCount == 1) {
            Node childNode = node.getFirstChild();
            if (childNode.getNodeType() != Node.TEXT_NODE) {
                throw new XmlToModelTransformationException("Expected TN node to have a text node");
            }
            name = childNode.getNodeValue();
            
        } else {
            throw new XmlToModelTransformationException("Expected TN node to have at most one child");
        }
        
        return new TrivialName(name);
    }

}
