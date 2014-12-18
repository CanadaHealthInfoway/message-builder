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
 * Last modified: $LastChangedDate: 2014-05-23 08:13:42 -0400 (Fri, 23 May 2014) $
 * Revision:      $LastChangedRevision: 8677 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.PqValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;

/**
 * PQ - Physical Quantity (R2)
 * 
 * Parses a PQ element into a PhysicalQuantity. The element looks like this:
 * 
 * <element-name value="123.33" unit="unit"/>
 *
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ
 * 
 */
@DataTypeHandler({"PQ", "SXCM<PQ>"})
class PqR2ElementParser extends AbstractSingleElementParser<PhysicalQuantity> {

	private final SxcmR2ElementParserHelper sxcmHelper = new SxcmR2ElementParserHelper();
	private final PqrR2ElementParser pqrParser = new PqrR2ElementParser();
	private final PqValidationUtils pqValidationUtils = new PqValidationUtils();
	
	@Override
	protected PhysicalQuantity parseNonNullNode(ParseContext context, Node node, BareANY bareAny, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element element = (Element) node;
		
		BigDecimal value = this.pqValidationUtils.validateValueR2(element.getAttribute("value"), context.getVersion(), context.getType(), false, element, null, xmlToModelResult);
		
		String unitAsString = element.getAttribute("unit");
		UnitsOfMeasureCaseSensitive unit = null;
		if (StringUtils.isNotBlank(unitAsString)) {
			unit = this.pqValidationUtils.validateUnits(context.getType(), unitAsString, element, null, xmlToModelResult, true);
		} else {
			// TM - MBR-285: units default to "1" if not specified; however, this part of the schemas will be ignored
		}

		PhysicalQuantity physicalQuantity = (value != null || unit != null) ? new PhysicalQuantity(value, unit) : null;
		if (physicalQuantity != null) {
			handleTranslations(element, physicalQuantity, context, xmlToModelResult);
		}
		
        this.sxcmHelper.handleOperator((Element) node, context, xmlToModelResult, (ANYMetaData) bareAny);
		
        // this is not the usual way of doing things; this is to make validation easier
        ((BareANYImpl) bareAny).setBareValue(physicalQuantity);
		
		return physicalQuantity;
	}
	
	private void handleTranslations(Element element, PhysicalQuantity pq, ParseContext context, XmlToModelResult result) {
		// we have no knowledge of what domain the translations may belong to (I imagine code system could allow for a reverse lookup at some point)
		ParseContext newContext = ParseContextImpl.create("PQR", ANY.class, context); 
		NodeList translations = element.getElementsByTagName("translation");
		for (int i = 0, length = translations.getLength(); i < length; i++) {
			Element translationElement = (Element) translations.item(i);
			// only want direct child node translations
			if (translationElement.getParentNode().isSameNode(element)) {
				CodedTypeR2<Code> parsedTranslation = parseTranslation(translationElement, newContext, result);
				if (parsedTranslation != null) {
					pq.getTranslation().add(parsedTranslation);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private CodedTypeR2<Code> parseTranslation(Element translationElement, ParseContext newContext, XmlToModelResult result) {
		BareANY anyResult = this.pqrParser.parse(newContext, translationElement, result);
		return anyResult == null ? null : (CodedTypeR2<Code>) anyResult.getBareValue();
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PQImpl();
	}
}