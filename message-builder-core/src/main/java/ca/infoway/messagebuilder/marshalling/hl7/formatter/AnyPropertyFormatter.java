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
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.AnyHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;
/**
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH; added for BC: ANY.X1, ANY.X2
 * 
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 * 
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL<PQ.x>, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG<PQ,x>
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 * ANY.X1:    ST, CV, PQ.LAB, IVL<PQ.x>, URG<PQ.LAB>
 * ANY.X2:    ST, CV, ED.DOCORREF
 * 
 */
@DataTypeHandler({"ANY", "ANY.LAB", "ANY.CA.IZ", "ANY.PATH", "ANY.x1", "ANY.x2"})
public class AnyPropertyFormatter extends AbstractNullFlavorPropertyFormatter<Object> {

	private final PolymorphismHandler polymorphismHandler = new PolymorphismHandler();

	@Override
	public String format(FormatContext formatContext, BareANY hl7Value, int indentLevel) {
		String specializationType = hl7Value.getDataType().getType();

		StandardDataType specializationTypeAsEnum = StandardDataType.getByTypeName(specializationType);
		if (specializationTypeAsEnum != null && StandardDataType.ANY.equals(specializationTypeAsEnum.getRootDataType())) {
			// specializationType has been determined to be an ANY variant; this (most likely) means specializationType has not been specified, so don't do any special processing  
			return super.format(formatContext, hl7Value, indentLevel);
		} else {
			String mappedSpecializationType = this.polymorphismHandler.mapCdaR1Type(hl7Value.getDataType(), formatContext.isCda());
			PropertyFormatter formatter = FormatterRegistry.getInstance().get(mappedSpecializationType);
			String parentType = formatContext.getType();
			if (formatter == null || !AnyHelper.isValidTypeForAny(parentType, specializationType)) {
				String errorText = "Cannot support properties of type " + specializationType + " for " + parentType + ". Please specify a specializationType applicable for " + parentType + " in the appropriate message bean.";
				throw new ModelToXmlTransformationException(errorText);
			} else {
				// pass processing off to the formatter applicable for the given specializationType
				StandardDataType type = hl7Value.getDataType();
				return formatter.format(
						new FormatContextImpl(
								formatContext.getModelToXmlResult(), 
								formatContext.getPropertyPath(), 
								formatContext.getElementName(), 
								mappedSpecializationType,
								type.isCoded() ? "Code" : formatContext.getDomainType(),
								formatContext.getConformanceLevel(), 
								formatContext.getCardinality(), 
								true, 
								formatContext.getVersion(), 
								formatContext.getDateTimeZone(), 
								formatContext.getDateTimeTimeZone(),
								null,
								formatContext.getConstraints(), // yes, pass constraints down
								formatContext.isCda()),
						hl7Value, 
						indentLevel);
			}
		}

	}
	
	@Override
	protected
	String formatNonNullValue(FormatContext formatContext, Object t, int indentLevel) {
		// getting to this point means: 
		//    1) specializationType was not specified
		//    2) the value being processed is neither null nor a NullFlavor
		// effectively, we have no idea what to do with the data at this point
		String errorText = "Specalization type not set for property of type " + formatContext.getType() + ". Specialization type is required in order to render non-null data.";
		throw new ModelToXmlTransformationException(errorText);
	}
	
}
