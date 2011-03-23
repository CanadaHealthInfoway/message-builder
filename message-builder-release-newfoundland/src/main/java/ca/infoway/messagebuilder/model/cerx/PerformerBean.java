package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.AssignedPersonBean;
import ca.infoway.messagebuilder.model.IdentifiablePractitioner;
import ca.infoway.messagebuilder.model.MessagePartBean;

/**
 * <p>The person who performed a particular service.</p>
 * 
 * <p>This type is currently only used in the context of professional services.</p>
 * 
 * @author administrator
 */
@Hl7PartTypeMapping("REPC_MT100001CA.Performer")
public class PerformerBean extends MessagePartBean implements Serializable, IdentifiablePractitioner {

    private static final long serialVersionUID = -8064569252221532979L;

    private AssignedPersonBean assignedPerson = new AssignedPersonBean();

    @Hl7XmlMapping("assignedPerson")
    public AssignedPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }

    public void setAssignedPerson(AssignedPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public Identifier getLicenseNumber() {
        return this.assignedPerson.getLicenseNumber();
    }

    public PersonName getName() {
        return this.assignedPerson.getName();
    }

    public Identifier getId() {
        return this.assignedPerson.getId();
    }
}
