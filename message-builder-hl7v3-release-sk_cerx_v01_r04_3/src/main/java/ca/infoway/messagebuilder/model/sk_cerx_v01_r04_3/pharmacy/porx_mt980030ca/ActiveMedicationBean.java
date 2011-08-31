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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980030ca;

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
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT980030CA.SubstanceAdministration"})
public class ActiveMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.CausalActs {

    private static final long serialVersionUID = 20110831L;
    private CS otherMedicationIndicator = new CSImpl();
    private II activeMedicationRecordNumber = new IIImpl();
    private CD administrationType = new CDImpl();
    private CS activeMedicationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> activeMedicationTimeRange = new IVLImpl<TS, Interval<Date>>();
    private CV activeMedicationMaskingIndicator = new CVImpl();
    private PQ activeMedicationDoseQuantity = new PQImpl();
    private DrugProductBean consumableMedication;


    /**
     * <p>Other Medication Indicator</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getOtherMedicationIndicator() {
        return (x_ActMoodOrderEvent) this.otherMedicationIndicator.getValue();
    }
    public void setOtherMedicationIndicator(x_ActMoodOrderEvent otherMedicationIndicator) {
        this.otherMedicationIndicator.setValue(otherMedicationIndicator);
    }


    /**
     * <p>A:Active Medication Record Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getActiveMedicationRecordNumber() {
        return this.activeMedicationRecordNumber.getValue();
    }
    public void setActiveMedicationRecordNumber(Identifier activeMedicationRecordNumber) {
        this.activeMedicationRecordNumber.setValue(activeMedicationRecordNumber);
    }


    /**
     * <p>Administration Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdministrationCode getAdministrationType() {
        return (ActSubstanceAdministrationCode) this.administrationType.getValue();
    }
    public void setAdministrationType(ActSubstanceAdministrationCode administrationType) {
        this.administrationType.setValue(administrationType);
    }


    /**
     * <p>B:Active Medication Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getActiveMedicationStatus() {
        return (ActStatus) this.activeMedicationStatus.getValue();
    }
    public void setActiveMedicationStatus(ActStatus activeMedicationStatus) {
        this.activeMedicationStatus.setValue(activeMedicationStatus);
    }


    /**
     * <p>C:Active Medication Time-range</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getActiveMedicationTimeRange() {
        return this.activeMedicationTimeRange.getValue();
    }
    public void setActiveMedicationTimeRange(Interval<Date> activeMedicationTimeRange) {
        this.activeMedicationTimeRange.setValue(activeMedicationTimeRange);
    }


    /**
     * <p>E:Active Medication Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getActiveMedicationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.activeMedicationMaskingIndicator.getValue();
    }
    public void setActiveMedicationMaskingIndicator(x_VeryBasicConfidentialityKind activeMedicationMaskingIndicator) {
        this.activeMedicationMaskingIndicator.setValue(activeMedicationMaskingIndicator);
    }


    /**
     * <p>D:Active Medication Dose Quantity</p>
     */
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