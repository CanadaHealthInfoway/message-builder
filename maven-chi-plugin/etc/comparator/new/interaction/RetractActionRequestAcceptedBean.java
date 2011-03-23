/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700226ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;



/**
 * <p>Indicates that an identified ControlAct has been 
 * nullified as requested, essentially reversing the record of 
 * the event. 
 */
@Hl7PartTypeMapping({"COMT_IN600002CA"})
public class RetractActionRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {


}
