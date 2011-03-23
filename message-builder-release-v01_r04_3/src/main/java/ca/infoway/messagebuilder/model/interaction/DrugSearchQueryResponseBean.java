/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pharmacy.pome_mt010090ca.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.pharmacy.pome_mt010100ca.MedicationBean;



/**
 * <p>Returns a list of basic identifying and descriptive 
 * information about one or more medications.</p>
 */
@Hl7PartTypeMapping({"POME_IN010080CA"})
public class DrugSearchQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
