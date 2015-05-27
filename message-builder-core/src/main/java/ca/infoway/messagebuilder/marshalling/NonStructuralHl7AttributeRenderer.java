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

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeRegistry.CodeTypeRegistry;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.util.DomainTypeHelper;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.Relationship;

class NonStructuralHl7AttributeRenderer {
	
	static Object getFixedValue(Relationship relationship, VersionNumber version, boolean isR2, Hl7Errors errors, String propertyPath) {
		String fixedValue = relationship.getFixedValue();
		if (StringUtils.equals("BL",relationship.getType())) {
			return Boolean.TRUE.toString().equalsIgnoreCase(fixedValue);
		} else if (StringUtils.equals("INT.POS", relationship.getType())) {
			return new Integer(fixedValue);
		} else if (StringUtils.equals("ST", relationship.getType())) {
			return fixedValue;
		} else if (relationship.isCodedType()) {
			Class<? extends Code> codeType = DomainTypeHelper.getReturnType(relationship, version, CodeTypeRegistry.getInstance());
			if (codeType == null) {
				codeType = Code.class;
			}
			Code code = CodeResolverRegistry.lookup(codeType, fixedValue);
			if (code == null) {
				String message = MessageFormat.format("Fixed code lookup could not find match for {0}.{1}", relationship.getDomainType(), fixedValue);
				errors.addHl7Error(new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, ErrorLevel.WARNING, message, propertyPath));
			}
			//Fixup for .NET
			if (isR2) {
				return code == null ? null : new CodedTypeR2<Code>(code);
			} else {
				return code;
			}
		} else {
			throw new MarshallingException("Cannot handle a fixed relationship of type: " + relationship.getType());
		}
	}
}