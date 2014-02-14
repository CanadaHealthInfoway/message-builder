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
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
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

	private static OnElementParser onElementParser = new OnElementParser();
	private static PnElementParser pnElementParser = new PnElementParser();
	private static TnElementParser tnElementParser = new TnElementParser();
	
    private static final Map<String, NameParser> nameParsers = new HashMap<String, NameParser>();
    static {
		nameParsers.put("ON",  onElementParser);
		nameParsers.put("PN",  pnElementParser);
		nameParsers.put("TN",  tnElementParser);
    }
    
    @Override
	protected EntityName parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	EntityName result = null;
        
    	// The incoming xml should specify a specializationType or xsi:type in order to determine how to process the field.
    	// However, it should be possible to determine which concrete type to use by applying all known name parsers.
    	
    	String specializationType = getSpecializationType(node);
    	if (StringUtils.isBlank(specializationType)) {
    		specializationType = getXsiType(node);
    	}
    	
    	NameParser nameParser = nameParsers.get(StringUtils.upperCase(specializationType));
    	if (nameParser == null) {
    		// log error based on bad ST/XT
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "EN fields require a specializationType and/or xsi:type specifying one of TN/PN/ON", (Element) node));
    	}
    	
        if (nameParser != null && nameParser.isParseable(node, context)) {
            result = (EntityName) nameParser.parse(context, node, xmlToModelResult).getBareValue();
        } else {
        	String actualParserUsed = null;
        	// try all known name parsers
	        if (tnElementParser.isParseable(node, context)) {
	        	actualParserUsed = "TN";
	        	result = (EntityName) tnElementParser.parse(context, node, xmlToModelResult).getBareValue();
	        	
	        } else if (pnElementParser.isParseable(node, context)) {
        		actualParserUsed = "PN";
        		result = (EntityName) pnElementParser.parse(context, node, xmlToModelResult).getBareValue();
        	
        	} else if (onElementParser.isParseable(node, context)) {
        		actualParserUsed = "ON";
        		result = (EntityName) onElementParser.parse(context, node, xmlToModelResult).getBareValue();
        		
        	} else {
        		throw new XmlToModelTransformationException("Cannot figure out how to parse EN node " + node.toString());
        	}
        	
        	// need to log warning - not able to parse name as expected
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "EN field could not be parsed as specified. Field has been handled as of type " + actualParserUsed, (Element) node));
        }

        return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ENImpl<EntityName>();
	}
}
