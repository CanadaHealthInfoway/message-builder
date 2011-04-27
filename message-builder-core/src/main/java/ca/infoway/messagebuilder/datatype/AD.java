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

package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PostalAddress;

/**
 * <p>HL7 datatype for addresses. Backed by the java datatype PostalAddress.
 * 
 * <p>Covers:
 * 
 * <p>AD.BASIC:  Used to communicate addresses for simple display, mailing and contact purposes.  
 *            The data type is not generally suitable for registries.
 * <p>AD.FULL:   Used to communicate fully validatable addresses. Usually appropriate only for registry-type situations.
 * <p>AD.SEARCH: This type is used to convey high level address information for searching purposes. All matches are 
 *            considered to be "starts with" for each specified property.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface AD extends ANY<PostalAddress> {

}
