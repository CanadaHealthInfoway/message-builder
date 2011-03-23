/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt000005ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.merged.AuthoredByBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Allergy/Intolerance</p>
 * 
 * <p>A record of a patient's allergy or intolerance.</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with drug contraindication checking.</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 */
@Hl7PartTypeMapping({"REPC_MT000005CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II allergyIntoleranceRecordId = new IIImpl();
    private CD allergyIntoleranceType = new CDImpl();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS allergyIntoleranceStatus = new CSImpl();
    private TS allergyIntoleranceDate = new TSImpl();
    private SET<CV, Code> allergyIntoleranceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV confirmedIndicator = new CVImpl();
    private CV agent = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private AuthoredByBean author;
    private ReportedByBean informant;
    private TargetedToPharmacyBean location;
    private List<RecordsBean> supportRecords = new ArrayList<RecordsBean>();
    private List<NotesBean> subjectOf1Annotation = new ArrayList<NotesBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private NoteIndicatorBean subjectOf3AnnotationIndicator;
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getAllergyIntoleranceRecordId() {
        return this.allergyIntoleranceRecordId.getValue();
    }
    public void setAllergyIntoleranceRecordId(Identifier allergyIntoleranceRecordId) {
        this.allergyIntoleranceRecordId.setValue(allergyIntoleranceRecordId);
    }

    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }

    @Hl7XmlMapping({"negationInd"})
    public Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyIntoleranceDate() {
        return this.allergyIntoleranceDate.getValue();
    }
    public void setAllergyIntoleranceDate(Date allergyIntoleranceDate) {
        this.allergyIntoleranceDate.setValue(allergyIntoleranceDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAllergyIntoleranceMaskingIndicators() {
        return this.allergyIntoleranceMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }

    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return (ActUncertainty) this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }

    @Hl7XmlMapping({"value"})
    public IntoleranceValue getAgent() {
        return (IntoleranceValue) this.agent.getValue();
    }
    public void setAgent(IntoleranceValue agent) {
        this.agent.setValue(agent);
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public AuthoredByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AuthoredByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"support/records"})
    public List<RecordsBean> getSupportRecords() {
        return this.supportRecords;
    }

    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<NotesBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }

    @Hl7XmlMapping({"subjectOf2/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf2SeverityObservation() {
        return this.subjectOf2SeverityObservation;
    }
    public void setSubjectOf2SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation) {
        this.subjectOf2SeverityObservation = subjectOf2SeverityObservation;
    }

    @Hl7XmlMapping({"subjectOf3/annotationIndicator"})
    public NoteIndicatorBean getSubjectOf3AnnotationIndicator() {
        return this.subjectOf3AnnotationIndicator;
    }
    public void setSubjectOf3AnnotationIndicator(NoteIndicatorBean subjectOf3AnnotationIndicator) {
        this.subjectOf3AnnotationIndicator = subjectOf3AnnotationIndicator;
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }

}
