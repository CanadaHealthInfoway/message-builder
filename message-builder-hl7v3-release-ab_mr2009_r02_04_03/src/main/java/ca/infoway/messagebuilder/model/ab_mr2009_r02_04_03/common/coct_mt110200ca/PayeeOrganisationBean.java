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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Payee Organisation</p>
 * 
 * <p>Organisation receiving payment.</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20190731L;
    private ST name = new STImpl();
    private AD addr = new ADImpl();
    private PayeeRelationshipRoleBean asRole;


    /**
     * <p>Business Name: Payee Organisation name</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of organisation receiving payment.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: Payee Organisation name</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of organisation receiving payment.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: Payee Organisation address</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeOrganization.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: Payee Organisation address</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeOrganization.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Relationship: COCT_MT110200CA.PayeeChoice.asRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"asRole"})
    public PayeeRelationshipRoleBean getAsRole() {
        return this.asRole;
    }

    /**
     * <p>Relationship: COCT_MT110200CA.PayeeChoice.asRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAsRole(PayeeRelationshipRoleBean asRole) {
        this.asRole = asRole;
    }

}
