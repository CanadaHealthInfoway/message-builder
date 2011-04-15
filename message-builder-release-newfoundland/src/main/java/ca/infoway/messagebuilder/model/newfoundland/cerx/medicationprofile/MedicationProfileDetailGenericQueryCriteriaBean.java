package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.newfoundland.cerx.PatientQueryCriteria;

public class MedicationProfileDetailGenericQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = 1822382334871547099L;

    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();

    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private CD diagnosisCode = new CDImpl();

    private CD drugCode = new CDImpl();

    private BL includeEventHistoryIndicator = new BLImpl(false);

    private BL includeIssuesIndicator = new BLImpl(false);

    private BL includeNotesIndicator = new BLImpl(false);

    private BL includePendingChangesIndicator = new BLImpl(false);

    private CD issueFilterCode = new CDImpl();

    private BL mostRecentByDrugIndicator = new BLImpl(false);

    private BL mostRecentDispenseForEachRxIndicator = new BLImpl(false);

    private CD otherIndicationCode = new CDImpl();

    private II otherMedicationRecordId = new IIImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private II prescriberProviderId = new IIImpl();

    private II prescriptionDispenseNumber = new IIImpl();

    private II prescriptionOrderNumber = new IIImpl();

    private CD prescriptionStatus = new CDImpl();

    private final List<CV> rxDispenseIndicator = Collections.synchronizedList(new ArrayList<CV>());

    private CD symptomCode = new CDImpl();

    private CD treatmentType = new CDImpl();

    /**
     * Indicates the administration period for which the request/query applies.
     * 
	 * Filter the result set to include only those medication records (prescription order, prescription 
	 * dispense and other active medication) for which the patient was deemed to be taking the drug 
	 * within the specified period.
	 * 
	 * Allows the requester to specify the administration period of interest for the retrieval. 
	 * Useful for constraining run-away queries.
     */
    @Hl7XmlMapping("administrationEffectivePeriod/value")
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }

    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }

    /**
	 * Indicates that the returned records should be filtered to only include those which have been 
	 * amended in some way (had status changed, been annotated, prescription was dispensed, etc.) 
	 * within the indicated time-period. This will commonly be used to retrieve everything that has been amended since xxx.
	 * 
	 * Allows the requester to specify the event period of interest for the retrieval of medication records.
	 * 
	 * Useful for constraining run-away queries.
	 */
    @Hl7XmlMapping("amendedInTimeRange/value")
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }

    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping("diagnosisCode/value")
    public DiagnosisValue getDiagnosisCode() {
        return (DiagnosisValue) this.diagnosisCode.getValue();
    }

    public void setDiagnosisCode(DiagnosisValue diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

    @Hl7XmlMapping("drugCode/value")
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }

    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }

    @Hl7XmlMapping("includeEventHistoryIndicator/value")
    public boolean isIncludeEventHistoryIndicator() {
        return this.includeEventHistoryIndicator.getValue();
    }

    public void setIncludeEventHistoryIndicator(boolean includeEventHistoryIndicator) {
        this.includeEventHistoryIndicator.setValue(includeEventHistoryIndicator);
    }

    @Hl7XmlMapping("includeIssuesIndicator/value")
    public boolean isIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }

    public void setIncludeIssuesIndicator(boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("includePendingChangesIndicator/value")
    public boolean isIncludePendingChangesIndicator() {
        return this.includePendingChangesIndicator.getValue();
    }

    public void setIncludePendingChangesIndicator(boolean includePendingChangesIndicator) {
        this.includePendingChangesIndicator.setValue(includePendingChangesIndicator);
    }

    /**
	 * Indicates whether records to be returned (e.g. prescription order, prescription dispense and/or other medication) should 
	 * be filtered to those with at least one persistent un-managed issue (against the record), with at least one persistent issues 
	 * or should return all records, independent of the presence of persistent issues.
	 * 
	 * By filtering returned records to include only those which have unmanaged issues or any issues at all, allows a provider 
	 * to focus on those aspects of care where extra attention is needed. Because the attribute must be known, it is mandatory.
	 **/
    @Hl7XmlMapping("issueFilterCode/value")
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }

    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    /**
	 * Indicates whether or not the medication records are to be retrieved based on the most recent by Drug Code. 
	 * If true, only the most recent prescription, dispense or other active medication for a particular drug generic 
	 * classification will be returned. The default is 'FALSE' indicating that retrieval of prescription, dispense 
	 * and other active medication records should not be limited to one per drug.
	 *
	 * Helps decrease the volume of records returned, while still maintaining information on all drugs that the patient is on.
	 *
	 * Because this is a boolean attribute whose value must be known to evaluate the query, the attribute is mandatory.
	 */
    @Hl7XmlMapping("mostRecentByDrugIndicator/value")
    public boolean isMostRecentByDrugIndicator() {
        return this.mostRecentByDrugIndicator.getValue();
    }

    public void setMostRecentByDrugIndicator(boolean mostRecentByDrugIndicator) {
        this.mostRecentByDrugIndicator.setValue(mostRecentByDrugIndicator);
    }

    /**
	 * Indicates whether or not a prescription dispenses returned on a query should be limited 
	 * to only the most recent dispense for a prescription.
	 *
	 * Allows the returning of at most one prescription dispense record per a prescription.
	 * The default is 'TRUE' indicating that retrieval should be for only the most recent dispense 
	 * for a prescription is to be included in a query result.
	 * 
	 * Helps to trim down volume of query response by eliminating multiple dispenses for the same prescription.
	 * 
	 * Because this is a boolean attribute whose value must be known to evaluate the query, the attribute is mandatory.
	 */
    @Hl7XmlMapping("mostRecentDispenseForEachRxIndicator/value")
    public boolean isMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }

    public void setMostRecentDispenseForEachRxIndicator(boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }

    @Hl7XmlMapping("otherIndicationCode/value")
    public ActNonConditionIndicationCode getOtherIndicationCode() {
        return (ActNonConditionIndicationCode) this.otherIndicationCode.getValue();
    }

    public void setOtherIndicationCode(ActNonConditionIndicationCode otherIndicationCode) {
        this.otherIndicationCode.setValue(otherIndicationCode);
    }

    @Hl7XmlMapping("otherMedicationRecordId/value")
    public Identifier getOtherMedicationRecordId() {
        return this.otherMedicationRecordId.getValue();
    }

    public void setOtherMedicationRecordId(Identifier otherMedicationRecordId) {
        this.otherMedicationRecordId.setValue(otherMedicationRecordId);
    }

    @Override
    @Hl7XmlMapping("patientBirthDate/value")
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Override
    @Hl7XmlMapping("patientGender/value")
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Override
    @Hl7XmlMapping("patientID/value")
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }

    public void setPatientId(Identifier patientId) {
        this.patientId.setValue(patientId);
    }

    @Override
    @Hl7XmlMapping("patientName/value")
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }

    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    /**
	 * Identifier of the prescriber who created and/or supervised the prescriptions being retrieved.
	 * 
	 * The result set will be filtered to only include records which were either directly created by this 
	 * provider, or were created 'under the supervision' of this provider.
	 * 
	 * Allows for the retrieval of prescriptions based on the specific prescribers.
	 **/
    @Hl7XmlMapping("prescriberProviderID/value")
    public Identifier getPrescriberProviderId() {
        return this.prescriberProviderId.getValue();
    }

    public void setPrescriberProviderId(Identifier prescriberProviderId) {
        this.prescriberProviderId.setValue(prescriberProviderId);
    }

    @Hl7XmlMapping("prescriptionDispenseNumber/value")
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }

    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    /**
	 * Identifier of the prescription for which detailed information is required.
	 * 
	 * The result set will be filtered to only the specific prescription.
	 * 
	 * Identifies the prescription that is to be retrieved.
	 */
    @Hl7XmlMapping("prescriptionOrderNumber/value")
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }

    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    /**
	 * Indicates that prescriptions of a specific statuses are to be included in the result set. 
	 * Specific prescription statuses are: 'active', completed', 'aborted', 'suspended'.
	 * 
	 * Allows for the retrieval of patient prescriptions and dispenses based on the lifecycle state of the prescription.
	 */
    @Hl7XmlMapping("prescriptionStatus/value")
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }

    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }

    /**
	 * A coded value indicating the dispensing (fill) status of the prescription to be included in the result set. 
	 * Rx Dispense Indicators include: ND (Never Dispensed), DRR (Dispensed with Refills Remaining), etc.
	 *
	 * The repetition of 3 allows for retrieval based on all three Rx Dispense Indicators.
	 * 
	 * Allows for finer sub-set of prescriptions to be retrieved based on the fill status of the prescription.
	 */
    @Hl7XmlMapping("rxDispenseIndicator/value")
    public List<PrescriptionDispenseFilterCode> getRxDispenseIndicator() {
    	return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(this.rxDispenseIndicator, CVImpl.class);
    }

    @Hl7XmlMapping("symptomCode/value")
    public SymptomValue getSymptomCode() {
        return (SymptomValue) this.symptomCode.getValue();
    }

    public void setSymptomCode(SymptomValue symptomCode) {
        this.symptomCode.setValue(symptomCode);
    }

    @Hl7XmlMapping("treatmentType/value")
    public ActTherapyDurationWorkingListCode getTreatmentType() {
        return (ActTherapyDurationWorkingListCode) this.treatmentType.getValue();
    }

    public void setTreatmentType(ActTherapyDurationWorkingListCode treatmentType) {
        this.treatmentType.setValue(treatmentType);
    }
}
