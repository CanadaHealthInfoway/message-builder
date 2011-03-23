package ca.infoway.messagebuilder.acceptance.metrics;

public enum AcceptanceTestLanguage {
	
	JAVA("Java"),
	DOT_NET(".Net");
	
	private String languageLiteral;
	
	public String getLanguageLiteral() {
		return this.languageLiteral;
	}
	
	public static AcceptanceTestLanguage getLanguage(String languageLiteral) {
		for (AcceptanceTestLanguage language : AcceptanceTestLanguage.values()) {
			if (language.getLanguageLiteral().equals(languageLiteral)) {
				return language;
			}
		}
		return null;
	}

	private AcceptanceTestLanguage(String languageLiteral) {
		this.languageLiteral = languageLiteral;
	}
	
}
