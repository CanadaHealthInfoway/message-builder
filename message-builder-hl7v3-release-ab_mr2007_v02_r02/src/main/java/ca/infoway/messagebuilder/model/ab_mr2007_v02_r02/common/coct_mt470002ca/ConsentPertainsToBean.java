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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AssignedEntity_1Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AssignedEntity_2Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.SubjectChoice;



/**
 * <p>*a:consent pertains to</p>
 * 
 * <p><p>The patient's record the consent is associated 
 * with.</p></p>
 * 
 * <p><p>Essential for knowing what patient the consent is for, 
 * and therefore mandatory.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.Subject"})
public class ConsentPertainsToBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private SubjectChoice subjectChoice;


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    @Hl7XmlMapping({"subjectChoice"})
    public SubjectChoice getSubjectChoice() {
        return this.subjectChoice;
    }
    public void setSubjectChoice(SubjectChoice subjectChoice) {
        this.subjectChoice = subjectChoice;
    }

    public PatientBean getSubjectChoiceAsPatient1() {
        return this.subjectChoice instanceof PatientBean ? (PatientBean) this.subjectChoice : null;
    }
    public boolean hasSubjectChoiceAsPatient1() {
        return (this.subjectChoice instanceof PatientBean);
    }

    public AssignedEntity_1Bean getSubjectChoiceAsAssignedEntity1() {
        return this.subjectChoice instanceof AssignedEntity_1Bean ? (AssignedEntity_1Bean) this.subjectChoice : null;
    }
    public boolean hasSubjectChoiceAsAssignedEntity1() {
        return (this.subjectChoice instanceof AssignedEntity_1Bean);
    }

    public AssignedEntity_2Bean getSubjectChoiceAsAssignedEntity2() {
        return this.subjectChoice instanceof AssignedEntity_2Bean ? (AssignedEntity_2Bean) this.subjectChoice : null;
    }
    public boolean hasSubjectChoiceAsAssignedEntity2() {
        return (this.subjectChoice instanceof AssignedEntity_2Bean);
    }

    public RelatedPersonBean getSubjectChoiceAsPersonalRelationship() {
        return this.subjectChoice instanceof RelatedPersonBean ? (RelatedPersonBean) this.subjectChoice : null;
    }
    public boolean hasSubjectChoiceAsPersonalRelationship() {
        return (this.subjectChoice instanceof RelatedPersonBean);
    }

    public ActingPerson getSubjectChoiceAsActingPerson() {
        return this.subjectChoice instanceof ActingPerson ? (ActingPerson) this.subjectChoice : null;
    }
    public boolean hasSubjectChoiceAsActingPerson() {
        return (this.subjectChoice instanceof ActingPerson);
    }

}
