/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPM_MT301010CA.RelatedTo"})
public class RelatedToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private RoleChoice roleChoice;


    /**
     * <p><p>Required</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
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