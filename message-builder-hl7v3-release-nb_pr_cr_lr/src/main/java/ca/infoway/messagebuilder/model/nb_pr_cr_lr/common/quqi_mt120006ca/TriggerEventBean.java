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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.quqi_mt120006ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260022ca.IssuesBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt470002ca.ConsentBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged.Patient;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged.QueryAckBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.CareCompositionsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Trigger Event</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 */
@Hl7PartTypeMapping({"QUQI_MT120006CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<ACT,PL> extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private CE languageCode = new CEImpl();
    private Patient recordTargetPatient1;
    private List<RefersTo_1Bean<ACT>> subject = new ArrayList<RefersTo_1Bean<ACT>>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private ConsentBean subjectOf2ConsentEvent;
    private List<CareCompositionsBean> componentOf = new ArrayList<CareCompositionsBean>();
    private QueryAckBean queryAck;
    private QueryByParameterBean<PL> queryByParameter;


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred. The identifier must 
     * be unique and different from the event identifier that is 
     * present on the request - it must be generated by the 
     * responding application.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred. The identifier must 
     * be unique and different from the event identifier that is 
     * present on the request - it must be generated by the 
     * responding application.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Event Effective Period</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Event Effective Period</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient1"})
    public Patient getRecordTargetPatient1() {
        return this.recordTargetPatient1;
    }

    /**
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRecordTargetPatient1(Patient recordTargetPatient1) {
        this.recordTargetPatient1 = recordTargetPatient1;
    }

    public PatientBean getRecordTargetPatient1AsPatient1() {
        return this.recordTargetPatient1 instanceof PatientBean ? (PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient1() {
        return (this.recordTargetPatient1 instanceof PatientBean);
    }

    public ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207ca.PatientBean getRecordTargetPatient1AsPatient2() {
        return this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207ca.PatientBean ? (ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207ca.PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient2() {
        return (this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207ca.PatientBean);
    }

    public ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050201ca.PatientBean getRecordTargetPatient1AsPatient3() {
        return this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050201ca.PatientBean ? (ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050201ca.PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient3() {
        return (this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050201ca.PatientBean);
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1000)</p>
     */
    @Hl7XmlMapping({"subject"})
    public List<RefersTo_1Bean<ACT>> getSubject() {
        return this.subject;
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }

    /**
     * <p>Relationship: QUQI_MT120006CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.componentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public List<CareCompositionsBean> getComponentOf() {
        return this.componentOf;
    }


    /**
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.queryAck</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryAck"})
    public QueryAckBean getQueryAck() {
        return this.queryAck;
    }

    /**
     * <p>Relationship: QUQI_MT120006CA.ControlActEvent.queryAck</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryAck(QueryAckBean queryAck) {
        this.queryAck = queryAck;
    }


    /**
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT120006CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}