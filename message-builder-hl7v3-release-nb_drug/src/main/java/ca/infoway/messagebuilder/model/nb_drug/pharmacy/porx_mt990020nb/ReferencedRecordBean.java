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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990020nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.common.coct_mt050203nb.PatientBean;



/**
 * <p>Business Name: Referenced Record</p>
 * 
 * <p>As a request message, refers to the order record to be 
 * acted upon or which has been acted upon.</p><p>As a 
 * response, may be used to indicate the identifier assigned to 
 * a created object.</p>
 * 
 * <p>References an existing Request or Order record by 
 * identifier.</p>
 */
@Hl7PartTypeMapping({"PORX_MT990020NB.ActRequest"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private II id = new IIImpl();
    private PatientBean subjectPatient;


    /**
     * <p>Business Name: Record Id</p>
     * 
     * <p>Relationship: PORX_MT990020NB.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the order record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the Request or Order record being referred to.</p>
     * 
     * <p>This must specify a valid prescription record 
     * identifier(drug or or device prescription record ID ).</p>
     * 
     * <p>For the Activate Prescription request accepted message 
     * this id returns the newly created DIS identifier for the 
     * medication record that was created against the patient's DIS 
     * profile. This ID should be saved for the medication in the 
     * local system such that it may be used for subsequent update 
     * messages or other transactions requiring this 
     * identifier.</p> <p>For the Activate Device Prescription 
     * request accepted message this id returns the newly created 
     * DIS identifier for the device prescription record that was 
     * created against the patient's DIS profile. This ID should be 
     * saved for the device prescription in the local system such 
     * that it may be used for subsequent update messages or other 
     * transactions requiring this identifier.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Record Id</p>
     * 
     * <p>Relationship: PORX_MT990020NB.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the order record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the Request or Order record being referred to.</p>
     * 
     * <p>This must specify a valid prescription record 
     * identifier(drug or or device prescription record ID ).</p>
     * 
     * <p>For the Activate Prescription request accepted message 
     * this id returns the newly created DIS identifier for the 
     * medication record that was created against the patient's DIS 
     * profile. This ID should be saved for the medication in the 
     * local system such that it may be used for subsequent update 
     * messages or other transactions requiring this 
     * identifier.</p> <p>For the Activate Device Prescription 
     * request accepted message this id returns the newly created 
     * DIS identifier for the device prescription record that was 
     * created against the patient's DIS profile. This ID should be 
     * saved for the device prescription in the local system such 
     * that it may be used for subsequent update messages or other 
     * transactions requiring this identifier.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: PORX_MT990020NB.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT990020NB.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

}
