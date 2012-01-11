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
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.UncertainRangeFactory;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

abstract class UrgElementParser<T extends QTY<V>, V> extends AbstractSingleElementParser<UncertainRange<V>> {

	@Override
	protected UncertainRange<V> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) 
			throws XmlToModelTransformationException {

		try {
			Element low = (Element) getNamedChildNode(node, "low");
			Element high = (Element) getNamedChildNode(node, "high");
			Element center = (Element) getNamedChildNode(node, "center");
			Element width = (Element) getNamedChildNode(node, "width");
			
			if (low != null && high != null) {
				try {
					return UncertainRange.createLowHigh(createType(low), createType(high));
				} catch (IllegalArgumentException e) {
					xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, e.getMessage(), (Element) node));
					return null;
				}
			} else if (low != null && width != null) {
				return UncertainRangeFactory.<V>createLowWidth(createType(low), createDiffType(width));
			} else if (high != null && width != null) {
				return UncertainRangeFactory.<V>createWidthHigh(createDiffType(width), createType(high));
			} else if (center != null && width != null) {
				return UncertainRangeFactory.<V>createCentreWidth(createType(center), createDiffType(width));
			} else if (low != null) {
				return UncertainRangeFactory.<V>createLow(createType(low));
			} else if (high != null) {
				return UncertainRangeFactory.<V>createHigh(createType(high));
			} else if (center != null) {
				return UncertainRangeFactory.<V>createCentre(createType(center));
			} else if (width != null) {
				return UncertainRangeFactory.<V>createWidth(createDiffType(width));
			} else {
				return null;
			}
		} catch (ParseException e) {
			throw new XmlToModelTransformationException(e.toString());
		}
	}
	
	protected Diff<V> createDiffType(Element width) throws ParseException, XmlToModelTransformationException {
		return new Diff<V>((V) createType(width));
	}

	protected abstract V createType(Element high) throws ParseException, XmlToModelTransformationException;

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new URGImpl<T, V>();
	}
}
