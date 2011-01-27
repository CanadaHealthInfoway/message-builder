/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mcai_mt700222ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700222CA.AuthorRole"})
public class NullAuthorRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.common.merged.AuthorPerson {

    private static final long serialVersionUID = 20110127L;
    private CS classCode = new CSImpl();


    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }

}
