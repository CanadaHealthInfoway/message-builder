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
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.x_RoleClassPayeePolicyRelationship;



/**
 * <p>Business Name: Payee Organisation</p>
 * 
 * <p>Organisation receiving payment.</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeOrganization"})
public class PayeeOrganisationBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20130613L;
    private ST name = new STImpl();
    private AD addr = new ADImpl();
    private CS asPayeeRelationshipRoleClassCode = new CSImpl();


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
     * <p>Relationship: 
     * COCT_MT110200CA.PayeeRelationshipRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"asPayeeRelationshipRole/classCode"})
    public x_RoleClassPayeePolicyRelationship getAsPayeeRelationshipRoleClassCode() {
        return (x_RoleClassPayeePolicyRelationship) this.asPayeeRelationshipRoleClassCode.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT110200CA.PayeeRelationshipRole.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAsPayeeRelationshipRoleClassCode(x_RoleClassPayeePolicyRelationship asPayeeRelationshipRoleClassCode) {
        this.asPayeeRelationshipRoleClassCode.setValue(asPayeeRelationshipRoleClassCode);
    }

}
