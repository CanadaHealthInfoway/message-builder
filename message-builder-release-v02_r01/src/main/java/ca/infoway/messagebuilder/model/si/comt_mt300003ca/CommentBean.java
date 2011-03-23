/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.si.comt_mt300003ca;

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
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.AuthoredByBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import java.util.Set;



/**
 * <p>Comment</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300003CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II patientNoteId = new IIImpl();
    private CV patientNoteCategory = new CVImpl();
    private ST patientNoteText = new STImpl();
    private SET<CV, Code> restrictedPatientAccess = new SETImpl<CV, Code>(CVImpl.class);
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private AuthoredByBean author;
    private TargetedToPharmacyBean location;

    @Hl7XmlMapping({"id"})
    public Identifier getPatientNoteId() {
        return this.patientNoteId.getValue();
    }
    public void setPatientNoteId(Identifier patientNoteId) {
        this.patientNoteId.setValue(patientNoteId);
    }

    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getPatientNoteCategory() {
        return (ActPatientAnnotationCode) this.patientNoteCategory.getValue();
    }
    public void setPatientNoteCategory(ActPatientAnnotationCode patientNoteCategory) {
        this.patientNoteCategory.setValue(patientNoteCategory);
    }

    @Hl7XmlMapping({"text"})
    public String getPatientNoteText() {
        return this.patientNoteText.getValue();
    }
    public void setPatientNoteText(String patientNoteText) {
        this.patientNoteText.setValue(patientNoteText);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getRestrictedPatientAccess() {
        return this.restrictedPatientAccess.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
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

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

}
