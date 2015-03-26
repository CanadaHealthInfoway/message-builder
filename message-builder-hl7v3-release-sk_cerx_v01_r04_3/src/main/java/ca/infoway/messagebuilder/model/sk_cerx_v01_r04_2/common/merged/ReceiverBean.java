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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000100CA.Receiver","MCCI_MT000200CA.Receiver","MCCI_MT000300CA.Receiver","MCCI_MT102001CA.Receiver"})
public class ReceiverBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private II deviceAsAgentRepresentedOrganizationId = new IIImpl();
    private II deviceAsLocatedEntityLocationId = new IIImpl();


    /**
     * <p>Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p><div>Although PIN will echo this field back in the 
     * response</div> <p>if sent, it is not used by PIN.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p><div>Although PIN will echo this field back in the 
     * response</div> <p>if sent, it is not used by PIN.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     * 
     * <p>Un-merged Business Name: ReceiverNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Receiver.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The address to which this message is being sent.</p>
     * 
     * <p>Indicates where the message should be sent. This is 
     * optional because not all environments require network 
     * addresses.</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p><div>Fixed to jurisdiction-specific Application 
     * Identifier</div> <p>for PIN.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }

    /**
     * <p>Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p><div>Fixed to jurisdiction-specific Application 
     * Identifier</div> <p>for PIN.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     * 
     * <p>Un-merged Business Name: ReceiverApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Device2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application to which the 
     * message is being sent.</p>
     * 
     * <p>Used for routing and for verification that &quot;yes, 
     * this message is intended for me.&quot; This is mandatory 
     * because it is the key identifier of the receiving 
     * application.</p>
     */
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
    }


    /**
     * <p>Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getDeviceAsAgentRepresentedOrganizationId() {
        return this.deviceAsAgentRepresentedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverOrganizationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Organization2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the organization with 
     * responsibility to act on the contents of this message.</p>
     * 
     * <p>Important when the eventual entity responsible for acting 
     * on an interaction may be reached through several routing 
     * steps. This attribute is optional because not all 
     * environments require communicating this information.</p>
     */
    public void setDeviceAsAgentRepresentedOrganizationId(Identifier deviceAsAgentRepresentedOrganizationId) {
        this.deviceAsAgentRepresentedOrganizationId.setValue(deviceAsAgentRepresentedOrganizationId);
    }


    /**
     * <p>Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getDeviceAsLocatedEntityLocationId() {
        return this.deviceAsLocatedEntityLocationId.getValue();
    }

    /**
     * <p>Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     * 
     * <p>Un-merged Business Name: ReceiverFacilityIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Place2.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the facility expected to receive the 
     * message.</p>
     * 
     * <p>May be used to assist in routing the message. This 
     * attribute is optional because not all environments require 
     * communicating this information.</p>
     */
    public void setDeviceAsLocatedEntityLocationId(Identifier deviceAsLocatedEntityLocationId) {
        this.deviceAsLocatedEntityLocationId.setValue(deviceAsLocatedEntityLocationId);
    }

}
