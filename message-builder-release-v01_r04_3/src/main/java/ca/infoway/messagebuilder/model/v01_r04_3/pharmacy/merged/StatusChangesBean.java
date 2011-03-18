/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090302ca.ApplicationBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060010CA.ControlActEvent","PORX_MT060040CA.ControlActEvent","PORX_MT060090CA.ControlActEvent","PORX_MT060160CA.ControlActEvent","PORX_MT060210CA.ControlActEvent","PORX_MT060340CA.ControlActEvent"})
public class StatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ProviderBean responsiblePartyAssignedPerson;
    private CV reasonCode = new CVImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ChangedBy authorChangedBy;
    private TS changeTimestamp = new TSImpl();


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Change Reason</p>
     * 
     * <p>Dispense Status Change Reason</p>
     * 
     * <p>Other Medication Status Change Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Dispense Status Change Type</p>
     * 
     * <p>Other Medication Status Change Type</p>
     * 
     * <p>Change Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Other Medication Status Change Effective Period</p>
     * 
     * <p>Dispense Status Change Effective Date</p>
     * 
     * <p>Change Effective Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"author/changedBy"})
    public ChangedBy getAuthorChangedBy() {
        return this.authorChangedBy;
    }
    public void setAuthorChangedBy(ChangedBy authorChangedBy) {
        this.authorChangedBy = authorChangedBy;
    }

    public ProviderBean getAuthorChangedByAsAssignedPerson() {
        return this.authorChangedBy instanceof ProviderBean ? (ProviderBean) this.authorChangedBy : null;
    }
    public boolean hasAuthorChangedByAsAssignedPerson() {
        return (this.authorChangedBy instanceof ProviderBean);
    }

    public ApplicationBean getAuthorChangedByAsAssignedDevice() {
        return this.authorChangedBy instanceof ApplicationBean ? (ApplicationBean) this.authorChangedBy : null;
    }
    public boolean hasAuthorChangedByAsAssignedDevice() {
        return (this.authorChangedBy instanceof ApplicationBean);
    }


    /**
     * <p>ChangeTimestamp</p>
     * 
     * <p>Change Timestamp</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getChangeTimestamp() {
        return this.changeTimestamp.getValue();
    }
    public void setChangeTimestamp(Date changeTimestamp) {
        this.changeTimestamp.setValue(changeTimestamp);
    }

}
