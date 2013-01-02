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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseInstructionsBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryBean;

@Hl7PartTypeMapping({ "PORX_MT030040CA.CombinedMedicationRequest", "PORX_MT060190CA.CombinedMedicationRequest" })
public class MedicationPrescriptionBean extends BasePrescriptionBean implements Serializable, MedicationProfileSummaryBean {

    private static final long serialVersionUID = 1701558074014825124L;

    private final CD code = new CDImpl();

    private MedicineBean medication;

    private MedicationDispenseInstructionsBean dispenseInstructions;

    private final CD workingListCode = new CDImpl();

    private BL verificationEventCriterion = new BLImpl(false);

    private BL sourceDispense = new BLImpl(false);
    
    private ServiceDeliveryLocationBean location;

    @Hl7XmlMapping("derivedFrom/sourceDispense")
    public Boolean getSourceDispense() {
        return sourceDispense.getValue();
    }

    public void setSourceDispense(Boolean sourceDispense) {
        this.sourceDispense.setValue(sourceDispense);
    }

    @Hl7XmlMapping("precondition/verificationEventCriterion")
    public Boolean getVerificationEventCriterion() {
        return verificationEventCriterion.getValue();
    }

    public void setVerificationEventCriterion(Boolean verificationEventCriterion) {
        this.verificationEventCriterion.setValue(verificationEventCriterion);
    }

    @Hl7XmlMapping("component2/supplyRequest")
    public MedicationDispenseInstructionsBean getDispenseInstructions() {
        return dispenseInstructions;
    }

    public void setDispenseInstructions(MedicationDispenseInstructionsBean supplyRequest) {
        this.dispenseInstructions = supplyRequest;
    }

    @Hl7XmlMapping("directTarget/medication/player")
    public MedicineBean getMedication() {
        return this.medication;
    }

    public void setMedication(MedicineBean medication) {
        this.medication = medication;
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("location")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("componentOf/workingListEvent/code")
    public ActTherapyDurationWorkingListCode getWorkingListCode() {
        return (ActTherapyDurationWorkingListCode) this.workingListCode.getValue();
    }

    public void setWorkingListCode(ActTherapyDurationWorkingListCode workingListCode) {
        this.workingListCode.setValue(workingListCode);
    }
}
