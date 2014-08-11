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

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractValueNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * INT (R2)
 *
 * Represents a INT object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 */
@DataTypeHandler({"INT", "SXCM<INT>"})
class IntR2PropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

    private final SxcmR2PropertyFormatterHelper sxcmHelper = new SxcmR2PropertyFormatterHelper();
    
	@Override
    protected String getValue(Integer integer, FormatContext context, BareANY bareAny) {
        return integer.toString();
    }
	
    @Override
    protected void addOtherAttributesIfNecessary(Integer integer, Map<String, String> attributes, FormatContext context, BareANY bareAny) {
    	this.sxcmHelper.handleOperator(attributes, context, (ANYMetaData) bareAny);
    	// this is a hack to allow for a single known instance where the base model has extended a data type (INT, in this case) to have an exrta property 
    	if (bareAny instanceof ANYMetaData && ((ANYMetaData) bareAny).isUnsorted()) {
    		attributes.put("unsorted", "true");
    	}
    }
	
}
