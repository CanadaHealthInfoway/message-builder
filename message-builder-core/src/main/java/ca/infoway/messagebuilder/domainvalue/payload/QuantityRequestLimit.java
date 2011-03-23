package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum QuantityRequestLimit.
 */
public class QuantityRequestLimit extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.QueryRequestLimit {
	
	private static final long serialVersionUID = 669843685953278565L;

	public static final QuantityRequestLimit RECORDS = new QuantityRequestLimit("RECORDS", "RD");
	
	private final String codeValue;

	private QuantityRequestLimit(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return "2.16.840.1.113883.5.1112";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
