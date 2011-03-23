package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public class Hl7DataTypeName {
	
	private final String name;

	private Hl7DataTypeName(String name) {
		this.name = name;
	}
	
	public static Hl7DataTypeName create(String name) {
		return new Hl7DataTypeName(name);
	}
	
	public Hl7DataTypeName getUnqualifiedVersion() {
		if (isQualified()) {
			return create(unqualify());
		} else {
			return this;
		}
	}

	private String unqualify() {
		StringBuilder builder = new StringBuilder();
		for (StringTokenizer tokenizer = new StringTokenizer(this.name, "<,>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			if ("<,>".indexOf(token) >= 0) {
				builder.append(token);
			} else if (isQualified(token)) {
				builder.append(StringUtils.substringBefore(token, "."));
			} else {
				builder.append(token);
			}
		}
		return builder.toString();
	}

	private boolean isQualified(String token) {
		return token.contains(".");
	}

	public String toString() {
		return this.name;
	}

	public boolean isQualified() {
		return this.name.contains(".");
	}

	public static String unqualify(String name) {
		return create(name).getUnqualifiedVersion().toString();
	}

	public static String getTypeWithoutParameters(String name) {
		return StringUtils.isNotBlank(name) && name.contains("<") ? StringUtils.substringBefore(name, "<") : name;
	}
	
	public static String getParameterizedType(String type) {
		return StringUtils.substringBeforeLast(StringUtils.substringAfter(type, "<"), ">");
	}
}
