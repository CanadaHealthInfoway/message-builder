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

package ca.infoway.messagebuilder.datatype.lang.util;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Enum for PersonName part types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PersonNamePartType extends EnumPattern implements NamePartType {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
    private static final long serialVersionUID = 8255492551088946001L;
    
	public static final PersonNamePartType DELIMITER = new PersonNamePartType("DELIMITER", "delimiter"); 
    public static final PersonNamePartType PREFIX = new PersonNamePartType("PREFIX", "prefix"); 
    public static final PersonNamePartType SUFFIX = new PersonNamePartType("SUFFIX", "suffix"); 
    public static final PersonNamePartType FAMILY = new PersonNamePartType("FAMILY", "family"); 
    public static final PersonNamePartType GIVEN = new PersonNamePartType("GIVEN", "given");

	private final String value;

    private PersonNamePartType(String name, String value) {
    	super(name);
		this.value = value;
    }
    
    /**
     * <p>Returns the enum value.
     * 
     * @return the enum value
     */
    public String getValue() {
        return this.value;
    }
}
