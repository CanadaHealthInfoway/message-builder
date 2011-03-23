/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060240ca.UnfilledPrescriptionQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060300ca.PrescriptionBean;



/**
 * <p>Returns basic information about all prescriptions 
 * provided to a single patient which have not yet been 
 * dispensed, optionally filtered by date and status.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060500CA"})
public class UnfilledPrescriptionsQueryResponseBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,UnfilledPrescriptionQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
