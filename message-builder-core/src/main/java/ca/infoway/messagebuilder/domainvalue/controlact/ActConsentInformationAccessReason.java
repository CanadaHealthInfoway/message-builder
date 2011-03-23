package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActConsentInformationAccessReason.
 */
public class ActConsentInformationAccessReason extends EnumPattern implements
		ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason, Describable {
	
	private static final long serialVersionUID = -3966382346162978317L;
	public static final ActConsentInformationAccessReason EMERGENCY = new ActConsentInformationAccessReason("EMERGENCY", "EMERG");
	public static final ActConsentInformationAccessReason PROFESSIONAL_JUDGEMENT = new ActConsentInformationAccessReason("PROFESSIONAL_JUDGEMENT", "PROFJ");

    private final String codeValue;
    
    private ActConsentInformationAccessReason(String name, String codeValue) {
    	super(name);
		this.codeValue = codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_REASON.getRoot();
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