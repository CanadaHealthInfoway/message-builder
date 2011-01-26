/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.ChangedByBean;
import java.util.Date;



/**
 * <p>REPC_MT000010CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT000007CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT000009CA.ControlActEvent: Allergy/Intolerance 
 * Status Changes</p>
 * 
 * <p><p>This records the history of changes that have been 
 * made to the allergy/intolerance, including why the changes 
 * were made, who made them and when.</p></p>
 * 
 * <p><p>Provides a record of a patient's allergy changes, 
 * providing deeper clinical understanding, particularly of 
 * past clinical decisions.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000007CA.ControlActEvent","REPC_MT000009CA.ControlActEvent","REPC_MT000010CA.ControlActEvent"})
public class AllergyIntoleranceStatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private ChangedByBean author;
    private CV reasonCode = new CVImpl();
    private CV allergyIntoleranceStatusChangeType = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private TS allergyIntoleranceStatusChangeEffectiveDate = new TSImpl();


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    /**
     * <p>B:Amend Reason</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>C:Allergy/Intolerance Status Change Reason</p>
     * 
     * <p><p>Denotes the reason the allergy/intolerance was 
     * changed.</p></p>
     * 
     * <p><p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>AllergyIntoleranceStatusChangeType</p>
     * 
     * <p>A:Allergy/Intolerance Status Change Type</p>
     * 
     * <p><p>Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete.</p></p>
     * 
     * <p><p>This attribute is mandatory to ensure that change 
     * types are distinguishable.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getAllergyIntoleranceStatusChangeType() {
        return (HL7TriggerEventCode) this.allergyIntoleranceStatusChangeType.getValue();
    }
    public void setAllergyIntoleranceStatusChangeType(HL7TriggerEventCode allergyIntoleranceStatusChangeType) {
        this.allergyIntoleranceStatusChangeType.setValue(allergyIntoleranceStatusChangeType);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>AllergyIntoleranceStatusChangeEffectiveDate</p>
     * 
     * <p>B:Allergy/intolerance Status Change Effective Date</p>
     * 
     * <p><p>The date on which the various changes of an 
     * allergy/intolerance become valid and applicable.</p></p>
     * 
     * <p><p>Allows applications to sort and filter by time. The 
     * date on which a change is effective should always be known 
     * and thus is mandatory.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyIntoleranceStatusChangeEffectiveDate() {
        return this.allergyIntoleranceStatusChangeEffectiveDate.getValue();
    }
    public void setAllergyIntoleranceStatusChangeEffectiveDate(Date allergyIntoleranceStatusChangeEffectiveDate) {
        this.allergyIntoleranceStatusChangeEffectiveDate.setValue(allergyIntoleranceStatusChangeEffectiveDate);
    }

}
