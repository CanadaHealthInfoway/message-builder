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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT002100CA.RespondTo","MCCI_MT002200CA.RespondTo","MCCI_MT002300CA.RespondTo","MCCI_MT102001CA.RespondTo"})
public class ToBeRespondedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TEL respondToNetworkAddress = new TELImpl();
    private II respondToApplicationIdentifier = new IIImpl();


    /**
     * <p>RespondToNetworkAddress</p>
     * 
     * <p>KB:Respond to Network Address</p>
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
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getRespondToApplicationIdentifier() {
        return this.respondToApplicationIdentifier.getValue();
    }
    public void setRespondToApplicationIdentifier(Identifier respondToApplicationIdentifier) {
        this.respondToApplicationIdentifier.setValue(respondToApplicationIdentifier);
    }

}