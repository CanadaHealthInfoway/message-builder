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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretationNormality;
import ca.infoway.messagebuilder.domainvalue.ObservationMethod;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ObservationResultableLabType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.RoleChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.coct_mt090502ca.HealthcareOrganizationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Result Observation</p>
 * 
 * <p>This observation event contains the atomic result 
 * observation information.</p>
 * 
 * <p>This observation event act is used to 
 * document/communicate individual result observation 
 * values.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ObservationEvent"})
public class ResultObservationBean extends MessagePartBean implements ResultChoice {

    private static final long serialVersionUID = 20150326L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ANY<Object> value = new ANYImpl<Object>();
    private CV interpretationCode = new CVImpl();
    private CV methodCode = new CVImpl();
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private PatientBean recordTargetPatient;
    private List<RoleChoice> receiverRoleChoice = new ArrayList<RoleChoice>();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private RecipientChoice primaryInformationRecipientRecipientChoice;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private List<ResultObservationBean> derivedFromObservationEvent = new ArrayList<ResultObservationBean>();
    private List<ReferenceRangeBean> referenceRangeInterpretationRange = new ArrayList<ReferenceRangeBean>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ResultSortKeyBean component1ResultSortKey;
    private List<ReportableHealthIndicatorBean> component2ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private List<ResultChoice> component3ResultChoice = new ArrayList<ResultChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    /**
     * <p>Business Name: Result Observation Identifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-2)</p>
     * 
     * <p>Unique identifiers are required for result revisions, 
     * etc.</p>
     * 
     * <p>Unique identifier for this lab result observation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Result Observation Type</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of lab result observation e.g. 
     * analyte. The code is bound to the LOINC domain. The LOINC 
     * codes &quot;carry&quot; other attributed information such as 
     * method. In those cases where the method is part of the 
     * LOINC, it is up to the implementation to determine whether 
     * to also populate the methodCode attribute. The methodCode 
     * attribute is provided for those cases where the LOINC code 
     * is also not specific or granular enough for this result.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationResultableLabType getCode() {
        return (ObservationResultableLabType) this.code.getValue();
    }

    /**
     * <p>Business Name: Result Observation Type</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of lab result observation e.g. 
     * analyte. The code is bound to the LOINC domain. The LOINC 
     * codes &quot;carry&quot; other attributed information such as 
     * method. In those cases where the method is part of the 
     * LOINC, it is up to the implementation to determine whether 
     * to also populate the methodCode attribute. The methodCode 
     * attribute is provided for those cases where the LOINC code 
     * is also not specific or granular enough for this result.</p>
     */
    public void setCode(ObservationResultableLabType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Result Observation Text</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to document any act information not covered by the 
     * other attribution or value sets.</p>
     * 
     * <p>Contains any text-based descriptive text regarding or in 
     * support of this observation.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Result Observation Text</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to document any act information not covered by the 
     * other attribution or value sets.</p>
     * 
     * <p>Contains any text-based descriptive text regarding or in 
     * support of this observation.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Result Observation Status</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p>
     * 
     * <p>The status or state of the result observation. The 
     * statusCode is not as fine-grained as lab reporting statuses 
     * such as preliminary. A &quot;preliminary&quot; result is a 
     * result whose statusCode=active and ProcessStep (procedure 
     * event) valued &quot;preliminary&quot;.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Result Observation Status</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p>
     * 
     * <p>The status or state of the result observation. The 
     * statusCode is not as fine-grained as lab reporting statuses 
     * such as preliminary. A &quot;preliminary&quot; result is a 
     * result whose statusCode=active and ProcessStep (procedure 
     * event) valued &quot;preliminary&quot;.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Result Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date and time interval over which this lab test 
     * observation was performed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Result Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date and time interval over which this lab test 
     * observation was performed.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationEvent.confidentialityCode</p>
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
     * <p>Business Name: Result Observation Value</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The result value. If a coded value applies, the value 
     * must be selected from the designated Concept Domain.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Result Observation Value</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The result value. If a coded value applies, the value 
     * must be selected from the designated Concept Domain.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    /**
     * <p>Business Name: Observation Interpretation Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>In v2.x, this was the abnormal flag.</p>
     * 
     * <p>Communicates the performer's interpretation of the result 
     * based on an established baseline (normal, high, low, panic, 
     * etc.).</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretationNormality getInterpretationCode() {
        return (ObservationInterpretationNormality) this.interpretationCode.getValue();
    }

    /**
     * <p>Business Name: Observation Interpretation Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>In v2.x, this was the abnormal flag.</p>
     * 
     * <p>Communicates the performer's interpretation of the result 
     * based on an established baseline (normal, high, low, panic, 
     * etc.).</p>
     */
    public void setInterpretationCode(ObservationInterpretationNormality interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    /**
     * <p>Business Name: Result Observation Method</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.methodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The code attribute is bound to LOINC. Some LOINC codes 
     * &quot;carry&quot; the method as part of the code. The 
     * methodCode attribute is provided for those cases where LOINC 
     * is not specific enough or the implementers want to break out 
     * this data in addition to it's inclusion in the LOINC 
     * code.</p>
     */
    @Hl7XmlMapping({"methodCode"})
    public ObservationMethod getMethodCode() {
        return (ObservationMethod) this.methodCode.getValue();
    }

    /**
     * <p>Business Name: Result Observation Method</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationEvent.methodCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The code attribute is bound to LOINC. Some LOINC codes 
     * &quot;carry&quot; the method as part of the code. The 
     * methodCode attribute is provided for those cases where LOINC 
     * is not specific enough or the implementers want to break out 
     * this data in addition to it's inclusion in the LOINC 
     * code.</p>
     */
    public void setMethodCode(ObservationMethod methodCode) {
        this.methodCode.setValue(methodCode);
    }


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/roleChoice"})
    public List<RoleChoice> getReceiverRoleChoice() {
        return this.receiverRoleChoice;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PrimaryInformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/recipientChoice"})
    public RecipientChoice getPrimaryInformationRecipientRecipientChoice() {
        return this.primaryInformationRecipientRecipientChoice;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PrimaryInformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPrimaryInformationRecipientRecipientChoice(RecipientChoice primaryInformationRecipientRecipientChoice) {
        this.primaryInformationRecipientRecipientChoice = primaryInformationRecipientRecipientChoice;
    }

    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt090508ca.HealthcareOrganizationBean getPrimaryInformationRecipientRecipientChoiceAsAssignedEntity1() {
        return this.primaryInformationRecipientRecipientChoice instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt090508ca.HealthcareOrganizationBean) this.primaryInformationRecipientRecipientChoice : null;
    }
    public boolean hasPrimaryInformationRecipientRecipientChoiceAsAssignedEntity1() {
        return (this.primaryInformationRecipientRecipientChoice instanceof ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public HealthcareOrganizationBean getPrimaryInformationRecipientRecipientChoiceAsAssignedEntity2() {
        return this.primaryInformationRecipientRecipientChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.primaryInformationRecipientRecipientChoice : null;
    }
    public boolean hasPrimaryInformationRecipientRecipientChoiceAsAssignedEntity2() {
        return (this.primaryInformationRecipientRecipientChoice instanceof HealthcareOrganizationBean);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.DerivedFrom.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"derivedFrom/observationEvent"})
    public List<ResultObservationBean> getDerivedFromObservationEvent() {
        return this.derivedFromObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.ReferenceRange.interpretationRange</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"referenceRange/interpretationRange"})
    public List<ReferenceRangeBean> getReferenceRangeInterpretationRange() {
        return this.referenceRangeInterpretationRange;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Component2.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/resultSortKey"})
    public ResultSortKeyBean getComponent1ResultSortKey() {
        return this.component1ResultSortKey;
    }

    /**
     * <p>Relationship: POLB_MT004000CA.Component2.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ResultSortKey(ResultSortKeyBean component1ResultSortKey) {
        this.component1ResultSortKey = component1ResultSortKey;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Component3.reportableTestIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent2ReportableTestIndicator() {
        return this.component2ReportableTestIndicator;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Component1.resultChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/resultChoice"})
    public List<ResultChoice> getComponent3ResultChoice() {
        return this.component3ResultChoice;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }

}
