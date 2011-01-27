/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT130001CA.ControlActEvent","REPC_MT000009CA.ControlActEvent","REPC_MT000010CA.ControlActEvent"})
@Hl7RootType
public class VersionInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private RefusedByBean author;
    private CV reasonCode = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV code = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private II changeIdentifier = new IIImpl();


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>C:Allergy/Intolerance Status Change Reason</p>
     * 
     * <p>B:Medical Condition Status Change Reason</p>
     * 
     * <p>D:Change Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>B:Allergy/intolerance Status Change Effective Date</p>
     * 
     * <p>A:Medical Condition Status Change Effective Date</p>
     * 
     * <p>C:Change Effective Date and End Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>A:Change Type</p>
     * 
     * <p>A:Allergy/Intolerance Status Change Type</p>
     * 
     * <p>C:Medical Condition Status Change Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>ChangeIdentifier</p>
     * 
     * <p>B:Change Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getChangeIdentifier() {
        return this.changeIdentifier.getValue();
    }
    public void setChangeIdentifier(Identifier changeIdentifier) {
        this.changeIdentifier.setValue(changeIdentifier);
    }

}
