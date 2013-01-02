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

package ca.infoway.messagebuilder.domainvalue.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.Code;

/**
 * <p>Determine a standard description of an object.
 * 
 * <p>This class is ideally designed for enums, which typically have names like 
 * <code>MY_INTERESTING_VALUE</code>.  This utility will convert the description to
 * "My interesting value".
 * 
 * @author BC Holmes
 */
public class DescribableUtil {
    
    /**
     * <p>Gets the default description.
     *
     * @param object the object
     * @return the default description
     */
    public static String getDefaultDescription(Object object) {
    	if (object == null || StringUtils.isBlank(object.toString())) {
    		return "";
    	} else {
	        String temp = object.toString().replace('_', ' ').toLowerCase();
			return temp.substring(0, 1).toUpperCase() + temp.substring(1);
    	}
    }
    
    /**
     * <p>Gets the code description.
     *
     * @param code the code
     * @return the code description
     */
    public static String getCodeDescription(Code code) {
        return WordUtils.capitalizeFully(code.getCodeValue().replace('_', ' '));    
    }
}
