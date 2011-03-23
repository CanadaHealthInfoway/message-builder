/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt020050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;



/**
 * <p>prescribed by</p>
 * 
 * <p>The person who ordered the office supply.</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the EHR.</p>
 * 
 * <p>The attribute is marked as "populated" as the prescriber 
 * must be known or null flavour specified.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.Author2"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private HealthcareWorkerBean assignedEntity;

    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
