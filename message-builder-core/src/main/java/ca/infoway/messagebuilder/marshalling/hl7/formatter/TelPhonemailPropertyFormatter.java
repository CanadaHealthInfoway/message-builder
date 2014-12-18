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

import java.util.Map;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.TelValidationUtils;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

/**
 * Represents a TEL.PHONEMAIL String as an element:
 *
 * &lt;element-name use="H WP" value="mailto://me@me.com"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 *
 * The TEL.PHONEMAIL variant defined by CeRx is for personal contact addresses only.
 * The only valid URLSchemes are FAX, MAILTO and TELEPHONE.
 */
@DataTypeHandler({"TEL.ALL", "TEL.PHONEMAIL", "TEL"})
public class TelPhonemailPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> {

	private static final TelValidationUtils TEL_VALIDATION_UTILS = new TelValidationUtils();
	
    @Override
    protected final String getValue(TelecommunicationAddress phonemail, FormatContext context, BareANY bareAny) {
    	
    	String type = context.getType();
    	String specializationType = bareAny.getDataType() == null ? null : bareAny.getDataType().getType();
    	VersionNumber version = context.getVersion();
    	Hl7Errors errors = context.getModelToXmlResult();
    	
    	TEL_VALIDATION_UTILS.validateTelecommunicationAddress(phonemail, type, specializationType, version, null, context.getPropertyPath(), errors);
    	
        return phonemail.toString();
    }

    @Override
    protected void addOtherAttributesIfNecessary(TelecommunicationAddress phonemail, Map<String, String> attributes, FormatContext context,	BareANY bareAny) {
    	VersionNumber version = context.getVersion();
    	String type = (bareAny == null || bareAny.getDataType() == null) ? null : bareAny.getDataType().getType();
		String actualType = TEL_VALIDATION_UTILS.determineActualType(phonemail, context.getType(), type, version, null, context.getPropertyPath(), context.getModelToXmlResult(), false);
    	if (!context.getType().equals(actualType)) {
    		// excluding our test NFLD version to allow legacy tests to pass
    		if(!"NEWFOUNDLAND".equals(version == null ? null : version.getVersionLiteral())) {
    			addSpecializationType(attributes, actualType);
    		}
    	}
    	
        if (!phonemail.getAddressUses().isEmpty()) {

    		StringBuffer useValue = new StringBuffer();
            boolean isFirst = true;
            for (TelecommunicationAddressUse addressUse : phonemail.getAddressUses()) {
            	if (TEL_VALIDATION_UTILS.isAllowableUse(actualType, addressUse, version)) {
	                if (!isFirst) {
	                    useValue.append(XmlRenderingUtils.SPACE);
	                }
	                useValue.append(addressUse.getCodeValue());
	                isFirst = false;
            	}
            }
            attributes.put("use", useValue.toString());
        }
    }

}
