/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060190ca;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.AnnotationIndicatorBean;
import ca.infoway.messagebuilder.model.merged.DetectedIssueIndicatorBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Other Medication</p>
 * 
 * <p>A record of a medication the patient is believed to be 
 * taking, but for which an electronic order does not exist. 
 * "Other medications" include any drug product deemed relevant 
 * to the patient's drug profile, but which was not 
 * specifically ordered by a prescriber in a DIS-enabled 
 * jurisdiction. Examples include over-the counter medications 
 * that were not specifically ordered, herbal remedies, and 
 * recreational drugs. Prescription drugs that the patient may 
 * be taking but was not prescribed on the EHR (e.g. 
 * institutionally administered or out-of-jurisdiction 
 * prescriptions) will also be recorded here.</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Allows DUR checking against a more complete drug 
 * profile.</p>
 * 
 * <p>routeCode must not be used when code is SNOMED and is 
 * mandatory otherwise</p>
 * 
 * <p>Status can only be '''ACTIVE''' or '''COMPLETED'''</p>
 */
@Hl7PartTypeMapping({"PORX_MT060190CA.OtherMedication"})
public class OtherMedicationBean extends MessagePartBean implements MedicationRecordBean {

    private static final long serialVersionUID = 20100615L;
    private II otherMedicationRecordNumber = new IIImpl();
    private CD otherMedicationType = new CDImpl();
    private CS otherMedicationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> drugActivePeriod = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> otherMedicationMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV routeOfAdministration = new CVImpl();
    private DrugProductBean consumableMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private TargetedToPharmacyBean location;
    private DetectedIssueIndicatorBean subjectOf1DetectedIssueIndicator;
    private AnnotationIndicatorBean subjectOf2AnnotationIndicator;
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getOtherMedicationRecordNumber() {
        return this.otherMedicationRecordNumber.getValue();
    }
    public void setOtherMedicationRecordNumber(Identifier otherMedicationRecordNumber) {
        this.otherMedicationRecordNumber.setValue(otherMedicationRecordNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getOtherMedicationType() {
        return (ActCode) this.otherMedicationType.getValue();
    }
    public void setOtherMedicationType(ActCode otherMedicationType) {
        this.otherMedicationType.setValue(otherMedicationType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getOtherMedicationStatus() {
        return (ActStatus) this.otherMedicationStatus.getValue();
    }
    public void setOtherMedicationStatus(ActStatus otherMedicationStatus) {
        this.otherMedicationStatus.setValue(otherMedicationStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDrugActivePeriod() {
        return this.drugActivePeriod.getValue();
    }
    public void setDrugActivePeriod(Interval<Date> drugActivePeriod) {
        this.drugActivePeriod.setValue(drugActivePeriod);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getOtherMedicationMaskingIndicators() {
        return this.otherMedicationMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }

    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteOfAdministration() {
        return (RouteOfAdministration) this.routeOfAdministration.getValue();
    }
    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration.setValue(routeOfAdministration);
    }

    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public DetectedIssueIndicatorBean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator;
    }
    public void setSubjectOf1DetectedIssueIndicator(DetectedIssueIndicatorBean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator = subjectOf1DetectedIssueIndicator;
    }

    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public AnnotationIndicatorBean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator;
    }
    public void setSubjectOf2AnnotationIndicator(AnnotationIndicatorBean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator = subjectOf2AnnotationIndicator;
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }

}
