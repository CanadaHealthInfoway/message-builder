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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt470000ca.AccessTypeBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.rcmr_mt010001ca.InformationAccessBean;
import java.util.Date;



/**
 * <p>Business Name: Consent</p>
 * 
 * <p>COCT_MT470000CA.ConsentEvent: Consent</p>
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
 * 
 * <p>RCMR_MT010001CA.ConsentEvent: Consent</p>
 * 
 * <p>If code is INFA, then InformDefinition must be present, 
 * otherwise it must be absent</p>
 * 
 * <p>One and only one of author1 (Consenter) and author2 
 * (Provider) must be specified</p>
 * 
 * <p>If author2 (provider) is specified, reasonCode must be 
 * specified</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.ConsentEvent","RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private PatientBean subjectPatient;
    private PrescribedByBean author2;
    private ConsentedToByBean author1;
    private AccessTypeBean subject2InformDefinition;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private InformationAccessBean componentPermissionToInform;


    /**
     * <p>Business Name: ConsentFormNumber</p>
     * 
     * <p>Un-merged Business Name: ConsentFormNumber</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.id</p>
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
     * 
     * <p>Un-merged Business Name: ConsentFormNumber</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.id</p>
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
     * <p>Business Name: ConsentFormNumber</p>
     * 
     * <p>Un-merged Business Name: ConsentFormNumber</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.id</p>
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
     * 
     * <p>Un-merged Business Name: ConsentFormNumber</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.id</p>
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
     * <p>Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.effectiveTime</p>
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
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.effectiveTime</p>
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
     * 
     * <p>Un-merged Business Name: ConsentEffectiveAndEndTime</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: ConsentOverrideReason</p>
     * 
     * <p>Un-merged Business Name: ConsentOverrideReason</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.reasonCode</p>
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
     * 
     * <p>Un-merged Business Name: ConsentOverrideReason</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.reasonCode</p>
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
     * rules or accessing information without consent.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: ConsentOverrideReason</p>
     * 
     * <p>Un-merged Business Name: ConsentOverrideReason</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.reasonCode</p>
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
     * 
     * <p>Un-merged Business Name: ConsentOverrideReason</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.reasonCode</p>
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
     * rules or accessing information without consent.</p>
     */
    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient","subject1/patient"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subject", type="RCMR_MT010001CA.Subject"),
        @Hl7MapByPartType(name="subject/patient", type="COCT_MT050203CA.Patient"),
        @Hl7MapByPartType(name="subject1", type="COCT_MT470000CA.Subject"),
        @Hl7MapByPartType(name="subject1/patient", type="COCT_MT050202CA.Patient")})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="COCT_MT470000CA.Author2"),
        @Hl7MapByPartType(name="author2", type="RCMR_MT010001CA.Author2")})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="RCMR_MT010001CA.Author"),
        @Hl7MapByPartType(name="author2", type="COCT_MT470000CA.Author")})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }


    /**
     * <p>Business Name: ConsentType</p>
     * 
     * <p>Un-merged Business Name: ConsentType</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes what type of consent is being dealt with 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the type of consent being given: Information 
     * access or Information maintenance.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActConsentType getCode() {
        return (ActConsentType) this.code.getValue();
    }

    /**
     * <p>Business Name: ConsentType</p>
     * 
     * <p>Un-merged Business Name: ConsentType</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes what type of consent is being dealt with 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the type of consent being given: Information 
     * access or Information maintenance.</p>
     */
    public void setCode(ActConsentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ConsentRefusedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConsentRefusedIndicator</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Must be either not present or non-null.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     * 
     * <p>If true, indicates that consent has explicitly *not* been 
     * given.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: ConsentRefusedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConsentRefusedIndicator</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.ConsentEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Must be either not present or non-null.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     * 
     * <p>If true, indicates that consent has explicitly *not* been 
     * given.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * RCMR_MT010001CA.Component.permissionToInform</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * RCMR_MT010001CA.Component.permissionToInform</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }

}
