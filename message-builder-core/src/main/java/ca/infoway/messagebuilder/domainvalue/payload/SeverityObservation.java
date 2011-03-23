package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum SeverityObservation. An indication of the seriousness of a patient's medical 
 * condition or issues. Conditions for which severity levels are assigned include: disease state, 
 * allergies, intolerance and contraindications involving combinations of drugs and other conditions.
 */
public class SeverityObservation extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.SeverityObservation {
	
	private static final long serialVersionUID = -5776943781743759764L;
	
	public static final SeverityObservation HIGH = new SeverityObservation("HIGH", "H"); 
	public static final SeverityObservation MODERATE = new SeverityObservation("MODERATE", "M"); 
	public static final SeverityObservation LOW = new SeverityObservation("LOW", "L");

    private final String codeValue;

    private SeverityObservation(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
