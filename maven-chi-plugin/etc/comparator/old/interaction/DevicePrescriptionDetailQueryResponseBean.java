/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.porx_mt060280ca.DrugPrescriptionDetailQueryParametersBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.PrescriptionBean;



/**
 * <p>Returns detailed information about a single device 
 * prescription referenced by id, optionally including detailed 
 * dispense information. 
 */
@Hl7PartTypeMapping({"PORX_IN060100CA"})
public class DevicePrescriptionDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {


}
