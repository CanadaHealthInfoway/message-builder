/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.mfmi_mt700726ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.cr.prpa_mt101102ca.IdentifiedEntityBean;



/**
 * <p>A person registry accepts a request to revise an existing 
 * record and responds back to the requesting application. The 
 * revised person record is sent in the payload.</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101205CA"})
public class PersonReviseEventAcceptBean extends HL7MessageBean<TriggerEventBean<IdentifiedEntityBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
