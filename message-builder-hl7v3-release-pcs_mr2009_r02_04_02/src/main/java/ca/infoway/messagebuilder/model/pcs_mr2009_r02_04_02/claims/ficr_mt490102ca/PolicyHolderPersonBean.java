/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT490102CA.PolicyHolderPerson"})
public class PolicyHolderPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.PolicyHolderChoice {

    private static final long serialVersionUID = 20110831L;
    private PN policyHolderName = new PNImpl();


    /**
     * <p>Policy Holder Name</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getPolicyHolderName() {
        return this.policyHolderName.getValue();
    }
    public void setPolicyHolderName(PersonName policyHolderName) {
        this.policyHolderName.setValue(policyHolderName);
    }

}
