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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.rcmr_mt010001on;

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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt050203on.PatientBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged.PrescribedByBean;
import java.util.Date;



/**
 * <p>Business Name: Consent</p>
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
@Hl7PartTypeMapping({"RCMR_MT010001ON.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private PatientBean subjectPatient;
    private ConsentedToByBean author1;
    private PrescribedByBean author2;
    private InformationAccessBean componentPermissionToInform;


    /**
     * <p>Business Name: D:Consent Form Number</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.id</p>
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
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.id</p>
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
     * <p>Business Name: A:Consent Type</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.code</p>
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
     * <p>Business Name: A:Consent Type</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.code</p>
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
     * <p>Business Name: B:Consent Refused Indicator</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.negationInd</p>
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
     * <p>Business Name: B:Consent Refused Indicator</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.negationInd</p>
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
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.effectiveTime</p>
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
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.effectiveTime</p>
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
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.reasonCode</p>
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
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.reasonCode</p>
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
     * <p>Relationship: RCMR_MT010001ON.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: RCMR_MT010001ON.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author1"})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }

    /**
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.author1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    /**
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author2"})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }

    /**
     * <p>Relationship: RCMR_MT010001ON.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>Relationship: 
     * RCMR_MT010001ON.Component.permissionToInform</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }

    /**
     * <p>Relationship: 
     * RCMR_MT010001ON.Component.permissionToInform</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }

}
