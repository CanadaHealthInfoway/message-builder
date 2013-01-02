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

package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * @sharpen.ignore
 * 
 * The Hl7MapByPartTypes annotation only exists in Java
 * 
 */

final class MappingHelper {
	
	static final Hl7MapByPartType[] EMPTY = new Hl7MapByPartType[0];  

	static Hl7MapByPartType[] getAllHl7MapByPartType(BeanProperty property) {
		Hl7MapByPartTypes exceptions = property.getAnnotation(Hl7MapByPartTypes.class);
		return exceptions == null ? EMPTY : exceptions.value();
	}
	
}
