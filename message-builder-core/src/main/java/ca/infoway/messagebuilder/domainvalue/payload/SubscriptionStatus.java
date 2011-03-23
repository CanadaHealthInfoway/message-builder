package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum SubscriptionStatus.
 */
public class SubscriptionStatus extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.SubscriptionStatus, Describable {

	private static final long serialVersionUID = -8472481397627274517L;
	
	public static final SubscriptionStatus SUBSCRIBED = new SubscriptionStatus("SUBSCRIBED", "1"); 
	public static final SubscriptionStatus UNSUBSCRIBED = new SubscriptionStatus("UNSUBSCRIBED", "2");

	private final String codeValue;

	private SubscriptionStatus(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.SUBSCRIPTION_STATUS.getRoot();
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
