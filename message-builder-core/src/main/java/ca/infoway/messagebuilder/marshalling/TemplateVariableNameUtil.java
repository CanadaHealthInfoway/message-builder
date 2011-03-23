package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.j5goodies.CamelCaseUtil;

public class TemplateVariableNameUtil {

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
