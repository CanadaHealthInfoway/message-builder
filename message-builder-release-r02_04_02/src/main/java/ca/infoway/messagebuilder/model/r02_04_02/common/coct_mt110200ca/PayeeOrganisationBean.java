/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Payee Organisation</p>
 * 
 * <p><p>Organisation receiving payment.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20110318L;
    private ST payeeOrganisationName = new STImpl();
    private AD payeeOrganisationAddress = new ADImpl();
    private PayeeRelationshipRoleBean asRole;


    /**
     * <p>Payee Organisation name</p>
     * 
     * <p><p>name of organisation receiving payment.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getPayeeOrganisationName() {
        return this.payeeOrganisationName.getValue();
    }
    public void setPayeeOrganisationName(String payeeOrganisationName) {
        this.payeeOrganisationName.setValue(payeeOrganisationName);
    }


    /**
     * <p>Payee Organisation address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getPayeeOrganisationAddress() {
        return this.payeeOrganisationAddress.getValue();
    }
    public void setPayeeOrganisationAddress(PostalAddress payeeOrganisationAddress) {
        this.payeeOrganisationAddress.setValue(payeeOrganisationAddress);
    }


    @Hl7XmlMapping({"asRole"})
    public PayeeRelationshipRoleBean getAsRole() {
        return this.asRole;
    }
    public void setAsRole(PayeeRelationshipRoleBean asRole) {
        this.asRole = asRole;
    }

}
