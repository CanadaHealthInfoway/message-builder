package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum x_ActMoodOrderEvent.
 */
public class x_ActMoodOrderEvent extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent {
	
	private static final long serialVersionUID = 7047002739820769921L;
	
	public static final x_ActMoodOrderEvent EVENT = new x_ActMoodOrderEvent("EVENT", "EVN"); 
	public static final x_ActMoodOrderEvent REQUEST = new x_ActMoodOrderEvent("REQUEST", "RQO");
	
	private final String codeValue;

	private x_ActMoodOrderEvent(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_MOOD.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

}
