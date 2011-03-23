/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060280ca.DrugPrescriptionDetailQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt060340ca.PrescriptionBean;



/**
 * <p>Returns detailed information about a single identified 
 * medication prescription, including history of changes and 
 * all fulfilling dispense events.</p>
 */
@Hl7PartTypeMapping({"PORX_IN060180CA"})
public class MedPrescrWithHistAndDispensesQueryRespBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
