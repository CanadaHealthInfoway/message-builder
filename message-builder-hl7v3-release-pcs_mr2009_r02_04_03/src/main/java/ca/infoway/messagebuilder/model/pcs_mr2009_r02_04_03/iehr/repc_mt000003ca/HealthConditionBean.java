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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt000003ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.OldConditionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Health Condition</p>
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
@Hl7PartTypeMapping({"REPC_MT000003CA.ConditionEvent"})
@Hl7RootType
public class HealthConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CD value = new CDImpl();
    private ActingPerson informantActingPerson;
    private List<OldConditionBean> predecessorOldCondition = new ArrayList<OldConditionBean>();
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
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


    /**
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
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareWorkerBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public Patient_2Bean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof Patient_2Bean ? (Patient_2Bean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof Patient_2Bean);
    }


    @Hl7XmlMapping({"predecessor/oldCondition"})
    public List<OldConditionBean> getPredecessorOldCondition() {
        return this.predecessorOldCondition;
    }


    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
