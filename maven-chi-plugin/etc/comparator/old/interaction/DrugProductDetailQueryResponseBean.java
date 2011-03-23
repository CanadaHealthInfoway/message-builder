/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.pome_mt010040ca.MedicationBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120008ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;



/**
 * <p>Returns detailed information about a single drug product. 
 */
@Hl7PartTypeMapping({"POME_IN010060CA"})
public class DrugProductDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationBean,GenericQueryParametersBean>> implements InteractionBean {


}
