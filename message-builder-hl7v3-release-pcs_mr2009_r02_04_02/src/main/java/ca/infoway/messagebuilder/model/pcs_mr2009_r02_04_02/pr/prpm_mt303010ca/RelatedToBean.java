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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt303010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPM_MT303010CA.RelatedTo"})
public class RelatedToBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private RoleChoice roleChoice;


    /**
     * <p>Business Name: Relationship Effective Date and Time</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.RelatedTo.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective date and time of the role relationships.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Relationship Effective Date and Time</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.RelatedTo.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective date and time of the role relationships.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: PRPM_MT303010CA.RelatedTo.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"roleChoice"})
    public RoleChoice getRoleChoice() {
        return this.roleChoice;
    }

    /**
     * <p>Relationship: PRPM_MT303010CA.RelatedTo.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRoleChoice(RoleChoice roleChoice) {
        this.roleChoice = roleChoice;
    }

    public AssignedEntityBean getRoleChoiceAsAssignedEntity() {
        return this.roleChoice instanceof AssignedEntityBean ? (AssignedEntityBean) this.roleChoice : null;
    }
    public boolean hasRoleChoiceAsAssignedEntity() {
        return (this.roleChoice instanceof AssignedEntityBean);
    }

    public QualifiedEntityBean getRoleChoiceAsQualifiedEntity() {
        return this.roleChoice instanceof QualifiedEntityBean ? (QualifiedEntityBean) this.roleChoice : null;
    }
    public boolean hasRoleChoiceAsQualifiedEntity() {
        return (this.roleChoice instanceof QualifiedEntityBean);
    }

    public HealthcareProviderBean getRoleChoiceAsHealthCareProvider() {
        return this.roleChoice instanceof HealthcareProviderBean ? (HealthcareProviderBean) this.roleChoice : null;
    }
    public boolean hasRoleChoiceAsHealthCareProvider() {
        return (this.roleChoice instanceof HealthcareProviderBean);
    }

}
