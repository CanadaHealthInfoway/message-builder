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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdministrationCode;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.CausalActs;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT980010CA.SubstanceAdministration", "PORX_MT980020CA.SubstanceAdministration", "PORX_MT980030CA.SubstanceAdministration" })
public class SubstanceAdministrationBean extends MessagePartBean implements Serializable, CausalActs, VeryBasicConfidentiality {

    private static final long serialVersionUID = 3756331604342755726L;

    private final II id = new IIImpl();

    private final CD otherMedicationIndicator = new CDImpl();

    private final CD administrationType = new CDImpl();

    private final CD activeMedicationStatus = new CDImpl();

    private final IVL<TS, Interval<Date>> activeMedicationTimeRange = new IVLImpl<TS, Interval<Date>>();

    private final CD confidentialityCode = new CDImpl();

    private final PQ activeMedicationDoseQuantity = new PQImpl();

    private MedicineBean medication;

    @Hl7XmlMapping({ "id" })
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping({ "moodCode" })
    public x_ActMoodOrderEvent getOtherMedicationIndicator() {
        return (x_ActMoodOrderEvent) this.otherMedicationIndicator.getValue();
    }

    public void setOtherMedicationIndicator(x_ActMoodOrderEvent otherMedicationIndicator) {
        this.otherMedicationIndicator.setValue(otherMedicationIndicator);
    }

    @Hl7XmlMapping({ "code" })
    public ActSubstanceAdministrationCode getAdministrationType() {
        return (ActSubstanceAdministrationCode) this.administrationType.getValue();
    }

    public void setAdministrationType(ActSubstanceAdministrationCode administrationType) {
        this.administrationType.setValue(administrationType);
    }

    @Hl7XmlMapping({ "statusCode" })
    public ActStatus getActiveMedicationStatus() {
        return (ActStatus) this.activeMedicationStatus.getValue();
    }

    public void setActiveMedicationStatus(ActStatus activeMedicationStatus) {
        this.activeMedicationStatus.setValue(activeMedicationStatus);
    }

    @Hl7XmlMapping({ "effectiveTime" })
    public Interval<Date> getActiveMedicationTimeRange() {
        return this.activeMedicationTimeRange.getValue();
    }

    public void setActiveMedicationTimeRange(Interval<Date> activeMedicationTimeRange) {
        this.activeMedicationTimeRange.setValue(activeMedicationTimeRange);
    }

    @Hl7XmlMapping({ "confidentialityCode" })
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind activeMedicationMaskingIndicator) {
        this.confidentialityCode.setValue(activeMedicationMaskingIndicator);
    }

    @Hl7XmlMapping({ "doseQuantity" })
    public PhysicalQuantity getActiveMedicationDoseQuantity() {
        return this.activeMedicationDoseQuantity.getValue();
    }

    public void setActiveMedicationDoseQuantity(PhysicalQuantity activeMedicationDoseQuantity) {
        this.activeMedicationDoseQuantity.setValue(activeMedicationDoseQuantity);
    }

    @Hl7XmlMapping("consumable/medication/player")
    public MedicineBean getMedication() {
        return medication;
    }

    public void setMedication(MedicineBean medication) {
        this.medication = medication;
    }
}
