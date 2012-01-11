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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({"MCCI_MT002100CA.Receiver", "MCCI_MT002300CA.Receiver", "MCCI_MT000100CA.Receiver", "MCCI_MT102001CA.Receiver", "MCCI_MT000300CA.Receiver"})
public class Receiver extends MessagePartBean implements Serializable {

	private static final long serialVersionUID = -1571165043033330892L;
	
	@Hl7BusinessName("receiverApplicationIdentifier")
	private II deviceId = new IIImpl();
	@Hl7BusinessName("receiverApplicationName")
	private ST deviceName = new STImpl();
	@Hl7BusinessName("receiverNetworkAddress")
	private TEL telecommunicationAddress = new TELImpl();
	@Hl7BusinessName("receiverOrganizationIdentifier")
    private II receiverOrganizationIdentifier = new IIImpl();
	
	@Hl7XmlMapping("device/id")
	public Identifier getDeviceId() {
		return this.deviceId.getValue();
	}
	public void setDeviceId(Identifier deviceId) {
		this.deviceId.setValue(deviceId);
	}
	@Hl7XmlMapping("device/name")
	public String getDeviceName() {
		return this.deviceName.getValue();
	}
	public void setDeviceName(String deviceName) {
		this.deviceName.setValue(deviceName);
	}
	@Hl7XmlMapping("telecom")
	public TelecommunicationAddress getTelecommunicationAddress() {
		return this.telecommunicationAddress.getValue();
	}
	public void setTelecommunicationAddress(TelecommunicationAddress telecommunicationAddress) {
		this.telecommunicationAddress.setValue(telecommunicationAddress);
	}
    /**
     * <p>JK:Receiver Organization Identifier 
     * 
     * <p>Receiver organization. 
     * 
     * <p>The identifier of the receiver organization. This is the 
     * only non-structural attribute in this class and is therefore 
     * mandatory. Receiver organization is optional (as the scoper 
     * association from the receiver application is optional). 
     */
    @Hl7XmlMapping("device/agent/agentOrganization/id")
	public Identifier getReceiverOrganizationIdentifier() {
		return this.receiverOrganizationIdentifier.getValue();
	}
	public void setReceiverOrganizationIdentifier(Identifier receiverOrganizationIdentifier) {
		this.receiverOrganizationIdentifier.setValue(receiverOrganizationIdentifier);
	}
	
}
