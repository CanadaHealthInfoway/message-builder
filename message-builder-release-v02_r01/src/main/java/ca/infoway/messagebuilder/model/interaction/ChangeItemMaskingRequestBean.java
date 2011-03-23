/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.si.comt_mt400001ca.MaskableRecordBean;



/**
 * <p>Requests that an identified item, group of items 
 * (identified by act type, medication, indication) or all 
 * items for a particular patient should have their 
 * confidentiality code changed to the specified value.</p>
 */
@Hl7PartTypeMapping({"COMT_IN400001CA"})
public class ChangeItemMaskingRequestBean extends HL7MessageBean<TriggerEventBean<MaskableRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
