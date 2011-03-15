package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ParticipationMode. Created manually. 
 */
public class ParticipationMode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ProcessingMode, Describable {
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ParticipationMode ELECTRONIC = new ParticipationMode("ELECTRONIC"); 

	private ParticipationMode(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_PROCESSING_MODE.getRoot();
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
