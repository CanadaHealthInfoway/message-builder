package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * At the moment, this code set only supports one reason, used for the eReferrals ping.
 * 
 * Identifies why this specific query, modification request, or modification occurred.
 */
public class ActReason extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActReason, Describable {
	private static final long serialVersionUID = -4688667149166033487L;

	public static final ActReason SYSTEM_TEST = new ActReason("SYSTEM_TEST", "SYSTEST");

	private final String codeValue;

	private ActReason(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.REFERRALS_ACT_REASON.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
