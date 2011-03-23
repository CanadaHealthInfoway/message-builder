/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700236ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Indicates that the confidentiality code has been 
 * successfully revised for the requested identified item, 
 * group of items (identified by act type, medication, 
 * indication) or all items for a particular patient.</p>
 */
@Hl7PartTypeMapping({"COMT_IN400002CA"})
public class ChangeItemMaskingRequestAcceptedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
