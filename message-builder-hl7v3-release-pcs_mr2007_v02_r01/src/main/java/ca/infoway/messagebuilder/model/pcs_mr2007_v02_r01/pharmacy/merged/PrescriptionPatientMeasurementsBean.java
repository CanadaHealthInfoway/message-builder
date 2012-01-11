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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_ActObservationHeightOrWeight;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010120CA.QuantityObservationEvent","PORX_MT060160CA.QuantityObservationEvent","PORX_MT060340CA.QuantityObservationEvent"})
public class PrescriptionPatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ value = new PQImpl();


    /**
     * <p>PrescriptionPatientMeasurementType</p>
     * 
     * <p>Prescription Patient Measurement Type</p>
     */
    @Hl7XmlMapping({"code"})
    public x_ActObservationHeightOrWeight getCode() {
        return (x_ActObservationHeightOrWeight) this.code.getValue();
    }
    public void setCode(x_ActObservationHeightOrWeight code) {
        this.code.setValue(code);
    }


    /**
     * <p>Prescription Patient Measurement Time</p>
     * 
     * <p>Prescription Patient Measurement Timestamp</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Prescription Patient Measured Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
