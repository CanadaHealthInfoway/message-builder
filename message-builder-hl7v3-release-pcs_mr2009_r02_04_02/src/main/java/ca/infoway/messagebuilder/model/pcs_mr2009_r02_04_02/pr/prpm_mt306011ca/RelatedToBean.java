/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt306011ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.RelatedTo"})
public class RelatedToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private IVL<TS, Interval<Date>> relationshipEffectiveDateAndTime = new IVLImpl<TS, Interval<Date>>();
    private RoleChoice roleChoice;


    /**
     * <p>Relationship Effective Date and Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getRelationshipEffectiveDateAndTime() {
        return this.relationshipEffectiveDateAndTime.getValue();
    }
    public void setRelationshipEffectiveDateAndTime(Interval<Date> relationshipEffectiveDateAndTime) {
        this.relationshipEffectiveDateAndTime.setValue(relationshipEffectiveDateAndTime);
    }


    @Hl7XmlMapping({"roleChoice"})
    public RoleChoice getRoleChoice() {
        return this.roleChoice;
    }
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
