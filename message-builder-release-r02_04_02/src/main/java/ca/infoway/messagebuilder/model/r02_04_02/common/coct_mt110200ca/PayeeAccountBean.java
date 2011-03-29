/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt110200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Payee Account</p>
 * 
 * <p><p>Payee Bank account, transit number, credit card, etc. 
 * for payment.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.Account"})
@Hl7RootType
public class PayeeAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV typeOfAccount = new CVImpl();
    private PayeeRoleBean holderPayeeRole;
    private ST nameOnCreditCard = new STImpl();
    private II accountID = new IIImpl();
    private TS expiryDateOnCreditCard = new TSImpl();


    /**
     * <p>Type of Account</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getTypeOfAccount() {
        return (Code) this.typeOfAccount.getValue();
    }
    public void setTypeOfAccount(Code typeOfAccount) {
        this.typeOfAccount.setValue(typeOfAccount);
    }


    @Hl7XmlMapping({"holder/payeeRole"})
    public PayeeRoleBean getHolderPayeeRole() {
        return this.holderPayeeRole;
    }
    public void setHolderPayeeRole(PayeeRoleBean holderPayeeRole) {
        this.holderPayeeRole = holderPayeeRole;
    }


    /**
     * <p>name on credit card</p>
     */
    @Hl7XmlMapping({"title"})
    public String getNameOnCreditCard() {
        return this.nameOnCreditCard.getValue();
    }
    public void setNameOnCreditCard(String nameOnCreditCard) {
        this.nameOnCreditCard.setValue(nameOnCreditCard);
    }


    /**
     * <p>Account ID</p>
     * 
     * <p><p>Bank Account, transit number, credit card, etc.</p></p>
     * 
     * <p><p>Bank account information can be used to indicate where 
     * the Payer is instructed to direct deposit for a Payee who is 
     * not already known to the Payer.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAccountID() {
        return this.accountID.getValue();
    }
    public void setAccountID(Identifier accountID) {
        this.accountID.setValue(accountID);
    }


    /**
     * <p>expiry date on credit card</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getExpiryDateOnCreditCard() {
        return this.expiryDateOnCreditCard.getValue();
    }
    public void setExpiryDateOnCreditCard(Date expiryDateOnCreditCard) {
        this.expiryDateOnCreditCard.setValue(expiryDateOnCreditCard);
    }

}