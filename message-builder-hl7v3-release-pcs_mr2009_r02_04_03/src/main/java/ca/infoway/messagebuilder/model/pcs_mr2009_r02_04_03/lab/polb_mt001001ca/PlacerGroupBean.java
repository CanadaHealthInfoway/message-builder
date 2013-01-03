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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt001001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Placer Group</p>
 * 
 * <p>Group(er) of tests requested to be performed.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001001CA.PlacerGroup"})
public class PlacerGroupBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20130103L;
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private II id = new IIImpl();
    private ParentTestBean occurrenceOfActParentPointer;
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<SupportingClinicalInformationBean> pertinentInformationSupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private LabInitiatedOrderIndicatorBean component1LabInitiatedOrderIndicator;
    private ReferralRedirectIndicatorBean component2ReferralRedirectIndicator;
    private OrderSortKeyBean component3RequestSortKey;
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private VersionInformationBean subjectOf2ControlActEvent;
    private PriorTestRequestBean componentOf1PriorActRequest;
    private List<CareCompositionsBean> componentOf2PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    /**
     * <p>Business Name: A:Placer Group Identifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PlacerGroup.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>This field allows an order placing application to group 
     * sets of requisitions together and subsequently identify 
     * them. Mandatory for create, revise, cancel, and nullify 
     * actions.</p>
     * 
     * <p>Order (requisition) number of placer (requestor). If 
     * electronic order entry is not supported, then the sending 
     * organization must enter an Placer Order Identifier.</p><p>A 
     * unique number assigned to all tests in a requisition.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Placer Group Identifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PlacerGroup.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>This field allows an order placing application to group 
     * sets of requisitions together and subsequently identify 
     * them. Mandatory for create, revise, cancel, and nullify 
     * actions.</p>
     * 
     * <p>Order (requisition) number of placer (requestor). If 
     * electronic order entry is not supported, then the sending 
     * organization must enter an Placer Order Identifier.</p><p>A 
     * unique number assigned to all tests in a requisition.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    /**
     * <p>Business Name: B:Placer Group Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.PlacerGroup.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>This code allows for privacy control by patients as well 
     * as flagged for 'not for disclosure to patient' by care 
     * providers.</p>
     * 
     * <p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformationSupportingClinicalObservationEvent() {
        return this.pertinentInformationSupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component1/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent1LabInitiatedOrderIndicator() {
        return this.component1LabInitiatedOrderIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent1LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component1LabInitiatedOrderIndicator) {
        this.component1LabInitiatedOrderIndicator = component1LabInitiatedOrderIndicator;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component2/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent2ReferralRedirectIndicator() {
        return this.component2ReferralRedirectIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent2ReferralRedirectIndicator(ReferralRedirectIndicatorBean component2ReferralRedirectIndicator) {
        this.component2ReferralRedirectIndicator = component2ReferralRedirectIndicator;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component3/requestSortKey"})
    public OrderSortKeyBean getComponent3RequestSortKey() {
        return this.component3RequestSortKey;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent3RequestSortKey(OrderSortKeyBean component3RequestSortKey) {
        this.component3RequestSortKey = component3RequestSortKey;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.RequestChoice.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public VersionInformationBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf1/priorActRequest"})
    public PriorTestRequestBean getComponentOf1PriorActRequest() {
        return this.componentOf1PriorActRequest;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponentOf1PriorActRequest(PriorTestRequestBean componentOf1PriorActRequest) {
        this.componentOf1PriorActRequest = componentOf1PriorActRequest;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component4.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf2/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf2PatientCareProvisionEvent() {
        return this.componentOf2PatientCareProvisionEvent;
    }

}
