/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020050CA.Author2","PORX_MT030040CA.Author2","PORX_MT060020CA.Author2","PORX_MT060060CA.Author2","PORX_MT060100CA.Author2","PORX_MT060190CA.Author2","RCMR_MT010001CA.Author2"})
public class OverriddenByBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private TS prescribedDate = new TSImpl();
    private HealthcareWorkerBean assignedEntity;

    @Hl7XmlMapping({"time"})
    public Date getPrescribedDate() {
        return this.prescribedDate.getValue();
    }
    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate.setValue(prescribedDate);
    }

    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
