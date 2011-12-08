/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.si.merged;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AssignedEntity_2Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.si.comt_mt300003ca.AnnotatedByBean;
import java.util.Set;



/**
 * <p>Comment</p>
 * 
 * <p>COMT_MT300001CA.Annotation: Comment</p>
 * 
 * <p><p>Identifies the comments to be recorded against a 
 * Patient's record.</p></p>
 * 
 * <p><p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, Immunization, etc) information.</p></p>
 * 
 * <p>COMT_MT300003CA.Annotation: Comment</p>
 * 
 * <p><p>Identifies the comments to be recorded against a 
 * Patient's record.</p></p>
 * 
 * <p><p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p></p>
 * 
 * <p>COMT_MT301001CA.Annotation: Comment</p>
 * 
 * <p><p>Identifies the comments to be recorded against a 
 * Patient's record.</p></p>
 * 
 * <p><p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT300001CA.Annotation","COMT_MT300003CA.Annotation","COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private II id = new IIImpl();
    private AssignedEntity_2Bean responsiblePartyAssignedEntity;
    private AnnotatedByBean author;
    private CreatedAtBean location;
    private CV languageCode = new CVImpl();
    private II subjectAnnotatedActId = new IIImpl();


    /**
     * <p>PatientNoteCategory</p>
     * 
     * <p>A:Patient Note Category</p>
     * 
     * <p><p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, etc.</p></p>
     * 
     * <p><p>Allows patient notes of different purposes and use, to 
     * be attached to a patient. Attribute is mandatory to ensure 
     * that patient notes are categorized accordingly. This 
     * attribute may also be used by DISs to enforce different 
     * access control to different types of notes.</p></p>
     * 
     * <p>Patient Note Category</p>
     * 
     * <p><p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, Immunization, etc</p></p>
     * 
     * <p><p>Allows patient notes of different purposes and use, to 
     * be attached to a patient. Attribute is mandatory to ensure 
     * that patient notes are categorized accordingly. This 
     * attribute may also be used by DISs to enforce different 
     * access control to different types of notes.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getCode() {
        return (ActPatientAnnotationCode) this.code.getValue();
    }
    public void setCode(ActPatientAnnotationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>C:Annotation Text</p>
     * 
     * <p><p>Free text comment to be attached to a record.</p></p>
     * 
     * <p><p>Allows a provider to attach arbitrary comments to 
     * clinical records (prescription, dispenses, lab results, 
     * allergies, etc) for communication. This attribute is 
     * mandatory because there's no point in having an annotation 
     * unless there's actually content in the note.</p></p>
     * 
     * <p>C:Patient Note Text</p>
     * 
     * <p><p>Free textual description of the patient note.</p></p>
     * 
     * <p><p>Allows a provider to attach comments to a patient as a 
     * whole or to the patient's profile (such as medication, lab. 
     * DI, etc). This attribute is mandatory because there's no 
     * point in having a patient note unless there's actually 
     * content in the note.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>RestrictedPatientAccess</p>
     * 
     * <p>D:Restricted Patient Access</p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p>D:Restricted Patient Access</p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows a provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is required 
     * because even if a jurisdiction doesn't support masking on 
     * the way in, it will need to need to communicate masked data 
     * returned from other jurisdictions.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is required 
     * because even if a jurisdiction doesn't support masking on 
     * the way in, it will need to need to communicate masked data 
     * returned from other jurisdictions.</p></p>
     * 
     * <p><p>Taboo allows the provider to request restricted access 
     * to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is required 
     * because even if a jurisdiction doesn't support masking on 
     * the way in, it will need to need to communicate masked data 
     * returned from other jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>PatientNoteId</p>
     * 
     * <p>B:Patient Note Id</p>
     * 
     * <p><p>Identifier of the patient note record.</p></p>
     * 
     * <p><p>Allows for the unique reference of a patient note and 
     * is therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p></p>
     * 
     * <p><p>Allows for the unique reference of a patient note and 
     * is therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public AssignedEntity_2Bean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(AssignedEntity_2Bean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public AnnotatedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AnnotatedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>WrittenIn</p>
     * 
     * <p>D:Written in</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>RecordId</p>
     * 
     * <p>A:Record Id</p>
     * 
     * <p><p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p></p>
     * 
     * <p><p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Identifier getSubjectAnnotatedActId() {
        return this.subjectAnnotatedActId.getValue();
    }
    public void setSubjectAnnotatedActId(Identifier subjectAnnotatedActId) {
        this.subjectAnnotatedActId.setValue(subjectAnnotatedActId);
    }

}
