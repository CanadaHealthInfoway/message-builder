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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"QUQI_MT120006CA.ControlActEvent","QUQI_MT120008CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_5Bean<ACT,PL> extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private List<RefersTo_1Bean<ACT>> subject = new ArrayList<RefersTo_1Bean<ACT>>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private AuthorizedByBean subjectOf2;
    private QueryAckBean queryAck;
    private QueryByParameterBean<PL> queryByParameter;
    private RecordTargetBean recordTarget;
    private List<CareCompositionsBean> componentOf = new ArrayList<CareCompositionsBean>();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }


    /**
     * <p>EventType</p>
     * 
     * <p>A:Event Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return (HL7TriggerEventCode) this.eventType.getValue();
    }
    public void setEventType(HL7TriggerEventCode eventType) {
        this.eventType.setValue(eventType);
    }


    /**
     * <p>EventEffectivePeriod</p>
     * 
     * <p>C:Event Effective Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEventEffectivePeriod() {
        return this.eventEffectivePeriod.getValue();
    }
    public void setEventEffectivePeriod(Interval<Date> eventEffectivePeriod) {
        this.eventEffectivePeriod.setValue(eventEffectivePeriod);
    }


    /**
     * <p>EventReason</p>
     * 
     * <p>E:Event Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return (ControlActReason) this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }


    @Hl7XmlMapping({"subject"})
    public List<RefersTo_1Bean<ACT>> getSubject() {
        return this.subject;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public AuthorizedByBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(AuthorizedByBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }


    @Hl7XmlMapping({"queryAck"})
    public QueryAckBean getQueryAck() {
        return this.queryAck;
    }
    public void setQueryAck(QueryAckBean queryAck) {
        this.queryAck = queryAck;
    }


    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }


    @Hl7XmlMapping({"recordTarget"})
    public RecordTargetBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(RecordTargetBean recordTarget) {
        this.recordTarget = recordTarget;
    }


    @Hl7XmlMapping({"componentOf"})
    public List<CareCompositionsBean> getComponentOf() {
        return this.componentOf;
    }

}
