/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700222ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000300ca.HL7MessageBean;



/**
 * <p>Indicates that the keyword used to control patient access 
 * to a all or a portion of the patient's record has been 
 * successfully revised to the requested value.</p>
 */
@Hl7PartTypeMapping({"RCMR_IN010004CA"})
public class UpdateKeywordRequestAcceptedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
