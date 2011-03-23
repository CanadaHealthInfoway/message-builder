package ca.infoway.messagebuilder.model.cerx.observation;

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
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.AssignedPersonBean;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.OfPatient;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;

@Hl7PartTypeMapping({ "REPC_MT000018CA.CommonObservationEvent", "REPC_MT100002CA.CommonObservationEvent" })
public class ObservationBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = -658068714139610144L;

    private final II id = new IIImpl();

    private final TS effectiveTime = new TSImpl();

    private final CD confidentiality = new CDImpl();

    private final PQ valuePhysicalQuantity = new PQImpl();
    
    private final CD type = new CDImpl();

    private List<ObservationValueBean> values = new ArrayList<ObservationValueBean>();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private final List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private AuthorBean author;

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    private BL annotationIndicator = new BLImpl(false);

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier identifier) {
        this.id.setValue(identifier);
    }

    @Hl7XmlMapping("code")
    public CommonClinicalObservationType getType() {
        return (CommonClinicalObservationType) this.type.getValue();
    }

    public void setType(CommonClinicalObservationType type) {
        this.type.setValue(type);
    }

    @Hl7XmlMapping("value")
    public PhysicalQuantity getValuePhysicalQuantity() {
        return this.valuePhysicalQuantity.getValue();
    }

    public void setValuePhysicalQuantity(PhysicalQuantity value) {
        this.valuePhysicalQuantity.setValue(value);
    }

    @Hl7XmlMapping("component/subObservationEvent")
    public List<ObservationValueBean> getValues() {
        return this.values;
    }

    public void setValues(List<ObservationValueBean> values) {
        this.values = values;
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentiality() {
        return (x_VeryBasicConfidentialityKind) this.confidentiality.getValue();
    }

    public void setConfidentiality(x_VeryBasicConfidentialityKind confidentiality) {
        this.confidentiality.setValue(confidentiality);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean subject) {
        this.patient = subject;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
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

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({ "subjectOf2/annotation" })
    public List<NoteBean> getNotes() {
        return notes;
    }
    
    @Hl7XmlMapping({ "subjectOf/annotation" })
    public NoteBean getNote() {
    	return this.notes.isEmpty() ? null : this.notes.get(0);
    }
    public void setNote(NoteBean note) {
    	this.notes.clear();
    	this.notes.add(note);
    }

    @Hl7XmlMapping("subjectOf1/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }
}
