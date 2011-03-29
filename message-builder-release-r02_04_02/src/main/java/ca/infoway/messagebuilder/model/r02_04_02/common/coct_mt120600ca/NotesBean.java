/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt120600ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.RelatedPersonBean;
import java.util.Date;



/**
 * <p>Notes</p>
 * 
 * <p><p>Identified-confirmable is used on requests 
 * Identified-information is used on responses</p></p>
 * 
 * <p><p>This is a list of comments made about the record by 
 * providers. Information captured here includes the provider 
 * making the comments; and excludes information that would 
 * render the record invalid. This information will only be 
 * seen when another provider reviews the record. Urgent or 
 * targeted messages should be sent using a different mechanism 
 * (e.g. phone).</p></p>
 * 
 * <p><p>Public Health requires all clinical notes to be 
 * 'verified' by a responsible party if not created by 
 * physician in charge. This model conveys the correct 
 * semantics, but is inconsistent with other uses of 
 * &quot;author&quot; participation in POIZ models. Any changes 
 * here will have to be reconciled with other projects using 
 * this same cmet.</p></p>
 * 
 * <p><p>Allows various Providers to attach comments to an 
 * existing record, and thus improving cross-provider 
 * communications.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120600CA.Annotation"})
@Hl7RootType
public class NotesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private TS noteTimestamp = new TSImpl();
    private AssignedPerson authorAssignedPerson;
    private ST noteText = new STImpl();


    /**
     * <p>A: Note Timestamp</p>
     * 
     * <p><p>The date and time at which the note was posted.</p></p>
     * 
     * <p><p>Identifies timing of the annotation for sorting and 
     * for audit purposes.</p><p>This attribute is mandatory 
     * because the time of creation of the annotation will always 
     * be known.</p></p>
     * 
     * <p><p>Identifies timing of the annotation for sorting and 
     * for audit purposes.</p><p>This attribute is mandatory 
     * because the time of creation of the annotation will always 
     * be known.</p></p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getNoteTimestamp() {
        return this.noteTimestamp.getValue();
    }
    public void setNoteTimestamp(Date noteTimestamp) {
        this.noteTimestamp.setValue(noteTimestamp);
    }


    @Hl7XmlMapping({"author/assignedPerson"})
    public AssignedPerson getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }
    public void setAuthorAssignedPerson(AssignedPerson authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }

    public HealthcareWorkerBean getAuthorAssignedPersonAsAssignedEntity1() {
        return this.authorAssignedPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity1() {
        return (this.authorAssignedPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getAuthorAssignedPersonAsAssignedEntity2() {
        return this.authorAssignedPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity2() {
        return (this.authorAssignedPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship1() {
        return this.authorAssignedPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship1() {
        return (this.authorAssignedPerson instanceof RelatedPersonBean);
    }

    public ActingPerson getAuthorAssignedPersonAsActingPerson1() {
        return this.authorAssignedPerson instanceof ActingPerson ? (ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson1() {
        return (this.authorAssignedPerson instanceof ActingPerson);
    }

    public HealthcareWorkerBean getAuthorAssignedPersonAsAssignedEntity3() {
        return this.authorAssignedPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity3() {
        return (this.authorAssignedPerson instanceof HealthcareWorkerBean);
    }

    public ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean getAuthorAssignedPersonAsAssignedEntity4() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsAssignedEntity4() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship2() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean ? (ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship2() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt910108ca.RelatedPersonBean);
    }

    public ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson getAuthorAssignedPersonAsActingPerson2() {
        return this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson ? (ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsActingPerson2() {
        return (this.authorAssignedPerson instanceof ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt911108ca.ActingPerson);
    }

    public RelatedPersonBean getAuthorAssignedPersonAsPersonalRelationship4() {
        return this.authorAssignedPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorAssignedPerson : null;
    }
    public boolean hasAuthorAssignedPersonAsPersonalRelationship4() {
        return (this.authorAssignedPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>B: Note Text</p>
     * 
     * <p><p>Free text comments. Additional textual iinformation 
     * entered about an object.</p></p>
     * 
     * <p><p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p><p>Language is supported to allow 
     * grouping or filtering comments based on language</p></p>
     * 
     * <p><p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p><p>Language is supported to allow 
     * grouping or filtering comments based on language</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getNoteText() {
        return this.noteText.getValue();
    }
    public void setNoteText(String noteText) {
        this.noteText.setValue(noteText);
    }

}