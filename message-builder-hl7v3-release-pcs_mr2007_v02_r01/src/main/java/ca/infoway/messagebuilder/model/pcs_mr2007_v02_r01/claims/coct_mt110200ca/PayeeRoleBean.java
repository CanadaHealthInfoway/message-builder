/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeRole"})
public class PayeeRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private PayeeChoice payeeChoice;


    /**
     * <p>payee identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"payeeChoice"})
    public PayeeChoice getPayeeChoice() {
        return this.payeeChoice;
    }
    public void setPayeeChoice(PayeeChoice payeeChoice) {
        this.payeeChoice = payeeChoice;
    }

    public PayeePersonBean getPayeeChoiceAsPayeePerson() {
        return this.payeeChoice instanceof PayeePersonBean ? (PayeePersonBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeePerson() {
        return (this.payeeChoice instanceof PayeePersonBean);
    }

    public PayeeOrganisationBean getPayeeChoiceAsPayeeOrganization() {
        return this.payeeChoice instanceof PayeeOrganisationBean ? (PayeeOrganisationBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeeOrganization() {
        return (this.payeeChoice instanceof PayeeOrganisationBean);
    }

}
