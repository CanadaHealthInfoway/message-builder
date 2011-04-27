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
import java.text.ParseException;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

@DataTypeHandler({"URG<PQ>", "URG<PQ.DRUG>", "URG<PQ.TIME>", "URG<PQ.BASIC>"})
class UrgPqElementParser extends UrgElementParser<PQ, PhysicalQuantity> {
	
	@Override
	protected PhysicalQuantity createType(Element element) throws ParseException, XmlToModelTransformationException {
		String quantity = element.getAttribute("value");
		String unitString = element.getAttribute("unit");
		UnitsOfMeasureCaseSensitive unit = (CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, unitString));
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
