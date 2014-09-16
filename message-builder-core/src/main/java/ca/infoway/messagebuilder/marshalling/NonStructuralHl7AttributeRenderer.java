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

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.Relationship;

class NonStructuralHl7AttributeRenderer {
	
	static Object getFixedValue(Relationship relationship, VersionNumber version, boolean isR2) {
		if (StringUtils.equals("BL",relationship.getType())) {
			return Boolean.TRUE.toString().equalsIgnoreCase(relationship.getFixedValue());
		} else if (StringUtils.equals("INT.POS", relationship.getType())) {
			return new Integer(relationship.getFixedValue());
		} else if (relationship.isCodedType()) {
			Class<? extends Code> codeType = DomainTypeHelper.getReturnType(relationship, version);
			if (codeType == null) {
				codeType = Code.class;
			}
			Code code = CodeResolverRegistry.lookup(codeType, relationship.getFixedValue());
			return isR2 ? new CodedTypeR2<Code>(code): code;
		} else {
			throw new MarshallingException("Cannot handle a fixed relationship of type: " + relationship.getType());
		}
	}
}