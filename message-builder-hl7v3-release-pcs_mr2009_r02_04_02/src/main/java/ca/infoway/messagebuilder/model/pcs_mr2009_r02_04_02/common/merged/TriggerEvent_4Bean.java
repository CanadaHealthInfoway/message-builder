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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>TriggerEvent</p>
 * 
 * <p>MFMI_MT700726CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 * 
 * <p>MFMI_MT700717CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700717CA.ControlActEvent","MFMI_MT700726CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_4Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private II eventIdentifier = new IIImpl();
    private CV eventType = new CVImpl();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV eventReason = new CVImpl();
    private CE messageLanguage = new CEImpl();
    private RefersTo_3Bean<RR> subject;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p><p>A unique identifier for this particular event assigned 
     * by the system in which the event occurred.</p></p>
     * 
     * <p><p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p></p>
     * 
     * <p><p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone). The identifier must be unique and 
     * different from the event identifier that is present on the 
     * request - it must be generated by the responding 
     * application.</p></p>
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
     * 
     * <p><p>Identifies the trigger event that occurred.</p></p>
     * 
     * <p><p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p></p>
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
     * 
     * <p><p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p></p>
     * 
     * <p><p>The time an event becomes effective may differ from 
     * the time the event is recorded (i.e. it may be in the future 
     * or the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p></p>
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
     * 
     * <p><p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p></p>
     * 
     * <p><p>Allows identifying a reason for a specific action, 
     * such as 'reason for hold' or 'reason for accessing 
     * information'.</p></p>
     * 
     * <p><p>The domain associated with this attribute will vary 
     * for each interaction and will be noted as part of the 
     * interaction description.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return (ControlActReason) this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }


    /**
     * <p>MessageLanguage</p>
     * 
     * <p>Message Language</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getMessageLanguage() {
        return (HumanLanguage) this.messageLanguage.getValue();
    }
    public void setMessageLanguage(HumanLanguage messageLanguage) {
        this.messageLanguage.setValue(messageLanguage);
    }


    @Hl7XmlMapping({"subject"})
    public RefersTo_3Bean<RR> getSubject() {
        return this.subject;
    }
    public void setSubject(RefersTo_3Bean<RR> subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
