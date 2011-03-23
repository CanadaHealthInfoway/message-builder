package ca.infoway.messagebuilder.model.cerx.immunization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_InformationSource;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.AssignedPersonBean;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.OfPatient;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "POIZ_MT030050CA.Immunization", "POIZ_MT030060CA.Immunization", "POIZ_MT060150CA.Immunization" })
public class ImmunizationBean extends MessagePartBean implements OfPatient, Serializable, VeryBasicConfidentiality {

    private static final long serialVersionUID = 2492427712483110663L;

    private final II id = new IIImpl();

    private final CD code = new CDImpl();

    private final BL negationInd = new BLImpl(false);

    private final TS effectiveTime = new TSImpl();

    private final CD confidentialityCode = new CDImpl();

    private final CD reasonCode = new CDImpl();

    private final CD routeCode = new CDImpl();

    private final CD approachSiteCode = new CDImpl();

    private final PQ doseQuantity = new PQImpl();

    private MedicineBean medicine;

    private final CD informantRole = new CDImpl();

    private final INT doseSequenceNumber = new INTImpl();

    private final IVL<TS, Interval<Date>> nextPlannedDoseDate = new IVLImpl<TS, Interval<Date>>();

    private final TS renewalDate = new TSImpl();

    private BL causeOfIndicator = new BLImpl(false);

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private ServiceDeliveryLocationBean location;

    private AuthorBean author;

    private AssignedPersonBean responsibleParty;

    private BL annotationIndicator = new BLImpl(false);

    private BL detectedIssueIndicator = new BLImpl(false);

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

    @Hl7XmlMapping("negationInd")
    public boolean isNegationInd() {
        return this.negationInd.getValue();
    }

    public void setNegationInd(boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("reasonCode")
    public ActNoImmunizationReason getReasonCode() {
        return (ActNoImmunizationReason) this.reasonCode.getValue();
    }

    public void setReasonCode(ActNoImmunizationReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("routeCode")
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }

    @Hl7XmlMapping("approachSiteCode")
    public HumanSubstanceAdministrationSite getApproachSiteCode() {
        return (HumanSubstanceAdministrationSite) this.approachSiteCode.getValue();
    }

    public void setApproachSiteCode(HumanSubstanceAdministrationSite approachSiteCode) {
        this.approachSiteCode.setValue(approachSiteCode);
    }

    @Hl7XmlMapping("doseQuantity")
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("consumable/medication/player")
    public MedicineBean getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineBean medicine) {
        this.medicine = medicine;
    }

    @Hl7XmlMapping("informant/informantionSourceRole/classCode")
    public x_InformationSource getInformantRole() {
        return (x_InformationSource) this.informantRole.getValue();
    }

    public void setInformantRole(x_InformationSource informantRole) {
        this.informantRole.setValue(informantRole);
    }

    @Hl7XmlMapping("inFulfillmentOf/sequenceNumber")
    public int getDoseSequenceNumber() {
        return doseSequenceNumber.getValue();
    }

    public void setDoseSequenceNumber(int doseSequenceNumber) {
        this.doseSequenceNumber.setValue(doseSequenceNumber);
    }

    @Hl7XmlMapping("inFulfillmentOf/immunizationPlan/fulfillment/nextPlannedImmunization/effectiveTime")
    public Interval<Date> getNextPlannedDoseDate() {
        return this.nextPlannedDoseDate.getValue();
    }

    public void setNextPlannedDoseDate(Interval<Date> nextPlannedDoseDate) {
        this.nextPlannedDoseDate.setValue(nextPlannedDoseDate);
    }

    @Hl7XmlMapping("inFulfillmentOf/immunizationPlan/successor/nextImmunizationPlan/effectiveTime")
    public Date getRenewalDate() {
        return this.renewalDate.getValue();
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate.setValue(renewalDate);
    }

    @Hl7XmlMapping({ "subjectOf/annotation" })
    public NoteBean getNote() {
        return this.notes.isEmpty() ? null : this.notes.get(0);
    }
    public void setNote(NoteBean noteBean) {
    	this.notes.clear();
    	this.notes.add(noteBean);
    }

    @Hl7XmlMapping({ "subjectOf2/annotation" })
    public List<NoteBean> getNotes() {
        return notes;
    }

    @Hl7XmlMapping("cause/adverseReactionObservationEvent")
    public Boolean getCauseOfIndicator() {
        return causeOfIndicator.getValue();
    }

    public void setCauseOfIndicator(Boolean causeOfIndicator) {
        this.causeOfIndicator.setValue(causeOfIndicator);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("subjectOf4/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping("subjectOf3/detectedIssueIndicator")
    public Boolean getDetectedIssueIndicator() {
        return detectedIssueIndicator.getValue();
    }

    public void setDetectedIssueIndicator(Boolean detectedIssueIndicator) {
        this.detectedIssueIndicator.setValue(detectedIssueIndicator);
    }
}
