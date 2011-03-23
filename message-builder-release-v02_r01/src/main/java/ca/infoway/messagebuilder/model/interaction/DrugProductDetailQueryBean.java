/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020002ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.GenericQueryParametersBean;



/**
 * <p>Requests retrieval of detailed information about a single 
 * drug product by product code.</p>
 */
@Hl7PartTypeMapping({"POME_IN010050CA"})
public class DrugProductDetailQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
