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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.PatientImmunizationObservationType;



/**
 * <p>PatientImmunizationObservations</p>
 * 
 * <p>POIZ_MT060150CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p>
 * 
 * <p>Provides a mechanism to communicate information that is 
 * not otherwise modeled.</p>
 * 
 * <p>POIZ_MT030050CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p>
 * 
 * <p>Provides a mechanism to communicate information that is 
 * not otherwise modeled.</p>
 * 
 * <p>POIZ_MT030060CA.PatientImmunizationObservations: Patient 
 * Immunization Observations</p>
 * 
 * <p>Captures a wide range of observations mandated by the 
 * appropriate or organizational administrative definitions or 
 * other criteria that govern reporting.</p>
 * 
 * <p>Provides a mechanism to communicate information that is 
 * not otherwise modeled.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.PatientImmunizationObservations","POIZ_MT030060CA.PatientImmunizationObservations","POIZ_MT060150CA.PatientImmunizationObservations"})
public class PatientImmunizationObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private ANY<Object> value = new ANYImpl<Object>();


    /**
     * <p>PatientImmunizationObservationType</p>
     * 
     * <p>Patient Immunization Observation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public PatientImmunizationObservationType getCode() {
        return (PatientImmunizationObservationType) this.code.getValue();
    }

    /**
     * <p>PatientImmunizationObservationType</p>
     * 
     * <p>Patient Immunization Observation Type</p>
     */
    public void setCode(PatientImmunizationObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>PatientImmunizationObservationValue</p>
     * 
     * <p>Patient Immunization Observation Value</p>
     * 
     * <p>Allows the specification of a value related to the 
     * patient immunization observation in question.</p>
     * 
     * <p>Needed to convey meaning of the patient immunization 
     * observation. As a result, this attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>PatientImmunizationObservationValue</p>
     * 
     * <p>Patient Immunization Observation Value</p>
     * 
     * <p>Allows the specification of a value related to the 
     * patient immunization observation in question.</p>
     * 
     * <p>Needed to convey meaning of the patient immunization 
     * observation. As a result, this attribute is mandatory.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }

}
