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

package ca.infoway.messagebuilder.generator.report;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Relationship;

public class Renderer {

	static String createPartDefinitionSummary(Relationship relationship) {
		StringBuilder builder = new StringBuilder();
		
		if (relationship.isStructural()) {
			builder.append("@");
		}
		if (StringUtils.isNotBlank(relationship.getType())) {
			builder.append(relationship.getType());
		} else if (StringUtils.isNotBlank(relationship.getTemplateParameterName())) {
			builder.append("<").append(relationship.getTemplateParameterName()).append(">");
		}
		if (relationship.isAttribute()) {
			if (relationship.hasFixedValue()) {
				builder.append(" \"").append(relationship.getFixedValue()).append("\"");
			}
			if (StringUtils.isNotBlank(relationship.getDomainType())) {
				builder.append(" (").append(relationship.getDomainType()).append(")");
			}
			
		}
		return builder.toString();
	}

}
