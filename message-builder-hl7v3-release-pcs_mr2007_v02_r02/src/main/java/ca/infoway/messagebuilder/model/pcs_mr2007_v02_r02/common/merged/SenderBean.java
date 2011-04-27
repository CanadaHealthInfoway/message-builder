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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"MCCI_MT002100CA.Sender","MCCI_MT002200CA.Sender","MCCI_MT002300CA.Sender","MCCI_MT102001CA.Sender"})
public class SenderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private TEL sendingNetworkAddress = new TELImpl();
    private II sendingApplicationIdentifier = new IIImpl();
    private ST sendingApplicationName = new STImpl();
    private ST sendingApplicationConfigurationInformation = new STImpl();
    private IVL<TS, Interval<Date>> sendingApplicationVersionDate = new IVLImpl<TS, Interval<Date>>();
    private ST sendingSoftwareVersionNumber = new STImpl();
    private ST sendingApplicationSoftwareName = new STImpl();
    private II sendingOrganizationIdentifier = new IIImpl();


    /**
     * <p>SendingNetworkAddress</p>
     * 
     * <p>IB:Sending Network Address</p>
     * 
     * <p><p>The network address of the application which sent the 
     * message.</p></p>
     * 
     * <p><p>soap:Header\wsa:From</p></p>
     * 
     * <p><p>May be important for sender validation. Usually also 
     * the address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getSendingNetworkAddress() {
        return this.sendingNetworkAddress.getValue();
    }
    public void setSendingNetworkAddress(TelecommunicationAddress sendingNetworkAddress) {
        this.sendingNetworkAddress.setValue(sendingNetworkAddress);
    }


    /**
     * <p>SendingApplicationIdentifier</p>
     * 
     * <p>IA:Sending Application Identifier</p>
     * 
     * <p><p>The unique identifier of the application or system to 
     * whom the message is being routed.</p></p>
     * 
     * <p><p>soap:Header\wsa:From\@endpointID</p></p>
     * 
     * <p><p>Because this is the key identifier of where the 
     * message is intended to go, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getSendingApplicationIdentifier() {
        return this.sendingApplicationIdentifier.getValue();
    }
    public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
        this.sendingApplicationIdentifier.setValue(sendingApplicationIdentifier);
    }


    /**
     * <p>SendingApplicationName</p>
     * 
     * <p>IE:Sending Application Name</p>
     * 
     * <p><p>This is the name associated with the system or 
     * application sending the message.</p></p>
     * 
     * <p><p>Provides useful information when debugging.</p></p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getSendingApplicationName() {
        return this.sendingApplicationName.getValue();
    }
    public void setSendingApplicationName(String sendingApplicationName) {
        this.sendingApplicationName.setValue(sendingApplicationName);
    }


    /**
     * <p>SendingApplicationConfigurationInformation</p>
     * 
     * <p>II:Sending Application Configuration Information</p>
     * 
     * <p><p>Provides additional information about the 
     * configuration of the sending application. Useful when 
     * debugging.</p></p>
     * 
     * <p><p>Provides additional information that may assist in 
     * debugging interactions.</p></p>
     */
    @Hl7XmlMapping({"device/desc"})
    public String getSendingApplicationConfigurationInformation() {
        return this.sendingApplicationConfigurationInformation.getValue();
    }
    public void setSendingApplicationConfigurationInformation(String sendingApplicationConfigurationInformation) {
        this.sendingApplicationConfigurationInformation.setValue(sendingApplicationConfigurationInformation);
    }


    /**
     * <p>SendingApplicationVersionDate</p>
     * 
     * <p>IH:Sending Application Version Date</p>
     * 
     * <p><p>Indicates the last time the sending application was 
     * modified or reconfigured.</p></p>
     * 
     * <p><p>Can help to isolate the source of a problem when 
     * debugging.</p></p>
     */
    @Hl7XmlMapping({"device/existenceTime"})
    public Interval<Date> getSendingApplicationVersionDate() {
        return this.sendingApplicationVersionDate.getValue();
    }
    public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
        this.sendingApplicationVersionDate.setValue(sendingApplicationVersionDate);
    }


    /**
     * <p>SendingSoftwareVersionNumber</p>
     * 
     * <p>IG:Sending Software Version Number</p>
     * 
     * <p><p>Indicates the version number of the piece of software 
     * used to construct the message.</p></p>
     * 
     * <p><p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p></p>
     */
    @Hl7XmlMapping({"device/manufacturerModelName"})
    public String getSendingSoftwareVersionNumber() {
        return this.sendingSoftwareVersionNumber.getValue();
    }
    public void setSendingSoftwareVersionNumber(String sendingSoftwareVersionNumber) {
        this.sendingSoftwareVersionNumber.setValue(sendingSoftwareVersionNumber);
    }


    /**
     * <p>SendingApplicationSoftwareName</p>
     * 
     * <p>IF:Sending Application Software Name</p>
     * 
     * <p><p>Indicates the name of the software used to construct 
     * the message.</p></p>
     * 
     * <p><p>May be used to filter messages based on sending 
     * application compliance testing.</p></p>
     */
    @Hl7XmlMapping({"device/softwareName"})
    public String getSendingApplicationSoftwareName() {
        return this.sendingApplicationSoftwareName.getValue();
    }
    public void setSendingApplicationSoftwareName(String sendingApplicationSoftwareName) {
        this.sendingApplicationSoftwareName.setValue(sendingApplicationSoftwareName);
    }


    /**
     * <p>SendingOrganizationIdentifier</p>
     * 
     * <p>IK:Sending Organization Identifier</p>
     * 
     * <p><p>Sending organization unique identifier.</p></p>
     * 
     * <p><p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p></p>
     * 
     * <p>IK:Sending Organization Identifier</p>
     * 
     * <p><p>Sending organization unique identifier.</p></p>
     * 
     * <p><p>Identifier is the only non-structure attribute in this 
     * class and is therefore mandatory. The agent association from 
     * the sending device (application) to the agent role is 
     * optional.</p></p>
     */
    @Hl7XmlMapping({"device/agent/agentOrganization/id"})
    public Identifier getSendingOrganizationIdentifier() {
        return this.sendingOrganizationIdentifier.getValue();
    }
    public void setSendingOrganizationIdentifier(Identifier sendingOrganizationIdentifier) {
        this.sendingOrganizationIdentifier.setValue(sendingOrganizationIdentifier);
    }

}
