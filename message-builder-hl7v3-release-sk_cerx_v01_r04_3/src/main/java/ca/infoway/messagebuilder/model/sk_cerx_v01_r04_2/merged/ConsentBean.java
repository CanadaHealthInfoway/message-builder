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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt470000ca.AccessTypeBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.si.rcmr_mt010001ca.InformationAccessBean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p>COCT_MT470000CA.ConsentEvent: Consent</p>
 * 
 * <p>One and only one of author2 (Consenter) and author1 
 * (Provider) must be specified.</p><p>If author1 (provider) is 
 * specified, reason code must be specified.</p>
 * 
 * <p>One and only one of author2 (Consenter) and author1 
 * (Provider) must be specified.</p><p>If author1 (provider) is 
 * specified, reason code must be specified.</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis. May be required on a Prescription Request to indicate 
 * a keyword for DUR processing.</p>
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
 * <p>RCMR_MT010001CA.ConsentEvent: Consent</p>
 * 
 * <p>If code is INFA, then InformDefinition must be present, 
 * otherwise it must be absent</p><p>One and only one of 
 * author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p>
 * 
 * <p>If code is INFA, then InformDefinition must be present, 
 * otherwise it must be absent</p><p>One and only one of 
 * author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p>
 * 
 * <p>If code is INFA, then InformDefinition must be present, 
 * otherwise it must be absent</p><p>One and only one of 
 * author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.ConsentEvent","RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
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
     * <p>ConsentFormNumber</p>
     * 
     * <p>D:Consent Form Number</p>
     * 
     * <p>A unique identifier for a specific consent for a 
     * patient.</p>
     * 
     * <p>Authorization.formNumber</p>
     * 
     * <p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>ConsentFormNumber</p>
     * 
     * <p>D:Consent Form Number</p>
     * 
     * <p>A unique identifier for a specific consent for a 
     * patient.</p>
     * 
     * <p>Authorization.formNumber</p>
     * 
     * <p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>ConsentEffectiveAndEndTime</p>
     * 
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control</p>
     * 
     * <p><strong>CeRx defines this as 0..1 but the effective time 
     * is required in PIN so this is mandatory.</strong></p>
     * 
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>ConsentEffectiveAndEndTime</p>
     * 
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control</p>
     * 
     * <p><strong>CeRx defines this as 0..1 but the effective time 
     * is required in PIN so this is mandatory.</strong></p>
     * 
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p>Indicates the time that the consent will expire. 'Low' is 
     * effective time and 'High' is end time.</p>
     * 
     * <p>Authorization.endTime (high)</p>
     * 
     * <p>Most consents are not open-ended, to ensure the patient 
     * retains a level of control.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ConsentOverrideReason</p>
     * 
     * <p>E:Consent Override Reason</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules.</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     * 
     * <p>E:Consent Override Reason</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules or accessing information without consent.</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    /**
     * <p>ConsentOverrideReason</p>
     * 
     * <p>E:Consent Override Reason</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules.</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     * 
     * <p>E:Consent Override Reason</p>
     * 
     * <p>Indicates a reason for overriding a patient's consent 
     * rules or accessing information without consent.</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Authorization.reason 
     * (mnemonic)</p><p>Authorization.comment (original text)</p>
     * 
     * <p>Important for audit purposes</p>
     */
    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p>&nbsp;This uses COCT_MT050202CA &ndash; Patient 
     * Person&nbsp;Identified Confirmable.</p>
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
     * <p>(no business name)</p>
     * 
     * <p>&nbsp;This uses COCT_MT050202CA &ndash; Patient 
     * Person&nbsp;Identified Confirmable.</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>OverriddenBy</p>
     * 
     * <p>Overridden By</p>
     * 
     * <p>&nbsp;Indicates that information access was approved</p> 
     * <div>by a provider rather than a patient.</div>
     * 
     * <p><div>Either this must be specified or author1 must 
     * be&nbsp;specified or a MISSCOND error issue will be</div> 
     * <div>returned.</div></p>
     */
    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="COCT_MT470000CA.Author2"),
        @Hl7MapByPartType(name="author2", type="RCMR_MT010001CA.Author2")})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }

    /**
     * <p>OverriddenBy</p>
     * 
     * <p>Overridden By</p>
     * 
     * <p>&nbsp;Indicates that information access was approved</p> 
     * <div>by a provider rather than a patient.</div>
     * 
     * <p><div>Either this must be specified or author1 must 
     * be&nbsp;specified or a MISSCOND error issue will be</div> 
     * <div>returned.</div></p>
     */
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>ConsentedToBy</p>
     * 
     * <p>Consented To By</p>
     * 
     * <p>&nbsp;Indicates that the consent was provided by 
     * the&nbsp;patient or representative.</p> <div>&nbsp;</div>
     * 
     * <p><div>Either this must be specified or author2 must 
     * be&nbsp;specified or a MISSCOND error issue will be</div> 
     * <p>returned.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="RCMR_MT010001CA.Author"),
        @Hl7MapByPartType(name="author2", type="COCT_MT470000CA.Author")})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }

    /**
     * <p>ConsentedToBy</p>
     * 
     * <p>Consented To By</p>
     * 
     * <p>&nbsp;Indicates that the consent was provided by 
     * the&nbsp;patient or representative.</p> <div>&nbsp;</div>
     * 
     * <p><div>Either this must be specified or author2 must 
     * be&nbsp;specified or a MISSCOND error issue will be</div> 
     * <p>returned.&nbsp;</p></p>
     */
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }

    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }


    /**
     * <p>ConsentType</p>
     * 
     * <p>A:Consent Type</p>
     * 
     * <p>Indicates the type of consent being given: Information 
     * access or Information maintenance.</p>
     * 
     * <p>Distinguishes what type of consent is being dealt with 
     * and is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActConsentType getCode() {
        return (ActConsentType) this.code.getValue();
    }

    /**
     * <p>ConsentType</p>
     * 
     * <p>A:Consent Type</p>
     * 
     * <p>Indicates the type of consent being given: Information 
     * access or Information maintenance.</p>
     * 
     * <p>Distinguishes what type of consent is being dealt with 
     * and is therefore mandatory.</p>
     */
    public void setCode(ActConsentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>ConsentRefusedIndicator</p>
     * 
     * <p>B:Consent Refused Indicator</p>
     * 
     * <p>Must be either not present or non-null.</p>
     * 
     * <p>If true, indicates that consent has explicitly *not* been 
     * given.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>ConsentRefusedIndicator</p>
     * 
     * <p>B:Consent Refused Indicator</p>
     * 
     * <p>Must be either not present or non-null.</p>
     * 
     * <p>If true, indicates that consent has explicitly *not* been 
     * given.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     * 
     * <p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>ConsentsTo</p>
     * 
     * <p>Consents to</p>
     * 
     * <p>&nbsp;Describes the type of information access being</p> 
     * <div>consented to.</div>
     */
    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }

    /**
     * <p>ConsentsTo</p>
     * 
     * <p>Consents to</p>
     * 
     * <p>&nbsp;Describes the type of information access being</p> 
     * <div>consented to.</div>
     */
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }

}
