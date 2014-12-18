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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.List;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

@DataTypeHandler("PIVLTSCDAR1")
class PivlTsCdaElementParser implements ElementParser {

	private PivlTsElementParser r1Parser = new PivlTsElementParser();
	private PivlTsDateTimeElementParser r1ParserFrequency = new PivlTsDateTimeElementParser();
	
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		ParseContext newContext = convertContext(context);
		BareANY parseResult = this.r1Parser.parse(newContext, nodes, xmlToModelResult);
		if (parseResult.getBareValue() == null && !parseResult.hasNullFlavor()) {
			parseResult = this.r1ParserFrequency.parse(newContext, nodes, xmlToModelResult);
		}
		return convertDataType(parseResult);
	}
	
	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		PeriodicIntervalTime pivlR1 = (bareValue instanceof PeriodicIntervalTime ? (PeriodicIntervalTime) bareValue : null);
		PeriodicIntervalTimeR2 pivlR2 = (pivlR1 == null ? null : convertPivl(pivlR1));
		
		BareANY result = new PIVLTSCDAR1Impl(pivlR2);
		result.setDataType(dataType.getDataType());
		result.setNullFlavor(dataType.getNullFlavor());
		return result;
	}

	private PeriodicIntervalTimeR2 convertPivl(PeriodicIntervalTime pivlR1) {
		return PeriodicIntervalTimeR2.createFromPivlR1(pivlR1);
	}

	private ParseContext convertContext(ParseContext ParseContext) {
		return ParseContextImpl.create("PIVL<TS>", ParseContext);
	}
	
}
