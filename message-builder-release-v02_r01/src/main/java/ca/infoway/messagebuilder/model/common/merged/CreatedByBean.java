/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

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
import ca.infoway.messagebuilder.model.common.mcai_mt700231ca.NullAuthorRoleBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"MCAI_MT700210CA.Author","MCAI_MT700211CA.Author","MCAI_MT700212CA.Author","MCAI_MT700220CA.Author","MCAI_MT700221CA.Author","MCAI_MT700222CA.Author","MCAI_MT700230CA.Author","MCAI_MT700231CA.Author","MCAI_MT700232CA.Author","MFMI_MT700711CA.Author","MFMI_MT700751CA.Author","QUQI_MT020000CA.Author","QUQI_MT020002CA.Author"})
public class CreatedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ED<String> digitalSignature = new EDImpl<String>();
    private CV informationReceivedMethod = new CVImpl();
    private AuthorPerson authorPerson;
    private TS timeOfCreation = new TSImpl();


    /**
     * <p>DigitalSignature</p>
     * 
     * <p>G:Digital Signature</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getDigitalSignature() {
        return this.digitalSignature.getValue();
    }
    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature.setValue(digitalSignature);
    }


    /**
     * <p>InformationReceivedMethod</p>
     * 
     * <p>F:Information Received Method</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationReceivedMethod() {
        return (ParticipationMode) this.informationReceivedMethod.getValue();
    }
    public void setInformationReceivedMethod(ParticipationMode informationReceivedMethod) {
        this.informationReceivedMethod.setValue(informationReceivedMethod);
    }


    @Hl7XmlMapping({"authorPerson"})
    public AuthorPerson getAuthorPerson() {
        return this.authorPerson;
    }
    public void setAuthorPerson(AuthorPerson authorPerson) {
        this.authorPerson = authorPerson;
    }

    public NullAuthorRoleBean getAuthorPersonAsAuthorRole1() {
        return this.authorPerson instanceof NullAuthorRoleBean ? (NullAuthorRoleBean) this.authorPerson : null;
    }
    public boolean hasAuthorPersonAsAuthorRole1() {
        return (this.authorPerson instanceof NullAuthorRoleBean);
    }

    public HealthcareWorkerBean getAuthorPersonAsAssignedEntity1() {
        return this.authorPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.authorPerson : null;
    }
    public boolean hasAuthorPersonAsAssignedEntity1() {
        return (this.authorPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getAuthorPersonAsAssignedEntity2() {
        return this.authorPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.authorPerson : null;
    }
    public boolean hasAuthorPersonAsAssignedEntity2() {
        return (this.authorPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getAuthorPersonAsPersonalRelationship() {
        return this.authorPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.authorPerson : null;
    }
    public boolean hasAuthorPersonAsPersonalRelationship() {
        return (this.authorPerson instanceof RelatedPersonBean);
    }

    public ActingPerson getAuthorPersonAsActingPerson() {
        return this.authorPerson instanceof ActingPerson ? (ActingPerson) this.authorPerson : null;
    }
    public boolean hasAuthorPersonAsActingPerson() {
        return (this.authorPerson instanceof ActingPerson);
    }


    /**
     * <p>TimeOfCreation</p>
     * 
     * <p>D:Time of Creation</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTimeOfCreation() {
        return this.timeOfCreation.getValue();
    }
    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation.setValue(timeOfCreation);
    }

}
