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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.util.CollapsedToDataTypeListHelper;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.pome_mt010090ca.HasCharacteristicBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"POME_MT010030CA.ParameterList","POME_MT010050CA.ParameterList","POME_MT010090CA.ParameterList","PORX_MT050010CA.ParameterList","PORX_MT050020CA.ParameterList","PORX_MT060170CA.ParameterList","PORX_MT060180CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private List<CV<ClinicalDrug>> drugCode = new ArrayList<CV<ClinicalDrug>>();
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDs = new ArrayList<II>();
    private List<CV<ActCareEventType>> careCompositionTypes = new ArrayList<CV<ActCareEventType>>();
    private CV<DiagnosisValue> diagnosisCode = new CVImpl<DiagnosisValue>();
    private BL includeEventHistoryIndicator = new BLImpl();
    private BL includeIssuesIndicator = new BLImpl();
    private BL includeNotesIndicator = new BLImpl();
    private BL includePendingChangesIndicator = new BLImpl();
    private CV<IssueFilterCode> issueFilterCode = new CVImpl<IssueFilterCode>();
    private BL mostRecentByDrugIndicator = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicator = new BLImpl();
    private CV<ActNonConditionIndicationCode> otherIndicationCode = new CVImpl<ActNonConditionIndicationCode>();
    private II otherMedicationRecordId = new IIImpl();
    private II prescriberProviderID = new IIImpl();
    private II prescriptionDispenseNumber = new IIImpl();
    private II prescriptionOrderNumber = new IIImpl();
    private List<CV<ActStatus>> prescriptionStatuses = new ArrayList<CV<ActStatus>>();
    private List<CV<PrescriptionDispenseFilterCode>> rxDispenserIndicators = new ArrayList<CV<PrescriptionDispenseFilterCode>>();
    private CV<SymptomValue> symptomCode = new CVImpl<SymptomValue>();
    private List<CV<ActTherapyDurationWorkingListCode>> treatmentTypes = new ArrayList<CV<ActTherapyDurationWorkingListCode>>();
    private II medicationDocumentID = new IIImpl();
    private CV<ActMedicationDocumentCode> medicationDocumentType = new CVImpl<ActMedicationDocumentCode>();
    private CV<DiagnosisValue> prescribingIndicationDiagnosisCode = new CVImpl<DiagnosisValue>();
    private CV<SymptomValue> prescribingIndicationSymptomCode = new CVImpl<SymptomValue>();
    private List<HasCharacteristicBean> drugCharacteristics = new ArrayList<HasCharacteristicBean>();
    private CV<OrderableDrugForm> orderableDrugForm = new CVImpl<OrderableDrugForm>();
    private ST drugManufacturerName = new STImpl();
    private ST drugName = new STImpl();
    private CV<RouteOfAdministration> drugRouteCode = new CVImpl<RouteOfAdministration>();

    @Hl7XmlMapping({"drugCode/value"})
    public List<ClinicalDrug> getDrugCode() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.drugCode).rawList();
    }

    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }

    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }
    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDs() {
        return new CollapsedToDataTypeListHelper(IIImpl.class, this.careCompositionIDs).rawList();
    }

    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypes() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.careCompositionTypes).rawList();
    }

    @Hl7XmlMapping({"diagnosisCode/value"})
    public DiagnosisValue getDiagnosisCode() {
        return this.diagnosisCode.getValue();
    }
    public void setDiagnosisCode(DiagnosisValue diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public java.lang.Boolean getIncludeEventHistoryIndicator() {
        return this.includeEventHistoryIndicator.getValue();
    }
    public void setIncludeEventHistoryIndicator(java.lang.Boolean includeEventHistoryIndicator) {
        this.includeEventHistoryIndicator.setValue(includeEventHistoryIndicator);
    }

    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public java.lang.Boolean getIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }
    public void setIncludeIssuesIndicator(java.lang.Boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }

    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public java.lang.Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(java.lang.Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping({"includePendingChangesIndicator/value"})
    public java.lang.Boolean getIncludePendingChangesIndicator() {
        return this.includePendingChangesIndicator.getValue();
    }
    public void setIncludePendingChangesIndicator(java.lang.Boolean includePendingChangesIndicator) {
        this.includePendingChangesIndicator.setValue(includePendingChangesIndicator);
    }

    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCode() {
        return this.issueFilterCode.getValue();
    }
    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public java.lang.Boolean getMostRecentByDrugIndicator() {
        return this.mostRecentByDrugIndicator.getValue();
    }
    public void setMostRecentByDrugIndicator(java.lang.Boolean mostRecentByDrugIndicator) {
        this.mostRecentByDrugIndicator.setValue(mostRecentByDrugIndicator);
    }

    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public java.lang.Boolean getMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicator(java.lang.Boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }

    @Hl7XmlMapping({"otherIndicationCode/value"})
    public ActNonConditionIndicationCode getOtherIndicationCode() {
        return this.otherIndicationCode.getValue();
    }
    public void setOtherIndicationCode(ActNonConditionIndicationCode otherIndicationCode) {
        this.otherIndicationCode.setValue(otherIndicationCode);
    }

    @Hl7XmlMapping({"otherMedicationRecordId/value"})
    public Identifier getOtherMedicationRecordId() {
        return this.otherMedicationRecordId.getValue();
    }
    public void setOtherMedicationRecordId(Identifier otherMedicationRecordId) {
        this.otherMedicationRecordId.setValue(otherMedicationRecordId);
    }

    @Hl7XmlMapping({"prescriberProviderID/value"})
    public Identifier getPrescriberProviderID() {
        return this.prescriberProviderID.getValue();
    }
    public void setPrescriberProviderID(Identifier prescriberProviderID) {
        this.prescriberProviderID.setValue(prescriberProviderID);
    }

    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatuses() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.prescriptionStatuses).rawList();
    }

    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public List<PrescriptionDispenseFilterCode> getRxDispenserIndicators() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.rxDispenserIndicators).rawList();
    }

    @Hl7XmlMapping({"symptomCode/value"})
    public SymptomValue getSymptomCode() {
        return this.symptomCode.getValue();
    }
    public void setSymptomCode(SymptomValue symptomCode) {
        this.symptomCode.setValue(symptomCode);
    }

    @Hl7XmlMapping({"treatmentType/value"})
    public List<ActTherapyDurationWorkingListCode> getTreatmentTypes() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.treatmentTypes).rawList();
    }

    @Hl7XmlMapping({"medicationDocumentID/value"})
    public Identifier getMedicationDocumentID() {
        return this.medicationDocumentID.getValue();
    }
    public void setMedicationDocumentID(Identifier medicationDocumentID) {
        this.medicationDocumentID.setValue(medicationDocumentID);
    }

    @Hl7XmlMapping({"medicationDocumentType/value"})
    public ActMedicationDocumentCode getMedicationDocumentType() {
        return this.medicationDocumentType.getValue();
    }
    public void setMedicationDocumentType(ActMedicationDocumentCode medicationDocumentType) {
        this.medicationDocumentType.setValue(medicationDocumentType);
    }

    @Hl7XmlMapping({"prescribingDiagnosisCode/value"})
    public DiagnosisValue getPrescribingIndicationDiagnosisCode() {
        return this.prescribingIndicationDiagnosisCode.getValue();
    }
    public void setPrescribingIndicationDiagnosisCode(DiagnosisValue prescribingIndicationDiagnosisCode) {
        this.prescribingIndicationDiagnosisCode.setValue(prescribingIndicationDiagnosisCode);
    }

    @Hl7XmlMapping({"prescribingSymptomCode/value"})
    public SymptomValue getPrescribingIndicationSymptomCode() {
        return this.prescribingIndicationSymptomCode.getValue();
    }
    public void setPrescribingIndicationSymptomCode(SymptomValue prescribingIndicationSymptomCode) {
        this.prescribingIndicationSymptomCode.setValue(prescribingIndicationSymptomCode);
    }

    @Hl7XmlMapping({"drugCharacteristics"})
    public List<HasCharacteristicBean> getDrugCharacteristics() {
        return this.drugCharacteristics;
    }

    @Hl7XmlMapping({"drugForm/value"})
    public OrderableDrugForm getOrderableDrugForm() {
        return this.orderableDrugForm.getValue();
    }
    public void setOrderableDrugForm(OrderableDrugForm orderableDrugForm) {
        this.orderableDrugForm.setValue(orderableDrugForm);
    }

    @Hl7XmlMapping({"drugManufacturerName/value"})
    public java.lang.String getDrugManufacturerName() {
        return this.drugManufacturerName.getValue();
    }
    public void setDrugManufacturerName(java.lang.String drugManufacturerName) {
        this.drugManufacturerName.setValue(drugManufacturerName);
    }

    @Hl7XmlMapping({"drugName/value"})
    public java.lang.String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(java.lang.String drugName) {
        this.drugName.setValue(drugName);
    }

    @Hl7XmlMapping({"drugRoute/value"})
    public RouteOfAdministration getDrugRouteCode() {
        return this.drugRouteCode.getValue();
    }
    public void setDrugRouteCode(RouteOfAdministration drugRouteCode) {
        this.drugRouteCode.setValue(drugRouteCode);
    }

}
