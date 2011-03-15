package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActSpecimenTransportationCode.
 */
public class ActSpecimenTransportationCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActSpecimenTransportationCode, Describable {
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ActSpecimenTransportationCode SREC = new ActSpecimenTransportationCode("SREC"); 

	private ActSpecimenTransportationCode(String name) {
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
