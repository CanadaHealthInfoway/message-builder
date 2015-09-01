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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_drug.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ComponentMeasurements</p>
 * 
 * <p>REPC_MT100002NB.SubObservationEvent: Component 
 * Measurements</p>
 * 
 * <p>The same Measurement Type may not be specified in both 
 * the SubObservationEvent and the CommonObservationEvent.</p>
 * 
 * <p>Allows both parts to be captured as part of a single 
 * measurement.</p>
 * 
 * <p>Represents one of the two components (systolic and 
 * diastolic) of a blood pressure measurement.</p>
 * 
 * <p>REPC_MT000018NB.SubObservationEvent: Component 
 * Measurements</p>
 * 
 * <p>The same Measurement Type may not be specified in both 
 * the SubObservationEvent and the CommonObservationEvent.</p>
 * 
 * <p>Allows both parts to be captured as part of a single 
 * measurement.</p>
 * 
 * <p>Represents one of the two components (systolic and 
 * diastolic) of a blood pressure measurement.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000018NB.SubObservationEvent","REPC_MT100002NB.SubObservationEvent"})
public class ComponentMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private CD code = new CDImpl();
    private PQ value = new PQImpl();


    /**
     * <p>Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Relationship: REPC_MT100002NB.SubObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between the two twtype of blood pressure 
     * measurements.</p><p>Code is mandatory to ensure that blood 
     * pressure observations are distinguishable. The attribute is 
     * CD to support SNOMED</p>
     * 
     * <p>Distinguishes bwtween the two types of blood measurement. 
     * This can either be code for SYSTOLIC or DYSTOLIC</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Relationship: REPC_MT000018NB.SubObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between the two types of blood pressure 
     * measurements.</p><p>Code is mandatory to ensure that blood 
     * pressure observations are distinguishable. The attribute is 
     * CD to support SNOMED</p>
     * 
     * <p>Distinguishes between the two types of blood measurement. 
     * This can either be code for SYSTOLIC or DYSTOLIC</p>
     */
    @Hl7XmlMapping({"code"})
    public CommonClinicalObservationType getCode() {
        return (CommonClinicalObservationType) this.code.getValue();
    }

    /**
     * <p>Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Relationship: REPC_MT100002NB.SubObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between the two twtype of blood pressure 
     * measurements.</p><p>Code is mandatory to ensure that blood 
     * pressure observations are distinguishable. The attribute is 
     * CD to support SNOMED</p>
     * 
     * <p>Distinguishes bwtween the two types of blood measurement. 
     * This can either be code for SYSTOLIC or DYSTOLIC</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementType</p>
     * 
     * <p>Relationship: REPC_MT000018NB.SubObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between the two types of blood pressure 
     * measurements.</p><p>Code is mandatory to ensure that blood 
     * pressure observations are distinguishable. The attribute is 
     * CD to support SNOMED</p>
     * 
     * <p>Distinguishes between the two types of blood measurement. 
     * This can either be code for SYSTOLIC or DYSTOLIC</p>
     */
    public void setCode(CommonClinicalObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Relationship: REPC_MT100002NB.SubObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides standard representation of the blood pressure 
     * measurement. May be used in calculations. Attribute is 
     * defined as mandatory to ensure that a value is always 
     * supplied, if there is a blood pressure measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the blood pressure.</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Relationship: REPC_MT000018NB.SubObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides standard representation of the blood pressure 
     * measurement. May be used in calculations. Attribute is 
     * defined as mandatory to ensure that a value is always 
     * supplied, if there is a blood pressure measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the blood pressure.</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Relationship: REPC_MT100002NB.SubObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides standard representation of the blood pressure 
     * measurement. May be used in calculations. Attribute is 
     * defined as mandatory to ensure that a value is always 
     * supplied, if there is a blood pressure measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the blood pressure.</p>
     * 
     * <p>Un-merged Business Name: BloodPressureMeasurementValue</p>
     * 
     * <p>Relationship: REPC_MT000018NB.SubObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides standard representation of the blood pressure 
     * measurement. May be used in calculations. Attribute is 
     * defined as mandatory to ensure that a value is always 
     * supplied, if there is a blood pressure measurement.</p>
     * 
     * <p>The amount (quantity and unit) that has been recorded for 
     * the blood pressure.</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
