/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700226ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.PrescriptionDispenseResponseBean;



/**
 * <p>Indicates that the requested device dispense processing 
 * information has been successfully recorded in the patient's 
 * record.</p>
 */
@Hl7PartTypeMapping({"PORX_IN020340CA"})
public class RecordDeviceDispProcessingRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<PrescriptionDispenseResponseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
