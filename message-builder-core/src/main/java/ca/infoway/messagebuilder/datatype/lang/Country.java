/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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