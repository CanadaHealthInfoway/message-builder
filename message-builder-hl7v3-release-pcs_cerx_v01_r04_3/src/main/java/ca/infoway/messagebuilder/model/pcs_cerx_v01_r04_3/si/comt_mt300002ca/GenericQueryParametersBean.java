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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.comt_mt300002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300002CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private CV patientNoteCategoryCodeValue = new CVImpl();


    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient drug contraindication query. Filter the result set 
     * to include only those records pertaining to the patient with 
     * this Id.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient drug contraindication query. Filter the result set 
     * to include only those records pertaining to the patient with 
     * this Id.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the drug 
     * contraindication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: COMT_MT300002CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the drug 
     * contraindication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: Patient Note Category Code</p>
     * 
     * <p>Relationship: 
     * COMT_MT300002CA.PatientNoteCategoryCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all patient notes pertaining 
     * to a specific note category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those patient annotation pertaining to the 
     * specified annotation category.</p><p>Valid patient note 
     * categories include: General, Medication, Lab, DI, etc.</p>
     */
    @Hl7XmlMapping({"patientNoteCategoryCode/value"})
    public ActPatientAnnotationCode getPatientNoteCategoryCodeValue() {
        return (ActPatientAnnotationCode) this.patientNoteCategoryCodeValue.getValue();
    }

    /**
     * <p>Business Name: Patient Note Category Code</p>
     * 
     * <p>Relationship: 
     * COMT_MT300002CA.PatientNoteCategoryCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all patient notes pertaining 
     * to a specific note category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those patient annotation pertaining to the 
     * specified annotation category.</p><p>Valid patient note 
     * categories include: General, Medication, Lab, DI, etc.</p>
     */
    public void setPatientNoteCategoryCodeValue(ActPatientAnnotationCode patientNoteCategoryCodeValue) {
        this.patientNoteCategoryCodeValue.setValue(patientNoteCategoryCodeValue);
    }

}
