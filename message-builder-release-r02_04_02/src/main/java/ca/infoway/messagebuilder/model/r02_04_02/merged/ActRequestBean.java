/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>ReferencedRecord</p>
 * 
 * <p>COMT_MT001101CA.ActRequest: Referenced Record</p>
 * 
 * <p><p>References an existing event record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p>COMT_MT001103CA.ActEvent: Referenced Record</p>
 * 
 * <p><p>References an existing event record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p>COMT_MT001201CA.Role: Referenced Record</p>
 * 
 * <p><p>References an existing role record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the role to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the role to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT001101CA.ActRequest","COMT_MT001103CA.ActEvent","COMT_MT001201CA.Role","PORX_MT010140CA.ActRequest"})
@Hl7RootType
public class ActRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private BL preconditionVerificationEventCriterion = new BLImpl(false);


    /**
     * <p>Record Ids</p>
     * 
     * <p><p>The identifier assigned by the central system (EHR) to 
     * the Event record being referred to.</p></p>
     * 
     * <p><p>Allows the event record to be uniquely referenced and 
     * is therefore mandatory.</p></p>
     * 
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p>This is an identifier assigned to a specific 
     * medication order. The number remains constant across the 
     * lifetime of the order, regardless of the number of providers 
     * or pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced. 
     * Multiple identifiers are allowed to support assigning of 
     * prescription ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p>Record Ids</p>
     * 
     * <p><p>The identifier assigned by the registry to the role 
     * record being referred to</p></p>
     * 
     * <p><p>Allows the role record to be uniquely referenced and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }

}
