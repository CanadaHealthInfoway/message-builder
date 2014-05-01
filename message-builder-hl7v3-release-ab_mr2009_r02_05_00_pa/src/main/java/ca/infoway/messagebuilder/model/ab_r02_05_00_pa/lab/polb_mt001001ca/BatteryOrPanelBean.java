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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt001001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.AssignedEntityBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Battery or Panel</p>
 * 
 * <p>Used as a functional grouper of tests. Usually a 
 * &quot;panel&quot; or &quot;battery&quot; of tests are 
 * diagnostically related and frequently conducted and reported 
 * together.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001001CA.BatteryRequest"})
public class BatteryOrPanelBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private LIST<GTS, GeneralTimingSpecification> effectiveTime = new LISTImpl<GTS, GeneralTimingSpecification>(GTSImpl.class);
    private CV priorityCode = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<AssignedEntityBean> verifierAssignedEntity = new ArrayList<AssignedEntityBean>();
    private ParentTestBean occurrenceOfActParentPointer;
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
     * <p>Business Name: Q:Battery Identifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Mandatory for create, revise, cancel, and nullify 
     * actions.</p>
     * 
     * <p>Uniquely identifies this panel or battery.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Q:Battery Identifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Mandatory for create, revise, cancel, and nullify 
     * actions.</p>
     * 
     * <p>Uniquely identifies this panel or battery.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: R:Battery Type</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to categorize and specify the type of battery to be 
     * performed.</p>
     * 
     * <p>The type of battery or the &quot;code&quot; for this 
     * battery or panel. The value set bound to this attribute is a 
     * list of LOINC codes pulled from the pan-Canadian Laboratory 
     * Observation Code Database (pCLOCD). Only those records 
     * flagged as orderable or &quot;both&quot; in the pCLOCD can 
     * be used.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getCode() {
        return (ObservationOrderableLabType) this.code.getValue();
    }

    /**
     * <p>Business Name: R:Battery Type</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to categorize and specify the type of battery to be 
     * performed.</p>
     * 
     * <p>The type of battery or the &quot;code&quot; for this 
     * battery or panel. The value set bound to this attribute is a 
     * list of LOINC codes pulled from the pan-Canadian Laboratory 
     * Observation Code Database (pCLOCD). Only those records 
     * flagged as orderable or &quot;both&quot; in the pCLOCD can 
     * be used.</p>
     */
    public void setCode(ObservationOrderableLabType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: T:Battery Status</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * test e.g. active=in progress or not yet started, 
     * complete=resulted and/or reported. For a battery, a 
     * &quot;complete&quot; status represents a 
     * &quot;complete&quot; status for all child orders.</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * battery e.g. active=in progress or not yet started, 
     * complete=resulted and/or result reported. It is up to the 
     * order placer to determine, upon receipt of one or more 
     * results which fulfill this battery request, when the order 
     * is complete.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: T:Battery Status</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * test e.g. active=in progress or not yet started, 
     * complete=resulted and/or reported. For a battery, a 
     * &quot;complete&quot; status represents a 
     * &quot;complete&quot; status for all child orders.</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * battery e.g. active=in progress or not yet started, 
     * complete=resulted and/or result reported. It is up to the 
     * order placer to determine, upon receipt of one or more 
     * results which fulfill this battery request, when the order 
     * is complete.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: S:Battery Request Time Specification</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.BatteryRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-9)</p>
     * 
     * <p>Would be used to communicate that an Order is for a 
     * future date.</p>
     * 
     * <p>The time specification for when the battery is requested 
     * to be performed or occur or when the changes to the request 
     * took effect or are supposed to take effect. This time 
     * specification includes support for complex, repeating 
     * orders.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<GeneralTimingSpecification> getEffectiveTime() {
        return this.effectiveTime.rawList();
    }


    /**
     * <p>Business Name: U:Battery Priority Code</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Communicates requested test priority (e.g. routine, stat, 
     * etc.)</p>
     * 
     * <p>Priority code associated with a specific test.</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getPriorityCode() {
        return (ActPriority) this.priorityCode.getValue();
    }

    /**
     * <p>Business Name: U:Battery Priority Code</p>
     * 
     * <p>Relationship: POLB_MT001001CA.BatteryRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Communicates requested test priority (e.g. routine, stat, 
     * etc.)</p>
     * 
     * <p>Priority code associated with a specific test.</p>
     */
    public void setPriorityCode(ActPriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Business Name: V:Battery Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.BatteryRequest.confidentialityCode</p>
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
     * POLB_MT001001CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<AssignedEntityBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformationSupportingClinicalObservationEvent() {
        return this.pertinentInformationSupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent1LabInitiatedOrderIndicator() {
        return this.component1LabInitiatedOrderIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component1LabInitiatedOrderIndicator) {
        this.component1LabInitiatedOrderIndicator = component1LabInitiatedOrderIndicator;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent2ReferralRedirectIndicator() {
        return this.component2ReferralRedirectIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2ReferralRedirectIndicator(ReferralRedirectIndicatorBean component2ReferralRedirectIndicator) {
        this.component2ReferralRedirectIndicator = component2ReferralRedirectIndicator;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/requestSortKey"})
    public OrderSortKeyBean getComponent3RequestSortKey() {
        return this.component3RequestSortKey;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3RequestSortKey(OrderSortKeyBean component3RequestSortKey) {
        this.component3RequestSortKey = component3RequestSortKey;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public VersionInformationBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT001001CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf1/priorActRequest"})
    public PriorTestRequestBean getComponentOf1PriorActRequest() {
        return this.componentOf1PriorActRequest;
    }

    /**
     * <p>Relationship: POLB_MT001001CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOf1PriorActRequest(PriorTestRequestBean componentOf1PriorActRequest) {
        this.componentOf1PriorActRequest = componentOf1PriorActRequest;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001001CA.Component4.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf2/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf2PatientCareProvisionEvent() {
        return this.componentOf2PatientCareProvisionEvent;
    }

}
