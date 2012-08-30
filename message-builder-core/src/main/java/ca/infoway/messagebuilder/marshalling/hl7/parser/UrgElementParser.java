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
import java.util.Arrays;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

abstract class UrgElementParser<T extends QTY<V>, V> extends AbstractSingleElementParser<UncertainRange<V>> {

	@Override
	protected UncertainRange<V> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		// URGs are almost identical in function to IVLs; use IVL parser
		BareANY bareAny = getIvlParser().parse(convertContext(context), Arrays.asList(node), xmlToModelResult);
		
		@SuppressWarnings("unchecked")
		Interval<V> parsedInterval = (Interval<V>) bareAny.getBareValue();
		
		return convertIntervalToUncertainRange(parsedInterval);
	}
	
	private ParseContext convertContext(ParseContext context) {
		String newType = "IVL<" + Hl7DataTypeName.getParameterizedType(context.getType()) + ">";
		return ParserContextImpl.create(newType, context);
	}

	private UncertainRange<V> convertIntervalToUncertainRange(Interval<V> parsedInterval) {
		UncertainRange<V> urg = null;
		if (parsedInterval != null) {
			urg = new UncertainRange<V>(parsedInterval);
		}
		return urg;
	}

	protected abstract ElementParser getIvlParser();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new URGImpl<T, V>();
	}
}
