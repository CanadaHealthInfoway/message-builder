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

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * MO - Money
 * 
 * Represents an MO elements into a MO object. The element looks like this:
 * 
 * <amt value="10" currency="CAD"/>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoElementParser extends AbstractSingleElementParser<Money> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new MOImpl();
	}
	
	@Override
	protected Money parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		
		validateNoChildren(context, node);

		String value = getMandatoryAttributeValue(node, "value", xmlToModelResult);
		BigDecimal amount = StringUtils.isBlank(value) ? null : new BigDecimal(value);
        String currencyCode = getMandatoryAttributeValue(node, "currency", xmlToModelResult);
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
        
        if (currency == null) {
            xmlToModelResult.addHl7Error(
            		new Hl7Error(
            				Hl7ErrorCode.DATA_TYPE_ERROR,
            				"Could not decode currency value " + currencyCode + " (" + XmlDescriber.describeSingleElement((Element) node) + ")",
            				(Element) node
            				));
        }

		return new Money(amount, currency);
	}

}
