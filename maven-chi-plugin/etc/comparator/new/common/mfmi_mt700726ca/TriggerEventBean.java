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
package ca.infoway.messagebuilder.model.common.mfmi_mt700726ca;

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
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.ReplacesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Trigger Event 
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent. 
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper. 
 * 
 * <p>Key to understanding what action a message represents. 
 */
@Hl7PartTypeMapping({"MFMI_MT700726CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<RR> extends MessagePartBean {

    private II eventIdentifier = new IIImpl();
    private CV<HL7TriggerEventCode> eventType = new CVImpl<HL7TriggerEventCode>();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV<ControlActReason> eventReason = new CVImpl<ControlActReason>();
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL cascadeResponsibilityIndicator = new BLImpl();
    private List<ReplacesBean> subjectRegistrationEventReplacementOf = new ArrayList<ReplacesBean>();
    private EHRRepositoryBean subjectRegistrationEventCustodianAssignedDevice = new EHRRepositoryBean();
    private RR subjectRegistrationEventSubjectRegisteredRole;

    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return this.eventType.getValue();
    }
    public void setEventType(HL7TriggerEventCode eventType) {
        this.eventType.setValue(eventType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEventEffectivePeriod() {
        return this.eventEffectivePeriod.getValue();
    }
    public void setEventEffectivePeriod(Interval<Date> eventEffectivePeriod) {
        this.eventEffectivePeriod.setValue(eventEffectivePeriod);
    }

    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }

    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

    @Hl7XmlMapping({"subject/contextConductionInd"})
    public java.lang.Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(java.lang.Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }

    @Hl7XmlMapping({"subject/registrationEvent/replacementOf"})
    public List<ReplacesBean> getSubjectRegistrationEventReplacementOf() {
        return this.subjectRegistrationEventReplacementOf;
    }

    @Hl7XmlMapping({"subject/registrationEvent/custodian/assignedDevice"})
    public EHRRepositoryBean getSubjectRegistrationEventCustodianAssignedDevice() {
        return this.subjectRegistrationEventCustodianAssignedDevice;
    }
    public void setSubjectRegistrationEventCustodianAssignedDevice(EHRRepositoryBean subjectRegistrationEventCustodianAssignedDevice) {
        this.subjectRegistrationEventCustodianAssignedDevice = subjectRegistrationEventCustodianAssignedDevice;
    }

    @Hl7XmlMapping({"subject/registrationEvent/subject/registeredRole"})
    public RR getSubjectRegistrationEventSubjectRegisteredRole() {
        return this.subjectRegistrationEventSubjectRegisteredRole;
    }
    public void setSubjectRegistrationEventSubjectRegisteredRole(RR subjectRegistrationEventSubjectRegisteredRole) {
        this.subjectRegistrationEventSubjectRegisteredRole = subjectRegistrationEventSubjectRegisteredRole;
    }

}
