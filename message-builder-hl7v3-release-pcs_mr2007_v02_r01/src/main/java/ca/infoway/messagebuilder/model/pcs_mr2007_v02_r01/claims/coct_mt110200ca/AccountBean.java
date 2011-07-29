/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt110200ca;

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



@Hl7PartTypeMapping({"COCT_MT110200CA.Account"})
@Hl7RootType
public class AccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II accountID = new IIImpl();
    private CV typeOfCreditCard = new CVImpl();
    private ST nameOnCreditCard = new STImpl();
    private TS expiryDateOnCreditCard = new TSImpl();
    private PayeeRoleBean holderPayeeRole;


    /**
     * <p>Account ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAccountID() {
        return this.accountID.getValue();
    }
    public void setAccountID(Identifier accountID) {
        this.accountID.setValue(accountID);
    }


    /**
     * <p>Type of credit card</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getTypeOfCreditCard() {
        return (Code) this.typeOfCreditCard.getValue();
    }
    public void setTypeOfCreditCard(Code typeOfCreditCard) {
        this.typeOfCreditCard.setValue(typeOfCreditCard);
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
     * <p>expiry date on credit card</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getExpiryDateOnCreditCard() {
        return this.expiryDateOnCreditCard.getValue();
    }
    public void setExpiryDateOnCreditCard(Date expiryDateOnCreditCard) {
        this.expiryDateOnCreditCard.setValue(expiryDateOnCreditCard);
    }


    @Hl7XmlMapping({"holder/payeeRole"})
    public PayeeRoleBean getHolderPayeeRole() {
        return this.holderPayeeRole;
    }
    public void setHolderPayeeRole(PayeeRoleBean holderPayeeRole) {
        this.holderPayeeRole = holderPayeeRole;
    }

}
