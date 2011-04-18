package ca.infoway.messagebuilder.codeset.newfoundland;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class QueryRequestLimitEnum extends EnumPattern implements Code {
	
	private static final long serialVersionUID = 1908549015408291860L;
	
	public static final QueryRequestLimitEnum RD = new QueryRequestLimitEnum("RD");
	
	private QueryRequestLimitEnum(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_QUERY_REQUEST_LIMIT.getRoot();
	}

	public String getCodeValue() {
		return name();
	}
}