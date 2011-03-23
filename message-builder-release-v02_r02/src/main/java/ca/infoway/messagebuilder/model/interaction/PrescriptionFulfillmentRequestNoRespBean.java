/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt010120ca.PrescriptionBean;



/**
 * <p>Requests that the specified facility dispense the 
 * medication prescription transmitted by this interaction and 
 * does not expect a response interaction</p>
 */
@Hl7PartTypeMapping({"PORX_IN010650CA"})
public class PrescriptionFulfillmentRequestNoRespBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
