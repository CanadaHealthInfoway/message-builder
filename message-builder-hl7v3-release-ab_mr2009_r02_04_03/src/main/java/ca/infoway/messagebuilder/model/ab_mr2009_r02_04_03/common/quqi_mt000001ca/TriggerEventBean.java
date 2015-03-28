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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.quqi_mt000001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



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
@Hl7PartTypeMapping({"QUQI_MT000001CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private CE languageCode = new CEImpl();
    private II queryContinuationQueryId = new IIImpl();
    private INT queryContinuationStartResultNumber = new INTImpl();
    private INT queryContinuationContinuationQuantity = new INTImpl();


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.id</p>
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
     * the system in which the event occurred.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.id</p>
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
     * the system in which the event occurred.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.code</p>
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
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.code</p>
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
     * QUQI_MT000001CA.ControlActEvent.effectiveTime</p>
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
     * QUQI_MT000001CA.ControlActEvent.effectiveTime</p>
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
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.reasonCode</p>
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
     * <p>Relationship: QUQI_MT000001CA.ControlActEvent.reasonCode</p>
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
     * <p>Business Name: Message Language</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.ControlActEvent.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: Message Language</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.ControlActEvent.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Business Name: H:Query Identifier</p>
     * 
     * <p>Relationship: QUQI_MT000001CA.QueryContinuation.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Links to the query for which continuation is desired. 
     * Needed to ensure that the query is not re-executed, as the 
     * results may have changed. As a result, the attribute is 
     * mandatory.</p>
     * 
     * <p>Unique number for the query to be continued.</p>
     */
    @Hl7XmlMapping({"queryContinuation/queryId"})
    public Identifier getQueryContinuationQueryId() {
        return this.queryContinuationQueryId.getValue();
    }

    /**
     * <p>Business Name: H:Query Identifier</p>
     * 
     * <p>Relationship: QUQI_MT000001CA.QueryContinuation.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Links to the query for which continuation is desired. 
     * Needed to ensure that the query is not re-executed, as the 
     * results may have changed. As a result, the attribute is 
     * mandatory.</p>
     * 
     * <p>Unique number for the query to be continued.</p>
     */
    public void setQueryContinuationQueryId(Identifier queryContinuationQueryId) {
        this.queryContinuationQueryId.setValue(queryContinuationQueryId);
    }


    /**
     * <p>Business Name: I:Start Position</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.QueryContinuation.startResultNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what point the query should continue from and 
     * is therefore mandatory.</p>
     * 
     * <p>Indicates the record number at which to start the 
     * returned result set.</p>
     */
    @Hl7XmlMapping({"queryContinuation/startResultNumber"})
    public Integer getQueryContinuationStartResultNumber() {
        return this.queryContinuationStartResultNumber.getValue();
    }

    /**
     * <p>Business Name: I:Start Position</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.QueryContinuation.startResultNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what point the query should continue from and 
     * is therefore mandatory.</p>
     * 
     * <p>Indicates the record number at which to start the 
     * returned result set.</p>
     */
    public void setQueryContinuationStartResultNumber(Integer queryContinuationStartResultNumber) {
        this.queryContinuationStartResultNumber.setValue(queryContinuationStartResultNumber);
    }


    /**
     * <p>Business Name: J:Query Limit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.QueryContinuation.continuationQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an application to control the number of returned 
     * records. If not specified, the EHR may apply a default 
     * limit.</p>
     * 
     * <p>Indicates how many records should be returned for this 
     * query.</p>
     */
    @Hl7XmlMapping({"queryContinuation/continuationQuantity"})
    public Integer getQueryContinuationContinuationQuantity() {
        return this.queryContinuationContinuationQuantity.getValue();
    }

    /**
     * <p>Business Name: J:Query Limit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT000001CA.QueryContinuation.continuationQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an application to control the number of returned 
     * records. If not specified, the EHR may apply a default 
     * limit.</p>
     * 
     * <p>Indicates how many records should be returned for this 
     * query.</p>
     */
    public void setQueryContinuationContinuationQuantity(Integer queryContinuationContinuationQuantity) {
        this.queryContinuationContinuationQuantity.setValue(queryContinuationContinuationQuantity);
    }

}
