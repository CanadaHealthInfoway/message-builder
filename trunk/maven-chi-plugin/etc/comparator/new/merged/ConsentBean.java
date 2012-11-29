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
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt470012ca.ControlsBean;
import ca.infoway.messagebuilder.model.common.rcmr_mt010001ca.ConsentsToBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT470012CA.ConsentEvent","RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private II consentFormNumber = new IIImpl();
    private CV<ActConsentType> consentType = new CVImpl<ActConsentType>();
    private BL consentRefusedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV<ActConsentInformationAccessReason> consentOverrideReason = new CVImpl<ActConsentInformationAccessReason>();
    private ConsentedToByBean author1;
    private PrescribedByBean author2;
    private ConsentsToBean component;
    private SubjectChoiceBean subject1SubjectChoice;
    private ControlsBean subject2 = new ControlsBean();

    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActConsentType getConsentType() {
        return this.consentType.getValue();
    }
    public void setConsentType(ActConsentType consentType) {
        this.consentType.setValue(consentType);
    }

    @Hl7XmlMapping({"negationInd"})
    public java.lang.Boolean getConsentRefusedIndicator() {
        return this.consentRefusedIndicator.getValue();
    }
    public void setConsentRefusedIndicator(java.lang.Boolean consentRefusedIndicator) {
        this.consentRefusedIndicator.setValue(consentRefusedIndicator);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }

    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }

    @Hl7XmlMapping({"author1"})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }

    @Hl7XmlMapping({"author2"})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }

    @Hl7XmlMapping({"component"})
    public ConsentsToBean getComponent() {
        return this.component;
    }
    public void setComponent(ConsentsToBean component) {
        this.component = component;
    }

    @Hl7XmlMapping({"subject1/subjectChoice"})
    public SubjectChoiceBean getSubject1SubjectChoice() {
        return this.subject1SubjectChoice;
    }
    public void setSubject1SubjectChoice(SubjectChoiceBean subject1SubjectChoice) {
        this.subject1SubjectChoice = subject1SubjectChoice;
    }

    @Hl7XmlMapping({"subject2"})
    public ControlsBean getSubject2() {
        return this.subject2;
    }
    public void setSubject2(ControlsBean subject2) {
        this.subject2 = subject2;
    }

}
