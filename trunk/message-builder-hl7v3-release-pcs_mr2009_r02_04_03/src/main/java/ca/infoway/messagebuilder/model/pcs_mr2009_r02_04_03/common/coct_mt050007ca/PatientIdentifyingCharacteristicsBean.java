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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.PatientCharacteristicObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient Identifying Characteristics</p>
 * 
 * <p>For this model, the observation is a description of 
 * patient characteristics used for identification.</p>
 * 
 * <p>Used for patient identification when the client registry 
 * is not available.</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifyingCharacteristicsObservationEvent"})
public class PatientIdentifyingCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private ST value = new STImpl();


    /**
     * <p>Identifying Characteristics Observation Type</p>
     * 
     * <p>Describes the observation type.</p>
     * 
     * <p>Used to categorize this observation event. For this 
     * model, the observation is a description of patient 
     * characteristics used for identification.</p>
     */
    @Hl7XmlMapping({"code"})
    public PatientCharacteristicObservationType getCode() {
        return (PatientCharacteristicObservationType) this.code.getValue();
    }

    /**
     * <p>Identifying Characteristics Observation Type</p>
     * 
     * <p>Describes the observation type.</p>
     * 
     * <p>Used to categorize this observation event. For this 
     * model, the observation is a description of patient 
     * characteristics used for identification.</p>
     */
    public void setCode(PatientCharacteristicObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>I:Patient Characteristics Text</p>
     * 
     * <p>A text attribute that is specifically used to describe 
     * identifying characteristics of a patient.</p>
     * 
     * <p>When a lab does not have access to the client registry to 
     * identify the patient, additional information is helpful in 
     * patient identification. This text description allows for 
     * non-coded patient descriptive details which don't change 
     * measurable over time and can be used to assist in patient 
     * identification.</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>I:Patient Characteristics Text</p>
     * 
     * <p>A text attribute that is specifically used to describe 
     * identifying characteristics of a patient.</p>
     * 
     * <p>When a lab does not have access to the client registry to 
     * identify the patient, additional information is helpful in 
     * patient identification. This text description allows for 
     * non-coded patient descriptive details which don't change 
     * measurable over time and can be used to assist in patient 
     * identification.</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
