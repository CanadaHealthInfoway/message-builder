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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Payee Organisation</p>
 * 
 * <p><p>Organisation receiving payment.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20110729L;
    private PayeeRelationshipRoleBean asRole;
    private ST payeeOrganisationName = new STImpl();
    private AD payeeOrganisationAddress = new ADImpl();


    @Hl7XmlMapping({"asRole"})
    public PayeeRelationshipRoleBean getAsRole() {
        return this.asRole;
    }
    public void setAsRole(PayeeRelationshipRoleBean asRole) {
        this.asRole = asRole;
    }


    /**
     * <p>Payee Organisation name</p>
     * 
     * <p><p>name of organisation receiving payment.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getPayeeOrganisationName() {
        return this.payeeOrganisationName.getValue();
    }
    public void setPayeeOrganisationName(String payeeOrganisationName) {
        this.payeeOrganisationName.setValue(payeeOrganisationName);
    }


    /**
     * <p>Payee Organisation address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getPayeeOrganisationAddress() {
        return this.payeeOrganisationAddress.getValue();
    }
    public void setPayeeOrganisationAddress(PostalAddress payeeOrganisationAddress) {
        this.payeeOrganisationAddress.setValue(payeeOrganisationAddress);
    }

}
