/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700220ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.ReferencedRecordBean;



/**
 * <p>Indicates that the requested medical condition record has 
 * been successfully added to the patient's record.</p>
 */
@Hl7PartTypeMapping({"REPC_IN000029CA"})
public class RecordMedicalConditionRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
