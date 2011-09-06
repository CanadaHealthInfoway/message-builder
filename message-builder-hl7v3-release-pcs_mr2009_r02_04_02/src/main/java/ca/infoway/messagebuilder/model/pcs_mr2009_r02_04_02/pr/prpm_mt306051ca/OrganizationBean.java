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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt306051ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Organization</p>
 * 
 * <p><p>The scoping organization for the specified role 
 * class</p></p>
 * 
 * <p><p>Supports the requirement to supply additional 
 * information regarding the assigning Organization of the 
 * specified RoleClass</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private II organizationId = new IIImpl();
    private ST issuingRepresentingQualificationGrantingOrganizationNameS = new STImpl();
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Organization Id</p>
     * 
     * <p><p>The unique identifier of the Organization.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getOrganizationId() {
        return this.organizationId.getValue();
    }
    public void setOrganizationId(Identifier organizationId) {
        this.organizationId.setValue(organizationId);
    }


    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Name(s</p>
     * 
     * <p><p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getIssuingRepresentingQualificationGrantingOrganizationNameS() {
        return this.issuingRepresentingQualificationGrantingOrganizationNameS.getValue();
    }
    public void setIssuingRepresentingQualificationGrantingOrganizationNameS(String issuingRepresentingQualificationGrantingOrganizationNameS) {
        this.issuingRepresentingQualificationGrantingOrganizationNameS.setValue(issuingRepresentingQualificationGrantingOrganizationNameS);
    }


    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
