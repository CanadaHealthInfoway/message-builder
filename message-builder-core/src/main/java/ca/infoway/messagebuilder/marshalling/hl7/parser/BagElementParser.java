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
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
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
	protected BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection, ParseContext context) {
		CollectionHelper result = createCollectionHelper(type);
		for (BareANY bareANY : collection) {
			result.add(bareANY);
		}
		return (BareANY) result;
	}

	private CollectionHelper createCollectionHelper(String dataType) {
		Hl7DataTypeName type = Hl7DataTypeName.create(dataType);
		String typeName = StringUtils.deleteWhitespace(type.getUnqualifiedVersion().toString());
		if ("BAG<AD>".equals(typeName)) {
			return new LISTImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("BAG<GTS>".equals(typeName)) {
			return new LISTImpl<GTS,GeneralTimingSpecification>(GTSImpl.class);
		} else if ("BAG<II>".equals(typeName)) {
			return new LISTImpl<II,Identifier>(IIImpl.class);
		} else if ("BAG<PN>".equals(typeName)) {
			return new LISTImpl<PN,PersonName>(PNImpl.class);
		} else if ("BAG<ST>".equals(typeName)) {
			return new LISTImpl<ST,String>(STImpl.class);
		} else if ("BAG<TEL>".equals(typeName)) {
			return new LISTImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else {
			throw new MarshallingException("Cannot create a data type construct for data type " + dataType);
		}
	}

	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new ArrayList<BareANY>();
	}
}