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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.util.xml.XmlNodeListIterable;

public abstract class AbstractRtoR2ElementParser<N, D> extends AbstractSingleElementParser<Ratio<N, D>> {

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
		for (Node childNode : new XmlNodeListIterable(childNodes)) {
            if (childNode instanceof Element) {
                Element element = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(element);
                if ("numerator".equals(name)) {
                	numeratorFound = true;
                    result.setNumerator(getNumeratorValue(element, innerTypes.get(0).toString(), context, xmlToModelResult));
                    if (denominatorFound) {
                    	recordError("Denominator must come after numerator", context, element, xmlToModelResult);
                    }
                } else if ("denominator".equals(name)) {
                	denominatorFound = true;
                    result.setDenominator(getDenominatorValue(element, innerTypes.get(1).toString(), context, xmlToModelResult));
                }
            }
		}
        
        checkNumerator(result, numeratorFound, node, context, xmlToModelResult);
        
        checkDenominator(result, denominatorFound, node, context, xmlToModelResult);
        
        return result;
    }

	private void checkDenominator(Ratio<N, D> result, boolean denominatorFound, Node node, ParseContext context, XmlToModelResult xmlToModelResult) {
		if (denominatorFound) {
        	if (result.getDenominator() instanceof PhysicalQuantity) {
        		PhysicalQuantity pqDenominator = (PhysicalQuantity)(Object) result.getDenominator(); //cast to Object for .NET translation
        		if (BigDecimal.ZERO.equals(pqDenominator.getQuantity())) {
        			recordError("Denominator value can not be zero.", context, node, xmlToModelResult);
        		} else if (pqDenominator.getQuantity() == null) {
	        		// schema states that the pq values default to "1", without reference to which property; assuming this to mean quantity
	        		pqDenominator.setQuantity(BigDecimal.ONE);
	        	}
        	}
        } else {
        	recordMissingElementError("Denominator", context, node, xmlToModelResult);
        }
	}

	private void checkNumerator(Ratio<N, D> result, boolean numeratorFound, Node node, ParseContext context, XmlToModelResult xmlToModelResult) {
		if (numeratorFound) {
        	if (result.getNumerator() instanceof PhysicalQuantity) {
        		PhysicalQuantity pqNumerator = (PhysicalQuantity) result.getBareNumerator();
	        	if (pqNumerator.getQuantity() == null) {
	        		// schema states that the pq values default to "1", without reference to which property; assuming this to mean quantity
	        		pqNumerator.setQuantity(BigDecimal.ONE);
	        	}
        	}
        } else {
        	recordMissingElementError("Numerator", context, node, xmlToModelResult);
        }
	}

	private void recordMissingElementError(String elementName, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		String message = MessageFormat.format("{0} is mandatory for type {1} ({2})",
				elementName, context.getType(), XmlDescriber.describeSingleElement((Element) node));
		recordError(message, context, node, xmlToModelResult);
	}

	protected void recordError(String message, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, (Element) node));
	}

    protected abstract N getNumeratorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult);
    protected abstract D getDenominatorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult);

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new RTOImpl<N, D>();
	}

}
