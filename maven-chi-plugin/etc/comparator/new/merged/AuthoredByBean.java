/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000005CA.Author","REPC_MT000006CA.Author","REPC_MT000009CA.Author"})
public class AuthoredByBean extends MessagePartBean {

    private TS createTimestamp = new TSImpl();
    private AssignedEntityBean assignedEntity = new AssignedEntityBean();

    @Hl7XmlMapping({"time"})
    public Date getCreateTimestamp() {
        return this.createTimestamp.getValue();
    }
    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp.setValue(createTimestamp);
    }

    @Hl7XmlMapping({"assignedEntity"})
    public AssignedEntityBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(AssignedEntityBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
