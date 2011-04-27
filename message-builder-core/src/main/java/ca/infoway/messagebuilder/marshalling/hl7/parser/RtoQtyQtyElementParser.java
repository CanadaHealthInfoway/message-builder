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

import java.math.BigDecimal;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * RTO<QTY,QTY> - Ratio (quantity, quantity)
 * 
 * Parses into a Ratio of quantities. The element looks like this:
 * 
 * <unitQuantity>
 *    <numerator value="1.0" xsi:type="QTY"/>
 *    <denominator value="64.0" xsi:type="QTY"/>
 * </unitQuantity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<QTY,QTY>")
class RtoQtyQtyElementParser extends AbstractRtoElementParser<BigDecimal, BigDecimal> {

    protected BigDecimal getNumeratorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }
    protected BigDecimal getDenominatorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }

    private BigDecimal getValue(Element element) throws XmlToModelTransformationException {
        return new BigDecimal(getAttributeValue(element, "value"));
    }
}
