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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT470002CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II consentFormNumber = new IIImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private SubjectChoice subject1SubjectChoice;
    private PrescribedByBean author1;
    private ConsentedToByBean author2;
    private AccessTypeBean subject2InformDefinition;


    /**
     * <p>D:Consent Form Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }


    /**
     * <p>C:Consent Effective and End Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }


    /**
     * <p>E:Consent Override Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    @Hl7XmlMapping({"subject1/subjectChoice"})
    public SubjectChoice getSubject1SubjectChoice() {
        return this.subject1SubjectChoice;
    }
    public void setSubject1SubjectChoice(SubjectChoice subject1SubjectChoice) {
        this.subject1SubjectChoice = subject1SubjectChoice;
    }

    public PatientBean getSubject1SubjectChoiceAsPatient1() {
        return this.subject1SubjectChoice instanceof PatientBean ? (PatientBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsPatient1() {
        return (this.subject1SubjectChoice instanceof PatientBean);
    }

    public HealthcareWorkerBean getSubject1SubjectChoiceAsAssignedEntity1() {
        return this.subject1SubjectChoice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsAssignedEntity1() {
        return (this.subject1SubjectChoice instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getSubject1SubjectChoiceAsAssignedEntity2() {
        return this.subject1SubjectChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsAssignedEntity2() {
        return (this.subject1SubjectChoice instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getSubject1SubjectChoiceAsPersonalRelationship() {
        return this.subject1SubjectChoice instanceof RelatedPersonBean ? (RelatedPersonBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsPersonalRelationship() {
        return (this.subject1SubjectChoice instanceof RelatedPersonBean);
    }

    public ActingPerson getSubject1SubjectChoiceAsActingPerson() {
        return this.subject1SubjectChoice instanceof ActingPerson ? (ActingPerson) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsActingPerson() {
        return (this.subject1SubjectChoice instanceof ActingPerson);
    }


    @Hl7XmlMapping({"author1"})
    public PrescribedByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(PrescribedByBean author1) {
        this.author1 = author1;
    }


    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }


    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }

}
