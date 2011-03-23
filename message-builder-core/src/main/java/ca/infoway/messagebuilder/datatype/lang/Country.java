package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;

import ca.infoway.messagebuilder.Code;

/**
 * <p>The cerx AD.Basic states that the country is a SC data type (meaning that the code is optional but the text description is always manadatory)
 * {@link Code} can not model this type. In the future we may want to handle this type? 
 * For now we are just using the text description directly and ignoring any iso3166-alpha2 code that may be present.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @deprecated
 * 
 *  @sharpen.ignore - datatype - translated manually
 */
@Deprecated
public class Country implements ca.infoway.messagebuilder.domainvalue.Country, Serializable {

	private static final long serialVersionUID = 407008735068117828L;

	/** 
	 * <p>Canada.
	 */
	public final static Country CANADA = new Country("CA", "Canada");
	/** 
	 * <p>United States.
	 */
	public final static Country USA = new Country("US", "United States of America");

	private final String code;
	private final String name;

	/**
	 * <p>Constructs a Country using  the supplied parameters.
	 * 
	 * @param code a code
	 * @param name a name
	 */
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * <p>Returns the country code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * <p>Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * <p>Returns the code value.
	 * 
	 * @return the code value
	 */
	public String getCodeValue() {
		// arguably we could use code here, but code is an optional attribute in the XML
		return this.name;
	}

	/**
	 * <p>Returns the codesystem as an empty string.
	 * 
	 * @return the codesystem as an empty string
	 */
	public String getCodeSystem(){
		return "";
	}		
	
	/**
	 * <p>Returns the country applicable for the country code.
	 * 
	 * @param countryCode the country code
	 * @return the country applicable for the country code
	 */
	public static Country resolveCountry(String countryCode) {
		return Country.CANADA.getCode().equals(countryCode) ?  Country.CANADA : null;
	}

	/**
	 * <p>Returns the country applicable for the country name (Canada only!).
	 * 
	 * @param countryName the country name
	 * @return the country applicable for the country name (Canada only!)
	 */
	public static String resolveCountryCode(String countryName) {
		return Country.CANADA.getName().equalsIgnoreCase(countryName) ?  Country.CANADA.getCode() : null;
	}
}