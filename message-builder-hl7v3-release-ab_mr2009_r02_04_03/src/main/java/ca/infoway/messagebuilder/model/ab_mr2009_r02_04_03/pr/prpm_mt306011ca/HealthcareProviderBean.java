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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.prpm_mt306011ca;

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
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.merged.ConfidenceValueBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.PrinicpalPerson_2Bean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.PrivilegeBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.RegistrationEventBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.StatusChangeDetailsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Healthcare Provider</p>
 * 
 * <p>Roleclass required to support the identification of 
 * person responsible for providing healthcare services</p>
 * 
 * <p>This roles the specific Healthcare provider role such as 
 * a Physician, Nurse or other type of caregivers.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements Choice, RoleChoice {

    private static final long serialVersionUID = 20150814L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_2Bean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;
    private RegistrationEventBean subjectOf1RegistrationEvent;
    private List<StatusChangeDetailsBean> subjectOf2StateTransitionControlActEvent = new ArrayList<StatusChangeDetailsBean>();
    private ConfidenceValueBean subjectOf3ObservationEvent;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();


    /**
     * <p>Business Name: Healthcare Provider Role Identification</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-50)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>A unique identifier for a provider in a specific 
     * healthcare role.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Healthcare Provider Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific healthcare provider 
     * role.</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific healthcare provider 
     * role.</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider'''s name pertaining to the specific 
     * healthcare provider role.</p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Business Name: Healthcare Provider Role Address</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The address for the provider when playing the role of 
     * healthcare provider.</p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>Business Name: Healthcare Provider Role Telecom</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.HealthCareProvider.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The telecom for the provider when playing the role of 
     * healthcare provider.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Business Name: Healthcare Provider Role Status Code</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The status of the provider in the healthcare provider 
     * role i.e. Active</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Status Code</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The status of the provider in the healthcare provider 
     * role i.e. Active</p>
     */
    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Effective Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The effective date of the provider in the healthcare 
     * provider role.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Effective Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The effective date of the provider in the healthcare 
     * provider role.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.healthCarePrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"healthCarePrincipalPerson"})
    public PrinicpalPerson_2Bean getHealthCarePrincipalPerson() {
        return this.healthCarePrincipalPerson;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.healthCarePrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setHealthCarePrincipalPerson(PrinicpalPerson_2Bean healthCarePrincipalPerson) {
        this.healthCarePrincipalPerson = healthCarePrincipalPerson;
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.issuingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"issuingOrganization"})
    public OrganizationBean getIssuingOrganization() {
        return this.issuingOrganization;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.HealthCareProvider.issuingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIssuingOrganization(OrganizationBean issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.Subject4.registrationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/registrationEvent"})
    public RegistrationEventBean getSubjectOf1RegistrationEvent() {
        return this.subjectOf1RegistrationEvent;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.Subject4.registrationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1RegistrationEvent(RegistrationEventBean subjectOf1RegistrationEvent) {
        this.subjectOf1RegistrationEvent = subjectOf1RegistrationEvent;
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject2.stateTransitionControlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/stateTransitionControlActEvent"})
    public List<StatusChangeDetailsBean> getSubjectOf2StateTransitionControlActEvent() {
        return this.subjectOf2StateTransitionControlActEvent;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.Subject3.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/observationEvent"})
    public ConfidenceValueBean getSubjectOf3ObservationEvent() {
        return this.subjectOf3ObservationEvent;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.Subject3.observationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3ObservationEvent(ConfidenceValueBean subjectOf3ObservationEvent) {
        this.subjectOf3ObservationEvent = subjectOf3ObservationEvent;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.ResponsibleParty.privilege</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.RoleChoice.relatedTo</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
    }

}
