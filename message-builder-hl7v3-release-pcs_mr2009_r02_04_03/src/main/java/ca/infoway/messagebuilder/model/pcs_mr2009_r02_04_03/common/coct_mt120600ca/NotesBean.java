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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt120600ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910107ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911102ca.ActingPerson;
import java.util.Date;



/**
 * <p>Business Name: Notes</p>
 * 
 * <p>Identified-confirmable is used on requests 
 * Identified-information is used on responses</p>
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
@Hl7PartTypeMapping({"COCT_MT120600CA.Annotation"})
@Hl7RootType
public class NotesBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private ST text = new STImpl();
    private TS authorTime = new TSImpl();
    private AssignedPerson authorAssignedPerson;


    /**
     * <p>Business Name: B: Note Text</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p><p>Language is supported to allow 
     * grouping or filtering comments based on language</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: B: Note Text</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p><p>Language is supported to allow 
     * grouping or filtering comments based on language</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: A: Note Timestamp</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies timing of the annotation for sorting and for 
     * audit purposes.</p><p>This attribute is mandatory because 
     * the time of creation of the annotation will always be 
     * known.</p>
     * 
     * <p>The date and time at which the note was posted.</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>Business Name: A: Note Timestamp</p>
     * 
     * <p>Relationship: COCT_MT120600CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies timing of the annotation for sorting and for 
     * audit purposes.</p><p>This attribute is mandatory because 
     * the time of creation of the annotation will always be 
     * known.</p>
     * 
     * <p>The date and time at which the note was posted.</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Relationship: COCT_MT120600CA.Author.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedPerson"})
    public AssignedPerson getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }

    /**
     * <p>Relationship: COCT_MT120600CA.Author.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910102ca.RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship1() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910102ca.RelatedPersonBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910102ca.RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship1() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910102ca.RelatedPersonBean);
    }

    public ActingPerson getAuthorAssignedPersonAsActingPerson1() {
        return this.authorAssignedPerson instanceof ActingPerson ? (ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson1() {
        return (this.authorAssignedPerson instanceof ActingPerson);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean getAuthorAssignedPersonAsAssignedEntity3() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity3() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean getAuthorAssignedPersonAsAssignedEntity4() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity4() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca.RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship2() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca.RelatedPersonBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca.RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship2() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca.RelatedPersonBean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson getAuthorAssignedPersonAsActingPerson2() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson2() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson);
    }

    public RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship4() {
        return this.authorAssignedPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship4() {
        return (this.authorAssignedPerson instanceof RelatedPersonBean);
    }

}
