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
import java.text.ParseException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * IVL - Interval
 * 
 * Parses an IVL element into a Interval. The element looks like this:
 * 
 * <value>
 *   <low value='2'/>
 *   <high value='4'/>
 * </value>
 *
 * or:
 * 
 * <value>
 *   <width unit="d" value="15"/>
 * </value>
 * 
 * or (confusingly):
 *
 * <value value='2' />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-IVL
 */
abstract class AbstractIvlElementParser<T> extends AbstractSingleElementParser<Interval<T>> {
	
	@Override
	@SuppressWarnings("unchecked")
	protected Interval<T> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {

		Interval<T> result = null;
		
		try {
			Element low = (Element) getNamedChildNode(node, "low");
			Element high = (Element) getNamedChildNode(node, "high");
			Element center = (Element) getNamedChildNode(node, "center");
			Element width = (Element) getNamedChildNode(node, "width");
			
			Object lowType = low==null ? null : createType(context, low, xmlToModelResult).getBareValue();
			Object highType = high==null ? null : createType(context, high, xmlToModelResult).getBareValue();
			Object centerType = center==null ? null : createType(context, center, xmlToModelResult).getBareValue();
			Object widthType = width==null ? null : createDiffType(context, width, xmlToModelResult);
			
			if (lowType != null && highType != null) {
				result = IntervalFactory.<T>createLowHigh((T) lowType, (T)highType);
			} else if (lowType != null && widthType != null) {
				result = IntervalFactory.<T>createLowWidth((T)lowType, (Diff<T>) widthType);
			} else if (highType != null && widthType != null) {
				result = IntervalFactory.<T>createWidthHigh((Diff<T>) widthType, (T) highType);
			} else if (centerType != null && widthType != null) {
				result = IntervalFactory.<T>createCentreWidth((T) centerType, (Diff<T>) widthType);
			} else if (lowType != null) {
				result = IntervalFactory.<T>createLow((T) lowType);
			} else if (highType != null) {
				result = IntervalFactory.<T>createHigh((T) highType);
			} else if (centerType != null) {
				result = IntervalFactory.<T>createCentre((T) centerType);
			} else if (widthType != null) {
				result = IntervalFactory.<T>createWidth((Diff<T>)widthType);
			} else {
				Object type = createType(context, (Element) node, xmlToModelResult).getBareValue();
				if (type==null) {
		        	xmlToModelResult.addHl7Error(
		        			new Hl7Error(
		        					Hl7ErrorCode.SYNTAX_ERROR, 
		        					"\"Simple interval node: " + XmlDescriber.describePath(node) + " does not allow a null value\"",
		        					(Element) node));
				} else {
					result = IntervalFactory.<T>createSimple((T) type);
				}
			}
		} catch (ParseException e) {
        	xmlToModelResult.addHl7Error(
        			new Hl7Error(
        					Hl7ErrorCode.DATA_TYPE_ERROR, 
        					"Unable to parse the interval date for element \"" + node.getNodeName() + "\"",
        					(Element) node));
		}
		
		return result;
	}
	
	BareDiff createDiffType(ParseContext context, Element width, XmlToModelResult xmlToModelResult) throws ParseException, XmlToModelTransformationException {
		return new Diff<T>((T) createType(context, width, xmlToModelResult).getBareValue());
	}

	protected abstract BareANY createType(ParseContext context, Element high, XmlToModelResult xmlToModelResult) throws ParseException, XmlToModelTransformationException;
}
