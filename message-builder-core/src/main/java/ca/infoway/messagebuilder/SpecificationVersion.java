package ca.infoway.messagebuilder;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that lists the various supported hl7 versions.
 */
public class SpecificationVersion extends EnumPattern implements VersionNumber {

	private static final long serialVersionUID = 3269139690668726076L;

	/**
	 * <p>This designation is used for a stand-alone version of the IEHR messages.  It
	 * was released on 2007-05-08
	 */
	public static final SpecificationVersion V01R01_4 = new SpecificationVersion("V01R01_4", "V01R01.4");

	public static final SpecificationVersion V01R04_3 = new SpecificationVersion("V01R04_3", "V01R04.3");
	public static final SpecificationVersion V01R04_3_HOTFIX1 = new SpecificationVersion("V01R04_3_HOTFIX1", "V01R04.3_HOTFIX1"); 
	public static final SpecificationVersion V01R04_3_HOTFIX2 = new SpecificationVersion("V01R04_3_HOTFIX2", "V01R04.3_HOTFIX2"); 
	public static final SpecificationVersion V01R04_3_HOTFIX3 = new SpecificationVersion("V01R04_3_HOTFIX3", "V01R04.3_HOTFIX3");

	public static final SpecificationVersion R02_04_00 = new SpecificationVersion("R02_04_00", "R02.04.00");
	
	public static final SpecificationVersion V02R01 = new SpecificationVersion("V02R01", "V02R01");

	/**
	 * <p>This designation is used for the major release of CeRx, CR, PR and other 
	 * messages.  It appears to have been officially released on 2007-12-07.
	 */
	public static final SpecificationVersion V02R02 = new SpecificationVersion("V02R02", "V02R02");
	/**
	 * <p>R02.04.00 is the designation given to Maintenance Release 2009 (MR 2009), 
	 * officially released on 2009-03-16.
	 */
	public static final SpecificationVersion R02_04_02 = new SpecificationVersion("R02_04_02", "R02.04.02");
	
	/**
	 * Newfoundland and Labrador (mixed V01R04.3 / V02R02).
	 */
	public static final SpecificationVersion NEWFOUNDLAND = new SpecificationVersion("NEWFOUNDLAND", "Newfoundland and Labrador (mixed V01R04.3 / V02R02)");
	
	public static final SpecificationVersion NA = new SpecificationVersion("NA", "", true);
	
	private final String description;
	private final boolean unknown;
	
	private SpecificationVersion(String name, String description) {
		this(name, description, false);
	}
	private SpecificationVersion(String name, String description, boolean unknown) {
		super(name);
		this.description = description;
		this.unknown = unknown;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getVersionLiteral() {
		return name();
	}
	
	/**
	 * <p>Checks if is unknown.
	 *
	 * @return true, if is unknown
	 */
	public boolean isUnknown() {
		return this.unknown;
	}
	
	/**
	 * <p>Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

}
