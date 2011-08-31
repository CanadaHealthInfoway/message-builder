/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Payee Relationship Role</p>
 * 
 * <p><p>Indicates whether payee is Person or Organisation</p></p>
 * 
 * <p><p>Covered Party/Patient is the scoper of this role, but 
 * is not necessary in this CMET</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.Role"})
public class PayeeRelationshipRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CS accountPayeePolicyRelationshipRole = new CSImpl();


    /**
     * <p>Account Payee Policy Relationship Role</p>
     * 
     * <p><p>Invoice Adjudication Results</p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public Code getAccountPayeePolicyRelationshipRole() {
        return (Code) this.accountPayeePolicyRelationshipRole.getValue();
    }
    public void setAccountPayeePolicyRelationshipRole(Code accountPayeePolicyRelationshipRole) {
        this.accountPayeePolicyRelationshipRole.setValue(accountPayeePolicyRelationshipRole);
    }

}
