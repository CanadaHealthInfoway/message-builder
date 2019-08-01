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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.PrinicpalPerson_1Bean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.PrivilegeBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged.RegistrationEventBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Qualified Entity</p>
 * 
 * <p>Roleclass required to provide additional information for 
 * the person responsible for providing healthcare services</p>
 * 
 * <p>This role describes specific qualifications that may be 
 * held the provider as a result of training or experience, but 
 * having no legal force. Example: a medical degree or diploma. 
 * The current model does not include role attributes such as 
 * name, addr and telecom because there are no known use cases 
 * in this domain where this role is contactable.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20190731L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private BL equivalenceInd = new BLImpl();
    private PrinicpalPerson_1Bean qualifiedPrincipalPerson;
    private OrganizationBean qualificationGrantingOrganization;
    private RegistrationEventBean subjectOf1RegistrationEvent;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();


    /**
     * <p>Business Name: Expertise Role Identifier</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.QualifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>Unique identifier for the Expertise.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Expertise Role Type</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.QualifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>If Expertise or Credentials are included in the message, 
     * then Role Type Must Exist.</p>
     * 
     * <p>A code for the degree or educational rank that the 
     * credential specifies. May also apply to an Expertise 
     * type.</p>
     */
    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getCode() {
        return (QualifiedRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Expertise Role Type</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.QualifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>If Expertise or Credentials are included in the message, 
     * then Role Type Must Exist.</p>
     * 
     * <p>A code for the degree or educational rank that the 
     * credential specifies. May also apply to an Expertise 
     * type.</p>
     */
    public void setCode(QualifiedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Expertise Role Effective Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>If Expertise or Credentials are included in the message, 
     * then Role Effective Date Must Exist</p>
     * 
     * <p>The effective date of the provider expertise or 
     * credentials in the healthcare provider role.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Expertise Role Effective Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>If Expertise or Credentials are included in the message, 
     * then Role Effective Date Must Exist</p>
     * 
     * <p>The effective date of the provider expertise or 
     * credentials in the healthcare provider role.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Expertise Equivalency</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.equivalenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"equivalenceInd"})
    public Boolean getEquivalenceInd() {
        return this.equivalenceInd.getValue();
    }

    /**
     * <p>Business Name: Expertise Equivalency</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.equivalenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEquivalenceInd(Boolean equivalenceInd) {
        this.equivalenceInd.setValue(equivalenceInd);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.qualifiedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPerson_1Bean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.qualifiedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQualifiedPrincipalPerson(PrinicpalPerson_1Bean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }


    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.qualificationGrantingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public OrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.QualifiedEntity.qualificationGrantingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQualificationGrantingOrganization(OrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
    }


    /**
     * <p>Relationship: PRPM_MT301010CA.Subject2.registrationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/registrationEvent"})
    public RegistrationEventBean getSubjectOf1RegistrationEvent() {
        return this.subjectOf1RegistrationEvent;
    }

    /**
     * <p>Relationship: PRPM_MT301010CA.Subject2.registrationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1RegistrationEvent(RegistrationEventBean subjectOf1RegistrationEvent) {
        this.subjectOf1RegistrationEvent = subjectOf1RegistrationEvent;
    }


    /**
     * <p>Relationship: PRPM_MT301010CA.ResponsibleParty.privilege</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
    }


    /**
     * <p>Relationship: PRPM_MT301010CA.RoleChoice.relatedTo</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
    }

}
