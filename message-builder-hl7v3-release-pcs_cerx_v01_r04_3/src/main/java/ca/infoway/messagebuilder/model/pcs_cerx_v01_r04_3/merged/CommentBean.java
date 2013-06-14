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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

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
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.comt_mt301001ca.AnnotatedActBean;



/**
 * <p>COMT_MT300001CA.Annotation: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, Immunization, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 * 
 * <p>COMT_MT300003CA.Annotation: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 * 
 * <p>COMT_MT301001CA.Annotation: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 * 
 * <p>COCT_MT120600CA.Annotation: Notes</p>
 * 
 * <p>Public Health requires all clinical notes to be 
 * 'verified' by a responsible party if not created by 
 * physician in charge. This model conveys the correct 
 * semantics, but is inconsistent with other uses of 
 * &quot;author&quot; participation in POIZ models. Any changes 
 * here will have to be reconciled with other projects using 
 * this same cmet.</p>
 * 
 * <p>Allows various Providers to attach comments to an 
 * existing record, and thus improving cross-provider 
 * communications.</p>
 * 
 * <p>This is a list of comments made about the record by 
 * providers. Information captured here includes the provider 
 * making the comments; and excludes information that would 
 * render the record invalid. This information will only be 
 * seen when another provider reviews the record. Urgent or 
 * targeted messages should be sent using a different mechanism 
 * (e.g. phone).</p>
 */
@Hl7PartTypeMapping({"COCT_MT120600CA.Annotation","COMT_MT300001CA.Annotation","COMT_MT300003CA.Annotation","COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private PatientBean recordTargetPatient;
    private II id = new IIImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private CV languageCode = new CVImpl();
    private AnnotatedActBean subjectAnnotatedAct;


    /**
     * <p>Business Name: PatientNoteCategory</p>
     * 
     * <p>Un-merged Business Name: PatientNoteCategory</p>
     * 
     * <p>Relationship: COMT_MT300001CA.Annotation.code</p>
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
     * General, Medication, Lab, DI, Immunization, etc</p>
     * 
     * <p>Un-merged Business Name: PatientNoteCategory</p>
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
     * <p>Business Name: PatientNoteCategory</p>
     * 
     * <p>Un-merged Business Name: PatientNoteCategory</p>
     * 
     * <p>Relationship: COMT_MT300001CA.Annotation.code</p>
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
     * General, Medication, Lab, DI, Immunization, etc</p>
     * 
     * <p>Un-merged Business Name: PatientNoteCategory</p>
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
     * <p>Un-merged Business Name: PatientNoteText</p>
     * 
     * <p>Relationship: COMT_MT300001CA.Annotation.text</p>
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
     * 
     * <p>Un-merged Business Name: PatientNoteText</p>
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
     * 
     * <p>Un-merged Business Name: AnnotationText</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach arbitrary comments to 
     * clinical records (prescription, dispenses, lab results, 
     * allergies, etc) for communication. This attribute is 
     * mandatory because there's no point in having an annotation 
     * unless there's actually content in the note.</p>
     * 
     * <p>Free text comment to be attached to a record.</p>
     * 
     * <p>Un-merged Business Name: NoteText</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Un-merged Business Name: PatientNoteText</p>
     * 
     * <p>Relationship: COMT_MT300001CA.Annotation.text</p>
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
     * 
     * <p>Un-merged Business Name: PatientNoteText</p>
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
     * 
     * <p>Un-merged Business Name: AnnotationText</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach arbitrary comments to 
     * clinical records (prescription, dispenses, lab results, 
     * allergies, etc) for communication. This attribute is 
     * mandatory because there's no point in having an annotation 
     * unless there's actually content in the note.</p>
     * 
     * <p>Free text comment to be attached to a record.</p>
     * 
     * <p>Un-merged Business Name: NoteText</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300001CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300001CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Business Name: PatientNoteId</p>
     * 
     * <p>Un-merged Business Name: PatientNoteId</p>
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
     * <p>Business Name: PatientNoteId</p>
     * 
     * <p>Un-merged Business Name: PatientNoteId</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to write notes in the language of their 
     * choice.</p><p>This attribute is marked as 'populated' 
     * because the language of the note must always be 
     * known/available or a null flavor must be specified.</p>
     * 
     * <p>A coded value denoting the language in which the note is 
     * written.</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to write notes in the language of their 
     * choice.</p><p>This attribute is marked as 'populated' 
     * because the language of the note must always be 
     * known/available or a null flavor must be specified.</p>
     * 
     * <p>A coded value denoting the language in which the note is 
     * written.</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Subject.annotatedAct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/annotatedAct"})
    public AnnotatedActBean getSubjectAnnotatedAct() {
        return this.subjectAnnotatedAct;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Subject.annotatedAct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectAnnotatedAct(AnnotatedActBean subjectAnnotatedAct) {
        this.subjectAnnotatedAct = subjectAnnotatedAct;
    }

}
