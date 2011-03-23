package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.VersionNumber;

public class MockVersionNumber implements VersionNumber {

	public static final VersionNumber MOCK = new MockVersionNumber("MOCK");
	public static final VersionNumber MOCK_MR2009 = new MockVersionNumber("MOCK_MR2009");
	private final String literal;
	
	private MockVersionNumber(String literal) {
		this.literal = literal;
	}
	
	public String getVersionLiteral() {
		return this.literal;
	}
}
