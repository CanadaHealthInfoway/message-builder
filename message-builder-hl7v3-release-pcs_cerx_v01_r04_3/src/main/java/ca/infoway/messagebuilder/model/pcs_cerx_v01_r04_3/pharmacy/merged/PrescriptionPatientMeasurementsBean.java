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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

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



/**
 * <p>Business Name: PrescriptionPatientMeasurements</p>
 * 
 * <p>PORX_MT060340CA.QuantityObservationEvent: Prescription 
 * Patient Measurements</p>
 * 
 * <p>Allows patient height and weight to be conveyed to the 
 * pharmacy for dosage calculation or verification</p>
 * 
 * <p>This comprises the height and/or weight of a patient as 
 * measured/observed/known by the prescriber at the time of 
 * prescribing.</p>
 * 
 * <p>PORX_MT010120CA.QuantityObservationEvent: Prescription 
 * Patient Measurements</p>
 * 
 * <p>Allows patient height and weight to be conveyed to the 
 * pharmacy for dosage calculation or verification;</p>
 * 
 * <p>This comprises the height and/or weight of a patient as 
 * measured/observed/known by the prescriber at the time of 
 * prescribing.</p>
 * 
 * <p>PORX_MT060160CA.QuantityObservationEvent: Prescription 
 * Patient Measurements</p>
 * 
 * <p>Allows patient height and weight to be conveyed to the 
 * pharmacy for dosage calculation or verification</p>
 * 
 * <p>This comprises the height and/or weight of a patient as 
 * measured/observed/known by the prescriber at the time of 
 * prescribing.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.QuantityObservationEvent","PORX_MT060160CA.QuantityObservationEvent","PORX_MT060340CA.QuantityObservationEvent"})
public class PrescriptionPatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ value = new PQImpl();


    /**
     * <p>Business Name: PrescriptionPatientMeasurementType</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01</p>
     * 
     * <p>Clinical.495-H2</p>
     * 
     * <p>Distinguishes height from weight.</p><p>Code is mandatory 
     * to ensure that measurements/observations are 
     * distinguishable.</p>
     * 
     * <p>Identification of the type of observation that was made 
     * about the patient. The only two allowable types are height 
     * and weight.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01 NCPDP:Clinical.495-H2</p>
     * 
     * <p>Distinguishes what kind of information is being 
     * specified. Code is mandatory to ensure that 
     * measurements/observations are distinguishable.</p>
     * 
     * <p>Identification of the type of measurement/observation 
     * that was made about the patient. The only two allowable 
     * types are height and weight.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01</p>
     * 
     * <p>Clinical.495-H2</p>
     * 
     * <p>Distinguishes height from weight.</p><p>Code is mandatory 
     * to ensure that measurements/observations are 
     * distinguishable.</p>
     * 
     * <p>Identification of the type of observation that was made 
     * about the patient. The only two allowable types are height 
     * and weight.</p>
     */
    @Hl7XmlMapping({"code"})
    public x_ActObservationHeightOrWeight getCode() {
        return (x_ActObservationHeightOrWeight) this.code.getValue();
    }

    /**
     * <p>Business Name: PrescriptionPatientMeasurementType</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01</p>
     * 
     * <p>Clinical.495-H2</p>
     * 
     * <p>Distinguishes height from weight.</p><p>Code is mandatory 
     * to ensure that measurements/observations are 
     * distinguishable.</p>
     * 
     * <p>Identification of the type of observation that was made 
     * about the patient. The only two allowable types are height 
     * and weight.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01 NCPDP:Clinical.495-H2</p>
     * 
     * <p>Distinguishes what kind of information is being 
     * specified. Code is mandatory to ensure that 
     * measurements/observations are distinguishable.</p>
     * 
     * <p>Identification of the type of measurement/observation 
     * that was made about the patient. The only two allowable 
     * types are height and weight.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-01</p>
     * 
     * <p>Clinical.495-H2</p>
     * 
     * <p>Distinguishes height from weight.</p><p>Code is mandatory 
     * to ensure that measurements/observations are 
     * distinguishable.</p>
     * 
     * <p>Identification of the type of observation that was made 
     * about the patient. The only two allowable types are height 
     * and weight.</p>
     */
    public void setCode(x_ActObservationHeightOrWeight code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTime</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04</p>
     * 
     * <p>Clinical.494-ZE</p>
     * 
     * <p>Clinical.495-H1</p>
     * 
     * <p>Allows provider to evaluate currency of the 
     * information.</p><p>The attribute is populated because the 
     * measurement time must be known or a null flavor must be 
     * specified.</p>
     * 
     * <p>The date on which the measurement was made.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTimestamp</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04 NCPDP:Clinical.494-ZE 
     * NCPDP:Clinical.495-H1</p>
     * 
     * <p>Allows providers to evaluate currency of the 
     * information.</p><p>Because the date of measurement 
     * determines the relevance of the information, this attribute 
     * is defined as 'populated'.</p>
     * 
     * <p>The date on which the measurement was made</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTime</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04</p>
     * 
     * <p>Clinical.494-ZE</p>
     * 
     * <p>Clinical.495-H1</p>
     * 
     * <p>Allows provider to evaluate currency of the 
     * information.</p><p>The attribute is populated because the 
     * measurement time must be known or a null flavor must be 
     * specified.</p>
     * 
     * <p>The date on which the measurement was made.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTime</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04</p>
     * 
     * <p>Clinical.494-ZE</p>
     * 
     * <p>Clinical.495-H1</p>
     * 
     * <p>Allows provider to evaluate currency of the 
     * information.</p><p>The attribute is populated because the 
     * measurement time must be known or a null flavor must be 
     * specified.</p>
     * 
     * <p>The date on which the measurement was made.</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTimestamp</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04 NCPDP:Clinical.494-ZE 
     * NCPDP:Clinical.495-H1</p>
     * 
     * <p>Allows providers to evaluate currency of the 
     * information.</p><p>Because the date of measurement 
     * determines the relevance of the information, this attribute 
     * is defined as 'populated'.</p>
     * 
     * <p>The date on which the measurement was made</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescriptionPatientMeasurementTime</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>OBS.010-04</p>
     * 
     * <p>Clinical.494-ZE</p>
     * 
     * <p>Clinical.495-H1</p>
     * 
     * <p>Allows provider to evaluate currency of the 
     * information.</p><p>The attribute is populated because the 
     * measurement time must be known or a null flavor must be 
     * specified.</p>
     * 
     * <p>The date on which the measurement was made.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity)</p>
     * 
     * <p>OBS.010-03 (unit)</p>
     * 
     * <p>Clinical.595-H4 (value)</p>
     * 
     * <p>Clinical.495-H3 (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>The attribute is 
     * mandatory because the measurement value must be known.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the patient's height and/or weight. E.g. height in meters, 
     * weight in kilograms, etc.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity) eScript:OBS.010-03 (unit) 
     * NCPDP:Clinical.595-H4 (value) NCPDP:Clinical.495-H3 
     * (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>Attribute is defined as 
     * 'mandatory' to ensure that a value is supplied, if there is 
     * a measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the specific type of observation. E.g. height in meters, 
     * weight in kilograms.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity)</p>
     * 
     * <p>OBS.010-03 (unit)</p>
     * 
     * <p>Clinical.595-H4 (value)</p>
     * 
     * <p>Clinical.495-H3 (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>The attribute is 
     * mandatory because the measurement value must be known.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the patient's height and/or weight. E.g. height in meters, 
     * weight in kilograms, etc.</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity)</p>
     * 
     * <p>OBS.010-03 (unit)</p>
     * 
     * <p>Clinical.595-H4 (value)</p>
     * 
     * <p>Clinical.495-H3 (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>The attribute is 
     * mandatory because the measurement value must be known.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the patient's height and/or weight. E.g. height in meters, 
     * weight in kilograms, etc.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity) eScript:OBS.010-03 (unit) 
     * NCPDP:Clinical.595-H4 (value) NCPDP:Clinical.495-H3 
     * (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>Attribute is defined as 
     * 'mandatory' to ensure that a value is supplied, if there is 
     * a measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the specific type of observation. E.g. height in meters, 
     * weight in kilograms.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.QuantityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>OBS.010-02 (quantity)</p>
     * 
     * <p>OBS.010-03 (unit)</p>
     * 
     * <p>Clinical.595-H4 (value)</p>
     * 
     * <p>Clinical.495-H3 (unit)</p>
     * 
     * <p>Provides comparable representation of the measurement. 
     * May be used in calculations.</p><p>The attribute is 
     * mandatory because the measurement value must be known.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the patient's height and/or weight. E.g. height in meters, 
     * weight in kilograms, etc.</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
