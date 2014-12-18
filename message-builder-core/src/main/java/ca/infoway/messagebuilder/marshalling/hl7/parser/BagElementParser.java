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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.corba.se.impl.corba.AnyImpl;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

@DataTypeHandler({"BAG"})
class BagElementParser extends SetOrListElementParser {

	public BagElementParser(ParserRegistry parserRegistry) {
		super(parserRegistry, false);
	}

	@Override
	public BareANY parse(ParseContext context, List<Node> nodes,
			XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
				"Data type \"" + context.getType() 
				+ "\" is not part of the pan-Canadian standard",
				CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)));
		return super.parse(context, nodes, xmlToModelResult);
	}
	
	@Override
	protected BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		CollectionHelper result = new LISTImpl(AnyImpl.class);
		for (BareANY bareANY : collection) {
			result.add(bareANY);
		}
		return (BareANY) result;
	}

	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new ArrayList<BareANY>();
	}
}