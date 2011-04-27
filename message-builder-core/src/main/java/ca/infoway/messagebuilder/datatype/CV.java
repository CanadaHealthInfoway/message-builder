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


/**
 * <p>HL7 datatype CV. Backed by a Code.
 * 
 * <p>Coded data, specifying only a code, code system, and optionally display name and original text. Used only as the 
 * type of properties of other	data types.
 * 
 * <p>CV is used when any reasonable use case will require only a single code value to be sent. Thus, it should not 
 * be used in circumstances where multiple alternative codes for a given value are desired. This type may be used 
 * with both the CNE (coded, non-extensible) and the CWE (coded, with extensibility) domain qualifiers.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface CV extends CE {
}
