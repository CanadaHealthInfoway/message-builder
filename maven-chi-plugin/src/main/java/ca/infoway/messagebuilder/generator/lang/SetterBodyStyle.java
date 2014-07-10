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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;

import ca.infoway.messagebuilder.generator.lang.PropertyGeneratorBuilder.Setter;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

public enum SetterBodyStyle implements MethodBody {
	DEFAULT() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(getBodyFormat(builder.language), 
					builder.nameProvider.getName(resolver), setter.nameProvider.getName(resolver) ));
		}

		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "this.{0} = {1};" : "this.{0} = value;";
		}
	},
	ATTRIBUTE() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(getBodyFormat(builder.language), 
					builder.nameProvider.getName(resolver), setter.nameProvider.getName(resolver) ));
		}

		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "this.{0}.setValue({1});" : "this.{0}.Value = value;";
		}
	},
	COLLECTION_ELEMENT() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(
					getBodyFormat(builder.language), 
					PropertyGeneratorBuilder.capitalize(builder.nameProvider.getName(resolver)), setter.nameProvider.getName(resolver) ));
		}
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "get{0}().clear(); get{0}().add({1});" : "get{0}().clear(); get{0}().Add(value);";
		}
		@Override
		public boolean useTypeDecorator() {
			return false;
		}
	};
	public abstract String getBodyFormat(ProgrammingLanguage language);
	public abstract void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException;
	public String create(PropertyGeneratorBuilder builder, Setter setter, BaseRelationshipNameResolver resolver) throws IOException {
		StringWriter writer = new StringWriter();
		create(builder, setter, writer, resolver);
		return writer.toString();
	}
	public boolean useTypeDecorator() {
		return true;
	}
}