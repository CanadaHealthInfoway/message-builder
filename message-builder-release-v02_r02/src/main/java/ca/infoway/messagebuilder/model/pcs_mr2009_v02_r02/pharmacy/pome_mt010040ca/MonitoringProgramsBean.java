/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActMonitoringProtocolCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_v02_r02.pharmacy.merged.AssignedEntity3Bean;



/**
 * <p>Monitoring Programs</p>
 * 
 * <p><p>A system of additional business rules, documentation 
 * or reporting associated with a particular drug or group of 
 * drugs. These are typically instituted to detect potential 
 * abuse, or to monitor prescribing and/or dispensing patterns 
 * of a sensitive class of medications. Examples include 
 * triplicate programs, antibiotic monitoring programs, 
 * etc.</p></p>
 * 
 * <p><p>Allows association of additional business requirements 
 * with a particular drug</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.MonitoringProgram"})
public class MonitoringProgramsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV programType = new CVImpl();
    private ST programName = new STImpl();
    private AssignedEntity3Bean custodianAssignedEntity;


    /**
     * <p>Program Type</p>
     * 
     * <p><p>A coded value denoting a specific kind of monitoring 
     * program. For example, &quot;Drugs of potential abuse&quot;, 
     * &quot;Antibiotics&quot;, etc.</p></p>
     * 
     * <p><p>Used for classifying and sorting monitoring 
     * programs.</p><p>This is mandatory because, different program 
     * types have different business rules.</p></p>
     * 
     * <p><p>Used for classifying and sorting monitoring 
     * programs.</p><p>This is mandatory because, different program 
     * types have different business rules.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActMonitoringProtocolCode getProgramType() {
        return (ActMonitoringProtocolCode) this.programType.getValue();
    }
    public void setProgramType(ActMonitoringProtocolCode programType) {
        this.programType.setValue(programType);
    }


    /**
     * <p>Program Name</p>
     * 
     * <p><p>A user-friendly label assigned to the monitoring 
     * program.</p></p>
     * 
     * <p><p>Provides a provider-recognizable label for the 
     * program.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getProgramName() {
        return this.programName.getValue();
    }
    public void setProgramName(String programName) {
        this.programName.setValue(programName);
    }


    @Hl7XmlMapping({"custodian/assignedEntity"})
    public AssignedEntity3Bean getCustodianAssignedEntity() {
        return this.custodianAssignedEntity;
    }
    public void setCustodianAssignedEntity(AssignedEntity3Bean custodianAssignedEntity) {
        this.custodianAssignedEntity = custodianAssignedEntity;
    }

}