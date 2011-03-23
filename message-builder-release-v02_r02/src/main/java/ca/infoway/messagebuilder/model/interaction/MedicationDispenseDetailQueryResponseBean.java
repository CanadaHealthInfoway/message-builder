/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060090ca.DispenseBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060360ca.GenericQueryParametersBean;



/**
 * <p>Returns detailed information about a single identified 
 * medication dispense event.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060220CA"})
public class MedicationDispenseDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<DispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
