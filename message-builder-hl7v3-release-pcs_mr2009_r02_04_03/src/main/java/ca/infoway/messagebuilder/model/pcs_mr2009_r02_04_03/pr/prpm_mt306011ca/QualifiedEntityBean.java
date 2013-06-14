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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged.PrinicpalPerson_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged.PrivilegeBean;
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
@Hl7PartTypeMapping({"PRPM_MT306011CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20130613L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_2Bean qualifiedPrincipalPerson;
    private OrganizationBean qualificationGrantingOrganization;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();


    /**
     * <p>Business Name: Expertise or Credentials Role Identifier</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.QualifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>Unique identifier for the Expertise or Credential.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Expertise or Credentials Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.QualifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
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
     * <p>Business Name: Expertise or Credentials Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.QualifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
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
     * <p>Business Name: Expertise or Credentials Role Effective 
     * Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
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
     * <p>Business Name: Expertise or Credentials Role Effective 
     * Date</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
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
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.qualifiedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPerson_2Bean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.qualifiedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQualifiedPrincipalPerson(PrinicpalPerson_2Bean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.qualificationGrantingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public OrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.QualifiedEntity.qualificationGrantingOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQualificationGrantingOrganization(OrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
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
