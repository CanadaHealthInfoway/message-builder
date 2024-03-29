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

package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.generator.lang.CodeGenerator;

public abstract class Hl7TypeCodeGenerator extends CodeGenerator {

	protected boolean isInSamePackage(String className) {
		return getPackageName().equals(ClassUtils.getPackageName(className));
	}

	protected abstract String getPackageName();
	public boolean shouldBeFullyQualified(String className) {
		return conflictsWithTypeName(className);
	}

	protected abstract boolean conflictsWithTypeName(String className);
}
