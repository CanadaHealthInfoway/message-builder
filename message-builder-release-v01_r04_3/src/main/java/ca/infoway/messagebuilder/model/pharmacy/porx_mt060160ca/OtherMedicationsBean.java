/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060160ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.merged.CommentBean;
import ca.infoway.messagebuilder.model.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060160CA.OtherMedication"})
public class OtherMedicationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20110127L;
    private PatientBean subjectPatient;
    private RecordedAtBean location;
    private BL subjectOf2DetectedIssueIndicator = new BLImpl();
    private CD otherMedicationType = new CDImpl();
    private IVL<TS, Interval<Date>> drugActivePeriod = new IVLImpl<TS, Interval<Date>>();
    private II administrationRecordId = new IIImpl();
    private CV routeOfAdministration = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private CV otherMedicationMaskingIndicator = new CVImpl();
    private CS otherMedicationStatus = new CSImpl();
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();
    private RefusedByBean author;
    private DrugProductBean consumableMedication;
    private BL subjectOf4AnnotationIndicator = new BLImpl();
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    /**
     * <p>Other Medication Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getOtherMedicationType() {
        return (ActCode) this.otherMedicationType.getValue();
    }
    public void setOtherMedicationType(ActCode otherMedicationType) {
        this.otherMedicationType.setValue(otherMedicationType);
    }


    /**
     * <p>C:Drug Active Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDrugActivePeriod() {
        return this.drugActivePeriod.getValue();
    }
    public void setDrugActivePeriod(Interval<Date> drugActivePeriod) {
        this.drugActivePeriod.setValue(drugActivePeriod);
    }


    /**
     * <p>A:Administration Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdministrationRecordId() {
        return this.administrationRecordId.getValue();
    }
    public void setAdministrationRecordId(Identifier administrationRecordId) {
        this.administrationRecordId.setValue(administrationRecordId);
    }


    /**
     * <p>E:Route of Administration</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteOfAdministration() {
        return (RouteOfAdministration) this.routeOfAdministration.getValue();
    }
    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration.setValue(routeOfAdministration);
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>D:Other Medication Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getOtherMedicationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.otherMedicationMaskingIndicator.getValue();
    }
    public void setOtherMedicationMaskingIndicator(x_VeryBasicConfidentialityKind otherMedicationMaskingIndicator) {
        this.otherMedicationMaskingIndicator.setValue(otherMedicationMaskingIndicator);
    }


    /**
     * <p>B:Other Medication Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getOtherMedicationStatus() {
        return (ActStatus) this.otherMedicationStatus.getValue();
    }
    public void setOtherMedicationStatus(ActStatus otherMedicationStatus) {
        this.otherMedicationStatus.setValue(otherMedicationStatus);
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }


    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }

}
