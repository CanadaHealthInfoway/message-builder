/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.comt_mt300002ca.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.quqi_mt120000ca.TriggerEventBean;



@Hl7PartTypeMapping({"COMT_IN300202CA"})
public class PatientNoteQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<CommentBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110714L;

}
