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
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
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
@Hl7PartTypeMapping({"MCCI_MT002100CA.RespondTo","MCCI_MT002200CA.RespondTo","MCCI_MT002300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TEL respondToNetworkAddress = new TELImpl();
    private II respondToApplicationIdentifier = new IIImpl();


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
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getRespondToNetworkAddress() {
        return this.respondToNetworkAddress.getValue();
    }
    public void setRespondToNetworkAddress(TelecommunicationAddress respondToNetworkAddress) {
        this.respondToNetworkAddress.setValue(respondToNetworkAddress);
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
     * <p><p>soap:Header\wsa:ReplyTo\@endpointID</p></p>
     * 
     * <p><p>Allows unique identification and routing to the 
     * application to be responded to. This attribute is mandatory 
     * be cause it is the principal identifier of the application 
     * to respond to.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getRespondToApplicationIdentifier() {
        return this.respondToApplicationIdentifier.getValue();
    }
    public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
        this.respondToApplicationIdentifier.setValue(respondToApplicationIdentifier);
    }

}