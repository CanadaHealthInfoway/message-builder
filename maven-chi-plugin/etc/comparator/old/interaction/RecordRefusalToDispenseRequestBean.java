/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;



/**
 * <p>Requests that the specified ""refusal to fill"" note be 
 * recorded against the identified prescription. 
 */
@Hl7PartTypeMapping({"PORX_IN010060CA"})
public class RecordRefusalToDispenseRequestBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {


}
