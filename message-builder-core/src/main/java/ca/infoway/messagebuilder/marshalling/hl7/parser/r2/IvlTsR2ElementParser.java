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

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.util.Date;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IvlTsConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;

@DataTypeHandler("IVL<TS>")
class IvlTsR2ElementParser implements ElementParser {

	private final IvlTsConstraintsHandler constraintsHandler = new IvlTsConstraintsHandler();
	
	private static IvlR2ElementParser<Date> actualIvlTsParser = new IvlR2ElementParser<Date>() {
		protected Object extractValue(BareANY any) {
			Object value = any == null ? null : any.getBareValue();
			return value == null ? null : ((MbDate) value).getValue();
		}
	};
	
	public IvlTsR2ElementParser() {
	}

	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		BareANY parsedValue = actualIvlTsParser.parse(context, nodes, xmlToModelResult);
		// need to wrap result in a DateInterval
		Object bareValue = parsedValue.getBareValue();
		if (bareValue != null && bareValue instanceof Interval<?>) {
			@SuppressWarnings("unchecked")
			DateInterval newValue = new DateInterval((Interval<Date>) bareValue);
			
			Node node = (nodes == null || nodes.size() == 0 ? null : nodes.get(0)); // should always have a node
			handleConstraints(context, xmlToModelResult, (Element) node, newValue);
			
			parsedValue.setBareValue(newValue);
		}
		return parsedValue;
	}

	private void handleConstraints(ParseContext context, final Hl7Errors errors, final Element element, DateInterval dateInterval) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, element));
			}
		};
		
		this.constraintsHandler.handleConstraints(context.getConstraints(), dateInterval, logger);
	}

}
