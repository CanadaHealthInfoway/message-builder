/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT500201CA.PolicyHolder"})
public class PolicyHolderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private PN policyHolderName = new PNImpl();
    private TS policyHolderDateOfBirth = new TSImpl();


    /**
     * <p>Policy Holder Name</p>
     */
    @Hl7XmlMapping({"policyHolderPerson/name"})
    public PersonName getPolicyHolderName() {
        return this.policyHolderName.getValue();
    }
    public void setPolicyHolderName(PersonName policyHolderName) {
        this.policyHolderName.setValue(policyHolderName);
    }


    /**
     * <p>Policy Holder Date of birth</p>
     */
    @Hl7XmlMapping({"policyHolderPerson/birthTime"})
    public Date getPolicyHolderDateOfBirth() {
        return this.policyHolderDateOfBirth.getValue();
    }
    public void setPolicyHolderDateOfBirth(Date policyHolderDateOfBirth) {
        this.policyHolderDateOfBirth.setValue(policyHolderDateOfBirth);
    }

}
