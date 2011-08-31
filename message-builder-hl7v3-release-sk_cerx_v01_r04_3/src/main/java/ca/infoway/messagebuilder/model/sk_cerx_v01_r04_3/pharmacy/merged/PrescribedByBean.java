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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;



@Hl7PartTypeMapping({"PORX_MT060040CA.Author4","PORX_MT060160CA.Author4","PORX_MT060340CA.Author4"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS prescribedDate = new TSImpl();
    private CV prescriptionTransmissionMethod = new CVImpl();
    private ED<String> signature = new EDImpl<String>();
    private ProviderBean assignedPerson;


    /**
     * <p>PrescribedDate</p>
     * 
     * <p>Prescribed Date</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getPrescribedDate() {
        return this.prescribedDate.getValue();
    }
    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate.setValue(prescribedDate);
    }


    /**
     * <p>PrescriptionTransmissionMethod</p>
     * 
     * <p>Prescription Transmission Method</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getPrescriptionTransmissionMethod() {
        return (ParticipationMode) this.prescriptionTransmissionMethod.getValue();
    }
    public void setPrescriptionTransmissionMethod(ParticipationMode prescriptionTransmissionMethod) {
        this.prescriptionTransmissionMethod.setValue(prescriptionTransmissionMethod);
    }


    /**
     * <p>Signature</p>
     * 
     * <p>Signature</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignature() {
        return this.signature.getValue();
    }
    public void setSignature(String signature) {
        this.signature.setValue(signature);
    }


    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

}
