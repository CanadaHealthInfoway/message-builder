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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.poiz_mt070020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt050208ca.PatientBean;



/**
 * <p>Business Name: administered to</p>
 * 
 * <p>Essential for linking the immunization to the patient's 
 * record, and is therefore mandatory.</p>
 * 
 * <p>Indicates the patient who is scheduled to be 
 * immunized.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT070020CA.Subject"})
public class AdministeredToBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private PatientBean patient;


    /**
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"patient"})
    public PatientBean getPatient() {
        return this.patient;
    }

    /**
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

}
