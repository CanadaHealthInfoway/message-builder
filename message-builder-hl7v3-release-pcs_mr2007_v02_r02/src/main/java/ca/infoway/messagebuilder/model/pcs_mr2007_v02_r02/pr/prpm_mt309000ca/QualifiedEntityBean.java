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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt309000ca;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Qualified Entity</p>
 * 
 * <p><p>This role describes specific qualifications that may 
 * be held the provider as a result of training or experience, 
 * but having no legal force. Example: a medical degree or 
 * diploma. The current model does not include role attributes 
 * such as name, addr and telecom because there are no known 
 * use cases in this domain where this role is contactable.</p></p>
 * 
 * <p><p>Roleclass required to provide additional information 
 * for the person responsible for providing healthcare 
 * services</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20110831L;
    private List<ResponsiblePartyBean> responsibleFor = new ArrayList<ResponsiblePartyBean>();
    private SET<II, Identifier> expertiseOrCredentialsRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV expertiseOrCredentialsRoleType = new CVImpl();
    private IVL<TS, Interval<Date>> expertiseOrCredentialsRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPersonBean qualifiedPrincipalPerson;
    private OrganizationBean qualificationGrantingOrganization;


    @Hl7XmlMapping({"responsibleFor"})
    public List<ResponsiblePartyBean> getResponsibleFor() {
        return this.responsibleFor;
    }


    /**
     * <p>Expertise or Credentials Role Identifier</p>
     * 
     * <p><p>Unique identifier for the Expertise or Credential.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getExpertiseOrCredentialsRoleIdentifier() {
        return this.expertiseOrCredentialsRoleIdentifier.rawSet();
    }


    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
    }


    /**
     * <p>Expertise or Credentials Role Type</p>
     * 
     * <p><p>A code for the degree or educational rank that the 
     * credential specifies. May also apply to an Expertise 
     * type.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     */
    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getExpertiseOrCredentialsRoleType() {
        return (QualifiedRoleType) this.expertiseOrCredentialsRoleType.getValue();
    }
    public void setExpertiseOrCredentialsRoleType(QualifiedRoleType expertiseOrCredentialsRoleType) {
        this.expertiseOrCredentialsRoleType.setValue(expertiseOrCredentialsRoleType);
    }


    /**
     * <p>Expertise or Credentials Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider expertise or 
     * credentials in the healthcare provider role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     * 
     * <p><p>If Expertise or Credentials are included in the 
     * message, then Role Effective Date Must Exist</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getExpertiseOrCredentialsRoleEffectiveDate() {
        return this.expertiseOrCredentialsRoleEffectiveDate.getValue();
    }
    public void setExpertiseOrCredentialsRoleEffectiveDate(Interval<Date> expertiseOrCredentialsRoleEffectiveDate) {
        this.expertiseOrCredentialsRoleEffectiveDate.setValue(expertiseOrCredentialsRoleEffectiveDate);
    }


    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPersonBean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }
    public void setQualifiedPrincipalPerson(PrinicpalPersonBean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }


    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public OrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }
    public void setQualificationGrantingOrganization(OrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
    }

}
