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

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@DataTypeHandler("PIVL<TS>")
class PivlTsElementParser extends AbstractPivlElementParser {

    @Override
	protected DateDiff createPeriodType(Element element, XmlToModelResult xmlToModelResult) throws ParseException, XmlToModelTransformationException {
    	return (DateDiff) new IvlTsElementParser().createDiffType(
    			ParserContextImpl.create("IVL<TS>", null, null, ConformanceLevel.OPTIONAL),
    			element, xmlToModelResult);
	}

	@Override
	protected Interval<Date> createPhaseType(Element element, XmlToModelResult xmlToModelResult) throws ParseException, XmlToModelTransformationException {
		return (Interval<Date>) new IvlTsElementParser().parse(
    			ParserContextImpl.create("IVL<TS>", null, null, ConformanceLevel.OPTIONAL),
    			Arrays.asList((Node) element), xmlToModelResult).getBareValue();
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PIVLImpl();
	}
}
