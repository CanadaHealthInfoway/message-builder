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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.prpm_mt306011ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.merged.PrinicpalPerson_2Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.merged.ResponsiblePartyBean;
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
@Hl7PartTypeMapping({"PRPM_MT306011CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20111208L;
    private List<ResponsiblePartyBean> responsibleFor = new ArrayList<ResponsiblePartyBean>();
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_2Bean qualifiedPrincipalPerson;
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
    public Set<Identifier> getId() {
        return this.id.rawSet();
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
     * <p><p>Populated attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     * 
     * <p><p>If Expertise or Credentials are included in the 
     * message, then Role Type Must Exist.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getCode() {
        return (QualifiedRoleType) this.code.getValue();
    }
    public void setCode(QualifiedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Expertise or Credentials Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider expertise or 
     * credentials in the healthcare provider role.</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     * 
     * <p><p>If Expertise or Credentials are included in the 
     * message, then Role Effective Date Must Exist</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPerson_2Bean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }
    public void setQualifiedPrincipalPerson(PrinicpalPerson_2Bean qualifiedPrincipalPerson) {
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
