/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;



/**
 * <p>OrderForService</p>
 * 
 * <p>REPC_MT100001CA.ActRequest: Order for Service</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Represents 
 * the order or prescription against which the service was 
 * performed.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * linking the service to the person responsible for requesting 
 * it.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000017CA.ActRequest","REPC_MT100001CA.ActRequest"})
public class OrderForServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private RefusedByBean author;
    private ProviderBean responsiblePartyAssignedPerson;


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
