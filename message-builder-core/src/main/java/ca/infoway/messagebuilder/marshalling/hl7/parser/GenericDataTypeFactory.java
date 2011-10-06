/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.SCImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.MarshallingException;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;

/**
 * <p>Provide a C#-compatible utility to create the necessary data types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class GenericDataTypeFactory {

	public static BareANY create(String dataType) {
		Hl7DataTypeName type = Hl7DataTypeName.create(dataType);
		String typeName = StringUtils.deleteWhitespace(type.getUnqualifiedVersion().toString());
		if ("ANY".equals(typeName)) {
			return new ANYImpl<Object>();
		} else if ("AD".equals(typeName)) {
			return new ADImpl();
		} else if ("BL".equals(typeName)) {
			return new BLImpl();
		} else if ("ON".equals(typeName)) {
			return new ONImpl();
		} else if ("SC".equals(typeName)) {
			return new SCImpl<Code>();
		} else if ("TN".equals(typeName)) {
			return new TNImpl();
		} else if ("GTS".equals(typeName)) {
			return new GTSImpl();
		} else if ("II".equals(typeName)) {
			return new IIImpl();
		} else if ("IVL<PQ>".equals(typeName)) {
			return new IVLImpl<PQ,Interval<PhysicalQuantity>>();
		} else if ("IVL<TS>".equals(typeName)) {
			return new IVLImpl<TS,Interval<Date>>();
		} else if ("IVL<INT>".equals(typeName)) {
			return new IVLImpl<INT,Interval<Integer>>();
		} else if ("SET<CV>".equals(typeName)) {
			return new SETImpl<CV,Code>(CVImpl.class);
		} else if ("SET<II>".equals(typeName)) {
			return new SETImpl<II,Identifier>(IIImpl.class);
		} else if ("SET<PIVL>".equals(typeName)) {
			return new SETImpl<PIVL,PeriodicIntervalTime>(PIVLImpl.class);
		} else if ("SET<PN>".equals(typeName)) {
			return new SETImpl<PIVL,PeriodicIntervalTime>(PIVLImpl.class);
		} else if ("SET<RTO<PQ,PQ>>".equals(typeName)) {
			return new SETImpl<RTO<PhysicalQuantity,PhysicalQuantity>,Ratio<PhysicalQuantity,PhysicalQuantity>>(RTOImpl.class);
		} else if ("SET<ST>".equals(typeName)) {
			return new SETImpl<ST,String>(STImpl.class);
		} else if ("SET<TEL>".equals(typeName)) {
			return new SETImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else if ("SET<TS>".equals(typeName)) {
			return new SETImpl<TS,Date>(TSImpl.class);
		} else if ("LIST<AD>".equals(typeName)) {
			return new LISTImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("LIST<GTS>".equals(typeName)) {
			return new LISTImpl<GTS,GeneralTimingSpecification>(GTSImpl.class);
		} else if ("LIST<II>".equals(typeName)) {
			return new LISTImpl<II,Identifier>(IIImpl.class);
		} else if ("LIST<PN>".equals(typeName)) {
			return new LISTImpl<PN,PersonName>(PNImpl.class);
		} else if ("LIST<TEL>".equals(typeName)) {
			return new LISTImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else if ("BAG<AD>".equals(typeName)) {
			return new LISTImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("BAG<GTS>".equals(typeName)) {
			return new LISTImpl<GTS,GeneralTimingSpecification>(GTSImpl.class);
		} else if ("BAG<II>".equals(typeName)) {
			return new LISTImpl<II,Identifier>(IIImpl.class);
		} else if ("BAG<PN>".equals(typeName)) {
			return new LISTImpl<PN,PersonName>(PNImpl.class);
		} else if ("BAG<ST>".equals(typeName)) {
			return new LISTImpl<AD,PostalAddress>(ADImpl.class);
		} else if ("BAG<TEL>".equals(typeName)) {
			return new LISTImpl<TEL,TelecommunicationAddress>(TELImpl.class);
		} else {
			throw new MarshallingException("Cannot create a data type construct for data type " + dataType);
		}
	}
}
