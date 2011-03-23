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
			if (StringUtils.isNotBlank(relationship.getFixedValue())) {
				builder.append(" \"").append(relationship.getFixedValue()).append("\"");
			}
			if (StringUtils.isNotBlank(relationship.getDomainType())) {
				builder.append(" (").append(relationship.getDomainType()).append(")");
			}
			
		}
		return builder.toString();
	}

}
