/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.merged.NotesBean;



/**
 * <p>Requests that the specified annotation be recorded 
 * against a particular record.</p>
 */
@Hl7PartTypeMapping({"COMT_IN301001CA"})
public class AddNoteToRecordRequestBean extends HL7MessageBean<TriggerEventBean<NotesBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
