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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ChangedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>HealthCondition</p>
 * 
 * <p>REPC_MT000014CA.ConditionEvent: Health Condition</p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>Necessary component of a person's overall profile. 
 * Helps with contraindication checking.</p></p>
 * 
 * <p>REPC_MT000010CA.ConditionEvent: Health Condition</p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>A record of a patient's health condition, as tracked 
 * over time. Examples include diseases, disabilities, 
 * pregnancy, lactation and other clinical conditions of 
 * interest.</p><p>Also known as &quot;Problem&quot; (from a 
 * 'problem list').</p></p>
 * 
 * <p><p>Necessary component of a person's overall profile. 
 * Helps with contraindication checking.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000010CA.ConditionEvent","REPC_MT000014CA.ConditionEvent"})
@Hl7RootType
public class HealthConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CD value = new CDImpl();
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private BL negationInd = new BLImpl();
    private ActingPerson responsiblePartyActingPerson;
    private ChangedByBean author;
    private ServiceLocationBean custodian1ServiceDeliveryLocation;
    private EHRRepositoryBean custodian2AssignedDevice;
    private List<OldConditionBean> predecessorOldCondition = new ArrayList<OldConditionBean>();
    private HealthConditionBean replacementOfConditionEvent;
    private NewConditionBean successorNewCondition;
    private AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private VersionInformationBean subjectOf3ControlActEvent;
    private BL subjectOf4AnnotationIndicator = new BLImpl(false);


    /**
     * <p>ConditionIdentifier</p>
     * 
     * <p>A:Condition Identifier</p>
     * 
     * <p></p><p>The identifier applies to this 
     * &quot;instance&quot; of the condition. For example, multiple 
     * pregnancies would each be treated as distinct conditions, 
     * each with a unique id.</p></p>
     * 
     * <p></p><p>The identifier applies to this 
     * &quot;instance&quot; of the condition. For example, multiple 
     * pregnancies would each be treated as distinct conditions, 
     * each with a unique id.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>ConditionType</p>
     * 
     * <p>B: Condition Type</p>
     * 
     * <p><p>Code is fixed DX if not using SNOMED;</p></p>
     * 
     * <p><p>Designates the concept in DiagnosisValue as a 
     * Diagnosis</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     * 
     * <p></p><p>Since all diagnosis concepts can be represented in 
     * a single field, this domain is a fixed value</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>ConditionStatus</p>
     * 
     * <p>C:Condition Status</p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p><p>Indicates whether the condition is still being 
     * monitored as relevant to the patient's health ('active') or 
     * whether the condition is no longer considered a relevant 
     * 'problem' ('completed'). It may also be 'obsolete' in 
     * circumstances where the record has been replaced.</p><p>Note 
     * that a problem may be considered 'active' even if the 
     * underlying condition is no longer affecting the patient. For 
     * example, for a patient who was recently pregnant, the 
     * pregnancy has ended, but the pregnancy would still be an 
     * 'active' condition record because of it's ongoing impact on 
     * the patient's healthcare situation.</p><p>To convey the 
     * actual clinical status of the condition, use SNOMED 
     * post-coordination in the Condition attribute.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>ConditionTimePeriod</p>
     * 
     * <p>G: Condition Time Period</p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p><p>The date on which the condition first began and when 
     * it ended.</p><p>For ongoing conditions such as chronic 
     * diseases, the upper boundary may be unknown.</p><p>For 
     * transient conditions such as pregnancy, lactation, etc; the 
     * upper boundary of the period would usually be specified to 
     * signify the end of the condition.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ConditionMaskingIndicators</p>
     * 
     * <p>F: Condition Masking Indicators</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Condition</p>
     * 
     * <p>K:Condition</p>
     * 
     * <p><p>A code indicating the specific condition. E.g. 
     * Hypertension, Pregnancy.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    /**
     * <p>RefutedIndicator</p>
     * 
     * <p>E: Refuted Indicator</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"custodian1/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian1ServiceDeliveryLocation() {
        return this.custodian1ServiceDeliveryLocation;
    }
    public void setCustodian1ServiceDeliveryLocation(ServiceLocationBean custodian1ServiceDeliveryLocation) {
        this.custodian1ServiceDeliveryLocation = custodian1ServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"custodian2/assignedDevice"})
    public EHRRepositoryBean getCustodian2AssignedDevice() {
        return this.custodian2AssignedDevice;
    }
    public void setCustodian2AssignedDevice(EHRRepositoryBean custodian2AssignedDevice) {
        this.custodian2AssignedDevice = custodian2AssignedDevice;
    }


    @Hl7XmlMapping({"predecessor/oldCondition"})
    public List<OldConditionBean> getPredecessorOldCondition() {
        return this.predecessorOldCondition;
    }


    @Hl7XmlMapping({"replacementOf/conditionEvent"})
    public HealthConditionBean getReplacementOfConditionEvent() {
        return this.replacementOfConditionEvent;
    }
    public void setReplacementOfConditionEvent(HealthConditionBean replacementOfConditionEvent) {
        this.replacementOfConditionEvent = replacementOfConditionEvent;
    }


    @Hl7XmlMapping({"successor/newCondition"})
    public NewConditionBean getSuccessorNewCondition() {
        return this.successorNewCondition;
    }
    public void setSuccessorNewCondition(NewConditionBean successorNewCondition) {
        this.successorNewCondition = successorNewCondition;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public AllergyIntoleranceStatusChangesBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(AllergyIntoleranceStatusChangesBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"subjectOf3/controlActEvent"})
    public VersionInformationBean getSubjectOf3ControlActEvent() {
        return this.subjectOf3ControlActEvent;
    }
    public void setSubjectOf3ControlActEvent(VersionInformationBean subjectOf3ControlActEvent) {
        this.subjectOf3ControlActEvent = subjectOf3ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }

}
