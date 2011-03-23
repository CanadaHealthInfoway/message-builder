package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "MFMI_MT700711CA.Author", "QUQI_MT020000CA.Author", "MFMI_MT700751CA.Author", "COCT_MT120600CA.Author", "MCAI_MT700210CA.Author", "PORX_MT020070CA.Author", "PORX_MT060010CA.Author6", "PORX_MT060040CA.Author", "PORX_MT060040CA.Author4", "PORX_MT060060CA.Author", "PORX_MT060060CA.Author2", "PORX_MT060090CA.Author5", "PORX_MT980030CA.Author1", "PORX_MT980030CA.Author2", "REPC_MT000005CA.Author", "REPC_MT000007CA.Author", "PORX_MT030040CA.Author2", "REPC_MT000017CA.Author", "REPC_MT100001CA.Author", "REPC_MT210001CA.Author", "PORX_MT030040CA.Author", "PORX_MT020060CA.Author", "PORX_MT060190CA.Author2", "PORX_MT060190CA.Author3" })
public class AuthorBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -7391826388673357574L;

    @Hl7BusinessName("timeOfCreation")
    private TS time = new TSImpl();

    private AssignedPersonBean assignedPerson = new AssignedPersonBean();
    
    private ST organizationName = new STImpl();

    private CD signatureCode = new CDImpl();

    @Hl7XmlMapping("time")
    public Date getTime() {
        return this.time.getValue();
    }

    public void setTime(Date time) {
        this.time.setValue(time);
    }

    @Hl7XmlMapping({ "authorPerson", "choice0", "changedBy", "assignedPerson", "actingPerson" })
    public AssignedPerson getAuthorPerson() {
        return this.assignedPerson;
    }

    public void setAuthorPerson(AssignedPerson assignedPerson) {
        if (assignedPerson instanceof AssignedPersonBean) {
            this.assignedPerson = (AssignedPersonBean) assignedPerson;
        }
    }

    @Hl7XmlMapping({ "assignedEntity/assignedOrganization/name" })
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }

    @Hl7XmlMapping("signatureCode")
    public ParticipationSignature getSignatureCode() {
        return (ParticipationSignature) this.signatureCode.getValue();
    }

    public void setSignatureCode(ParticipationSignature signatureCode) {
        this.signatureCode.setValue(signatureCode);
    }

    public Identifier getId() {
        return this.assignedPerson.getId();
    }

    public void setId(Identifier identifier) {
        this.assignedPerson.setId(identifier);
    }

    public Identifier getLicenseNumber() {
        return this.assignedPerson.getLicenseNumber();
    }

    public void setLicenseNumber(Identifier identifier) {
        this.assignedPerson.setLicenseNumber(identifier);
    }

    public PersonName getName() {
        return this.assignedPerson.getName();
    }

    public void setName(PersonName personName) {
        this.assignedPerson.setName(personName);
    }
}
