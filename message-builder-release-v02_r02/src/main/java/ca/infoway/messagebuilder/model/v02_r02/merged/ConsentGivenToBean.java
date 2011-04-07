/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.common.merged.HealthcareWorkerBean;



/**
 * <p>ConsentGivenTo</p>
 * 
 * <p>RCMR_MT010001CA.Receiver: *consent given to</p>
 * 
 * <p><p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p></p>
 * 
 * <p><p>Indicates who is being authorized to receive the 
 * information, and is therefore populated.</p></p>
 * 
 * <p>COCT_MT470012CA.Receiver: *consent given to</p>
 * 
 * <p><p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p></p>
 * 
 * <p><p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p></p>
 * 
 * <p><p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p></p>
 * 
 * <p>COCT_MT470002CA.Receiver: *consent given to</p>
 * 
 * <p><p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p></p>
 * 
 * <p><p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p></p>
 * 
 * <p><p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.Receiver","COCT_MT470012CA.Receiver","RCMR_MT010001CA.Receiver"})
public class ConsentGivenToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private Recipient recipient;


    @Hl7XmlMapping({"recipient"})
    public Recipient getRecipient() {
        return this.recipient;
    }
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public HealthcareWorkerBean getRecipientAsAssignedEntity() {
        return this.recipient instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.recipient : null;
    }
    public boolean hasRecipientAsAssignedEntity() {
        return (this.recipient instanceof HealthcareWorkerBean);
    }

    public ServiceLocationBean getRecipientAsServiceDeliveryLocation() {
        return this.recipient instanceof ServiceLocationBean ? (ServiceLocationBean) this.recipient : null;
    }
    public boolean hasRecipientAsServiceDeliveryLocation() {
        return (this.recipient instanceof ServiceLocationBean);
    }

}
