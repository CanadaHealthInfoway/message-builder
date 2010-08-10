package ca.infoway.messagebuilder.marshalling.hl7;

import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockEnum extends EnumPattern implements MockCharacters {
	
	private static final long serialVersionUID = 2054176307399510076L;
	
	public static final MockEnum FRED = new MockEnum("FRED");
	public static final MockEnum BARNEY = new MockEnum("BARNEY"); 
	public static final MockEnum WILMA = new MockEnum("WILMA"); 
	public static final MockEnum BETTY = new MockEnum("BETTY"); 
	public static final MockEnum BAM_BAM = new MockEnum("BAM_BAM");

	private MockEnum(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return "1.2.3.4.5";
	}

	public String getCodeValue() {
		return toString();
	}

}
