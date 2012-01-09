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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004000ca;

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
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretation;
import ca.infoway.messagebuilder.domainvalue.ObservationMethod;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RoleChoice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Result Observation</p>
 * 
 * <p><p>This observation event act is used to 
 * document/communicate individual result observation 
 * values.</p></p>
 * 
 * <p><p>This observation event contains the atomic result 
 * observation information.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ObservationEvent"})
public class ResultObservationBean extends MessagePartBean implements ResultChoice {

    private static final long serialVersionUID = 20120106L;
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private Patient_1Bean recordTargetPatient;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private CD code = new CDImpl();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private PrimaryInformationRecipientBean primaryInformationRecipient;
    private ST text = new STImpl();
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ResultSortKeyBean component1ResultSortKey;
    private ANY<Object> value = new ANYImpl<Object>();
    private List<ReportableHealthIndicatorBean> component2ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private CV interpretationCode = new CVImpl();
    private List<ResultChoice> component3ResultChoice = new ArrayList<ResultChoice>();
    private CV methodCode = new CVImpl();
    private List<DerivationBean> derivedFrom = new ArrayList<DerivationBean>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<ReferenceRangeBean> referenceRangeInterpretationRange = new ArrayList<ReferenceRangeBean>();
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Result Observation Identifier</p>
     * 
     * <p><p>Unique identifier for this lab result observation.</p></p>
     * 
     * <p><p>Unique identifiers are required for result revisions, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    /**
     * <p>Result Observation Type</p>
     * 
     * <p><p>Describes the type of lab result observation e.g. 
     * analyte. The code is bound to the LOINC domain. The LOINC 
     * codes &quot;carry&quot; other attributed information such as 
     * method. In those cases where the method is part of the 
     * LOINC, it is up to the implementation to determine whether 
     * to also populate the methodCode attribute. The methodCode 
     * attribute is provided for those cases where the LOINC code 
     * is also not specific or granular enough for this result.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    @Hl7XmlMapping({"primaryInformationRecipient"})
    public PrimaryInformationRecipientBean getPrimaryInformationRecipient() {
        return this.primaryInformationRecipient;
    }
    public void setPrimaryInformationRecipient(PrimaryInformationRecipientBean primaryInformationRecipient) {
        this.primaryInformationRecipient = primaryInformationRecipient;
    }


    /**
     * <p>Result Observation Text</p>
     * 
     * <p><p>Contains any text-based descriptive text regarding or 
     * in support of this observation.</p></p>
     * 
     * <p><p>Used to document any act information not covered by 
     * the other attribution or value sets.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Result Observation Status</p>
     * 
     * <p><p>The status or state of the result observation. The 
     * statusCode is not as fine-grained as lab reporting statuses 
     * such as preliminary. A &quot;preliminary&quot; result is a 
     * result whose statusCode=active and ProcessStep (procedure 
     * event) valued &quot;preliminary&quot;.</p></p>
     * 
     * <p><p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Result Observation Date/Time</p>
     * 
     * <p><p>The date and time interval over which this lab test 
     * observation was performed.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Result Masking Indicator</p>
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
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"component1/resultSortKey"})
    public ResultSortKeyBean getComponent1ResultSortKey() {
        return this.component1ResultSortKey;
    }
    public void setComponent1ResultSortKey(ResultSortKeyBean component1ResultSortKey) {
        this.component1ResultSortKey = component1ResultSortKey;
    }


    /**
     * <p>Result Observation Value</p>
     * 
     * <p><p>The result value. If a coded value applies, the value 
     * must be selected from the LaboratoryResultCodeValue Concept 
     * Domain.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    @Hl7XmlMapping({"component2/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent2ReportableTestIndicator() {
        return this.component2ReportableTestIndicator;
    }


    /**
     * <p>Observation Interpretation Code</p>
     * 
     * <p><p>Communicates the performer's interpretation of the 
     * result based on some established baseline (normal, high, 
     * low, panic, etc.).</p></p>
     * 
     * <p><p>In v2.x, this was the abnormal flag.</p></p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretation getInterpretationCode() {
        return (ObservationInterpretation) this.interpretationCode.getValue();
    }
    public void setInterpretationCode(ObservationInterpretation interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    @Hl7XmlMapping({"component3/resultChoice"})
    public List<ResultChoice> getComponent3ResultChoice() {
        return this.component3ResultChoice;
    }


    /**
     * <p>Result Observation Method</p>
     * 
     * <p><p>The code attribute is bound to LOINC. Some LOINC codes 
     * &quot;carry&quot; the method as part of the code. The 
     * methodCode attribute is provided for those cases where LOINC 
     * is not specific enough or the implementers want to break out 
     * this data in addition to it's inclusion in the LOINC 
     * code.</p></p>
     */
    @Hl7XmlMapping({"methodCode"})
    public ObservationMethod getMethodCode() {
        return (ObservationMethod) this.methodCode.getValue();
    }
    public void setMethodCode(ObservationMethod methodCode) {
        this.methodCode.setValue(methodCode);
    }


    @Hl7XmlMapping({"derivedFrom"})
    public List<DerivationBean> getDerivedFrom() {
        return this.derivedFrom;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"referenceRange/interpretationRange"})
    public List<ReferenceRangeBean> getReferenceRangeInterpretationRange() {
        return this.referenceRangeInterpretationRange;
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
