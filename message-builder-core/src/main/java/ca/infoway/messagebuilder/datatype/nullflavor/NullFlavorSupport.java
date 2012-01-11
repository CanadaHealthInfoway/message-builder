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

package ca.infoway.messagebuilder.datatype.nullflavor;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * 
 * <p>Interface used to define behaviour for any nullable HL7 datatype, java datatype or message part bean.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public interface NullFlavorSupport {
    
	/**
	 * <p>Determines if the object currently has a null flavor set.
	 * 
	 * @return whether the object currently has a null flavor.
	 */
    public boolean hasNullFlavor();
    
    /**
     * <p>Returns the current null flavor state of the object.
     * 
     * @return the null flavor
     */
    public NullFlavor getNullFlavor();
    
    /**
     * <p>Sets a null flavor on the object.
     * 
     * @param nullFlavor the null flavor to set
     */
    public void setNullFlavor(NullFlavor nullFlavor);

}
