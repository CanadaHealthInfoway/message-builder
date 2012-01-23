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
import java.util.Set;



/**
 * <p>ErrorsOrWarnings</p>
 * 
 * <p>MCCI_MT000300CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p><p>An error, warning or information message associated 
 * with the message being acknowledged.</p></p>
 * 
 * <p><p>Allows identification issues related to the parsing 
 * and low-level processing of the message.</p></p>
 * 
 * <p>MCCI_MT002200CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p><p>An error, warning or information message associated 
 * with the message being acknowledged.</p></p>
 * 
 * <p><p>Allows identification issues related to the parsing 
 * and low-level processing of the message.</p></p>
 * 
 * <p>MCCI_MT002300CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p><p>An error, warning or information message associated 
 * with the message being acknowledged.</p></p>
 * 
 * <p><p>Allows identification issues related to the parsing 
 * and low-level processing of the message.</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT000300CA.AcknowledgementDetail","MCCI_MT002200CA.AcknowledgementDetail","MCCI_MT002300CA.AcknowledgementDetail"})
public class ErrorsOrWarningsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private CS typeCode = new CSImpl();
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private SET<ST, String> location = new SETImpl<ST, String>(STImpl.class);


    /**
     * <p>MessageType</p>
     * 
     * <p>Message type</p>
     * 
     * <p><p>Distinguishes between errors, warnings and information 
     * messages.</p></p>
     * 
     * <p><p>Different types of messages have substantially 
     * different ramifications.</p></p>
     * 
     * <p>Message type</p>
     * 
     * <p><p>Distinguishes between errors, warnings and information 
     * messages.</p></p>
     * 
     * <p><p>Different types of messages have substantially 
     * different ramifications.</p></p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementDetailType getTypeCode() {
        return (AcknowledgementDetailType) this.typeCode.getValue();
    }
    public void setTypeCode(AcknowledgementDetailType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>ResponseCode</p>
     * 
     * <p>A:Response Code</p>
     * 
     * <p><p>Indicates the specific issue represented by this 
     * message.</p></p>
     * 
     * <p><p>By providing coded identification of issues and 
     * errors, allows applications to have logic that manages 
     * particular errors and warnings automatically. However in 
     * some circumstances, a code may not be available. Therefore 
     * the attribute is marked as 'populated'.</p><p>The coding 
     * strength is CWE (coded with extensions). The use of local 
     * codes is only permitted when those codes are submitted to 
     * the SC for consideration and if the SC makes a 
     * recommendation other then adoption of the local code, 
     * jurisdictions are bound to adopt the recommendation.</p></p>
     * 
     * <p><p>By providing coded identification of issues and 
     * errors, allows applications to have logic that manages 
     * particular errors and warnings automatically. However in 
     * some circumstances, a code may not be available. Therefore 
     * the attribute is marked as 'populated'.</p><p>The coding 
     * strength is CWE (coded with extensions). The use of local 
     * codes is only permitted when those codes are submitted to 
     * the SC for consideration and if the SC makes a 
     * recommendation other then adoption of the local code, 
     * jurisdictions are bound to adopt the recommendation.</p></p>
     * 
     * <p>A:Response Code</p>
     * 
     * <p><p>Indicates the specific issue represented by this 
     * message.</p></p>
     * 
     * <p><p>By providing coded identification of issues and 
     * errors, allows applications to have logic that manages 
     * particular errors and warnings automatically. However in 
     * some circumstances, a code may not be available. Therefore 
     * the attribute is marked as 'populated'.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public AcknowledgementDetailCode getCode() {
        return (AcknowledgementDetailCode) this.code.getValue();
    }
    public void setCode(AcknowledgementDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>MessageDescription</p>
     * 
     * <p>C:Message Description</p>
     * 
     * <p><p>The human-readable description of the error, warning 
     * or information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p></p>
     * 
     * <p><p>Allows supplementing the 'computer' information for 
     * human-readability.</p></p>
     * 
     * <p>C:Message Description</p>
     * 
     * <p><p>The human-readable description of the error, warning 
     * or information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p></p>
     * 
     * <p><p>Allows supplementing the 'computer' information for 
     * human-readability.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>ReferencedMessageLocations</p>
     * 
     * <p>B:Referenced Message Locations</p>
     * 
     * <p><p>Indicates the location of the elements within the 
     * message instance that triggered this error, warning or 
     * information message.</p></p>
     * 
     * <p><p>Allows syntax and other messages to be linked to 
     * particular fields within the message.</p></p>
     * 
     * <p><p>I.e. only the default 'child' axis is permitted, 
     * occurrence numbers are always specified, and no other 
     * predicates are permitted.</p></p>
     * 
     * <p>B:Referenced Message Locations</p>
     * 
     * <p><p>Indicates the location of the elements within the 
     * message instance that triggered this error, warning or 
     * information message.</p></p>
     * 
     * <p><p>Allows syntax and other messages to be linked to 
     * particular fields within the message.</p></p>
     * 
     * <p><p>I.e. only the default 'child' axis is permitted, 
     * occurrence numbers are always specified, and no other 
     * predicates are permitted.</p></p>
     */
    @Hl7XmlMapping({"location"})
    public Set<String> getLocation() {
        return this.location.rawSet();
    }

}
