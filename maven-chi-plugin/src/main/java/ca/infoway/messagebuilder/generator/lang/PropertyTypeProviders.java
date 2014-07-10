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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.lang.PropertyGeneratorBuilder.PropertyTypeProvider;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

public class PropertyTypeProviders {

	static class Attribute implements PropertyTypeProvider {
		private ca.infoway.messagebuilder.generator.lang.Attribute attribute;
		private final ProgrammingLanguage language;
		@Deprecated
		Attribute(ca.infoway.messagebuilder.generator.lang.Attribute attribute) {
			this(attribute, ProgrammingLanguage.JAVA);
		}
		Attribute(ca.infoway.messagebuilder.generator.lang.Attribute attribute, ProgrammingLanguage language) {
			this.attribute = attribute;
			this.language = language;
		}
		
		public boolean hasType() {
			return attribute != null;
		}
		public String getType(ClassNameManager manager) {
			DataType dataType = this.attribute.getDataType();
			String type = dataType.getTypeName(this.language);
			return manager.getRepresentationOfClassName(type) + dataType.getTypeParameters(this.language);
		}
	}

	static class Association implements PropertyTypeProvider {
		private ca.infoway.messagebuilder.generator.lang.Association association;
		Association(ca.infoway.messagebuilder.generator.lang.Association association) {
			this.association = association;
		}
		
		public boolean hasType() {
			return association != null;
		}
		public String getType(ClassNameManager manager) {
			String type;
			if (this.association.isTemplateType()) {
				type = this.association.getTemplateVariable().getType() + this.association.getTypeParameters();
			} else {
				type = manager.getRepresentationOfType(this.association.getAssociationType()) + this.association.getTypeParameters();
			}
			return type;
		}
	}
	
	static class Identity implements PropertyTypeProvider {
		private String type;
		Identity(String type) {
			this.type = type;
		}
		public boolean hasType() {
			return type != null;
		}
		public String getType(ClassNameManager manager) {
			return type;
		}
	}
	
}
