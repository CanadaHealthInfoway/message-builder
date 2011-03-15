package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActCode. A code specifying the particular kind of Act that the Act-instance represents within its class. 
 */
public class ActCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActCode, Describable {
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ActCode ADVERSE_REACTION = new ActCode("ADVERSE_REACTION"); 
	public static final ActCode CHRON = new ActCode("CHRON"); 
	public static final ActCode DRUG = new ActCode("DRUG"); 
	public static final ActCode FS = new ActCode("FS"); 
	public static final ActCode G = new ActCode("G"); 
	public static final ActCode IMMUNIZ = new ActCode("IMMUNIZ"); 
	public static final ActCode INF = new ActCode("INF"); 
	public static final ActCode INFA = new ActCode("INFA"); 
	public static final ActCode OBSANTC = new ActCode("OBSANTC"); 
	public static final ActCode OBSANTV = new ActCode("OBSANTV"); 
	public static final ActCode PORX_TE010210UV = new ActCode("PORX_TE010210UV"); 
	public static final ActCode REP_HALF_LIFE = new ActCode("REP_HALF_LIFE"); 
	public static final ActCode SEV = new ActCode("SEV"); 
	public static final ActCode STORE = new ActCode("STORE"); 
	public static final ActCode TF = new ActCode("TF"); 
	public static final ActCode VFPAPER = new ActCode("VFPAPER"); 

	private ActCode(String name) {
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
