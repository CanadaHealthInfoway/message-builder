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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Organization</p>
 * 
 * <p>Supports the requirement to supply additional information 
 * regarding the assigning Organization of the specified 
 * RoleClass</p>
 * 
 * <p>The scoping organization for the specified role class</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private ST name = new STImpl();
    private SET<AD, PostalAddress> addr = new SETImpl<AD, PostalAddress>(ADImpl.class);
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Business Name: Organization Id</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the scoping organization assigning the id 
     * to the specified roleClass</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Organization Id</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the scoping organization assigning the id 
     * to the specified roleClass</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: (Issuing Representing Qualification 
     * Granting Organization Name(s</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: (Issuing Representing Qualification 
     * Granting Organization Name(s</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: (Issuing Representing Qualification 
     * Granting Organization Address(es</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Organization.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     */
    @Hl7XmlMapping({"addr"})
    public Set<PostalAddress> getAddr() {
        return this.addr.rawSet();
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Organization.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Organization.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
