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

package ca.infoway.messagebuilder.generator.java;

import static java.lang.String.format;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

enum TypeDecorator {
	NULL() {
		@Override
		public String decorateType(String type, ProgrammingLanguage language) {
			return type;
		}
		@Override
		public String decorateImplType(String type, String implType, ProgrammingLanguage language) {
			return implType;
		}
	}, 
	LIST() {
		@Override
		public String decorateType(String type, ProgrammingLanguage language) {
			return language == ProgrammingLanguage.C_SHARP ? format("IList<%s>", type) : format("List<%s>", type);
		}
		@Override
		public String decorateImplType(String type, String implType, ProgrammingLanguage language) {
			return language == ProgrammingLanguage.C_SHARP ? format("List<%s>", type) : format("ArrayList<%s>", type);
		}
	};
	public abstract String decorateType(String type, ProgrammingLanguage language);
	public abstract String decorateImplType(String type, String implType, ProgrammingLanguage language);
}