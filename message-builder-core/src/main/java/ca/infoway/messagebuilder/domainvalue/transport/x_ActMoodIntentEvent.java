package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum x_ActMoodIntentEvent.
 */
public class x_ActMoodIntentEvent extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent, Describable {

	private static final long serialVersionUID = -90066419599911191L;
	
	public static final x_ActMoodIntentEvent EVENT = new x_ActMoodIntentEvent("EVN"); 
	public static final x_ActMoodIntentEvent REQUEST = new x_ActMoodIntentEvent("RQO");

	private x_ActMoodIntentEvent(String codeValue) {
		super(codeValue);
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
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}