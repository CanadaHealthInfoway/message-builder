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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractValueNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * BL - Boolean
 *
 * Formats a Boolean into a BL element. The element looks like this:
 *
 * &lt;element-name value="true"/&gt;		&lt;!-- or value="false" --&gt;
 *
 * If a Boolean is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-BL
 */
@DataTypeHandler({"BL", "BN"})
class BlR2PropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Boolean> {

	@Override
	public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
		// if type is BN then NFs are not allowed
		if (StringUtils.equals(context.getType(), StandardDataType.BN.getType())) {
			if (hl7Value == null || hl7Value.getBareValue() == null || hl7Value.hasNullFlavor()) {
				context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, "BN can not be null or have a nullFlavor", context.getPropertyPath()));
			}
		}
		return super.format(context, hl7Value, indentLevel);
	}
	
	@Override
	public Map<String, String> getAttributeNameValuePairs(FormatContext context, Boolean bool, BareANY bareAny) {
		return super.getAttributeNameValuePairs(context, bool, bareAny);
	}
	
	@Override
	protected String getValue(Boolean booleanValue, FormatContext context, BareANY bareAny) {
		return booleanValue.booleanValue() ? "true" : "false"; 
	}
}
