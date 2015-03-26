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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.comt_mt300003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;



/**
 * <p>Business Name: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300003CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private PatientBean recordTargetPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private RecordedAtBean location;


    /**
     * <p>Business Name: B:Patient Note Id</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique reference of a patient note and is 
     * therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p>
     * 
     * <p>Identifier of the patient note record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Patient Note Id</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique reference of a patient note and is 
     * therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p>
     * 
     * <p>Identifier of the patient note record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Patient Note Category</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows patient notes of different purposes and use, to be 
     * attached to a patient. Attribute is mandatory to ensure that 
     * patient notes are categorized accordingly. This attribute 
     * may also be used by DISs to enforce different access control 
     * to different types of notes.</p>
     * 
     * <p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getCode() {
        return (ActPatientAnnotationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Patient Note Category</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows patient notes of different purposes and use, to be 
     * attached to a patient. Attribute is mandatory to ensure that 
     * patient notes are categorized accordingly. This attribute 
     * may also be used by DISs to enforce different access control 
     * to different types of notes.</p>
     * 
     * <p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, etc.</p>
     */
    public void setCode(ActPatientAnnotationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Patient Note Text</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to a patient as a 
     * whole or to the patient's profile (such as medication, lab. 
     * DI, etc). This attribute is mandatory because there's no 
     * point in having a patient note unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free textual description of the patient note.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: C:Patient Note Text</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to a patient as a 
     * whole or to the patient's profile (such as medication, lab. 
     * DI, etc). This attribute is mandatory because there's no 
     * point in having a patient note unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free textual description of the patient note.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: COMT_MT300003CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: 
     * COMT_MT300003CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * COMT_MT300003CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }

}
