/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoiceBean {

    private ST payeeOrganisationName = new STImpl();
    private AD payeeOrganisationAddress = new ADImpl();

    @Hl7XmlMapping({"name"})
    public java.lang.String getPayeeOrganisationName() {
        return this.payeeOrganisationName.getValue();
    }
    public void setPayeeOrganisationName(java.lang.String payeeOrganisationName) {
        this.payeeOrganisationName.setValue(payeeOrganisationName);
    }

    @Hl7XmlMapping({"addr"})
    public PostalAddress getPayeeOrganisationAddress() {
        return this.payeeOrganisationAddress.getValue();
    }
    public void setPayeeOrganisationAddress(PostalAddress payeeOrganisationAddress) {
        this.payeeOrganisationAddress.setValue(payeeOrganisationAddress);
    }

}
