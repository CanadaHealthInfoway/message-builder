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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt470002ca;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.AccessTypeBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.SubjectChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RelatedPersonBean;
import java.util.Date;



/**
 * <p>Business Name: Consent</p>
 * 
 * <p>One and only one of author2 (Consenter) and author1 
 * (Provider) must be specified.</p>
 * 
 * <p>If author1 (provider) is specified, reason code must be 
 * specified.</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis. May be required on a Prescription Request to indicate 
 * a keyword for DUR processing.</p>
 * 
 * <p>The keywords will not be passed from prescriber to 
 * dispenser by the DIS.</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private SubjectChoice subject1SubjectChoice;
    private PrescribedByBean author1;
    private ConsentedToByBean author2;
    private AccessTypeBean subject2InformDefinition;


    /**
     * <p>Business Name: D:Consent Form Number</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.formNumber</p>
     * 
     * <p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p>
     * 
     * <p>A unique identifier for a specific consent for a 
     * patient.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: D:Consent Form Number</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.formNumber</p>
     * 
     * <p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p>
     * 
     * <p>A unique identifier for a specific consent for a 
     * patient.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control.</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control.</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.reason (mnemonic)</p>
     * 
     * <p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.reason (mnemonic)</p>
     * 
     * <p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules.</p>
     */
    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: COCT_MT470002CA.Subject.subjectChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject1/subjectChoice"})
    public SubjectChoice getSubject1SubjectChoice() {
        return this.subject1SubjectChoice;
    }

    /**
     * <p>Relationship: COCT_MT470002CA.Subject.subjectChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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


    /**
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author1"})
    public PrescribedByBean getAuthor1() {
        return this.author1;
    }

    /**
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor1(PrescribedByBean author1) {
        this.author1 = author1;
    }


    /**
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }

    /**
     * <p>Relationship: COCT_MT470002CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>Relationship: COCT_MT470002CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }

    /**
     * <p>Relationship: COCT_MT470002CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }

}
