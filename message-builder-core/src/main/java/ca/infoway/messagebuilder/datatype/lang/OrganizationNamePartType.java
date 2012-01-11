/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for organization name part types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class OrganizationNamePartType extends EnumPattern implements NamePartType {
	
    private static final long serialVersionUID = -8005396643000939327L;
    
	public static final OrganizationNamePartType DELIMETER = new OrganizationNamePartType("DELIMETER", "delimiter"); 
    public static final OrganizationNamePartType PREFIX = new OrganizationNamePartType("PREFIX", "prefix");
    public static final OrganizationNamePartType SUFFIX = new OrganizationNamePartType("SUFFIX", "suffix");

	private final String value;

    private OrganizationNamePartType(String name, String value) {
        super(name);
		this.value = value;
    }
    
    /**
     * <p>Returns the value of this enum.
     * 
     * @return the value
     */
    public String getValue() {
        return this.value;
    }
}
