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

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private TS effectiveTime = new TSImpl();
    private PayeeRoleBean holderPayeeRole;


    /**
     * <p>Account ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Type of credit card</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>name on credit card</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>expiry date on credit card</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"holder/payeeRole"})
    public PayeeRoleBean getHolderPayeeRole() {
        return this.holderPayeeRole;
    }
    public void setHolderPayeeRole(PayeeRoleBean holderPayeeRole) {
        this.holderPayeeRole = holderPayeeRole;
    }

}
