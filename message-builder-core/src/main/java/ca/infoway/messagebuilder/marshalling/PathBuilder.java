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

package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class PathBuilder {

	private final Log log = LogFactory.getLog(PathBuilder.class);

	private final MessageDefinitionService service;
	private final VersionNumber version;

	PathBuilder(MessageDefinitionService service, VersionNumber version) {
		this.service = service;
		this.version = version;
	}
	
	List<TypeName> findPathTo(TypeName start, TypeName end) {
		validateHasType(end, "end");
		validateHasType(start, "start");
		List<TypeName> results = new ArrayList<TypeName>();
		if (ObjectUtils.equals(start, end) || findPathTo(start, end, results)) {
			// expected
		} else {
			this.log.error("PathBuilder: Could not find a type path from start to end (" + start + ", " + end + "). Using end type only.");
		}
		results.add(end);
		return results;
	}

	private void validateHasType(TypeName typeName, String position) {
		if (typeName == null || typeName.getName() == null) {
			throw new IllegalStateException("Cannot determine a type path when type is null (for " + position + ")");
		}
	}

	private boolean findPathTo(TypeName start, TypeName end, List<TypeName> results) {
		List<String> childs = getMessagePart(start).getSpecializationChilds();
		for (String childName : childs) {
			TypeName childTypeName = new TypeName(childName); 
			if (ObjectUtils.equals(childTypeName, end)) {
				results.add(start);
				return true;
			} else {
				if (findPathTo(childTypeName, end, results)) {
					results.add(0, start);
					return true;
				}
			}
		}
		return false;
	}

	private MessagePart getMessagePart(TypeName typeName) {
		return this.service.getMessagePart(this.version, typeName.getName());
	}
	
}
