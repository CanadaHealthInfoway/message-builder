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

package ca.infoway.messagebuilder.datatype.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Java datatype for TN Hl7 datatypes.
 * 
 * <p>A string used for simple names for things (e.g. drug names) and places (e.g. "Canada Health Infoway")
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class TrivialName extends EntityName {

    private final String name;
   
    /**
     * 
     * <p>Constructs a trivial name based on a string.
     * 
     * @param name the trivial name
     */
    public TrivialName(String name) {
        this.name = name;
    }

    /**
     * <p>Returns this trivial name as a list containing a single EntityNamPart.
     * 
     * @return this trivial name as a list of parts.
     */
    @Override
    public List<EntityNamePart> getParts() {
        if (this.name == null) {
            return new ArrayList<EntityNamePart>();
        } else {
            return Arrays.asList(new EntityNamePart(this.name));
        }
    }

    /**
     * <p>Returns this trivial name formatted as a string.
     *  
     * @return this trivial name formatted as a string 
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * 
     * <p>Returns the underlying string representing this trivial name.
     * 
     * @return the underlying string representing this trivial name.
     */
    public String getName() {
        return this.name;
    }
}
