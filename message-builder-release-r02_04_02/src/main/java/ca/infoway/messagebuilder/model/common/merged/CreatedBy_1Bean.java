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
import ca.infoway.messagebuilder.model.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700221ca.NullAuthorRoleBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import java.util.Date;



/**
 * <p>CreatedBy</p>
 * 
 * <p>MCAI_MT700211CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>QUQI_MT020002CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>MCAI_MT700212CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700220CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>QUQI_MT020000CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>MCAI_MT700232CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700230CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700210CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700231CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700222CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700221CA.Author: a:*created by</p>
 * 
 * <p><p>If AuthorizationToken is specified and communicates 
 * author, the bare AuthorRole class must be specified, 
 * otherwise the R_ActingPerson CMET must be specified.</p></p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as follows:</p><p>1. 
 * 'identified' when supporting Patient Session 
 * Tokens.</p><p>2. 'informational' when passing through non 
 * Client- Registry patient for PHS or similar 
 * processing.</p><p>3. 'identified-confirmable' otherwise.</p></p>
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Author","MCAI_MT700211CA.Author","MCAI_MT700212CA.Author","MCAI_MT700220CA.Author","MCAI_MT700221CA.Author","MCAI_MT700222CA.Author","MCAI_MT700230CA.Author","MCAI_MT700231CA.Author","MCAI_MT700232CA.Author","QUQI_MT020000CA.Author","QUQI_MT020002CA.Author"})
public class CreatedBy_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private AuthorPerson authorPerson;
    private TS timeOfCreation = new TSImpl();
    private CV informationReceivedMethod = new CVImpl();
    private ED<String> digitalSignature = new EDImpl<String>();


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
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time a change is made is a critical piece of audit 
     * information and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTimeOfCreation() {
        return this.timeOfCreation.getValue();
    }
    public void setTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation.setValue(timeOfCreation);
    }


    /**
     * <p>InformationReceivedMethod</p>
     * 
     * <p>F:Information Received Method</p>
     * 
     * <p><p>Indicates how the person who recorded the event became 
     * aware of it.. E.g. Verbal, written, fax, etc.</p></p>
     * 
     * <p><p>May have ramifications for the audit trail and 
     * reliability of the information.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationReceivedMethod() {
        return (ParticipationMode) this.informationReceivedMethod.getValue();
    }
    public void setInformationReceivedMethod(ParticipationMode informationReceivedMethod) {
        this.informationReceivedMethod.setValue(informationReceivedMethod);
    }


    /**
     * <p>DigitalSignature</p>
     * 
     * <p>G:Digital Signature</p>
     * 
     * <p><p>Indicates the formal digital signature of the message 
     * content.</p></p>
     * 
     * <p><p>Digital signatures may be needed for authentication of 
     * message content. The attribute is marked as optional because 
     * it is not yet clear whether there is a use-case for this, or 
     * where it will be used.</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getDigitalSignature() {
        return this.digitalSignature.getValue();
    }
    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature.setValue(digitalSignature);
    }

}
