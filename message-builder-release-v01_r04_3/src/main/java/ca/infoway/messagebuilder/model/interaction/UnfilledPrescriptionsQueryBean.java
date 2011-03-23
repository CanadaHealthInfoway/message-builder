/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.UnfilledPrescriptionQueryParametersBean;



/**
 * <p>Requests retrieval of basic information about all 
 * prescriptions provided to a single patient which have not 
 * yet been dispensed, optionally filtered by date and status.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060490CA"})
public class UnfilledPrescriptionsQueryBean extends HL7MessageBean<TriggerEventBean<UnfilledPrescriptionQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
