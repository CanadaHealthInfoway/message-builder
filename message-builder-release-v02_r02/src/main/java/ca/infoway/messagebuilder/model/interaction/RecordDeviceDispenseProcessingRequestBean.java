/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt020060ca.PrescriptionDispenseBean;



/**
 * <p>Requests that the device dispense processing (drug 
 * preparation, packaging and contraindication checking) for a 
 * particular quantity of devices against a prescription has 
 * been performed and the medication is awaiting pickup ne 
 * recorded.</p>
 */
@Hl7PartTypeMapping({"PORX_IN020060CA"})
public class RecordDeviceDispenseProcessingRequestBean extends HL7MessageBean<TriggerEventBean<PrescriptionDispenseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
