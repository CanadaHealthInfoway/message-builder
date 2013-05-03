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

import static ca.infoway.messagebuilder.datatype.StandardDataType.ST;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ST_LANG;

import java.lang.reflect.Type;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * ST - String
 *
 * Parses an ST element into a String. The element looks like this:
 *
 * <element-name>This is some text</element-name>
 *
 * Returns the value of the text node, or null if there is no node.
 *
 * HL7 defines other attributes, but notes that they are optional since
 * the values are self-evident (representation="TXT" mediaType="text/plain").
 * The CeRx documentation makes no mention of these attributes.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ST
 */
@DataTypeHandler("ST")
class StElementParser extends AbstractSingleElementParser<String> {

	@Override
	protected String parseNonNullNode(ParseContext context, Node node, BareANY dataType, Type returnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {

    	Element element = (Element) node;
    	
    	if (ST.getType().equals(context.getType()) && hasLanguageAttribute(element)) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
    				MessageFormat.format(
    						"The language attribute is not allow for ST element types ({0})",
    						XmlDescriber.describeSingleElement(element)), element));
    	} else if (ST_LANG.getType().equals(context.getType()) && !hasLanguageAttribute(element)) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
    				MessageFormat.format(
    						"The language attribute is required for ST.LANG element types ({0})",
    						XmlDescriber.describeSingleElement(element)), element));
    	} else if (ST_LANG.getType().equals(context.getType()) && hasLanguageAttribute(element) && !languageSupported(element)) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
    				MessageFormat.format(
    						"The language attribute is not one of the supported types ({0})",
    						XmlDescriber.describeSingleElement(element)), element));
    	}
    	
        String result = null;
        int childNodeCount = node.getChildNodes().getLength();

        if (childNodeCount == 0) {
        	if (context.getConformance() == ConformanceLevel.MANDATORY) {
        		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
        				MessageFormat.format("The string value should not be empty ({0})", XmlDescriber.describeSingleElement(element)), 
        				element));
        	}
        	
            // this is an empty node, return empty string (null should have a null flavor attribute)
            result = EMPTY_STRING;
            
        } else if (childNodeCount == 1) {
            Node childNode = node.getFirstChild();
            if (childNode.getNodeType() != Node.TEXT_NODE) {
                throw new XmlToModelTransformationException("Expected ST node to have a text node");
            }
            result = childNode.getNodeValue();

        } else {
            throw new XmlToModelTransformationException("Expected ST node to have at most one child");
        }
        
        if (context.getLength() != null && result.length() > context.getLength()) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
    				MessageFormat.format(
    						"The specified string (\"{0}\") exceeds the maximum length of {1}.  The string has been truncated.",
    						truncate(result, 50), context.getLength()), 
    				element));
    		result = StringUtils.left(result, context.getLength());
        }
        
        if (ST_LANG.getType().equals(context.getType())) {
			String language = ((Element) node).getAttribute("language");
			// this cast is safe - it will always be an STImpl due to the doCreateDataTypeInstance() method
			((STImpl) dataType).setLanguage(StringUtils.trimToNull(language));
        }

        return result;
	}
	
	private String truncate(String text, Integer length) {
		if (StringUtils.isBlank(text)) {
			return "";
		} else if (text.length() > length) {
			return StringUtils.substring(text, 0, length-3) + "...";
		} else {
			return text;
		}
	}

	private boolean hasLanguageAttribute(Element element) {
		return element.hasAttribute("language");
	}

	private boolean languageSupported(Element element) {
		return STImpl.ALLOWED_LANGUAGES.contains(element.getAttribute("language"));
	}
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new STImpl();
	}
}
