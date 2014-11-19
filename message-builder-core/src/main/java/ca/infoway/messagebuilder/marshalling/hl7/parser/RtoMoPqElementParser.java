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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.Cardinality;
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
@DataTypeHandler("RTO<MO,PQ>")
class RtoMoPqElementParser extends AbstractRtoElementParser<Money, PhysicalQuantity> {

	PqElementParser pqParser = new PqElementParser();
	MoElementParser moParser = new MoElementParser();
	
	@Override
	protected Money getNumeratorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult) {
    	// inner types (numerator and denominator) are guaranteed to be of type MO.x and PQ.x due to the DataTypeHandler annotation; no need to validate this is a MO or PQ
    	
    	// create new (mandatory) context
    	ParseContext innerContext = ParseContextImpl.create(type, ConformanceLevel.MANDATORY, Cardinality.create("1"), context);
    	
    	// this loses any null flavor info; however, since both numerator and denominator are mandatory this is not a problem
    	return (Money) moParser.parse(innerContext, (Node) element, xmlToModelResult).getBareValue();
    }
    
	@Override
	protected PhysicalQuantity getDenominatorValue(Element element, String type, ParseContext context, XmlToModelResult xmlToModelResult) {
    	// inner types (numerator and denominator) are guaranteed to be of type MO.x and PQ.x due to the DataTypeHandler annotation; no need to validate this is a MO or PQ
    	
    	// create new (mandatory) context
    	ParseContext innerContext = ParseContextImpl.create(type, ConformanceLevel.MANDATORY, Cardinality.create("1"), context);
    	
    	// this loses any null flavor info; however, since both numerator and denominator are mandatory this is not a problem
    	return (PhysicalQuantity) pqParser.parse(innerContext, (Node) element, xmlToModelResult).getBareValue();
    }

}
