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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged;

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
 * <p>Business Name: ErrorsOrWarnings</p>
 * 
 * <p>MCCI_MT000200CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p>An error, warning or information message associated with 
 * the message being acknowledged.</p>
 * 
 * <p>Allows identification issues related to the parsing and 
 * low-level processing of the message.</p>
 * 
 * <p>MCCI_MT000300CA.AcknowledgementDetail: Errors or Warnings</p>
 * 
 * <p>An error, warning or information message associated with 
 * the message being acknowledged.</p>
 * 
 * <p>Allows identification issues related to the parsing and 
 * low-level processing of the message.</p>
 */
@Hl7PartTypeMapping({"MCCI_MT000200CA.AcknowledgementDetail","MCCI_MT000300CA.AcknowledgementDetail"})
public class ErrorsOrWarningsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS typeCode = new CSImpl();
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private SET<ST, String> location = new SETImpl<ST, String>(STImpl.class);


    /**
     * <p>Business Name: MessageType</p>
     * 
     * <p>Other Business Name: MessageType</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000200CA.AcknowledgementDetail.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between errors, warnings and information 
     * messages.</p>
     * 
     * <p>Different types of messages have substantially different 
     * ramifications. As a result, the element is mandatory.</p>
     * 
     * <p>Other Business Name: MessageType</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000300CA.AcknowledgementDetail.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between errors, warnings and information 
     * messages.</p>
     * 
     * <p>Different types of messages have substantially different 
     * ramifications.</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementDetailType getTypeCode() {
        return (AcknowledgementDetailType) this.typeCode.getValue();
    }

    /**
     * <p>Business Name: MessageType</p>
     * 
     * <p>Other Business Name: MessageType</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000200CA.AcknowledgementDetail.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between errors, warnings and information 
     * messages.</p>
     * 
     * <p>Different types of messages have substantially different 
     * ramifications. As a result, the element is mandatory.</p>
     * 
     * <p>Other Business Name: MessageType</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000300CA.AcknowledgementDetail.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between errors, warnings and information 
     * messages.</p>
     * 
     * <p>Different types of messages have substantially different 
     * ramifications.</p>
     */
    public void setTypeCode(AcknowledgementDetailType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Business Name: ResponseCode</p>
     * 
     * <p>Other Business Name: ResponseCode</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.AcknowledgementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the specific issue represented by this 
     * message.</p>
     * 
     * <p>By providing coded identification of issues and errors, 
     * allows applications to have logic that manages particular 
     * errors and warnings automatically. However in some 
     * circumstances, a code may not be available. Therefore the 
     * attribute is marked as 'populated'.</p>
     * 
     * <p>Other Business Name: ResponseCode</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.AcknowledgementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the specific issue represented by this 
     * message.</p>
     * 
     * <p>By providing coded identification of issues and errors, 
     * allows applications to have logic that manages particular 
     * errors and warnings automatically. However in some 
     * circumstances, a code may not be available. Therefore the 
     * attribute is marked as 'populated'.</p>
     */
    @Hl7XmlMapping({"code"})
    public AcknowledgementDetailCode getCode() {
        return (AcknowledgementDetailCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ResponseCode</p>
     * 
     * <p>Other Business Name: ResponseCode</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.AcknowledgementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the specific issue represented by this 
     * message.</p>
     * 
     * <p>By providing coded identification of issues and errors, 
     * allows applications to have logic that manages particular 
     * errors and warnings automatically. However in some 
     * circumstances, a code may not be available. Therefore the 
     * attribute is marked as 'populated'.</p>
     * 
     * <p>Other Business Name: ResponseCode</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.AcknowledgementDetail.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Indicates the specific issue represented by this 
     * message.</p>
     * 
     * <p>By providing coded identification of issues and errors, 
     * allows applications to have logic that manages particular 
     * errors and warnings automatically. However in some 
     * circumstances, a code may not be available. Therefore the 
     * attribute is marked as 'populated'.</p>
     */
    public void setCode(AcknowledgementDetailCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: MessageDescription</p>
     * 
     * <p>Other Business Name: MessageDescription</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.AcknowledgementDetail.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The human-readable description of the error, warning or 
     * information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p>
     * 
     * <p>Allows supplementing the 'computer' information for 
     * human-readability.</p>
     * 
     * <p>Other Business Name: MessageDescription</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.AcknowledgementDetail.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The human-readable description of the error, warning or 
     * information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p>
     * 
     * <p>Allows supplementing the 'computer' information for 
     * human-readability.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: MessageDescription</p>
     * 
     * <p>Other Business Name: MessageDescription</p>
     * 
     * <p>Relationship: MCCI_MT000200CA.AcknowledgementDetail.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The human-readable description of the error, warning or 
     * information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p>
     * 
     * <p>Allows supplementing the 'computer' information for 
     * human-readability.</p>
     * 
     * <p>Other Business Name: MessageDescription</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.AcknowledgementDetail.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The human-readable description of the error, warning or 
     * information message. May convey additional details not 
     * present in the 'code', but is not intended to be 
     * human-processable.</p>
     * 
     * <p>Allows supplementing the 'computer' information for 
     * human-readability.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ReferencedMessageLocations</p>
     * 
     * <p>Other Business Name: ReferencedMessageLocations</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000200CA.AcknowledgementDetail.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Indicates the location of the elements within the message 
     * instance that triggered this error, warning or information 
     * message.</p>
     * 
     * <p>Allows syntax and other messages to be linked to 
     * particular fields within the message.</p>
     * 
     * <p>I.e. only the default 'child' axis is permitted, 
     * occurrence numbers are always specified, and no other 
     * predicates are permitted.</p>
     * 
     * <p>Other Business Name: ReferencedMessageLocations</p>
     * 
     * <p>Relationship: 
     * MCCI_MT000300CA.AcknowledgementDetail.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Indicates the location of the elements within the message 
     * instance that triggered this error, warning or information 
     * message.</p>
     * 
     * <p>Allows syntax and other messages to be linked to 
     * particular fields within the message.</p>
     * 
     * <p>I.e. only the default 'child' axis is permitted, 
     * occurrence numbers are always specified, and no other 
     * predicates are permitted.</p>
     */
    @Hl7XmlMapping({"location"})
    public Set<String> getLocation() {
        return this.location.rawSet();
    }

}
