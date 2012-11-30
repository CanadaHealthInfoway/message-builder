/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.domainvalue.basic;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;

/**
 * <p>The cerx AD.Basic states that the country is a SC data type (meaning that the code is optional but the text description is always manadatory)
 * {@link Code} can not model this type. In the future we may want to handle this type? 
 * For now we are just using the text description directly and ignoring any iso3166-alpha2 code that may be present.
 * 
 * @deprecated
 *
 * @sharpen.ignore - datatype - translated manually
 */
@Deprecated
public class State implements ca.infoway.messagebuilder.domainvalue.State, Serializable {
    
	private static final long serialVersionUID = -9119222339454680995L;

	public final static State ALBERTA = new State("AB", "Alberta");
	public final static State BRITISH_COLUMBIA = new State("BC", "British Columbia");
	public final static State MANITOBA = new State("MB", "Manitoba");
	public final static State NEW_BRUNSWICK = new State("NB", "New Brunsiwck");
	public final static State NEWFOUNDLAND = new State("NL", "Newfoundland and Labrador");
	public final static State NORTHWEST_TERRITORIES = new State("NT", "Northwest Territories");
	public final static State NOVA_SCOTIA = new State("NS", "Nova Scotia");
	public final static State NUNAVUT = new State("NU", "Nunavat");
	public final static State PRINCE_EDWARD_ISLAND = new State("PE", "Prince Edward Island");
	public final static State ONTARIO = new State("ON", "Ontario");
	public final static State QUEBEC = new State("QC", "Quebec");
	public final static State SASKATCHEWAN = new State("SK", "Saskatchewan");
	public final static State YUKON = new State("YT", "Yukon Territory");

	public final static Map<String, State> CANADIAN_PROVINCES = new LinkedHashMap<String, State>();
	static{
		CANADIAN_PROVINCES.put(ALBERTA.getCode(), ALBERTA);
		CANADIAN_PROVINCES.put(BRITISH_COLUMBIA.getCode(), BRITISH_COLUMBIA);
		CANADIAN_PROVINCES.put(MANITOBA.getCode(), MANITOBA);
		CANADIAN_PROVINCES.put(NEW_BRUNSWICK.getCode(), NEW_BRUNSWICK);
		CANADIAN_PROVINCES.put(NEWFOUNDLAND.getCode(), NEWFOUNDLAND);
		CANADIAN_PROVINCES.put(NORTHWEST_TERRITORIES.getCode(), NORTHWEST_TERRITORIES);
		CANADIAN_PROVINCES.put(NOVA_SCOTIA.getCode(), NOVA_SCOTIA);
		CANADIAN_PROVINCES.put(NUNAVUT.getCode(), NUNAVUT);
		CANADIAN_PROVINCES.put(PRINCE_EDWARD_ISLAND.getCode(), PRINCE_EDWARD_ISLAND);
		CANADIAN_PROVINCES.put(ONTARIO.getCode(), ONTARIO);
		CANADIAN_PROVINCES.put(QUEBEC.getCode(), QUEBEC);
		CANADIAN_PROVINCES.put(SASKATCHEWAN.getCode(), SASKATCHEWAN);
		CANADIAN_PROVINCES.put(YUKON.getCode(), YUKON);
	}
		
	private final String code;
	private final String name;
	
	/**
	 * <p>Constructs a State with the given code and name.
	 * 
	 * @param code a code
	 * @param name a name
	 */
	public State(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * <p>Returns the code.
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
		return this.code;
	}
	
	/**
	 * <p>Returns the collection of values.
	 * 
	 * @return the collection of values
	 */
	public static Collection<State> values() {
		return CANADIAN_PROVINCES.values();
	}

	/**
	 * <p>Returns the State matching the given code.
	 * 
	 * @param code the code to lookup
	 * @return the matching State
	 */
	public static State resolveState(String code) {
		return (State) CANADIAN_PROVINCES.get(code);
	}
	
	/**
	 * <p>Returns an empty code system.
	 * 
	 * @return an empty code system.
	 */
	public String getCodeSystem(){
		return "";
	}		
}