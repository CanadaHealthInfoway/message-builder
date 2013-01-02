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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * RTO<PQ, PQ> - Ratio (physical quantity, physical quantity)
 * 
 * Parses into a Ratio of physical quantities. The elements looks like this:
 * 
 * <unitQuanity>
 *    <numerator value="1.0" xsi:type="PQ"/>
 *    <denominator value="64.0" xsi:type="/>
 * </unitQuanity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<PQ,PQ>")
class RtoPqPqElementParser extends AbstractRtoElementParser<PhysicalQuantity, PhysicalQuantity> {

	PqElementParser parser = new PqElementParser();
	
	@Override
	protected PhysicalQuantity getNumeratorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult) {
        return getValue(element, type, context, xmlToModelResult);
    }
    
	@Override
	protected PhysicalQuantity getDenominatorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult) {
        return getValue(element, type, context, xmlToModelResult);
    }

    private PhysicalQuantity getValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult) {
    	// inner types (numerator and denominator) are guaranteed to be of type PQ.x due to the DataTypeHandler annotation; no need to validate this is a PQ
    	
    	// create new (mandatory) context
    	ParseContext innerContext = ParserContextImpl.create(type, ConformanceLevel.MANDATORY, context);
    	
    	// this loses any null flavor info; however, since both numerator and denominator are mandatory this is not a problem
    	return (PhysicalQuantity) this.parser.parse(innerContext, (Node) element, xmlToModelResult).getBareValue();
    }

}
