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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt303010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Organization</p>
 * 
 * <p>The scoping organization for the specified role class</p>
 * 
 * <p>Supports the requirement to supply additional information 
 * regarding the assigning Organization of the specified 
 * RoleClass</p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private ST name = new STImpl();
    private AD addr = new ADImpl();
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Organization Id</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the scoping organization assigning the id 
     * to the specified roleClass</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Organization Id</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * specified roleClass identifier.</p><p>Required attribute 
     * supports the validation and identification of the specified 
     * roleClass.</p><p>Issuing Representing Qualification Granting 
     * Organization Name(s)</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a providers functional role.</p><p>3. Organization that 
     * grants the qualifications or expertise.</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the scoping organization assigning the id 
     * to the specified roleClass</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Name(s</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Name(s</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>1. Organization that is responsible for registering the 
     * provider for a specific healthcare provider role.</p><p>2. 
     * Organization associated with a providers functional 
     * role.</p><p>3. Organization that grants the qualifications 
     * or expertise.</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Address(es)</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Address(es)</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Address for any of the supported roles</p><p>1. Issuing 
     * Oganization</p><p>2. Representing Organization</p><p>3. 
     * Qualification Granting Organization</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
