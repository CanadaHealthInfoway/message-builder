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
 * Last modified: $LastChangedDate: 2012-05-15 20:03:59 -0400 (Tue, 15 May 2012) $
 * Revision:      $LastChangedRevision: 5886 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CV_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * RTO&lt;PQ, PQ&gt; - Ratio R2 (physical quantity, physical quantity)
 *
 * Represents a Ratio of physical quantities as an element:
 *
 * &lt;unitQuanity&gt;
 *    &lt;numerator value="1.0" xsi:type="PQ"/&gt;
 *    &lt;denominator value="64.0" xsi:type="/&gt;
 * &lt;/unitQuanity&gt;
 */
@DataTypeHandler("CR")
public class CrR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<CodeRole> {

	private CvR2PropertyFormatter cvFormatter = new CvR2PropertyFormatter();
	private CdR2PropertyFormatter cdFormatter = new CdR2PropertyFormatter();
	
	@Override
	protected
    String formatNonNullValue(FormatContext context, CodeRole codeRole, int indentLevel) {

		boolean hasContent = (codeRole.getName() != null || codeRole.getValue() != null);
		
		// validation here (limited, from schema); must have value or a NF (and if we are here, we don't have a NF)
		if (codeRole.getValue() == null) {
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "CR types must have the \"value\" property provided", context.getPropertyPath()));
		}
		
        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, createAttributesMap(codeRole, context), indentLevel, !hasContent, true));
        if (hasContent) {
	        if (codeRole.getName() != null) {
				buffer.append(formatName(context, codeRole.getName(), indentLevel + 1));
	        }
	        if (codeRole.getValue() != null) {
	        	buffer.append(formatValue(context, codeRole.getValue(), indentLevel + 1));
	        }
        	buffer.append(createElementClosure(context.getElementName(), indentLevel, true));
        }
        return buffer.toString();
    }
    
	private Map<String, String> createAttributesMap(CodeRole codeRole, FormatContext context) {
		Map<String, String> attributes = null;
		if (codeRole.isInverted()) {
			// value defaults to false; only output if true
			attributes = new HashMap<String, String>(); 
			attributes.put("inverted", "true");
		}
		return attributes;
	}

	private String formatName(FormatContext context, CodedTypeR2<Code> name, int indentLevel) {
		FormatContext newContext = new FormatContextImpl("CV", ConformanceLevel.OPTIONAL, Cardinality.create("0-1"), "name", context);
		return this.cvFormatter.format(newContext, new CV_R2Impl(name), indentLevel);
	}

	private String formatValue(FormatContext context, CodedTypeR2<Code> value, int indentLevel) {
		FormatContext newContext = new FormatContextImpl("CD", ConformanceLevel.OPTIONAL, Cardinality.create("0-1"), "value", context);
		return this.cdFormatter.format(newContext, new CD_R2Impl(value), indentLevel);
	}
	
}
