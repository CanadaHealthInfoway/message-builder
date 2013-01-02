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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.AnyHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
/**
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH
 * 
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 * 
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL<PQ.x>, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG<PQ,x>
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 * 
 */
@DataTypeHandler({"ANY", "ANY.LAB", "ANY.CA.IZ", "ANY.PATH"})
public class AnyPropertyFormatter extends AbstractPropertyFormatter {

	@Override
	public String format(FormatContext formatContext, BareANY hl7Value, int indentLevel) {
		String specializationType = hl7Value.getDataType().getType();
		PropertyFormatter formatter = FormatterRegistry.getInstance().get(specializationType);
		String parentType = formatContext.getType();
		if (formatter == null || !AnyHelper.isValidTypeForAny(parentType, specializationType)) {
			String errorText = "Cannot support properties of type " + specializationType + " for " + parentType + ". Please specify a specializationType applicable for " + parentType + " in the appropriate message bean.";
			throw new ModelToXmlTransformationException(errorText);
		} else {
			return formatter.format(
					new FormatContextImpl(
							formatContext.getModelToXmlResult(), 
							formatContext.getPropertyPath(), 
							formatContext.getElementName(), 
							specializationType,
							formatContext.getDomainType(),
							formatContext.getConformanceLevel(), 
							true, 
							formatContext.getVersion(), 
							formatContext.getDateTimeZone(), 
							formatContext.getDateTimeTimeZone(), true, null), 
					hl7Value, 
					indentLevel);
		}
	}
	
}
