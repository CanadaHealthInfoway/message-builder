/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.AssignedEntity1","POME_MT010040CA.AssignedEntity2","POME_MT010040CA.AssignedEntity3","PORR_MT050016CA.AssignedEntity"})
public class AssignedEntity3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private ST assignedOrganizationName = new STImpl();


    /**
     * <p>Formulary Owner Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the organization or facility responsible for the 
     * formulary.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps 
     * identify the circumstances in which the formulary 
     * applies.</p></p>
     * 
     * <p>Monograph Author Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the organization responsible for creating the monograph</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps the 
     * receiver evaluate the supplied information.</p></p>
     * 
     * <p>Monitoring Organization Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the organization responsible for the monitoring program</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps 
     * identify the program and understand its context. May also 
     * indicate who to send reports to.</p></p>
     * 
     * <p>D:Medication Document Author Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the organization responsible for creating the medication 
     * document.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps the 
     * receiver evaluate the supplied information.</p></p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization1"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization2"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization3"),
        @Hl7MapByPartType(name="representedOrganization", type="PORR_MT050016CA.Organization4")})
    public String getAssignedOrganizationName() {
        return this.assignedOrganizationName.getValue();
    }
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }

}
