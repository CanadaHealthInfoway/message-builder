/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.common.merged.ActingPerson;
import ca.infoway.messagebuilder.model.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT470002CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ConsentedToByBean author2;
    private CV consentOverrideReason = new CVImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private AccessTypeBean subject2InformDefinition;
    private PrescribedByBean author1;
    private II consentFormNumber = new IIImpl();
    private SubjectChoice subject1SubjectChoice;


    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }


    /**
     * <p>E:Consent Override Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    /**
     * <p>C:Consent Effective and End Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }


    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }


    @Hl7XmlMapping({"author1"})
    public PrescribedByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(PrescribedByBean author1) {
        this.author1 = author1;
    }


    /**
     * <p>D:Consent Form Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }


    @Hl7XmlMapping({"subject1/subjectChoice"})
    public SubjectChoice getSubject1SubjectChoice() {
        return this.subject1SubjectChoice;
    }
    public void setSubject1SubjectChoice(SubjectChoice subject1SubjectChoice) {
        this.subject1SubjectChoice = subject1SubjectChoice;
    }

    public PatientBean getSubject1SubjectChoiceAsPatient1() {
        return this.subject1SubjectChoice instanceof PatientBean ? (PatientBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsPatient1() {
        return (this.subject1SubjectChoice instanceof PatientBean);
    }

    public HealthcareWorkerBean getSubject1SubjectChoiceAsAssignedEntity1() {
        return this.subject1SubjectChoice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsAssignedEntity1() {
        return (this.subject1SubjectChoice instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getSubject1SubjectChoiceAsAssignedEntity2() {
        return this.subject1SubjectChoice instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsAssignedEntity2() {
        return (this.subject1SubjectChoice instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getSubject1SubjectChoiceAsPersonalRelationship() {
        return this.subject1SubjectChoice instanceof RelatedPersonBean ? (RelatedPersonBean) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsPersonalRelationship() {
        return (this.subject1SubjectChoice instanceof RelatedPersonBean);
    }

    public ActingPerson getSubject1SubjectChoiceAsActingPerson() {
        return this.subject1SubjectChoice instanceof ActingPerson ? (ActingPerson) this.subject1SubjectChoice : null;
    }
    public boolean hasSubject1SubjectChoiceAsActingPerson() {
        return (this.subject1SubjectChoice instanceof ActingPerson);
    }

}
