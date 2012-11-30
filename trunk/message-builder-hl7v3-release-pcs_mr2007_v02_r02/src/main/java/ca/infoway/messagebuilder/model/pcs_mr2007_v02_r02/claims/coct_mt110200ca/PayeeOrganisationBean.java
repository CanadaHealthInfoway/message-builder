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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt110200ca;

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
 * <p>Organisation receiving payment.</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20121122L;
    private PayeeRelationshipRoleBean asPayeeRelationshipRole;
    private ST name = new STImpl();
    private AD addr = new ADImpl();


    @Hl7XmlMapping({"asPayeeRelationshipRole"})
    public PayeeRelationshipRoleBean getAsPayeeRelationshipRole() {
        return this.asPayeeRelationshipRole;
    }

    public void setAsPayeeRelationshipRole(PayeeRelationshipRoleBean asPayeeRelationshipRole) {
        this.asPayeeRelationshipRole = asPayeeRelationshipRole;
    }


    /**
     * <p>Payee Organisation name</p>
     * 
     * <p>name of organisation receiving payment.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Payee Organisation name</p>
     * 
     * <p>name of organisation receiving payment.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Payee Organisation address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Payee Organisation address</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

}
