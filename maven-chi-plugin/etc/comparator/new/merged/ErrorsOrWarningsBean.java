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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"MCCI_MT002200CA.AcknowledgementDetail","MCCI_MT002300CA.AcknowledgementDetail"})
public class ErrorsOrWarningsBean extends MessagePartBean {

    private CS<AcknowledgementDetailType> messageType = new CSImpl<AcknowledgementDetailType>();
    private CV<AcknowledgementDetailCode> responseCode = new CVImpl<AcknowledgementDetailCode>();
    private ST messageDescription = new STImpl();
    private SET<ST, String> referencedMessageLocations = new SETImpl<ST, String>(STImpl.class);

    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementDetailType getMessageType() {
        return this.messageType.getValue();
    }
    public void setMessageType(AcknowledgementDetailType messageType) {
        this.messageType.setValue(messageType);
    }

    @Hl7XmlMapping({"code"})
    public AcknowledgementDetailCode getResponseCode() {
        return this.responseCode.getValue();
    }
    public void setResponseCode(AcknowledgementDetailCode responseCode) {
        this.responseCode.setValue(responseCode);
    }

    @Hl7XmlMapping({"text"})
    public java.lang.String getMessageDescription() {
        return this.messageDescription.getValue();
    }
    public void setMessageDescription(java.lang.String messageDescription) {
        this.messageDescription.setValue(messageDescription);
    }

    @Hl7XmlMapping({"location"})
    public Set<String> getReferencedMessageLocations() {
        return this.referencedMessageLocations.rawSet();
    }

}
