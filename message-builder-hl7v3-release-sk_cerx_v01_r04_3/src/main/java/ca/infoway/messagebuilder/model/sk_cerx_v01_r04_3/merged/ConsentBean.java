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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt470000ca.AccessTypeBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.si.rcmr_mt010001ca.InformationAccessBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT470000CA.ConsentEvent","RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private II consentFormNumber = new IIImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private PatientBean subjectPatient;
    private PrescribedByBean author2;
    private ConsentedToByBean author1;
    private AccessTypeBean subject2InformDefinition;
    private CV consentType = new CVImpl();
    private BL consentRefusedIndicator = new BLImpl();
    private InformationAccessBean componentPermissionToInform;


    /**
     * <p>ConsentFormNumber</p>
     * 
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
     * <p>ConsentEffectiveAndEndTime</p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p><strong>CeRx defines this as 0..1 but the effective 
     * time is required in PIN so this is mandatory.</strong></p></p>
     * 
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
     * <p>ConsentOverrideReason</p>
     * 
     * <p>E:Consent Override Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    @Hl7XmlMapping({"subject/patient","subject1/patient"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subject", type="RCMR_MT010001CA.Subject"),
        @Hl7MapByPartType(name="subject/patient", type="COCT_MT050203CA.Patient"),
        @Hl7MapByPartType(name="subject1", type="COCT_MT470000CA.Subject"),
        @Hl7MapByPartType(name="subject1/patient", type="COCT_MT050202CA.Patient")})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="COCT_MT470000CA.Author2"),
        @Hl7MapByPartType(name="author2", type="RCMR_MT010001CA.Author2")})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }


    @Hl7XmlMapping({"author1","author2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author1", type="RCMR_MT010001CA.Author"),
        @Hl7MapByPartType(name="author2", type="COCT_MT470000CA.Author")})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }
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
     */
    @Hl7XmlMapping({"code"})
    public ActConsentType getConsentType() {
        return (ActConsentType) this.consentType.getValue();
    }
    public void setConsentType(ActConsentType consentType) {
        this.consentType.setValue(consentType);
    }


    /**
     * <p>ConsentRefusedIndicator</p>
     * 
     * <p>B:Consent Refused Indicator</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getConsentRefusedIndicator() {
        return this.consentRefusedIndicator.getValue();
    }
    public void setConsentRefusedIndicator(Boolean consentRefusedIndicator) {
        this.consentRefusedIndicator.setValue(consentRefusedIndicator);
    }


    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }

}
