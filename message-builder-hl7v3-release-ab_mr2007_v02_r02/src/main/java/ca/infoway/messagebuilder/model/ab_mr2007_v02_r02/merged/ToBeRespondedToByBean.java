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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
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
 * <p>ToBeRespondedToBy</p>
 * 
 * <p>MCCI_MT102001CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 * 
 * <p>MCCI_MT002300CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 * 
 * <p>MCCI_MT000100CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 * 
 * <p>MCCI_MT002200CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 * 
 * <p>MCCI_MT000300CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 * 
 * <p>MCCI_MT002100CA.RespondTo: to be responded to by</p>
 * 
 * <p><p>Indicates the interaction that should receive the 
 * response to this interaction. Used when different from the 
 * sender of the original interaction.</p></p>
 * 
 * <p><p>In complex routing environments, the acknowledgements 
 * may need to be sent to a system other than the one which 
 * constructed the original message. This association is 
 * optional because not all environments will support responses 
 * to systems other than the original sender.</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT000100CA.RespondTo","MCCI_MT000300CA.RespondTo","MCCI_MT002100CA.RespondTo","MCCI_MT002200CA.RespondTo","MCCI_MT002300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20120116L;
    private TEL telecom = new TELImpl();
    private II deviceId = new IIImpl();
    private CS typeCode = new CSImpl();
    private CS deviceClassCode = new CSImpl();
    private CS deviceDeterminerCode = new CSImpl();
    private II deviceAsAgentRepresentedOrganizationId = new IIImpl();
    private II deviceAsLocatedEntityLocationId = new IIImpl();


    /**
     * <p>RespondToNetworkAddress</p>
     * 
     * <p>KB:Respond to Network Address</p>
     * 
     * <p><p>Indicates the address to send acknowledgments of this 
     * message to.</p></p>
     * 
     * <p><p>soap:Header\wsa:ReplyTo</p></p>
     * 
     * <p><p>Needed when the address to respond to is different 
     * than that of the sender. This is optional because not all 
     * environments require network addresses. It is required when 
     * communicating using SOAP.</p></p>
     * 
     * <p>KB:Respond to Network Address</p>
     * 
     * <p><p>Indicates the address to send acknowledgments of this 
     * message to.</p></p>
     * 
     * <p><p>Needed when the address to respond to is different 
     * than that of the sender. This is optional because not all 
     * environments require network addresses.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>RespondToApplicationIdentifier</p>
     * 
     * <p>KA:Respond to Application Identifier</p>
     * 
     * <p><p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p></p>
     * 
     * <p><p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p></p>
     * 
     * <p>KA:Respond to Application Identifier</p>
     * 
     * <p><p>The unique identifier of the applications to which 
     * responses should be sent. Only populated when different from 
     * the sending application id.</p></p>
     * 
     * <p><p>soap:Header\wsa:ReplyTo\@endpointID</p></p>
     * 
     * <p><p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getDeviceId() {
        return this.deviceId.getValue();
    }
    public void setDeviceId(Identifier deviceId) {
        this.deviceId.setValue(deviceId);
    }


    @Hl7XmlMapping({"typeCode"})
    public CommunicationFunctionType getTypeCode() {
        return (CommunicationFunctionType) this.typeCode.getValue();
    }
    public void setTypeCode(CommunicationFunctionType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"device/classCode"})
    public EntityClass getDeviceClassCode() {
        return (EntityClass) this.deviceClassCode.getValue();
    }
    public void setDeviceClassCode(EntityClass deviceClassCode) {
        this.deviceClassCode.setValue(deviceClassCode);
    }


    @Hl7XmlMapping({"device/determinerCode"})
    public EntityDeterminer getDeviceDeterminerCode() {
        return (EntityDeterminer) this.deviceDeterminerCode.getValue();
    }
    public void setDeviceDeterminerCode(EntityDeterminer deviceDeterminerCode) {
        this.deviceDeterminerCode.setValue(deviceDeterminerCode);
    }


    /**
     * <p>RespondToOrganizationId</p>
     * 
     * <p>KC:Respond to Organization Id</p>
     * 
     * <p><p>The unique identifier of the application who is to be 
     * responsible for responses to this message.</p></p>
     * 
     * <p><p>Needed for circumstances where the 'respond to' 
     * organization is different than the sending organization. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p></p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getDeviceAsAgentRepresentedOrganizationId() {
        return this.deviceAsAgentRepresentedOrganizationId.getValue();
    }
    public void setDeviceAsAgentRepresentedOrganizationId(Identifier deviceAsAgentRepresentedOrganizationId) {
        this.deviceAsAgentRepresentedOrganizationId.setValue(deviceAsAgentRepresentedOrganizationId);
    }


    /**
     * <p>RespondToFacilityId</p>
     * 
     * <p>KD:Respond to Facility Id</p>
     * 
     * <p><p>Indicates the clinic or other facility to which 
     * responses to this interaction should be sent.</p></p>
     * 
     * <p><p>May affect the routing of a message. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p></p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getDeviceAsLocatedEntityLocationId() {
        return this.deviceAsLocatedEntityLocationId.getValue();
    }
    public void setDeviceAsLocatedEntityLocationId(Identifier deviceAsLocatedEntityLocationId) {
        this.deviceAsLocatedEntityLocationId.setValue(deviceAsLocatedEntityLocationId);
    }

}
