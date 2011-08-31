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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt120600ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT120600CA.Annotation"})
@Hl7RootType
public class NotesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private ST noteText = new STImpl();
    private TS noteTimestamp = new TSImpl();
    private AssignedPerson authorAssignedPerson;


    /**
     * <p>B: Note Text</p>
     */
    @Hl7XmlMapping({"text"})
    public String getNoteText() {
        return this.noteText.getValue();
    }
    public void setNoteText(String noteText) {
        this.noteText.setValue(noteText);
    }


    /**
     * <p>A: Note Timestamp</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getNoteTimestamp() {
        return this.noteTimestamp.getValue();
    }
    public void setNoteTimestamp(Date noteTimestamp) {
        this.noteTimestamp.setValue(noteTimestamp);
    }


    @Hl7XmlMapping({"author/assignedPerson"})
    public AssignedPerson getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }
    public void setAuthorAssignedPerson(AssignedPerson authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }

    public HealthcareWorkerBean getAuthorAssignedPersonAsAssignedEntity1() {
        return this.authorAssignedPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity1() {
        return (this.authorAssignedPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getAuthorAssignedPersonAsAssignedEntity2() {
        return this.authorAssignedPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity2() {
        return (this.authorAssignedPerson instanceof HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship1() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean ? (ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship1() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson getAuthorAssignedPersonAsActingPerson1() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson ? (ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson1() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson);
    }

    public HealthcareWorkerBean getAuthorAssignedPersonAsAssignedEntity3() {
        return this.authorAssignedPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity3() {
        return (this.authorAssignedPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getAuthorAssignedPersonAsAssignedEntity4() {
        return this.authorAssignedPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity4() {
        return (this.authorAssignedPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship2() {
        return this.authorAssignedPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship2() {
        return (this.authorAssignedPerson instanceof RelatedPersonBean);
    }

    public ActingPerson getAuthorAssignedPersonAsActingPerson2() {
        return this.authorAssignedPerson instanceof ActingPerson ? (ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson2() {
        return (this.authorAssignedPerson instanceof ActingPerson);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship4() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean ? (ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship4() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean);
    }

}