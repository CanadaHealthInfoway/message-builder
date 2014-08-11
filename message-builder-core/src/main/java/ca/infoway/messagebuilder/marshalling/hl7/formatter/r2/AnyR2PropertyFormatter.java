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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;
/**
 * ANY (R2)
 * 
 */
@DataTypeHandler("ANY")
public class AnyR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<Object> {

	@Override
	protected String formatNonNullDataType(FormatContext context, BareANY hl7Value, int indentLevel) {
		String actualType = hl7Value.getDataType().getType();
		StandardDataType actualTypeAsEnum = StandardDataType.getByTypeName(actualType);
		String result = null;
		
		if (actualTypeAsEnum == null) {
			recordError("Could not determine type for ANY relationship." + (actualType == null ? "'" : actualType + "' not found in StandardDataType enum."), context);
		} else if (StandardDataType.ANY.equals(actualTypeAsEnum.getRootDataType())) {
			// actual type has been determined to be ANY; this (most likely) means a concrete type has not been specified  
			recordError("A concrete data type must be specified for a relationship of type ANY.", context);
		} else {
			PropertyFormatter formatter = FormatterR2Registry.getInstance().get(actualType);
			if (formatter == null) {
				String errorText = "Cannot support properties of type " + actualType + " for relationship of type ANY. Please specify a type applicable for ANY in the appropriate message bean.";
				recordError(errorText, context);
			} else {
				// adjust context and pass processing off to the formatter applicable for the specified type
				result = formatter.format(
						new FormatContextImpl(
								actualType,
								true, 
								context), 
						hl7Value, 
						indentLevel);
			}
		}
		
		return result;
	}
	
	@Override
	protected
	String formatNonNullValue(FormatContext formatContext, Object t, int indentLevel) {
		throw new UnsupportedOperationException("Use formatNonNullDataType() instead.");
	}
	
	private void recordError(String message, FormatContext context) {
		String propertyPath = context.getPropertyPath();
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, propertyPath));
	}

}
