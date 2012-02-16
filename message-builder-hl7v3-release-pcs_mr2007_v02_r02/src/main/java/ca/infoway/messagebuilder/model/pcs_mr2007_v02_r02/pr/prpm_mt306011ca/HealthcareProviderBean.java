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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.PrinicpalPerson_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.Date;
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
@Hl7PartTypeMapping({"PRPM_MT306011CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Choice, RoleChoice {

    private static final long serialVersionUID = 20120215L;
    private List<ResponsiblePartyBean> responsibleFor = new ArrayList<ResponsiblePartyBean>();
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV code = new CVImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_2Bean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;


    @Hl7XmlMapping({"responsibleFor"})
    public List<ResponsiblePartyBean> getResponsibleFor() {
        return this.responsibleFor;
    }


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


    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
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
     * <p><p>The providers name pertaining to the specific 
     * healthcare provider role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Healthcare Provider Role Address</p>
     * 
     * <p><p>The address for the provider when playing the role of 
     * healthcare provider.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>Healthcare Provider Role Telecom</p>
     * 
     * <p><p>The telecom for the provider when playing the role of 
     * healthcare provider.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Healthcare Provider Role Status Code</p>
     * 
     * <p><p>The status of the provider in the healthcare provider 
     * role i.e. Active</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Healthcare Provider Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider in the healthcare 
     * provider role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
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
