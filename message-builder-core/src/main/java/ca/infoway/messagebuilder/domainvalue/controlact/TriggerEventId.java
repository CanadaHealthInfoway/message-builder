package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum TriggerEventId. Created manually. 
 */
public class TriggerEventId extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActCode, Describable {
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final TriggerEventId PORX_TE010340CA = new TriggerEventId("PORX_TE010340CA"); 

	private TriggerEventId(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_CODE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
