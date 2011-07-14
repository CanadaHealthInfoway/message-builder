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



/**
 * <p>ErrorsOrWarnings</p>
 * 
 * <p>MCCI_MT000200CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An error, 
 * warning or information message associated with the message 
 * being acknowledged.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * identification issues related to the parsing and low-level 
 * processing of the message.</p></p>
 * 
 * <p>MCCI_MT000300CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An error, 
 * warning or information message associated with the message 
 * being acknowledged.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * identification issues related to the parsing and low-level 
 * processing of the message.</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT000200CA.AcknowledgementDetail","MCCI_MT000300CA.AcknowledgementDetail"})
public class ErrorsOrWarningsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private CS messageType = new CSImpl();
    private CV responseCode = new CVImpl();
    private ST messageDescription = new STImpl();
    private SET<ST, String> referencedMessageLocations = new SETImpl<ST, String>(STImpl.class);


    /**
     * <p>MessageType</p>
     * 
     * <p>Message type</p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes 
     * between errors, warnings and information messages.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Different 
     * types of messages have substantially different 
     * ramifications.</p></p>
     * 
     * <p>Message type</p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes 
     * between errors, warnings and information messages.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Different 
     * types of messages have substantially different 
     * ramifications. As a result, the element is mandatory.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the specific issue represented by this message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">By providing 
     * coded identification of issues and errors, allows 
     * applications to have logic that manages particular errors 
     * and warnings automatically. However in some circumstances, a 
     * code may not be available. Therefore the attribute is marked 
     * as 'populated'.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * human-readable description of the error, warning or 
     * information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * supplementing the 'computer' information for 
     * human-readability.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the location of the elements within the message instance 
     * that triggered this error, warning or information 
     * message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * syntax and other messages to be linked to particular fields 
     * within the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml"></p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">I.e. only the 
     * default 'child' axis is permitted, occurrence numbers are 
     * always specified, and no other predicates are permitted.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml"></p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">I.e. only the 
     * default 'child' axis is permitted, occurrence numbers are 
     * always specified, and no other predicates are permitted.</p></p>
     */
    @Hl7XmlMapping({"location"})
    public Set<String> getReferencedMessageLocations() {
        return this.referencedMessageLocations.rawSet();
    }

}
