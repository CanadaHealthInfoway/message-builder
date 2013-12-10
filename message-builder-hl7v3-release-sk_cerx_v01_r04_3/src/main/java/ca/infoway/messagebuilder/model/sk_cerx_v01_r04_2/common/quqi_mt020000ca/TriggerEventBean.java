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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.quqi_mt020000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged.QueryDefinitionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.ConsentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Trigger Event</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the reasonCode 
 * attribute in the definition of the interaction or the 
 * trigger events which are conveyed with this wrapper.</p>
 */
@Hl7PartTypeMapping({"QUQI_MT020000CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private ProviderBean dataEntererAssignedPerson;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private RecordedAtBean location;
    private QueryDefinitionBean<PL> queryByParameter;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private ConsentBean subjectOf2ConsentEvent;


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Used for audit purposes and is therefore mandatory.</p>
     * 
     * <p>Queries cannot be retracted, so this event identifier 
     * does not need to be locally persisted.</p>
     * 
     * <p><div>&nbsp;It will be stored</div> <div>by PIN and can be 
     * used to refer to this event in</div> <p>future 
     * transactions.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Used for audit purposes and is therefore mandatory.</p>
     * 
     * <p>Queries cannot be retracted, so this event identifier 
     * does not need to be locally persisted.</p>
     * 
     * <p><div>&nbsp;It will be stored</div> <div>by PIN and can be 
     * used to refer to this event in</div> <p>future 
     * transactions.&nbsp;</p></p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p><div>A CODE_INVAL error issue will be returned if 
     * this</div> <div>is a valid trigger event code but it is not 
     * the trigger</div> <p>event code associated with this 
     * interaction.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p><div>A CODE_INVAL error issue will be returned if 
     * this</div> <div>is a valid trigger event code but it is not 
     * the trigger</div> <p>event code associated with this 
     * interaction.&nbsp;</p></p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query occurred.</p>
     * 
     * <p>Allows identifying the reason for accessing information 
     * via a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p><div>Each message indicates the specific subdomain</div> 
     * <div>that must be sent. PIN will validate that</div> 
     * <div>the contents come from this domain. For</div> 
     * <div>messages with no domain, PIN will validate that</div> 
     * <p>no reason is being sent.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query occurred.</p>
     * 
     * <p>Allows identifying the reason for accessing information 
     * via a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p><div>Each message indicates the specific subdomain</div> 
     * <div>that must be sent. PIN will validate that</div> 
     * <div>the contents come from this domain. For</div> 
     * <div>messages with no domain, PIN will validate that</div> 
     * <p>no reason is being sent.&nbsp;</p></p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: Recorded By</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the person responsible for entering 
     * the</div> <div>query into the system. This should only be 
     * specified</div> <p>if different from the author.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"dataEnterer/assignedPerson"})
    public ProviderBean getDataEntererAssignedPerson() {
        return this.dataEntererAssignedPerson;
    }

    /**
     * <p>Business Name: Recorded By</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the person responsible for entering 
     * the</div> <div>query into the system. This should only be 
     * specified</div> <p>if different from the author.&nbsp;</p></p>
     */
    public void setDataEntererAssignedPerson(ProviderBean dataEntererAssignedPerson) {
        this.dataEntererAssignedPerson = dataEntererAssignedPerson;
    }


    /**
     * <p>Business Name: Recorded At</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the location where the record of this 
     * query</div> <div>was made. The may be different from the 
     * location</div> <p>where the query occurred.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Business Name: Recorded At</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the location where the record of this 
     * query</div> <div>was made. The may be different from the 
     * location</div> <p>where the query occurred.&nbsp;</p></p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryByParameter"})
    public QueryDefinitionBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryByParameter(QueryDefinitionBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }


    /**
     * <p>Business Name: Caused</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Identifies errors or warnings that are being 
     * managed</div> <p>as part of the current message.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }

}
