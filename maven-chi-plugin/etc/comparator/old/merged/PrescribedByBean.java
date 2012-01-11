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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT470002CA.Author2","PORX_MT020050CA.Author2","PORX_MT030040CA.Author2","PORX_MT060020CA.Author2","PORX_MT060040CA.Author4","PORX_MT060060CA.Author2","PORX_MT060100CA.Author2","PORX_MT060160CA.Author4","PORX_MT060190CA.Author2","PORX_MT060340CA.Author4","RCMR_MT010001CA.Author2"})
public class PrescribedByBean extends MessagePartBean {

    private HealthcareWorkerBean assignedEntity;
    private TS prescribedDate = new TSImpl();
    private CV<ParticipationMode> prescriptionTransmissionMethod = new CVImpl<ParticipationMode>();
    private ED<String> signature = new EDImpl<String>();

    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

    @Hl7XmlMapping({"time"})
    public Date getPrescribedDate() {
        return this.prescribedDate.getValue();
    }
    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate.setValue(prescribedDate);
    }

    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getPrescriptionTransmissionMethod() {
        return this.prescriptionTransmissionMethod.getValue();
    }
    public void setPrescriptionTransmissionMethod(ParticipationMode prescriptionTransmissionMethod) {
        this.prescriptionTransmissionMethod.setValue(prescriptionTransmissionMethod);
    }

    @Hl7XmlMapping({"signatureText"})
    public java.lang.String getSignature() {
        return this.signature.getValue();
    }
    public void setSignature(java.lang.String signature) {
        this.signature.setValue(signature);
    }

}
