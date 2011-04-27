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

package ca.infoway.messagebuilder.devtools;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class SenderValueHolder {

    private TelecommunicationAddress sendingNetworkAddress;
    private Identifier sendingApplicationIdentifier;
    private String sendingApplicationName;
    private String sendingApplicationConfigurationInformation;
    private Interval<Date> sendingApplicationVersionDate;
    private String sendingSoftwareVersionNumber;
    private String sendingApplicationSoftwareName;
    private Identifier sendingOrganizationIdentifier;
    
	public TelecommunicationAddress getSendingNetworkAddress() {
		return this.sendingNetworkAddress;
	}
	public void setSendingNetworkAddress(TelecommunicationAddress sendingNetworkAddress) {
		this.sendingNetworkAddress = sendingNetworkAddress;
	}
	public Identifier getSendingApplicationIdentifier() {
		return this.sendingApplicationIdentifier;
	}
	public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
		this.sendingApplicationIdentifier = sendingApplicationIdentifier;
	}
	public String getSendingApplicationName() {
		return this.sendingApplicationName;
	}
	public void setSendingApplicationName(String sendingApplicationName) {
		this.sendingApplicationName = sendingApplicationName;
	}
	public String getSendingApplicationConfigurationInformation() {
		return this.sendingApplicationConfigurationInformation;
	}
	public void setSendingApplicationConfigurationInformation(
			String sendingApplicationConfigurationInformation) {
		this.sendingApplicationConfigurationInformation = sendingApplicationConfigurationInformation;
	}
	public Interval<Date> getSendingApplicationVersionDate() {
		return this.sendingApplicationVersionDate;
	}
	public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
		this.sendingApplicationVersionDate = sendingApplicationVersionDate;
	}
	public String getSendingSoftwareVersionNumber() {
		return this.sendingSoftwareVersionNumber;
	}
	public void setSendingSoftwareVersionNumber(String sendingSoftwareVersionNumber) {
		this.sendingSoftwareVersionNumber = sendingSoftwareVersionNumber;
	}
	public String getSendingApplicationSoftwareName() {
		return this.sendingApplicationSoftwareName;
	}
	public void setSendingApplicationSoftwareName(String sendingApplicationSoftwareName) {
		this.sendingApplicationSoftwareName = sendingApplicationSoftwareName;
	}
	public Identifier getSendingOrganizationIdentifier() {
		return this.sendingOrganizationIdentifier;
	}
	public void setSendingOrganizationIdentifier(Identifier sendingOrganizationIdentifier) {
		this.sendingOrganizationIdentifier = sendingOrganizationIdentifier;
	}
	
	
}
