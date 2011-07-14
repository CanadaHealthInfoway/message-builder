/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;



/**
 * <p>REPC_MT000010CA.ControlActEvent: Medical Condition Status 
 * Changes</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
 * indicates the history of changes that have been made to the 
 * medical condition record, including why the changes were 
 * made, who made them and when.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides an 
 * audit trail of a patient's medical condition changes.</p></p>
 * 
 * <p>REPC_MT000009CA.ControlActEvent: Allergy/Intolerance 
 * Status Changes</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This records 
 * the history of changes that have been made to the 
 * allergy/intolerance, including why the changes were made, 
 * who made them and when.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
 * record of a patient's allergy changes, providing deeper 
 * clinical understanding, particularly of past clinical 
 * decisions.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000009CA.ControlActEvent","REPC_MT000010CA.ControlActEvent"})
public class MedicalConditionStatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private ProviderBean responsiblePartyAssignedPerson;


    /**
     * <p>C:Medical Condition Status Change Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * what kind of change occurred.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
     * attribute is mandatory to ensure that change types are 
     * distinguishable.</p></p>
     * 
     * <p>A:Allergy/Intolerance Status Change Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * what kind of change occurred. Allergy/Intolerance change 
     * types are Revise, Reactivate and Complete.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This 
     * attribute is mandatory to ensure that change types are 
     * distinguishable.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>B:Allergy/intolerance Status Change Effective Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the various changes of an allergy/intolerance become 
     * valid and applicable.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * applications to sort and filter by time. The date on which a 
     * change is effective should always be known and thus is 
     * mandatory.</p></p>
     * 
     * <p>A:Medical Condition Status Change Effective Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date on 
     * which the changes to the medical condition become valid and 
     * applicable.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * applications to sort and filter by time.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The effective date 
     * can be defaulted to change date, and thus is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * applications to sort and filter by time.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The effective date 
     * can be defaulted to change date, and thus is mandatory.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>C:Allergy/Intolerance Status Change Reason</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes the 
     * reason the the allergy/intolerance was changed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures 
     * consistent terminology in capturing and interpreting reasons 
     * for change. Allows CWE because not all reasons will 
     * correspond to a pre-defined code.</p></p>
     * 
     * <p>B:Medical Condition Status Change Reason</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes the 
     * reason the medical condition record was changed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Ensures 
     * consistent terminology in capturing and interpreting reasons 
     * for change. Allows CWE because not all reasons will 
     * correspond to a pre-defined code.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }

}
