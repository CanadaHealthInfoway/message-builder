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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT000018CA.SubObservationEvent","REPC_MT100002CA.SubObservationEvent"})
public class ComponentMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD bloodPressureMeasurementType = new CDImpl();
    private PQ bloodPressureMeasurementValue = new PQImpl();


    /**
     * <p>BloodPressureMeasurementType</p>
     * 
     * <p>A:Blood Pressure Measurement Type</p>
     * 
     * <p>Blood Pressure Measurement Type</p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getBloodPressureMeasurementType() {
        return (CommonClinicalObservationType) this.bloodPressureMeasurementType.getValue();
    }
    public void setBloodPressureMeasurementType(CommonClinicalObservationType bloodPressureMeasurementType) {
        this.bloodPressureMeasurementType.setValue(bloodPressureMeasurementType);
    }


    /**
     * <p>BloodPressureMeasurementValue</p>
     * 
     * <p>B:Blood Pressure Measurement Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getBloodPressureMeasurementValue() {
        return this.bloodPressureMeasurementValue.getValue();
    }
    public void setBloodPressureMeasurementValue(PhysicalQuantity bloodPressureMeasurementValue) {
        this.bloodPressureMeasurementValue.setValue(bloodPressureMeasurementValue);
    }

}