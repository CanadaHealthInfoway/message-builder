/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.AssignedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT120600CA.Author","COMT_MT300003CA.Author","MCAI_MT700210CA.Author","MCAI_MT700211CA.Author","MCAI_MT700212CA.Author","MCAI_MT700220CA.Author","MCAI_MT700221CA.Author","MCAI_MT700222CA.Author","MCAI_MT700230CA.Author","MCAI_MT700231CA.Author","MCAI_MT700232CA.Author","MFMI_MT700711CA.Author","MFMI_MT700751CA.Author","QUQI_MT020000CA.Author","QUQI_MT020002CA.Author","REPC_MT000005CA.Author","REPC_MT000006CA.Author","REPC_MT000009CA.Author"})
public class CreatedByBean extends MessagePartBean {

    private TS timeOfCreation = new TSImpl();
    private CV<ParticipationMode> informationReceivedMethod = new CVImpl<ParticipationMode>();
    private ED<String> digitalSignature = new EDImpl<String>();
    private AuthorPersonBean authorPerson;
    private HealthcareWorkerBean assignedEntity = new HealthcareWorkerBean();
    private AssignedPersonBean assignedPerson;

    @Hl7XmlMapping({"time"})
    public Date getTimeOfCreation() {
        return this.timeOfCreation.getValue();
    }
    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation.setValue(timeOfCreation);
    }

    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationReceivedMethod() {
        return this.informationReceivedMethod.getValue();
    }
    public void setInformationReceivedMethod(ParticipationMode informationReceivedMethod) {
        this.informationReceivedMethod.setValue(informationReceivedMethod);
    }

    @Hl7XmlMapping({"signatureText"})
    public java.lang.String getDigitalSignature() {
        return this.digitalSignature.getValue();
    }
    public void setDigitalSignature(java.lang.String digitalSignature) {
        this.digitalSignature.setValue(digitalSignature);
    }

    @Hl7XmlMapping({"authorPerson"})
    public AuthorPersonBean getAuthorPerson() {
        return this.authorPerson;
    }
    public void setAuthorPerson(AuthorPersonBean authorPerson) {
        this.authorPerson = authorPerson;
    }

    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

    @Hl7XmlMapping({"assignedPerson"})
    public AssignedPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(AssignedPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

}
