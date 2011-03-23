package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockActCodeEnum extends EnumPattern implements ActCode {
	
	private static final long serialVersionUID = 5768896600339903436L;
	
	public static final MockActCodeEnum SEV = new MockActCodeEnum("SEV");
	public static final MockActCodeEnum IMMUNIZ = new MockActCodeEnum("IMMUNIZ");
	public static final MockActCodeEnum ADVERSE_REACTION = new MockActCodeEnum("ADVERSE_REACTION");
	public static final MockActCodeEnum PORX_TE010210UV = new MockActCodeEnum("PORX_TE010210UV");
	public static final MockActCodeEnum DRUG = new MockActCodeEnum("DRUG");
	public static final MockActCodeEnum INF = new MockActCodeEnum("INF");
	public static final MockActCodeEnum PORX_TE060300UV = new MockActCodeEnum("PORX_TE060300UV");
	public static final MockActCodeEnum G = new MockActCodeEnum("G");

	private MockActCodeEnum(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_CODE.getRoot();
	}

	public String getCodeValue() {
		return name();
	}
}
