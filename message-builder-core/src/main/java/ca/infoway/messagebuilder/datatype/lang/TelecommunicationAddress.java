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

package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;

/**
 * <p>A class to represent CeRx's notion of a telecommunication address, such as a phone
 * number, fax, email or http address.
 *
 * <p>There are several parts to an tel address, but HL7 has dumped all the relevant 
 * information into a single text field. Urp.
 * 
 * <p>The first part is the URL scheme. This is something like tel: or http:. CeRx limits 
 * these based on the subclass of TEL (TEL.PHONEMAIL or TEL.URI).
 * 
 * <p>There are some number of uses for each address. CeRx limits this to three, which is
 * not enforced by this class. For the TEL.URI subclass, use is not permitted at all.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class TelecommunicationAddress implements Serializable {
	
	private static final long serialVersionUID = 369059637226025872L;
	private static final String SEPARATOR = ":";
	private static final String SLASHES = "//";
	
	private static final List<String> URL_SCHEMES_REQUIRING_SLASHES = new ArrayList<String>();
	static {
		URL_SCHEMES_REQUIRING_SLASHES.add("file");
		URL_SCHEMES_REQUIRING_SLASHES.add("ftp");
		URL_SCHEMES_REQUIRING_SLASHES.add("http");
		URL_SCHEMES_REQUIRING_SLASHES.add("https");
//		URL_SCHEMES_REQUIRING_SLASHES.add("mailto");
		URL_SCHEMES_REQUIRING_SLASHES.add("nfs");
	}
	
	// add an ordering to the usage list for predictable ordering
	private Set<TelecommunicationAddressUse> addressUses = new TreeSet<TelecommunicationAddressUse>(new AdressUsesComparator());
	private URLScheme urlScheme;
	private String address;
	// added for R2 usage only
	private Map<Date, SetOperator> useablePeriods = new LinkedHashMap<Date, SetOperator>();
	
	/**
	 * <p>Constructs an empty telecom address.
	 * 
	 */
	public TelecommunicationAddress() {
	}
	
	/**
	 * <p>Constructs a telecom address with a given scheme, address, and uses.
	 * 
	 * @param scheme the url scheme for the telecom address (ftp, fax, etc.)
	 * @param address the actual "address" (phone number, etc) of the telecom address
	 * @param uses which uses are applicable to the given telecom address
	 */
	public TelecommunicationAddress(URLScheme scheme, String address, TelecommunicationAddressUse... uses) {
		this.urlScheme = scheme;
		this.address = address;
		this.addressUses.addAll(Arrays.asList(uses));
	}
	
	/**
	 * <p>Adds an address usage to a telecom address.
	 * 
	 * @param addressUse an address usage
	 */
	public void addAddressUse(TelecommunicationAddressUse addressUse) {
		if(addressUse != null){
			this.addressUses.add(addressUse);
		}
	}
	
	/**
	 * <p>Returns all address uses for this telecom address.
	 * 
	 * @return all address uses
	 */
	public Set<TelecommunicationAddressUse> getAddressUses() {
		return this.addressUses;
	}

	/**
	 * <p>Sets a url scheme on the telecom address.
	 * 
	 * @param urlScheme a url scheme
	 */
	public void setUrlScheme(URLScheme urlScheme) {
		this.urlScheme = urlScheme;
	}
	
	/**
	 * <p>Returns the telecom address usrl scheme.
	 * 
	 * @return the url scheme
	 */
	public URLScheme getUrlScheme() {
		return this.urlScheme;
	}
	
	/**
	 * <p>Returns the actual address (phone number, etc) of this telecom address.
	 * 
	 * @return the address of this telecom address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * <p>Sets the address.
	 * 
	 * @param address the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Useable periods or the given telecom address. The periods will be sorted internally. 
	 * 
	 * @return the useable periods
	 */
	public Map<Date, SetOperator> getUseablePeriods() {
		return useablePeriods;
	}
	
	/**
	 * Convenience method for adding a period and inclusive operator.
	 * 
	 * @param periodInTime
	 * @param operator specifies the operation to perform
	 * @return whether the added period replaced an existing period 
	 */
	public boolean addUseablePeriod(Date periodInTime, SetOperator operator) {
		// leave it up to the user to worry about a given time replacing an existing one
		return this.useablePeriods.put(periodInTime, operator == null ? SetOperator.INCLUDE : operator) != null;
	}

	/**
	 * <p>Formats the telecom address into a string.
	 * 
	 * @return the formatted telecom address
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (this.urlScheme != null) {
			buffer.append(urlScheme.getCodeValue());
			buffer.append(SEPARATOR);
			if (URL_SCHEMES_REQUIRING_SLASHES.contains(this.urlScheme.getCodeValue())) {
				buffer.append(SLASHES);
			}
		}
		if (this.address != null) {
			buffer.append(this.address);
		}
		return buffer.toString();
	}
	
	static class AdressUsesComparator implements Comparator<TelecommunicationAddressUse> {
		public int compare(TelecommunicationAddressUse address1, TelecommunicationAddressUse address2) {
			return address1.getCodeValue().compareTo(address2.getCodeValue());
		}
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.address)
		        .append(this.addressUses)
		        .append(this.urlScheme)
		        .append(this.useablePeriods)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((TelecommunicationAddress) obj);
        }
    }
    
    private boolean equals(TelecommunicationAddress that) {
        return new EqualsBuilder()
                .append(this.address, that.address)
                .append(this.addressUses, that.addressUses)
                .append(this.urlScheme, that.urlScheme)
		        .append(this.useablePeriods, that.useablePeriods)
                .isEquals();
    }
	
}
