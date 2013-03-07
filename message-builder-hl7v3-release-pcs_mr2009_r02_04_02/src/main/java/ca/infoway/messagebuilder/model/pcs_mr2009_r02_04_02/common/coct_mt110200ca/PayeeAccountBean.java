/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110200ca;

import java.util.Date;

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



/**
 * <p>Business Name: Payee Account</p>
 * 
 * <p>Payee Bank account, transit number, credit card, etc. for 
 * payment.</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.Account"})
@Hl7RootType
public class PayeeAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private TS effectiveTime = new TSImpl();
    private PayeeRoleBean holderPayeeRole;


    /**
     * <p>Business Name: Account ID</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Bank account information can be used to indicate where 
     * the Payer is instructed to direct deposit for a Payee who is 
     * not already known to the Payer.</p>
     * 
     * <p>Bank Account, transit number, credit card, etc.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Account ID</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Bank account information can be used to indicate where 
     * the Payer is instructed to direct deposit for a Payee who is 
     * not already known to the Payer.</p>
     * 
     * <p>Bank Account, transit number, credit card, etc.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Type of Account</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }

    /**
     * <p>Business Name: Type of Account</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: name on credit card</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: name on credit card</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: expiry date on credit card</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: expiry date on credit card</p>
     * 
     * <p>Relationship: COCT_MT110200CA.Account.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: COCT_MT110200CA.Holder.payeeRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"holder/payeeRole"})
    public PayeeRoleBean getHolderPayeeRole() {
        return this.holderPayeeRole;
    }

    /**
     * <p>Relationship: COCT_MT110200CA.Holder.payeeRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setHolderPayeeRole(PayeeRoleBean holderPayeeRole) {
        this.holderPayeeRole = holderPayeeRole;
    }

}
