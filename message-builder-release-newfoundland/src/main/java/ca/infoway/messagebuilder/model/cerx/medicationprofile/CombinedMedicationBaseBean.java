package ca.infoway.messagebuilder.model.cerx.medicationprofile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.OfPatient;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.cerx.DispenseInstructionsBean;
import ca.infoway.messagebuilder.model.cerx.DosageInstructionBean;
import ca.infoway.messagebuilder.model.cerx.MedicationDispenseBean;
import ca.infoway.messagebuilder.model.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.cerx.Prescription;
import ca.infoway.messagebuilder.model.cerx.QuantityObservationEventBean;
import ca.infoway.messagebuilder.model.cerx.ReasonBean;
import ca.infoway.messagebuilder.model.confidentiality.VeryBasicConfidentiality;

public abstract class CombinedMedicationBaseBean extends MedicationRecordBean implements VeryBasicConfidentiality, OfPatient, Prescription {

    private static final long serialVersionUID = -260704236035475306L;

    private final List<CoverageBean> coverages = Collections.synchronizedList(new ArrayList<CoverageBean>());

    private final II id = new IIImpl();

    private final CD code = new CDImpl();

    private final CD statusCode = new CDImpl();

    private final CD confidentialityCode = new CDImpl();

    private MedicineBean medication;

    private IdentifiedPersonBean patient;

    private AuthorBean author;

    private ServiceDeliveryLocationBean location;

    private final II predecessorId = new IIImpl();

    private final List<DosageInstructionBean> dosageInstructions = Collections.synchronizedList(new ArrayList<DosageInstructionBean>());

    private final BL notEligibleForTrial = new BLImpl(false);

    private DerivedFromBean derivedFrom;

    private DispenseInstructionsBean supplyRequest;

    private final List<MedicationDispenseBean> medicationDispenses = Collections.synchronizedList(new ArrayList<MedicationDispenseBean>());

    private SupplySummaryBean supplyEventLastSummary;

    private SupplySummaryBean supplyEventFirstSummary;

    private CumulativeSupplySummaryBean supplyEventFutureSummary;

    private CumulativeSupplySummaryBean supplyEventPastSummary;

    private final List<ReasonBean> reasons = Collections.synchronizedList(new ArrayList<ReasonBean>());

    private final CD workingListCode = new CDImpl();

    private BL verificationEventCriterion = new BLImpl(false);

    private List<QuantityObservationEventBean> quantityObservationEvents = Collections.synchronizedList(new ArrayList<QuantityObservationEventBean>());

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("directTarget/medication/player")
    public MedicineBean getMedication() {
        return this.medication;
    }

    public void setMedication(MedicineBean medication) {
        this.medication = medication;
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return this.patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return this.location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("predecessor/priorCombinedMedicationRequest/id")
    public Identifier getPredecessorId() {
        return this.predecessorId.getValue();
    }

    public void setPredecessorId(Identifier predecessorId) {
        this.predecessorId.setValue(predecessorId);
    }

    @Hl7XmlMapping("component1/dosageInstruction")
    public List<DosageInstructionBean> getDosageInstructions() {
        return this.dosageInstructions;
    }

    @Hl7XmlMapping("component2/negationInd")
    public boolean isNotEligibleForTrial() {
        return this.notEligibleForTrial.getValue();
    }

    public void setNotEligibleForTrial(boolean notEligibleForTrial) {
        this.notEligibleForTrial.setValue(notEligibleForTrial);
    }

    public boolean isEligibleForTrial() {
        return !this.isNotEligibleForTrial();
    }

    public void setEligibleForTrial(boolean eligibleForTrial) {
        this.setNotEligibleForTrial(!eligibleForTrial);
    }

    @Hl7XmlMapping("derivedFrom")
    public DerivedFromBean getDerivedFrom() {
        return this.derivedFrom;
    }

    public void setDerivedFrom(DerivedFromBean derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    @Hl7XmlMapping("component3/supplyRequest")
    public DispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }

    public void setSupplyRequest(DispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

    @Hl7XmlMapping("fulfillment1/medicationDispense")
    public List<MedicationDispenseBean> getMedicationDispenses() {
        return this.medicationDispenses;
    }

    @Hl7XmlMapping("fulfillment2/supplyEventLastSummary")
    public SupplySummaryBean getSupplyEventLastSummary() {
        return this.supplyEventLastSummary;
    }

    public void setSupplyEventLastSummary(SupplySummaryBean supplyEventLastSummary) {
        this.supplyEventLastSummary = supplyEventLastSummary;
    }

    @Hl7XmlMapping("fulfillment3/supplyEventFirstSummary")
    public SupplySummaryBean getSupplyEventFirstSummary() {
        return this.supplyEventFirstSummary;
    }

    public void setSupplyEventFirstSummary(SupplySummaryBean supplyEventFirstSummary) {
        this.supplyEventFirstSummary = supplyEventFirstSummary;
    }

    @Hl7XmlMapping("fulfillment4/supplyEventFutureSummary")
    public CumulativeSupplySummaryBean getSupplyEventFutureSummary() {
        return this.supplyEventFutureSummary;
    }

    public void setSupplyEventFutureSummary(CumulativeSupplySummaryBean supplyEventFutureSummary) {
        this.supplyEventFutureSummary = supplyEventFutureSummary;
    }

    @Hl7XmlMapping("fulfillment5/supplyEventPastSummary")
    public CumulativeSupplySummaryBean getSupplyEventPastSummary() {
        return this.supplyEventPastSummary;
    }

    public void setSupplyEventPastSummary(CumulativeSupplySummaryBean supplyEventPastSummary) {
        this.supplyEventPastSummary = supplyEventPastSummary;
    }

    @Hl7XmlMapping("reason")
    public List<ReasonBean> getReasons() {
        return reasons;
    }

    public boolean isCompound() {
        return this.medication != null && this.medication.getCode() == null;
    }

    @Hl7XmlMapping("componentOf/workingListEvent/code")
    public ActTherapyDurationWorkingListCode getWorkingListCode() {
        return (ActTherapyDurationWorkingListCode) this.workingListCode.getValue();
    }

    public void setWorkingListCode(ActTherapyDurationWorkingListCode workingListCode) {
        this.workingListCode.setValue(workingListCode);
    }

    @Hl7XmlMapping("precondition/verificationEventCriterion")
    public Boolean getVerificationEventCriterion() {
        return verificationEventCriterion.getValue();
    }

    public void setVerificationEventCriterion(Boolean verificationEventCriterion) {
        this.verificationEventCriterion.setValue(verificationEventCriterion);
    }

    @Hl7XmlMapping("pertinentInformation/quantityObservationEvent")
    public List<QuantityObservationEventBean> getQuantityObservationEvents() {
        return quantityObservationEvents;
    }

    public void setQuantityObservationEvents(List<QuantityObservationEventBean> quantityObservationEvents) {
        this.quantityObservationEvents = quantityObservationEvents;
    }

    @Hl7XmlMapping("coverage/coverage")
    public List<CoverageBean> getCoverages() {
        return coverages;
    }
}
