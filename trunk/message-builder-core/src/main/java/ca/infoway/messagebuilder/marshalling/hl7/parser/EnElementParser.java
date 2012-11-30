/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * EN - EntityName
 * 
 * Parses an EN element into a EntityName. The element looks like this:
 * 
 * <element-name>This is a trivial name</element-name>
 * 
 * This class makes a decision on which parser to use based on the format of the
 * XML.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-EN
 */
@DataTypeHandler("EN")
class EnElementParser extends AbstractSingleElementParser<EntityName> {

    private final AbstractEntityNameElementParser onElementParser = new OnElementParser();
    private final PnElementParser pnElementParser = new PnElementParser();
    private final TnElementParser tnElementParser = new TnElementParser();

    @Override
	protected EntityName parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	EntityName result;
        
        if (tnElementParser.isParseable(node, context)) {
            result = (EntityName) tnElementParser.parse(context, node, xmlToModelResult).getBareValue();
            
        } else if (onElementParser.isParseable(node, context)) {
            result = (EntityName) onElementParser.parse(context, node, xmlToModelResult).getBareValue();
            
        } else if (pnElementParser.isParseable(node, context)) {
            result = (EntityName) pnElementParser.parse(context, node, xmlToModelResult).getBareValue();
            
        } else {
            throw new XmlToModelTransformationException("Cannot figure out how to parse node " + node.toString());
        }

        return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ENImpl<EntityName>();
	}
}
