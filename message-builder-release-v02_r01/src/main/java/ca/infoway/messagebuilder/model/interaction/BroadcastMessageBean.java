/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700212ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;



/**
 * <p>Sends a broadcast message to all or a subset of users of 
 * a given system; (Used for alerts regarding system outages or 
 * other urgent messages).</p>
 */
@Hl7PartTypeMapping({"COMT_IN500001CA"})
public class BroadcastMessageBean extends HL7MessageBean<TriggerEventBean<ca.infoway.messagebuilder.model.si.comt_mt500001ca.BroadcastMessageBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100615L;

}
