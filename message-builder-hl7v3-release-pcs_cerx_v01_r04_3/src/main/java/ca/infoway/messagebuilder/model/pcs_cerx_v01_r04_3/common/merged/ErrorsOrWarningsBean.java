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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000200CA.AcknowledgementDetail","MCCI_MT000300CA.AcknowledgementDetail"})
public class ErrorsOrWarningsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CS messageType = new CSImpl();
    private CV responseCode = new CVImpl();
    private ST messageDescription = new STImpl();
    private SET<ST, String> referencedMessageLocations = new SETImpl<ST, String>(STImpl.class);


    /**
     * <p>MessageType</p>
     * 
     * <p>Message type</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementDetailType getMessageType() {
        return (AcknowledgementDetailType) this.messageType.getValue();
    }
    public void setMessageType(AcknowledgementDetailType messageType) {
        this.messageType.setValue(messageType);
    }


    /**
     * <p>ResponseCode</p>
     * 
     * <p>A:Response Code</p>
     */
    @Hl7XmlMapping({"code"})
    public AcknowledgementDetailCode getResponseCode() {
        return (AcknowledgementDetailCode) this.responseCode.getValue();
    }
    public void setResponseCode(AcknowledgementDetailCode responseCode) {
        this.responseCode.setValue(responseCode);
    }


    /**
     * <p>MessageDescription</p>
     * 
     * <p>C:Message Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getMessageDescription() {
        return this.messageDescription.getValue();
    }
    public void setMessageDescription(String messageDescription) {
        this.messageDescription.setValue(messageDescription);
    }


    /**
     * <p>ReferencedMessageLocations</p>
     * 
     * <p>B:Referenced Message Locations</p>
     */
    @Hl7XmlMapping({"location"})
    public Set<String> getReferencedMessageLocations() {
        return this.referencedMessageLocations.rawSet();
    }

}
