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

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.SXCM;
import ca.infoway.messagebuilder.datatype.SXCMTSCDAR1;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.SXCMTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.SetComponent;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;

@DataTypeHandler({"LIST"})
class ListElementParser extends SetOrListElementParser {

	public ListElementParser(ParserRegistry parserRegistry) {
		super(parserRegistry, false);
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
		if ("LIST<AD>".equals(typeName)) {
			return new LISTImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("LIST<GTS>".equals(typeName)) {
			return new LISTImpl<GTS,GeneralTimingSpecification>(GTSImpl.class);
		} else if ("LIST<II>".equals(typeName)) {
			return new LISTImpl<II,Identifier>(IIImpl.class);
		} else if ("LIST<PN>".equals(typeName)) {
			return new LISTImpl<PN,PersonName>(PNImpl.class);
		} else if ("LIST<TEL>".equals(typeName)) {
			return new LISTImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else if ("LIST<ON>".equals(typeName)) {
			return new LISTImpl<ON, OrganizationName>(ONImpl.class);
		} else if ("LIST<CD>".equals(typeName)) {
			return new LISTImpl<CD, Code>(CDImpl.class);
		} else if ("LIST<CS>".equals(typeName)) {
			return new LISTImpl<CS, Code>(CSImpl.class);
		} else if ("LIST<CE>".equals(typeName)) {
			return new LISTImpl<CE, Code>(CEImpl.class);
		} else if ("LIST<SXCM<TS>>".equals(typeName)) {
			return new LISTImpl<SXCM<TS>, SetComponent<TS>>(TSImpl.class);
		} else if ("LIST<ANY>".equals(typeName)) {
			return new LISTImpl<ANY<Object>, Object>(ANYImpl.class);
		} else if ("LIST<INT>".equals(typeName)) {
			return new LISTImpl<INT, Integer>(INTImpl.class);
		} else if ("LIST<PQ>".equals(typeName)) {
			return new LISTImpl<PQ, PhysicalQuantity>(PQImpl.class);
		} else if ("LIST<ST>".equals(typeName)) {
			return new LISTImpl<ST, String>(STImpl.class);
		} else if ("LIST<SXCMTSCDAR1>".equals(typeName)) {
			return new LISTImpl<SXCMTSCDAR1, MbDate>(SXCMTSCDAR1Impl.class);
		} else {
			throw new MarshallingException("Cannot create a data type construct for data type " + dataType);
		}
	}

	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new ArrayList<BareANY>();
	}

}