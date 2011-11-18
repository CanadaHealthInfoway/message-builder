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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306051ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.PrinicpalPerson_2Bean;
import java.util.List;
import java.util.Set;



/**
 * <p>Healthcare Provider</p>
 * 
 * <p><p>This roles the specific Healthcare provider role such 
 * as a Physician, Nurse or other type of caregivers.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * person responsible for providing healthcare services</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20111117L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private PrinicpalPerson_2Bean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;


    /**
     * <p>Healthcare Provider Role Identification</p>
     * 
     * <p><p>A unique identifier for a provider in a specific 
     * healthcare role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Healthcare Provider Role Type</p>
     * 
     * <p><p>The code identifying the specific healthcare provider 
     * role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Healthcare Provider Role Name</p>
     * 
     * <p><p>The provider's name pertaining to the specific 
     * healthcare provider role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    @Hl7XmlMapping({"healthCarePrincipalPerson"})
    public PrinicpalPerson_2Bean getHealthCarePrincipalPerson() {
        return this.healthCarePrincipalPerson;
    }
    public void setHealthCarePrincipalPerson(PrinicpalPerson_2Bean healthCarePrincipalPerson) {
        this.healthCarePrincipalPerson = healthCarePrincipalPerson;
    }


    @Hl7XmlMapping({"issuingOrganization"})
    public OrganizationBean getIssuingOrganization() {
        return this.issuingOrganization;
    }
    public void setIssuingOrganization(OrganizationBean issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

}
