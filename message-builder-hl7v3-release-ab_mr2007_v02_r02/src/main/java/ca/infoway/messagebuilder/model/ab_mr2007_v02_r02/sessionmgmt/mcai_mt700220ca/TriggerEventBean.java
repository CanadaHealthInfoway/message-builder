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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.mcai_mt700220ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CausedBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.RefersToBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Trigger Event</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700220CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefersToBean<ACT> subject;
    private List<CausedBean> subjectOf = new ArrayList<CausedBean>();


    /**
     * <p>B:Event Identifier</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for retractions) and 
     * also indicates whether multiple interactions were caused by 
     * the same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p>These identifiers should be stored for use in 
     * 'retractions'. They should be stored in such a way that they 
     * are associated with the item that was modified by this 
     * event. For example, a system should be able to show the list 
     * of trigger event identifiers for the actions that have been 
     * recorded against a particular prescription.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>B:Event Identifier</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for retractions) and 
     * also indicates whether multiple interactions were caused by 
     * the same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p>These identifiers should be stored for use in 
     * 'retractions'. They should be stored in such a way that they 
     * are associated with the item that was modified by this 
     * event. For example, a system should be able to show the list 
     * of trigger event identifiers for the actions that have been 
     * recorded against a particular prescription.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>A:Event Type</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>A:Event Type</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>C:Event Effective Period</p>
     * 
     * <p>Indicates the time the change occurred. If not populated, 
     * the assumption is the same time the message was 
     * constructed.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>C:Event Effective Period</p>
     * 
     * <p>Indicates the time the change occurred. If not populated, 
     * the assumption is the same time the message was 
     * constructed.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>E:Event Reason</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>E:Event Reason</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"subject"})
    public RefersToBean<ACT> getSubject() {
        return this.subject;
    }

    public void setSubject(RefersToBean<ACT> subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<CausedBean> getSubjectOf() {
        return this.subjectOf;
    }

}
