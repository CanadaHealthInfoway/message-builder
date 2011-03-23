/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt220001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT220001CA.Author"})
public class AuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private TS authoredDatetime = new TSImpl();
    private CV attestedIndicator = new CVImpl();
    private ActingPersonBean actingPerson;

    @Hl7XmlMapping({"time"})
    public Date getAuthoredDatetime() {
        return this.authoredDatetime.getValue();
    }
    public void setAuthoredDatetime(Date authoredDatetime) {
        this.authoredDatetime.setValue(authoredDatetime);
    }

    @Hl7XmlMapping({"signatureCode"})
    public ParticipationSignature getAttestedIndicator() {
        return (ParticipationSignature) this.attestedIndicator.getValue();
    }
    public void setAttestedIndicator(ParticipationSignature attestedIndicator) {
        this.attestedIndicator.setValue(attestedIndicator);
    }

    @Hl7XmlMapping({"actingPerson"})
    public ActingPersonBean getActingPerson() {
        return this.actingPerson;
    }
    public void setActingPerson(ActingPersonBean actingPerson) {
        this.actingPerson = actingPerson;
    }

    public HealthcareWorkerBean getActingPersonAsAssignedEntity1() {
        return this.actingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsAssignedEntity1() {
        return (this.actingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getActingPersonAsAssignedEntity2() {
        return this.actingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsAssignedEntity2() {
        return (this.actingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getActingPersonAsPersonalRelationship() {
        return this.actingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsPersonalRelationship() {
        return (this.actingPerson instanceof RelatedPersonBean);
    }

}
