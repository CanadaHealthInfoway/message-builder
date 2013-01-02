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
import java.text.MessageFormat;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public abstract class AbstractRtoElementParser<N, D> extends AbstractSingleElementParser<Ratio<N, D>> {

    @Override
	protected Ratio<N, D> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {

        Ratio<N, D> result = new Ratio<N, D>();
        
		List<Hl7DataTypeName> innerTypes = Hl7DataTypeName.create(context.getType()).getInnerTypes();
		if (innerTypes.size() != 2) {
			// this should never happen unless a message set is incorrect; ok to abort with exception (parsing will continue after this datatype) 
			throw new XmlToModelTransformationException("RTO data type must have two inner types. Type " + context.getType() + " has " + innerTypes.size() + ".");
		}

		boolean numeratorFound = false;
		boolean denominatorFound = false;
		
		NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode instanceof Element) {
                Element element = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(element);
                if ("numerator".equals(name)) {
                	numeratorFound = true;
                    result.setNumerator(getNumeratorValue(element, innerTypes.get(0).toString(), context, xmlToModelResult));
                } else if ("denominator".equals(name)) {
                	denominatorFound = true;
                    result.setDenominator(getDenominatorValue(element, innerTypes.get(1).toString(), context, xmlToModelResult));
                }
            }
        }
        
        if (!numeratorFound) {
        	recordMissingElementError("Numerator", context, node, xmlToModelResult);
        }
        if (!denominatorFound) {
        	recordMissingElementError("Denominator", context, node, xmlToModelResult);
        }
        
        return result;
    }

	private void recordMissingElementError(String element, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						MessageFormat.format("{0} is mandatory for type {1} ({2})",
								element, context.getType(), XmlDescriber.describeSingleElement((Element) node)), (Element) node));
	}

    protected abstract N getNumeratorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult);
    protected abstract D getDenominatorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult);

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new RTOImpl<N, D>();
	}

}
