/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.iehr.repc_mt000012ca.ReportedReactionBean;



@Hl7PartTypeMapping({"REPC_IN000008CA"})
public class UpdateAdverseReactionRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<ReportedReactionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110407L;

}
