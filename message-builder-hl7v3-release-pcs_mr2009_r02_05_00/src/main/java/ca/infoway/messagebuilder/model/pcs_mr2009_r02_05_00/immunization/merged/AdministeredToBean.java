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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.merged.Patient_2Bean;



/**
 * <p>Business Name: AdministeredTo</p>
 * 
 * <p>POIZ_MT030060CA.Subject10: (no business name)</p>
 * 
 * <p>Essential for linking the immunization to the patient's 
 * record, and is therefore mandatory.</p>
 * 
 * <p>Indicates the patient who was immunized.</p>
 * 
 * <p>POIZ_MT070020CA.Subject: administered to</p>
 * 
 * <p>Essential for linking the immunization to the patient's 
 * record, and is therefore mandatory.</p>
 * 
 * <p>Indicates the patient who is scheduled to be 
 * immunized.</p>
 * 
 * <p>POIZ_MT061150CA.Subject10: *administered to</p>
 * 
 * <p>Essential for linking the immunization to the patient's 
 * record, and is therefore mandatory.</p>
 * 
 * <p>Indicates the patient who was immunized.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Subject10","POIZ_MT030060CA.Subject10","POIZ_MT060150CA.Subject10","POIZ_MT061150CA.Subject10","POIZ_MT070020CA.Subject"})
public class AdministeredToBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private Patient_2Bean patient;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"patient"})
    public Patient_2Bean getPatient() {
        return this.patient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPatient(Patient_2Bean patient) {
        this.patient = patient;
    }

}
