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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.lang.Decorator;
import ca.infoway.messagebuilder.generator.lang.Indenter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class MapByPartTypeAnnotationDecorator extends Indenter implements Decorator {

	private final BaseRelationship baseRelationship;
	private final ProgrammingLanguage programmingLanguage;
	private final int indentLevel;
	
	public MapByPartTypeAnnotationDecorator(int indent, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		this.indentLevel = indent;
		this.baseRelationship = baseRelationship;
		this.programmingLanguage = programmingLanguage;
	}

	public String render() {
		String result = StringUtils.EMPTY;
		if (requiresMapByPartTypeAnnotation()) {
			List<NameAndType> mappings = new ArrayList<NameAndType>(this.baseRelationship.getMapByPartTypeMappings());
			Collections.sort(mappings);
			result = createMappingsString(mappings);
		}
		return result;
	}

	boolean requiresMapByPartTypeAnnotation() {
		return this.baseRelationship.requiresMapByPartTypeAnnotation();
	}

	private String createMappingsString(List<NameAndType> mappings) {
		String result = null;
		switch (this.programmingLanguage) {
		case JAVA:
			result = createMappingsForJava(mappings);
			break;
		case C_SHARP:
			result = createMappingsForCsharp(mappings);
			break;
		default:
			throw new IllegalStateException(this.getClass().getSimpleName() + " currently only works with Java or CSharp.");
		}
		return result;
	}

	private String createMappingsForCsharp(List<NameAndType> mappings) {
		StringBuilder builder = new StringBuilder();
		for (NameAndType nameAndType : mappings) {
			builder.append("\n");
			indent(this.indentLevel, builder);
			builder.append("[Hl7MapByPartType(Name=\"");
			builder.append(nameAndType.getName());
			builder.append("\", Type=\"");
			builder.append(nameAndType.getType());
			builder.append("\")]");
		}
		return builder.toString();
	}

	private String createMappingsForJava(List<NameAndType> mappings) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		indent(this.indentLevel, builder);
		builder.append("@Hl7MapByPartTypes({");
		boolean moreThanOneMapping = mappings.size() > 1;
		boolean first = true;
		for (NameAndType nameAndType : mappings) {
			if (!first) {
				builder.append(",");
			}
			if (moreThanOneMapping) {
				builder.append("\n");
				indent(this.indentLevel+1, builder);
			}
			
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(nameAndType.getName());
			builder.append("\", type=\"");
			builder.append(nameAndType.getType());
			builder.append("\")");
			first = false;
		}
		builder.append("})");
		return builder.toString();
	}

}
