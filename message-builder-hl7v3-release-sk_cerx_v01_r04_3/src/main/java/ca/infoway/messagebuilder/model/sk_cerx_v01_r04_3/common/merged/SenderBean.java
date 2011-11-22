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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

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

    private static final long serialVersionUID = 20111121L;
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
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getDeviceAsLocatedEntityLocationId() {
        return this.deviceAsLocatedEntityLocationId.getValue();
    }
    public void setDeviceAsLocatedEntityLocationId(Identifier deviceAsLocatedEntityLocationId) {
        this.deviceAsLocatedEntityLocationId.setValue(deviceAsLocatedEntityLocationId);
    }

}
