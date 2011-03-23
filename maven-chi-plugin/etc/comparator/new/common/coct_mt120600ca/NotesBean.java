/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt120600ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Notes 
 * 
 * <p>This is a list of comments made about the record by 
 * providers. Information captured here includes the provider 
 * making the comments; and excludes information that would 
 * render the record invalid. This information will only be 
 * seen when another provider reviews the record. Urgent or 
 * targeted messages should be sent using a different mechanism 
 * (e.g. phone). 
 * 
 * <p>Allows various Providers to attach comments to an 
 * existing record, and thus improving cross-provider 
 * communications. 
 * 
 * <p>Public Health requires all clinical notes to be 
 * 'verified' by a responsible party if not created by 
 * physician in charge. This model conveys the correct 
 * semantics, but is inconsistent with other uses of "author" 
 * participation in POIZ models. Any changes here will have to 
 * be reconciled with other projects using this same cmet. 
 * 
 * <p>Identified-confirmable is used on requests 
 * Identified-information is used on responses 
 */
@Hl7PartTypeMapping({"COCT_MT120600CA.Annotation"})
@Hl7RootType
public class NotesBean extends MessagePartBean {

    private ST noteText = new STImpl();
    private TS noteTimestamp = new TSImpl();
    private AssignedPersonBean authorAssignedPerson;

    @Hl7XmlMapping({"text"})
    public java.lang.String getNoteText() {
        return this.noteText.getValue();
    }
    public void setNoteText(java.lang.String noteText) {
        this.noteText.setValue(noteText);
    }

    @Hl7XmlMapping({"author/time"})
    public Date getNoteTimestamp() {
        return this.noteTimestamp.getValue();
    }
    public void setNoteTimestamp(Date noteTimestamp) {
        this.noteTimestamp.setValue(noteTimestamp);
    }

    @Hl7XmlMapping({"author/assignedPerson"})
    public AssignedPersonBean getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }
    public void setAuthorAssignedPerson(AssignedPersonBean authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }

}
