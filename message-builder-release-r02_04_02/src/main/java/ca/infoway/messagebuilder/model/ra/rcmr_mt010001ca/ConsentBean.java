/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ra.rcmr_mt010001ca;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PrescribedByBean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p><p>If code is INFA, then InformDefinition must be 
 * present, otherwise it must be absent</p><p>One and only one 
 * of author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p></p>
 * 
 * <p><p>If code is INFA, then InformDefinition must be 
 * present, otherwise it must be absent</p><p>One and only one 
 * of author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p></p>
 * 
 * <p><p>If code is INFA, then InformDefinition must be 
 * present, otherwise it must be absent</p><p>One and only one 
 * of author1 (Consenter) and author2 (Provider) must be 
 * specified</p><p>If author2 (provider) is specified, 
 * reasonCode must be specified</p></p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private ConsentedToByBean author1;
    private CV consentType = new CVImpl();
    private II consentFormNumber = new IIImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private BL consentRefusedIndicator = new BLImpl();
    private InformationAccessBean componentPermissionToInform;
    private CV consentOverrideReason = new CVImpl();
    private PrescribedByBean author2;


    @Hl7XmlMapping({"author1"})
    public ConsentedToByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(ConsentedToByBean author1) {
        this.author1 = author1;
    }


    /**
     * <p>A:Consent Type</p>
     * 
     * <p><p>Indicates the type of consent being given: Information 
     * access or Information maintenance.</p></p>
     * 
     * <p><p>Distinguishes what type of consent is being dealt with 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActConsentType getConsentType() {
        return (ActConsentType) this.consentType.getValue();
    }
    public void setConsentType(ActConsentType consentType) {
        this.consentType.setValue(consentType);
    }


    /**
     * <p>D:Consent Form Number</p>
     * 
     * <p><p>A unique identifier for a specific consent for a 
     * patient.</p></p>
     * 
     * <p><p>Provides a traceable audit link between a physical 
     * consent form and its electronic record</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }


    /**
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p><p>Indicates the time that the consent will expire. 'Low' 
     * is effective time and 'High' is end time.</p></p>
     * 
     * <p><p>Most consents are not open-ended, to ensure the 
     * patient retains a level of control</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }


    /**
     * <p>B:Consent Refused Indicator</p>
     * 
     * <p><p>Must be either not present or non-null.</p></p>
     * 
     * <p><p>If true, indicates that consent has explicitly *not* 
     * been given.</p></p>
     * 
     * <p><p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p></p>
     * 
     * <p><p>Primarily applies for global &quot;participation&quot; 
     * consent, when there is a need to track whether the patient 
     * has consented, not consented, or has not recorded a 
     * decision.</p><p>Because not all jurisdictions will track 
     * &quot;participation&quot; consent, this attribute is 
     * optional. In jurisdictions where it is supported, the 
     * element must always be valued as either true or false.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getConsentRefusedIndicator() {
        return this.consentRefusedIndicator.getValue();
    }
    public void setConsentRefusedIndicator(Boolean consentRefusedIndicator) {
        this.consentRefusedIndicator.setValue(consentRefusedIndicator);
    }


    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }


    /**
     * <p>E:Consent Override Reason</p>
     * 
     * <p><p>Indicates a reason for overriding a patient's consent 
     * rules or accessing information without consent.</p></p>
     * 
     * <p><p>Important for audit purposes</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Code getConsentOverrideReason() {
        return (Code) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(Code consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    @Hl7XmlMapping({"author2"})
    public PrescribedByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(PrescribedByBean author2) {
        this.author2 = author2;
    }

}
