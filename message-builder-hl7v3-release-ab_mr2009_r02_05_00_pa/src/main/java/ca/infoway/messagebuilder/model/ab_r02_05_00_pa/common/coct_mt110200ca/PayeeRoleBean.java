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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Payee Role</p>
 * 
 * <p>Payee: (1) Provider or designate organization with 
 * identifier plays the role of Payee - PayeeRole.id only (no 
 * Account, Person info) (2) Payee is an individual listed on 
 * the insurance (e.g. policy holder or covered party) - 
 * PayeeRole.id must not be specified - Specify 
 * PayeeRelationshipRole (e.g. Policy Holder) - Optionally 
 * specify name, addr, language, bank account info - Account 
 * bank info is likely on file with Payor and is NOT required 
 * for direct deposit - PayeePerson.addr is likely on file with 
 * Payor and is NOT required for mailing of cheque (3) Payee is 
 * an individual not listed on the insurance (e.g. guarantor) - 
 * PayeeRole.id must not be specified - Specify 
 * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
 * name, addr, language, bank account info - Account bank info 
 * is likely NOT on file with Payor and is required for direct 
 * deposit - PayeePerson.addr is likely NOT on file with Payor 
 * and is required for mailing of cheque</p>
 * 
 * <p>Role of payee - being played by Organisation, Person</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeRole"})
public class PayeeRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private PayeeChoice payeeChoice;


    /**
     * <p>Business Name: payee identifier</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Payee:</p><p>(1) Provider or designate organization with 
     * identifier plays the role of Payee</p><p>- PayeeRole.id only 
     * (no Account, Person info)</p><p>(2) Payee is an individual 
     * listed on the insurance (e.g. policy holder or covered 
     * party)</p><p>- PayeeRole.id must not be specified</p><p>- 
     * Specify PayeeRelationshipRole (e.g. Policy Holder)</p><p>- 
     * Optionally specify name, addr, language, bank account 
     * info</p><p>- Account bank info is likely on file with Payor 
     * and is NOT required for direct deposit</p><p>- 
     * PayeePerson.addr is likely on file with Payor and is NOT 
     * required for mailing of cheque</p><p>(3) Payee is an 
     * individual not listed on the insurance (e.g. guarantor) - 
     * PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p>
     * 
     * <p>Policy Holder or covered party</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Relationship: COCT_MT110200CA.PayeeRole.payeeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"payeeChoice"})
    public PayeeChoice getPayeeChoice() {
        return this.payeeChoice;
    }

    /**
     * <p>Relationship: COCT_MT110200CA.PayeeRole.payeeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
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