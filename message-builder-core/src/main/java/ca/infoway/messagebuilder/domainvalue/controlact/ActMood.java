package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActMood. 
 */
public class ActMood extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActCode, Describable {
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ActMood DEF = new ActMood("DEF"); 
	public static final ActMood EVN = new ActMood("EVN"); 
	public static final ActMood EVN_CRT = new ActMood("EVN.CRT"); 
	public static final ActMood EVNINT_CRT = new ActMood("EVNINT.CRT"); 
	public static final ActMood INT = new ActMood("INT"); 
	public static final ActMood PERM = new ActMood("PERM"); 
	public static final ActMood RQO = new ActMood("RQO"); 

	private ActMood(String name) {
		super(name);
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
		return name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
