package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.Country;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum Iso3166Alpha2Country.
 */
public class Iso3166Alpha2Country extends EnumPattern implements Country {
	
	private static final long serialVersionUID = -7361050354534966120L;
	
	public static final Iso3166Alpha2Country CANADA = new Iso3166Alpha2Country("CANADA", "CA"); 
	public static final Iso3166Alpha2Country UNITED_STATES = new Iso3166Alpha2Country("UNITED_STATES", "US");

	private final String codeValue;

	private Iso3166Alpha2Country(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.ISO_3166_1_ALPHA_2.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}