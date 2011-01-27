/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT490102CA.PolicyHolderOrganization"})
public class PolicyHolderOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.claims.merged.PolicyHolderChoice {

    private static final long serialVersionUID = 20110127L;
    private TN policyHolderOrganizationName = new TNImpl();


    /**
     * <p>Policy Holder Organization Name</p>
     */
    @Hl7XmlMapping({"name"})
    public TrivialName getPolicyHolderOrganizationName() {
        return this.policyHolderOrganizationName.getValue();
    }
    public void setPolicyHolderOrganizationName(TrivialName policyHolderOrganizationName) {
        this.policyHolderOrganizationName.setValue(policyHolderOrganizationName);
    }

}
