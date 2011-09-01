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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Battery or Panel</p>
 * 
 * <p><p>Used as a functional grouper of tests. Usually a 
 * &quot;panel&quot; or &quot;battery&quot; of tests are 
 * diagnostically related and frequently conducted and reported 
 * together.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT001001CA.BatteryRequest"})
public class BatteryOrPanelBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20110901L;
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private II batteryIdentifier = new IIImpl();
    private ParentTestBean occurrenceOfActParentPointer;
    private CD batteryType = new CDImpl();
    private List<SupportingClinicalInformationBean> pertinentInformationSupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private LabInitiatedOrderIndicatorBean component1LabInitiatedOrderIndicator;
    private CS batteryStatus = new CSImpl();
    private ReferralRedirectIndicatorBean component2ReferralRedirectIndicator;
    private LIST<GTS, GeneralTimingSpecification> batteryRequestTimeSpecification = new LISTImpl<GTS, GeneralTimingSpecification>(GTSImpl.class);
    private OrderSortKeyBean component3RequestSortKey;
    private CV batteryPriorityCode = new CVImpl();
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private SET<CV, Code> batteryMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private VersionInformationBean subjectOf2ControlActEvent;
    private PriorTestRequestBean componentOf1PriorActRequest;
    private List<CareCompositionsBean> componentOf2PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    /**
     * <p>Q:Battery Identifier</p>
     * 
     * <p><p>Uniquely identifies this panel or battery.</p></p>
     * 
     * <p><p>Mandatory for create, revise, cancel, and nullify 
     * actions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getBatteryIdentifier() {
        return this.batteryIdentifier.getValue();
    }
    public void setBatteryIdentifier(Identifier batteryIdentifier) {
        this.batteryIdentifier.setValue(batteryIdentifier);
    }


    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    /**
     * <p>R:Battery Type</p>
     * 
     * <p><p>The type of battery or the &quot;code&quot; for this 
     * battery or panel. The value set bound to this attribute is a 
     * list of LOINC codes pulled from the pan-Canadian Laboratory 
     * Observation Code Database (pCLOCD). Only those records 
     * flagged as orderable or &quot;both&quot; in the pCLOCD can 
     * be used.</p></p>
     * 
     * <p><p>Used to categorize and specify the type of battery to 
     * be performed.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getBatteryType() {
        return (ObservationOrderableLabType) this.batteryType.getValue();
    }
    public void setBatteryType(ObservationOrderableLabType batteryType) {
        this.batteryType.setValue(batteryType);
    }


    @Hl7XmlMapping({"pertinentInformation/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformationSupportingClinicalObservationEvent() {
        return this.pertinentInformationSupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"component1/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent1LabInitiatedOrderIndicator() {
        return this.component1LabInitiatedOrderIndicator;
    }
    public void setComponent1LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component1LabInitiatedOrderIndicator) {
        this.component1LabInitiatedOrderIndicator = component1LabInitiatedOrderIndicator;
    }


    /**
     * <p>T:Battery Status</p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * battery e.g. active=in progress or not yet started, 
     * complete=resulted and/or result reported. It is up to the 
     * order placer to determine, upon receipt of one or more 
     * results which fulfill this battery request, when the order 
     * is complete.</p></p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * test e.g. active=in progress or not yet started, 
     * complete=resulted and/or reported. For a battery, a 
     * &quot;complete&quot; status represents a 
     * &quot;complete&quot; status for all child orders.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getBatteryStatus() {
        return (ActStatus) this.batteryStatus.getValue();
    }
    public void setBatteryStatus(ActStatus batteryStatus) {
        this.batteryStatus.setValue(batteryStatus);
    }


    @Hl7XmlMapping({"component2/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent2ReferralRedirectIndicator() {
        return this.component2ReferralRedirectIndicator;
    }
    public void setComponent2ReferralRedirectIndicator(ReferralRedirectIndicatorBean component2ReferralRedirectIndicator) {
        this.component2ReferralRedirectIndicator = component2ReferralRedirectIndicator;
    }


    /**
     * <p>S:Battery Request Time Specification</p>
     * 
     * <p><p>The time specification for when the battery is 
     * requested to be performed or occur or when the changes to 
     * the request took effect or are supposed to take effect. This 
     * time specification includes support for complex, repeating 
     * orders.</p></p>
     * 
     * <p><p>Would be used to communicate that an Order is for a 
     * future date.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public List<GeneralTimingSpecification> getBatteryRequestTimeSpecification() {
        return this.batteryRequestTimeSpecification.rawList();
    }


    @Hl7XmlMapping({"component3/requestSortKey"})
    public OrderSortKeyBean getComponent3RequestSortKey() {
        return this.component3RequestSortKey;
    }
    public void setComponent3RequestSortKey(OrderSortKeyBean component3RequestSortKey) {
        this.component3RequestSortKey = component3RequestSortKey;
    }


    /**
     * <p>U:Battery Priority Code</p>
     * 
     * <p><p>Priority code associated with a specific test.</p></p>
     * 
     * <p><p>Communicates requested test priority (e.g. routine, 
     * stat, etc.)</p></p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getBatteryPriorityCode() {
        return (ActPriority) this.batteryPriorityCode.getValue();
    }
    public void setBatteryPriorityCode(ActPriority batteryPriorityCode) {
        this.batteryPriorityCode.setValue(batteryPriorityCode);
    }


    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    /**
     * <p>V:Battery Masking Indicator</p>
     * 
     * <p><p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p></p>
     * 
     * <p><p>This code allows for privacy control by patients as 
     * well as flagged for 'not for disclosure to patient' by care 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getBatteryMaskingIndicator() {
        return this.batteryMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public VersionInformationBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    @Hl7XmlMapping({"componentOf1/priorActRequest"})
    public PriorTestRequestBean getComponentOf1PriorActRequest() {
        return this.componentOf1PriorActRequest;
    }
    public void setComponentOf1PriorActRequest(PriorTestRequestBean componentOf1PriorActRequest) {
        this.componentOf1PriorActRequest = componentOf1PriorActRequest;
    }


    @Hl7XmlMapping({"componentOf2/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf2PatientCareProvisionEvent() {
        return this.componentOf2PatientCareProvisionEvent;
    }

}
