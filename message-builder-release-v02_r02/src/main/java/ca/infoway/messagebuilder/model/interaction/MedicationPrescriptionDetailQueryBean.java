/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060280ca.DrugPrescriptionDetailQueryParametersBean;



/**
 * <p>Requests retrieval of detailed information about a single 
 * medication prescription referenced by id, optionally 
 * including detailed dispense information.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060250CA"})
public class MedicationPrescriptionDetailQueryBean extends HL7MessageBean<TriggerEventBean<DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
