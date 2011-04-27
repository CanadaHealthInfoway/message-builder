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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodedString;

/**
 * <p>Hl7 datatype SC (Coded String). Backed by the Java datatype CodedString.
 *
 * <p>An ST that optionally may have a code attached. The text must always be present if a code is present. 
 * The code is often a local code.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type
 * @sharpen.ignore - datatype - translated manually 
 */
public interface SC<V extends Code> extends ANY<CodedString<V>> {
}
