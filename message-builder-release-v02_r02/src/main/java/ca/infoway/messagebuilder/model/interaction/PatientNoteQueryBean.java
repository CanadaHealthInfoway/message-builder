/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.si.comt_mt300002ca.GenericQueryParametersBean;



/**
 * <p>Requests retrieval of the notes that have been recorded 
 * against a particular patient, potentially filtered by note 
 * type and/or date.</p>
 */
@Hl7PartTypeMapping({"COMT_IN300201CA"})
public class PatientNoteQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20100614L;

}
