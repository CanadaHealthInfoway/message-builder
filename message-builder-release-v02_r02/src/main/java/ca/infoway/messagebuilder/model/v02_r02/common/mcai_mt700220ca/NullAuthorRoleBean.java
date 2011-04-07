/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.mcai_mt700220ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Null Author Role</p>
 * 
 * <p><p>This is a messaging artifact used by HL7 to allow the 
 * time, signiture and method to be captured when the author is 
 * not sent. This will happen in circumstances where the author 
 * information is sent as part of the authentication token.</p></p>
 */
@Hl7PartTypeMapping({"MCAI_MT700220CA.AuthorRole"})
public class NullAuthorRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v02_r02.common.merged.AuthorPerson {

    private static final long serialVersionUID = 20110407L;
    private CS classCode = new CSImpl();


    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }

}
