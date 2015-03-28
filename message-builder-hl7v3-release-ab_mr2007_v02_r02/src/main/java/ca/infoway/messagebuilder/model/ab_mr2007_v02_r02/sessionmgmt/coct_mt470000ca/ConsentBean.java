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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt470000ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ConsentedToByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>Business Name: Consent</p>
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
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private PatientBean subject1Patient;
    private ProviderBean author1AssignedPerson;
    private ConsentedToByBean author2;
    private AccessTypeBean subject2InformDefinition;


    /**
     * <p>Business Name: D:Consent Form Number</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: D:Consent Form Number</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: C:Consent Effective and End Time</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Consent Override Reason</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     */
    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: COCT_MT470000CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject1/patient"})
    public PatientBean getSubject1Patient() {
        return this.subject1Patient;
    }

    /**
     * <p>Relationship: COCT_MT470000CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject1Patient(PatientBean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    /**
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"author1/assignedPerson"})
    public ProviderBean getAuthor1AssignedPerson() {
        return this.author1AssignedPerson;
    }

    /**
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAuthor1AssignedPerson(ProviderBean author1AssignedPerson) {
        this.author1AssignedPerson = author1AssignedPerson;
    }


    /**
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }

    /**
     * <p>Relationship: COCT_MT470000CA.ConsentEvent.author2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>Relationship: COCT_MT470000CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }

    /**
     * <p>Relationship: COCT_MT470000CA.Subject2.informDefinition</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }

}
