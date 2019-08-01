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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700751ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240012ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt260012ca.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt470012ca.ConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.AuthenticationTokenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.EntererChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
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
@Hl7PartTypeMapping({"MFMI_MT700751CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private CE languageCode = new CEImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedBy_2Bean author;
    private EntererChoice dataEntererEntererChoice;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private ConsentBean subjectOf1ConsentEvent;
    private List<IssuesBean> subjectOf2DetectedIssueEvent = new ArrayList<IssuesBean>();
    private QueryByParameterBean<PL> queryByParameter;


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone). The identifier must be unique and 
     * different from the event identifier that is present on the 
     * request - it must be generated by the responding 
     * application.</p>
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
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone). The identifier must be unique and 
     * different from the event identifier that is present on the 
     * request - it must be generated by the responding 
     * application.</p>
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
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.code</p>
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
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.code</p>
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
     * MFMI_MT700751CA.ControlActEvent.effectiveTime</p>
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
     * MFMI_MT700751CA.ControlActEvent.effectiveTime</p>
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
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.reasonCode</p>
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
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.reasonCode</p>
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
     * MFMI_MT700751CA.ControlActEvent.languageCode</p>
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
     * MFMI_MT700751CA.ControlActEvent.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public CreatedBy_2Bean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: MFMI_MT700751CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(CreatedBy_2Bean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: MFMI_MT700751CA.DataEnterer.entererChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEnterer/entererChoice"})
    public EntererChoice getDataEntererEntererChoice() {
        return this.dataEntererEntererChoice;
    }

    /**
     * <p>Relationship: MFMI_MT700751CA.DataEnterer.entererChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntererEntererChoice(EntererChoice dataEntererEntererChoice) {
        this.dataEntererEntererChoice = dataEntererEntererChoice;
    }

    public HealthcareWorkerBean getDataEntererEntererChoiceAsAssignedEntity1() {
        return this.dataEntererEntererChoice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.dataEntererEntererChoice : null;
    }
    public boolean hasDataEntererEntererChoiceAsAssignedEntity1() {
        return (this.dataEntererEntererChoice instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getDataEntererEntererChoiceAsAssignedEntity2() {
        return this.dataEntererEntererChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dataEntererEntererChoice : null;
    }
    public boolean hasDataEntererEntererChoiceAsAssignedEntity2() {
        return (this.dataEntererEntererChoice instanceof HealthcareOrganizationBean);
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }

    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    /**
     * <p>Relationship: MFMI_MT700751CA.Subject1.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/consentEvent"})
    public ConsentBean getSubjectOf1ConsentEvent() {
        return this.subjectOf1ConsentEvent;
    }

    /**
     * <p>Relationship: MFMI_MT700751CA.Subject1.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ConsentEvent(ConsentBean subjectOf1ConsentEvent) {
        this.subjectOf1ConsentEvent = subjectOf1ConsentEvent;
    }


    /**
     * <p>Relationship: MFMI_MT700751CA.Subject2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf2DetectedIssueEvent() {
        return this.subjectOf2DetectedIssueEvent;
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }

    /**
     * <p>Relationship: 
     * MFMI_MT700751CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}
