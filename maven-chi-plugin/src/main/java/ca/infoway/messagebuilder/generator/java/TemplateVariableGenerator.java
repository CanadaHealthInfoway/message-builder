package ca.infoway.messagebuilder.generator.java;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.CamelCaseUtil;


public class TemplateVariableGenerator {
	
	public Set<String> items = new HashSet<String>();
	public StringBuffer buffer = new StringBuffer("TUVWXYZ");
	
	public synchronized TemplateVariable getNext(String templateParameterName) {
		String option = transform(templateParameterName);
		while (isStandardDataType(option) || StringUtils.isBlank(option) || !this.items.add(option)) {
			char var = this.buffer.charAt(0);
			this.buffer.deleteCharAt(0);
			option = String.valueOf(var);
		}
		return new TemplateVariable(option);
	}

	private boolean isStandardDataType(String option) {
		return StandardDataType.getByTypeName(option) != null;
	}

	public static String transform(String templateParameterName) {
		String[] words = StringUtils.split(CamelCaseUtil.convertToWords(templateParameterName));
		if (words.length == 1 && words[0].length() <= 3) {
			return words[0].toUpperCase();
		} else {
			StringBuilder builder = new StringBuilder();
			for (String word : words) {
				builder.append(word.substring(0,1).toUpperCase());
			}
			return builder.toString();
		}
	}
}
