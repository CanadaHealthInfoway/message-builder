/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for Currency.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class Currency extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.Currency {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
	private static final long serialVersionUID = -4782912717651803398L;
	
	public static final Currency CANADIAN_DOLLAR = new Currency("CANADIAN_DOLLAR", "CAD");
	public static final Currency US_DOLLAR = new Currency("US_DOLLAR", "USD");
	public static final Currency EURO = new Currency("EURO", "EUR");

    private final String codeValue;

    private Currency(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * <p>Returns the code system for currency.
     * 
     * @return the code system for currency.
     */
    public String getCodeSystem() {
        return "2.16.840.1.113883.5.1058";
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
    }
    
    /**
     * <p>Returns the code value.
     * 
     * @return the code value.
     */
    public String getCodeValue() {
        return this.codeValue;
    }
}
