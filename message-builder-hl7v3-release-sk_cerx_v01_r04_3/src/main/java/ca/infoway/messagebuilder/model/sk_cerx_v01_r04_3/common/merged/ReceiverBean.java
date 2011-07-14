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
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000100CA.Receiver","MCCI_MT000200CA.Receiver","MCCI_MT000300CA.Receiver","MCCI_MT102001CA.Receiver"})
public class ReceiverBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private TEL receiverNetworkAddress = new TELImpl();
    private II receiverApplicationIdentifier = new IIImpl();
    private II receiverOrganizationIdentifier = new IIImpl();
    private II receiverFacilityIdentifier = new IIImpl();


    /**
     * <p>ReceiverNetworkAddress</p>
     * 
     * <p>JB:Receiver Network Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The address 
     * to which this message is being sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * where the message should be sent. This is optional because 
     * not all environments require network addresses.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getReceiverNetworkAddress() {
        return this.receiverNetworkAddress.getValue();
    }
    public void setReceiverNetworkAddress(TelecommunicationAddress receiverNetworkAddress) {
        this.receiverNetworkAddress.setValue(receiverNetworkAddress);
    }


    /**
     * <p>ReceiverApplicationIdentifier</p>
     * 
     * <p>JA:Receiver Application Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the application to which the message is being 
     * sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * routing and for verification that &quot;yes, this message is 
     * intended for me.&quot; This is mandatory because it is the 
     * key identifier of the receiving application.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getReceiverApplicationIdentifier() {
        return this.receiverApplicationIdentifier.getValue();
    }
    public void setReceiverApplicationIdentifier(Identifier receiverApplicationIdentifier) {
        this.receiverApplicationIdentifier.setValue(receiverApplicationIdentifier);
    }


    /**
     * <p>ReceiverOrganizationIdentifier</p>
     * 
     * <p>JC:Receiver Organization Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the organization with responsibility to act on 
     * the contents of this message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
     * when the eventual entity responsible for acting on an 
     * interaction may be reached through several routing steps. 
     * This attribute is optional because not all environments 
     * require communicating this information.</p></p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getReceiverOrganizationIdentifier() {
        return this.receiverOrganizationIdentifier.getValue();
    }
    public void setReceiverOrganizationIdentifier(Identifier receiverOrganizationIdentifier) {
        this.receiverOrganizationIdentifier.setValue(receiverOrganizationIdentifier);
    }


    /**
     * <p>ReceiverFacilityIdentifier</p>
     * 
     * <p>JD:Receiver Facility Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * the facility expected to receive the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be used 
     * to assist in routing the message. This attribute is optional 
     * because not all environments require communicating this 
     * information.</p></p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getReceiverFacilityIdentifier() {
        return this.receiverFacilityIdentifier.getValue();
    }
    public void setReceiverFacilityIdentifier(Identifier receiverFacilityIdentifier) {
        this.receiverFacilityIdentifier.setValue(receiverFacilityIdentifier);
    }

}
