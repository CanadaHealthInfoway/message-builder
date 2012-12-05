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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.CommunicationFunctionType;
import ca.infoway.messagebuilder.domainvalue.EntityClass;
import ca.infoway.messagebuilder.domainvalue.EntityDeterminer;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ToBeRespondedToBy</p>
 * 
 * <p>MCCI_MT102001CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 * 
 * <p>MCCI_MT002300CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 * 
 * <p>MCCI_MT000100CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 * 
 * <p>MCCI_MT002200CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 * 
 * <p>MCCI_MT000300CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 * 
 * <p>MCCI_MT002100CA.RespondTo: to be responded to by</p>
 * 
 * <p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p>
 * 
 * <p>In complex routing environments, the acknowledgements may 
 * need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p>
 */
@Hl7PartTypeMapping({"MCCI_MT000100CA.RespondTo","MCCI_MT000300CA.RespondTo","MCCI_MT002100CA.RespondTo","MCCI_MT002200CA.RespondTo","MCCI_MT002300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private CS typeCode = new CSImpl();
    private CS deviceClassCode = new CSImpl();
    private CS deviceDeterminerCode = new CSImpl();
    private II deviceAsAgentRepresentedOrganizationId = new IIImpl();
    private II deviceAsLocatedEntityLocationId = new IIImpl();


    /**
     * <p>Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses.</p>
     * 
     * <p>Other Business Name: RespondToNetworkAddress</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.RespondTo.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates the address to send acknowledgments of this 
     * message to.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo</p>
     * 
     * <p>Needed when the address to respond to is different than 
     * that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }

    /**
     * <p>Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT102001CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     * 
     * <p>Other Business Name: RespondToApplicationIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Device3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p>
     * 
     * <p>soap:Header\wsa:ReplyTo\@endpointID</p>
     * 
     * <p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p>
     */
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.RespondTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public CommunicationFunctionType getTypeCode() {
        return (CommunicationFunctionType) this.typeCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.RespondTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(CommunicationFunctionType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"device/classCode"})
    public EntityClass getDeviceClassCode() {
        return (EntityClass) this.deviceClassCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeviceClassCode(EntityClass deviceClassCode) {
        this.deviceClassCode.setValue(deviceClassCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"device/determinerCode"})
    public EntityDeterminer getDeviceDeterminerCode() {
        return (EntityDeterminer) this.deviceDeterminerCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Device3.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeviceDeterminerCode(EntityDeterminer deviceDeterminerCode) {
        this.deviceDeterminerCode.setValue(deviceDeterminerCode);
    }


    /**
     * <p>Business Name: RespondToOrganizationId</p>
     * 
     * <p>Other Business Name: RespondToOrganizationId</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Organization3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application who is to be 
     * responsible for responses to this message.</p>
     * 
     * <p>Needed for circumstances where the 'respond to' 
     * organization is different than the sending organization. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p>
     * 
     * <p>Other Business Name: RespondToOrganizationId</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Organization3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application who is to be 
     * responsible for responses to this message.</p>
     * 
     * <p>Needed for circumstances where the 'respond to' 
     * organization is different than the sending organization. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getDeviceAsAgentRepresentedOrganizationId() {
        return this.deviceAsAgentRepresentedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: RespondToOrganizationId</p>
     * 
     * <p>Other Business Name: RespondToOrganizationId</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Organization3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application who is to be 
     * responsible for responses to this message.</p>
     * 
     * <p>Needed for circumstances where the 'respond to' 
     * organization is different than the sending organization. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p>
     * 
     * <p>Other Business Name: RespondToOrganizationId</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Organization3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identifier of the application who is to be 
     * responsible for responses to this message.</p>
     * 
     * <p>Needed for circumstances where the 'respond to' 
     * organization is different than the sending organization. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p>
     */
    public void setDeviceAsAgentRepresentedOrganizationId(Identifier deviceAsAgentRepresentedOrganizationId) {
        this.deviceAsAgentRepresentedOrganizationId.setValue(deviceAsAgentRepresentedOrganizationId);
    }


    /**
     * <p>Business Name: RespondToFacilityId</p>
     * 
     * <p>Other Business Name: RespondToFacilityId</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Place3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the clinic or other facility to which responses 
     * to this interaction should be sent.</p>
     * 
     * <p>May affect the routing of a message. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p>
     * 
     * <p>Other Business Name: RespondToFacilityId</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Place3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the clinic or other facility to which responses 
     * to this interaction should be sent.</p>
     * 
     * <p>May affect the routing of a message. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getDeviceAsLocatedEntityLocationId() {
        return this.deviceAsLocatedEntityLocationId.getValue();
    }

    /**
     * <p>Business Name: RespondToFacilityId</p>
     * 
     * <p>Other Business Name: RespondToFacilityId</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Place3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the clinic or other facility to which responses 
     * to this interaction should be sent.</p>
     * 
     * <p>May affect the routing of a message. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p>
     * 
     * <p>Other Business Name: RespondToFacilityId</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Place3.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the clinic or other facility to which responses 
     * to this interaction should be sent.</p>
     * 
     * <p>May affect the routing of a message. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p>
     */
    public void setDeviceAsLocatedEntityLocationId(Identifier deviceAsLocatedEntityLocationId) {
        this.deviceAsLocatedEntityLocationId.setValue(deviceAsLocatedEntityLocationId);
    }

}
