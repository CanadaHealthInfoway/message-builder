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
package ca.infoway.messagebuilder.model.merged;

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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"COMT_MT300001CA.Annotation","COMT_MT300003CA.Annotation","COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private CV<ActPatientAnnotationCode> patientNoteCategory = new CVImpl<ActPatientAnnotationCode>();
    private ST patientNoteText = new STImpl();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> restrictedPatientAccess = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private II patientNoteId = new IIImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author = new CreatedByBean();
    private CreatedAtBean location = new CreatedAtBean();
    private CV<HumanLanguage> writtenIn = new CVImpl<HumanLanguage>();
    private II recordId = new IIImpl();

    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getPatientNoteCategory() {
        return this.patientNoteCategory.getValue();
    }
    public void setPatientNoteCategory(ActPatientAnnotationCode patientNoteCategory) {
        this.patientNoteCategory.setValue(patientNoteCategory);
    }

    @Hl7XmlMapping({"text"})
    public java.lang.String getPatientNoteText() {
        return this.patientNoteText.getValue();
    }
    public void setPatientNoteText(java.lang.String patientNoteText) {
        this.patientNoteText.setValue(patientNoteText);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getRestrictedPatientAccess() {
        return this.restrictedPatientAccess.rawSet();
    }

    @Hl7XmlMapping({"id"})
    public Identifier getPatientNoteId() {
        return this.patientNoteId.getValue();
    }
    public void setPatientNoteId(Identifier patientNoteId) {
        this.patientNoteId.setValue(patientNoteId);
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getWrittenIn() {
        return this.writtenIn.getValue();
    }
    public void setWrittenIn(HumanLanguage writtenIn) {
        this.writtenIn.setValue(writtenIn);
    }

    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Identifier getRecordId() {
        return this.recordId.getValue();
    }
    public void setRecordId(Identifier recordId) {
        this.recordId.setValue(recordId);
    }

}
