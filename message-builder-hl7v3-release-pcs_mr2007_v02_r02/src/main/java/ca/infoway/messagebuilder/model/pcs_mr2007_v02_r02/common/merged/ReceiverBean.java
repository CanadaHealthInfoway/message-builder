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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

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



@Hl7PartTypeMapping({"MCCI_MT002100CA.Receiver","MCCI_MT002200CA.Receiver","MCCI_MT002300CA.Receiver","MCCI_MT102001CA.Receiver"})
public class ReceiverBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private ST deviceName = new STImpl();
    private II deviceAgentAgentOrganizationId = new IIImpl();


    /**
     * <p>ReceiverNetworkAddress</p>
     * 
     * <p>JB:Receiver Network Address</p>
     * 
     * <p><p>The address to which this message is being sent.</p></p>
     * 
     * <p><p>soap:Header\wsa:To</p></p>
     * 
     * <p><p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses. It is mandatory when communicating using 
     * SOAP.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>ReceiverApplicationIdentifier</p>
     * 
     * <p>JA:Receiver Application Identifier</p>
     * 
     * <p><p>The unique identifier of the application to which the 
     * message is being sent.</p></p>
     * 
     * <p><p>soap:Header\wsa:To\@endpointID</p></p>
     * 
     * <p><p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
    }


    /**
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p><p>Optional name of receiver application</p></p>
     * 
     * <p>JE:Receiver Application Name</p>
     * 
     * <p><p>Optional name of receiver application.</p></p>
     * 
     * <p><p>Optional application name.</p></p>
     * 
     * <p>JE:Receiving Application Name</p>
     * 
     * <p><p>Name of the receiving application.</p></p>
     * 
     * <p><p>Optional name of the receiving application.</p></p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    /**
     * <p>ReceiverOrganizationIdentifier</p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Name of receiver application.</p></p>
     * 
     * <p><p>Identifier is the only non-structure attribute in this 
     * class and is therefore mandatory. The agent association from 
     * the receiver device (application) to the agent role is 
     * optional.</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Organization intended to receive this message</p></p>
     * 
     * <p><p>Id is the only attribute in this class which is 
     * non-structural and is therefore mandatory. The agent 
     * association (from the receiver device) is optional.</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Receiver organization.</p></p>
     * 
     * <p><p>The identifier of the receiver organization. This is 
     * the only non-structural attribute in this class and is 
     * therefore mandatory. Receiver organization is optional (as 
     * the scoper association from the receiver application is 
     * optional).</p></p>
     * 
     * <p>JK:Receiver Organization Identifier</p>
     * 
     * <p><p>Unique identifier for the receiver organization.</p></p>
     * 
     * <p><p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * receiver device to agent is optional.</p></p>
     */
    @Hl7XmlMapping({"device/agent/agentOrganization/id"})
    public Identifier getDeviceAgentAgentOrganizationId() {
        return this.deviceAgentAgentOrganizationId.getValue();
    }
    public void setDeviceAgentAgentOrganizationId(Identifier deviceAgentAgentOrganizationId) {
        this.deviceAgentAgentOrganizationId.setValue(deviceAgentAgentOrganizationId);
    }

}
