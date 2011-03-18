/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.si.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.v02_r01.si.comt_mt300003ca.AnnotatedByBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COMT_MT300001CA.Annotation","COMT_MT300003CA.Annotation","COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private SET<CV, Code> restrictedPatientAccess = new SETImpl<CV, Code>(CVImpl.class);
    private CV patientNoteCategory = new CVImpl();
    private ST text = new STImpl();
    private II patientNoteId = new IIImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedAtBean location;
    private AnnotatedByBean author;
    private II recordId = new IIImpl();
    private CV writtenIn = new CVImpl();


    /**
     * <p>RestrictedPatientAccess</p>
     * 
     * <p>D:Restricted Patient Access</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getRestrictedPatientAccess() {
        return this.restrictedPatientAccess.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>PatientNoteCategory</p>
     * 
     * <p>A:Patient Note Category</p>
     * 
     * <p>Patient Note Category</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getPatientNoteCategory() {
        return (ActPatientAnnotationCode) this.patientNoteCategory.getValue();
    }
    public void setPatientNoteCategory(ActPatientAnnotationCode patientNoteCategory) {
        this.patientNoteCategory.setValue(patientNoteCategory);
    }


    /**
     * <p>C:Annotation Text</p>
     * 
     * <p>C:Patient Note Text</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>PatientNoteId</p>
     * 
     * <p>B:Patient Note Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPatientNoteId() {
        return this.patientNoteId.getValue();
    }
    public void setPatientNoteId(Identifier patientNoteId) {
        this.patientNoteId.setValue(patientNoteId);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"author"})
    public AnnotatedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AnnotatedByBean author) {
        this.author = author;
    }


    /**
     * <p>RecordId</p>
     * 
     * <p>A:Record Id</p>
     */
    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Identifier getRecordId() {
        return this.recordId.getValue();
    }
    public void setRecordId(Identifier recordId) {
        this.recordId.setValue(recordId);
    }


    /**
     * <p>WrittenIn</p>
     * 
     * <p>D:Written in</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getWrittenIn() {
        return (HumanLanguage) this.writtenIn.getValue();
    }
    public void setWrittenIn(HumanLanguage writtenIn) {
        this.writtenIn.setValue(writtenIn);
    }

}
