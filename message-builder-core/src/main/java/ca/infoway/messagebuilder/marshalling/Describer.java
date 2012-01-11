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

package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Relationship;

class Describer {

	static String describe(MessagePartHolder messagePart, Relationship relationship) {
		return describe(messagePart.getName(), relationship);
	}

	static String describe(Class<?> tealClass, BeanProperty property) {
		return describe(tealClass, property.getName());
	}
	
	static String describe(Class<?> tealClass, String name) {
		return ClassUtils.getShortClassName(tealClass) + "." + name;
	}
	
	static String describe(String messagePartName, Relationship relationship) {
		return relationship.getName() + " of type " + messagePartName;
	}

}
