/**
 * Copyright 2013 Canada Health, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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



@Hl7PartTypeMapping({"MCCI_MT002100CA.Sender","MCCI_MT002200CA.Sender","MCCI_MT002300CA.Sender","MCCI_MT102001CA.Sender"})
public class SenderBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private ST deviceName = new STImpl();
    private ST deviceDesc = new STImpl();
    private IVL<TS, Interval<Date>> deviceExistenceTime = new IVLImpl<TS, Interval<Date>>();
    private ST deviceManufacturerModelName = new STImpl();
    private ST deviceSoftwareName = new STImpl();
    private II deviceAgentAgentOrganizationId = new IIImpl();


    /**
     * <p>Business Name: SendingNetworkAddress</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Business Name: SendingNetworkAddress</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Sender.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>soap:Header\wsa:From</p>
     * 
     * <p>May be important for sender validation. Usually also the 
     * address to which responses are sent. This is optional 
     * because not all environments require network addresses. It 
     * is mandatory when communicating using SOAP.</p>
     * 
     * <p>The network address of the application which sent the 
     * message.</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * has originated, this attribute is mandatory in order to 
     * support efficient logging, auditing and debugging 
     * requirements.</p>
     * 
     * <p>The unique identifier of the application or system from 
     * which the message has originated.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * has originated, this attribute is mandatory in order to 
     * support efficient logging, auditing and debugging 
     * requirements.</p>
     * 
     * <p>The unique identifier of the application or system from 
     * which the message has originated.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:From\@endpointID</p>
     * 
     * <p>Because this is the key identifier of where the message 
     * is intended to go, this attribute is mandatory.</p>
     * 
     * <p>The unique identifier of the application or system to 
     * whom the message is being routed.</p>
     */
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
    }


    /**
     * <p>Business Name: SendingApplicationName</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getDeviceName() {
        return this.deviceName.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationName</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides useful information when debugging.</p>
     * 
     * <p>This is the name associated with the system or 
     * application sending the message.</p>
     */
    public void setDeviceName(String deviceName) {
        this.deviceName.setValue(deviceName);
    }


    /**
     * <p>Business Name: SendingApplicationConfigurationInformation</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     */
    @Hl7XmlMapping({"device/desc"})
    public String getDeviceDesc() {
        return this.deviceDesc.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationConfigurationInformation</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     * 
     * <p>Un-merged Business Name: 
     * SendingApplicationConfigurationInformation</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides additional information that may assist in 
     * debugging interactions.</p>
     * 
     * <p>Provides additional information about the configuration 
     * of the sending application. Useful when debugging.</p>
     */
    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc.setValue(deviceDesc);
    }


    /**
     * <p>Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     */
    @Hl7XmlMapping({"device/existenceTime"})
    public Interval<Date> getDeviceExistenceTime() {
        return this.deviceExistenceTime.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationVersionDate</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.existenceTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can help to isolate the source of a problem when 
     * debugging.</p>
     * 
     * <p>Indicates the last time the sending application was 
     * modified or reconfigured.</p>
     */
    public void setDeviceExistenceTime(Interval<Date> deviceExistenceTime) {
        this.deviceExistenceTime.setValue(deviceExistenceTime);
    }


    /**
     * <p>Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT102001CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002100CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     */
    @Hl7XmlMapping({"device/manufacturerModelName"})
    public String getDeviceManufacturerModelName() {
        return this.deviceManufacturerModelName.getValue();
    }

    /**
     * <p>Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT102001CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002100CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     * 
     * <p>Un-merged Business Name: SendingSoftwareVersionNumber</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Device1.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on the compliance 
     * testing of the sending software.</p>
     * 
     * <p>Indicates the version number of the piece of software 
     * used to construct the message.</p>
     */
    public void setDeviceManufacturerModelName(String deviceManufacturerModelName) {
        this.deviceManufacturerModelName.setValue(deviceManufacturerModelName);
    }


    /**
     * <p>Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     */
    @Hl7XmlMapping({"device/softwareName"})
    public String getDeviceSoftwareName() {
        return this.deviceSoftwareName.getValue();
    }

    /**
     * <p>Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     * 
     * <p>Un-merged Business Name: SendingApplicationSoftwareName</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device1.softwareName</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be used to filter messages based on sending 
     * application compliance testing.</p>
     * 
     * <p>Indicates the name of the software used to construct the 
     * message.</p>
     */
    public void setDeviceSoftwareName(String deviceSoftwareName) {
        this.deviceSoftwareName.setValue(deviceSoftwareName);
    }


    /**
     * <p>Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier is the only non-structure attribute in this 
     * class and is therefore mandatory. The agent association from 
     * the sending device (application) to the agent role is 
     * optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     */
    @Hl7XmlMapping({"device/agent/agentOrganization/id"})
    public Identifier getDeviceAgentAgentOrganizationId() {
        return this.deviceAgentAgentOrganizationId.getValue();
    }

    /**
     * <p>Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier is the only non-structure attribute in this 
     * class and is therefore mandatory. The agent association from 
     * the sending device (application) to the agent role is 
     * optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     * 
     * <p>Un-merged Business Name: SendingOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier is the only non-structural attribute in 
     * this class and is therefore mandatory. The association from 
     * sending device to agent is optional.</p>
     * 
     * <p>Sending organization unique identifier.</p>
     */
    public void setDeviceAgentAgentOrganizationId(Identifier deviceAgentAgentOrganizationId) {
        this.deviceAgentAgentOrganizationId.setValue(deviceAgentAgentOrganizationId);
    }

}
