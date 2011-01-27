/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeRole"})
public class PayeeRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private PayeeChoice payeeChoice;
    private SET<II, Identifier> payeeIdentifier = new SETImpl<II, Identifier>(IIImpl.class);


    @Hl7XmlMapping({"payeeChoice"})
    public PayeeChoice getPayeeChoice() {
        return this.payeeChoice;
    }
    public void setPayeeChoice(PayeeChoice payeeChoice) {
        this.payeeChoice = payeeChoice;
    }

    public PayeePersonBean getPayeeChoiceAsPayeePerson() {
        return this.payeeChoice instanceof PayeePersonBean ? (PayeePersonBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeePerson() {
        return (this.payeeChoice instanceof PayeePersonBean);
    }

    public PayeeOrganisationBean getPayeeChoiceAsPayeeOrganization() {
        return this.payeeChoice instanceof PayeeOrganisationBean ? (PayeeOrganisationBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeeOrganization() {
        return (this.payeeChoice instanceof PayeeOrganisationBean);
    }


    /**
     * <p>payee identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPayeeIdentifier() {
        return this.payeeIdentifier.rawSet();
    }

}
