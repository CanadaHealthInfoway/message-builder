package ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction;

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
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.InformantParty;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.CausalityAssessmentBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "REPC_MT000002CA.ReactionObservationEvent", "REPC_MT000012CA.ReactionObservationEvent", "REPC_MT000006CA.ReactionObservationEvent" })
public class AdverseReactionBean extends MessagePartBean implements OfPatient, Serializable, VeryBasicConfidentiality {

    private static final long serialVersionUID = 2492427712483110663L;

    private final II id = new IIImpl();

    private final CD code = new CDImpl();

    private final ST text = new STImpl();

    private final IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();

    private final CD confidentialityCode = new CDImpl();

    private final CD subjectReactionValue = new CDImpl();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private InformantParty informant;

    private final TS informantTime = new TSImpl();

    private List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private final CD severityObservation = new CDImpl();

    private List<CausalityAssessmentBean> causalityAssessments = new ArrayList<CausalityAssessmentBean>();

    private BL annotationIndicator = new BLImpl(false);

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    private AuthorBean author;

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

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getReactionOnsetDate() {
        return reactionOnsetDate.getValue();
    }

    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("value")
    public SubjectReaction getSubjectReactionValue() {
        return (SubjectReaction) this.subjectReactionValue.getValue();
    }

    public void setSubjectReactionValue(SubjectReaction subjectReactionValue) {
        this.subjectReactionValue.setValue(subjectReactionValue);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping({ "informant/party", "informant/choice" })
    public InformantParty getInformant() {
        return informant;
    }

    public void setInformant(InformantParty informant) {
        this.informant = informant;
    }

    @Hl7XmlMapping({ "informant/time" })
    public Date getInformantTime() {
        return this.informantTime.getValue();
    }

    public void setInformantTime(Date informantTime) {
        this.informantTime.setValue(informantTime);
    }

    @Hl7XmlMapping("subjectOf1/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    @Hl7XmlMapping({ "subjectOf4/severityObservation/value", "subjectOf2/severityObservation/value", "subjectOf1/severityObservation/value" })
    public SeverityObservation getSeverityObservation() {
        return (SeverityObservation) this.severityObservation.getValue();
    }

    public void setSeverityObservation(SeverityObservation severityObservation) {
        this.severityObservation.setValue(severityObservation);
    }

    @Hl7XmlMapping({ "subjectOf3/causalityAssessment", "subjectOf2/causalityAssessment" })
    public List<CausalityAssessmentBean> getCausalityAssessments() {
        return causalityAssessments;
    }

    public void setCausalityAssessments(List<CausalityAssessmentBean> causalityAssessments) {
        this.causalityAssessments = causalityAssessments;
    }

    @Hl7XmlMapping("subjectOf2/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("responsibleParty")
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }
}
