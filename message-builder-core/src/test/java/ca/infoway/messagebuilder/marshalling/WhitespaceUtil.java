package ca.infoway.messagebuilder.marshalling;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public abstract class WhitespaceUtil {

	public static String normalizeWhitespace(String xml) {
		StringBuilder builder = new StringBuilder();
		boolean text = true;
		for (StringTokenizer tokenizer = new StringTokenizer(xml, "<>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			
			if ("<".equals(token)) {
				text = false;
				builder.append(token);
			} else if (">".equals(token)) {
				text = true;
				builder.append(token);
			} else if (!text || StringUtils.isNotBlank(token)) {
				builder.append(token);
			}
		}
		return builder.toString().trim();
	}
}
