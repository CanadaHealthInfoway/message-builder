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

package ca.infoway.messagebuilder.domainvalue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * @sharpen.ignore missing test
 */
public class VocabularyCodeSystemTest {
	
	@Test
	public void allEnumsShouldHaveACodeSystem() throws Exception {
		
		List<Class<?>> list = new ClassFinder().findClasses(ActCode.class, Predicates.isInstanceofPredicate(Code.class));
		for (Class<?> codeType : list) {
			if (EnumPattern.isEnum(codeType)) {
				for (Object o : EnumPattern.getEnumConstants(codeType)) {
					Code code = (Code) o;
					assertNotNull("code " + ClassUtils.getShortClassName(codeType) + "." + code.toString(), code.getCodeSystem());
				}
			}
		}
	}

	@Test
	public void codeSystemsArentTypeOids() throws Exception {
		for (CodeSystem codeSystem : EnumPattern.values(CodeSystem.class)) {
			assertFalse("code system " + codeSystem.name() + " should not use 2.16.840.1.113883.1.11.* oids",
					codeSystem.getRoot().startsWith("2.16.840.1.113883.1.11."));
		}
	}
}
