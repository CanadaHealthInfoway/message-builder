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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"MCCI_MT000100CA.Sender","MCCI_MT000200CA.Sender","MCCI_MT000300CA.Sender","MCCI_MT102001CA.Sender"})
public class SenderBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private ST deviceName = new STImpl();
    private ST deviceDesc = new STImpl();
    private IVL<TS, Interval<Date>> deviceExistenceTime = new IVLImpl<TS, Interval<Date>>();
    private ST deviceManufacturerModelName = new STImpl();
    private ST deviceSoftwareName = new STImpl();
    private II deviceAsAgentRepresentedOrganizationId = new IIImpl();
    private II deviceAsLocatedEntityLocationId = new IIImpl();


    /**
     * <p>SendingNetworkAddress</p>
     * 
     * <p>IB:Sending Network Address</p>
     * 
     * <p><p>The network address of the application which sent the 
     * message.</p></p>
     * 
     * <p><p>May be important for sender validation. Usually also 
     * the address to which responses are sent. This is optional 
     * because not all environments require network addresses.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>SendingApplicationIdentifier</p>
     * 
     * <p>IA:Sending Application Identifier</p>
     * 
     * <p><p>The unique identifier of the application or system 
     * from where the message is being sent.</p></p>
     * 
     * <p><p>Because this is the key identifier of where the 
     * message is coming from, this attribute is mandatory.</p></p>
     * 
     * <p>IA:Sending Application Identifier</p>
     * 
     * <p><p>The unique identifier of the application or system to 
     * whom the message is being routed.</p></p>
     * 
     * <p><p>Because this is the key identifier of where the 
     * message is intended to go, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
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
    public String getDeviceName() {
        return this.deviceName.getValue();
    }
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
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
    public String getDeviceDesc() {
        return this.deviceDesc.getValue();
    }
    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc.setValue(deviceDesc);
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
    public Interval<Date> getDeviceExistenceTime() {
        return this.deviceExistenceTime.getValue();
    }
    public void setDeviceExistenceTime(Interval<Date> deviceExistenceTime) {
        this.deviceExistenceTime.setValue(deviceExistenceTime);
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
    public String getDeviceManufacturerModelName() {
        return this.deviceManufacturerModelName.getValue();
    }
    public void setDeviceManufacturerModelName(String deviceManufacturerModelName) {
        this.deviceManufacturerModelName.setValue(deviceManufacturerModelName);
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
    public String getDeviceSoftwareName() {
        return this.deviceSoftwareName.getValue();
    }
    public void setDeviceSoftwareName(String deviceSoftwareName) {
        this.deviceSoftwareName.setValue(deviceSoftwareName);
    }


    /**
     * <p>SendingOrganizationIdentifier</p>
     * 
     * <p>IC:Sending Organization Identifier</p>
     * 
     * <p><p>Uniquely identifies the legal entity responsible for 
     * the content of the message.</p></p>
     * 
     * <p><p>May be used for routing/filtering purposes. Also 
     * allows tracking of the original responsible party for 
     * messages which may undergo multiple routing or translation 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p></p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getDeviceAsAgentRepresentedOrganizationId() {
        return this.deviceAsAgentRepresentedOrganizationId.getValue();
    }
    public void setDeviceAsAgentRepresentedOrganizationId(Identifier deviceAsAgentRepresentedOrganizationId) {
        this.deviceAsAgentRepresentedOrganizationId.setValue(deviceAsAgentRepresentedOrganizationId);
    }


    /**
     * <p>SendingFacilityIdentifier</p>
     * 
     * <p>ICA:Sending Facility Identifier</p>
     * 
     * <p><p>The unique identifier of the hospital, clinic or other 
     * facility which constructed the message.</p></p>
     * 
     * <p><p>May be used for routing, or for configuration control. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p></p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getDeviceAsLocatedEntityLocationId() {
        return this.deviceAsLocatedEntityLocationId.getValue();
    }
    public void setDeviceAsLocatedEntityLocationId(Identifier deviceAsLocatedEntityLocationId) {
        this.deviceAsLocatedEntityLocationId.setValue(deviceAsLocatedEntityLocationId);
    }

}
