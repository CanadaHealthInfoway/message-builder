/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.OverriddenByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_1Bean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a patient's agreement/acceptance to have 
 * his/her clinical information electronically stored and 
 * shared.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * authorization to record and/or view patient information.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II consentFormNumber = new IIImpl();
    private CV consentType = new CVImpl();
    private BL consentRefusedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private ConsentedToByBean author1;
    private OverriddenByBean author2;
    private InformationAccessBean componentPermissionToInform;
    private Patient_1Bean subjectPatient;


    /**
     * <p>D:Consent Form Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a specific consent for a patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.formNumber</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * traceable audit link between a physical consent form and its 
     * electronic record</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }


    /**
     * <p>A:Consent Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of consent being given: Information access or 
     * Information maintenance.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes what 
     * type of consent is being dealt with and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActConsentType getConsentType() {
        return (ActConsentType) this.consentType.getValue();
    }
    public void setConsentType(ActConsentType consentType) {
        this.consentType.setValue(consentType);
    }


    /**
     * <p>B:Consent Refused Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If true, 
     * indicates that consent has explicitly *not* been given.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Primarily 
     * applies for global &quot;participation&quot; consent, when 
     * there is a need to track whether the patient has consented, 
     * not consented, or has not recorded a decision.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because not all 
     * jurisdictions will track &quot;participation&quot; consent, 
     * this attribute is optional. In jurisdictions where it is 
     * supported, the element must always be valued as either true 
     * or false.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Primarily 
     * applies for global &quot;participation&quot; consent, when 
     * there is a need to track whether the patient has consented, 
     * not consented, or has not recorded a decision.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because not all 
     * jurisdictions will track &quot;participation&quot; consent, 
     * this attribute is optional. In jurisdictions where it is 
     * supported, the element must always be valued as either true 
     * or false.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getConsentRefusedIndicator() {
        return this.consentRefusedIndicator.getValue();
    }
    public void setConsentRefusedIndicator(Boolean consentRefusedIndicator) {
        this.consentRefusedIndicator.setValue(consentRefusedIndicator);
    }


    /**
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the time that the consent will expire. 'Low' is effective 
     * time and 'High' is end time.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.endTime 
     * (high)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Most 
     * consents are not open-ended, to ensure the patient retains a 
     * level of control</p></p>
     * 
     * <p><p><strong>CeRx defines this as 0..1 but the effective 
     * time is required in PIN so this is mandatory.</strong></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>E:Consent Override Reason</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates a 
     * reason for overriding a patient's consent rules or accessing 
     * information without consent.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.reason 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.comment 
     * (original text)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.reason 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.comment 
     * (original text)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
     * for audit purposes</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    @Hl7XmlMapping({"author1"})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    @Hl7XmlMapping({"author2"})
    public OverriddenByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(OverriddenByBean author2) {
        this.author2 = author2;
    }


    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

}
