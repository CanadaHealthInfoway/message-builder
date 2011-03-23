/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT260020CA.DetectedIssueManagement","COCT_MT260022CA.DetectedIssueManagement","COCT_MT260030CA.DetectedIssueManagement"})
public class DetectedIssueManagement_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private CV managementType = new CVImpl();
    private ST managementDescription = new STImpl();
    private TS changeTimestamp = new TSImpl();
    private ChangedByBean authorChangedBy;
    private ActingPersonBean authorActingPerson;
    private HealthcareWorkerBean authorAssignedEntity;

    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getManagementType() {
        return (ActDetectedIssueManagementCode) this.managementType.getValue();
    }
    public void setManagementType(ActDetectedIssueManagementCode managementType) {
        this.managementType.setValue(managementType);
    }

    @Hl7XmlMapping({"text"})
    public String getManagementDescription() {
        return this.managementDescription.getValue();
    }
    public void setManagementDescription(String managementDescription) {
        this.managementDescription.setValue(managementDescription);
    }

    @Hl7XmlMapping({"author/time"})
    public Date getChangeTimestamp() {
        return this.changeTimestamp.getValue();
    }
    public void setChangeTimestamp(Date changeTimestamp) {
        this.changeTimestamp.setValue(changeTimestamp);
    }

    @Hl7XmlMapping({"author/changedBy"})
    public ChangedByBean getAuthorChangedBy() {
        return this.authorChangedBy;
    }
    public void setAuthorChangedBy(ChangedByBean authorChangedBy) {
        this.authorChangedBy = authorChangedBy;
    }

    @Hl7XmlMapping({"author/actingPerson"})
    public ActingPersonBean getAuthorActingPerson() {
        return this.authorActingPerson;
    }
    public void setAuthorActingPerson(ActingPersonBean authorActingPerson) {
        this.authorActingPerson = authorActingPerson;
    }

    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }

}
