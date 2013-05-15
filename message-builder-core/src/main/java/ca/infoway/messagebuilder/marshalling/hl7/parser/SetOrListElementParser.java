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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

abstract class SetOrListElementParser extends AbstractElementParser {

	@Override
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
 		String subType = getSubType(context);
		Collection<BareANY> list = getCollectionType(context);
		for (Node node : nodes) {
			ElementParser parser = ParserRegistry.getInstance().get(subType);
			if (parser != null) {
				BareANY result = parser.parse(
						ParserContextImpl.create(
								subType,
								getSubTypeAsModelType(context),
								context.getVersion(),
								context.getDateTimeZone(),
								context.getDateTimeTimeZone(),
								context.getConformance()),
						toList(node),
						xmlToModelResult);
				if (result != null) {
					if (!list.add(result)) {
						unableToAddResultToCollection(result, (Element) node, xmlToModelResult);
					}
				}
			} else {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR,
						"No parser type found for " + subType, (Element) node));
				break;
			}
		}
		return wrapWithHl7DataType(context.getType(), subType, list);
	}

	protected void unableToAddResultToCollection(BareANY result, Element node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(new Hl7Error(
				Hl7ErrorCode.INTERNAL_ERROR, "Could not add parsed value to collection", (Element) node));
	}
	
	protected abstract BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection);

	protected abstract Collection<BareANY> getCollectionType(ParseContext context);

	private Type getSubTypeAsModelType(ParseContext context) {
		Type returnType = getReturnType(context);
		try {
			return Generics.getParameterType(returnType);
		} catch (IllegalArgumentException e) {
			return returnType;
		}
	}

	private List<Node> toList(Node node) {
		return Arrays.asList(node);
	}

	protected String getChildType() {
		return null;
	}

	private String getSubType(ParseContext context) throws XmlToModelTransformationException {
		String subType = Hl7DataTypeName.getParameterizedType(context.getType());
		if (StringUtils.isNotBlank(subType)) {
			return subType;
		} else {
			throw new XmlToModelTransformationException("Cannot find the sub type for " + context.getType());
		}
	}

}