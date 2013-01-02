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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.CultureObservationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.WasPerformedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Culture Grouper Observation</p>
 * 
 * <p>This mandatory culture observation is the grouping 
 * observation for all information related to the culturing of 
 * the collected specimen to identify micro-organisms and the 
 * further, optional testing for antibiotic sensitivities.</p>
 * 
 * <p>This culture observation is the grouping observation for 
 * all information related to the culturing of the collected 
 * specimen to identify micro-organisms and the further, 
 * optional testing for antibiotic sensitivities.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.Culture"})
public class CultureGrouperObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ReportSectionSpecimenBean specimen;
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private List<SupportingClinicalInformationBean> pertinentInformation1SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private OutbreakBean pertinentInformation2OutbreakEvent;
    private List<CultureObservationsBean> component1CultureObservationEvent = new ArrayList<CultureObservationsBean>();
    private ResultSortKeyBean component2ResultSortKey;
    private List<HasAComponentBean> component3 = new ArrayList<HasAComponentBean>();
    private List<ReportableHealthIndicatorBean> component4ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    /**
     * <p>Business Name: Culture Identifier</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Unique to identify this culture test.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Culture Type</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of culture. LOINC codes are used for 
     * this attribute which also &quot;carry&quot; the specimen 
     * source e.g. ear, blood, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public CultureObservationCode getCode() {
        return (CultureObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Culture Type</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of culture. LOINC codes are used for 
     * this attribute which also &quot;carry&quot; the specimen 
     * source e.g. ear, blood, etc.</p>
     */
    public void setCode(CultureObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Culture Status</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status of the Culture.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Culture Status</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status of the Culture.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Culture Effective Time</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time associated with the Culture.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Culture Effective Time</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time associated with the Culture.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: POLB_MT004100CA.Culture.confidentialityCode</p>
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


    @Hl7XmlMapping({"specimen"})
    public ReportSectionSpecimenBean getSpecimen() {
        return this.specimen;
    }

    public void setSpecimen(ReportSectionSpecimenBean specimen) {
        this.specimen = specimen;
    }


    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004100CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    @Hl7XmlMapping({"pertinentInformation1/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation1SupportingClinicalObservationEvent() {
        return this.pertinentInformation1SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"pertinentInformation2/outbreakEvent"})
    public OutbreakBean getPertinentInformation2OutbreakEvent() {
        return this.pertinentInformation2OutbreakEvent;
    }

    public void setPertinentInformation2OutbreakEvent(OutbreakBean pertinentInformation2OutbreakEvent) {
        this.pertinentInformation2OutbreakEvent = pertinentInformation2OutbreakEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.Component1.cultureObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component1/cultureObservationEvent"})
    public List<CultureObservationsBean> getComponent1CultureObservationEvent() {
        return this.component1CultureObservationEvent;
    }


    @Hl7XmlMapping({"component2/resultSortKey"})
    public ResultSortKeyBean getComponent2ResultSortKey() {
        return this.component2ResultSortKey;
    }

    public void setComponent2ResultSortKey(ResultSortKeyBean component2ResultSortKey) {
        this.component2ResultSortKey = component2ResultSortKey;
    }


    /**
     * <p>Relationship: POLB_MT004100CA.Culture.component3</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-100)</p>
     */
    @Hl7XmlMapping({"component3"})
    public List<HasAComponentBean> getComponent3() {
        return this.component3;
    }


    @Hl7XmlMapping({"component4/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent4ReportableTestIndicator() {
        return this.component4ReportableTestIndicator;
    }


    /**
     * <p>Relationship: POLB_MT004100CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT004100CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }

    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }

}
