/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.consent.rcmr_mt010001ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.RequestedByBean;
import java.util.Date;



/**
 * <p>Consent</p>
 * 
 * <p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p>
 * 
 * <p>Provides authorization to record and/or view patient 
 * information.</p>
 * 
 * <p>If code is INFA, then InformDefinition must be present, 
 * otherwise it must be absent</p>
 * 
 * <p>One and only one of author1 (Consenter) and author2 
 * (Provider) must be specified</p>
 * 
 * <p>If author2 (provider) is specified, reasonCode must be 
 * specified</p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II consentFormNumber = new IIImpl();
    private CV consentType = new CVImpl();
    private BL consentRefusedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private RequestedByBean author1;
    private HealthcareWorkerBean author2AssignedEntity;
    private InformationAccessBean componentPermissionToInform;

    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActConsentType getConsentType() {
        return (ActConsentType) this.consentType.getValue();
    }
    public void setConsentType(ActConsentType consentType) {
        this.consentType.setValue(consentType);
    }

    @Hl7XmlMapping({"negationInd"})
    public Boolean getConsentRefusedIndicator() {
        return this.consentRefusedIndicator.getValue();
    }
    public void setConsentRefusedIndicator(Boolean consentRefusedIndicator) {
        this.consentRefusedIndicator.setValue(consentRefusedIndicator);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }

    @Hl7XmlMapping({"reasonCode"})
    public Code getConsentOverrideReason() {
        return (Code) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(Code consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }

    @Hl7XmlMapping({"author1"})
    public RequestedByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(RequestedByBean author1) {
        this.author1 = author1;
    }

    @Hl7XmlMapping({"author2/assignedEntity"})
    public HealthcareWorkerBean getAuthor2AssignedEntity() {
        return this.author2AssignedEntity;
    }
    public void setAuthor2AssignedEntity(HealthcareWorkerBean author2AssignedEntity) {
        this.author2AssignedEntity = author2AssignedEntity;
    }

    @Hl7XmlMapping({"component/permissionToInform"})
    public InformationAccessBean getComponentPermissionToInform() {
        return this.componentPermissionToInform;
    }
    public void setComponentPermissionToInform(InformationAccessBean componentPermissionToInform) {
        this.componentPermissionToInform = componentPermissionToInform;
    }

}
