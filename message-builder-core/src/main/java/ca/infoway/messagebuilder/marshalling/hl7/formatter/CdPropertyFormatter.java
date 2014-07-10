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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * CS - Coded Simple
 *
 * Formats a enum into a CS element. The element looks like this:
 *
 * &lt;element-name code="RECENT"/&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * HL7 implies that variations on this type may use a different name than "code" for
 * the attribute. The use in the controlActProcess is given as an example.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
@DataTypeHandler({"CD", "CE"})
class CdPropertyFormatter extends AbstractCodePropertyFormatter {

    @Override
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Code code, BareANY bareAny) {
        Map<String, String> result = super.getAttributeNameValuePairs(context, code, bareAny);
        if (code != null) {
            if (StringUtils.isNotBlank(code.getCodeSystem())) {
                result.put("codeSystem", code.getCodeSystem());
            }
			ANYMetaData anyCd = (ANYMetaData) bareAny;
			if (StringUtils.isNotBlank(anyCd.getDisplayName())) {
                result.put("displayName", anyCd.getDisplayName());
        	}
        }
        return result;
    }
    
    @Override
    protected boolean hasChildContent(CD cd, FormatContext context) {
    	return hasTranslations(cd) || super.hasChildContent(cd, context);
    }

	private boolean hasTranslations(CD cd) {
		return !cd.getTranslations().isEmpty();
	}
    
    @Override
    protected void createChildContent(CD cd, StringBuilder result) {
    	super.createChildContent(cd, result);
    	if (hasTranslations(cd)) {
    		for (CD translation : cd.getTranslations()) {
    			Map<String, String> attributes = new HashMap<String, String>();
    			attributes.put("code", translation.getValue().getCodeValue());
    			attributes.put("codeSystem", translation.getValue().getCodeSystem());
    			result.append(createElement("translation", attributes, 0, true, false));
			}
    	}
    }
    
}
