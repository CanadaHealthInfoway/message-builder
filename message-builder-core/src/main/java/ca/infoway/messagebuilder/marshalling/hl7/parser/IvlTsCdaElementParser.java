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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.Date;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IvlTsConstraintsHandler;

@DataTypeHandler("IVLTSCDAR1")
class IvlTsCdaElementParser implements ElementParser {
	
	private IvlTsElementParser r1Parser = new IvlTsElementParser();
	private final IvlTsConstraintsHandler constraintsHandler = new IvlTsConstraintsHandler();

	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		ParseContext newContext = convertContext(context);
		BareANY parseResult = this.r1Parser.parse(newContext, nodes, xmlToModelResult);
		BareANY convertedDataType = convertDataType(parseResult);
		handleConstraints(context, xmlToModelResult, nodes, convertedDataType);
		return convertedDataType;
	}

	private void handleConstraints(ParseContext context, final Hl7Errors errors, final List<Node> nodes, BareANY convertedDataType) {
		final Element element = (nodes.size() > 0 ? (Element) nodes.get(0) : null); 
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, element));
			}
		};
		
		DateInterval dateInterval = (DateInterval) convertedDataType.getBareValue();
		this.constraintsHandler.handleConstraints(context.getConstraints(), dateInterval, logger);
	}
	
	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		@SuppressWarnings("unchecked")
		Interval<Date> ivlTsR1 = (bareValue instanceof Interval ? (Interval<Date>) bareValue : null);
		DateInterval ivlTsR2 = (ivlTsR1 == null ? null : convertIvlTs(ivlTsR1));
		
		IVLTSCDAR1 result = new IVLTSCDAR1Impl();
		result.setDataType(dataType.getDataType());
		result.setBareValue(ivlTsR2);
		result.setNullFlavor(dataType.getNullFlavor());
		return result;
	}

	private DateInterval convertIvlTs(Interval<Date> ivlTsR1) {
		return ivlTsR1 == null ? null : new DateInterval(ivlTsR1);
	}

	private ParseContext convertContext(ParseContext parseContext) {
		return ParseContextImpl.create("IVL<TS>", parseContext);
	}

}
