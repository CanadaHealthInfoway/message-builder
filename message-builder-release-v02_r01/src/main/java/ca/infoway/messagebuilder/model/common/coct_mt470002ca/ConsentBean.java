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
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 * 
 * <p>The keywords will not be passed from prescriber to 
 * dispenser by the DIS.</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p>
 * 
 * <p>Indicates the consent or keyword used to authorize access 
 * or update, including a reason for access; May also be used 
 * to override access restriction to the information ('break 
 * the glass') on a message by message basis. May be required 
 * on a Prescription Request to indicate a keyword for DUR 
 * processing.</p>
 * 
 * <p>One and only one of author2 (Consenter) and author1 
 * (Provider) must be specified.</p>
 * 
 * <p>If author1 (provider) is specified, reason code must be 
 * specified.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II consentFormNumber = new IIImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private SubjectChoiceBean subject1SubjectChoice;
    private HealthcareWorkerBean author1AssignedEntity;
    private ConsentedToByBean author2;
    private ControlsBean subject2;

    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }

    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }

    @Hl7XmlMapping({"subject1/subjectChoice"})
    public SubjectChoiceBean getSubject1SubjectChoice() {
        return this.subject1SubjectChoice;
    }
    public void setSubject1SubjectChoice(SubjectChoiceBean subject1SubjectChoice) {
        this.subject1SubjectChoice = subject1SubjectChoice;
    }

    @Hl7XmlMapping({"author1/assignedEntity"})
    public HealthcareWorkerBean getAuthor1AssignedEntity() {
        return this.author1AssignedEntity;
    }
    public void setAuthor1AssignedEntity(HealthcareWorkerBean author1AssignedEntity) {
        this.author1AssignedEntity = author1AssignedEntity;
    }

    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }

    @Hl7XmlMapping({"subject2"})
    public ControlsBean getSubject2() {
        return this.subject2;
    }
    public void setSubject2(ControlsBean subject2) {
        this.subject2 = subject2;
    }

}
