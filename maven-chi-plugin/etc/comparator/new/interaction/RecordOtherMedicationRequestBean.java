/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.OtherMedicationBean;



/**
 * <p>Requests that a medication be recorded against the 
 * patient's record. 
 */
@Hl7PartTypeMapping({"PORX_IN040020CA"})
public class RecordOtherMedicationRequestBean extends HL7MessageBean<TriggerEventBean<OtherMedicationBean>> implements InteractionBean {


}
