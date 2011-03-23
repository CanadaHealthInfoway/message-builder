package ca.infoway.messagebuilder.terminology.loader.maven;

import ca.infoway.messagebuilder.Code;

class CodeImpl implements Code {

	private final String code;
	private final String oid;

	CodeImpl(String code, String oid) {
		this.code = code;
		this.oid = oid;
	}

	public String getCodeSystem() {
		return this.oid;
	}

	public String getCodeValue() {
		return this.code;
	}
}
