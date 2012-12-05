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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.si.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.si.comt_mt300003ca.AnnotatedByBean;
import java.util.Set;



/**
 * <p>Business Name: Comment</p>
 * 
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
 */
@Hl7PartTypeMapping({"COMT_MT300001CA.Annotation","COMT_MT300003CA.Annotation","COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private II id = new IIImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private AnnotatedByBean author;
    private CreatedAtBean location;
    private CV languageCode = new CVImpl();
    private II subjectAnnotatedActId = new IIImpl();


    /**
     * <p>Business Name: PatientNoteCategory</p>
     * 
     * <p>Other Business Name: PatientNoteCategory</p>
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
     * <p>Other Business Name: PatientNoteCategory</p>
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
     * <p>Other Business Name: PatientNoteCategory</p>
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
     * <p>Other Business Name: PatientNoteCategory</p>
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
     * <p>Other Business Name: PatientNoteText</p>
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
     * <p>Other Business Name: PatientNoteText</p>
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
     * <p>Other Business Name: AnnotationText</p>
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
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Other Business Name: PatientNoteText</p>
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
     * <p>Other Business Name: PatientNoteText</p>
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
     * <p>Other Business Name: AnnotationText</p>
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
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: RestrictedPatientAccess</p>
     * 
     * <p>Other Business Name: RestrictedPatientAccess</p>
     * 
     * <p>Relationship: 
     * COMT_MT300001CA.Annotation.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Taboo allows the provider to request restricted access to 
     * patient or their care giver.</p><p>Constraint: Cant have 
     * both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p>
     * 
     * <p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Other Business Name: RestrictedPatientAccess</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.Annotation.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Taboo allows the provider to request restricted access to 
     * patient or their care giver.</p><p>Constraint: Cant have 
     * both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is required because even 
     * if a jurisdiction doesn't support masking on the way in, it 
     * will need to need to communicate masked data returned from 
     * other jurisdictions.</p>
     * 
     * <p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Business Name: PatientNoteId</p>
     * 
     * <p>Other Business Name: PatientNoteId</p>
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
     * <p>Other Business Name: PatientNoteId</p>
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
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AnnotatedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(AnnotatedByBean author) {
        this.author = author;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Other Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Other Business Name: WrittenIn</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Business Name: RecordId</p>
     * 
     * <p>Other Business Name: RecordId</p>
     * 
     * <p>Relationship: COMT_MT301001CA.AnnotatedAct.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p>
     */
    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Identifier getSubjectAnnotatedActId() {
        return this.subjectAnnotatedActId.getValue();
    }

    /**
     * <p>Business Name: RecordId</p>
     * 
     * <p>Other Business Name: RecordId</p>
     * 
     * <p>Relationship: COMT_MT301001CA.AnnotatedAct.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p>
     */
    public void setSubjectAnnotatedActId(Identifier subjectAnnotatedActId) {
        this.subjectAnnotatedActId.setValue(subjectAnnotatedActId);
    }

}
