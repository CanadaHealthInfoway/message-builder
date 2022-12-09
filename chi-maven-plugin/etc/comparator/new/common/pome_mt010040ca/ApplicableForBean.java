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
package ca.infoway.messagebuilder.model.common.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>applicable for 
 * 
 * <p>Identifies conditions that need to apply to the patient 
 * for the dosage guideline to be applicable. 
 * 
 * <p>Different dosage specifications apply to different types 
 * of patients. 
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Precondition"})
public class ApplicableForBean extends MessagePartBean {

    private CV<ObservationDosageDefinitionPreconditionType> patientCharacteristicType = new CVImpl<ObservationDosageDefinitionPreconditionType>();
    private BL excludeCharacteristic = new BLImpl();
    private IVL<PQ, Interval<PhysicalQuantity>> patientCharacteristicValue = new IVLImpl<PQ, Interval<PhysicalQuantity>>();

    @Hl7XmlMapping({"observationEventCriterion/code"})
    public ObservationDosageDefinitionPreconditionType getPatientCharacteristicType() {
        return this.patientCharacteristicType.getValue();
    }
    public void setPatientCharacteristicType(ObservationDosageDefinitionPreconditionType patientCharacteristicType) {
        this.patientCharacteristicType.setValue(patientCharacteristicType);
    }

    @Hl7XmlMapping({"observationEventCriterion/negationInd"})
    public java.lang.Boolean getExcludeCharacteristic() {
        return this.excludeCharacteristic.getValue();
    }
    public void setExcludeCharacteristic(java.lang.Boolean excludeCharacteristic) {
        this.excludeCharacteristic.setValue(excludeCharacteristic);
    }

    @Hl7XmlMapping({"observationEventCriterion/value"})
    public Interval<PhysicalQuantity> getPatientCharacteristicValue() {
        return this.patientCharacteristicValue.getValue();
    }
    public void setPatientCharacteristicValue(Interval<PhysicalQuantity> patientCharacteristicValue) {
        this.patientCharacteristicValue.setValue(patientCharacteristicValue);
    }

}