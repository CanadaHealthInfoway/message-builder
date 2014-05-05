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
 * Last modified: $LastChangedDate: 2013-12-09 12:33:15 -0400 (Mon, 09 Dec 2013) $
 * Revision:      $LastChangedRevision: 8228 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Patient</p>
 * 
 * <p>Important for qualifying and filtering dosage 
 * specifications.</p>
 * 
 * <p>Indicates the type of patient for whom the dosage 
 * instruction applies.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Patient"})
public class PatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private CV patientLivingSubjectKindAdministrativeGenderCode = new CVImpl();


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.LivingSubjectKind.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Some dosage specifications are gender-specific.</p>
     * 
     * <p>Indicates the gender of patient to whom the dosage 
     * specification applies.</p>
     */
    @Hl7XmlMapping({"patientLivingSubjectKind/administrativeGenderCode"})
    public AdministrativeGender getPatientLivingSubjectKindAdministrativeGenderCode() {
        return (AdministrativeGender) this.patientLivingSubjectKindAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.LivingSubjectKind.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Some dosage specifications are gender-specific.</p>
     * 
     * <p>Indicates the gender of patient to whom the dosage 
     * specification applies.</p>
     */
    public void setPatientLivingSubjectKindAdministrativeGenderCode(AdministrativeGender patientLivingSubjectKindAdministrativeGenderCode) {
        this.patientLivingSubjectKindAdministrativeGenderCode.setValue(patientLivingSubjectKindAdministrativeGenderCode);
    }

}
