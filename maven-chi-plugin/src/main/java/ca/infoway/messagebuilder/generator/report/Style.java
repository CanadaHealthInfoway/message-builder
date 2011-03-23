package ca.infoway.messagebuilder.generator.report;

enum Style {
	HEADER, 
	DIFFERENCE, 
	NO_DIFFERENCE, 
	NOT_APPLICABLE, 
	MINOR_DIFFERENCE;

	public static String makeName(Style[] styles) {
		StringBuilder builder = new StringBuilder();
		for (Style style : styles) {
			if (builder.length() > 0) {
				builder.append(" and ");
			}
			builder.append(style.name());
		}
		return builder.toString();
	}
}