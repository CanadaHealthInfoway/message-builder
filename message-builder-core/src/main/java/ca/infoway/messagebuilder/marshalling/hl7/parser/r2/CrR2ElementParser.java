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
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CRImpl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;

/**
 * CR (R2)
 */
@DataTypeHandler("CR")
class CrR2ElementParser extends AbstractSingleElementParser<CodeRole> {

	private CvR2ElementParser cvParser = new CvR2ElementParser();
	private CdR2ElementParser cdParser = new CdR2ElementParser();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new CRImpl();
	}

	@Override
	protected CodeRole parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {

        CodeRole result = new CodeRole();

        Element element = (Element) node;
        handleName(element, result, context, xmlToModelResult);
        handleValue(element, result, context, xmlToModelResult);
		boolean hasInvertedAttribute = handleInverted(element, result);

		if (result.getName() == null && result.getValue() == null && !hasInvertedAttribute) {
			result = null;
		}
		
        return result;
    }

	private boolean handleInverted(Element element, CodeRole result) {
		boolean hasInvertedAttribute = element.hasAttribute("inverted");
		if (hasInvertedAttribute) {
			boolean inverted = Boolean.parseBoolean(element.getAttribute("inverted"));
			result.setInverted(inverted);
		}
		return hasInvertedAttribute;
	}

	@SuppressWarnings("unchecked")
	private void handleValue(Element element, CodeRole result, ParseContext context, XmlToModelResult xmlToModelResult) {
		List<Element> values = getNamedElements("value", element);
		if (values.size() >= 1) {
			if (values.size() > 1) {
				recordError("Only one value element is allowed within a CR type.", context, element, xmlToModelResult);
			}
			Element valueElement = values.get(0);
			
			// run through cd parser
			ParseContext newContext = ParserContextImpl.create("ANY", Code.class, context);
			BareANY cdAny = this.cdParser.parse(newContext, valueElement, xmlToModelResult);
			result.setValue(cdAny == null ? null : (CodedTypeR2<Code>) cdAny.getBareValue());
		} else {
			recordError("CR types must have a value element (or a nullFlavor attribute)", context, element, xmlToModelResult);
		}
	}

	@SuppressWarnings("unchecked")
	private void handleName(Element element, CodeRole result, ParseContext context, XmlToModelResult xmlToModelResult) {
		List<Element> names = getNamedElements("name", element);
		if (names.size() >= 1) {
			if (names.size() > 1) {
				recordError("Only one name element is allowed within a CR type.", context, element, xmlToModelResult);
			}
			Element nameElement = names.get(0);
			
			// run through cv parser
			ParseContext newContext = ParserContextImpl.create("ANY", Code.class, context);
			BareANY cvAny = this.cvParser.parse(newContext, nameElement, xmlToModelResult);
			result.setName(cvAny == null ? null : (CodedTypeR2<Code>) cvAny.getBareValue());
		}
	}
    
	protected void recordError(String message, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, (Element) node));
	}
}
