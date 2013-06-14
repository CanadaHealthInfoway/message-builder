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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.polb_mt001000ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.ReferralRedirectIndicator;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.PriorTestRequestBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.RecipientChoice;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.IncludesBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.SpecimenRoleBean;
import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
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
@Hl7PartTypeMapping({"POLB_MT001000CA.BatteryRequest"})
public class BatteryOrPanelBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private LIST<GTS, GeneralTimingSpecification> effectiveTime = new LISTImpl<GTS, GeneralTimingSpecification>(GTSImpl.class);
    private CV priorityCode = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<SpecimenRoleBean> specimenSpecimen = new ArrayList<SpecimenRoleBean>();
    private Patient_1Bean recordTargetPatient;
    private HealthcareOrganizationBean performerAssignedEntity;
    private List<HealthcareWorkerBean> callBackContactAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private II occurrenceOfActParentPointerId = new IIImpl();
    private II pertinentInformation1OutbreakEventId = new IIImpl();
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private CD component1ReferralRedirectIndicatorCode = new CDImpl();
    private ST component2RequestSortKeyText = new STImpl();
    private BL component3LabInitiatedOrderIndicatorNegationInd = new BLImpl();
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();
    private PriorTestRequestBean componentOfPriorActRequest;


    /**
     * <p>Business Name: Q:Battery Identifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.code</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.code</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.statusCode</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.statusCode</p>
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
     * POLB_MT001000CA.BatteryRequest.effectiveTime</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.priorityCode</p>
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
     * <p>Relationship: POLB_MT001000CA.BatteryRequest.priorityCode</p>
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
     * POLB_MT001000CA.BatteryRequest.confidentialityCode</p>
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
     * <p>Relationship: POLB_MT001000CA.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"specimen/specimen"})
    public List<SpecimenRoleBean> getSpecimenSpecimen() {
        return this.specimenSpecimen;
    }


    /**
     * <p>Relationship: POLB_MT001000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: POLB_MT001000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: POLB_MT001000CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareOrganizationBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Relationship: POLB_MT001000CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"callBackContact/assignedEntity"})
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity() {
        return this.callBackContactAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    /**
     * <p>Relationship: POLB_MT001000CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    /**
     * <p>Business Name: Parent Test Identifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.ActParentPointer.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     */
    @Hl7XmlMapping({"occurrenceOf/actParentPointer/id"})
    public Identifier getOccurrenceOfActParentPointerId() {
        return this.occurrenceOfActParentPointerId.getValue();
    }

    /**
     * <p>Business Name: Parent Test Identifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.ActParentPointer.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     */
    public void setOccurrenceOfActParentPointerId(Identifier occurrenceOfActParentPointerId) {
        this.occurrenceOfActParentPointerId.setValue(occurrenceOfActParentPointerId);
    }


    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent/id"})
    public Identifier getPertinentInformation1OutbreakEventId() {
        return this.pertinentInformation1OutbreakEventId.getValue();
    }

    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    public void setPertinentInformation1OutbreakEventId(Identifier pertinentInformation1OutbreakEventId) {
        this.pertinentInformation1OutbreakEventId.setValue(pertinentInformation1OutbreakEventId);
    }


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Business Name: O:Referral Redirect Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    @Hl7XmlMapping({"component1/referralRedirectIndicator/code"})
    public ReferralRedirectIndicator getComponent1ReferralRedirectIndicatorCode() {
        return (ReferralRedirectIndicator) this.component1ReferralRedirectIndicatorCode.getValue();
    }

    /**
     * <p>Business Name: O:Referral Redirect Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    public void setComponent1ReferralRedirectIndicatorCode(ReferralRedirectIndicator component1ReferralRedirectIndicatorCode) {
        this.component1ReferralRedirectIndicatorCode.setValue(component1ReferralRedirectIndicatorCode);
    }


    /**
     * <p>Business Name: N:Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT001000CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    @Hl7XmlMapping({"component2/requestSortKey/text"})
    public String getComponent2RequestSortKeyText() {
        return this.component2RequestSortKeyText.getValue();
    }

    /**
     * <p>Business Name: N:Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT001000CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    public void setComponent2RequestSortKeyText(String component2RequestSortKeyText) {
        this.component2RequestSortKeyText.setValue(component2RequestSortKeyText);
    }


    /**
     * <p>Business Name: Lab Initiated Order Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A 'true' value indicates that the Order was initiated by 
     * the Lab.</p>
     */
    @Hl7XmlMapping({"component3/labInitiatedOrderIndicator/negationInd"})
    public Boolean getComponent3LabInitiatedOrderIndicatorNegationInd() {
        return this.component3LabInitiatedOrderIndicatorNegationInd.getValue();
    }

    /**
     * <p>Business Name: Lab Initiated Order Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A 'true' value indicates that the Order was initiated by 
     * the Lab.</p>
     */
    public void setComponent3LabInitiatedOrderIndicatorNegationInd(Boolean component3LabInitiatedOrderIndicatorNegationInd) {
        this.component3LabInitiatedOrderIndicatorNegationInd.setValue(component3LabInitiatedOrderIndicatorNegationInd);
    }


    /**
     * <p>Relationship: POLB_MT001000CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    /**
     * <p>Relationship: POLB_MT001000CA.RequestChoice.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    /**
     * <p>Relationship: POLB_MT001000CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/priorActRequest"})
    public PriorTestRequestBean getComponentOfPriorActRequest() {
        return this.componentOfPriorActRequest;
    }

    /**
     * <p>Relationship: POLB_MT001000CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest) {
        this.componentOfPriorActRequest = componentOfPriorActRequest;
    }

}
