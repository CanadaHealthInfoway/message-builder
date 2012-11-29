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
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdministrationCode;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodRequestEvent;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT260010CA.SubstanceAdministration","COCT_MT260020CA.SubstanceAdministration","COCT_MT260030CA.SubstanceAdministration"})
public class ActiveMedicationBean extends MessagePartBean implements CausalActsBean, ca.infoway.messagebuilder.model.common.coct_mt260030ca.CausalActsBean {

    private CS<x_ActMoodRequestEvent> otherMedicationIndicator = new CSImpl<x_ActMoodRequestEvent>();
    private II activeMedicationRecordNumber = new IIImpl();
    private CD<ActSubstanceAdministrationCode> administrationType = new CDImpl<ActSubstanceAdministrationCode>();
    private CS<ActStatus> activeMedicationStatus = new CSImpl<ActStatus>();
    private IVL<TS, Interval<Date>> activeMedicationTimeRange = new IVLImpl<TS, Interval<Date>>();
    private CV<x_VeryBasicConfidentialityKind> activeMedicationMaskingIndicator = new CVImpl<x_VeryBasicConfidentialityKind>();
    private PQ activeMedicationDoseQuantity = new PQImpl();
    private DrugProductBean consumableMedication;

    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodRequestEvent getOtherMedicationIndicator() {
        return this.otherMedicationIndicator.getValue();
    }
    public void setOtherMedicationIndicator(x_ActMoodRequestEvent otherMedicationIndicator) {
        this.otherMedicationIndicator.setValue(otherMedicationIndicator);
    }

    @Hl7XmlMapping({"id"})
    public Identifier getActiveMedicationRecordNumber() {
        return this.activeMedicationRecordNumber.getValue();
    }
    public void setActiveMedicationRecordNumber(Identifier activeMedicationRecordNumber) {
        this.activeMedicationRecordNumber.setValue(activeMedicationRecordNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActSubstanceAdministrationCode getAdministrationType() {
        return this.administrationType.getValue();
    }
    public void setAdministrationType(ActSubstanceAdministrationCode administrationType) {
        this.administrationType.setValue(administrationType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getActiveMedicationStatus() {
        return this.activeMedicationStatus.getValue();
    }
    public void setActiveMedicationStatus(ActStatus activeMedicationStatus) {
        this.activeMedicationStatus.setValue(activeMedicationStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getActiveMedicationTimeRange() {
        return this.activeMedicationTimeRange.getValue();
    }
    public void setActiveMedicationTimeRange(Interval<Date> activeMedicationTimeRange) {
        this.activeMedicationTimeRange.setValue(activeMedicationTimeRange);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getActiveMedicationMaskingIndicator() {
        return this.activeMedicationMaskingIndicator.getValue();
    }
    public void setActiveMedicationMaskingIndicator(x_VeryBasicConfidentialityKind activeMedicationMaskingIndicator) {
        this.activeMedicationMaskingIndicator.setValue(activeMedicationMaskingIndicator);
    }

    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getActiveMedicationDoseQuantity() {
        return this.activeMedicationDoseQuantity.getValue();
    }
    public void setActiveMedicationDoseQuantity(PhysicalQuantity activeMedicationDoseQuantity) {
        this.activeMedicationDoseQuantity.setValue(activeMedicationDoseQuantity);
    }

    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }

}
