/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt020020ca.DispensePickupBean;



/**
 * <p>Indicates that a previously processed prescription has 
 * now been picked up.</p>
 */
@Hl7PartTypeMapping({"PORX_IN020070CA"})
public class DispensePickupNotificationBean extends HL7MessageBean<TriggerEventBean<DispensePickupBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
