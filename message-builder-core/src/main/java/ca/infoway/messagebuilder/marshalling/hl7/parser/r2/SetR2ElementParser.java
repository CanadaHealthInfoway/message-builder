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
 * Last modified: $LastChangedDate: 2013-05-24 17:39:39 -0400 (Fri, 24 May 2013) $
 * Revision:      $LastChangedRevision: 6901 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.SetOrListElementParser;

@DataTypeHandler({"SET"})
class SetR2ElementParser extends SetOrListElementParser {

	public SetR2ElementParser(ParserR2Registry parserRegistry) {
		super(parserRegistry, true);
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
		if ("SET<CV>".equals(typeName)) {
			return new SETImpl<CV,Code>(CVImpl.class);
		} else if ("SET<II>".equals(typeName)) {
			return new SETImpl<II,Identifier>(IIImpl.class);
		} else if ("SET<PIVL>".equals(typeName)) {
			return new SETImpl<PIVL,PeriodicIntervalTime>(PIVLImpl.class);
		} else if ("SET<PN>".equals(typeName)) {
			return new SETImpl<PN,PersonName>(PNImpl.class);
		} else if ("SET<RTO<PQ,PQ>>".equals(typeName)) {
			return new SETImpl<RTO<PhysicalQuantity,PhysicalQuantity>,Ratio<PhysicalQuantity,PhysicalQuantity>>(RTOImpl.class);
		} else if ("SET<ST>".equals(typeName)) {
			return new SETImpl<ST,String>(STImpl.class);
		} else if ("SET<TEL>".equals(typeName)) {
			return new SETImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else if ("SET<TS>".equals(typeName)) {
			return new SETImpl<TS,Date>(TSImpl.class);
		} else if ("SET<CD>".equals(typeName)) {
			return new SETImpl<CD,Code>(CDImpl.class);
		} else if ("SET<AD>".equals(typeName)) {
			return new SETImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("SET<TN>".equals(typeName)) {
			return new SETImpl<TN,TrivialName>(TNImpl.class);
		} else {
			throw new MarshallingException("Cannot create a data type construct for data type " + dataType);
		}
	}

	protected void resultAlreadyExistsInCollection(BareANY result, Element node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(new Hl7Error(
				Hl7ErrorCode.DATA_TYPE_ERROR, "Duplicate value not allowed for SET", (Element) node));
	}
	
	@Override
	protected Collection<BareANY> getCollectionType(ParseContext context) {
		return new LinkedHashSet<BareANY>();
	}
	
}