/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt102001ca.HL7MessageBean;



/**
 * <p>Requests an indication of the number and priority of 
 * outstanding interactions (if any) on the application's poll 
 * queue.</p>
 */
@Hl7PartTypeMapping({"MCCI_IN102002CA"})
public class RequestPollQueueStatusBean extends HL7MessageBean implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
