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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_VER;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.text.Indenter;

@DataTypeHandler("II")
class IiPropertyFormatter extends AbstractAttributePropertyFormatter<Identifier> {

	private static Set<StandardDataType> abstractIiTypes = new HashSet<StandardDataType>(Arrays.asList(
			StandardDataType.II, 
			StandardDataType.II_BUS_AND_VER));
	
	@Override
	String formatNonNullDataType(FormatContext context, BareANY bareAny, int indentLevel) throws ModelToXmlTransformationException {
		
		IIImpl ii = (IIImpl) bareAny;
		
    	StringBuilder builder = new StringBuilder();
        if (StringUtils.isBlank(ii.getValue().getRoot())) {
        	Indenter.indentBuilder(builder, indentLevel);
        	builder.append("<!-- WARNING: ")
        			.append("Property root on oid property ")
        			.append(context.getElementName())
        			.append(" cannot be null: ")
        			.append(ii)
        			.append(" -->");
        	builder.append(SystemUtils.LINE_SEPARATOR);
        }
        builder.append(super.formatNonNullDataType(context, ii, indentLevel));
		return builder.toString();
	}

	/**
     * II - Installer Identifier
     * 
     * II has two attributes: root, extension
     *
     * CeRx standards claim that both attributes are required, although extension 
     * is sometimes unused. 
     * 
     * The HL7 standard also defines the assigningAuthorityName attribute, but that
     * has been left out of the CeRx implementation.
     * 
     * According to CeRx: Root has a limit of 100 characters, extension of 20 
     * characters. These limits are not currently enforced by this class. 
     *
     * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
     */
    @Override
    Map<String,String> getAttributeNameValuePairs(FormatContext context, Identifier ii, BareANY bareAny) throws ModelToXmlTransformationException {
    	
        VersionNumber version = context.getVersion();

        Map<String, String> result = new HashMap<String, String>();
    	result.put("root", ii.getRoot() == null ? StringUtils.EMPTY : ii.getRoot());

    	String type = context.getType();
    	if (!SpecificationVersion.isVersion(SpecificationVersion.V01R04_3, version) 
    			&& (StandardDataType.II.getType().equals(type) || StandardDataType.II_BUS_AND_VER.getType().equals(type))) {
    		StandardDataType dataType = bareAny.getDataType();
    		if (!abstractIiTypes.contains(dataType)) {
    			// only set a specialization type if we have a concrete II type supplied
    			type = dataType.getType();
    			result.put("specializationType", type);
    		}
    	}
        
        if (StringUtils.isNotBlank(ii.getExtension())) {
            result.put("extension", ii.getExtension());
        }
        
		if (StringUtils.equals(II_BUS.getType(), type)) {
            result.put("use", "BUS");
        } else if (StringUtils.equals(II_VER.getType(), type)) {
            result.put("use", "VER");
        } else if (StringUtils.equals(II_PUBLIC.getType(), type)) {
            result.put("displayable", "true");
            if (version != null) {
				if (!SpecificationVersion.isVersion(SpecificationVersion.V01R04_3, version) &&
					!SpecificationVersion.isVersion(SpecificationVersion.V02R01, version) &&
					!SpecificationVersion.isVersion(SpecificationVersion.V02R02, version) && 
					!SpecificationVersion.isVersion(SpecificationVersion.NEWFOUNDLAND, version)) {
					result.put("use", "BUS");
	            }
            }
        } 
        
        return result;
    }

}
