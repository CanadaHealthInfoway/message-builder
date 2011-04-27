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

package ca.infoway.messagebuilder.marshalling.hl7;

import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;

public class CeRxDomainTestValues {
	
	public static class URLSchemeImpl implements URLScheme {
		private final String codeValue;

		public URLSchemeImpl(String codeValue) {
			this.codeValue = codeValue;
		}
		public String getCodeValue() {
			return codeValue;
		}
		public String getCodeSystem() {
			return "";
		}
	}

	public static class TelecommunicationUsageTypeImpl implements TelecommunicationAddressUse {
		private final String codeValue;
		
		public TelecommunicationUsageTypeImpl(String codeValue) {
			this.codeValue = codeValue;
		}
		public String getCodeValue() {
			return codeValue;
		}
		public String getCodeSystem() {
			return "";
		}
	}
	
	public static class UnitImpl implements UnitsOfMeasureCaseSensitive {
		private final String codeValue;
		
		public UnitImpl(String codeValue) {
			this.codeValue = codeValue;
		}
		public String getCodeValue() {
			return codeValue;
		}
		public String getCodeSystem() {
			return "";
		}
	}
	
	public static final URLScheme TELEPHONE = new URLSchemeImpl("tel");
	public static final URLScheme FAX = new URLSchemeImpl("fax");
	public static final URLScheme MAILTO = new URLSchemeImpl("mailto");
	public static final URLScheme FILE = new URLSchemeImpl("file");
	public static final URLScheme FTP = new URLSchemeImpl("ftp");
	public static final URLScheme HTTP = new URLSchemeImpl("http");
	public static final URLScheme HTTPS = new URLSchemeImpl("https");
	public static final URLScheme MLLP = new URLSchemeImpl("mllp");
	public static final URLScheme MODEM = new URLSchemeImpl("modem");
	public static final URLScheme TELNET = new URLSchemeImpl("telnet");
	public static final URLScheme NFS = new URLSchemeImpl("nfs");
	
	public static final TelecommunicationAddressUse HOME_ADDRESS = new TelecommunicationUsageTypeImpl("H");
	public static final TelecommunicationAddressUse WORK_PLACE = new TelecommunicationUsageTypeImpl("WP");
	public static final TelecommunicationAddressUse TEMPORARY_ADDRESS = new TelecommunicationUsageTypeImpl("TMP");
	public static final TelecommunicationAddressUse PAGER = new TelecommunicationUsageTypeImpl("PG");
	public static final TelecommunicationAddressUse MOBILE_CONTACT = new TelecommunicationUsageTypeImpl("MC");
	public static final TelecommunicationAddressUse EMERGENCY_CONTACT = new TelecommunicationUsageTypeImpl("EC");
	public static final TelecommunicationAddressUse VACATION_HOME = new TelecommunicationUsageTypeImpl("HV");
	public static final TelecommunicationAddressUse PUBLIC = new TelecommunicationUsageTypeImpl("PUB");
	public static final TelecommunicationAddressUse PRIMARY_HOME = new TelecommunicationUsageTypeImpl("HP");
	public static final TelecommunicationAddressUse DIRECT = new TelecommunicationUsageTypeImpl("DIR");
	public static final TelecommunicationAddressUse BAD_ADDRESS = new TelecommunicationUsageTypeImpl("BAD");
	public static final TelecommunicationAddressUse ANSWERING_SERVICE = new TelecommunicationUsageTypeImpl("AS");
	
	public static UnitsOfMeasureCaseSensitive CENTIMETRE = new UnitImpl("cm");
	public static UnitsOfMeasureCaseSensitive ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE = new UnitImpl("U/l");
	public static UnitsOfMeasureCaseSensitive FLUID_OUNCE = new UnitImpl("[foz_br]");
	public static UnitsOfMeasureCaseSensitive KILOGRAM = new UnitImpl("kg");
    public static UnitsOfMeasureCaseSensitive MILLIMETER = new UnitImpl("mm");
	public static UnitsOfMeasureCaseSensitive MILLIGRAM = new UnitImpl("mg");
}
